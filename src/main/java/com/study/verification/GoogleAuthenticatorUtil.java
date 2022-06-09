package com.study.verification;
//Google  Authenticator
// 只从google出了双重身份验证后，就方便了大家，等同于有了google一个级别的安全，但是我们该怎么使用google authenticator (双重身份验证)，
//下面是java的算法，这样大家都可以得到根据key得到公共的秘钥了,直接复制，记得导入JAR包：
//commons-codec-1.8.jar
//junit-4.10.jar
//测试方法：
//1、执行测试代码中的“genSecret”方法，将生成一个KEY（用户为testuser），URL打开是一张二维码图片。
//2、在手机中下载“GOOGLE身份验证器”。
//3、在身份验证器中配置账户，输入账户名（第一步中的用户testuser）、密钥（第一步生成的KEY），选择基于时间。
//4、运行authcode方法将key和要测试的验证码带进去（codes，key），就可以知道是不是正确的秘钥了！返回值布尔
//main我就不写了大家~~因为这个可以当做util工具直接调用就行了

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Slf4j
public class GoogleAuthenticatorUtil {
    // 生成的key长度( Generate secret key length)
    public static final int SECRET_SIZE = 10;

    public static final String SEED = "g8GjEvTbW5oVSV7avLBdwIHqGlUYNzKFI7izOF8GwLDVKs2m0QN7vxRs2im5MDaNCWGmcD2rvcZx";

    // Java实现随机数算法
    public static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

    int window_size = 3; // default 3 - max 20 (from google docs)最多可偏移的时间

    public void setWindowSize(int s) {
        if (s >= 1 && s <= 200)
            window_size = s;
    }

    /**
     * 根据密钥和验证码进行身份认证
     * @param codes 验证码
     * @param savedSecret 密钥
     * @return
     */
    public static Boolean authcode(String codes, String savedSecret) {
        // 输入设备上显示的验证码。
        // 编辑并在验证码过期之前快速运行
        long code = Long.parseLong(codes);
        long t = System.currentTimeMillis();
        GoogleAuthenticatorUtil ga = new GoogleAuthenticatorUtil();
        // 1*30刷新一次验证码《30s内的验证码都可以使用》
        ga.setWindowSize(17);
        boolean r = ga.check_code(savedSecret, code, t);
        return r;
    }

    /**
     * 根据用户名和密码生成密钥。
     * @return
     */
    public static String genSecret() {
        String secret = GoogleAuthenticatorUtil.generateSecretKey();
        GoogleAuthenticatorUtil.getQRBarcodeURL("testuser",
                "testhost", secret);
        return secret;
    }

    /**
     * 获取符合要求的密钥
     * @return
     */
    public static String generateSecretKey() {
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstance(RANDOM_NUMBER_ALGORITHM);
            sr.setSeed(Base64.decodeBase64(SEED));
            byte[] buffer = sr.generateSeed(SECRET_SIZE);
            Base32 codec = new Base32();
            byte[] bEncodedKey = codec.encode(buffer);
            String encodedKey = new String(bEncodedKey);
            return encodedKey;
        }catch (NoSuchAlgorithmException e) {
            log.error("生成密钥时失败：【{}】", e.getMessage());
        }
        return null;
    }


    /**
     * 根据user和secret拼接出可以获取密钥的二维码的链接
     * @param user 用户名
     * @param host 用户地址
     * @param secret 密钥
     * @return
     */
    public static String getQRBarcodeURL(String user, String host, String secret) {
        String format = "https://www.google.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=otpauth://totp/%s@%s%%3Fsecret%%3D%s";
        return String.format(format, user, host, secret);
    }


    /**
     * 根据密钥和验证码和时间进行身份认证
     * @param secret 密钥
     * @param code 验证码
     * @param timeMsec
     * @return
     */
    public boolean check_code(String secret, long code, long timeMsec) {
        // Base32编码
        Base32 codec = new Base32();
        byte[] decodedKey = codec.decode(secret);
        // 将unix毫秒时间转换为30秒的“Windows”
        // 这符合TOTP规范（详见RFC）
        long t = (timeMsec / 1000L) / 30L;
        // Window用于检查最近生成的代码
        // 您可以使用此值来调整您愿意走多远
        for (int i = -window_size; i <= window_size; ++i) {
            long hash;
            try {
                hash = verify_code(decodedKey, t + i);
            }catch (Exception e) {
                // 是的，这是一种糟糕的形式，但是引发的异常非常罕见，这是一个静态配置问题
                e.printStackTrace();
                //throw new RuntimeException(e.getMessage());
                log.error("google出了双重身份验证验证时发生异常：【{}】。", e.getMessage());
                return false;
            }
            System.out.println("第【{" + i + "}】次，验证码为【{" + hash + "}】" );
            if (hash == code) {
                return true;
            }
        }
        // 验证代码无效.
        return false;
    }

    /**
     * 根据密钥和时间生成验证码
     * @param key 密钥
     * @param t 时间
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    private static int verify_code(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] data = new byte[8];
        long value = t;
        for (int i = 8; i-- > 0; value >>>= 8) {
            data[i] = (byte) value;
        }
        SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signKey);
        byte[] hash = mac.doFinal(data);
        int offset = hash[20 - 1] & 0xF;
        // 我们使用long，因为Java没有unsigned int。
        long truncatedHash = 0;
        for (int i = 0; i < 4; ++i) {
            truncatedHash <<= 8;
            //我们正在处理有符号字节：
            // 我们只保留第一个字节
            truncatedHash |= (hash[offset + i] & 0xFF);
        }
        truncatedHash &= 0x7FFFFFFF;
        truncatedHash %= 1000000;
        return (int) truncatedHash;
    }

    public static String generateCode(String secret) {
        long t = System.currentTimeMillis();
        // Base32编码
        Base32 codec = new Base32();
        byte[] decodedKey = codec.decode(secret);
        // 将unix毫秒时间转换为30秒的“Windows”
        // 这符合TOTP规范（详见RFC）
        t = (t / 1000L) / 30L;
        long hash = 0;
        try {
            hash = verify_code(decodedKey, t);
        } catch (Exception e) {
            log.error("生成验证码失败。");
        }
        return String.valueOf(hash);
    }

    // RTH5M4LCI63ZH43D
    public static void main(String[] args) {
        // 使用java中的算法生成密钥
/*        String secret = GoogleAuthenticatorUtil.generateSecretKey(); // 16位密钥，只能使用这个方法生成的。自己随便设置的不符合要求。
        if (secret == null) {
            log.error("获取密钥失败：系统问题。请重试");
        }
        log.info("密钥为：【{}】。", secret);*/


        // 根据密钥和验证码校验身份。
        String codes = "000000";
        String savedSecret = "RTH5M4LCI63ZH43D";
        long code = Long.parseLong(codes);
        long t = System.currentTimeMillis();
        GoogleAuthenticatorUtil ga = new GoogleAuthenticatorUtil();
        // 1*30刷新一次验证码《30s内的验证码都可以使用》
        ga.setWindowSize(200);
        boolean r = ga.check_code(savedSecret, code, t);
        if (r) {
            log.info("身份校验成功");
        } else {
            log.error("身份校验失败");
        }

    }
}




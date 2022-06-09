package com.study.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 密码加密解密处理工具类
 *
 */
/*
*
sany.318  密文：A20840BB3F5C73B0A406170D9085CEA9
zhanghq318  密文：9603A77D97EBA2C185D0F46FD7341DA0
zhinenghua  密文：5C1FD3D39B02730C3C158FF2A2FD9C0D
*
*/
public class PasswordUtil {
    public static void main(String[] args) {
        String[] list = {"liql19", "Huanmeng6374@"};
        for (String plainText: list) {
            String strDefaultKey = "sany###***";
            try {
                System.out.println("--开始--");
                System.out.println("密钥：" + strDefaultKey);
                String encode = encodeDESAndMD5(plainText, strDefaultKey);
                System.out.println("密码：" + encode);
                String decode = decodeDESAndMD5(encode, strDefaultKey);
                System.out.println("明文：" + decode);
                System.out.println("----结束----");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * key使用MD5加密取前8位String字符作为新的密钥，然后将message使用des加密。
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String encodeDESAndMD5(String message, String key) throws Exception {
        key = encodeMD5(key).substring(0, 8);
        return toHexString(encodeDES(message, key));
    }

    /**
     * key使用MD5加密取前8位String字符作为新的密钥，然后将message使用des解密。
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String decodeDESAndMD5(String message, String key) throws Exception {
        key = encodeMD5(key).substring(0, 8);
        return decodeDES(message, key);
    }

    /**
     * DES解密
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static String decodeDES(String message, String key) throws Exception {

        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        return new String(retByte);
    }

    /**
     * DES加密
     * @param message
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encodeDES(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(message.getBytes("UTF-8"));
    }

    /**
     * MD5加密
     * 使用org.apache.commons.codec.digest.DigestUtils加密
     * http://commons.apache.org/proper/commons-codec/download_codec.cgi
     * @param message
     * @return
     */
    public static String encodeMD5(String message) {
        return DigestUtils.md5Hex(message);
    }

    /**
     * String转byte数组
     * @param ss
     * @return
     */
    public static byte[] convertHexString(String ss) {
        byte digest[] = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }
        return digest;
    }

    /**
     * byte数组转String
     * @param b
     * @return
     */
    public static String toHexString(byte b[]) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2)
                plainText = "0" + plainText;
            hexString.append(plainText);
        }
        return hexString.toString();
    }


}

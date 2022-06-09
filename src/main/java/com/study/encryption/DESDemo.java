package com.study.encryption;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;

/*
*
sany.318  密文：A20840BB3F5C73B0A406170D9085CEA9
zhanghq318  密文：9603A77D97EBA2C185D0F46FD7341DA0
zhinenghua  密文：5C1FD3D39B02730C3C158FF2A2FD9C0D
*
*/
public class DESDemo {
    public static void main(String[] args) {
        String plainText = "sany.318";
        try {
            testDES(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void testDES(String plainText) throws Exception {
        // 明文
        System.out.println("明文：" + plainText);

        // 提供原始秘钥:长度64位,8字节
        String originKey = "sany###***";

        MessageDigest md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
        md.update(originKey.getBytes());// 计算md5函数
        /**
         * digest()最后确定返回md5 hash值，返回值为8位字符串。
         * 因为md5 hash值是16位的hex值，实际上就是8位的字符
         * BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
         * 一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
         */
        String hashedPwd = new BigInteger(1, md.digest()).toString(16);// 16是表示转换为16进制数
        hashedPwd = hashedPwd.substring(0,8);
        System.out.println(hashedPwd);


        // 根据给定的字节数组构建一个秘钥
        //SecretKeySpec key = new SecretKeySpec(originKey.getBytes(), "DES");
        SecretKeySpec key = new SecretKeySpec(hashedPwd.getBytes(), "DES");

        // 加密
        // 1.获取加密算法工具类
        Cipher cipher = Cipher.getInstance("DES");
        // 2.对工具类对象进行初始化,
        // mode:加密/解密模式
        // key:对原始秘钥处理之后的秘钥
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 3.用加密工具类对象对明文进行加密
        byte[] encipherByte = cipher.doFinal(plainText.getBytes());
        // 防止乱码，使用Base64编码
        String encode = Base64.encodeBase64String(encipherByte);
        System.out.println("加密：" + encode);

        // 解密
        // 2.对工具类对象进行初始化
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 3.用加密工具类对象对密文进行解密
        byte[] decode = Base64.decodeBase64(encode);
        byte[] decipherByte = cipher.doFinal(decode);
        String decipherText = new String(decipherByte);
        System.out.println("解密：" + decipherText);
    }
}

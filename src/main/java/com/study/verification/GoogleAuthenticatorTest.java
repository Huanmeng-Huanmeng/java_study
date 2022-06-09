package com.study.verification;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class GoogleAuthenticatorTest {
    public static void main(String[] args) {
        GoogleAuthenticatorTest test = new GoogleAuthenticatorTest();
        test.genSecretTest();
        test.verifyTest();
    }
    public void genSecretTest() {
        String secret = GoogleAuthenticatorUtil.generateSecretKey(); // 16位密钥，只能使用这个方法生成的。自己随便设置的不符合要求。
        String qrcode = GoogleAuthenticatorUtil.getQRBarcodeURL("ssv", "javastack.cn", secret);
        System.out.println("二维码地址:" + qrcode);
        System.out.println("密钥:" + secret);
    }

    public void verifyTest() {
        String verificationCode = "068401";
        String savedSecret = "BZNJPTPCENCLELES";
        GoogleAuthenticatorUtil ga = new GoogleAuthenticatorUtil();
        boolean r = ga.authcode(verificationCode, savedSecret);
        System.out.println("是否正确：" + r);
    }
}

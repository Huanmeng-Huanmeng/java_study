package com.study.utils;


public class ByteUtils {

    /**
     * hex字符串转byte数组
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte数组结果
     */
    public static byte[] hexToByteArray(String inHex){
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1){ // 奇数
            hexlen++;
            result = new byte[(hexlen/2)];
            inHex ="0" + inHex;
        }else { // 偶数
            result = new byte[(hexlen/2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2){
            result[j] = hexToByte(inHex.substring(i, i+2));
            j++;
        }
        return result;
    }

    /**
     * 两位16进制，转化为一位byte
     * Hex字符串转byte
     * @param inHex 待转换的Hex字符串
     * @return  转换后的byte
     */
    public static byte hexToByte(String inHex){
        return (byte)Integer.parseInt(inHex, 16);
    }

    /**
     * 字节数组转16进制
     * @param bytes 需要转换的byte数组
     * @param begin 起始位置
     * @param length 长度
     * @return  转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes, int begin, int length) {
        StringBuffer sb = new StringBuffer();
        int size = begin + length;
        for(int i = begin; i < size; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * 两位byte表示的16进制,转化为无符号的10进制
     * @param prefix 从左向右数的第1位byte
     * @param suffix 从左向右数的第2位byte
     * @return
     */
    public static int convertTwoBytesToUnsignedInt (byte prefix, byte suffix) {
        return (0xff00 & (prefix << 8)) | (0xff & suffix);
    }

    /**
     * 两位byte表示的16进制,转化为有符号的10进制
     * @param prefix 从左向右数的第1位byte
     * @param suffix 从左向右数的第2位byte
     * @return
     */
    public static int convertTwoBytesToSignedInt(byte prefix, byte suffix) {
        return (prefix << 8) | (0xff & suffix);
    }
}

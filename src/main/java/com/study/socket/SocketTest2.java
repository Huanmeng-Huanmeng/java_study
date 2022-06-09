package com.study.socket;

import com.study.utils.ByteUtils;
import org.slf4j.MDC;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTest2 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            socket = new Socket("192.168.11.11", 503);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            int[] positions = new int[]{36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,51,52,52,52,52};
            int size = positions.length;
            for (int j = 0; j < size; j++) {
                String place = Integer.toHexString(positions[j]);
                while (place.length() < 4) {
                    place = "0" + place;
                }

                byte[] bytes = new byte[1024];
                byte[][] realHead = new byte[1000][64];
                String ss = "a900" + place + "010101010101";
                outputStream.write(ByteUtils.hexToByteArray(ss));
                outputStream.flush();
                for (int i = 0; i < 1000; i++) {
                    try {
                        byte[] heads = new byte[2];
                        inputStream.read(heads);
                        String realHeadStr = "a900";
                        String readHeadStr = ByteUtils.bytesToHex(heads, 0, 2);
                        if (!realHeadStr.equals(readHeadStr)) {
                            i--;
                            continue;
                        }
                        inputStream.read(realHead[i]);
                        System.out.println(place + "-" + i + "完成");
                    } catch (IOException e) {
                    }
                }
                System.out.println(place + "完成");
            }

            //socket = new Socket("127.0.0.1", 502);
//            outputStream = socket.getOutputStream();
//            String ss = "000000000000010402bf0004";
//            while(true) {
//                ss = "000000000000010402c30004";
//                outputStream = socket.getOutputStream();
//                outputStream.write(hexToByteArray(ss));
//                outputStream.flush();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            result[j]=hexToByte(inHex.substring(i, i+2));
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
     * @return  转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes, int length) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}

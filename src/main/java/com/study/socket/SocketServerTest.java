package com.study.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {
    public static void main(String[] args) {
        ServerSocket socketServer = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            socketServer = new ServerSocket(502);

            //等待客户端的连接
            Socket socket = socketServer.accept();

            // 获取输入流
            inputStream = socket.getInputStream();
            analysisEventPackage(inputStream);



            outputStream = socket.getOutputStream();
            String ss = "0000000000000104";
//            printWriter = new PrintWriter(outputStream);
//            printWriter.println(new String(hexToByteArray(ss)));
//            printWriter.flush();
            outputStream.write(hexToByteArray(ss));
            outputStream.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void analysisEventPackage(InputStream inputStream) throws IOException {
        // 消息头部
        String requiredHead = "0000000000000104";
        byte[] realHead = new byte[8];
        inputStream.read(realHead);
        String realHeadStr = bytesToHex(realHead, 8);
        System.out.println("realHeadStr:=" + realHeadStr);
        if (!requiredHead.equals(realHeadStr)) {
            // log.error("tcp返回数据不符合要求");
            //continue;
            System.out.println(false);
        }
        System.out.println(true);

        // 消息数据长度
        byte[] realDataLength = new byte[2];
        inputStream.read(realDataLength);
        int dataLength = readInt(realDataLength[0], realDataLength[1]);
        System.out.println("dataLength:=" + dataLength);

        // 事件记录条数:
        // 每8位byte表示一条事件
        // 时间日期6个byte和故障码2个byte
        // 年，月，日，时，分，秒，故障码。
        int number = dataLength / 8;
        byte[] eventBytes = new byte[dataLength];
        inputStream.read(eventBytes);
        int[][] events = new int[number][7];
        for (int i = 0, j = 0; i < number; i++, j += 8) {
            events[i][0] = eventBytes[j] & 0xff;
            events[i][1] = eventBytes[j + 1] & 0xff;
            events[i][2] = eventBytes[j + 2] & 0xff;
            events[i][3] = eventBytes[j + 3] & 0xff;
            events[i][4] = eventBytes[j + 4] & 0xff;
            events[i][5] = eventBytes[j + 5] & 0xff;
            events[i][6] = readInt(eventBytes[j + 6], eventBytes[j + 7]);
            String temp = "20";
            System.out.println(i + "》" + (temp + String.format("%02d", events[i][0]))
                    + "-" + String.format("%02d", events[i][1]) + "-" + String.format("%02d", events[i][2])
                    + " " + String.format("%02d", events[i][3]) + ":" + String.format("%02d", events[i][4])
                    + ":" + String.format("%02d", events[i][5]) + "》" + events[i][6]);
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

    /**
     * 两位byte表示的16进制,转化为10进制
     * @param prefix 从左向右数的第1位byte
     * @param suffix 从左向右数的第2位byte
     * @return
     */
    public static int readInt(byte prefix, byte suffix) {
        return (0xff00 & (prefix << 8)) | (0xff & suffix);
    }
}

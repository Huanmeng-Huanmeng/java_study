package com.study.socket;

import java.io.*;
import java.net.Socket;

public class SocketTest {

    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //socket = new Socket("192.168.11.10", 502);
            socket = new Socket("127.0.0.1", 502);
            outputStream = socket.getOutputStream();
            String ss = "00000000000001040578150711110b2a040e15071111162c042d15071111162c04491507111117180fa01507111117260fa11507111119180fa615071111191803ef150711111918044c15071111191e0fa2150711111926040e15071111280304491507111128080fa215071111282f0fa015071111283a0fa1150711112a2a0fa6150711112a2a03ef150711112a2a044c150711112a300fa215071111332304491507111133290fa215071111351b0fa015071111351e03e915071111351e03ed15071111351e03f315071111351e040815071111351e040915071111351e042915071111351e042d15071111351e042f15071111351e0433150711113522040e1507111135240fa215071111352a043f15071111353503fc1507111136040fa2150711113b380fa01507111200070fa11507111203030fa615071112030303e915071112030303ed15071112030303f3150711120303040815071112030304091507111203030429150711120303042d150711120303042f1507111203030433150711120303044915071112030303ef150711120304040515071112030404061507111203090fa215071112030e043f150711120312040e150711120a0d0fa2150711120e270fa0150711120e2a0fa6150711120e2a03e9150711120e2a03ed150711120e2a03f3150711120e2a0408150711120e2a0409150711120e2a0429150711120e2a042d150711120e2a042f150711120e2a0433150711120e2a0449150711120e2a0405150711120e2b0406150711120e2f0fa2150711120e36043f150711120e38040e150712080d1a0449150712080d1f0fa2150712080e100fa0150712080e1b0fa115071208142a0fa615071208142903ef150712081429044c15071208142e0fa2150712082607042d150712082607044915071208270d0fa01507120827180fa1150712082a090fa6150712082a0903ef150712082a09044c150712082a0e0fa215071209303b042d15071209303b04491507120931330fa01507120932080fa21507120932360fa015071209323a03e915071209323a03ed15071209323a03f315071209323a040815071209323a040915071209323a042915071209323a042d15071209323a042f15071209323a043315071209323a044815071209323a04491507120933030fa215071209330a043f1507120a090f04491507120a09150fa21507120a200d04491507120a20120fa21507120a23050fa01507120a230703ff1507120a230d0fa21507120a23380fa01507120a233a03ff1507120a24040fa21507120a2911042d1507120a291104491507120a2a0e0fa01507120a2a110fa61507120a2a1103e91507120a2a1103ed1507120a2a1103f31507120a2a1104081507120a2a1104091507120a2a1104291507120a2a11042d1507120a2a11042f1507120a2a1104331507120a2a1104481507120a2a1104491507120a2a1103ef1507120a2a1104051507120a2a1204061507120a2a160fa21507120a2a1d043f1507120b16040fa21507120b170f0fa21507120b1e240fa21507120b1f200fa21507120b1f370fa21507120b372f04491507120b37350fa21507120e2b3804491507120e2c020fa21507120e3815042d1507120e381504491507120e381b0fa21507120f19220fa01507120f19310fa11507120f1a2e0fa61507120f1a2e0fa41507120f1a2e03e91507120f1a2e03ed1507120f1a2e03f31507120f1a2e04081507120f1a2e04091507120f1a2e04291507120f1a2e042d1507120f1a2e042f1507120f1a2e04331507120f1a2e04481507120f1a2e04491507120f1a2e04051507120f1a2f04061507120f1a340fa21507120f1a3a043f1507120f20090fa01507120f200c04011507120f20120fa21507120f20390fa01507120f210004011507120f21060fa21507120f2728042d1507120f27280449";
//            printWriter = new PrintWriter(outputStream);
//            printWriter.println(new String(hexToByteArray(ss)));
//            printWriter.flush();
            outputStream.write(hexToByteArray(ss));
            outputStream.flush();
            //outputStream.close();

            inputStream = socket.getInputStream();
            /*String requiredHead = "0000000000000104";
            byte[] realHead = new byte[16];
            inputStream.read(realHead);
            String realHeadStr = bytesToHex(realHead, 16);
            if (!requiredHead.equals(realHeadStr)) {
                // log.error("tcp返回数据不符合要求");
                //continue;
            }
            byte[] realDataLength = new byte[4];
            inputStream.read(realDataLength);
            int dataLength = 0;
            int multiplier = 1;
            for (int i = 3; i >= 0; i--) {
                dataLength += realDataLength[i] * multiplier;
                multiplier *= 16;
            }
            System.out.println(realDataLength);*/


            byte[] bytes = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int length = 0;
            while((length = inputStream.read(bytes)) != -1) {
                sb.append(bytesToHex(bytes, length));
            }

            System.out.println(sb);

            /*
            ss = "000000000000010402c30004";
            outputStream = socket.getOutputStream();
            outputStream.write(hexToByteArray(ss));
            outputStream.flush();
            //socket.shutdownOutput();
            inputStream = socket.getInputStream();
            while((length = inputStream.read(bytes)) != -1) {
                sb.append(bytesToHex(bytes, length));
            }
            */

            inputStream.close();
            //socket.close();

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

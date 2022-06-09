package com.study.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketDemo {
    public static void main(String[] args) {
        SocketDemo socketDemo = new SocketDemo();
        socketDemo.socketQuest();
    }
    void socketQuest() {
        Socket socket = null;
        OutputStream writer = null;
        //String conmand = "F1110,GF_001,DO1247,1,id,2022-02-20_12:12:12.122,CRC16";
        //String conmand = "F1110,GF_001,SquareArrayActivePowerSettingValue000,12,id,2022-02-20_12:12:12.122,CRC16";
        String conmand = "F1110,GF_001,DailyPowerGeneration001,14,id,2022-02-20_12:12:12.122,CRC16";
        try {
            socket = new Socket("localhost",3131);
            if (socket.isConnected()) {
                writer = socket.getOutputStream();
                writer.write(conmand.getBytes());
                socket.shutdownOutput();
                // 接收服务端发送的消息
                InputStream din = socket.getInputStream();
                byte[] outPut = new byte[4096];
                while (din.read(outPut) > 0) {
                    String result = new String(outPut);
                    System.out.println("服务端反回的的消息是：" + result);
                }
                din.close();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //socket.close();
            } else {
                System.out.println("socket未连接上");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void format() {
        String s = "2022-02-20_12:12.122";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        try {
            Date dateRev=formatter.parse(s);
            System.out.println(dateRev);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

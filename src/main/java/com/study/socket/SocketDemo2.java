package com.study.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo2 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream writer = null;
        String conmand = "F1110,GF_001,STOP,0/1,id,2022-02-20_12:12.122,CRC17";
        try {
            socket = new Socket("localhost",9999);
            if (socket.isConnected()) {
                writer = socket.getOutputStream();
                writer.write(conmand.getBytes());
                writer.flush();
                // 接收服务端发送的消息
                InputStream din = socket.getInputStream();
                byte[] outPut = new byte[4096];
                while (din.read(outPut) > 0) {
                    String result = new String(outPut);
                    System.out.println("服务端反回的的消息是：" + result);
                }
                din.close();
                socket.close();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("socket未连接上");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

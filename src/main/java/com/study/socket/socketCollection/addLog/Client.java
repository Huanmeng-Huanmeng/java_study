package com.study.socket.socketCollection.addLog;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
/*
* 通常大家会用以下方法进行进行结束：
* 两种方式：调用socket.close() 或者socket.shutdownOutput()方法。
*
* socket.close() 将socket关闭连接，那边如果有服务端给客户端反馈信息，此时客户端是收不到的。
* socket.shutdownOutput()是将输出流关闭，此时，如果服务端有信息返回，则客户端是可以正常接受的。
* */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.7", 9999);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = "你好，这是一个带标识的socket";
            bufferedWriter.write(str);
            //刷新输入流
            bufferedWriter.flush();

            bufferedWriter.write(str);
            //刷新输入流
            bufferedWriter.flush();
            //1.关闭socket的输出流
            //socket.shutdownOutput();

            //2.或者直接关闭socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.study.socket.socketCollection.addLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/*
第一个是accept方法，调用这个方法后，服务端一直阻塞在哪里，直到有客户端连接进来。
第二个是read方法，调用read方法也会进行阻塞。通过上面的示例我们可以发现，该问题发生在read方法中。
有朋友说是Client没有发送成功，其实不是的，我们可以通debug跟踪一下，发现客户端发送了，并且没有问题。
而是发生在服务端中，当服务端调用read方法后，他一直阻塞在哪里，因为客户端没有给他一个标识，告诉是否消息发送完成，
所以服务端还在一直等待接受客户端的数据，结果客户端此时已经关闭了，就是在服务端报错：java.net.SocketException: Connection reset
*/
public class ServerSocketTest {

    public static void main(String[] args) {
        try {
            //初始化服务端socket并且绑定9999端口
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(9999);
            //等待客户端的连接
            Socket socket = serverSocket.accept();
            //获取输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //读取一行数据
            String str = bufferedReader.readLine();
            //输出打印
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
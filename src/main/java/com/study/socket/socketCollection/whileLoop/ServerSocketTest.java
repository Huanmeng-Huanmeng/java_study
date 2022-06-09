package com.study.socket.socketCollection.whileLoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerSocketTest {
    public static void main(String[] args) {
        try {
            //初始化服务端socket并且绑定9999端口
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(9999);
            //等待客户端的连接
            Socket socket = serverSocket.accept();
            //获取输入流,并且指定统一的编码格式
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            //读取一行数据
            String str;
            //通过while循环不断读取信息，
            while ((str = bufferedReader.readLine()) != null) {
                //输出打印
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.study.socket.socketCollection.whileLoop;

import java.io.*;
import java.net.Socket;
/**
 * 一个while 循环
 * 客户端端在循环发送数据时候，每发送一行，添加一个换行标识“\n”标识，在告诉服务端我数据已经发送完成了。
 * 而服务端在读取客户数据时，通过while ((str = bufferedReader.readLine())!=null) 去判断是否读到了流的结尾，负责服务端将会一直阻塞在哪里，等待客户端的输入。
 *
 * 问题：
 * 由于socket通信是阻塞式的，假设我现在有A和B俩个客户端同时连接到服务端的上，
 * 因为只有当客户端A关闭后，客户端B才可以真正和服务端进行通信，这显然不是我们想要的。
 */
public class Client {
    public static void main(String[] args) {
        try {

            //初始化一个socket
            Socket socket = new Socket("127.0.0.1", 9999);
            //通过socket获取字符流
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //通过标准输入流获取字符流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            while (true) {
                String str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
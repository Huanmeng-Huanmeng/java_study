package com.study.socket.socketCollection.simple;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = "你好，这是一个简单的socket测试";
            bufferedWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

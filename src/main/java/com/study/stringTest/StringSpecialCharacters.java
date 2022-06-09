package com.study.stringTest;

import java.io.*;
import java.util.Date;

public class StringSpecialCharacters {
    public static void main(String[] args) {
        File srcFile = new File("doc/template.txt");
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder("");
        Date date = new Date();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile)));
            String str = null;
            int current = 0;
            while((str = bufferedReader.readLine()) != null)
            {
                int i = 0;
                int length = str.length();
                while(i < length) {
                    char temp = str.charAt(i);
                    if ((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z') || (temp >= '0' && temp <= '9')) {

                    } else {
                        System.out.println(i + ":不合法：" + temp + ";" + str);
                    }
                    i++;
                }
                current++;
            }
            System.out.println("文件成功生成" + date.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件成功失败" + date.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件成功失败" + date.toString());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.study.stringTest;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StringLineFeed {
    public static void main(String[] args) {
        StringLineFeed stringLineFeed = new StringLineFeed();
        StringBuilder stringBuilder = stringLineFeed.readFromFile("stringLineFeed/template.txt");
        StringBuilder stringBuilder1 = new StringBuilder("");
        int length = stringBuilder.length();
        for (int i = 0, j = 0; i <= length - 4; i += 4, j++) {
            stringBuilder1.append(j + " ").append(stringBuilder.substring(i, i + 4)).append("\n");
        }
        stringLineFeed.writeToFile("stringLineFeed/out.txt",stringBuilder1.toString());
    }

    public StringBuilder readFromFile(String fileName) {
        InputStream inputStream = null;
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            inputStream = new FileInputStream(fileName);
            byte [] bytes = new byte[1024];
            int length = 0;
            while((length = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes,0,length));
            }
            System.out.println(fileName + "文件读取完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder;
    }

    public void writeToFile(String fileName, String str) {
        File outFile =  new File(fileName);
        if (outFile.exists()) {
            outFile.delete();
        }
        try {
            outFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outFile);
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            System.out.println(fileName + "文件写入完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

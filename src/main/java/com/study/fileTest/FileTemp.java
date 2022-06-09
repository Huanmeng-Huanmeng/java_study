package com.study.fileTest;

import com.study.utils.ByteUtils;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
@Slf4j
public class FileTemp {
    public static void main(String[] args) throws Exception {
        String datFileName = "E:\\WorkSpace\\work\\变流器\\禾望变流器\\0422-禾望发送文档\\ascii码的\\PMSFC_001_Inv_2017-05-08_09-41-55(1).DAT";
        String cfgFileName = "E:\\WorkSpace\\work\\变流器\\禾望变流器\\0422-禾望发送文档\\ascii码的\\PMSFC_001_Inv_2017-05-08_09-41-55(1).CFG";
        String targetFileNamePrefix = "E:\\WorkSpace\\work\\变流器\\禾望变流器\\0422-禾望发送文档\\ascii码的\\PMSFC_001_Inv_2017-05-08_09-41-55(1)";


    }



    public static void fileReName(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.isFile()) {
                String fileGetName = file.getName();
                String temp = fileGetName;
                if (fileGetName.indexOf("(") != -1) {
                    temp = fileGetName.substring(0, fileGetName.indexOf("("));
                }
                if (fileGetName.indexOf("（") != -1) {
                    temp = fileGetName.substring(0, fileGetName.indexOf("（"));
                }
                temp = file.getParent() + temp;
                file.renameTo(new File(temp));
            } else {
                String[] list = file.list();
                for (String example: list) {
                    File file2 = new File(fileName + "/" + example);
                    String temp = example;
                    if (example.indexOf("(") != -1) {
                        temp = example.substring(0, example.indexOf("("));
                    }
                    if (example.indexOf("（") != -1) {
                        temp = example.substring(0, example.indexOf("（"));
                    }
                    temp = fileName + "/" + temp;
                    file2.renameTo(new File(temp));
                }
            }
        }
    }

    public void testFile() {
        String fileName = "par.txt";
        File file = new File(fileName);
        FileInputStream fileInputStream = null;
        StringBuilder sb = new StringBuilder("");
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int length = 0;
            while((length = fileInputStream.read(bytes)) != -1) {
                String temp = new String(bytes, 0, length, StandardCharsets.UTF_8);
                sb.append(temp);
            }
            System.out.println(sb);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String transform = sb.toString();
        StringBuilder result = new StringBuilder("");
        int length = transform.length();
        for(int i = 0; i < length; i += 4) {
            result.append(transform.substring(i, i + 4)).append("\n");
        }

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(result.toString().getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

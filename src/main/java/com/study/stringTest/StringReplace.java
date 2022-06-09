package com.study.stringTest;

import com.study.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Date;

@Slf4j
public class StringReplace {
    public static void main(String[] args) {
        formatGraphiqlSentence();
    }

    public static void formatGraphiqlSentence() {
        String srcFileNamePath = "C:\\Users\\root\\Desktop\\replace\\src";
        String outFileNamePath = "C:\\Users\\root\\Desktop\\replace\\out";
        File srcFilePath = new File(srcFileNamePath);
        if (srcFilePath.isFile()) {
            log.error("文件【{}】类型为文件，不为目录路径，不符合要求。", srcFileNamePath);
        }
        File[] files = srcFilePath.listFiles();
        int length = files.length;
        for (int i = 0; i < length; i++) {
            File file = files[i];
            formatGraphiqlSentenceFromOneFile(file, outFileNamePath);
        }

    }

    public static void formatGraphiqlSentenceFromOneFile(File file, String outFileNamePath) {
        String s = FileUtils.readFromFile(file.getAbsolutePath());
        String temp = s.replaceAll("\\\\n","\n");
        System.out.println(temp);
        String outFileName = outFileNamePath + File.separator + file.getName();
        File outFilePath = new File(outFileNamePath);
        File outFile = new File(outFileName);
        outFilePath.mkdirs();
        try {
            outFile.createNewFile();
        } catch (IOException e) {
            log.error("创建文件【{}】失败。", outFileName);
        }
        FileUtils.writeToFile(outFileName, temp, false);
        log.info("成功将文件【{}】解析为【{}】", file.getAbsolutePath(), outFile.getAbsolutePath());
    }

    public static void replaceChannelXml() {
        String replaced1 = "&&";
        String replaced2 = "##";
        String replaced3 = "%%";
        File srcFile = new File("doc/template.txt");
        File outFile = new File("doc/out.txt");
        if (outFile.exists()) {
            outFile.delete();
        }
        try {
            outFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("重新创建文件失败");
        }
        FileReader srcFileReader = null;
        FileWriter outFileWriter = null;
        StringBuilder stringBuilder = new StringBuilder("");
        StringBuilder outStringBuilder = new StringBuilder("");
        Date date = new Date();
        try {
            srcFileReader = new FileReader(srcFile);
            char[] buffer = new char[2048];
            int length = 0;
            while((length = srcFileReader.read(buffer)) != -1) {
                stringBuilder = stringBuilder.append(buffer,0,length);
            }

            System.out.println(stringBuilder);
            outStringBuilder = new StringBuilder(stringBuilder);

            outFileWriter = new FileWriter(outFile);
            /*for (int i = 1; i < 39; i++) {
                String replace = String.format("%03d", i);
                int tempInt = 540 + i;
                String temp = srcString.replaceAll(replaced, replace);
                temp = temp.replaceAll(replaced2, String.valueOf(tempInt));
                temp = temp.replaceAll(replaced3, "10.0.159.245");
                outStringBuilder.append(temp).append("\r\n");
            }*/
//            int i = 0;
//            int size = outStringBuilder.length();
//            while(i < outStringBuilder.length() - 1) {
//                if (outStringBuilder.charAt(i) == ' ') {
//                    if (outStringBuilder.charAt(i + 1) >= 'a' && outStringBuilder.charAt(i + 1) <= 'z') {
//                        String temp = outStringBuilder.charAt(i + 1) + "";
//                        temp = temp.toUpperCase();
//                        outStringBuilder.deleteCharAt(i).replace(i, i+1, temp);
//                    }
//                }
//                i++;
//            }
            outStringBuilder = new StringBuilder("");
            String srcString = stringBuilder.toString();
            int j = 2;
            int k = 0;
            int z = 0;
            for(int i = 0; i < 32; i++) {
                outStringBuilder.append(srcString.replaceAll(replaced1,j + "")
                        .replaceAll(replaced2, k + "")
                        .replaceAll(replaced3, z + "")).append("\n");
                j += 1;
                k += 1;
                z += 2;
            }
            outFileWriter.write(outStringBuilder.toString());
            outFileWriter.flush();
            System.out.println("文件成功生成" + date.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件成功失败" + date.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件成功失败" + date.toString());
        } finally {
            if (srcFileReader != null) {
                try {
                    srcFileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outFileWriter != null) {
                try {
                    outFileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

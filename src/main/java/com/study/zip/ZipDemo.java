package com.study.zip;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.study.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class ZipDemo {

    public static void main(String[] args) {
        testHopeWindConverter();
    }

    public static void testHopeWindConverter() {
        //String srcfilePathPrefix = "E:\\WorkSpace\\work\\变流器\\禾望变流器\\0422-禾望发送文档\\ascii码的\\PMSFC_003_Rec_2017-05-18_02-25-35";
        String targetFileName = "E:\\WorkSpace\\work\\变流器\\彭莫山部署\\变流器数据\\data\\cvt\\hopewind\\测试\\PMSFC_004_2022-05-21_14-19-47.zip";
        //zipCurrentPath(srcfilePathPrefix, targetFileName);
        String outFileDir = targetFileName.substring(0, targetFileName.lastIndexOf(".zip"));
        File unzip = unzip(targetFileName, outFileDir);
        String absolutePath = unzip.getAbsolutePath();
        File[] files = unzip.listFiles();
        if (files.length != 2) {
            log.error("压缩包【{}】中的文件不符合要求", targetFileName);
            return;
        }
        String cfgFileName = outFileDir + targetFileName.substring(targetFileName.lastIndexOf("\\"), targetFileName.lastIndexOf(".zip")) + ".CFG";
        String datFileName = outFileDir + targetFileName.substring(targetFileName.lastIndexOf("\\"), targetFileName.lastIndexOf(".zip")) + ".DAT";
        if (!(files[0].getAbsolutePath().equals(cfgFileName) && files[1].getAbsolutePath().equals(datFileName)) &&
                !(files[0].getAbsolutePath().equals(datFileName) && files[1].getAbsolutePath().equals(cfgFileName))) {
            log.error("压缩包【{}】中的文件不符合要求", targetFileName);
            return;
        }

        log.info("文件【{}】开始解析", cfgFileName);
        BufferedReader cfgBufferedReader = null;
        String[][] cfgDatas = new String[1][1];
        Integer length = null; // 通道数
        Float samplingRate = null; // 采样率
        Integer number = null; // 多少组数据
        try {
            cfgBufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(cfgFileName),"GB2312"));
            String readLine = null;

            // 第一行
            readLine = cfgBufferedReader.readLine();
            if (readLine == null) {
                log.error("文件【{}】中内容的格式不符合要求。", cfgFileName);
                return;
            }

            // 第二行
            readLine = cfgBufferedReader.readLine();
            if (readLine == null) {
                log.error("文件【{}】中内容的格式不符合要求。", cfgFileName);
                return;
            }
            String[] splitTemp = readLine.split(",");
            length = Integer.parseInt(splitTemp[0].trim());
            cfgDatas = new String[length][5];

            // 各通道详解
            for (int i = 0; i < length; i++) {
                readLine = cfgBufferedReader.readLine();
                if (readLine == null) {
                    log.error("文件【{}】中内容的格式不符合要求。", cfgFileName);
                    return;
                }
                String[] splitData = readLine.split(",");

                cfgDatas[i] = new String[5];
                cfgDatas[i][0] = splitData[0].trim();
                cfgDatas[i][1] = splitData[1].trim();
                cfgDatas[i][2] = splitData[4].trim();
                cfgDatas[i][3] = splitData[5].trim();
                cfgDatas[i][4] = splitData[6].trim();
            }

            // 系统电流电压的频率
            readLine = cfgBufferedReader.readLine();
            if (readLine == null) {
                log.error("文件【{}】中内容的格式不符合要求。", cfgFileName);
                return;
            }

            // 有几个采样频率
            readLine = cfgBufferedReader.readLine();
            if (readLine == null) {
                log.error("文件【{}】中内容的格式不符合要求。", cfgFileName);
                return;
            }
            int i = Integer.parseInt(readLine.trim());
            if (i != 1) {
                log.error("文件【{}】中内容的格式不符合要求。", cfgFileName);
                return;
            }

            // 在采样率为5000Hz下采了6300个点
            readLine = cfgBufferedReader.readLine();
            if (readLine == null) {
                log.error("文件【{}】中内容的格式不符合要求。", cfgFileName);
                return;
            }
            splitTemp = readLine.split(",");
            if (splitTemp.length != 2) {
                log.error("文件【{}】中内容的格式不符合要求。", cfgFileName);
                return;
            }

            samplingRate = Float.parseFloat(splitTemp[0].trim());
            number = Integer.parseInt(splitTemp[1].trim());

        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (cfgBufferedReader != null) {
                try {
                    cfgBufferedReader.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            log.info("文件【{}】解析完毕", cfgFileName);
        }



        log.info("通道数为：【{}】", length);
        log.info("采样频率为：【{}】", samplingRate);
        log.info("数组组数：【{}】", number);



        int realLength = length + 2;
        int [][] datDatas = new int[number][realLength];
        log.info("文件【{}】开始解析", datFileName);
        BufferedReader datBufferedReader = null;
        try {
            datBufferedReader = new BufferedReader(new FileReader(datFileName));
            String readLine = null;
            for (int i = 0; i < number; i++) {
                readLine = datBufferedReader.readLine();
                if (readLine == null) {
                    log.error("文件【{}】中内容的格式不符合要求。", datFileName);
                    return;
                }
                datDatas[i] = new int[realLength];
                String[] splitTemp = readLine.split(",");
                if (splitTemp.length != realLength) {
                    log.error("文件【{}】中内容的格式不符合要求。", datFileName);
                    return;
                }
                for (int j = 0; j < realLength; j++) {
                    datDatas[i][j] = Integer.parseInt(splitTemp[j]);
                }
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (datBufferedReader != null) {
                try {
                    datBufferedReader.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            log.info("文件【{}】解析完毕", datFileName);
        }

        // 生成csv文件
        String csvFileName = outFileDir + targetFileName.substring(targetFileName.lastIndexOf("\\"), targetFileName.lastIndexOf(".zip")) + "_" + samplingRate + ".csv";

        // 拼装csv表头
        StringBuilder csvTitle = new StringBuilder("序号");
        String name = null;
        for (int i = 0; i < length; i++) {
            name = cfgDatas[i][1].trim();
            if (!cfgDatas[i][2].trim().isEmpty()) {
                name = name + "(" + cfgDatas[i][2].trim() + ")";
            }
            csvTitle.append(",").append(name);
        }
        FileUtils.createCSV(csvFileName, csvTitle.toString());

        StringBuilder csvContent = new StringBuilder();
        for (int i = 0; i < number; i++) {
            csvContent.append(i);
            for (int j = 2; j < realLength; j++) {
                float fCoefA = Float.parseFloat(cfgDatas[j - 2][3].trim()); // 变换因子A
                float fCoefB = Float.parseFloat(cfgDatas[j - 2][4].trim()); // 变换因子B
                float realData = fCoefA*datDatas[i][j] + fCoefB;
                csvContent.append(",").append(realData);
            }
            csvContent.append("\n");
        }
        // 拼装数据
        FileUtils.writeToFile(csvFileName, csvContent.toString(), true);
        log.info("csv文件【{}】创建成功。", csvFileName);
    }
    /**
     * 将此目录下的所有文件目录打包到此目录.zip压缩包中
     * @param srcfilePathPrefix 文件目录
     */
    public static void zipCurrentPath(String srcfilePathPrefix) {
        //将aaa目录下的所有文件目录打包到d:/aaa.zip
        //ZipUtil.zip("d:/aaa");
        File zip = ZipUtil.zip(srcfilePathPrefix);
        System.out.println(zip.exists());
    }

    public static void zipCurrentPath(String srcfilePathPrefix, String targetFileName) {
/*        //将aaa目录下的所有文件目录打包到d:/bbb/目录下的aaa.zip文件中
        // 此处第二个参数必须为文件，不能为目录
        ZipUtil.zip("d:/aaa", "d:/bbb/aaa.zip");
        //将aaa目录下的所有文件目录打包到d:/bbb/目录下的ccc.zip文件中
        ZipUtil.zip("d:/aaa", "d:/bbb/ccc.zip");*/
        ZipUtil.zip(srcfilePathPrefix, targetFileName);
    }

    public static void zipCurrentPath(String srcfilePathPrefix, String targetFileName, boolean withSrcDir) {
        // 可选是否包含被打包的目录。比如我们打包一个照片的目录，打开这个压缩包有可能是带目录的，也有可能是打开压缩包直接看到的是文件。
        ZipUtil.zip(srcfilePathPrefix, targetFileName, withSrcDir);
    }

    public static void zipRandomFile(String targetFileName, boolean withSrcDir, String[] srcfilePathPrefixs) {
        // 多文件或目录压缩。可以选择多个文件或目录一起打成zip包。
        ZipUtil.zip(FileUtil.file("d:/bbb/ccc.zip"), false,
                FileUtil.file("d:/test1/file1.txt"),
                FileUtil.file("d:/test1/file2.txt"),
                FileUtil.file("d:/test2/file1.txt"),
                FileUtil.file("d:/test2/file2.txt")
        );
    }

    /**
     * 解压，默认UTF-8编码
     *
     * @param zipFilePath 压缩文件的路径
     * @param outFileDir  解压到的目录
     * @return 解压的目录
     * @throws UtilException IO异常
     */
    public static File unzip(String zipFilePath, String outFileDir) {
        //将test.zip解压到e:\\aaa目录下，返回解压到的目录
        //File unzip = ZipUtil.unzip("E:\\aaa\\test.zip", "e:\\aaa");
        File unzip = ZipUtil.unzip(zipFilePath, outFileDir);
        return unzip;
    }
}

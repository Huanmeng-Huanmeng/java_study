package com.study.zip;

import lombok.extern.slf4j.Slf4j;
import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

@Slf4j
public class SoftwareZip {
    public static void main(String[] args) {
        String filePrefix = "D:\\summary";
        un7z(filePrefix);
    }

    /**
     * 将某个文件夹下的所有7z文件（子文件和孙子文件和重孙子文件）解压出来
     * @param filePrefix 某个文件夹
     */
    public static void un7z(String filePrefix) {
        File file = new File(filePrefix);
        if (file.isFile()) {
            log.error("文件【{}】不为文件夹。", filePrefix);
            return;
        }
        File[] files = file.listFiles();
/*        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".7z")) {
                    return true;
                }
                return false;
            }
        });*/
        for (File fileExample: files) {
            if (fileExample.isDirectory()) {
                un7z(fileExample.getAbsolutePath());
            } else {
                String fileAbsolutePath = fileExample.getAbsolutePath();
                if (fileAbsolutePath.endsWith(".7z")) {
                    log.info("开始解压文件【{}】。", fileAbsolutePath);
                    String strTemp = fileExample.getName();
                    String password = strTemp.substring(0, strTemp.length() - 3);
                    try {
                        un7z(fileAbsolutePath, fileExample.getParentFile().getAbsolutePath(), password);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("解密文件【{}】时出错。原因为：【{}】。", fileAbsolutePath, e.getMessage());
                    }
                    log.info("完成解压文件【{}】。", fileAbsolutePath);
                }
            }
        }
    }



    /**
     *
     * @Description (解压7z)
     * @param file7zPath(7z文件路径)
     * @param outPutPath(解压路径)
     * @param passWord(文件密码.没有可随便写,或空)
     * @return
     * @throws Exception
     */
    public static int un7z(String file7zPath, final String outPutPath, String passWord) throws Exception {
        IInArchive archive;
        RandomAccessFile randomAccessFile;
        randomAccessFile = new RandomAccessFile(file7zPath, "r");
        archive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile), passWord);
        int numberOfItems = archive.getNumberOfItems();
        ISimpleInArchive simpleInArchive = archive.getSimpleInterface();
        for (final ISimpleInArchiveItem item : simpleInArchive.getArchiveItems()) {
            final int[] hash = new int[] { 0 };
            if (!item.isFolder()) {
                ExtractOperationResult result;
                final long[] sizeArray = new long[1];
                result = item.extractSlow(new ISequentialOutStream() {
                    @Override
                    public int write(byte[] data) throws SevenZipException {
                        try {
                            String str = item.getPath();
                            if (str.lastIndexOf(File.separator) != -1) {
                                str = str.substring(0, str.lastIndexOf(File.separator));
                                File file = new File(outPutPath + File.separator + str + File.separator);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                            }
                            File file1 = new File(outPutPath + File.separator + item.getPath());
                            IOUtils.write(data, new FileOutputStream(file1, true));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        hash[0] ^= Arrays.hashCode(data); // Consume data
                        sizeArray[0] += data.length;
                        return data.length; // Return amount of consumed
                    }
                }, passWord);
                if (result == ExtractOperationResult.OK) {
                    log.error("解压成功...." + String.format("%9X | %10s | %s", hash[0], sizeArray[0], item.getPath()));
                } else {
                    log.error("解压失败：密码错误或者其他错误...." + result);
                }
            }
        }
        archive.close();
        randomAccessFile.close();

        return numberOfItems;
    }
}

package com.study.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;

@Slf4j
public class FileUtils {
    /**
     * 根据csv文件名称创建csv文件，并写入表头字段。
     * @param csvName csv文件名称
     * @return 操作是否成功。true:操作成功。 false:操作失败
     */
    public static boolean createCSV(String csvName, String title) {
        boolean result = false;
        File csvfile = new File(csvName);
        if (!csvfile.exists()) {
            try {
                File parentFile = csvfile.getParentFile();
                if(!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                result = csvfile.createNewFile();
                if (!result) {
                    log.error("创建文件【{}】失败。", csvName);
                }
            } catch (IOException e) {
                log.error("创建文件【{}】失败。", csvName);
            }
        }

        // 新建csv文件时写入表头字段。
        byte[] bom = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        FileOutputStream csvFileOutputStream = null;
        try {
            csvFileOutputStream = new FileOutputStream(csvfile);
            // 解决utf-8 导出到csv文件时出现乱码的问题
            csvFileOutputStream.write(bom);
            csvFileOutputStream.write(title.getBytes());
            csvFileOutputStream.write("\n".getBytes());
            csvFileOutputStream.flush();
        } catch (IOException e) {
            log.error("创建{}文件失败：{}", csvName, e);
            if (csvfile.exists()) {
                csvfile.delete();
            }
            return false;
        } finally {
            if (csvFileOutputStream != null) {
                try {
                    csvFileOutputStream.close();
                } catch (IOException e) {
                    log.error("关闭csvFileOutputStream失败：{}", e);

                    if (csvfile.exists()) {
                        csvfile.delete();
                    }
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 将str追加到文件名为fileName的文件中
     * @param fileName 文件名
     * @param str 要写入的内容
     * @param append 是否将内容追加到文件中
     * @return 操作是否成功。true:操作成功。 false:操作失败
     */
    public static boolean writeToFile(String fileName, String str, Boolean append) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName, append);
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            log.error("将文本写入{}文件失败：{}", fileName, e);
            return false;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("关闭{}文件输出流失败：{}", fileName, e);
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 将str追加到文件名为fileName的文件中
     * @param fileName 文件名
     * @param str 要写入的内容
     * @return 操作是否成功。true:操作成功。 false:操作失败
     */
    public static boolean writeToFileIfNotExist(String fileName, String str, boolean isAdd) {
        boolean flag = false;
        File file = new File(fileName);
        File fileParent = file.getParentFile();
        if (!fileParent.exists()) {
            flag = fileParent.mkdirs();
            if (!flag) {
                log.error("创建【{}】文件失败。", fileParent.getAbsolutePath());
                return flag;
            }
        }
        if (!file.exists()) {
            try {
                flag = file.createNewFile();
                if (!flag) {
                    log.error("创建【{}】文件失败。", file.getAbsolutePath());
                    return flag;
                }
            } catch (IOException e) {
                log.error("创建【{}】文件失败：{}", fileName, e);
                return false;
            }
        }

        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName, isAdd);
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            log.error("将文本【{}】写入【{}】文件失败：{}", str, fileName, e);
            return false;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("关闭【{}】文件输出流失败：{}", fileName, e);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 读取并以String的形式返回文件名为fileName的文件中的内容
     * @param fileName 文件名
     * @return 文件中的内容
     */
    public static String readFromFile(String fileName) {
        InputStream inputStream = null;
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            inputStream = new FileInputStream(fileName);
            byte [] bytes = new byte[1024];
            int length = 0;
            while((length = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes,0,length));
            }
        } catch (FileNotFoundException e) {
            log.error("从{}文件中读取内容失败：{}", fileName, e);
            stringBuilder = new StringBuilder("");
        } catch (IOException e) {
            log.error("从{}文件中读取内容失败：{}", fileName, e);
            stringBuilder = new StringBuilder("");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("从{}文件中读取内容失败：{}", fileName, e);
                    stringBuilder = new StringBuilder("");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 将str追加到文件名为fileName的文件中
     * @param fileName 文件名
     * @param str 要写入的内容
     * @return 操作是否成功。true:操作成功。 false:操作失败
     */
    public static boolean writeToFileLock(String fileName, String str, Boolean append) {
        RandomAccessFile randomAccessFile = null;
        FileChannel channel = null;
        FileLock lock = null;
        try {
            randomAccessFile = new RandomAccessFile(fileName, "rw");
            channel = randomAccessFile.getChannel();

            while (null == lock) {
                try {
                    lock = channel.lock();
                } catch (Exception e) {
                    log.error("获取{}文件锁失败{}", fileName, e);
                    return false;
                }
            }
            randomAccessFile.writeUTF(str);
        } catch (IOException e) {
            log.error("将文本写入{}文件失败：{}", fileName, e);
            return false;
        } finally {
            if (lock != null) {
                try {
                    lock.release();
                } catch (IOException e) {
                    log.error("释放{}文件锁失败{}", fileName, e);
                    return false;
                }
            }
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    log.error("关闭文件{}对应的channel失败{}", fileName, e);
                    return false;
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    log.error("关闭文件{}对应的randomAccessFile失败{}", fileName, e);
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 读取并以String的形式返回文件名为fileName的文件中的内容
     * @param fileName 文件名
     * @return 文件中的内容
     */
    public static String readFromFileLock(String fileName) {
        String result = "";
        RandomAccessFile randomAccessFile = null;
        FileChannel channel = null;
        FileLock lock = null;
        try {
            randomAccessFile = new RandomAccessFile(fileName, "rw");
            channel = randomAccessFile.getChannel();

            while (null == lock) {
                try {
                    lock = channel.lock();
                } catch (Exception e) {
                    log.error("获取{}文件锁失败{}", fileName, e);
                    return result;
                }
            }
            result = randomAccessFile.readUTF();
            lock.release();
        } catch (IOException e) {
            log.error("将文本写入{}文件失败：{}", fileName, e);
            return result;
        } finally {
                if (lock != null) {
                    try {
                        lock.release();
                    } catch (IOException e) {
                        log.error("释放{}文件锁失败{}", fileName, e);
                        return result;
                    }
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        log.error("关闭文件{}对应的channel失败{}", fileName, e);
                        return result;
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                        log.error("关闭文件{}对应的randomAccessFile失败{}", fileName, e);
                        return result;
                    }
                }
            }
        return result;
    }
}

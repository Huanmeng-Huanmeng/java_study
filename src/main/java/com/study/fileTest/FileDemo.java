package com.study.fileTest;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * File.delete()
 * 删除文件或者目录，但是如果是目录，则这个目录必须是空的才能被删除。
 * 也就是说，要删一个非空文件夹，直接调delete方法是无法达到目的的
 *
 * */
@Slf4j
public class FileDemo {
    public static void main(String[] args) {
        deleteIdeaFile();
    }


    /**
     * 删除文件夹下的特定内容
     *  1.文件名后缀为.iml
     *  2.文件夹名为target
     */
    public static void deleteIdeaFile() {
        String filePath = "E:\\StudySpace\\mybatis-course";
        File file = new File(filePath);
        if (!file.exists()) {
            log.info("当前文件夹【{}】--【{}】不存在", file.getAbsolutePath(), file.getPath());
            return;
        }
        boolean flag = deleteFile(file);
        while(!flag) {
            deleteFile(file);
        }
        log.info("删除文件夹下的特定内容【成功】");
    }

    /**
     * @param file 删除文件夹下的特定内容
     *             1.文件名后缀为.iml
     *             2.文件夹名为target
     */
    public static boolean deleteFile(File file) {
        boolean result = true;
        if (file.isFile()) {
            if (file.getName().endsWith(".iml")) {
                boolean flag = file.delete();
                if (flag) {
                    log.info("删除文件【{}】成功", file.getAbsolutePath());
                }
                return flag;
            }
        } else {
            if (file.getName().equals("target") || file.getName().equals(".idea")) {
                boolean flag = deleteDirFile(file);
                if (flag) {
                    log.info("删除文件夹【{}】成功", file.getAbsolutePath());
                }
                return flag;
            }
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                result = deleteFile(files[i]);
                if (!result) {
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 先根遍历序递归删除文件夹
     *
     * @param dirFile 要被删除的文件或者目录
     * @return 删除成功返回true, 否则返回false
     */
    public static boolean deleteDirFile(File dirFile) {
        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return true;
        }
        if (dirFile.isFile()) {
            return dirFile.delete();
        } else {
            for (File file : dirFile.listFiles()) {
                boolean flag = deleteDirFile(file);
                if (!flag) {
                    return flag;
                }
            }
        }
        return dirFile.delete();
    }
}

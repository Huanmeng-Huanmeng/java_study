package com.study;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;


@Slf4j
public class Test {
    public static void main(String[] args) {
        testStringIndexOf();
    }
    public static void testStringIndexOf() {
        String comment = "【字段名字：主键】、、【维护人：人人】、、【使用对象：想想】";
        String[] split = comment.split("、、");
        String fieldName = split[0];
        String maintainer = split[1];
        String useObject = split[2];
        int begin = fieldName.indexOf("【字段名字：");
        maintainer.indexOf("人人");
        useObject.indexOf("想想");
        int end = fieldName.lastIndexOf("】");
    }

    public static void testReadFile() {
        String fileName = "E:\\WorkSpace\\work\\变流器\\禾望变流器\\0422-禾望发送文档\\PMSFC_003_Rec_2017-05-18_02-25-35\\PMSFC_003_Rec_2017-05-18_02-25-35.CFG";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "GB2312"));
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                System.out.println("--" + readLine + "--");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testList() {
        List<String> strings = new ArrayList<>();
        String first = null;
        strings.add(first);
        System.out.println(strings.size());
        first = strings.get(0);
        System.out.println(first);
    }

    public static void testObject() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("调用函数前：stringBuilder=【" + stringBuilder + "】");
        updateObject(stringBuilder);
        System.out.println("调用函数后：stringBuilder=【" + stringBuilder + "】");
    }

    public static void updateObject(StringBuilder stringBuilder) {
        stringBuilder.append("修改引用指向的对象的值"); // 引用传递
        stringBuilder = new StringBuilder("直接修改引用的指向对象"); // 值传递
    }

    /**
     * 字符串，正则表达式匹配
     */
    public static void testStringMatch() {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String test = scanner.nextLine();
            System.out.print("(test.matches(\"R([0-9]*)\") || test.matches(\"([0-9]*)\")):匹配结果");
            System.out.println((test.matches("R([0-9]*)") || test.matches("([0-9]*)")));
        }

    }

    public static void threadPoolTaskExecutor() {
        boolean result = true;
        long begin = System.currentTimeMillis();
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPoolTaskExecutor.setCorePoolSize(5);
        // 设置最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(10);
        // 设置工作队列大小
        threadPoolTaskExecutor.setQueueCapacity(2000);
        // 设置线程名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("threadPoolTaskExecutor-->");
        // 设置拒绝策略.当工作队列已满,线程数为最大线程数的时候,接收新任务抛出RejectedExecutionException异常
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 初始化线程池
        threadPoolTaskExecutor.initialize();
//        CountDownLatch countDownLatch = new CountDownLatch(2);
        Future<Boolean> submit = threadPoolTaskExecutor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Thread.sleep(10000);
//                countDownLatch.countDown();
                return true;
            }
        });
        Future<Boolean> submit2 = threadPoolTaskExecutor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Thread.sleep(10000);
//                countDownLatch.countDown();
                return true;
            }
        });

//        try {
//            countDownLatch.wait();
//            System.out.println("等待结束");
//        } catch (InterruptedException e) {
//            System.out.println("出错");
//        }

        try {
            result = submit.get();
            System.out.println("submit.get()" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            result = submit2.get();
            System.out.println("submit2.get()" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("多线程运行结束,花费时间为：" + (end - begin) + "s");
    }

    public static void testUUID() {
        System.out.println(UUID.randomUUID().toString());
    }
    // 判断文件的父文件是否存在
    public static void testParentFile() {
        String fileName = "D:/ss.txt";
        File file = new File(fileName);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            System.out.println("开始----parentFile.mkdirs()");
            parentFile.mkdirs();
            System.out.println("结束----parentFile.mkdirs()");
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("创建" + fileName);
        }
    }

    public static void ss() {
        float ff = 0;
        System.out.println((ff > 0));
    }
    /**
     * List过滤
     */
    public static void fliterStream() {
        float a1 = 0f;
        float a2 = 0.5f;
        List<SpeedPower> allSpeedPowerTemp = new ArrayList<>();
        List<SpeedPower> allSpeedPower = new ArrayList<>();
        allSpeedPowerTemp.add(new SpeedPower(0));
        allSpeedPowerTemp.add(new SpeedPower(0));
        allSpeedPowerTemp.add(new SpeedPower(0));
        allSpeedPowerTemp.add(new SpeedPower(0.5f));
        allSpeedPowerTemp.add(new SpeedPower(0.5f));
        allSpeedPowerTemp.add(new SpeedPower(0.5f));
        allSpeedPowerTemp.add(new SpeedPower(1.0f));
        allSpeedPowerTemp.add(new SpeedPower(1.6f));
        allSpeedPowerTemp.add(new SpeedPower(1.7f));
        allSpeedPowerTemp.add(new SpeedPower(2.0f));
        allSpeedPowerTemp.add(new SpeedPower(2.1f));
        allSpeedPowerTemp.add(new SpeedPower(2.2f));
        int length = 6 - 1;
        int[] counts = new int[length];
        float temp = 0.5f;
        for (SpeedPower f3 : allSpeedPowerTemp) {
            float f3Speed = f3.getWinds();
            int f3Id = (int) (f3Speed / temp);
            counts[f3Id]++;
        }
        allSpeedPower = allSpeedPowerTemp.stream().filter(f3 -> {
            float f3Speed = f3.getWinds();
            int f3Id = (int) (f3Speed / temp);
            if (counts[f3Id] >= 3) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        for (SpeedPower speedPower: allSpeedPower) {
            System.out.println(speedPower);
        }
    }

    /**
     * int转以string表示的16进制
     */
    public static void hex() {
        for (int i = 0; i <= 800; i++) {
            String hex= Integer.toHexString(i);
            System.out.println(hex);
        }
    }

    /**
     * 0xff   byte和int的区别
     */
    public static void byteAndInt() {
        byte one = (byte) 0xff;
        System.out.println(one);
        System.out.println(0xff);
    }

    /**
     * 测试两个数组是否一样
     */
    public static void test01() {
        byte[] requiredHead = {0x0, 0x0, 0x0, 0x0,
                0x0, 0x0, 0x0, 0x0,
                0x0, 0x0, 0x0, 0x0,
                0x0, 0x1, 0x0, 0x4};
        byte[] requiredHead1 = {0x0, 0x0, 0x0, 0x0,
                0x0, 0x0, 0x0, 0x0,
                0x0, 0x0, 0x0, 0x0,
                0x0, 0x1, 0x0, 0x4};
        System.out.println("boolean: " + (Arrays.equals(requiredHead, requiredHead1)));
    }


    /**
     * 测试左移和位运算。
     */
    public static void test02() {
        byte one = (byte) 0xbf;
        int hex = (one & 0xff);
        int hex1 = one << 8;
        int hex2 = (0xff00 & (one << 8));
        int hex3 = (one & 0xff) | (0xff00 & (one << 8));
        System.out.println("(byte) 0xbf:" + one);
        System.out.println("(one & 0xff):" + hex);
        System.out.println("one << 8:" + hex1);
        System.out.println("(0xff00 & (one << 8)):" + hex2);
        System.out.println("(one & 0xff) | (0xff00 & (one << 8)):" + hex3);
    }
}

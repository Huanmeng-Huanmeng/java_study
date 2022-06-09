package com.study.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class TestSubmit {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPoolTaskExecutor.setCorePoolSize(20);
        // 设置最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(20);
        // 设置工作队列大小
        threadPoolTaskExecutor.setQueueCapacity(1000);
        // 设置线程名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("threadPoolTaskExecutor-->");
        // 设置拒绝策略.当工作队列已满,线程数为最大线程数的时候,接收新任务抛出RejectedExecutionException异常
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 初始化线程池
        threadPoolTaskExecutor.initialize();
        Future<Boolean> submit = threadPoolTaskExecutor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    Future<Boolean> submit = threadPoolTaskExecutor.submit(new Callable<Boolean>() {

                        @Override
                        public Boolean call() throws Exception {
                            try {
                                Thread.sleep(100000);
                                int x = 1 / 0;
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("1最里面的线程失败了");
                                return false;
                            }

                            return true;
                        }
                    });
                    try {
                        Boolean aBoolean = submit.get(10000, TimeUnit.MILLISECONDS);
                        System.out.println(aBoolean);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("1最里面的线程失败了");
                        return false;
                    }
                }
                return true;
            }
        });
        Future<Boolean> submit2 = threadPoolTaskExecutor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    Future<Boolean> submit = threadPoolTaskExecutor.submit(new Callable<Boolean>() {

                        @Override
                        public Boolean call() throws Exception {
                            try {
                                Thread.sleep(100000);
                                int x = 1 / 0;
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("2最里面的线程失败了");
                                return false;
                            }

                            return true;
                        }
                    });
                    try {
                        Boolean aBoolean = submit.get(10000, TimeUnit.MILLISECONDS);
                        System.out.println(aBoolean);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("2最里面的线程失败了");
                        return false;
                    }
                }
                return true;
            }
        });
        try {
            Boolean aBoolean = submit.get();
            System.out.println("1外面的线程正常完成了" + aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1外面的线程失败了");
        }
        try {
            Boolean aBoolean = submit2.get();
            System.out.println("2外面的线程正常完成了" + aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("2外面的线程失败了");
        }
    }
}

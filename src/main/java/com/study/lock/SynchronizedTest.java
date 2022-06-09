package com.study.lock;

public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    SynchronizedTest.print(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 101; i < 200; i++) {
                    SynchronizedTest.print(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 101; i < 200; i++) {
                    SynchronizedTest.println();
                }
            }
        }).start();
    }

    public static void print(int i) {
        synchronized (SynchronizedTest.class) {
            System.out.print(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

    }

    public static void println() {
        System.out.print("没加锁开始--");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("没加锁结束");
    }
}

package com.study.stringTest;

public class SimpleStringTest {
    public static void main(String[] args) {
        stringBuilderTestIsEmpty();
    }
    public static void stringBuilderTestIsEmpty() {
        StringBuilder ss = new StringBuilder("");
        System.out.println("".equals(ss.toString()));
    }
    public static void stringBuilderTest() {
        StringBuilder ss = new StringBuilder("123");
        System.out.println(ss);
        stringTest(ss);
        System.out.println(ss);
    }
    public static void stringTest(StringBuilder replace) {
        replace.append(replace.toString());
    }
}

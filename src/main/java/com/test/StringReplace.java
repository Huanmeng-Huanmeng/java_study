package com.test;

import lombok.extern.slf4j.Slf4j;
import java.util.Scanner;

@Slf4j
public class StringReplace {
    public static void main(String[] args) {
        System.out.println("1".equals(1 + ""));
        //commaToUnderline();
        //spacesToLowercaseUnderline();
        //underlineToBigHump();
        //underlineToSmallHump();
    }
    /**
     * 下划线转大驼峰
     * 例子（table_COLUMN_coMMENT ==> tableColumnComment）
     */
    public static void underlineToBigHump() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.toString());
            s = s.toLowerCase();
            // //如果输入的是大写，+32即可得到小写
            // sb.append((char)((s.charAt(0) - 32)));
            sb.append((char) (s.charAt(0) -32));
            int length = s.length() - 1;
            for (int i = 1; i <= length; i++) {
                if (s.charAt(i) == '_' && i < length) {
                    sb.append((char) (s.charAt(i + 1) - 32));
                    i++;
                } else {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb);
        }
    }

    /**
     * 下划线转小驼峰
     * 例子（table_COLUMN_coMMENT ==> tableColumnComment）
     */
    public static void underlineToSmallHump() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.toString());
            s = s.toLowerCase();
            // //如果输入的是大写，+32即可得到小写
            // sb.append((char)((s.charAt(0) - 32)));
            sb.append(s.charAt(0));
            int length = s.length() - 1;
            for (int i = 1; i <= length; i++) {
                if (s.charAt(i) == '_' && i < length) {
                    sb.append((char) (s.charAt(i + 1) - 32));
                    i++;
                } else {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb);
        }
    }

    /**
     * 点号变下划线，并转为全大写
     * 例子（table.column ==> TABLE_COLUMN）
     */
    public static void commaToUnderline() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            s = s.replaceAll("\\.", "_");
            s = s.toUpperCase();
            System.out.println(s);
        }
    }

    /**
     * 空格变小写下划线
     * 例子（table.column ==> TABLE_COLUMN）
     */
    public static void spacesToLowercaseUnderline() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            s = s.replaceAll(" ", "_");
            s = s.toLowerCase();
            System.out.println(s);
        }
    }

}

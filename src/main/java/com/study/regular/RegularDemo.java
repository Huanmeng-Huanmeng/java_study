package com.study.regular;

import java.util.regex.Pattern;

public class RegularDemo {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static final Pattern MONITORING_STATUS_WORD_PATTERN = Pattern.compile("监控状态字\\d+");
    private static final Pattern ENGLISH_PATTERN = Pattern.compile("[a-zA-Z]+");
    public static boolean isNumeric2(String str) {
        // 尝试对整个目标字符展开匹配检测,也就是只有整个目标字符串完全匹配时才返回真值.
        return str != null && NUMBER_PATTERN.matcher(str).matches();
    }
    public static void main(String[] args) {
        System.out.println(NUMBER_PATTERN.matcher("123").matches());

        System.out.println(MONITORING_STATUS_WORD_PATTERN.matcher("监控状态字0.1").matches());
        System.out.println(ENGLISH_PATTERN.matcher("aa").matches());
    }
}

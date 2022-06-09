package com.study.log;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class LogTest {
    public static void main(String[] args) {

        try {
            Map map2 = null;
            map2.get("123");
        } catch (NullPointerException e) {
            log.error("空指针异常：{}", e);
        }
    }
}

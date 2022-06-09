package com.study.groovy;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class StartGroovy {
    public static void main(String[] args) {
        startGroovy();
    }

    public static void startGroovy() {
        try {
            GroovyScriptEngine engine = new GroovyScriptEngine("src/main/resources/groovy");
            Binding binding = new Binding();
            binding.setVariable("name", "软件质量保障");
            Object result1 = engine.run("OperatorXml.groovy", binding);
            System.out.println(result1);
        } catch (IOException e) {
            log.info("groovy脚本目录找不到");
        } catch (ResourceException e) {
            log.info("groovy脚本文件找不到");
        } catch (ScriptException e) {
            log.info("groovy脚本执行失败");
        }
    }
}

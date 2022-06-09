package com.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class HelloparentApplicationTests {

    @Test
    void contextLoads() throws Exception{
        String line1 = "5d";
        Pattern p = Pattern.compile("([0-9,a-f]{2}[-,:])");
        Matcher m = p.matcher("5d-");
//        System.out.println(m.matches());

        while (m.find()) {
            System.out.println(m.group());
        }
//        System.out.println(m.group(1));

//        System.out.println("5d-"+Pattern.compile("([0-9,a-f]{2})", Pattern.CASE_INSENSITIVE).matcher("5d").group(1));
//        System.out.println("5d:"+Pattern.compile("([0-9,a-f]{2}[:])", Pattern.CASE_INSENSITIVE).matcher("5d:").group(1));
//        System.out.println("-" + "-".matches("[-,:]"));
//        String macAddress = "";
//        String regular1 = "(([0-9,a-f]{2}[-,:]){5}([0-9,a-f]){2})";
//        String line2 = "   物理地址. . . . . . . . . . . . . : ";
//        String regular2 = ".*:?(\\\\s)*";
//        String line = "54-05-DB-68-F7-C8";
//        Pattern macPattern1 = Pattern.compile(regular1, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = macPattern1.matcher(new String(line.toLowerCase()));
//        //macAddress = matcher.group(1).replaceAll("[-:]", ":");
//        System.out.println(matcher.group());
    }

}

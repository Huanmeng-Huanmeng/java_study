package com.study.doc.xml.example;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxReadXml {

    public static void main(String[] args) {
        readXml();
    }

    public static void readXml() {
        try {
            // 创建工厂
            SAXParserFactory sf=SAXParserFactory.newInstance();
            // 获取SAXParser实例
            SAXParser sp = sf.newSAXParser();
            // 创建一个解析对象
            SAXParserHandler handler = new SAXParserHandler();
            sp.parse("doc/xml/books.xml", handler);

            for(Book book : handler.getbList()){
                System.out.println(book.getId());
                System.out.println(book.getName());
                System.out.println(book.getAuthor());
                System.out.println(book.getYear());
                System.out.println(book.getPrice());
                System.out.println(book.getLanguage());
                System.out.println("*****************");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package com.study.doc.xml.example;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jReadXml {

    public static void main(String[] args) {
        readXml();
    }

    public static void readXml(){
        try {
            // 创建SAXReader对象
            SAXReader reader = new SAXReader();
            // 加载xml文件
            Document dc= reader.read(new File("doc/xml/books.xml"));
            // 获取根节点
            Element e = dc.getRootElement();
            // 获取迭代器
            Iterator it = e.elementIterator();
            // 遍历迭代器，获取根节点信息
            while(it.hasNext()){
                Element book = (Element) it.next();

                List<Attribute>  atts= book.attributes();
                // 获取book属性名和属性值
                for (Attribute att : atts) {
                    System.out.println("节点名："+att.getName()+"节点值："+att.getValue());
                }

                Iterator itt = book.elementIterator();
                while(itt.hasNext()){
                    Element b = (Element) itt.next();

                    System.out.println("属性名："+b.getName()+"属性值："+b.getText());
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}



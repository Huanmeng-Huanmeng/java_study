package com.study.doc.xml.example;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDomReadXml {

    public static void main(String[] args) {
        //
        readXml();
    }

    @SuppressWarnings("unchecked")
    public static void readXml(){
        List<Book> bList = new ArrayList<Book>();
        try {
            // 创建一个SAXBuilder对象
            SAXBuilder builder = new SAXBuilder();
            // 创建一个输入流
            InputStream in = new FileInputStream("doc/xml/books.xml");

            // 处理乱码情况
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");

            // 通过build方法，将输入流加载到SAXBuilder中
            Document doc = builder.build(isr);
            // 通过Document对象获取根节点
            Element foo= doc.getRootElement();
            // 获取根节点下子节点名
            List<Element> allChildren = foo.getChildren();
            // 进行解析
            for (Element book : allChildren) {

                Book b = new Book();

                System.out.println("开始解析第"+(allChildren.indexOf(book)+1)+"本书");
                // 解析book属性集合
                List<Attribute> attrList = book.getAttributes();
                // 遍历(针对不清楚节点下属性名)
                for (Attribute attr : attrList) {
                    System.out.println("属性名："+attr.getName() +" -- 属性值："+attr.getValue());
                    if("id".equals(attr.getName())){
                        b.setId(attr.getValue());
                    }
                }

                // 清楚知道属性名获取属性值
                String v = book.getAttributeValue("id");
                System.out.println("清楚知道属性名"+v);

                // 对book节点子节点的节点名和节点值进行遍历
                List<Element> bookChiles = book.getChildren();
                for (Element element : bookChiles) {
                    System.out.println("属性名："+element.getName() +" -- 属性值："+element.getValue());

                    if("name".equals(element.getName())){
                        b.setName(element.getValue());
                    }else if("author".equals(element.getName())){
                        b.setAuthor(element.getValue());
                    }else if("year".equals(element.getName())){
                        b.setYear(element.getValue());
                    }else if("price".equals(element.getName())){
                        b.setPrice(element.getValue());
                    }else if("language".equals(element.getName())){
                        b.setLanguage(element.getValue());
                    }
                }
                System.out.println("结束解析第"+(allChildren.indexOf(book)+1)+"本书");
                bList.add(b);
                b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


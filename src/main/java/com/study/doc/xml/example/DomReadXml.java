package com.study.doc.xml.example;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DomReadXml {

    public static void main(String[] args) {
        readXml();
    }

    public static void readXml() {
        try {
            // 创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            // 创建一个Document对象
            Document doc = db.parse("doc/xml/books.xml");
            NodeList bookList = doc.getElementsByTagName("book");
            // 获取节点个数
            System.out.println("一共有" + bookList.getLength() + "本书");

            // 遍历每个book节点
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("*******************************");
                // 索引从零开始
                org.w3c.dom.Node book = bookList.item(i);
                // 获取book节点所有属性集合
                org.w3c.dom.NamedNodeMap attrs = book.getAttributes();

                System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "属性");
                // 遍历book属性，不知道节点属性和属性名情况
                for (int j = 0; j < attrs.getLength(); j++) {
                    // 获取某一个属性
                    org.w3c.dom.Node attr = attrs.item(j);
                    System.out.print("属性名:" + attr.getNodeName());
                    System.out.println(" --- 属性值:" + attr.getNodeValue());
                }

                // 若已经知道book节点有且只有1个ID属性,可用以下方式
                // org.w3c.dom.Element e = (org.w3c.dom.Element)
                // bookList.item(i);
                // System.out.println("Element属性值:"+e.getAttribute("id"));

                NodeList childNodes = book.getChildNodes();
                for (int k = 0; k < childNodes.getLength(); k++) {
                    // 区分,去掉空格和换行符
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        // 获取element类型的节点和节点值
                        System.out.print("节点名：" + childNodes.item(k).getNodeName());
                        System.out.print(" --- 节点值：" + childNodes.item(k).getFirstChild().getNodeValue());
                        System.out.println(" --- 节点值："+childNodes.item(k).getTextContent());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



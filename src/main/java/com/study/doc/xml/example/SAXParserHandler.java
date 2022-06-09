package com.study.doc.xml.example;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {

    int bookIndex = 0;
    String str = null;
    Book b = null;
    private List<Book> bList = new ArrayList<Book>();

    public List<Book> getbList() {
        return bList;
    }

    /**
     * 用来遍历xml文件的开始标签
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 调用DefaultHandler的startElement方法
        super.startElement(uri, localName, qName, attributes);
        // 开始解析book元素属性
        if(qName.equals("book")){
            bookIndex++;

            // 创建一个book对象
            b = new Book();
            System.out.println("****开始第"+bookIndex+"本书内容****");
            // 已知book元素下属性名称，根据属性名称获取属性值s
            String value = attributes.getValue("id");
            System.out.println("book的属性值是："+value);

            int num = attributes.getLength();

            for(int i=0;i<num;i++){
                System.out.print("book元素的第"+(i+1)+"个属性名是："+attributes.getQName(i));
                System.out.println(" -- 属性值是："+attributes.getValue(i));
                if(attributes.getQName(i).equals("id")){
                    b.setId(attributes.getQName(i));
                }
            }
        }else if(!qName.equals("book") && !qName.equals("bookstore")){
            System.out.print("节点名是："+qName);

        }
    }

    /**
     * 用来遍历xml文件的结束标签
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // 调用DefaultHandler的endElement方法
        super.endElement(uri, localName, qName);
        // 判断是否针对一本书已经遍历结束
        if(qName.equals("book")){
            bList.add(b);
            b = null;
            System.out.println("****结束第"+bookIndex+"本书内容****");
        }else if(qName.equals("name")){
            b.setName(str);
        }else if(qName.equals("author")){
            b.setAuthor(str);
        }else if(qName.equals("year")){
            b.setYear(str);
        }else if(qName.equals("price")){
            b.setPrice(str);
        }else if(qName.equals("language")){
            b.setLanguage(str);
        }
    }

    /**
     * 用来标志解析开始
     */
    @Override
    public void startDocument() throws SAXException {
        // 调用DefaultHandler的startDocument方法
        super.startDocument();
        System.out.println("解析开始");
    }

    /**
     * 用来标志解析结束
     */
    @Override
    public void endDocument() throws SAXException {
        // 调用DefaultHandler的endDocument方法
        super.endDocument();
        System.out.println("解析结束");
    }

    /**
     * 用来标志解析结束
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 调用DefaultHandler的characters方法
        super.characters(ch, start, length);
        str = new String(ch, start, length);
        if(!str.trim().equals("")){
            System.out.println(" -- 节点值是："+str);
        }
    }

}


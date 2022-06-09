package com.study.doc.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// sax(Simple API for XML)就是用来做xml解析用的，使用很简单，它是基于事件模型的
public class SaxXml {
    public static void main(String[] args) {
        dealXml();
    }
    public static void dealXml() {
        // SAX解析
        // 1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser parse = null;
        XMLReader reader = null;
        try {
            // 2.从解析工厂获取解析器
            parse = factory.newSAXParser();
            // 3.得到解读器
            reader = parse.getXMLReader();
            // 4.设置内容处理器
            reader.setContentHandler(new FaultCodeHandler());
            // 5.读取xml的文档内容
            reader.parse("FaultCode.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class FaultCodeHandler extends DefaultHandler {
    private Map<String, Map<String, FaultCode>> devices;

    public Map<String, Map<String, FaultCode>> getDevices() {
        return devices;
    }

    private Map<String, FaultCode> faultCodeMap;
    private FaultCode faultCode;
    private String tagDevice1 = null; // 存储操作标签
    private String tagPoint = null; // 存储操作标签
    private String tagDevice1Name = null;

    /**
     * @author lastwhisper
     * @desc 文档解析开始时调用，该方法只会调用一次
     * @param
     * @return void
     */
    @Override
    public void startDocument() throws SAXException {
        devices = new HashMap<String, Map<String, FaultCode>>();
    }

    /**
     * @author lastwhisper
     * @desc 标签（节点）解析开始时调用
     * @param uri xml文档的命名空间
     * @param localName 标签的名字
     * @param qName 带命名空间的标签的名字
     * @param attributes 标签的属性集
     * @return void
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (tagDevice1 == null) {
            tagDevice1 = qName;
        } else if (tagPoint == null){
            tagPoint = qName;
        }
        if ("device1".equals(tagDevice1)) {
            if (tagDevice1Name == null) {
                String deviceName = attributes.getValue("name");
                if (deviceName == null) {
                    System.out.println("xml不符合要求,device1标签下缺失name属性");
                    return;
                }
                tagDevice1Name = deviceName;
                int length = attributes.getLength();
                faultCodeMap = new HashMap<>(60);
            } else {
                if ("point".equals(qName)) {
                    String code = attributes.getValue("code");
                    if (code == null) {
                        System.out.println("xml不符合要求,device1标签下缺失code属性");
                        return;
                    }
                    String name = attributes.getValue("name");
                    if (name == null) {
                        System.out.println("xml不符合要求,device1标签下缺失name属性");
                        return;
                    }
                    String source = attributes.getValue("source");
                    if (source == null) {
                        System.out.println("xml不符合要求,device1标签下缺失source属性");
                        return;
                    }
                    String category = attributes.getValue("category");
                    if (category == null) {
                        System.out.println("xml不符合要求,device1标签下缺失category属性");
                        return;
                    }
                    faultCode = new FaultCode(code, name, source, category);
                    faultCodeMap.put(code, faultCode);
                }

            }

        }
    }

    /**
     * @author lastwhisper
     * @desc 解析标签的内容的时候调用
     * @param ch  字符
     * @param start 字符数组中的起始位置
     * @param length 要从字符数组使用的字符数
     * @return void
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        String contents = new String(ch, start, length).trim();
//        if ("name".equals(tag)) {
//            person.setName(contents);
//        } else if ("age".equals(tag)) {
//            if (contents.length() > 0) {
//                person.setAge(Integer.valueOf(contents));
//            }
//        }
    }

    /**
     * @author lastwhisper
     * @desc 标签（节点）解析结束后调用
     * @param uri xml文档的命名空间
     * @param localName 标签的名字
     * @param qName 带命名空间的标签的名字
     * @return void
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (tagDevice1 != null && qName.equals(tagPoint)) {
            System.out.println(tagPoint + "解析完毕");
            tagPoint = null;
        }
        if ("device1".equals(tagDevice1)) {
            devices.put(tagDevice1Name, faultCodeMap);
            System.out.println(tagDevice1 + "解析完毕");
            tagDevice1 = null;
        }

    }

    /**
     * @author lastwhisper
     * @desc 文档解析结束后调用，该方法只会调用一次
     * @param
     * @return void
     */
    @Override
    public void endDocument() throws SAXException {
        for (Map.Entry<String, Map<String, FaultCode>> devicesExample: devices.entrySet()) {
            String deviceName = devicesExample.getKey();
            Map<String, FaultCode> deviceMap = devicesExample.getValue();
            for (Map.Entry<String, FaultCode> deviceExample: deviceMap.entrySet()) {
                String pointCode = deviceExample.getKey();
                FaultCode faultCodeExample = deviceExample.getValue();
                System.out.println("device1:=【" + deviceName + "】code:=【"
                        + faultCodeExample.getCode() + "】name:=【" + faultCodeExample.getName()
                        + "】source:=【" + faultCodeExample.getSource() + "】category:=【" + faultCodeExample.getCategory() + "】");
            }
        }
        System.out.println("xml解析完毕");
    }

}
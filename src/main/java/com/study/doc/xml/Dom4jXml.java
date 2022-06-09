package com.study.doc.xml;

import com.study.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Dom4jXml {
    public static void main(String[] args) {
        Dom4jXml dom4jXml = new Dom4jXml();
        String fileName = "doc/xml/WGKDF4x00RunLogRecord.xml";
        dom4jXml.dealXml(fileName);
    }
    public void dealXml(String fileName) {
        String csvName = "doc/csv/FaultCode.csv";
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        Document document = null;
        Element root = null;
        //读取文件 转换成Document
        try {
            Map<String, Map<String, FaultCode>> deviceMap = new HashMap<>();
            document = reader.read(new File(fileName));
            root = document.getRootElement();
            List<Element> devices = root.elements();
            for (Element device: devices) {
                Map<String, FaultCode> map = new HashMap<>(200);
                String device1Name = device.attributeValue("name");
                List<Element> points = device.elements();
                for (Element element: points) {
                    String code = element.attributeValue("code");
                    String name = element.attributeValue("name");
                    String source = element.attributeValue("source");
                    String category = element.attributeValue("category");
                    FaultCode faultCode = new FaultCode(code, name, source, category);
                    map.put(code, faultCode);
                }
                deviceMap.put(device1Name, map);
            }
            StringBuilder stringBuilder = new StringBuilder("");
            for (Map.Entry<String, Map<String, FaultCode>> device: deviceMap.entrySet()) {
                String deviceName = device.getKey();
                for (Map.Entry<String, FaultCode> faultCodeEntry: device.getValue().entrySet()) {
                    String name = faultCodeEntry.getKey();
                    FaultCode faultCode = faultCodeEntry.getValue();
                    System.out.println("deviceName:=【" +deviceName + "】name:=【" + name + "】------" + faultCode.toString());
                    stringBuilder.append(faultCode.getCode()).append(",")
                            .append(faultCode.getName()).append(",")
                            .append(faultCode.getSource()).append(",")
                            .append(faultCode.getCategory()).append("\n");
                }
            }
            FileUtils.createCSV(csvName, "");
            FileUtils.writeToFile(csvName,stringBuilder.toString(), true);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

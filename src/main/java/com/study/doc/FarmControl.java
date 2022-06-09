package com.study.doc;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@Slf4j
public class FarmControl {
    public static void main(String[] args) {
        FarmControl farmControl = new FarmControl();
        farmControl.farmControlConfigCheck();
    }
    public void farmControlConfigCheck() {
        String prefix = "E:\\WorkSpace\\git\\configgenerated_scadaplus";
        File file = new File(prefix);
        String[] list = file.list();
        for (String example: list) {
            if (example.charAt(0) == '.' || "docker-entrypoint.sh".equals(example) || "Dockerfile".equals(example)
                    || "Makefile".equals(example) || "README.md".equals(example)) {
                continue;
            }
            String filePrefix = prefix + File.separator + example + "/scada/software/farmcontrol/";
            log.info("\n\n");
            log.info("-----" + example + "风场校验开始-----");
            try {
                farmControlConfigCheck(filePrefix);
            } catch (Exception e) {
                log.info(e.getMessage());
            }
            log.info("-----" + example + "风场校验结束-----");
        }
    }

    // 能管的关键配置文件校验
    public void farmControlConfigCheck(String fileNamePrefix) throws Exception{
        log.info("---能管的关键配置文件校验【开始】---");
        String applicationFileName = fileNamePrefix + APPLICATION_FILE_NAME;
        String farmconfigFileName = fileNamePrefix + FARMCONFIG_FILE_NAME;
        String channelFileName = fileNamePrefix + CHANNEL_FILE_NAME;
        String iecPubsFileName = fileNamePrefix + IEC_PUBS_FILE_NAME;
        String iecTagsFileName = fileNamePrefix + IEC_TAGS_FILE_NAME;
        String modbusPubsFileName = fileNamePrefix + MODBUS_PUBS_FILE_NAME;
        String modbusTagsFileName = fileNamePrefix + MODBUS_TAGS_FILE_NAME;
        StringBuilder message = new StringBuilder("");


        // 1.功率曲线的配置
        Properties farmConfigProperties = new Properties();
        boolean firstCheck = true;
        boolean farmConfigPropertiesCheck = true;
        farmConfigPropertiesCheck = readPropertiesFromFile(farmConfigProperties, farmconfigFileName);
        if (farmConfigPropertiesCheck) {
            firstCheck = firstCheck(farmConfigProperties);
            if (!firstCheck) {
                log.error(ERROR_MESSAGE_OF_FARMCONTROL_FIRST_CHECK);
                message.append("\n" + ERROR_MESSAGE_OF_FARMCONTROL_FIRST_CHECK);
            }
        } else {
            log.error(ERROR_MESSAGE_OF_FARMCONTROL_FIRST_CHECK);
            message.append("\n" + ERROR_MESSAGE_OF_FARMCONTROL_FIRST_CHECK);
        }


        // 2.agc avc 一次调频的配置
        Properties applicationProperties = new Properties();
        boolean secondCheck = true;
        boolean applicationPropertiesCheck = true;
        applicationPropertiesCheck = readPropertiesFromFile(applicationProperties, applicationFileName);
        // 读取channel.xml文件
        // 创建SAXReader对象
        Document channelDc = readDocumentFromFile(channelFileName);
        if (applicationPropertiesCheck) {
            secondCheck = secondCheck(applicationProperties, channelDc, modbusPubsFileName, iecPubsFileName);
            if (!secondCheck) {
                log.error(ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK);
                message.append("\n" + ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK);
            }
        } else {
            log.error(ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK);
            message.append("\n" + ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK);
        }


        // 3.风机采集点  sany/settings/modbus-tags.xml
        boolean thirdCheck = true;
        // 读取modbus-tags.xml文件
        // 创建SAXReader对象
        Document modbusTagsDc = readDocumentFromFile(modbusTagsFileName);
        if (farmConfigPropertiesCheck) {
            thirdCheck = thirdCheck(farmConfigProperties, channelDc, modbusTagsDc);
            if (!thirdCheck) {
                log.error(ERROR_MESSAGE_OF_FARMCONTROL_THIRD_CHECK);
                message.append("\n" + ERROR_MESSAGE_OF_FARMCONTROL_THIRD_CHECK);
            }
        } else {
            log.error(ERROR_MESSAGE_OF_FARMCONTROL_THIRD_CHECK);
            message.append("\n" + ERROR_MESSAGE_OF_FARMCONTROL_THIRD_CHECK);
        }


        // 5.并网点
        boolean fifthCheck = true;
        if (applicationPropertiesCheck) {
            fifthCheck = fifthCheck(applicationProperties, channelDc, iecTagsFileName, modbusTagsDc);
            if (!fifthCheck) {
                log.error(ERROR_MESSAGE_OF_FARMCONTROL_FIFTH_CHECK);
                message.append("\n" + ERROR_MESSAGE_OF_FARMCONTROL_FIFTH_CHECK);
            }
        } else {
            log.error(ERROR_MESSAGE_OF_FARMCONTROL_FIFTH_CHECK);
            message.append("\n" + ERROR_MESSAGE_OF_FARMCONTROL_FIFTH_CHECK);
        }
        if (!EMPTY_STRING.equals(message.toString())) {
            throw new Exception(message.toString());
        }
        log.info("---能管的关键配置文件校验【正常结束】---");
    }

    // 能管的关键配置文件校验：1.功率曲线的配置
    public boolean firstCheck(Properties farmConfigProperties) {
        String typeProperty = farmConfigProperties.getProperty(SANY_FARM_TURBINE_TYPE);
        if (typeProperty == null || EMPTY_STRING.equals(typeProperty.trim())) {
            log.error(SANY_FARM_TURBINE_TYPE + "属性不能为空或者空字符串");
            return false;
        }

        String[] typePropertys = typeProperty.toLowerCase().trim().split(COMMA);
        for (String example: typePropertys) {
            String match = SANY_FARM_TURBINE_POWERCURVE + example;
            String matchProperty = farmConfigProperties.getProperty(match);
            if (matchProperty == null || EMPTY_STRING.equals(matchProperty.trim())) {
                log.error(match + "属性不能为空或者空字符串");
                return  false;
            }
        }
        return true;
    }

    // 能管的关键配置文件校验：2.agc avc 一次调频的配置
    public boolean secondCheck(Properties applicationProperties, Document channelDc, String modbusPubsFileName, String iecPubsFileName) {
        String agcProperty = applicationProperties.getProperty(GRIDCOMMANDLISTENER_AGC);
        String avcProperty = applicationProperties.getProperty(GRIDCOMMANDLISTENER_AVC);
        String primaryProperty = applicationProperties.getProperty(GRIDCOMMANDLISTENER_PRIMARY);
        if (agcProperty == null || avcProperty == null || primaryProperty == null) {
            log.error("三个属性【[{}]，[{}]，[{}]】都不能为空。", GRIDCOMMANDLISTENER_AGC, GRIDCOMMANDLISTENER_AVC, GRIDCOMMANDLISTENER_PRIMARY);
            return false;
        }

        String[] agcPropertySplit = agcProperty.trim().split(COLON);
        String[] avcPropertySplit = avcProperty.trim().split(COLON);
        String[] primaryPropertySplit = primaryProperty.trim().split(COLON);
        if (agcPropertySplit.length != 4 || avcPropertySplit.length != 4 || primaryPropertySplit.length != 4) {
            log.error("三个属性【[{}]，[{}]，[{}]】按冒号（:）截取出来的字符串数组长度不全为4。", GRIDCOMMANDLISTENER_AGC, GRIDCOMMANDLISTENER_AVC, GRIDCOMMANDLISTENER_PRIMARY);
            return false;
        }

        if (!EMS.equals(agcPropertySplit[2]) || !EMS.equals(avcPropertySplit[2]) || !EMS.equals(primaryPropertySplit[2])) {
            log.error("三个属性【[{}]，[{}]，[{}]】截取出来的字符串数组的第三项必须全为ems。", GRIDCOMMANDLISTENER_AGC, GRIDCOMMANDLISTENER_AVC, GRIDCOMMANDLISTENER_PRIMARY);
            return false;
        }

        boolean agcPropertyBoolean = false;
        boolean avcPropertyBoolean = false;
        boolean primaryPropertyBoolean = false;

        if (channelDc != null) {
            // 获取根节点
            Element channelRootElement = channelDc.getRootElement();
            if (channelRootElement != null) {
                Element channels2Element = channelRootElement.element(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2);
                if (channels2Element != null) {
                    // 获取第一个channel元素
                    // Element channelElement = channels2Element.element("channel");
                    // 获取所有的channel元素
                    List<Element> channel2Elements = channels2Element.elements(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2);
                    for (Element example: channel2Elements) {
                        if (!agcPropertyBoolean) {
                            agcPropertyBoolean = farmControlConfigCheck2(example, agcPropertySplit, modbusPubsFileName, iecPubsFileName);
                        }
                        if (!avcPropertyBoolean) {
                            avcPropertyBoolean = farmControlConfigCheck2(example, avcPropertySplit, modbusPubsFileName, iecPubsFileName);
                        }
                        if (!primaryPropertyBoolean) {
                            primaryPropertyBoolean = farmControlConfigCheck2(example, primaryPropertySplit, modbusPubsFileName, iecPubsFileName);
                        }
                        if (agcPropertyBoolean && avcPropertyBoolean && primaryPropertyBoolean) {
                            break;
                        }
                    }
                    if (!agcPropertyBoolean || !avcPropertyBoolean || !primaryPropertyBoolean) {
                        log.error(ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK);
                        return false;
                    }
                } else {
                    log.error(ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK);
                    return false;
                }
            } else {
                log.error(ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK);
                return false;
            }
        } else {
            log.error(ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK);
            return false;
        }
        return true;
    }

    // 能管的关键配置文件校验：3.风机采集点  sany/settings/modbus-tags.xml
    public boolean thirdCheck(Properties farmConfigProperties, Document channelDc, Document modbusTagsDc) {
        String ratedPower = farmConfigProperties.getProperty(SANY_EMS_RATEDPOWER);
        String turbineMeasurementsKeys = farmConfigProperties.getProperty(SANY_EMS_TURBINEMEASUREMENTS_KEYS);
        if (ratedPower == null || !C025.equals(ratedPower.trim())) {
            log.error("{}属性的值必须为【{}】", SANY_EMS_RATEDPOWER, C025);
            return false;
        }
        if (turbineMeasurementsKeys == null) {
            log.error("{}属性的值不能为空", SANY_EMS_TURBINEMEASUREMENTS_KEYS);
            return false;
        }
        String[] turbineMeasurementsKeysSplit = turbineMeasurementsKeys.trim().split(COMMA);
        boolean check3 = false;
        for (String example:turbineMeasurementsKeysSplit) {
            if (C025.equals(example)) {
                check3 = true;
                break;
            }
        }
        if (!check3) {
            log.error("{}属性的值中必须包含字段【{}】", SANY_EMS_TURBINEMEASUREMENTS_KEYS, C025);
            return false;
        }
        if (channelDc != null) {
            // 获取根节点
            Element channelRootElement = channelDc.getRootElement();
            if (channelRootElement != null) {
                Element channels2Element = channelRootElement.element(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2);
                if (channels2Element != null) {
                    List<Element> channelElements = channels2Element.elements(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL);
                    Set<String> modbusTagsTemplateNames = new HashSet<>();
                    for (Element example: channelElements) {
                        String id = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ATTRIBUTE_ID);
                        String deviceUniKey = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ATTRIBUTE_DEVICEUNIKEY);
                        String role = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ATTRIBUTE_ROLE);
                        if (COLLECTOR_OF_ROLE.equals(role) && (id != null && !EMPTY_STRING.equals(id) && (id.equals(deviceUniKey)) && (id.matches("R([0-9]+)") || id.matches("([0-9]+)")))) {
                            Element endPoints = example.element(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ENDPOINTS);
                            if (endPoints != null) {
                                List<Element> endPointElement = endPoints.elements(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ENDPOINTS_ENDPOINT);
                                for (Element endPointExample: endPointElement) {
                                    String templateName = endPointExample.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ENDPOINTS_ENDPOINT_ATTRIBUTE_TEMPLATENAME);
                                    if (templateName != null && !EMPTY_STRING.equals(templateName)) {
                                        modbusTagsTemplateNames.add(templateName);
                                    }
                                }
                            }
                        }
                    }

                    // 获取根节点
                    if (modbusTagsDc != null) {
                        Element modbusTagsRootElement = modbusTagsDc.getRootElement();
                        if (modbusTagsRootElement != null) {
                            List<Element> modbusTagsTagsElement = modbusTagsRootElement.elements(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS);
                            // 不需要全等于， 有就行
                            for (Element tagsExample: modbusTagsTagsElement) {
                                String id = tagsExample.attributeValue(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_ATTRIBUTE_ID);
                                if (modbusTagsTemplateNames.contains(id)) {
                                    boolean hasMC016 = false;
                                    boolean hasMC025 = false;
                                    List<Element> segmentElement = tagsExample.elements(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT);
                                    for (Element segmentExample: segmentElement) {
                                        List<Element> ioTagElement = segmentExample.elements(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT_IOTAG);
                                        for (Element ioTagExample:ioTagElement) {
                                            String name = ioTagExample.attributeValue(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT_IOTAG_ATTRIBUTE_NAME);
                                            if (MC016.equals(name)) {
                                                hasMC016 = true;
                                            }
                                            if (C025.equals(name)) {
                                                String desc = ioTagExample.attributeValue(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT_IOTAG_ATTRIBUTE_DESC);
                                                if (VALUE_OF_DESC.equals(desc)) {
                                                    hasMC025 = true;
                                                }
                                            }
                                            if (hasMC016 && hasMC025) {
                                                modbusTagsTemplateNames.remove(id);
                                                break;
                                            }
                                        }
                                        if (modbusTagsTemplateNames.size() == 0) {
                                            break;
                                        }
                                    }
                                    if (modbusTagsTemplateNames.size() == 0) {
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    if (modbusTagsTemplateNames.size() == 0) {
                        return true;
                    }
                } else {
                    log.error(ERROR_MESSAGE_OF_FARMCONTROL_THIRD_CHECK);
                    return false;
                }
            } else {
                log.error(ERROR_MESSAGE_OF_FARMCONTROL_THIRD_CHECK);
                return false;
            }
        } else {
            log.error(ERROR_MESSAGE_OF_FARMCONTROL_THIRD_CHECK);
            return false;
        }
        return false;
    }

    // 能管的关键配置文件校验：5.并网点
    public boolean fifthCheck(Properties applicationProperties, Document channelDc, String iecTagsFileName, Document modbusTagsDc) {
        String outLinePowerProtocolProperty = applicationProperties.getProperty(OUT_LINE_POWER_PROTOCOL);
        String outLinePowerModeProperty = applicationProperties.getProperty(OUT_LINE_POWER_MODE);
        String outlinepowerProperty = applicationProperties.getProperty(OUT_LINE_POWER);
        if (outLinePowerProtocolProperty == null || outLinePowerModeProperty == null || outlinepowerProperty == null) {
            log.error("三个属性【[{}]，[{}]，[{}]】都不能为空。", OUT_LINE_POWER_PROTOCOL, OUT_LINE_POWER_MODE, OUT_LINE_POWER);
            return false;
        }
        outLinePowerProtocolProperty = outLinePowerProtocolProperty.trim();
        outLinePowerModeProperty = outLinePowerModeProperty.trim();
        String[] outlinepowerPropertySplit = outlinepowerProperty.trim().split(COLON);
        if (outlinepowerPropertySplit.length != 4 || !OLP.equals(outlinepowerPropertySplit[0]) || !OutLinePower.equals(outlinepowerPropertySplit[3])) {
            log.error("属性【{}】不符合要求。", OUT_LINE_POWER);
            return false;
        }

        if (channelDc != null) {
            // 获取根节点
            Element channelRootElement = channelDc.getRootElement();
            if (channelRootElement != null) {
                Element channels2Element = channelRootElement.element(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2);
                if (channels2Element != null) {
                    List<Element> channel2Elements = channels2Element.elements(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2);
                    if (IEC_104.equals(outLinePowerProtocolProperty)) {
                        for (Element example: channel2Elements) {
                            String id = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_ID);
                            String deviceUniKey = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_DEVICEUNIKEY);
                            String role = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_ROLE);
                            if (outlinepowerPropertySplit[0].equals(id) && id.equals(deviceUniKey)) {
                                if (COLLECTOR_OF_ROLE.equals(role)) {
                                    Element endPoints = example.element(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS);
                                    if (endPoints != null) {
                                        List<Element> endPointElement = endPoints.elements(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT);
                                        for (Element endPointExample: endPointElement) {
                                            if (endPointExample != null) {
                                                String protocolType = endPointExample.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT_ATTRIBUTE_PROTOCOLTYPE);
                                                if (IEC_104.equals(protocolType)) {
                                                    String templateName = endPointExample.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT_ATTRIBUTE_TEMPLATENAME);
                                                    // 读取iec-tags.xml文件
                                                    // 创建SAXReader对象
                                                    Document iecTagsDc = readDocumentFromFile(iecTagsFileName);
                                                    if (iecTagsDc != null) {
                                                        Element iecTagsRootElement = iecTagsDc.getRootElement();
                                                        List<Element> iecTagsTagsElement = iecTagsRootElement.elements(IEC_TAGS_XML_IEC104TAGSINFO_TAGS);
                                                        for (Element iecTagsTagsExample: iecTagsTagsElement) {
                                                            String id1 = iecTagsTagsExample.attributeValue(IEC_TAGS_XML_IEC104TAGSINFO_TAGS_ATTRIBUTE_ID);
                                                            if (templateName.equals(id1)) {
                                                                List<Element> iec104Items = iecTagsTagsExample.elements(IEC_TAGS_XML_IEC104TAGSINFO_TAGS_IEC104ITEMS);
                                                                for (Element iec104ItemsExample: iec104Items) {
                                                                    List<Element> iec104Item = iec104ItemsExample.elements(IEC_TAGS_XML_IEC104TAGSINFO_TAGS_IEC104ITEMS_ITEM);
                                                                    for (Element iec104ItemExample: iec104Item) {
                                                                        String iec104ItemName = iec104ItemExample.attributeValue(IEC_TAGS_XML_IEC104TAGSINFO_TAGS_IEC104ITEMS_ITEM_ATTRIBUTE_NAME);
                                                                        if (outlinepowerPropertySplit[3].equals(iec104ItemName)) {
                                                                            return true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (MODBUS.equals(outLinePowerProtocolProperty)) {
                        if (!ONE_OF_STRING.equals(outLinePowerModeProperty)) {
                            log.error("属性【{}】的值不为1,不符合要求", OUT_LINE_POWER_MODE);
                            return false;
                        }
                        for (Element example: channel2Elements) {
                            String id = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_ID);
                            String deviceUniKey = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_DEVICEUNIKEY);
                            String role = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_ROLE);
                            if (outlinepowerPropertySplit[0].equals(id) && id.equals(deviceUniKey)) {
                                if (COLLECTOR_OF_ROLE.equals(role)) {
                                    Element endPoints = example.element(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS);
                                    if (endPoints != null) {
                                        List<Element> endPointElement = endPoints.elements(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT);
                                        for (Element endPointExample: endPointElement) {
                                            if (endPointExample != null) {
                                                String protocolType = endPointExample.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT_ATTRIBUTE_PROTOCOLTYPE);
                                                if (MODBUS.equals(protocolType)) {
                                                    String templateName = endPointExample.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT_ATTRIBUTE_TEMPLATENAME);
                                                    // 读取modbus-tags.xml文件
                                                    // 创建SAXReader对象
                                                    if (modbusTagsDc != null) {
                                                        Element modbusTagsRootElement = modbusTagsDc.getRootElement();
                                                        if (modbusTagsRootElement != null) {
                                                            List<Element> modbusTagsTagsElement = modbusTagsRootElement.elements(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS);
                                                            for (Element modbusTagsTagsExample: modbusTagsTagsElement) {
                                                                String id1 = modbusTagsTagsExample.attributeValue(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_ATTRIBUTE_ID);
                                                                if (templateName.equals(id1)) {
                                                                    List<Element> segment = modbusTagsTagsExample.elements(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT);
                                                                    for (Element segmentExample: segment) {
                                                                        List<Element> ioTag = segmentExample.elements(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT_IOTAG);
                                                                        for (Element ioTagExample: ioTag) {
                                                                            String ioTagName = ioTagExample.attributeValue(MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT_IOTAG_ATTRIBUTE_NAME);
                                                                            if (outlinepowerPropertySplit[3].equals(ioTagName)) {
                                                                                return true;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        log.error(ERROR_MESSAGE_OF_FARMCONTROL_FIFTH_CHECK);
        return false;
    }

    // 能管的关键配置文件校验：2.agc avc 一次调频的配置 下的一个方法
    public boolean farmControlConfigCheck2(Element example, String[] propertySplit, String modbusFileName, String iecFileName){
        boolean result = false;
        String templateName = "";
        String id = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_ID);
        String deviceUniKey = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_DEVICEUNIKEY);
        String protocolType = example.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_PROTOCOLTYPE);
        if (propertySplit[0].equals(id) && id.equals(deviceUniKey)) {
            Element endPoints = example.element(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS);
            if (endPoints != null) {
                List<Element> endPointElement = endPoints.elements(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT);
                for (Element endPointExample: endPointElement) {
                    templateName = endPointExample.attributeValue(CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT_ATTRIBUTE_TEMPLATENAME);
                    if (IEC_104.equals(protocolType)) {
                        if (YT_F.equals(propertySplit[1])) {
                            // 读取iec-pubs.xml文件
                            // 创建SAXReader对象
                            Document iecPubsDc = readDocumentFromFile(iecFileName);
                            if (iecPubsDc != null) {
                                Element iecPubsRootElement = iecPubsDc.getRootElement();
                                if (iecPubsRootElement != null) {
                                    List<Element> tagsElement = iecPubsRootElement.elements(IEC_PUBS_IEC104PUBLISHINFO_TAGS);
                                    for (Element tagsExample: tagsElement) {
                                        if (templateName.equals(tagsExample.attributeValue(IEC_PUBS_IEC104PUBLISHINFO_TAGS_ATTRIBUTE_ID))) {
                                            List<Element> groupElements = tagsExample.elements(IEC_PUBS_IEC104PUBLISHINFO_TAGS_GROUP);
                                            for (Element groupExample: groupElements) {
                                                List<Element> itemElement = groupExample.elements(IEC_PUBS_IEC104PUBLISHINFO_TAGS_GROUP_ITEM);
                                                for (Element itemExample: itemElement) {
                                                    String alias = itemExample.attributeValue(IEC_PUBS_IEC104PUBLISHINFO_TAGS_GROUP_ITEM_ATTRIBUTE_ALIAS);
                                                    String key = itemExample.attributeValue(IEC_PUBS_IEC104PUBLISHINFO_TAGS_GROUP_ITEM_ATTRIBUTE_KEY);
                                                    if (propertySplit[2].equals(alias) && propertySplit[3].equals(key)) {
                                                        result = true;
                                                        return result;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (MODBUS.equals(protocolType)) {
                        if (HOLDING_REGISTER.equals(propertySplit[1])) {
                            // 读取modbus-pubs.xml文件
                            // 创建SAXReader对象
                            SAXReader reader = new SAXReader();
                            Document modbusPubsDc = readDocumentFromFile(modbusFileName);
                            if (modbusPubsDc != null) {
                                Element modbusPubsRootElement = modbusPubsDc.getRootElement();
                                if (modbusPubsRootElement != null) {
                                    List<Element> tagsElement = modbusPubsRootElement.elements(MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS);
                                    for (Element tagsExample: tagsElement) {
                                        if (templateName.equals(tagsExample.attributeValue(MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_ATTRIBUTE_ID))) {
                                            List<Element> segmentsElements = tagsExample.elements(MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS);
                                            for (Element segmentsExample:segmentsElements) {
                                                List<Element> segmentElements = segmentsExample.elements(MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS_SEGMENT);
                                                for (Element segmentExample: segmentElements) {
                                                    List<Element> ioTag = segmentExample.elements(MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS_SEGMENT_IOTAG);
                                                    for (Element ioTagExample:ioTag) {
                                                        String alias = ioTagExample.attributeValue(MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS_SEGMENT_IOTAG_ATTRIBUTE_ALIAS);
                                                        String storeKey = ioTagExample.attributeValue(MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS_SEGMENT_IOTAG_ATTRIBUTE_STOREKEY);
                                                        if (propertySplit[2].equals(alias) && propertySplit[3].equals(storeKey)) {
                                                            result = true;
                                                            return result;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param properties 配置类
     * @param fileName .properties文件名
     * @return 是否成功将.properties文件加载到配置类中
     */
    public boolean readPropertiesFromFile(Properties properties, String fileName) {
        InputStream inputStream = null;
        // 1.功率曲线的配置
        try {
            inputStream = new FileInputStream(fileName);
            properties.load(inputStream);
            //farmConfigProperties.list(System.out); // 将properties文件中所有内容输出到控制台
        } catch (FileNotFoundException e) {
            log.error("文件【{}】找不到", fileName);
            return false;
        } catch (IOException e) {
            log.error("文件【{}】转化为Properties类的过程中出错", fileName);
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("关闭【{}】文件输入流出错", fileName);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param fileName .xml文件名
     * @return xml文件解析出的Document
     */
    public Document readDocumentFromFile(String fileName){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File(fileName));
        } catch (DocumentException e) {
            log.error("文件【{}】解析报错DocumentException", fileName);
        }
        return document;
    }



    public static final String ERROR_MESSAGE_OF_FARMCONTROL_FIRST_CHECK = "不符合能管的关键配置文件校验的第一项：【功率曲线的配置】";
    public static final String ERROR_MESSAGE_OF_FARMCONTROL_SECOND_CHECK = "不符合能管的关键配置文件校验的第二项：【agc avc 一次调频的配置】";
    public static final String ERROR_MESSAGE_OF_FARMCONTROL_THIRD_CHECK = "不符合能管的关键配置文件校验的第三项：【风机采集点  sany/settings/modbus-tags.xml】";
    public static final String ERROR_MESSAGE_OF_FARMCONTROL_FIFTH_CHECK = "不符合能管的关键配置文件校验的第五项：【并网点】";


    // 各文件路径application.properties、sany/settings/farmconfig.properties、sany/settings/channel.xml、sany/settings/iec-pubs.xml、sany/settings/modbus-pubs.xml、sany/settings/modbus-tags.xml、sany/settings/iec-tags.xml
    public static final String APPLICATION_FILE_NAME = "application.properties";
    public static final String FARMCONFIG_FILE_NAME = "sany/settings/farmconfig.properties";
    public static final String CHANNEL_FILE_NAME = "sany/settings/channel.xml";
    public static final String IEC_PUBS_FILE_NAME = "sany/settings/iec-pubs.xml";
    public static final String IEC_TAGS_FILE_NAME = "sany/settings/iec-tags.xml";
    public static final String MODBUS_PUBS_FILE_NAME = "sany/settings/modbus-pubs.xml";
    public static final String MODBUS_TAGS_FILE_NAME = "sany/settings/modbus-tags.xml";

    // sany/settings/channel.xml文件各节点和属性
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2 = "channels2";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL = "channel";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ATTRIBUTE_ID = "id";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ATTRIBUTE_DEVICEUNIKEY = "deviceUniKey";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ATTRIBUTE_ROLE = "role";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ATTRIBUTE_PROTOCOLTYPE = "protocolType";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ENDPOINTS = "endPoints";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ENDPOINTS_ENDPOINT = "endPoint";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ENDPOINTS_ENDPOINT_ATTRIBUTE_TEMPLATENAME = "templateName";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL_ENDPOINTS_ENDPOINT_ATTRIBUTE_PROTOCOLTYPE = "protocolType";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2 = "channel2";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_ID = "id";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_DEVICEUNIKEY = "deviceUniKey";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_ROLE = "role";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ATTRIBUTE_PROTOCOLTYPE = "protocolType";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS = "endPoints";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT = "endPoint";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT_ATTRIBUTE_TEMPLATENAME = "templateName";
    public static final String CHANNEL_XML_CHANNELSETTINGS_CHANNELS2_CHANNEL2_ENDPOINTS_ENDPOINT_ATTRIBUTE_PROTOCOLTYPE = "protocolType";

    // sany/settings/iec-pubs.xml文件各节点和属性
    public static final String IEC_PUBS_IEC104PUBLISHINFO_TAGS = "tags";
    public static final String IEC_PUBS_IEC104PUBLISHINFO_TAGS_ATTRIBUTE_ID = "id";
    public static final String IEC_PUBS_IEC104PUBLISHINFO_TAGS_GROUP = "Group";
    public static final String IEC_PUBS_IEC104PUBLISHINFO_TAGS_GROUP_ITEM = "item";
    public static final String IEC_PUBS_IEC104PUBLISHINFO_TAGS_GROUP_ITEM_ATTRIBUTE_ALIAS = "alias";
    public static final String IEC_PUBS_IEC104PUBLISHINFO_TAGS_GROUP_ITEM_ATTRIBUTE_KEY = "key";

    // sany/settings/modbus-pubs.xml文件各节点和属性
    public static final String MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS = "tags";
    public static final String MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_ATTRIBUTE_ID = "id";
    public static final String MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS = "segments";
    public static final String MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS_SEGMENT = "segment";
    public static final String MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS_SEGMENT_IOTAG = "ioTag";
    public static final String MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS_SEGMENT_IOTAG_ATTRIBUTE_ALIAS = "alias";
    public static final String MODBUS_PUBS_MODBUSPUBLISHINFO_TAGS_SEGMENTS_SEGMENT_IOTAG_ATTRIBUTE_STOREKEY = "storeKey";

    // sany/settings/modbus-tags.xml文件各节点和属性
    public static final String MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS = "tags";
    public static final String MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_ATTRIBUTE_ID = "id";
    public static final String MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT = "segment";
    public static final String MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT_IOTAG = "ioTag";
    public static final String MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT_IOTAG_ATTRIBUTE_NAME = "name";
    public static final String MODBUS_TAGS_XML_MODBUSTAGSINFO_TAGS_SEGMENT_IOTAG_ATTRIBUTE_DESC = "desc";

    // sany/settings/iec-tags.xml文件各节点和属性
    public static final String IEC_TAGS_XML_IEC104TAGSINFO_TAGS = "tags";
    public static final String IEC_TAGS_XML_IEC104TAGSINFO_TAGS_ATTRIBUTE_ID = "id";
    public static final String IEC_TAGS_XML_IEC104TAGSINFO_TAGS_IEC104ITEMS = "IEC104Items";
    public static final String IEC_TAGS_XML_IEC104TAGSINFO_TAGS_IEC104ITEMS_ITEM = "item";
    public static final String IEC_TAGS_XML_IEC104TAGSINFO_TAGS_IEC104ITEMS_ITEM_ATTRIBUTE_NAME = "name";


    public static final String COLON = ":";
    public static final String COMMA = ",";
    public static final String EMPTY_STRING = "";

    // 1.功率曲线的配置
    public static final String SANY_FARM_TURBINE_TYPE = "sany.farm.turbine.type";
    public static final String SANY_FARM_TURBINE_POWERCURVE = "sany.farm.turbine.powerCurve.";

    // 2.agc avc 一次调频的配置
    public static final String EMS = "ems";
    public static final String GRIDCOMMANDLISTENER_AGC = "gridCommandListener.agc";
    public static final String GRIDCOMMANDLISTENER_AVC = "gridCommandListener.avc";
    public static final String GRIDCOMMANDLISTENER_PRIMARY = "gridCommandListener.primary";
    public static final String YT_F = "yt-f";
    public static final String HOLDING_REGISTER = "HOLDING_REGISTER";


    // 3.风机采集点  sany/settings/modbus-tags.xml
    public static final String SANY_EMS_TURBINEMEASUREMENTS_KEYS = "sany.ems.turbineMeasurements.keys";
    public static final String SANY_EMS_RATEDPOWER = "sany.ems.ratedpower";
    public static final String COLLECTOR_OF_ROLE = "collector";
    public static final String C025 = "C025";
    public static final String VALUE_OF_DESC = "额定功率";
    public static final String MC016 = "MC016";


    // 5.并网点
    public static final String OUT_LINE_POWER_PROTOCOL = "gridCommandListener.outLinePowerProtocol";
    public static final String OUT_LINE_POWER_MODE = "gridCommandListener.outLinePowerMode";
    public static final String OUT_LINE_POWER = "gridCommandListener.outlinepower";
    public static final String OLP = "OLP";
    public static final String OutLinePower = "OutLinePower";
    public static final String IEC_104 = "IEC_104";
    public static final String MODBUS = "MODBUS";
    public static final String ONE_OF_STRING = "1";
}

package com.sany.mdm.entity;

public class Modbus {
    private Integer modbusId;

    private Integer pointId;

    private String registerAddr;

    private String pointDescription;

    private String variableName;

    private String registerType;

    private String switchAndFaultCodeMark;

    private String switch0Escape;

    private String switch1Escape;

    private String switchNormalValue;

    private String faultCode;

    private String brakeNo;

    private String alarmLevel;

    private String partBelongs;

    private String coefficientAnalog;

    private String precisionAnalog;

    private String dataTypeAnalog;

    private String unitAnalog;

    private String upperLimitAnalog;

    private String lowerLimitAnalog;

    private String faultWordFlag;

    private String variableNameEn;

    private String variablePlc;

    private String partBelongsSecond;

    private String variableGroup;

    private String dictDesc;

    private String scadaDispalyDigit;

    private String partVariableMajorLevel;

    private String scadaClass;

    private String scadaDisplayLevel;

    private String simpleDescCn;

    private String coefficientUnit;

    private String overLimitStyle;

    private String switch0Style;

    private String switch1Style;

    private String calculationType;

    private String resampleType;

    private String iecXbWebDisplay;

    private String iecXbControlValue;

    private String iecXbButtonName;

    private String offSet;

    private String channelUuid;

    private Integer channelVersion;

    public Integer getModbusId() {
        return modbusId;
    }

    public void setModbusId(Integer modbusId) {
        this.modbusId = modbusId;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public String getRegisterAddr() {
        return registerAddr;
    }

    public void setRegisterAddr(String registerAddr) {
        this.registerAddr = registerAddr == null ? null : registerAddr.trim();
    }

    public String getPointDescription() {
        return pointDescription;
    }

    public void setPointDescription(String pointDescription) {
        this.pointDescription = pointDescription == null ? null : pointDescription.trim();
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName == null ? null : variableName.trim();
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType == null ? null : registerType.trim();
    }

    public String getSwitchAndFaultCodeMark() {
        return switchAndFaultCodeMark;
    }

    public void setSwitchAndFaultCodeMark(String switchAndFaultCodeMark) {
        this.switchAndFaultCodeMark = switchAndFaultCodeMark == null ? null : switchAndFaultCodeMark.trim();
    }

    public String getSwitch0Escape() {
        return switch0Escape;
    }

    public void setSwitch0Escape(String switch0Escape) {
        this.switch0Escape = switch0Escape == null ? null : switch0Escape.trim();
    }

    public String getSwitch1Escape() {
        return switch1Escape;
    }

    public void setSwitch1Escape(String switch1Escape) {
        this.switch1Escape = switch1Escape == null ? null : switch1Escape.trim();
    }

    public String getSwitchNormalValue() {
        return switchNormalValue;
    }

    public void setSwitchNormalValue(String switchNormalValue) {
        this.switchNormalValue = switchNormalValue == null ? null : switchNormalValue.trim();
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode == null ? null : faultCode.trim();
    }

    public String getBrakeNo() {
        return brakeNo;
    }

    public void setBrakeNo(String brakeNo) {
        this.brakeNo = brakeNo == null ? null : brakeNo.trim();
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel == null ? null : alarmLevel.trim();
    }

    public String getPartBelongs() {
        return partBelongs;
    }

    public void setPartBelongs(String partBelongs) {
        this.partBelongs = partBelongs == null ? null : partBelongs.trim();
    }

    public String getCoefficientAnalog() {
        return coefficientAnalog;
    }

    public void setCoefficientAnalog(String coefficientAnalog) {
        this.coefficientAnalog = coefficientAnalog == null ? null : coefficientAnalog.trim();
    }

    public String getPrecisionAnalog() {
        return precisionAnalog;
    }

    public void setPrecisionAnalog(String precisionAnalog) {
        this.precisionAnalog = precisionAnalog == null ? null : precisionAnalog.trim();
    }

    public String getDataTypeAnalog() {
        return dataTypeAnalog;
    }

    public void setDataTypeAnalog(String dataTypeAnalog) {
        this.dataTypeAnalog = dataTypeAnalog == null ? null : dataTypeAnalog.trim();
    }

    public String getUnitAnalog() {
        return unitAnalog;
    }

    public void setUnitAnalog(String unitAnalog) {
        this.unitAnalog = unitAnalog == null ? null : unitAnalog.trim();
    }

    public String getUpperLimitAnalog() {
        return upperLimitAnalog;
    }

    public void setUpperLimitAnalog(String upperLimitAnalog) {
        this.upperLimitAnalog = upperLimitAnalog == null ? null : upperLimitAnalog.trim();
    }

    public String getLowerLimitAnalog() {
        return lowerLimitAnalog;
    }

    public void setLowerLimitAnalog(String lowerLimitAnalog) {
        this.lowerLimitAnalog = lowerLimitAnalog == null ? null : lowerLimitAnalog.trim();
    }

    public String getFaultWordFlag() {
        return faultWordFlag;
    }

    public void setFaultWordFlag(String faultWordFlag) {
        this.faultWordFlag = faultWordFlag == null ? null : faultWordFlag.trim();
    }

    public String getVariableNameEn() {
        return variableNameEn;
    }

    public void setVariableNameEn(String variableNameEn) {
        this.variableNameEn = variableNameEn == null ? null : variableNameEn.trim();
    }

    public String getVariablePlc() {
        return variablePlc;
    }

    public void setVariablePlc(String variablePlc) {
        this.variablePlc = variablePlc == null ? null : variablePlc.trim();
    }

    public String getPartBelongsSecond() {
        return partBelongsSecond;
    }

    public void setPartBelongsSecond(String partBelongsSecond) {
        this.partBelongsSecond = partBelongsSecond == null ? null : partBelongsSecond.trim();
    }

    public String getVariableGroup() {
        return variableGroup;
    }

    public void setVariableGroup(String variableGroup) {
        this.variableGroup = variableGroup == null ? null : variableGroup.trim();
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc == null ? null : dictDesc.trim();
    }

    public String getScadaDispalyDigit() {
        return scadaDispalyDigit;
    }

    public void setScadaDispalyDigit(String scadaDispalyDigit) {
        this.scadaDispalyDigit = scadaDispalyDigit == null ? null : scadaDispalyDigit.trim();
    }

    public String getPartVariableMajorLevel() {
        return partVariableMajorLevel;
    }

    public void setPartVariableMajorLevel(String partVariableMajorLevel) {
        this.partVariableMajorLevel = partVariableMajorLevel == null ? null : partVariableMajorLevel.trim();
    }

    public String getScadaClass() {
        return scadaClass;
    }

    public void setScadaClass(String scadaClass) {
        this.scadaClass = scadaClass == null ? null : scadaClass.trim();
    }

    public String getScadaDisplayLevel() {
        return scadaDisplayLevel;
    }

    public void setScadaDisplayLevel(String scadaDisplayLevel) {
        this.scadaDisplayLevel = scadaDisplayLevel == null ? null : scadaDisplayLevel.trim();
    }

    public String getSimpleDescCn() {
        return simpleDescCn;
    }

    public void setSimpleDescCn(String simpleDescCn) {
        this.simpleDescCn = simpleDescCn == null ? null : simpleDescCn.trim();
    }

    public String getCoefficientUnit() {
        return coefficientUnit;
    }

    public void setCoefficientUnit(String coefficientUnit) {
        this.coefficientUnit = coefficientUnit == null ? null : coefficientUnit.trim();
    }

    public String getOverLimitStyle() {
        return overLimitStyle;
    }

    public void setOverLimitStyle(String overLimitStyle) {
        this.overLimitStyle = overLimitStyle == null ? null : overLimitStyle.trim();
    }

    public String getSwitch0Style() {
        return switch0Style;
    }

    public void setSwitch0Style(String switch0Style) {
        this.switch0Style = switch0Style == null ? null : switch0Style.trim();
    }

    public String getSwitch1Style() {
        return switch1Style;
    }

    public void setSwitch1Style(String switch1Style) {
        this.switch1Style = switch1Style == null ? null : switch1Style.trim();
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType == null ? null : calculationType.trim();
    }

    public String getResampleType() {
        return resampleType;
    }

    public void setResampleType(String resampleType) {
        this.resampleType = resampleType == null ? null : resampleType.trim();
    }

    public String getIecXbWebDisplay() {
        return iecXbWebDisplay;
    }

    public void setIecXbWebDisplay(String iecXbWebDisplay) {
        this.iecXbWebDisplay = iecXbWebDisplay == null ? null : iecXbWebDisplay.trim();
    }

    public String getIecXbControlValue() {
        return iecXbControlValue;
    }

    public void setIecXbControlValue(String iecXbControlValue) {
        this.iecXbControlValue = iecXbControlValue == null ? null : iecXbControlValue.trim();
    }

    public String getIecXbButtonName() {
        return iecXbButtonName;
    }

    public void setIecXbButtonName(String iecXbButtonName) {
        this.iecXbButtonName = iecXbButtonName == null ? null : iecXbButtonName.trim();
    }

    public String getOffSet() {
        return offSet;
    }

    public void setOffSet(String offSet) {
        this.offSet = offSet == null ? null : offSet.trim();
    }

    public String getChannelUuid() {
        return channelUuid;
    }

    public void setChannelUuid(String channelUuid) {
        this.channelUuid = channelUuid == null ? null : channelUuid.trim();
    }

    public Integer getChannelVersion() {
        return channelVersion;
    }

    public void setChannelVersion(Integer channelVersion) {
        this.channelVersion = channelVersion;
    }
}
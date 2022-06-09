package com.sany.mdm.entity;

import java.util.Date;

public class Channel {
    private Integer id;

    private String channelUuid;

    private Integer channelVersion;

    private String registerType;

    private String variableName;

    private String pointDescription;

    private String variableNameEn;

    private String registerAddr;

    private String variablePlc;

    private String partBelongs;

    private String partBelongsSecond;

    private String variableGroup;

    private String switchAndFaultCodeMark;

    private String faultCode;

    private String alarmLevel;

    private String brakeNo;

    private String switch0Escape;

    private String switch1Escape;

    private String dataTypeAnalog;

    private String unitAnalog;

    private String dictDesc;

    private String upperLimitAnalog;

    private String lowerLimitAnalog;

    private String precisionAnalog;

    private String scadaDispalyDigit;

    private String partVariableMajorLevel;

    private String scadaClass;

    private String scadaDisplayLevel;

    private String simpleDescCn;

    private String coefficientAnalog;

    private String coefficientUnit;

    private String overLimitStyle;

    private String switch0Style;

    private String switch1Style;

    private String calculationType;

    private String resampleType;

    private String ty;

    private String v2x;

    private String v3x;

    private String v5x1;

    private String v5x2;

    private String remark;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType == null ? null : registerType.trim();
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName == null ? null : variableName.trim();
    }

    public String getPointDescription() {
        return pointDescription;
    }

    public void setPointDescription(String pointDescription) {
        this.pointDescription = pointDescription == null ? null : pointDescription.trim();
    }

    public String getVariableNameEn() {
        return variableNameEn;
    }

    public void setVariableNameEn(String variableNameEn) {
        this.variableNameEn = variableNameEn == null ? null : variableNameEn.trim();
    }

    public String getRegisterAddr() {
        return registerAddr;
    }

    public void setRegisterAddr(String registerAddr) {
        this.registerAddr = registerAddr == null ? null : registerAddr.trim();
    }

    public String getVariablePlc() {
        return variablePlc;
    }

    public void setVariablePlc(String variablePlc) {
        this.variablePlc = variablePlc == null ? null : variablePlc.trim();
    }

    public String getPartBelongs() {
        return partBelongs;
    }

    public void setPartBelongs(String partBelongs) {
        this.partBelongs = partBelongs == null ? null : partBelongs.trim();
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

    public String getSwitchAndFaultCodeMark() {
        return switchAndFaultCodeMark;
    }

    public void setSwitchAndFaultCodeMark(String switchAndFaultCodeMark) {
        this.switchAndFaultCodeMark = switchAndFaultCodeMark == null ? null : switchAndFaultCodeMark.trim();
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode == null ? null : faultCode.trim();
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel == null ? null : alarmLevel.trim();
    }

    public String getBrakeNo() {
        return brakeNo;
    }

    public void setBrakeNo(String brakeNo) {
        this.brakeNo = brakeNo == null ? null : brakeNo.trim();
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

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc == null ? null : dictDesc.trim();
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

    public String getPrecisionAnalog() {
        return precisionAnalog;
    }

    public void setPrecisionAnalog(String precisionAnalog) {
        this.precisionAnalog = precisionAnalog == null ? null : precisionAnalog.trim();
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

    public String getCoefficientAnalog() {
        return coefficientAnalog;
    }

    public void setCoefficientAnalog(String coefficientAnalog) {
        this.coefficientAnalog = coefficientAnalog == null ? null : coefficientAnalog.trim();
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

    public String getTy() {
        return ty;
    }

    public void setTy(String ty) {
        this.ty = ty == null ? null : ty.trim();
    }

    public String getV2x() {
        return v2x;
    }

    public void setV2x(String v2x) {
        this.v2x = v2x == null ? null : v2x.trim();
    }

    public String getV3x() {
        return v3x;
    }

    public void setV3x(String v3x) {
        this.v3x = v3x == null ? null : v3x.trim();
    }

    public String getV5x1() {
        return v5x1;
    }

    public void setV5x1(String v5x1) {
        this.v5x1 = v5x1 == null ? null : v5x1.trim();
    }

    public String getV5x2() {
        return v5x2;
    }

    public void setV5x2(String v5x2) {
        this.v5x2 = v5x2 == null ? null : v5x2.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}
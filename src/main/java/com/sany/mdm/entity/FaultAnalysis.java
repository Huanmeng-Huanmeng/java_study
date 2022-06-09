package com.sany.mdm.entity;

import java.util.Date;

public class FaultAnalysis {
    private Integer id;

    private String faultAnalysisUuid;

    private String pointUuid;

    private Integer webPageShow;

    private String variableName;

    private String serialNumber;

    private String faultCode;

    private String faultDescription;

    private String analysisRulesName;

    private String brakeNo;

    private String alarmLevel;

    private String partName;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFaultAnalysisUuid() {
        return faultAnalysisUuid;
    }

    public void setFaultAnalysisUuid(String faultAnalysisUuid) {
        this.faultAnalysisUuid = faultAnalysisUuid == null ? null : faultAnalysisUuid.trim();
    }

    public String getPointUuid() {
        return pointUuid;
    }

    public void setPointUuid(String pointUuid) {
        this.pointUuid = pointUuid == null ? null : pointUuid.trim();
    }

    public Integer getWebPageShow() {
        return webPageShow;
    }

    public void setWebPageShow(Integer webPageShow) {
        this.webPageShow = webPageShow;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName == null ? null : variableName.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode == null ? null : faultCode.trim();
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription == null ? null : faultDescription.trim();
    }

    public String getAnalysisRulesName() {
        return analysisRulesName;
    }

    public void setAnalysisRulesName(String analysisRulesName) {
        this.analysisRulesName = analysisRulesName == null ? null : analysisRulesName.trim();
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

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName == null ? null : partName.trim();
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
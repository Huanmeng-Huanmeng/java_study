package com.sany.mdm.entity;

import java.util.Date;

public class PlcPartClass {
    private Integer id;

    private String plcPartClassUuid;

    private String pointUuid;

    private Integer partDisplayOrder;

    private String scadaPartClass;

    private String masterControlPartClass;

    private String fullEnglishName;

    private String englishAbbreviations;

    private String remark;

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

    public String getPlcPartClassUuid() {
        return plcPartClassUuid;
    }

    public void setPlcPartClassUuid(String plcPartClassUuid) {
        this.plcPartClassUuid = plcPartClassUuid == null ? null : plcPartClassUuid.trim();
    }

    public String getPointUuid() {
        return pointUuid;
    }

    public void setPointUuid(String pointUuid) {
        this.pointUuid = pointUuid == null ? null : pointUuid.trim();
    }

    public Integer getPartDisplayOrder() {
        return partDisplayOrder;
    }

    public void setPartDisplayOrder(Integer partDisplayOrder) {
        this.partDisplayOrder = partDisplayOrder;
    }

    public String getScadaPartClass() {
        return scadaPartClass;
    }

    public void setScadaPartClass(String scadaPartClass) {
        this.scadaPartClass = scadaPartClass == null ? null : scadaPartClass.trim();
    }

    public String getMasterControlPartClass() {
        return masterControlPartClass;
    }

    public void setMasterControlPartClass(String masterControlPartClass) {
        this.masterControlPartClass = masterControlPartClass == null ? null : masterControlPartClass.trim();
    }

    public String getFullEnglishName() {
        return fullEnglishName;
    }

    public void setFullEnglishName(String fullEnglishName) {
        this.fullEnglishName = fullEnglishName == null ? null : fullEnglishName.trim();
    }

    public String getEnglishAbbreviations() {
        return englishAbbreviations;
    }

    public void setEnglishAbbreviations(String englishAbbreviations) {
        this.englishAbbreviations = englishAbbreviations == null ? null : englishAbbreviations.trim();
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
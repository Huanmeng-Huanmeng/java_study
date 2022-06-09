package com.study.doc.xlsx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CmsFaultFrequencyTest {
    private Integer id;

    private String partAscription;

    private String partAttributeName;

    private String faultType;

    private Float faultFrequency;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartAscription() {
        return partAscription;
    }

    public void setPartAscription(String partAscription) {
        this.partAscription = partAscription == null ? null : partAscription.trim();
    }

    public String getPartAttributeName() {
        return partAttributeName;
    }

    public void setPartAttributeName(String partAttributeName) {
        this.partAttributeName = partAttributeName == null ? null : partAttributeName.trim();
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType == null ? null : faultType.trim();
    }

    public Float getFaultFrequency() {
        return faultFrequency;
    }

    public void setFaultFrequency(Float faultFrequency) {
        this.faultFrequency = faultFrequency;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
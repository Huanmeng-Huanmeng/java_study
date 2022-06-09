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
public class PointMappingTest {
    private Integer id;

    private String pinyinCode;

    private String turbineName;

    private String originalPointName;

    private String targetPointName;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode == null ? null : pinyinCode.trim();
    }

    public String getTurbineName() {
        return turbineName;
    }

    public void setTurbineName(String turbineName) {
        this.turbineName = turbineName == null ? null : turbineName.trim();
    }

    public String getOriginalPointName() {
        return originalPointName;
    }

    public void setOriginalPointName(String originalPointName) {
        this.originalPointName = originalPointName == null ? null : originalPointName.trim();
    }

    public String getTargetPointName() {
        return targetPointName;
    }

    public void setTargetPointName(String targetPointName) {
        this.targetPointName = targetPointName == null ? null : targetPointName.trim();
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
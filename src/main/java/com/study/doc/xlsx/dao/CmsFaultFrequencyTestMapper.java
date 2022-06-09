package com.study.doc.xlsx.dao;

import com.study.doc.xlsx.entity.CmsFaultFrequencyTest;

public interface CmsFaultFrequencyTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CmsFaultFrequencyTest record);

    int insertSelective(CmsFaultFrequencyTest record);

    CmsFaultFrequencyTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CmsFaultFrequencyTest record);

    int updateByPrimaryKey(CmsFaultFrequencyTest record);
}
package com.study.doc.xlsx.dao;

import com.study.doc.xlsx.entity.PointMappingTest;

public interface PointMappingTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PointMappingTest record);

    int insertSelective(PointMappingTest record);

    PointMappingTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointMappingTest record);

    int updateByPrimaryKey(PointMappingTest record);
}
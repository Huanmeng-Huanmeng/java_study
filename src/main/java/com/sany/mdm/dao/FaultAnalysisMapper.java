package com.sany.mdm.dao;

import com.sany.mdm.entity.FaultAnalysis;

public interface FaultAnalysisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FaultAnalysis record);

    int insertSelective(FaultAnalysis record);

    FaultAnalysis selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FaultAnalysis record);

    int updateByPrimaryKey(FaultAnalysis record);
}
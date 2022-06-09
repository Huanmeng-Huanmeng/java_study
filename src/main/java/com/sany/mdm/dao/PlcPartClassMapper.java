package com.sany.mdm.dao;

import com.sany.mdm.entity.PlcPartClass;

public interface PlcPartClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlcPartClass record);

    int insertSelective(PlcPartClass record);

    PlcPartClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlcPartClass record);

    int updateByPrimaryKey(PlcPartClass record);
}
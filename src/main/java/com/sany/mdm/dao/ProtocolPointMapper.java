package com.sany.mdm.dao;

import com.sany.mdm.entity.ProtocolPoint;
import com.sany.mdm.entity.ProtocolPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProtocolPointMapper {
    int countByExample(ProtocolPointExample example);

    int deleteByExample(ProtocolPointExample example);

    int deleteByPrimaryKey(Integer pointId);

    int insert(ProtocolPoint record);

    int insertSelective(ProtocolPoint record);

    List<ProtocolPoint> selectByExample(ProtocolPointExample example);

    ProtocolPoint selectByPrimaryKey(Integer pointId);

    int updateByExampleSelective(@Param("record") ProtocolPoint record, @Param("example") ProtocolPointExample example);

    int updateByExample(@Param("record") ProtocolPoint record, @Param("example") ProtocolPointExample example);

    int updateByPrimaryKeySelective(ProtocolPoint record);

    int updateByPrimaryKey(ProtocolPoint record);
}
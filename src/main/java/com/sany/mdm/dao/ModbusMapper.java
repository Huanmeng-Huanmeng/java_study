package com.sany.mdm.dao;

import com.sany.mdm.entity.Modbus;
import com.sany.mdm.entity.ModbusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModbusMapper {
    int countByExample(ModbusExample example);

    int deleteByExample(ModbusExample example);

    int deleteByPrimaryKey(Integer modbusId);

    int insert(Modbus record);

    int insertSelective(Modbus record);

    List<Modbus> selectByExample(ModbusExample example);

    Modbus selectByPrimaryKey(Integer modbusId);

    int updateByExampleSelective(@Param("record") Modbus record, @Param("example") ModbusExample example);

    int updateByExample(@Param("record") Modbus record, @Param("example") ModbusExample example);

    int updateByPrimaryKeySelective(Modbus record);

    int updateByPrimaryKey(Modbus record);
}
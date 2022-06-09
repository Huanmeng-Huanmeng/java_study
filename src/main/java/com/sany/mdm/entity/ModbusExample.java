package com.sany.mdm.entity;

import java.util.ArrayList;
import java.util.List;

public class ModbusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModbusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andModbusIdIsNull() {
            addCriterion("modbus_id is null");
            return (Criteria) this;
        }

        public Criteria andModbusIdIsNotNull() {
            addCriterion("modbus_id is not null");
            return (Criteria) this;
        }

        public Criteria andModbusIdEqualTo(Integer value) {
            addCriterion("modbus_id =", value, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdNotEqualTo(Integer value) {
            addCriterion("modbus_id <>", value, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdGreaterThan(Integer value) {
            addCriterion("modbus_id >", value, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("modbus_id >=", value, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdLessThan(Integer value) {
            addCriterion("modbus_id <", value, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdLessThanOrEqualTo(Integer value) {
            addCriterion("modbus_id <=", value, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdIn(List<Integer> values) {
            addCriterion("modbus_id in", values, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdNotIn(List<Integer> values) {
            addCriterion("modbus_id not in", values, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdBetween(Integer value1, Integer value2) {
            addCriterion("modbus_id between", value1, value2, "modbusId");
            return (Criteria) this;
        }

        public Criteria andModbusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("modbus_id not between", value1, value2, "modbusId");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNull() {
            addCriterion("point_id is null");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNotNull() {
            addCriterion("point_id is not null");
            return (Criteria) this;
        }

        public Criteria andPointIdEqualTo(Integer value) {
            addCriterion("point_id =", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotEqualTo(Integer value) {
            addCriterion("point_id <>", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThan(Integer value) {
            addCriterion("point_id >", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("point_id >=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThan(Integer value) {
            addCriterion("point_id <", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("point_id <=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdIn(List<Integer> values) {
            addCriterion("point_id in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotIn(List<Integer> values) {
            addCriterion("point_id not in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdBetween(Integer value1, Integer value2) {
            addCriterion("point_id between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("point_id not between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrIsNull() {
            addCriterion("register_addr is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrIsNotNull() {
            addCriterion("register_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrEqualTo(String value) {
            addCriterion("register_addr =", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrNotEqualTo(String value) {
            addCriterion("register_addr <>", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrGreaterThan(String value) {
            addCriterion("register_addr >", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrGreaterThanOrEqualTo(String value) {
            addCriterion("register_addr >=", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrLessThan(String value) {
            addCriterion("register_addr <", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrLessThanOrEqualTo(String value) {
            addCriterion("register_addr <=", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrLike(String value) {
            addCriterion("register_addr like", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrNotLike(String value) {
            addCriterion("register_addr not like", value, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrIn(List<String> values) {
            addCriterion("register_addr in", values, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrNotIn(List<String> values) {
            addCriterion("register_addr not in", values, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrBetween(String value1, String value2) {
            addCriterion("register_addr between", value1, value2, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andRegisterAddrNotBetween(String value1, String value2) {
            addCriterion("register_addr not between", value1, value2, "registerAddr");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionIsNull() {
            addCriterion("point_description is null");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionIsNotNull() {
            addCriterion("point_description is not null");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionEqualTo(String value) {
            addCriterion("point_description =", value, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionNotEqualTo(String value) {
            addCriterion("point_description <>", value, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionGreaterThan(String value) {
            addCriterion("point_description >", value, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("point_description >=", value, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionLessThan(String value) {
            addCriterion("point_description <", value, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionLessThanOrEqualTo(String value) {
            addCriterion("point_description <=", value, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionLike(String value) {
            addCriterion("point_description like", value, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionNotLike(String value) {
            addCriterion("point_description not like", value, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionIn(List<String> values) {
            addCriterion("point_description in", values, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionNotIn(List<String> values) {
            addCriterion("point_description not in", values, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionBetween(String value1, String value2) {
            addCriterion("point_description between", value1, value2, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andPointDescriptionNotBetween(String value1, String value2) {
            addCriterion("point_description not between", value1, value2, "pointDescription");
            return (Criteria) this;
        }

        public Criteria andVariableNameIsNull() {
            addCriterion("variable_name is null");
            return (Criteria) this;
        }

        public Criteria andVariableNameIsNotNull() {
            addCriterion("variable_name is not null");
            return (Criteria) this;
        }

        public Criteria andVariableNameEqualTo(String value) {
            addCriterion("variable_name =", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameNotEqualTo(String value) {
            addCriterion("variable_name <>", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameGreaterThan(String value) {
            addCriterion("variable_name >", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameGreaterThanOrEqualTo(String value) {
            addCriterion("variable_name >=", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameLessThan(String value) {
            addCriterion("variable_name <", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameLessThanOrEqualTo(String value) {
            addCriterion("variable_name <=", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameLike(String value) {
            addCriterion("variable_name like", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameNotLike(String value) {
            addCriterion("variable_name not like", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameIn(List<String> values) {
            addCriterion("variable_name in", values, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameNotIn(List<String> values) {
            addCriterion("variable_name not in", values, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameBetween(String value1, String value2) {
            addCriterion("variable_name between", value1, value2, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameNotBetween(String value1, String value2) {
            addCriterion("variable_name not between", value1, value2, "variableName");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIsNull() {
            addCriterion("register_type is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIsNotNull() {
            addCriterion("register_type is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeEqualTo(String value) {
            addCriterion("register_type =", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotEqualTo(String value) {
            addCriterion("register_type <>", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeGreaterThan(String value) {
            addCriterion("register_type >", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("register_type >=", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeLessThan(String value) {
            addCriterion("register_type <", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeLessThanOrEqualTo(String value) {
            addCriterion("register_type <=", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeLike(String value) {
            addCriterion("register_type like", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotLike(String value) {
            addCriterion("register_type not like", value, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeIn(List<String> values) {
            addCriterion("register_type in", values, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotIn(List<String> values) {
            addCriterion("register_type not in", values, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeBetween(String value1, String value2) {
            addCriterion("register_type between", value1, value2, "registerType");
            return (Criteria) this;
        }

        public Criteria andRegisterTypeNotBetween(String value1, String value2) {
            addCriterion("register_type not between", value1, value2, "registerType");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkIsNull() {
            addCriterion("switch_and_fault_code_mark is null");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkIsNotNull() {
            addCriterion("switch_and_fault_code_mark is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkEqualTo(String value) {
            addCriterion("switch_and_fault_code_mark =", value, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkNotEqualTo(String value) {
            addCriterion("switch_and_fault_code_mark <>", value, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkGreaterThan(String value) {
            addCriterion("switch_and_fault_code_mark >", value, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkGreaterThanOrEqualTo(String value) {
            addCriterion("switch_and_fault_code_mark >=", value, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkLessThan(String value) {
            addCriterion("switch_and_fault_code_mark <", value, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkLessThanOrEqualTo(String value) {
            addCriterion("switch_and_fault_code_mark <=", value, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkLike(String value) {
            addCriterion("switch_and_fault_code_mark like", value, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkNotLike(String value) {
            addCriterion("switch_and_fault_code_mark not like", value, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkIn(List<String> values) {
            addCriterion("switch_and_fault_code_mark in", values, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkNotIn(List<String> values) {
            addCriterion("switch_and_fault_code_mark not in", values, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkBetween(String value1, String value2) {
            addCriterion("switch_and_fault_code_mark between", value1, value2, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitchAndFaultCodeMarkNotBetween(String value1, String value2) {
            addCriterion("switch_and_fault_code_mark not between", value1, value2, "switchAndFaultCodeMark");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeIsNull() {
            addCriterion("switch0_escape is null");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeIsNotNull() {
            addCriterion("switch0_escape is not null");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeEqualTo(String value) {
            addCriterion("switch0_escape =", value, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeNotEqualTo(String value) {
            addCriterion("switch0_escape <>", value, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeGreaterThan(String value) {
            addCriterion("switch0_escape >", value, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeGreaterThanOrEqualTo(String value) {
            addCriterion("switch0_escape >=", value, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeLessThan(String value) {
            addCriterion("switch0_escape <", value, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeLessThanOrEqualTo(String value) {
            addCriterion("switch0_escape <=", value, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeLike(String value) {
            addCriterion("switch0_escape like", value, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeNotLike(String value) {
            addCriterion("switch0_escape not like", value, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeIn(List<String> values) {
            addCriterion("switch0_escape in", values, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeNotIn(List<String> values) {
            addCriterion("switch0_escape not in", values, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeBetween(String value1, String value2) {
            addCriterion("switch0_escape between", value1, value2, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch0EscapeNotBetween(String value1, String value2) {
            addCriterion("switch0_escape not between", value1, value2, "switch0Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeIsNull() {
            addCriterion("switch1_escape is null");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeIsNotNull() {
            addCriterion("switch1_escape is not null");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeEqualTo(String value) {
            addCriterion("switch1_escape =", value, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeNotEqualTo(String value) {
            addCriterion("switch1_escape <>", value, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeGreaterThan(String value) {
            addCriterion("switch1_escape >", value, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeGreaterThanOrEqualTo(String value) {
            addCriterion("switch1_escape >=", value, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeLessThan(String value) {
            addCriterion("switch1_escape <", value, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeLessThanOrEqualTo(String value) {
            addCriterion("switch1_escape <=", value, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeLike(String value) {
            addCriterion("switch1_escape like", value, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeNotLike(String value) {
            addCriterion("switch1_escape not like", value, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeIn(List<String> values) {
            addCriterion("switch1_escape in", values, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeNotIn(List<String> values) {
            addCriterion("switch1_escape not in", values, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeBetween(String value1, String value2) {
            addCriterion("switch1_escape between", value1, value2, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitch1EscapeNotBetween(String value1, String value2) {
            addCriterion("switch1_escape not between", value1, value2, "switch1Escape");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueIsNull() {
            addCriterion("switch_normal_value is null");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueIsNotNull() {
            addCriterion("switch_normal_value is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueEqualTo(String value) {
            addCriterion("switch_normal_value =", value, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueNotEqualTo(String value) {
            addCriterion("switch_normal_value <>", value, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueGreaterThan(String value) {
            addCriterion("switch_normal_value >", value, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueGreaterThanOrEqualTo(String value) {
            addCriterion("switch_normal_value >=", value, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueLessThan(String value) {
            addCriterion("switch_normal_value <", value, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueLessThanOrEqualTo(String value) {
            addCriterion("switch_normal_value <=", value, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueLike(String value) {
            addCriterion("switch_normal_value like", value, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueNotLike(String value) {
            addCriterion("switch_normal_value not like", value, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueIn(List<String> values) {
            addCriterion("switch_normal_value in", values, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueNotIn(List<String> values) {
            addCriterion("switch_normal_value not in", values, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueBetween(String value1, String value2) {
            addCriterion("switch_normal_value between", value1, value2, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andSwitchNormalValueNotBetween(String value1, String value2) {
            addCriterion("switch_normal_value not between", value1, value2, "switchNormalValue");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIsNull() {
            addCriterion("fault_code is null");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIsNotNull() {
            addCriterion("fault_code is not null");
            return (Criteria) this;
        }

        public Criteria andFaultCodeEqualTo(String value) {
            addCriterion("fault_code =", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotEqualTo(String value) {
            addCriterion("fault_code <>", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeGreaterThan(String value) {
            addCriterion("fault_code >", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fault_code >=", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLessThan(String value) {
            addCriterion("fault_code <", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLessThanOrEqualTo(String value) {
            addCriterion("fault_code <=", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLike(String value) {
            addCriterion("fault_code like", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotLike(String value) {
            addCriterion("fault_code not like", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIn(List<String> values) {
            addCriterion("fault_code in", values, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotIn(List<String> values) {
            addCriterion("fault_code not in", values, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeBetween(String value1, String value2) {
            addCriterion("fault_code between", value1, value2, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotBetween(String value1, String value2) {
            addCriterion("fault_code not between", value1, value2, "faultCode");
            return (Criteria) this;
        }

        public Criteria andBrakeNoIsNull() {
            addCriterion("brake_no is null");
            return (Criteria) this;
        }

        public Criteria andBrakeNoIsNotNull() {
            addCriterion("brake_no is not null");
            return (Criteria) this;
        }

        public Criteria andBrakeNoEqualTo(String value) {
            addCriterion("brake_no =", value, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoNotEqualTo(String value) {
            addCriterion("brake_no <>", value, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoGreaterThan(String value) {
            addCriterion("brake_no >", value, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoGreaterThanOrEqualTo(String value) {
            addCriterion("brake_no >=", value, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoLessThan(String value) {
            addCriterion("brake_no <", value, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoLessThanOrEqualTo(String value) {
            addCriterion("brake_no <=", value, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoLike(String value) {
            addCriterion("brake_no like", value, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoNotLike(String value) {
            addCriterion("brake_no not like", value, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoIn(List<String> values) {
            addCriterion("brake_no in", values, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoNotIn(List<String> values) {
            addCriterion("brake_no not in", values, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoBetween(String value1, String value2) {
            addCriterion("brake_no between", value1, value2, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andBrakeNoNotBetween(String value1, String value2) {
            addCriterion("brake_no not between", value1, value2, "brakeNo");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIsNull() {
            addCriterion("alarm_level is null");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIsNotNull() {
            addCriterion("alarm_level is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelEqualTo(String value) {
            addCriterion("alarm_level =", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotEqualTo(String value) {
            addCriterion("alarm_level <>", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelGreaterThan(String value) {
            addCriterion("alarm_level >", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_level >=", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLessThan(String value) {
            addCriterion("alarm_level <", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLessThanOrEqualTo(String value) {
            addCriterion("alarm_level <=", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLike(String value) {
            addCriterion("alarm_level like", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotLike(String value) {
            addCriterion("alarm_level not like", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIn(List<String> values) {
            addCriterion("alarm_level in", values, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotIn(List<String> values) {
            addCriterion("alarm_level not in", values, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelBetween(String value1, String value2) {
            addCriterion("alarm_level between", value1, value2, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotBetween(String value1, String value2) {
            addCriterion("alarm_level not between", value1, value2, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andPartBelongsIsNull() {
            addCriterion("part_belongs is null");
            return (Criteria) this;
        }

        public Criteria andPartBelongsIsNotNull() {
            addCriterion("part_belongs is not null");
            return (Criteria) this;
        }

        public Criteria andPartBelongsEqualTo(String value) {
            addCriterion("part_belongs =", value, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsNotEqualTo(String value) {
            addCriterion("part_belongs <>", value, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsGreaterThan(String value) {
            addCriterion("part_belongs >", value, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsGreaterThanOrEqualTo(String value) {
            addCriterion("part_belongs >=", value, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsLessThan(String value) {
            addCriterion("part_belongs <", value, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsLessThanOrEqualTo(String value) {
            addCriterion("part_belongs <=", value, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsLike(String value) {
            addCriterion("part_belongs like", value, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsNotLike(String value) {
            addCriterion("part_belongs not like", value, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsIn(List<String> values) {
            addCriterion("part_belongs in", values, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsNotIn(List<String> values) {
            addCriterion("part_belongs not in", values, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsBetween(String value1, String value2) {
            addCriterion("part_belongs between", value1, value2, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andPartBelongsNotBetween(String value1, String value2) {
            addCriterion("part_belongs not between", value1, value2, "partBelongs");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogIsNull() {
            addCriterion("coefficient_analog is null");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogIsNotNull() {
            addCriterion("coefficient_analog is not null");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogEqualTo(String value) {
            addCriterion("coefficient_analog =", value, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogNotEqualTo(String value) {
            addCriterion("coefficient_analog <>", value, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogGreaterThan(String value) {
            addCriterion("coefficient_analog >", value, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogGreaterThanOrEqualTo(String value) {
            addCriterion("coefficient_analog >=", value, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogLessThan(String value) {
            addCriterion("coefficient_analog <", value, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogLessThanOrEqualTo(String value) {
            addCriterion("coefficient_analog <=", value, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogLike(String value) {
            addCriterion("coefficient_analog like", value, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogNotLike(String value) {
            addCriterion("coefficient_analog not like", value, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogIn(List<String> values) {
            addCriterion("coefficient_analog in", values, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogNotIn(List<String> values) {
            addCriterion("coefficient_analog not in", values, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogBetween(String value1, String value2) {
            addCriterion("coefficient_analog between", value1, value2, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andCoefficientAnalogNotBetween(String value1, String value2) {
            addCriterion("coefficient_analog not between", value1, value2, "coefficientAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogIsNull() {
            addCriterion("precision_analog is null");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogIsNotNull() {
            addCriterion("precision_analog is not null");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogEqualTo(String value) {
            addCriterion("precision_analog =", value, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogNotEqualTo(String value) {
            addCriterion("precision_analog <>", value, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogGreaterThan(String value) {
            addCriterion("precision_analog >", value, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogGreaterThanOrEqualTo(String value) {
            addCriterion("precision_analog >=", value, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogLessThan(String value) {
            addCriterion("precision_analog <", value, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogLessThanOrEqualTo(String value) {
            addCriterion("precision_analog <=", value, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogLike(String value) {
            addCriterion("precision_analog like", value, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogNotLike(String value) {
            addCriterion("precision_analog not like", value, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogIn(List<String> values) {
            addCriterion("precision_analog in", values, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogNotIn(List<String> values) {
            addCriterion("precision_analog not in", values, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogBetween(String value1, String value2) {
            addCriterion("precision_analog between", value1, value2, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andPrecisionAnalogNotBetween(String value1, String value2) {
            addCriterion("precision_analog not between", value1, value2, "precisionAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogIsNull() {
            addCriterion("data_type_analog is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogIsNotNull() {
            addCriterion("data_type_analog is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogEqualTo(String value) {
            addCriterion("data_type_analog =", value, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogNotEqualTo(String value) {
            addCriterion("data_type_analog <>", value, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogGreaterThan(String value) {
            addCriterion("data_type_analog >", value, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogGreaterThanOrEqualTo(String value) {
            addCriterion("data_type_analog >=", value, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogLessThan(String value) {
            addCriterion("data_type_analog <", value, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogLessThanOrEqualTo(String value) {
            addCriterion("data_type_analog <=", value, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogLike(String value) {
            addCriterion("data_type_analog like", value, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogNotLike(String value) {
            addCriterion("data_type_analog not like", value, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogIn(List<String> values) {
            addCriterion("data_type_analog in", values, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogNotIn(List<String> values) {
            addCriterion("data_type_analog not in", values, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogBetween(String value1, String value2) {
            addCriterion("data_type_analog between", value1, value2, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andDataTypeAnalogNotBetween(String value1, String value2) {
            addCriterion("data_type_analog not between", value1, value2, "dataTypeAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogIsNull() {
            addCriterion("unit_analog is null");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogIsNotNull() {
            addCriterion("unit_analog is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogEqualTo(String value) {
            addCriterion("unit_analog =", value, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogNotEqualTo(String value) {
            addCriterion("unit_analog <>", value, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogGreaterThan(String value) {
            addCriterion("unit_analog >", value, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogGreaterThanOrEqualTo(String value) {
            addCriterion("unit_analog >=", value, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogLessThan(String value) {
            addCriterion("unit_analog <", value, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogLessThanOrEqualTo(String value) {
            addCriterion("unit_analog <=", value, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogLike(String value) {
            addCriterion("unit_analog like", value, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogNotLike(String value) {
            addCriterion("unit_analog not like", value, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogIn(List<String> values) {
            addCriterion("unit_analog in", values, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogNotIn(List<String> values) {
            addCriterion("unit_analog not in", values, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogBetween(String value1, String value2) {
            addCriterion("unit_analog between", value1, value2, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUnitAnalogNotBetween(String value1, String value2) {
            addCriterion("unit_analog not between", value1, value2, "unitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogIsNull() {
            addCriterion("upper_limit_analog is null");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogIsNotNull() {
            addCriterion("upper_limit_analog is not null");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogEqualTo(String value) {
            addCriterion("upper_limit_analog =", value, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogNotEqualTo(String value) {
            addCriterion("upper_limit_analog <>", value, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogGreaterThan(String value) {
            addCriterion("upper_limit_analog >", value, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogGreaterThanOrEqualTo(String value) {
            addCriterion("upper_limit_analog >=", value, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogLessThan(String value) {
            addCriterion("upper_limit_analog <", value, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogLessThanOrEqualTo(String value) {
            addCriterion("upper_limit_analog <=", value, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogLike(String value) {
            addCriterion("upper_limit_analog like", value, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogNotLike(String value) {
            addCriterion("upper_limit_analog not like", value, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogIn(List<String> values) {
            addCriterion("upper_limit_analog in", values, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogNotIn(List<String> values) {
            addCriterion("upper_limit_analog not in", values, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogBetween(String value1, String value2) {
            addCriterion("upper_limit_analog between", value1, value2, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andUpperLimitAnalogNotBetween(String value1, String value2) {
            addCriterion("upper_limit_analog not between", value1, value2, "upperLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogIsNull() {
            addCriterion("lower_limit_analog is null");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogIsNotNull() {
            addCriterion("lower_limit_analog is not null");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogEqualTo(String value) {
            addCriterion("lower_limit_analog =", value, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogNotEqualTo(String value) {
            addCriterion("lower_limit_analog <>", value, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogGreaterThan(String value) {
            addCriterion("lower_limit_analog >", value, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogGreaterThanOrEqualTo(String value) {
            addCriterion("lower_limit_analog >=", value, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogLessThan(String value) {
            addCriterion("lower_limit_analog <", value, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogLessThanOrEqualTo(String value) {
            addCriterion("lower_limit_analog <=", value, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogLike(String value) {
            addCriterion("lower_limit_analog like", value, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogNotLike(String value) {
            addCriterion("lower_limit_analog not like", value, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogIn(List<String> values) {
            addCriterion("lower_limit_analog in", values, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogNotIn(List<String> values) {
            addCriterion("lower_limit_analog not in", values, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogBetween(String value1, String value2) {
            addCriterion("lower_limit_analog between", value1, value2, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andLowerLimitAnalogNotBetween(String value1, String value2) {
            addCriterion("lower_limit_analog not between", value1, value2, "lowerLimitAnalog");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagIsNull() {
            addCriterion("fault_word_flag is null");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagIsNotNull() {
            addCriterion("fault_word_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagEqualTo(String value) {
            addCriterion("fault_word_flag =", value, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagNotEqualTo(String value) {
            addCriterion("fault_word_flag <>", value, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagGreaterThan(String value) {
            addCriterion("fault_word_flag >", value, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagGreaterThanOrEqualTo(String value) {
            addCriterion("fault_word_flag >=", value, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagLessThan(String value) {
            addCriterion("fault_word_flag <", value, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagLessThanOrEqualTo(String value) {
            addCriterion("fault_word_flag <=", value, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagLike(String value) {
            addCriterion("fault_word_flag like", value, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagNotLike(String value) {
            addCriterion("fault_word_flag not like", value, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagIn(List<String> values) {
            addCriterion("fault_word_flag in", values, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagNotIn(List<String> values) {
            addCriterion("fault_word_flag not in", values, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagBetween(String value1, String value2) {
            addCriterion("fault_word_flag between", value1, value2, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andFaultWordFlagNotBetween(String value1, String value2) {
            addCriterion("fault_word_flag not between", value1, value2, "faultWordFlag");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnIsNull() {
            addCriterion("variable_name_en is null");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnIsNotNull() {
            addCriterion("variable_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnEqualTo(String value) {
            addCriterion("variable_name_en =", value, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnNotEqualTo(String value) {
            addCriterion("variable_name_en <>", value, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnGreaterThan(String value) {
            addCriterion("variable_name_en >", value, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("variable_name_en >=", value, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnLessThan(String value) {
            addCriterion("variable_name_en <", value, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnLessThanOrEqualTo(String value) {
            addCriterion("variable_name_en <=", value, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnLike(String value) {
            addCriterion("variable_name_en like", value, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnNotLike(String value) {
            addCriterion("variable_name_en not like", value, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnIn(List<String> values) {
            addCriterion("variable_name_en in", values, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnNotIn(List<String> values) {
            addCriterion("variable_name_en not in", values, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnBetween(String value1, String value2) {
            addCriterion("variable_name_en between", value1, value2, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariableNameEnNotBetween(String value1, String value2) {
            addCriterion("variable_name_en not between", value1, value2, "variableNameEn");
            return (Criteria) this;
        }

        public Criteria andVariablePlcIsNull() {
            addCriterion("variable_plc is null");
            return (Criteria) this;
        }

        public Criteria andVariablePlcIsNotNull() {
            addCriterion("variable_plc is not null");
            return (Criteria) this;
        }

        public Criteria andVariablePlcEqualTo(String value) {
            addCriterion("variable_plc =", value, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcNotEqualTo(String value) {
            addCriterion("variable_plc <>", value, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcGreaterThan(String value) {
            addCriterion("variable_plc >", value, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcGreaterThanOrEqualTo(String value) {
            addCriterion("variable_plc >=", value, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcLessThan(String value) {
            addCriterion("variable_plc <", value, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcLessThanOrEqualTo(String value) {
            addCriterion("variable_plc <=", value, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcLike(String value) {
            addCriterion("variable_plc like", value, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcNotLike(String value) {
            addCriterion("variable_plc not like", value, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcIn(List<String> values) {
            addCriterion("variable_plc in", values, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcNotIn(List<String> values) {
            addCriterion("variable_plc not in", values, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcBetween(String value1, String value2) {
            addCriterion("variable_plc between", value1, value2, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andVariablePlcNotBetween(String value1, String value2) {
            addCriterion("variable_plc not between", value1, value2, "variablePlc");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondIsNull() {
            addCriterion("part_belongs_second is null");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondIsNotNull() {
            addCriterion("part_belongs_second is not null");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondEqualTo(String value) {
            addCriterion("part_belongs_second =", value, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondNotEqualTo(String value) {
            addCriterion("part_belongs_second <>", value, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondGreaterThan(String value) {
            addCriterion("part_belongs_second >", value, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondGreaterThanOrEqualTo(String value) {
            addCriterion("part_belongs_second >=", value, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondLessThan(String value) {
            addCriterion("part_belongs_second <", value, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondLessThanOrEqualTo(String value) {
            addCriterion("part_belongs_second <=", value, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondLike(String value) {
            addCriterion("part_belongs_second like", value, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondNotLike(String value) {
            addCriterion("part_belongs_second not like", value, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondIn(List<String> values) {
            addCriterion("part_belongs_second in", values, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondNotIn(List<String> values) {
            addCriterion("part_belongs_second not in", values, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondBetween(String value1, String value2) {
            addCriterion("part_belongs_second between", value1, value2, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andPartBelongsSecondNotBetween(String value1, String value2) {
            addCriterion("part_belongs_second not between", value1, value2, "partBelongsSecond");
            return (Criteria) this;
        }

        public Criteria andVariableGroupIsNull() {
            addCriterion("variable_group is null");
            return (Criteria) this;
        }

        public Criteria andVariableGroupIsNotNull() {
            addCriterion("variable_group is not null");
            return (Criteria) this;
        }

        public Criteria andVariableGroupEqualTo(String value) {
            addCriterion("variable_group =", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupNotEqualTo(String value) {
            addCriterion("variable_group <>", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupGreaterThan(String value) {
            addCriterion("variable_group >", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupGreaterThanOrEqualTo(String value) {
            addCriterion("variable_group >=", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupLessThan(String value) {
            addCriterion("variable_group <", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupLessThanOrEqualTo(String value) {
            addCriterion("variable_group <=", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupLike(String value) {
            addCriterion("variable_group like", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupNotLike(String value) {
            addCriterion("variable_group not like", value, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupIn(List<String> values) {
            addCriterion("variable_group in", values, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupNotIn(List<String> values) {
            addCriterion("variable_group not in", values, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupBetween(String value1, String value2) {
            addCriterion("variable_group between", value1, value2, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andVariableGroupNotBetween(String value1, String value2) {
            addCriterion("variable_group not between", value1, value2, "variableGroup");
            return (Criteria) this;
        }

        public Criteria andDictDescIsNull() {
            addCriterion("dict_desc is null");
            return (Criteria) this;
        }

        public Criteria andDictDescIsNotNull() {
            addCriterion("dict_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDictDescEqualTo(String value) {
            addCriterion("dict_desc =", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescNotEqualTo(String value) {
            addCriterion("dict_desc <>", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescGreaterThan(String value) {
            addCriterion("dict_desc >", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescGreaterThanOrEqualTo(String value) {
            addCriterion("dict_desc >=", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescLessThan(String value) {
            addCriterion("dict_desc <", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescLessThanOrEqualTo(String value) {
            addCriterion("dict_desc <=", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescLike(String value) {
            addCriterion("dict_desc like", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescNotLike(String value) {
            addCriterion("dict_desc not like", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescIn(List<String> values) {
            addCriterion("dict_desc in", values, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescNotIn(List<String> values) {
            addCriterion("dict_desc not in", values, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescBetween(String value1, String value2) {
            addCriterion("dict_desc between", value1, value2, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescNotBetween(String value1, String value2) {
            addCriterion("dict_desc not between", value1, value2, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitIsNull() {
            addCriterion("scada_dispaly_digit is null");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitIsNotNull() {
            addCriterion("scada_dispaly_digit is not null");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitEqualTo(String value) {
            addCriterion("scada_dispaly_digit =", value, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitNotEqualTo(String value) {
            addCriterion("scada_dispaly_digit <>", value, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitGreaterThan(String value) {
            addCriterion("scada_dispaly_digit >", value, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitGreaterThanOrEqualTo(String value) {
            addCriterion("scada_dispaly_digit >=", value, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitLessThan(String value) {
            addCriterion("scada_dispaly_digit <", value, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitLessThanOrEqualTo(String value) {
            addCriterion("scada_dispaly_digit <=", value, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitLike(String value) {
            addCriterion("scada_dispaly_digit like", value, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitNotLike(String value) {
            addCriterion("scada_dispaly_digit not like", value, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitIn(List<String> values) {
            addCriterion("scada_dispaly_digit in", values, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitNotIn(List<String> values) {
            addCriterion("scada_dispaly_digit not in", values, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitBetween(String value1, String value2) {
            addCriterion("scada_dispaly_digit between", value1, value2, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andScadaDispalyDigitNotBetween(String value1, String value2) {
            addCriterion("scada_dispaly_digit not between", value1, value2, "scadaDispalyDigit");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelIsNull() {
            addCriterion("part_variable_major_level is null");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelIsNotNull() {
            addCriterion("part_variable_major_level is not null");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelEqualTo(String value) {
            addCriterion("part_variable_major_level =", value, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelNotEqualTo(String value) {
            addCriterion("part_variable_major_level <>", value, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelGreaterThan(String value) {
            addCriterion("part_variable_major_level >", value, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelGreaterThanOrEqualTo(String value) {
            addCriterion("part_variable_major_level >=", value, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelLessThan(String value) {
            addCriterion("part_variable_major_level <", value, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelLessThanOrEqualTo(String value) {
            addCriterion("part_variable_major_level <=", value, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelLike(String value) {
            addCriterion("part_variable_major_level like", value, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelNotLike(String value) {
            addCriterion("part_variable_major_level not like", value, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelIn(List<String> values) {
            addCriterion("part_variable_major_level in", values, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelNotIn(List<String> values) {
            addCriterion("part_variable_major_level not in", values, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelBetween(String value1, String value2) {
            addCriterion("part_variable_major_level between", value1, value2, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andPartVariableMajorLevelNotBetween(String value1, String value2) {
            addCriterion("part_variable_major_level not between", value1, value2, "partVariableMajorLevel");
            return (Criteria) this;
        }

        public Criteria andScadaClassIsNull() {
            addCriterion("scada_class is null");
            return (Criteria) this;
        }

        public Criteria andScadaClassIsNotNull() {
            addCriterion("scada_class is not null");
            return (Criteria) this;
        }

        public Criteria andScadaClassEqualTo(String value) {
            addCriterion("scada_class =", value, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassNotEqualTo(String value) {
            addCriterion("scada_class <>", value, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassGreaterThan(String value) {
            addCriterion("scada_class >", value, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassGreaterThanOrEqualTo(String value) {
            addCriterion("scada_class >=", value, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassLessThan(String value) {
            addCriterion("scada_class <", value, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassLessThanOrEqualTo(String value) {
            addCriterion("scada_class <=", value, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassLike(String value) {
            addCriterion("scada_class like", value, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassNotLike(String value) {
            addCriterion("scada_class not like", value, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassIn(List<String> values) {
            addCriterion("scada_class in", values, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassNotIn(List<String> values) {
            addCriterion("scada_class not in", values, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassBetween(String value1, String value2) {
            addCriterion("scada_class between", value1, value2, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaClassNotBetween(String value1, String value2) {
            addCriterion("scada_class not between", value1, value2, "scadaClass");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelIsNull() {
            addCriterion("scada_display_level is null");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelIsNotNull() {
            addCriterion("scada_display_level is not null");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelEqualTo(String value) {
            addCriterion("scada_display_level =", value, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelNotEqualTo(String value) {
            addCriterion("scada_display_level <>", value, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelGreaterThan(String value) {
            addCriterion("scada_display_level >", value, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelGreaterThanOrEqualTo(String value) {
            addCriterion("scada_display_level >=", value, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelLessThan(String value) {
            addCriterion("scada_display_level <", value, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelLessThanOrEqualTo(String value) {
            addCriterion("scada_display_level <=", value, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelLike(String value) {
            addCriterion("scada_display_level like", value, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelNotLike(String value) {
            addCriterion("scada_display_level not like", value, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelIn(List<String> values) {
            addCriterion("scada_display_level in", values, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelNotIn(List<String> values) {
            addCriterion("scada_display_level not in", values, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelBetween(String value1, String value2) {
            addCriterion("scada_display_level between", value1, value2, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andScadaDisplayLevelNotBetween(String value1, String value2) {
            addCriterion("scada_display_level not between", value1, value2, "scadaDisplayLevel");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnIsNull() {
            addCriterion("simple_desc_cn is null");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnIsNotNull() {
            addCriterion("simple_desc_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnEqualTo(String value) {
            addCriterion("simple_desc_cn =", value, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnNotEqualTo(String value) {
            addCriterion("simple_desc_cn <>", value, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnGreaterThan(String value) {
            addCriterion("simple_desc_cn >", value, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnGreaterThanOrEqualTo(String value) {
            addCriterion("simple_desc_cn >=", value, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnLessThan(String value) {
            addCriterion("simple_desc_cn <", value, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnLessThanOrEqualTo(String value) {
            addCriterion("simple_desc_cn <=", value, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnLike(String value) {
            addCriterion("simple_desc_cn like", value, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnNotLike(String value) {
            addCriterion("simple_desc_cn not like", value, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnIn(List<String> values) {
            addCriterion("simple_desc_cn in", values, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnNotIn(List<String> values) {
            addCriterion("simple_desc_cn not in", values, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnBetween(String value1, String value2) {
            addCriterion("simple_desc_cn between", value1, value2, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andSimpleDescCnNotBetween(String value1, String value2) {
            addCriterion("simple_desc_cn not between", value1, value2, "simpleDescCn");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitIsNull() {
            addCriterion("coefficient_unit is null");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitIsNotNull() {
            addCriterion("coefficient_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitEqualTo(String value) {
            addCriterion("coefficient_unit =", value, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitNotEqualTo(String value) {
            addCriterion("coefficient_unit <>", value, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitGreaterThan(String value) {
            addCriterion("coefficient_unit >", value, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitGreaterThanOrEqualTo(String value) {
            addCriterion("coefficient_unit >=", value, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitLessThan(String value) {
            addCriterion("coefficient_unit <", value, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitLessThanOrEqualTo(String value) {
            addCriterion("coefficient_unit <=", value, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitLike(String value) {
            addCriterion("coefficient_unit like", value, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitNotLike(String value) {
            addCriterion("coefficient_unit not like", value, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitIn(List<String> values) {
            addCriterion("coefficient_unit in", values, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitNotIn(List<String> values) {
            addCriterion("coefficient_unit not in", values, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitBetween(String value1, String value2) {
            addCriterion("coefficient_unit between", value1, value2, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andCoefficientUnitNotBetween(String value1, String value2) {
            addCriterion("coefficient_unit not between", value1, value2, "coefficientUnit");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleIsNull() {
            addCriterion("over_limit_style is null");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleIsNotNull() {
            addCriterion("over_limit_style is not null");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleEqualTo(String value) {
            addCriterion("over_limit_style =", value, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleNotEqualTo(String value) {
            addCriterion("over_limit_style <>", value, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleGreaterThan(String value) {
            addCriterion("over_limit_style >", value, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleGreaterThanOrEqualTo(String value) {
            addCriterion("over_limit_style >=", value, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleLessThan(String value) {
            addCriterion("over_limit_style <", value, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleLessThanOrEqualTo(String value) {
            addCriterion("over_limit_style <=", value, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleLike(String value) {
            addCriterion("over_limit_style like", value, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleNotLike(String value) {
            addCriterion("over_limit_style not like", value, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleIn(List<String> values) {
            addCriterion("over_limit_style in", values, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleNotIn(List<String> values) {
            addCriterion("over_limit_style not in", values, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleBetween(String value1, String value2) {
            addCriterion("over_limit_style between", value1, value2, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andOverLimitStyleNotBetween(String value1, String value2) {
            addCriterion("over_limit_style not between", value1, value2, "overLimitStyle");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleIsNull() {
            addCriterion("switch0_style is null");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleIsNotNull() {
            addCriterion("switch0_style is not null");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleEqualTo(String value) {
            addCriterion("switch0_style =", value, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleNotEqualTo(String value) {
            addCriterion("switch0_style <>", value, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleGreaterThan(String value) {
            addCriterion("switch0_style >", value, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleGreaterThanOrEqualTo(String value) {
            addCriterion("switch0_style >=", value, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleLessThan(String value) {
            addCriterion("switch0_style <", value, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleLessThanOrEqualTo(String value) {
            addCriterion("switch0_style <=", value, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleLike(String value) {
            addCriterion("switch0_style like", value, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleNotLike(String value) {
            addCriterion("switch0_style not like", value, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleIn(List<String> values) {
            addCriterion("switch0_style in", values, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleNotIn(List<String> values) {
            addCriterion("switch0_style not in", values, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleBetween(String value1, String value2) {
            addCriterion("switch0_style between", value1, value2, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch0StyleNotBetween(String value1, String value2) {
            addCriterion("switch0_style not between", value1, value2, "switch0Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleIsNull() {
            addCriterion("switch1_style is null");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleIsNotNull() {
            addCriterion("switch1_style is not null");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleEqualTo(String value) {
            addCriterion("switch1_style =", value, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleNotEqualTo(String value) {
            addCriterion("switch1_style <>", value, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleGreaterThan(String value) {
            addCriterion("switch1_style >", value, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleGreaterThanOrEqualTo(String value) {
            addCriterion("switch1_style >=", value, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleLessThan(String value) {
            addCriterion("switch1_style <", value, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleLessThanOrEqualTo(String value) {
            addCriterion("switch1_style <=", value, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleLike(String value) {
            addCriterion("switch1_style like", value, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleNotLike(String value) {
            addCriterion("switch1_style not like", value, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleIn(List<String> values) {
            addCriterion("switch1_style in", values, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleNotIn(List<String> values) {
            addCriterion("switch1_style not in", values, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleBetween(String value1, String value2) {
            addCriterion("switch1_style between", value1, value2, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andSwitch1StyleNotBetween(String value1, String value2) {
            addCriterion("switch1_style not between", value1, value2, "switch1Style");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeIsNull() {
            addCriterion("calculation_type is null");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeIsNotNull() {
            addCriterion("calculation_type is not null");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeEqualTo(String value) {
            addCriterion("calculation_type =", value, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeNotEqualTo(String value) {
            addCriterion("calculation_type <>", value, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeGreaterThan(String value) {
            addCriterion("calculation_type >", value, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("calculation_type >=", value, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeLessThan(String value) {
            addCriterion("calculation_type <", value, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeLessThanOrEqualTo(String value) {
            addCriterion("calculation_type <=", value, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeLike(String value) {
            addCriterion("calculation_type like", value, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeNotLike(String value) {
            addCriterion("calculation_type not like", value, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeIn(List<String> values) {
            addCriterion("calculation_type in", values, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeNotIn(List<String> values) {
            addCriterion("calculation_type not in", values, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeBetween(String value1, String value2) {
            addCriterion("calculation_type between", value1, value2, "calculationType");
            return (Criteria) this;
        }

        public Criteria andCalculationTypeNotBetween(String value1, String value2) {
            addCriterion("calculation_type not between", value1, value2, "calculationType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeIsNull() {
            addCriterion("resample_type is null");
            return (Criteria) this;
        }

        public Criteria andResampleTypeIsNotNull() {
            addCriterion("resample_type is not null");
            return (Criteria) this;
        }

        public Criteria andResampleTypeEqualTo(String value) {
            addCriterion("resample_type =", value, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeNotEqualTo(String value) {
            addCriterion("resample_type <>", value, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeGreaterThan(String value) {
            addCriterion("resample_type >", value, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("resample_type >=", value, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeLessThan(String value) {
            addCriterion("resample_type <", value, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeLessThanOrEqualTo(String value) {
            addCriterion("resample_type <=", value, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeLike(String value) {
            addCriterion("resample_type like", value, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeNotLike(String value) {
            addCriterion("resample_type not like", value, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeIn(List<String> values) {
            addCriterion("resample_type in", values, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeNotIn(List<String> values) {
            addCriterion("resample_type not in", values, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeBetween(String value1, String value2) {
            addCriterion("resample_type between", value1, value2, "resampleType");
            return (Criteria) this;
        }

        public Criteria andResampleTypeNotBetween(String value1, String value2) {
            addCriterion("resample_type not between", value1, value2, "resampleType");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayIsNull() {
            addCriterion("iec_xb_web_display is null");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayIsNotNull() {
            addCriterion("iec_xb_web_display is not null");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayEqualTo(String value) {
            addCriterion("iec_xb_web_display =", value, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayNotEqualTo(String value) {
            addCriterion("iec_xb_web_display <>", value, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayGreaterThan(String value) {
            addCriterion("iec_xb_web_display >", value, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("iec_xb_web_display >=", value, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayLessThan(String value) {
            addCriterion("iec_xb_web_display <", value, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayLessThanOrEqualTo(String value) {
            addCriterion("iec_xb_web_display <=", value, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayLike(String value) {
            addCriterion("iec_xb_web_display like", value, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayNotLike(String value) {
            addCriterion("iec_xb_web_display not like", value, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayIn(List<String> values) {
            addCriterion("iec_xb_web_display in", values, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayNotIn(List<String> values) {
            addCriterion("iec_xb_web_display not in", values, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayBetween(String value1, String value2) {
            addCriterion("iec_xb_web_display between", value1, value2, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbWebDisplayNotBetween(String value1, String value2) {
            addCriterion("iec_xb_web_display not between", value1, value2, "iecXbWebDisplay");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueIsNull() {
            addCriterion("iec_xb_control_value is null");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueIsNotNull() {
            addCriterion("iec_xb_control_value is not null");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueEqualTo(String value) {
            addCriterion("iec_xb_control_value =", value, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueNotEqualTo(String value) {
            addCriterion("iec_xb_control_value <>", value, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueGreaterThan(String value) {
            addCriterion("iec_xb_control_value >", value, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueGreaterThanOrEqualTo(String value) {
            addCriterion("iec_xb_control_value >=", value, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueLessThan(String value) {
            addCriterion("iec_xb_control_value <", value, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueLessThanOrEqualTo(String value) {
            addCriterion("iec_xb_control_value <=", value, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueLike(String value) {
            addCriterion("iec_xb_control_value like", value, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueNotLike(String value) {
            addCriterion("iec_xb_control_value not like", value, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueIn(List<String> values) {
            addCriterion("iec_xb_control_value in", values, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueNotIn(List<String> values) {
            addCriterion("iec_xb_control_value not in", values, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueBetween(String value1, String value2) {
            addCriterion("iec_xb_control_value between", value1, value2, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbControlValueNotBetween(String value1, String value2) {
            addCriterion("iec_xb_control_value not between", value1, value2, "iecXbControlValue");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameIsNull() {
            addCriterion("iec_xb_button_name is null");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameIsNotNull() {
            addCriterion("iec_xb_button_name is not null");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameEqualTo(String value) {
            addCriterion("iec_xb_button_name =", value, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameNotEqualTo(String value) {
            addCriterion("iec_xb_button_name <>", value, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameGreaterThan(String value) {
            addCriterion("iec_xb_button_name >", value, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameGreaterThanOrEqualTo(String value) {
            addCriterion("iec_xb_button_name >=", value, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameLessThan(String value) {
            addCriterion("iec_xb_button_name <", value, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameLessThanOrEqualTo(String value) {
            addCriterion("iec_xb_button_name <=", value, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameLike(String value) {
            addCriterion("iec_xb_button_name like", value, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameNotLike(String value) {
            addCriterion("iec_xb_button_name not like", value, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameIn(List<String> values) {
            addCriterion("iec_xb_button_name in", values, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameNotIn(List<String> values) {
            addCriterion("iec_xb_button_name not in", values, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameBetween(String value1, String value2) {
            addCriterion("iec_xb_button_name between", value1, value2, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andIecXbButtonNameNotBetween(String value1, String value2) {
            addCriterion("iec_xb_button_name not between", value1, value2, "iecXbButtonName");
            return (Criteria) this;
        }

        public Criteria andOffSetIsNull() {
            addCriterion("off_set is null");
            return (Criteria) this;
        }

        public Criteria andOffSetIsNotNull() {
            addCriterion("off_set is not null");
            return (Criteria) this;
        }

        public Criteria andOffSetEqualTo(String value) {
            addCriterion("off_set =", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetNotEqualTo(String value) {
            addCriterion("off_set <>", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetGreaterThan(String value) {
            addCriterion("off_set >", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetGreaterThanOrEqualTo(String value) {
            addCriterion("off_set >=", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetLessThan(String value) {
            addCriterion("off_set <", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetLessThanOrEqualTo(String value) {
            addCriterion("off_set <=", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetLike(String value) {
            addCriterion("off_set like", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetNotLike(String value) {
            addCriterion("off_set not like", value, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetIn(List<String> values) {
            addCriterion("off_set in", values, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetNotIn(List<String> values) {
            addCriterion("off_set not in", values, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetBetween(String value1, String value2) {
            addCriterion("off_set between", value1, value2, "offSet");
            return (Criteria) this;
        }

        public Criteria andOffSetNotBetween(String value1, String value2) {
            addCriterion("off_set not between", value1, value2, "offSet");
            return (Criteria) this;
        }

        public Criteria andChannelUuidIsNull() {
            addCriterion("channel_uuid is null");
            return (Criteria) this;
        }

        public Criteria andChannelUuidIsNotNull() {
            addCriterion("channel_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andChannelUuidEqualTo(String value) {
            addCriterion("channel_uuid =", value, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidNotEqualTo(String value) {
            addCriterion("channel_uuid <>", value, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidGreaterThan(String value) {
            addCriterion("channel_uuid >", value, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidGreaterThanOrEqualTo(String value) {
            addCriterion("channel_uuid >=", value, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidLessThan(String value) {
            addCriterion("channel_uuid <", value, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidLessThanOrEqualTo(String value) {
            addCriterion("channel_uuid <=", value, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidLike(String value) {
            addCriterion("channel_uuid like", value, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidNotLike(String value) {
            addCriterion("channel_uuid not like", value, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidIn(List<String> values) {
            addCriterion("channel_uuid in", values, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidNotIn(List<String> values) {
            addCriterion("channel_uuid not in", values, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidBetween(String value1, String value2) {
            addCriterion("channel_uuid between", value1, value2, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelUuidNotBetween(String value1, String value2) {
            addCriterion("channel_uuid not between", value1, value2, "channelUuid");
            return (Criteria) this;
        }

        public Criteria andChannelVersionIsNull() {
            addCriterion("channel_version is null");
            return (Criteria) this;
        }

        public Criteria andChannelVersionIsNotNull() {
            addCriterion("channel_version is not null");
            return (Criteria) this;
        }

        public Criteria andChannelVersionEqualTo(Integer value) {
            addCriterion("channel_version =", value, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionNotEqualTo(Integer value) {
            addCriterion("channel_version <>", value, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionGreaterThan(Integer value) {
            addCriterion("channel_version >", value, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_version >=", value, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionLessThan(Integer value) {
            addCriterion("channel_version <", value, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionLessThanOrEqualTo(Integer value) {
            addCriterion("channel_version <=", value, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionIn(List<Integer> values) {
            addCriterion("channel_version in", values, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionNotIn(List<Integer> values) {
            addCriterion("channel_version not in", values, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionBetween(Integer value1, Integer value2) {
            addCriterion("channel_version between", value1, value2, "channelVersion");
            return (Criteria) this;
        }

        public Criteria andChannelVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_version not between", value1, value2, "channelVersion");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
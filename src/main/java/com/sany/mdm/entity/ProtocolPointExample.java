package com.sany.mdm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProtocolPointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProtocolPointExample() {
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

        public Criteria andProtocolIdIsNull() {
            addCriterion("protocol_id is null");
            return (Criteria) this;
        }

        public Criteria andProtocolIdIsNotNull() {
            addCriterion("protocol_id is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolIdEqualTo(Integer value) {
            addCriterion("protocol_id =", value, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdNotEqualTo(Integer value) {
            addCriterion("protocol_id <>", value, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdGreaterThan(Integer value) {
            addCriterion("protocol_id >", value, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("protocol_id >=", value, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdLessThan(Integer value) {
            addCriterion("protocol_id <", value, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdLessThanOrEqualTo(Integer value) {
            addCriterion("protocol_id <=", value, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdIn(List<Integer> values) {
            addCriterion("protocol_id in", values, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdNotIn(List<Integer> values) {
            addCriterion("protocol_id not in", values, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdBetween(Integer value1, Integer value2) {
            addCriterion("protocol_id between", value1, value2, "protocolId");
            return (Criteria) this;
        }

        public Criteria andProtocolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("protocol_id not between", value1, value2, "protocolId");
            return (Criteria) this;
        }

        public Criteria andPointNameIsNull() {
            addCriterion("point_name is null");
            return (Criteria) this;
        }

        public Criteria andPointNameIsNotNull() {
            addCriterion("point_name is not null");
            return (Criteria) this;
        }

        public Criteria andPointNameEqualTo(String value) {
            addCriterion("point_name =", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameNotEqualTo(String value) {
            addCriterion("point_name <>", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameGreaterThan(String value) {
            addCriterion("point_name >", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameGreaterThanOrEqualTo(String value) {
            addCriterion("point_name >=", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameLessThan(String value) {
            addCriterion("point_name <", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameLessThanOrEqualTo(String value) {
            addCriterion("point_name <=", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameLike(String value) {
            addCriterion("point_name like", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameNotLike(String value) {
            addCriterion("point_name not like", value, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameIn(List<String> values) {
            addCriterion("point_name in", values, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameNotIn(List<String> values) {
            addCriterion("point_name not in", values, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameBetween(String value1, String value2) {
            addCriterion("point_name between", value1, value2, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointNameNotBetween(String value1, String value2) {
            addCriterion("point_name not between", value1, value2, "pointName");
            return (Criteria) this;
        }

        public Criteria andPointVersionIsNull() {
            addCriterion("point_version is null");
            return (Criteria) this;
        }

        public Criteria andPointVersionIsNotNull() {
            addCriterion("point_version is not null");
            return (Criteria) this;
        }

        public Criteria andPointVersionEqualTo(String value) {
            addCriterion("point_version =", value, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionNotEqualTo(String value) {
            addCriterion("point_version <>", value, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionGreaterThan(String value) {
            addCriterion("point_version >", value, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionGreaterThanOrEqualTo(String value) {
            addCriterion("point_version >=", value, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionLessThan(String value) {
            addCriterion("point_version <", value, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionLessThanOrEqualTo(String value) {
            addCriterion("point_version <=", value, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionLike(String value) {
            addCriterion("point_version like", value, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionNotLike(String value) {
            addCriterion("point_version not like", value, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionIn(List<String> values) {
            addCriterion("point_version in", values, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionNotIn(List<String> values) {
            addCriterion("point_version not in", values, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionBetween(String value1, String value2) {
            addCriterion("point_version between", value1, value2, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andPointVersionNotBetween(String value1, String value2) {
            addCriterion("point_version not between", value1, value2, "pointVersion");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIsNull() {
            addCriterion("protocol_type is null");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIsNotNull() {
            addCriterion("protocol_type is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeEqualTo(String value) {
            addCriterion("protocol_type =", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotEqualTo(String value) {
            addCriterion("protocol_type <>", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeGreaterThan(String value) {
            addCriterion("protocol_type >", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeGreaterThanOrEqualTo(String value) {
            addCriterion("protocol_type >=", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLessThan(String value) {
            addCriterion("protocol_type <", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLessThanOrEqualTo(String value) {
            addCriterion("protocol_type <=", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeLike(String value) {
            addCriterion("protocol_type like", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotLike(String value) {
            addCriterion("protocol_type not like", value, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeIn(List<String> values) {
            addCriterion("protocol_type in", values, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotIn(List<String> values) {
            addCriterion("protocol_type not in", values, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeBetween(String value1, String value2) {
            addCriterion("protocol_type between", value1, value2, "protocolType");
            return (Criteria) this;
        }

        public Criteria andProtocolTypeNotBetween(String value1, String value2) {
            addCriterion("protocol_type not between", value1, value2, "protocolType");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeIsNull() {
            addCriterion("upgrade_time is null");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeIsNotNull() {
            addCriterion("upgrade_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeEqualTo(Date value) {
            addCriterion("upgrade_time =", value, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeNotEqualTo(Date value) {
            addCriterion("upgrade_time <>", value, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeGreaterThan(Date value) {
            addCriterion("upgrade_time >", value, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upgrade_time >=", value, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeLessThan(Date value) {
            addCriterion("upgrade_time <", value, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("upgrade_time <=", value, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeIn(List<Date> values) {
            addCriterion("upgrade_time in", values, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeNotIn(List<Date> values) {
            addCriterion("upgrade_time not in", values, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeBetween(Date value1, Date value2) {
            addCriterion("upgrade_time between", value1, value2, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andUpgradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("upgrade_time not between", value1, value2, "upgradeTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(String value) {
            addCriterion("scope =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(String value) {
            addCriterion("scope <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(String value) {
            addCriterion("scope >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(String value) {
            addCriterion("scope >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(String value) {
            addCriterion("scope <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(String value) {
            addCriterion("scope <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLike(String value) {
            addCriterion("scope like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotLike(String value) {
            addCriterion("scope not like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<String> values) {
            addCriterion("scope in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<String> values) {
            addCriterion("scope not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(String value1, String value2) {
            addCriterion("scope between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(String value1, String value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLocalPathIsNull() {
            addCriterion("local_path is null");
            return (Criteria) this;
        }

        public Criteria andLocalPathIsNotNull() {
            addCriterion("local_path is not null");
            return (Criteria) this;
        }

        public Criteria andLocalPathEqualTo(String value) {
            addCriterion("local_path =", value, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathNotEqualTo(String value) {
            addCriterion("local_path <>", value, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathGreaterThan(String value) {
            addCriterion("local_path >", value, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathGreaterThanOrEqualTo(String value) {
            addCriterion("local_path >=", value, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathLessThan(String value) {
            addCriterion("local_path <", value, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathLessThanOrEqualTo(String value) {
            addCriterion("local_path <=", value, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathLike(String value) {
            addCriterion("local_path like", value, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathNotLike(String value) {
            addCriterion("local_path not like", value, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathIn(List<String> values) {
            addCriterion("local_path in", values, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathNotIn(List<String> values) {
            addCriterion("local_path not in", values, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathBetween(String value1, String value2) {
            addCriterion("local_path between", value1, value2, "localPath");
            return (Criteria) this;
        }

        public Criteria andLocalPathNotBetween(String value1, String value2) {
            addCriterion("local_path not between", value1, value2, "localPath");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPointUuidIsNull() {
            addCriterion("point_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPointUuidIsNotNull() {
            addCriterion("point_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPointUuidEqualTo(String value) {
            addCriterion("point_uuid =", value, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidNotEqualTo(String value) {
            addCriterion("point_uuid <>", value, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidGreaterThan(String value) {
            addCriterion("point_uuid >", value, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidGreaterThanOrEqualTo(String value) {
            addCriterion("point_uuid >=", value, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidLessThan(String value) {
            addCriterion("point_uuid <", value, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidLessThanOrEqualTo(String value) {
            addCriterion("point_uuid <=", value, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidLike(String value) {
            addCriterion("point_uuid like", value, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidNotLike(String value) {
            addCriterion("point_uuid not like", value, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidIn(List<String> values) {
            addCriterion("point_uuid in", values, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidNotIn(List<String> values) {
            addCriterion("point_uuid not in", values, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidBetween(String value1, String value2) {
            addCriterion("point_uuid between", value1, value2, "pointUuid");
            return (Criteria) this;
        }

        public Criteria andPointUuidNotBetween(String value1, String value2) {
            addCriterion("point_uuid not between", value1, value2, "pointUuid");
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
package com.hsmy.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HsmyInfoPubExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HsmyInfoPubExample() {
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

        public Criteria andInfoSernoIsNull() {
            addCriterion("info_serno is null");
            return (Criteria) this;
        }

        public Criteria andInfoSernoIsNotNull() {
            addCriterion("info_serno is not null");
            return (Criteria) this;
        }

        public Criteria andInfoSernoEqualTo(Long value) {
            addCriterion("info_serno =", value, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoNotEqualTo(Long value) {
            addCriterion("info_serno <>", value, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoGreaterThan(Long value) {
            addCriterion("info_serno >", value, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoGreaterThanOrEqualTo(Long value) {
            addCriterion("info_serno >=", value, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoLessThan(Long value) {
            addCriterion("info_serno <", value, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoLessThanOrEqualTo(Long value) {
            addCriterion("info_serno <=", value, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoIn(List<Long> values) {
            addCriterion("info_serno in", values, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoNotIn(List<Long> values) {
            addCriterion("info_serno not in", values, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoBetween(Long value1, Long value2) {
            addCriterion("info_serno between", value1, value2, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andInfoSernoNotBetween(Long value1, Long value2) {
            addCriterion("info_serno not between", value1, value2, "infoSerno");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andMobileNoIsNull() {
            addCriterion("mobile_no is null");
            return (Criteria) this;
        }

        public Criteria andMobileNoIsNotNull() {
            addCriterion("mobile_no is not null");
            return (Criteria) this;
        }

        public Criteria andMobileNoEqualTo(String value) {
            addCriterion("mobile_no =", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotEqualTo(String value) {
            addCriterion("mobile_no <>", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoGreaterThan(String value) {
            addCriterion("mobile_no >", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_no >=", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLessThan(String value) {
            addCriterion("mobile_no <", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLessThanOrEqualTo(String value) {
            addCriterion("mobile_no <=", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoLike(String value) {
            addCriterion("mobile_no like", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotLike(String value) {
            addCriterion("mobile_no not like", value, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoIn(List<String> values) {
            addCriterion("mobile_no in", values, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotIn(List<String> values) {
            addCriterion("mobile_no not in", values, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoBetween(String value1, String value2) {
            addCriterion("mobile_no between", value1, value2, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andMobileNoNotBetween(String value1, String value2) {
            addCriterion("mobile_no not between", value1, value2, "mobileNo");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIsNull() {
            addCriterion("info_title is null");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIsNotNull() {
            addCriterion("info_title is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTitleEqualTo(String value) {
            addCriterion("info_title =", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotEqualTo(String value) {
            addCriterion("info_title <>", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleGreaterThan(String value) {
            addCriterion("info_title >", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("info_title >=", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLessThan(String value) {
            addCriterion("info_title <", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLessThanOrEqualTo(String value) {
            addCriterion("info_title <=", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLike(String value) {
            addCriterion("info_title like", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotLike(String value) {
            addCriterion("info_title not like", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIn(List<String> values) {
            addCriterion("info_title in", values, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotIn(List<String> values) {
            addCriterion("info_title not in", values, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleBetween(String value1, String value2) {
            addCriterion("info_title between", value1, value2, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotBetween(String value1, String value2) {
            addCriterion("info_title not between", value1, value2, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoEnumIsNull() {
            addCriterion("info_enum is null");
            return (Criteria) this;
        }

        public Criteria andInfoEnumIsNotNull() {
            addCriterion("info_enum is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEnumEqualTo(String value) {
            addCriterion("info_enum =", value, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumNotEqualTo(String value) {
            addCriterion("info_enum <>", value, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumGreaterThan(String value) {
            addCriterion("info_enum >", value, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumGreaterThanOrEqualTo(String value) {
            addCriterion("info_enum >=", value, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumLessThan(String value) {
            addCriterion("info_enum <", value, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumLessThanOrEqualTo(String value) {
            addCriterion("info_enum <=", value, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumLike(String value) {
            addCriterion("info_enum like", value, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumNotLike(String value) {
            addCriterion("info_enum not like", value, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumIn(List<String> values) {
            addCriterion("info_enum in", values, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumNotIn(List<String> values) {
            addCriterion("info_enum not in", values, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumBetween(String value1, String value2) {
            addCriterion("info_enum between", value1, value2, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoEnumNotBetween(String value1, String value2) {
            addCriterion("info_enum not between", value1, value2, "infoEnum");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataIsNull() {
            addCriterion("info_workdata is null");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataIsNotNull() {
            addCriterion("info_workdata is not null");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataEqualTo(String value) {
            addCriterion("info_workdata =", value, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataNotEqualTo(String value) {
            addCriterion("info_workdata <>", value, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataGreaterThan(String value) {
            addCriterion("info_workdata >", value, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataGreaterThanOrEqualTo(String value) {
            addCriterion("info_workdata >=", value, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataLessThan(String value) {
            addCriterion("info_workdata <", value, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataLessThanOrEqualTo(String value) {
            addCriterion("info_workdata <=", value, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataLike(String value) {
            addCriterion("info_workdata like", value, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataNotLike(String value) {
            addCriterion("info_workdata not like", value, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataIn(List<String> values) {
            addCriterion("info_workdata in", values, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataNotIn(List<String> values) {
            addCriterion("info_workdata not in", values, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataBetween(String value1, String value2) {
            addCriterion("info_workdata between", value1, value2, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoWorkdataNotBetween(String value1, String value2) {
            addCriterion("info_workdata not between", value1, value2, "infoWorkdata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataIsNull() {
            addCriterion("info_enddata is null");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataIsNotNull() {
            addCriterion("info_enddata is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataEqualTo(String value) {
            addCriterion("info_enddata =", value, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataNotEqualTo(String value) {
            addCriterion("info_enddata <>", value, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataGreaterThan(String value) {
            addCriterion("info_enddata >", value, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataGreaterThanOrEqualTo(String value) {
            addCriterion("info_enddata >=", value, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataLessThan(String value) {
            addCriterion("info_enddata <", value, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataLessThanOrEqualTo(String value) {
            addCriterion("info_enddata <=", value, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataLike(String value) {
            addCriterion("info_enddata like", value, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataNotLike(String value) {
            addCriterion("info_enddata not like", value, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataIn(List<String> values) {
            addCriterion("info_enddata in", values, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataNotIn(List<String> values) {
            addCriterion("info_enddata not in", values, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataBetween(String value1, String value2) {
            addCriterion("info_enddata between", value1, value2, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoEnddataNotBetween(String value1, String value2) {
            addCriterion("info_enddata not between", value1, value2, "infoEnddata");
            return (Criteria) this;
        }

        public Criteria andInfoDescIsNull() {
            addCriterion("info_desc is null");
            return (Criteria) this;
        }

        public Criteria andInfoDescIsNotNull() {
            addCriterion("info_desc is not null");
            return (Criteria) this;
        }

        public Criteria andInfoDescEqualTo(String value) {
            addCriterion("info_desc =", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotEqualTo(String value) {
            addCriterion("info_desc <>", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescGreaterThan(String value) {
            addCriterion("info_desc >", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescGreaterThanOrEqualTo(String value) {
            addCriterion("info_desc >=", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLessThan(String value) {
            addCriterion("info_desc <", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLessThanOrEqualTo(String value) {
            addCriterion("info_desc <=", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLike(String value) {
            addCriterion("info_desc like", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotLike(String value) {
            addCriterion("info_desc not like", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescIn(List<String> values) {
            addCriterion("info_desc in", values, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotIn(List<String> values) {
            addCriterion("info_desc not in", values, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescBetween(String value1, String value2) {
            addCriterion("info_desc between", value1, value2, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotBetween(String value1, String value2) {
            addCriterion("info_desc not between", value1, value2, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescIsNull() {
            addCriterion("pics_desc is null");
            return (Criteria) this;
        }

        public Criteria andPicsDescIsNotNull() {
            addCriterion("pics_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPicsDescEqualTo(String value) {
            addCriterion("pics_desc =", value, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescNotEqualTo(String value) {
            addCriterion("pics_desc <>", value, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescGreaterThan(String value) {
            addCriterion("pics_desc >", value, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescGreaterThanOrEqualTo(String value) {
            addCriterion("pics_desc >=", value, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescLessThan(String value) {
            addCriterion("pics_desc <", value, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescLessThanOrEqualTo(String value) {
            addCriterion("pics_desc <=", value, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescLike(String value) {
            addCriterion("pics_desc like", value, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescNotLike(String value) {
            addCriterion("pics_desc not like", value, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescIn(List<String> values) {
            addCriterion("pics_desc in", values, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescNotIn(List<String> values) {
            addCriterion("pics_desc not in", values, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescBetween(String value1, String value2) {
            addCriterion("pics_desc between", value1, value2, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andPicsDescNotBetween(String value1, String value2) {
            addCriterion("pics_desc not between", value1, value2, "picsDesc");
            return (Criteria) this;
        }

        public Criteria andLastDateIsNull() {
            addCriterion("last_date is null");
            return (Criteria) this;
        }

        public Criteria andLastDateIsNotNull() {
            addCriterion("last_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastDateEqualTo(Date value) {
            addCriterion("last_date =", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotEqualTo(Date value) {
            addCriterion("last_date <>", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateGreaterThan(Date value) {
            addCriterion("last_date >", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_date >=", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateLessThan(Date value) {
            addCriterion("last_date <", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateLessThanOrEqualTo(Date value) {
            addCriterion("last_date <=", value, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateIn(List<Date> values) {
            addCriterion("last_date in", values, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotIn(List<Date> values) {
            addCriterion("last_date not in", values, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateBetween(Date value1, Date value2) {
            addCriterion("last_date between", value1, value2, "lastDate");
            return (Criteria) this;
        }

        public Criteria andLastDateNotBetween(Date value1, Date value2) {
            addCriterion("last_date not between", value1, value2, "lastDate");
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
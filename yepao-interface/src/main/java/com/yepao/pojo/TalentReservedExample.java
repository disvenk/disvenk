package com.yepao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TalentReservedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TalentReservedExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTalentReservedIdIsNull() {
            addCriterion("talent_reserved_id is null");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdIsNotNull() {
            addCriterion("talent_reserved_id is not null");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdEqualTo(Long value) {
            addCriterion("talent_reserved_id =", value, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdNotEqualTo(Long value) {
            addCriterion("talent_reserved_id <>", value, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdGreaterThan(Long value) {
            addCriterion("talent_reserved_id >", value, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("talent_reserved_id >=", value, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdLessThan(Long value) {
            addCriterion("talent_reserved_id <", value, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdLessThanOrEqualTo(Long value) {
            addCriterion("talent_reserved_id <=", value, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdIn(List<Long> values) {
            addCriterion("talent_reserved_id in", values, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdNotIn(List<Long> values) {
            addCriterion("talent_reserved_id not in", values, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdBetween(Long value1, Long value2) {
            addCriterion("talent_reserved_id between", value1, value2, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andTalentReservedIdNotBetween(Long value1, Long value2) {
            addCriterion("talent_reserved_id not between", value1, value2, "talentReservedId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdIsNull() {
            addCriterion("wedding_talent_id is null");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdIsNotNull() {
            addCriterion("wedding_talent_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdEqualTo(Long value) {
            addCriterion("wedding_talent_id =", value, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdNotEqualTo(Long value) {
            addCriterion("wedding_talent_id <>", value, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdGreaterThan(Long value) {
            addCriterion("wedding_talent_id >", value, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("wedding_talent_id >=", value, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdLessThan(Long value) {
            addCriterion("wedding_talent_id <", value, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdLessThanOrEqualTo(Long value) {
            addCriterion("wedding_talent_id <=", value, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdIn(List<Long> values) {
            addCriterion("wedding_talent_id in", values, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdNotIn(List<Long> values) {
            addCriterion("wedding_talent_id not in", values, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdBetween(Long value1, Long value2) {
            addCriterion("wedding_talent_id between", value1, value2, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andWeddingTalentIdNotBetween(Long value1, Long value2) {
            addCriterion("wedding_talent_id not between", value1, value2, "weddingTalentId");
            return (Criteria) this;
        }

        public Criteria andReservedDateIsNull() {
            addCriterion("reserved_date is null");
            return (Criteria) this;
        }

        public Criteria andReservedDateIsNotNull() {
            addCriterion("reserved_date is not null");
            return (Criteria) this;
        }

        public Criteria andReservedDateEqualTo(Date value) {
            addCriterionForJDBCDate("reserved_date =", value, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("reserved_date <>", value, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateGreaterThan(Date value) {
            addCriterionForJDBCDate("reserved_date >", value, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("reserved_date >=", value, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateLessThan(Date value) {
            addCriterionForJDBCDate("reserved_date <", value, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("reserved_date <=", value, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateIn(List<Date> values) {
            addCriterionForJDBCDate("reserved_date in", values, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("reserved_date not in", values, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("reserved_date between", value1, value2, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andReservedDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("reserved_date not between", value1, value2, "reservedDate");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNull() {
            addCriterion("updated_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNotNull() {
            addCriterion("updated_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateEqualTo(Date value) {
            addCriterion("updated_date =", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotEqualTo(Date value) {
            addCriterion("updated_date <>", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThan(Date value) {
            addCriterion("updated_date >", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_date >=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThan(Date value) {
            addCriterion("updated_date <", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThanOrEqualTo(Date value) {
            addCriterion("updated_date <=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIn(List<Date> values) {
            addCriterion("updated_date in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotIn(List<Date> values) {
            addCriterion("updated_date not in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateBetween(Date value1, Date value2) {
            addCriterion("updated_date between", value1, value2, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotBetween(Date value1, Date value2) {
            addCriterion("updated_date not between", value1, value2, "updatedDate");
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
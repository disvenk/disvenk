package com.yepao.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWeipayidIsNull() {
            addCriterion("weiPayId is null");
            return (Criteria) this;
        }

        public Criteria andWeipayidIsNotNull() {
            addCriterion("weiPayId is not null");
            return (Criteria) this;
        }

        public Criteria andWeipayidEqualTo(String value) {
            addCriterion("weiPayId =", value, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidNotEqualTo(String value) {
            addCriterion("weiPayId <>", value, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidGreaterThan(String value) {
            addCriterion("weiPayId >", value, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidGreaterThanOrEqualTo(String value) {
            addCriterion("weiPayId >=", value, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidLessThan(String value) {
            addCriterion("weiPayId <", value, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidLessThanOrEqualTo(String value) {
            addCriterion("weiPayId <=", value, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidLike(String value) {
            addCriterion("weiPayId like", value, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidNotLike(String value) {
            addCriterion("weiPayId not like", value, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidIn(List<String> values) {
            addCriterion("weiPayId in", values, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidNotIn(List<String> values) {
            addCriterion("weiPayId not in", values, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidBetween(String value1, String value2) {
            addCriterion("weiPayId between", value1, value2, "weipayid");
            return (Criteria) this;
        }

        public Criteria andWeipayidNotBetween(String value1, String value2) {
            addCriterion("weiPayId not between", value1, value2, "weipayid");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIsNull() {
            addCriterion("prePay_id is null");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIsNotNull() {
            addCriterion("prePay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayIdEqualTo(String value) {
            addCriterion("prePay_id =", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotEqualTo(String value) {
            addCriterion("prePay_id <>", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdGreaterThan(String value) {
            addCriterion("prePay_id >", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdGreaterThanOrEqualTo(String value) {
            addCriterion("prePay_id >=", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLessThan(String value) {
            addCriterion("prePay_id <", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLessThanOrEqualTo(String value) {
            addCriterion("prePay_id <=", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLike(String value) {
            addCriterion("prePay_id like", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotLike(String value) {
            addCriterion("prePay_id not like", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIn(List<String> values) {
            addCriterion("prePay_id in", values, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotIn(List<String> values) {
            addCriterion("prePay_id not in", values, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdBetween(String value1, String value2) {
            addCriterion("prePay_id between", value1, value2, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotBetween(String value1, String value2) {
            addCriterion("prePay_id not between", value1, value2, "prepayId");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(String value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(String value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(String value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(String value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLike(String value) {
            addCriterion("customer_id like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotLike(String value) {
            addCriterion("customer_id not like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<String> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<String> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(String value1, String value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(String value1, String value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andHallIsNull() {
            addCriterion("hall is null");
            return (Criteria) this;
        }

        public Criteria andHallIsNotNull() {
            addCriterion("hall is not null");
            return (Criteria) this;
        }

        public Criteria andHallEqualTo(String value) {
            addCriterion("hall =", value, "hall");
            return (Criteria) this;
        }

        public Criteria andHallNotEqualTo(String value) {
            addCriterion("hall <>", value, "hall");
            return (Criteria) this;
        }

        public Criteria andHallGreaterThan(String value) {
            addCriterion("hall >", value, "hall");
            return (Criteria) this;
        }

        public Criteria andHallGreaterThanOrEqualTo(String value) {
            addCriterion("hall >=", value, "hall");
            return (Criteria) this;
        }

        public Criteria andHallLessThan(String value) {
            addCriterion("hall <", value, "hall");
            return (Criteria) this;
        }

        public Criteria andHallLessThanOrEqualTo(String value) {
            addCriterion("hall <=", value, "hall");
            return (Criteria) this;
        }

        public Criteria andHallLike(String value) {
            addCriterion("hall like", value, "hall");
            return (Criteria) this;
        }

        public Criteria andHallNotLike(String value) {
            addCriterion("hall not like", value, "hall");
            return (Criteria) this;
        }

        public Criteria andHallIn(List<String> values) {
            addCriterion("hall in", values, "hall");
            return (Criteria) this;
        }

        public Criteria andHallNotIn(List<String> values) {
            addCriterion("hall not in", values, "hall");
            return (Criteria) this;
        }

        public Criteria andHallBetween(String value1, String value2) {
            addCriterion("hall between", value1, value2, "hall");
            return (Criteria) this;
        }

        public Criteria andHallNotBetween(String value1, String value2) {
            addCriterion("hall not between", value1, value2, "hall");
            return (Criteria) this;
        }

        public Criteria andComboIsNull() {
            addCriterion("combo is null");
            return (Criteria) this;
        }

        public Criteria andComboIsNotNull() {
            addCriterion("combo is not null");
            return (Criteria) this;
        }

        public Criteria andComboEqualTo(String value) {
            addCriterion("combo =", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboNotEqualTo(String value) {
            addCriterion("combo <>", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboGreaterThan(String value) {
            addCriterion("combo >", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboGreaterThanOrEqualTo(String value) {
            addCriterion("combo >=", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboLessThan(String value) {
            addCriterion("combo <", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboLessThanOrEqualTo(String value) {
            addCriterion("combo <=", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboLike(String value) {
            addCriterion("combo like", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboNotLike(String value) {
            addCriterion("combo not like", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboIn(List<String> values) {
            addCriterion("combo in", values, "combo");
            return (Criteria) this;
        }

        public Criteria andComboNotIn(List<String> values) {
            addCriterion("combo not in", values, "combo");
            return (Criteria) this;
        }

        public Criteria andComboBetween(String value1, String value2) {
            addCriterion("combo between", value1, value2, "combo");
            return (Criteria) this;
        }

        public Criteria andComboNotBetween(String value1, String value2) {
            addCriterion("combo not between", value1, value2, "combo");
            return (Criteria) this;
        }

        public Criteria andCelebrationIsNull() {
            addCriterion("celebration is null");
            return (Criteria) this;
        }

        public Criteria andCelebrationIsNotNull() {
            addCriterion("celebration is not null");
            return (Criteria) this;
        }

        public Criteria andCelebrationEqualTo(String value) {
            addCriterion("celebration =", value, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationNotEqualTo(String value) {
            addCriterion("celebration <>", value, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationGreaterThan(String value) {
            addCriterion("celebration >", value, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationGreaterThanOrEqualTo(String value) {
            addCriterion("celebration >=", value, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationLessThan(String value) {
            addCriterion("celebration <", value, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationLessThanOrEqualTo(String value) {
            addCriterion("celebration <=", value, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationLike(String value) {
            addCriterion("celebration like", value, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationNotLike(String value) {
            addCriterion("celebration not like", value, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationIn(List<String> values) {
            addCriterion("celebration in", values, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationNotIn(List<String> values) {
            addCriterion("celebration not in", values, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationBetween(String value1, String value2) {
            addCriterion("celebration between", value1, value2, "celebration");
            return (Criteria) this;
        }

        public Criteria andCelebrationNotBetween(String value1, String value2) {
            addCriterion("celebration not between", value1, value2, "celebration");
            return (Criteria) this;
        }

        public Criteria andTalentIsNull() {
            addCriterion("talent is null");
            return (Criteria) this;
        }

        public Criteria andTalentIsNotNull() {
            addCriterion("talent is not null");
            return (Criteria) this;
        }

        public Criteria andTalentEqualTo(String value) {
            addCriterion("talent =", value, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentNotEqualTo(String value) {
            addCriterion("talent <>", value, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentGreaterThan(String value) {
            addCriterion("talent >", value, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentGreaterThanOrEqualTo(String value) {
            addCriterion("talent >=", value, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentLessThan(String value) {
            addCriterion("talent <", value, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentLessThanOrEqualTo(String value) {
            addCriterion("talent <=", value, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentLike(String value) {
            addCriterion("talent like", value, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentNotLike(String value) {
            addCriterion("talent not like", value, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentIn(List<String> values) {
            addCriterion("talent in", values, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentNotIn(List<String> values) {
            addCriterion("talent not in", values, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentBetween(String value1, String value2) {
            addCriterion("talent between", value1, value2, "talent");
            return (Criteria) this;
        }

        public Criteria andTalentNotBetween(String value1, String value2) {
            addCriterion("talent not between", value1, value2, "talent");
            return (Criteria) this;
        }

        public Criteria andPrepayIsNull() {
            addCriterion("prePay is null");
            return (Criteria) this;
        }

        public Criteria andPrepayIsNotNull() {
            addCriterion("prePay is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayEqualTo(BigDecimal value) {
            addCriterion("prePay =", value, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayNotEqualTo(BigDecimal value) {
            addCriterion("prePay <>", value, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayGreaterThan(BigDecimal value) {
            addCriterion("prePay >", value, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prePay >=", value, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayLessThan(BigDecimal value) {
            addCriterion("prePay <", value, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prePay <=", value, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayIn(List<BigDecimal> values) {
            addCriterion("prePay in", values, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayNotIn(List<BigDecimal> values) {
            addCriterion("prePay not in", values, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prePay between", value1, value2, "prepay");
            return (Criteria) this;
        }

        public Criteria andPrepayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prePay not between", value1, value2, "prepay");
            return (Criteria) this;
        }

        public Criteria andObligationIsNull() {
            addCriterion("obligation is null");
            return (Criteria) this;
        }

        public Criteria andObligationIsNotNull() {
            addCriterion("obligation is not null");
            return (Criteria) this;
        }

        public Criteria andObligationEqualTo(BigDecimal value) {
            addCriterion("obligation =", value, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationNotEqualTo(BigDecimal value) {
            addCriterion("obligation <>", value, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationGreaterThan(BigDecimal value) {
            addCriterion("obligation >", value, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("obligation >=", value, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationLessThan(BigDecimal value) {
            addCriterion("obligation <", value, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("obligation <=", value, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationIn(List<BigDecimal> values) {
            addCriterion("obligation in", values, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationNotIn(List<BigDecimal> values) {
            addCriterion("obligation not in", values, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("obligation between", value1, value2, "obligation");
            return (Criteria) this;
        }

        public Criteria andObligationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("obligation not between", value1, value2, "obligation");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(BigDecimal value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(BigDecimal value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(BigDecimal value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(BigDecimal value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<BigDecimal> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<BigDecimal> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCheckedIsNull() {
            addCriterion("checked is null");
            return (Criteria) this;
        }

        public Criteria andCheckedIsNotNull() {
            addCriterion("checked is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedEqualTo(String value) {
            addCriterion("checked =", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotEqualTo(String value) {
            addCriterion("checked <>", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedGreaterThan(String value) {
            addCriterion("checked >", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedGreaterThanOrEqualTo(String value) {
            addCriterion("checked >=", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedLessThan(String value) {
            addCriterion("checked <", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedLessThanOrEqualTo(String value) {
            addCriterion("checked <=", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedLike(String value) {
            addCriterion("checked like", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotLike(String value) {
            addCriterion("checked not like", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedIn(List<String> values) {
            addCriterion("checked in", values, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotIn(List<String> values) {
            addCriterion("checked not in", values, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedBetween(String value1, String value2) {
            addCriterion("checked between", value1, value2, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotBetween(String value1, String value2) {
            addCriterion("checked not between", value1, value2, "checked");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andClosedIsNull() {
            addCriterion("closed is null");
            return (Criteria) this;
        }

        public Criteria andClosedIsNotNull() {
            addCriterion("closed is not null");
            return (Criteria) this;
        }

        public Criteria andClosedEqualTo(Date value) {
            addCriterion("closed =", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotEqualTo(Date value) {
            addCriterion("closed <>", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedGreaterThan(Date value) {
            addCriterion("closed >", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedGreaterThanOrEqualTo(Date value) {
            addCriterion("closed >=", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedLessThan(Date value) {
            addCriterion("closed <", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedLessThanOrEqualTo(Date value) {
            addCriterion("closed <=", value, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedIn(List<Date> values) {
            addCriterion("closed in", values, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotIn(List<Date> values) {
            addCriterion("closed not in", values, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedBetween(Date value1, Date value2) {
            addCriterion("closed between", value1, value2, "closed");
            return (Criteria) this;
        }

        public Criteria andClosedNotBetween(Date value1, Date value2) {
            addCriterion("closed not between", value1, value2, "closed");
            return (Criteria) this;
        }

        public Criteria andPrepayedIsNull() {
            addCriterion("prepayed is null");
            return (Criteria) this;
        }

        public Criteria andPrepayedIsNotNull() {
            addCriterion("prepayed is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayedEqualTo(Date value) {
            addCriterion("prepayed =", value, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedNotEqualTo(Date value) {
            addCriterion("prepayed <>", value, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedGreaterThan(Date value) {
            addCriterion("prepayed >", value, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedGreaterThanOrEqualTo(Date value) {
            addCriterion("prepayed >=", value, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedLessThan(Date value) {
            addCriterion("prepayed <", value, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedLessThanOrEqualTo(Date value) {
            addCriterion("prepayed <=", value, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedIn(List<Date> values) {
            addCriterion("prepayed in", values, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedNotIn(List<Date> values) {
            addCriterion("prepayed not in", values, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedBetween(Date value1, Date value2) {
            addCriterion("prepayed between", value1, value2, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPrepayedNotBetween(Date value1, Date value2) {
            addCriterion("prepayed not between", value1, value2, "prepayed");
            return (Criteria) this;
        }

        public Criteria andPayedIsNull() {
            addCriterion("payed is null");
            return (Criteria) this;
        }

        public Criteria andPayedIsNotNull() {
            addCriterion("payed is not null");
            return (Criteria) this;
        }

        public Criteria andPayedEqualTo(Date value) {
            addCriterion("payed =", value, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedNotEqualTo(Date value) {
            addCriterion("payed <>", value, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedGreaterThan(Date value) {
            addCriterion("payed >", value, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedGreaterThanOrEqualTo(Date value) {
            addCriterion("payed >=", value, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedLessThan(Date value) {
            addCriterion("payed <", value, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedLessThanOrEqualTo(Date value) {
            addCriterion("payed <=", value, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedIn(List<Date> values) {
            addCriterion("payed in", values, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedNotIn(List<Date> values) {
            addCriterion("payed not in", values, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedBetween(Date value1, Date value2) {
            addCriterion("payed between", value1, value2, "payed");
            return (Criteria) this;
        }

        public Criteria andPayedNotBetween(Date value1, Date value2) {
            addCriterion("payed not between", value1, value2, "payed");
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
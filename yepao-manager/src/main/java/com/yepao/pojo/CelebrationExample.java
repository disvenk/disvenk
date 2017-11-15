package com.yepao.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CelebrationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CelebrationExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStyleIsNull() {
            addCriterion("style is null");
            return (Criteria) this;
        }

        public Criteria andStyleIsNotNull() {
            addCriterion("style is not null");
            return (Criteria) this;
        }

        public Criteria andStyleEqualTo(String value) {
            addCriterion("style =", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotEqualTo(String value) {
            addCriterion("style <>", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThan(String value) {
            addCriterion("style >", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThanOrEqualTo(String value) {
            addCriterion("style >=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThan(String value) {
            addCriterion("style <", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThanOrEqualTo(String value) {
            addCriterion("style <=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLike(String value) {
            addCriterion("style like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotLike(String value) {
            addCriterion("style not like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleIn(List<String> values) {
            addCriterion("style in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotIn(List<String> values) {
            addCriterion("style not in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleBetween(String value1, String value2) {
            addCriterion("style between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotBetween(String value1, String value2) {
            addCriterion("style not between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addCriterion("theme =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addCriterion("theme >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addCriterion("theme <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addCriterion("theme like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addCriterion("theme not like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addCriterion("theme in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andPrepriceIsNull() {
            addCriterion("prePrice is null");
            return (Criteria) this;
        }

        public Criteria andPrepriceIsNotNull() {
            addCriterion("prePrice is not null");
            return (Criteria) this;
        }

        public Criteria andPrepriceEqualTo(BigDecimal value) {
            addCriterion("prePrice =", value, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceNotEqualTo(BigDecimal value) {
            addCriterion("prePrice <>", value, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceGreaterThan(BigDecimal value) {
            addCriterion("prePrice >", value, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prePrice >=", value, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceLessThan(BigDecimal value) {
            addCriterion("prePrice <", value, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prePrice <=", value, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceIn(List<BigDecimal> values) {
            addCriterion("prePrice in", values, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceNotIn(List<BigDecimal> values) {
            addCriterion("prePrice not in", values, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prePrice between", value1, value2, "preprice");
            return (Criteria) this;
        }

        public Criteria andPrepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prePrice not between", value1, value2, "preprice");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andCombonameIsNull() {
            addCriterion("comboName is null");
            return (Criteria) this;
        }

        public Criteria andCombonameIsNotNull() {
            addCriterion("comboName is not null");
            return (Criteria) this;
        }

        public Criteria andCombonameEqualTo(String value) {
            addCriterion("comboName =", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameNotEqualTo(String value) {
            addCriterion("comboName <>", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameGreaterThan(String value) {
            addCriterion("comboName >", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameGreaterThanOrEqualTo(String value) {
            addCriterion("comboName >=", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameLessThan(String value) {
            addCriterion("comboName <", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameLessThanOrEqualTo(String value) {
            addCriterion("comboName <=", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameLike(String value) {
            addCriterion("comboName like", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameNotLike(String value) {
            addCriterion("comboName not like", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameIn(List<String> values) {
            addCriterion("comboName in", values, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameNotIn(List<String> values) {
            addCriterion("comboName not in", values, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameBetween(String value1, String value2) {
            addCriterion("comboName between", value1, value2, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameNotBetween(String value1, String value2) {
            addCriterion("comboName not between", value1, value2, "comboname");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andHostIsNull() {
            addCriterion("host is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("host is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(String value) {
            addCriterion("host =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(String value) {
            addCriterion("host <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(String value) {
            addCriterion("host >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(String value) {
            addCriterion("host >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(String value) {
            addCriterion("host <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(String value) {
            addCriterion("host <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLike(String value) {
            addCriterion("host like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotLike(String value) {
            addCriterion("host not like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(List<String> values) {
            addCriterion("host in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(List<String> values) {
            addCriterion("host not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(String value1, String value2) {
            addCriterion("host between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(String value1, String value2) {
            addCriterion("host not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andDresserIsNull() {
            addCriterion("dresser is null");
            return (Criteria) this;
        }

        public Criteria andDresserIsNotNull() {
            addCriterion("dresser is not null");
            return (Criteria) this;
        }

        public Criteria andDresserEqualTo(String value) {
            addCriterion("dresser =", value, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserNotEqualTo(String value) {
            addCriterion("dresser <>", value, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserGreaterThan(String value) {
            addCriterion("dresser >", value, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserGreaterThanOrEqualTo(String value) {
            addCriterion("dresser >=", value, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserLessThan(String value) {
            addCriterion("dresser <", value, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserLessThanOrEqualTo(String value) {
            addCriterion("dresser <=", value, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserLike(String value) {
            addCriterion("dresser like", value, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserNotLike(String value) {
            addCriterion("dresser not like", value, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserIn(List<String> values) {
            addCriterion("dresser in", values, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserNotIn(List<String> values) {
            addCriterion("dresser not in", values, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserBetween(String value1, String value2) {
            addCriterion("dresser between", value1, value2, "dresser");
            return (Criteria) this;
        }

        public Criteria andDresserNotBetween(String value1, String value2) {
            addCriterion("dresser not between", value1, value2, "dresser");
            return (Criteria) this;
        }

        public Criteria andPhotograperIsNull() {
            addCriterion("photograper is null");
            return (Criteria) this;
        }

        public Criteria andPhotograperIsNotNull() {
            addCriterion("photograper is not null");
            return (Criteria) this;
        }

        public Criteria andPhotograperEqualTo(String value) {
            addCriterion("photograper =", value, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperNotEqualTo(String value) {
            addCriterion("photograper <>", value, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperGreaterThan(String value) {
            addCriterion("photograper >", value, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperGreaterThanOrEqualTo(String value) {
            addCriterion("photograper >=", value, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperLessThan(String value) {
            addCriterion("photograper <", value, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperLessThanOrEqualTo(String value) {
            addCriterion("photograper <=", value, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperLike(String value) {
            addCriterion("photograper like", value, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperNotLike(String value) {
            addCriterion("photograper not like", value, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperIn(List<String> values) {
            addCriterion("photograper in", values, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperNotIn(List<String> values) {
            addCriterion("photograper not in", values, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperBetween(String value1, String value2) {
            addCriterion("photograper between", value1, value2, "photograper");
            return (Criteria) this;
        }

        public Criteria andPhotograperNotBetween(String value1, String value2) {
            addCriterion("photograper not between", value1, value2, "photograper");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andWelcomeIsNull() {
            addCriterion("welcome is null");
            return (Criteria) this;
        }

        public Criteria andWelcomeIsNotNull() {
            addCriterion("welcome is not null");
            return (Criteria) this;
        }

        public Criteria andWelcomeEqualTo(String value) {
            addCriterion("welcome =", value, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeNotEqualTo(String value) {
            addCriterion("welcome <>", value, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeGreaterThan(String value) {
            addCriterion("welcome >", value, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeGreaterThanOrEqualTo(String value) {
            addCriterion("welcome >=", value, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeLessThan(String value) {
            addCriterion("welcome <", value, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeLessThanOrEqualTo(String value) {
            addCriterion("welcome <=", value, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeLike(String value) {
            addCriterion("welcome like", value, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeNotLike(String value) {
            addCriterion("welcome not like", value, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeIn(List<String> values) {
            addCriterion("welcome in", values, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeNotIn(List<String> values) {
            addCriterion("welcome not in", values, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeBetween(String value1, String value2) {
            addCriterion("welcome between", value1, value2, "welcome");
            return (Criteria) this;
        }

        public Criteria andWelcomeNotBetween(String value1, String value2) {
            addCriterion("welcome not between", value1, value2, "welcome");
            return (Criteria) this;
        }

        public Criteria andCeremonyIsNull() {
            addCriterion("ceremony is null");
            return (Criteria) this;
        }

        public Criteria andCeremonyIsNotNull() {
            addCriterion("ceremony is not null");
            return (Criteria) this;
        }

        public Criteria andCeremonyEqualTo(String value) {
            addCriterion("ceremony =", value, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyNotEqualTo(String value) {
            addCriterion("ceremony <>", value, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyGreaterThan(String value) {
            addCriterion("ceremony >", value, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyGreaterThanOrEqualTo(String value) {
            addCriterion("ceremony >=", value, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyLessThan(String value) {
            addCriterion("ceremony <", value, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyLessThanOrEqualTo(String value) {
            addCriterion("ceremony <=", value, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyLike(String value) {
            addCriterion("ceremony like", value, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyNotLike(String value) {
            addCriterion("ceremony not like", value, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyIn(List<String> values) {
            addCriterion("ceremony in", values, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyNotIn(List<String> values) {
            addCriterion("ceremony not in", values, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyBetween(String value1, String value2) {
            addCriterion("ceremony between", value1, value2, "ceremony");
            return (Criteria) this;
        }

        public Criteria andCeremonyNotBetween(String value1, String value2) {
            addCriterion("ceremony not between", value1, value2, "ceremony");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceIsNull() {
            addCriterion("weddingPlace is null");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceIsNotNull() {
            addCriterion("weddingPlace is not null");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceEqualTo(String value) {
            addCriterion("weddingPlace =", value, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceNotEqualTo(String value) {
            addCriterion("weddingPlace <>", value, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceGreaterThan(String value) {
            addCriterion("weddingPlace >", value, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceGreaterThanOrEqualTo(String value) {
            addCriterion("weddingPlace >=", value, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceLessThan(String value) {
            addCriterion("weddingPlace <", value, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceLessThanOrEqualTo(String value) {
            addCriterion("weddingPlace <=", value, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceLike(String value) {
            addCriterion("weddingPlace like", value, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceNotLike(String value) {
            addCriterion("weddingPlace not like", value, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceIn(List<String> values) {
            addCriterion("weddingPlace in", values, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceNotIn(List<String> values) {
            addCriterion("weddingPlace not in", values, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceBetween(String value1, String value2) {
            addCriterion("weddingPlace between", value1, value2, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andWeddingplaceNotBetween(String value1, String value2) {
            addCriterion("weddingPlace not between", value1, value2, "weddingplace");
            return (Criteria) this;
        }

        public Criteria andDesklightIsNull() {
            addCriterion("deskLight is null");
            return (Criteria) this;
        }

        public Criteria andDesklightIsNotNull() {
            addCriterion("deskLight is not null");
            return (Criteria) this;
        }

        public Criteria andDesklightEqualTo(String value) {
            addCriterion("deskLight =", value, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightNotEqualTo(String value) {
            addCriterion("deskLight <>", value, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightGreaterThan(String value) {
            addCriterion("deskLight >", value, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightGreaterThanOrEqualTo(String value) {
            addCriterion("deskLight >=", value, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightLessThan(String value) {
            addCriterion("deskLight <", value, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightLessThanOrEqualTo(String value) {
            addCriterion("deskLight <=", value, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightLike(String value) {
            addCriterion("deskLight like", value, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightNotLike(String value) {
            addCriterion("deskLight not like", value, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightIn(List<String> values) {
            addCriterion("deskLight in", values, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightNotIn(List<String> values) {
            addCriterion("deskLight not in", values, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightBetween(String value1, String value2) {
            addCriterion("deskLight between", value1, value2, "desklight");
            return (Criteria) this;
        }

        public Criteria andDesklightNotBetween(String value1, String value2) {
            addCriterion("deskLight not between", value1, value2, "desklight");
            return (Criteria) this;
        }

        public Criteria andStandbyIsNull() {
            addCriterion("standby is null");
            return (Criteria) this;
        }

        public Criteria andStandbyIsNotNull() {
            addCriterion("standby is not null");
            return (Criteria) this;
        }

        public Criteria andStandbyEqualTo(String value) {
            addCriterion("standby =", value, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyNotEqualTo(String value) {
            addCriterion("standby <>", value, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyGreaterThan(String value) {
            addCriterion("standby >", value, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyGreaterThanOrEqualTo(String value) {
            addCriterion("standby >=", value, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyLessThan(String value) {
            addCriterion("standby <", value, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyLessThanOrEqualTo(String value) {
            addCriterion("standby <=", value, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyLike(String value) {
            addCriterion("standby like", value, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyNotLike(String value) {
            addCriterion("standby not like", value, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyIn(List<String> values) {
            addCriterion("standby in", values, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyNotIn(List<String> values) {
            addCriterion("standby not in", values, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyBetween(String value1, String value2) {
            addCriterion("standby between", value1, value2, "standby");
            return (Criteria) this;
        }

        public Criteria andStandbyNotBetween(String value1, String value2) {
            addCriterion("standby not between", value1, value2, "standby");
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
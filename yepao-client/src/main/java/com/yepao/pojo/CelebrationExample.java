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

        public Criteria andHotelidIsNull() {
            addCriterion("hotelId is null");
            return (Criteria) this;
        }

        public Criteria andHotelidIsNotNull() {
            addCriterion("hotelId is not null");
            return (Criteria) this;
        }

        public Criteria andHotelidEqualTo(Long value) {
            addCriterion("hotelId =", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotEqualTo(Long value) {
            addCriterion("hotelId <>", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidGreaterThan(Long value) {
            addCriterion("hotelId >", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidGreaterThanOrEqualTo(Long value) {
            addCriterion("hotelId >=", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidLessThan(Long value) {
            addCriterion("hotelId <", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidLessThanOrEqualTo(Long value) {
            addCriterion("hotelId <=", value, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidIn(List<Long> values) {
            addCriterion("hotelId in", values, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotIn(List<Long> values) {
            addCriterion("hotelId not in", values, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidBetween(Long value1, Long value2) {
            addCriterion("hotelId between", value1, value2, "hotelid");
            return (Criteria) this;
        }

        public Criteria andHotelidNotBetween(Long value1, Long value2) {
            addCriterion("hotelId not between", value1, value2, "hotelid");
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

        public Criteria andBasenameIsNull() {
            addCriterion("basename is null");
            return (Criteria) this;
        }

        public Criteria andBasenameIsNotNull() {
            addCriterion("basename is not null");
            return (Criteria) this;
        }

        public Criteria andBasenameEqualTo(String value) {
            addCriterion("basename =", value, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameNotEqualTo(String value) {
            addCriterion("basename <>", value, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameGreaterThan(String value) {
            addCriterion("basename >", value, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameGreaterThanOrEqualTo(String value) {
            addCriterion("basename >=", value, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameLessThan(String value) {
            addCriterion("basename <", value, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameLessThanOrEqualTo(String value) {
            addCriterion("basename <=", value, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameLike(String value) {
            addCriterion("basename like", value, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameNotLike(String value) {
            addCriterion("basename not like", value, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameIn(List<String> values) {
            addCriterion("basename in", values, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameNotIn(List<String> values) {
            addCriterion("basename not in", values, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameBetween(String value1, String value2) {
            addCriterion("basename between", value1, value2, "basename");
            return (Criteria) this;
        }

        public Criteria andBasenameNotBetween(String value1, String value2) {
            addCriterion("basename not between", value1, value2, "basename");
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

        public Criteria andIsStageIsNull() {
            addCriterion("is_stage is null");
            return (Criteria) this;
        }

        public Criteria andIsStageIsNotNull() {
            addCriterion("is_stage is not null");
            return (Criteria) this;
        }

        public Criteria andIsStageEqualTo(String value) {
            addCriterion("is_stage =", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageNotEqualTo(String value) {
            addCriterion("is_stage <>", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageGreaterThan(String value) {
            addCriterion("is_stage >", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageGreaterThanOrEqualTo(String value) {
            addCriterion("is_stage >=", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageLessThan(String value) {
            addCriterion("is_stage <", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageLessThanOrEqualTo(String value) {
            addCriterion("is_stage <=", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageLike(String value) {
            addCriterion("is_stage like", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageNotLike(String value) {
            addCriterion("is_stage not like", value, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageIn(List<String> values) {
            addCriterion("is_stage in", values, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageNotIn(List<String> values) {
            addCriterion("is_stage not in", values, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageBetween(String value1, String value2) {
            addCriterion("is_stage between", value1, value2, "isStage");
            return (Criteria) this;
        }

        public Criteria andIsStageNotBetween(String value1, String value2) {
            addCriterion("is_stage not between", value1, value2, "isStage");
            return (Criteria) this;
        }

        public Criteria andComboStyleIsNull() {
            addCriterion("combo_style is null");
            return (Criteria) this;
        }

        public Criteria andComboStyleIsNotNull() {
            addCriterion("combo_style is not null");
            return (Criteria) this;
        }

        public Criteria andComboStyleEqualTo(String value) {
            addCriterion("combo_style =", value, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleNotEqualTo(String value) {
            addCriterion("combo_style <>", value, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleGreaterThan(String value) {
            addCriterion("combo_style >", value, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleGreaterThanOrEqualTo(String value) {
            addCriterion("combo_style >=", value, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleLessThan(String value) {
            addCriterion("combo_style <", value, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleLessThanOrEqualTo(String value) {
            addCriterion("combo_style <=", value, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleLike(String value) {
            addCriterion("combo_style like", value, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleNotLike(String value) {
            addCriterion("combo_style not like", value, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleIn(List<String> values) {
            addCriterion("combo_style in", values, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleNotIn(List<String> values) {
            addCriterion("combo_style not in", values, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleBetween(String value1, String value2) {
            addCriterion("combo_style between", value1, value2, "comboStyle");
            return (Criteria) this;
        }

        public Criteria andComboStyleNotBetween(String value1, String value2) {
            addCriterion("combo_style not between", value1, value2, "comboStyle");
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

        public Criteria andStagePriceIsNull() {
            addCriterion("stage_price is null");
            return (Criteria) this;
        }

        public Criteria andStagePriceIsNotNull() {
            addCriterion("stage_price is not null");
            return (Criteria) this;
        }

        public Criteria andStagePriceEqualTo(BigDecimal value) {
            addCriterion("stage_price =", value, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceNotEqualTo(BigDecimal value) {
            addCriterion("stage_price <>", value, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceGreaterThan(BigDecimal value) {
            addCriterion("stage_price >", value, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stage_price >=", value, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceLessThan(BigDecimal value) {
            addCriterion("stage_price <", value, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stage_price <=", value, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceIn(List<BigDecimal> values) {
            addCriterion("stage_price in", values, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceNotIn(List<BigDecimal> values) {
            addCriterion("stage_price not in", values, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stage_price between", value1, value2, "stagePrice");
            return (Criteria) this;
        }

        public Criteria andStagePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stage_price not between", value1, value2, "stagePrice");
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

        public Criteria andStageHolographicIsNull() {
            addCriterion("stage_holographic is null");
            return (Criteria) this;
        }

        public Criteria andStageHolographicIsNotNull() {
            addCriterion("stage_holographic is not null");
            return (Criteria) this;
        }

        public Criteria andStageHolographicEqualTo(String value) {
            addCriterion("stage_holographic =", value, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicNotEqualTo(String value) {
            addCriterion("stage_holographic <>", value, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicGreaterThan(String value) {
            addCriterion("stage_holographic >", value, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicGreaterThanOrEqualTo(String value) {
            addCriterion("stage_holographic >=", value, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicLessThan(String value) {
            addCriterion("stage_holographic <", value, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicLessThanOrEqualTo(String value) {
            addCriterion("stage_holographic <=", value, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicLike(String value) {
            addCriterion("stage_holographic like", value, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicNotLike(String value) {
            addCriterion("stage_holographic not like", value, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicIn(List<String> values) {
            addCriterion("stage_holographic in", values, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicNotIn(List<String> values) {
            addCriterion("stage_holographic not in", values, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicBetween(String value1, String value2) {
            addCriterion("stage_holographic between", value1, value2, "stageHolographic");
            return (Criteria) this;
        }

        public Criteria andStageHolographicNotBetween(String value1, String value2) {
            addCriterion("stage_holographic not between", value1, value2, "stageHolographic");
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
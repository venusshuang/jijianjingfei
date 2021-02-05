package jjjf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZijinbofuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZijinbofuExample() {
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

        public Criteria andZijinbofuidIsNull() {
            addCriterion("zijinbofuid is null");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidIsNotNull() {
            addCriterion("zijinbofuid is not null");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidEqualTo(String value) {
            addCriterion("zijinbofuid =", value, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidNotEqualTo(String value) {
            addCriterion("zijinbofuid <>", value, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidGreaterThan(String value) {
            addCriterion("zijinbofuid >", value, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidGreaterThanOrEqualTo(String value) {
            addCriterion("zijinbofuid >=", value, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidLessThan(String value) {
            addCriterion("zijinbofuid <", value, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidLessThanOrEqualTo(String value) {
            addCriterion("zijinbofuid <=", value, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidLike(String value) {
            addCriterion("zijinbofuid like", value, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidNotLike(String value) {
            addCriterion("zijinbofuid not like", value, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidIn(List<String> values) {
            addCriterion("zijinbofuid in", values, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidNotIn(List<String> values) {
            addCriterion("zijinbofuid not in", values, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidBetween(String value1, String value2) {
            addCriterion("zijinbofuid between", value1, value2, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andZijinbofuidNotBetween(String value1, String value2) {
            addCriterion("zijinbofuid not between", value1, value2, "zijinbofuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidIsNull() {
            addCriterion("xiangmuid is null");
            return (Criteria) this;
        }

        public Criteria andXiangmuidIsNotNull() {
            addCriterion("xiangmuid is not null");
            return (Criteria) this;
        }

        public Criteria andXiangmuidEqualTo(String value) {
            addCriterion("xiangmuid =", value, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidNotEqualTo(String value) {
            addCriterion("xiangmuid <>", value, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidGreaterThan(String value) {
            addCriterion("xiangmuid >", value, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidGreaterThanOrEqualTo(String value) {
            addCriterion("xiangmuid >=", value, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidLessThan(String value) {
            addCriterion("xiangmuid <", value, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidLessThanOrEqualTo(String value) {
            addCriterion("xiangmuid <=", value, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidLike(String value) {
            addCriterion("xiangmuid like", value, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidNotLike(String value) {
            addCriterion("xiangmuid not like", value, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidIn(List<String> values) {
            addCriterion("xiangmuid in", values, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidNotIn(List<String> values) {
            addCriterion("xiangmuid not in", values, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidBetween(String value1, String value2) {
            addCriterion("xiangmuid between", value1, value2, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andXiangmuidNotBetween(String value1, String value2) {
            addCriterion("xiangmuid not between", value1, value2, "xiangmuid");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineIsNull() {
            addCriterion("lianbaobofujine is null");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineIsNotNull() {
            addCriterion("lianbaobofujine is not null");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineEqualTo(Double value) {
            addCriterion("lianbaobofujine =", value, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineNotEqualTo(Double value) {
            addCriterion("lianbaobofujine <>", value, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineGreaterThan(Double value) {
            addCriterion("lianbaobofujine >", value, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineGreaterThanOrEqualTo(Double value) {
            addCriterion("lianbaobofujine >=", value, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineLessThan(Double value) {
            addCriterion("lianbaobofujine <", value, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineLessThanOrEqualTo(Double value) {
            addCriterion("lianbaobofujine <=", value, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineIn(List<Double> values) {
            addCriterion("lianbaobofujine in", values, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineNotIn(List<Double> values) {
            addCriterion("lianbaobofujine not in", values, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineBetween(Double value1, Double value2) {
            addCriterion("lianbaobofujine between", value1, value2, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofujineNotBetween(Double value1, Double value2) {
            addCriterion("lianbaobofujine not between", value1, value2, "lianbaobofujine");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianIsNull() {
            addCriterion("lianbaobofushijian is null");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianIsNotNull() {
            addCriterion("lianbaobofushijian is not null");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianEqualTo(Date value) {
            addCriterion("lianbaobofushijian =", value, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianNotEqualTo(Date value) {
            addCriterion("lianbaobofushijian <>", value, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianGreaterThan(Date value) {
            addCriterion("lianbaobofushijian >", value, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianGreaterThanOrEqualTo(Date value) {
            addCriterion("lianbaobofushijian >=", value, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianLessThan(Date value) {
            addCriterion("lianbaobofushijian <", value, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianLessThanOrEqualTo(Date value) {
            addCriterion("lianbaobofushijian <=", value, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianIn(List<Date> values) {
            addCriterion("lianbaobofushijian in", values, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianNotIn(List<Date> values) {
            addCriterion("lianbaobofushijian not in", values, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianBetween(Date value1, Date value2) {
            addCriterion("lianbaobofushijian between", value1, value2, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andLianbaobofushijianNotBetween(Date value1, Date value2) {
            addCriterion("lianbaobofushijian not between", value1, value2, "lianbaobofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineIsNull() {
            addCriterion("zhongxinbofujine is null");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineIsNotNull() {
            addCriterion("zhongxinbofujine is not null");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineEqualTo(Double value) {
            addCriterion("zhongxinbofujine =", value, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineNotEqualTo(Double value) {
            addCriterion("zhongxinbofujine <>", value, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineGreaterThan(Double value) {
            addCriterion("zhongxinbofujine >", value, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineGreaterThanOrEqualTo(Double value) {
            addCriterion("zhongxinbofujine >=", value, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineLessThan(Double value) {
            addCriterion("zhongxinbofujine <", value, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineLessThanOrEqualTo(Double value) {
            addCriterion("zhongxinbofujine <=", value, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineIn(List<Double> values) {
            addCriterion("zhongxinbofujine in", values, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineNotIn(List<Double> values) {
            addCriterion("zhongxinbofujine not in", values, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineBetween(Double value1, Double value2) {
            addCriterion("zhongxinbofujine between", value1, value2, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofujineNotBetween(Double value1, Double value2) {
            addCriterion("zhongxinbofujine not between", value1, value2, "zhongxinbofujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianIsNull() {
            addCriterion("zhongxinbofushijian is null");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianIsNotNull() {
            addCriterion("zhongxinbofushijian is not null");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianEqualTo(Date value) {
            addCriterion("zhongxinbofushijian =", value, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianNotEqualTo(Date value) {
            addCriterion("zhongxinbofushijian <>", value, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianGreaterThan(Date value) {
            addCriterion("zhongxinbofushijian >", value, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianGreaterThanOrEqualTo(Date value) {
            addCriterion("zhongxinbofushijian >=", value, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianLessThan(Date value) {
            addCriterion("zhongxinbofushijian <", value, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianLessThanOrEqualTo(Date value) {
            addCriterion("zhongxinbofushijian <=", value, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianIn(List<Date> values) {
            addCriterion("zhongxinbofushijian in", values, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianNotIn(List<Date> values) {
            addCriterion("zhongxinbofushijian not in", values, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianBetween(Date value1, Date value2) {
            addCriterion("zhongxinbofushijian between", value1, value2, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andZhongxinbofushijianNotBetween(Date value1, Date value2) {
            addCriterion("zhongxinbofushijian not between", value1, value2, "zhongxinbofushijian");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNull() {
            addCriterion("lastupdatetime is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNotNull() {
            addCriterion("lastupdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeEqualTo(Date value) {
            addCriterion("lastupdatetime =", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotEqualTo(Date value) {
            addCriterion("lastupdatetime <>", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThan(Date value) {
            addCriterion("lastupdatetime >", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastupdatetime >=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThan(Date value) {
            addCriterion("lastupdatetime <", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("lastupdatetime <=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIn(List<Date> values) {
            addCriterion("lastupdatetime in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotIn(List<Date> values) {
            addCriterion("lastupdatetime not in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("lastupdatetime between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("lastupdatetime not between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiIsNull() {
            addCriterion("zhuangtai is null");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiIsNotNull() {
            addCriterion("zhuangtai is not null");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiEqualTo(Integer value) {
            addCriterion("zhuangtai =", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiNotEqualTo(Integer value) {
            addCriterion("zhuangtai <>", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiGreaterThan(Integer value) {
            addCriterion("zhuangtai >", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhuangtai >=", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiLessThan(Integer value) {
            addCriterion("zhuangtai <", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiLessThanOrEqualTo(Integer value) {
            addCriterion("zhuangtai <=", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiIn(List<Integer> values) {
            addCriterion("zhuangtai in", values, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiNotIn(List<Integer> values) {
            addCriterion("zhuangtai not in", values, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiBetween(Integer value1, Integer value2) {
            addCriterion("zhuangtai between", value1, value2, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiNotBetween(Integer value1, Integer value2) {
            addCriterion("zhuangtai not between", value1, value2, "zhuangtai");
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
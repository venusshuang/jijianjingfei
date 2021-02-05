package jjjf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZijinshenqingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZijinshenqingExample() {
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

        public Criteria andZijinshenqingidIsNull() {
            addCriterion("zijinshenqingid is null");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidIsNotNull() {
            addCriterion("zijinshenqingid is not null");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidEqualTo(String value) {
            addCriterion("zijinshenqingid =", value, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidNotEqualTo(String value) {
            addCriterion("zijinshenqingid <>", value, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidGreaterThan(String value) {
            addCriterion("zijinshenqingid >", value, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidGreaterThanOrEqualTo(String value) {
            addCriterion("zijinshenqingid >=", value, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidLessThan(String value) {
            addCriterion("zijinshenqingid <", value, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidLessThanOrEqualTo(String value) {
            addCriterion("zijinshenqingid <=", value, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidLike(String value) {
            addCriterion("zijinshenqingid like", value, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidNotLike(String value) {
            addCriterion("zijinshenqingid not like", value, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidIn(List<String> values) {
            addCriterion("zijinshenqingid in", values, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidNotIn(List<String> values) {
            addCriterion("zijinshenqingid not in", values, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidBetween(String value1, String value2) {
            addCriterion("zijinshenqingid between", value1, value2, "zijinshenqingid");
            return (Criteria) this;
        }

        public Criteria andZijinshenqingidNotBetween(String value1, String value2) {
            addCriterion("zijinshenqingid not between", value1, value2, "zijinshenqingid");
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

        public Criteria andXiangzhongxinshenqingzijinIsNull() {
            addCriterion("xiangzhongxinshenqingzijin is null");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinIsNotNull() {
            addCriterion("xiangzhongxinshenqingzijin is not null");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinEqualTo(Double value) {
            addCriterion("xiangzhongxinshenqingzijin =", value, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinNotEqualTo(Double value) {
            addCriterion("xiangzhongxinshenqingzijin <>", value, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinGreaterThan(Double value) {
            addCriterion("xiangzhongxinshenqingzijin >", value, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinGreaterThanOrEqualTo(Double value) {
            addCriterion("xiangzhongxinshenqingzijin >=", value, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinLessThan(Double value) {
            addCriterion("xiangzhongxinshenqingzijin <", value, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinLessThanOrEqualTo(Double value) {
            addCriterion("xiangzhongxinshenqingzijin <=", value, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinIn(List<Double> values) {
            addCriterion("xiangzhongxinshenqingzijin in", values, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinNotIn(List<Double> values) {
            addCriterion("xiangzhongxinshenqingzijin not in", values, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinBetween(Double value1, Double value2) {
            addCriterion("xiangzhongxinshenqingzijin between", value1, value2, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXiangzhongxinshenqingzijinNotBetween(Double value1, Double value2) {
            addCriterion("xiangzhongxinshenqingzijin not between", value1, value2, "xiangzhongxinshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianIsNull() {
            addCriterion("shenqingshijian is null");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianIsNotNull() {
            addCriterion("shenqingshijian is not null");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianEqualTo(Date value) {
            addCriterion("shenqingshijian =", value, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianNotEqualTo(Date value) {
            addCriterion("shenqingshijian <>", value, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianGreaterThan(Date value) {
            addCriterion("shenqingshijian >", value, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianGreaterThanOrEqualTo(Date value) {
            addCriterion("shenqingshijian >=", value, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianLessThan(Date value) {
            addCriterion("shenqingshijian <", value, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianLessThanOrEqualTo(Date value) {
            addCriterion("shenqingshijian <=", value, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianIn(List<Date> values) {
            addCriterion("shenqingshijian in", values, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianNotIn(List<Date> values) {
            addCriterion("shenqingshijian not in", values, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianBetween(Date value1, Date value2) {
            addCriterion("shenqingshijian between", value1, value2, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andShenqingshijianNotBetween(Date value1, Date value2) {
            addCriterion("shenqingshijian not between", value1, value2, "shenqingshijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinIsNull() {
            addCriterion("xianglianbaoshenqingzijin is null");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinIsNotNull() {
            addCriterion("xianglianbaoshenqingzijin is not null");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinEqualTo(Double value) {
            addCriterion("xianglianbaoshenqingzijin =", value, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinNotEqualTo(Double value) {
            addCriterion("xianglianbaoshenqingzijin <>", value, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinGreaterThan(Double value) {
            addCriterion("xianglianbaoshenqingzijin >", value, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinGreaterThanOrEqualTo(Double value) {
            addCriterion("xianglianbaoshenqingzijin >=", value, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinLessThan(Double value) {
            addCriterion("xianglianbaoshenqingzijin <", value, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinLessThanOrEqualTo(Double value) {
            addCriterion("xianglianbaoshenqingzijin <=", value, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinIn(List<Double> values) {
            addCriterion("xianglianbaoshenqingzijin in", values, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinNotIn(List<Double> values) {
            addCriterion("xianglianbaoshenqingzijin not in", values, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinBetween(Double value1, Double value2) {
            addCriterion("xianglianbaoshenqingzijin between", value1, value2, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingzijinNotBetween(Double value1, Double value2) {
            addCriterion("xianglianbaoshenqingzijin not between", value1, value2, "xianglianbaoshenqingzijin");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianIsNull() {
            addCriterion("xianglianbaoshenqingbofushijian is null");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianIsNotNull() {
            addCriterion("xianglianbaoshenqingbofushijian is not null");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianEqualTo(Date value) {
            addCriterion("xianglianbaoshenqingbofushijian =", value, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianNotEqualTo(Date value) {
            addCriterion("xianglianbaoshenqingbofushijian <>", value, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianGreaterThan(Date value) {
            addCriterion("xianglianbaoshenqingbofushijian >", value, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianGreaterThanOrEqualTo(Date value) {
            addCriterion("xianglianbaoshenqingbofushijian >=", value, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianLessThan(Date value) {
            addCriterion("xianglianbaoshenqingbofushijian <", value, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianLessThanOrEqualTo(Date value) {
            addCriterion("xianglianbaoshenqingbofushijian <=", value, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianIn(List<Date> values) {
            addCriterion("xianglianbaoshenqingbofushijian in", values, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianNotIn(List<Date> values) {
            addCriterion("xianglianbaoshenqingbofushijian not in", values, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianBetween(Date value1, Date value2) {
            addCriterion("xianglianbaoshenqingbofushijian between", value1, value2, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andXianglianbaoshenqingbofushijianNotBetween(Date value1, Date value2) {
            addCriterion("xianglianbaoshenqingbofushijian not between", value1, value2, "xianglianbaoshenqingbofushijian");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
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
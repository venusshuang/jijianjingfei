package jjjf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GongchengjinzhanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GongchengjinzhanExample() {
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

        public Criteria andGongchengjinzhanidIsNull() {
            addCriterion("gongchengjinzhanid is null");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidIsNotNull() {
            addCriterion("gongchengjinzhanid is not null");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidEqualTo(String value) {
            addCriterion("gongchengjinzhanid =", value, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidNotEqualTo(String value) {
            addCriterion("gongchengjinzhanid <>", value, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidGreaterThan(String value) {
            addCriterion("gongchengjinzhanid >", value, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidGreaterThanOrEqualTo(String value) {
            addCriterion("gongchengjinzhanid >=", value, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidLessThan(String value) {
            addCriterion("gongchengjinzhanid <", value, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidLessThanOrEqualTo(String value) {
            addCriterion("gongchengjinzhanid <=", value, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidLike(String value) {
            addCriterion("gongchengjinzhanid like", value, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidNotLike(String value) {
            addCriterion("gongchengjinzhanid not like", value, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidIn(List<String> values) {
            addCriterion("gongchengjinzhanid in", values, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidNotIn(List<String> values) {
            addCriterion("gongchengjinzhanid not in", values, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidBetween(String value1, String value2) {
            addCriterion("gongchengjinzhanid between", value1, value2, "gongchengjinzhanid");
            return (Criteria) this;
        }

        public Criteria andGongchengjinzhanidNotBetween(String value1, String value2) {
            addCriterion("gongchengjinzhanid not between", value1, value2, "gongchengjinzhanid");
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

        public Criteria andXiangmuzhuangtaiidIsNull() {
            addCriterion("xiangmuzhuangtaiid is null");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidIsNotNull() {
            addCriterion("xiangmuzhuangtaiid is not null");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidEqualTo(String value) {
            addCriterion("xiangmuzhuangtaiid =", value, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidNotEqualTo(String value) {
            addCriterion("xiangmuzhuangtaiid <>", value, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidGreaterThan(String value) {
            addCriterion("xiangmuzhuangtaiid >", value, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidGreaterThanOrEqualTo(String value) {
            addCriterion("xiangmuzhuangtaiid >=", value, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidLessThan(String value) {
            addCriterion("xiangmuzhuangtaiid <", value, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidLessThanOrEqualTo(String value) {
            addCriterion("xiangmuzhuangtaiid <=", value, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidLike(String value) {
            addCriterion("xiangmuzhuangtaiid like", value, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidNotLike(String value) {
            addCriterion("xiangmuzhuangtaiid not like", value, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidIn(List<String> values) {
            addCriterion("xiangmuzhuangtaiid in", values, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidNotIn(List<String> values) {
            addCriterion("xiangmuzhuangtaiid not in", values, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidBetween(String value1, String value2) {
            addCriterion("xiangmuzhuangtaiid between", value1, value2, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andXiangmuzhuangtaiidNotBetween(String value1, String value2) {
            addCriterion("xiangmuzhuangtaiid not between", value1, value2, "xiangmuzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianIsNull() {
            addCriterion("kaigongshijian is null");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianIsNotNull() {
            addCriterion("kaigongshijian is not null");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianEqualTo(Date value) {
            addCriterion("kaigongshijian =", value, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianNotEqualTo(Date value) {
            addCriterion("kaigongshijian <>", value, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianGreaterThan(Date value) {
            addCriterion("kaigongshijian >", value, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianGreaterThanOrEqualTo(Date value) {
            addCriterion("kaigongshijian >=", value, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianLessThan(Date value) {
            addCriterion("kaigongshijian <", value, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianLessThanOrEqualTo(Date value) {
            addCriterion("kaigongshijian <=", value, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianIn(List<Date> values) {
            addCriterion("kaigongshijian in", values, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianNotIn(List<Date> values) {
            addCriterion("kaigongshijian not in", values, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianBetween(Date value1, Date value2) {
            addCriterion("kaigongshijian between", value1, value2, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andKaigongshijianNotBetween(Date value1, Date value2) {
            addCriterion("kaigongshijian not between", value1, value2, "kaigongshijian");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaIsNull() {
            addCriterion("hetongzongjia is null");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaIsNotNull() {
            addCriterion("hetongzongjia is not null");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaEqualTo(Double value) {
            addCriterion("hetongzongjia =", value, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaNotEqualTo(Double value) {
            addCriterion("hetongzongjia <>", value, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaGreaterThan(Double value) {
            addCriterion("hetongzongjia >", value, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaGreaterThanOrEqualTo(Double value) {
            addCriterion("hetongzongjia >=", value, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaLessThan(Double value) {
            addCriterion("hetongzongjia <", value, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaLessThanOrEqualTo(Double value) {
            addCriterion("hetongzongjia <=", value, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaIn(List<Double> values) {
            addCriterion("hetongzongjia in", values, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaNotIn(List<Double> values) {
            addCriterion("hetongzongjia not in", values, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaBetween(Double value1, Double value2) {
            addCriterion("hetongzongjia between", value1, value2, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andHetongzongjiaNotBetween(Double value1, Double value2) {
            addCriterion("hetongzongjia not between", value1, value2, "hetongzongjia");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziIsNull() {
            addCriterion("wangchengtouzi is null");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziIsNotNull() {
            addCriterion("wangchengtouzi is not null");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziEqualTo(Double value) {
            addCriterion("wangchengtouzi =", value, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziNotEqualTo(Double value) {
            addCriterion("wangchengtouzi <>", value, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziGreaterThan(Double value) {
            addCriterion("wangchengtouzi >", value, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziGreaterThanOrEqualTo(Double value) {
            addCriterion("wangchengtouzi >=", value, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziLessThan(Double value) {
            addCriterion("wangchengtouzi <", value, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziLessThanOrEqualTo(Double value) {
            addCriterion("wangchengtouzi <=", value, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziIn(List<Double> values) {
            addCriterion("wangchengtouzi in", values, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziNotIn(List<Double> values) {
            addCriterion("wangchengtouzi not in", values, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziBetween(Double value1, Double value2) {
            addCriterion("wangchengtouzi between", value1, value2, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andWangchengtouziNotBetween(Double value1, Double value2) {
            addCriterion("wangchengtouzi not between", value1, value2, "wangchengtouzi");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuIsNull() {
            addCriterion("jindukuaizhifu is null");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuIsNotNull() {
            addCriterion("jindukuaizhifu is not null");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuEqualTo(Double value) {
            addCriterion("jindukuaizhifu =", value, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuNotEqualTo(Double value) {
            addCriterion("jindukuaizhifu <>", value, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuGreaterThan(Double value) {
            addCriterion("jindukuaizhifu >", value, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuGreaterThanOrEqualTo(Double value) {
            addCriterion("jindukuaizhifu >=", value, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuLessThan(Double value) {
            addCriterion("jindukuaizhifu <", value, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuLessThanOrEqualTo(Double value) {
            addCriterion("jindukuaizhifu <=", value, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuIn(List<Double> values) {
            addCriterion("jindukuaizhifu in", values, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuNotIn(List<Double> values) {
            addCriterion("jindukuaizhifu not in", values, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuBetween(Double value1, Double value2) {
            addCriterion("jindukuaizhifu between", value1, value2, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuaizhifuNotBetween(Double value1, Double value2) {
            addCriterion("jindukuaizhifu not between", value1, value2, "jindukuaizhifu");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliIsNull() {
            addCriterion("jindukuanbili is null");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliIsNotNull() {
            addCriterion("jindukuanbili is not null");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliEqualTo(String value) {
            addCriterion("jindukuanbili =", value, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliNotEqualTo(String value) {
            addCriterion("jindukuanbili <>", value, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliGreaterThan(String value) {
            addCriterion("jindukuanbili >", value, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliGreaterThanOrEqualTo(String value) {
            addCriterion("jindukuanbili >=", value, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliLessThan(String value) {
            addCriterion("jindukuanbili <", value, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliLessThanOrEqualTo(String value) {
            addCriterion("jindukuanbili <=", value, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliLike(String value) {
            addCriterion("jindukuanbili like", value, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliNotLike(String value) {
            addCriterion("jindukuanbili not like", value, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliIn(List<String> values) {
            addCriterion("jindukuanbili in", values, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliNotIn(List<String> values) {
            addCriterion("jindukuanbili not in", values, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliBetween(String value1, String value2) {
            addCriterion("jindukuanbili between", value1, value2, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andJindukuanbiliNotBetween(String value1, String value2) {
            addCriterion("jindukuanbili not between", value1, value2, "jindukuanbili");
            return (Criteria) this;
        }

        public Criteria andWangongshijianIsNull() {
            addCriterion("wangongshijian is null");
            return (Criteria) this;
        }

        public Criteria andWangongshijianIsNotNull() {
            addCriterion("wangongshijian is not null");
            return (Criteria) this;
        }

        public Criteria andWangongshijianEqualTo(Date value) {
            addCriterion("wangongshijian =", value, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianNotEqualTo(Date value) {
            addCriterion("wangongshijian <>", value, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianGreaterThan(Date value) {
            addCriterion("wangongshijian >", value, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianGreaterThanOrEqualTo(Date value) {
            addCriterion("wangongshijian >=", value, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianLessThan(Date value) {
            addCriterion("wangongshijian <", value, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianLessThanOrEqualTo(Date value) {
            addCriterion("wangongshijian <=", value, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianIn(List<Date> values) {
            addCriterion("wangongshijian in", values, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianNotIn(List<Date> values) {
            addCriterion("wangongshijian not in", values, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianBetween(Date value1, Date value2) {
            addCriterion("wangongshijian between", value1, value2, "wangongshijian");
            return (Criteria) this;
        }

        public Criteria andWangongshijianNotBetween(Date value1, Date value2) {
            addCriterion("wangongshijian not between", value1, value2, "wangongshijian");
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
package jjjf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JungongjiesuanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JungongjiesuanExample() {
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

        public Criteria andJungongjiesuanidIsNull() {
            addCriterion("jungongjiesuanid is null");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidIsNotNull() {
            addCriterion("jungongjiesuanid is not null");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidEqualTo(String value) {
            addCriterion("jungongjiesuanid =", value, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidNotEqualTo(String value) {
            addCriterion("jungongjiesuanid <>", value, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidGreaterThan(String value) {
            addCriterion("jungongjiesuanid >", value, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidGreaterThanOrEqualTo(String value) {
            addCriterion("jungongjiesuanid >=", value, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidLessThan(String value) {
            addCriterion("jungongjiesuanid <", value, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidLessThanOrEqualTo(String value) {
            addCriterion("jungongjiesuanid <=", value, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidLike(String value) {
            addCriterion("jungongjiesuanid like", value, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidNotLike(String value) {
            addCriterion("jungongjiesuanid not like", value, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidIn(List<String> values) {
            addCriterion("jungongjiesuanid in", values, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidNotIn(List<String> values) {
            addCriterion("jungongjiesuanid not in", values, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidBetween(String value1, String value2) {
            addCriterion("jungongjiesuanid between", value1, value2, "jungongjiesuanid");
            return (Criteria) this;
        }

        public Criteria andJungongjiesuanidNotBetween(String value1, String value2) {
            addCriterion("jungongjiesuanid not between", value1, value2, "jungongjiesuanid");
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

        public Criteria andJiesuanzhuangtaiidIsNull() {
            addCriterion("jiesuanzhuangtaiid is null");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidIsNotNull() {
            addCriterion("jiesuanzhuangtaiid is not null");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidEqualTo(String value) {
            addCriterion("jiesuanzhuangtaiid =", value, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidNotEqualTo(String value) {
            addCriterion("jiesuanzhuangtaiid <>", value, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidGreaterThan(String value) {
            addCriterion("jiesuanzhuangtaiid >", value, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidGreaterThanOrEqualTo(String value) {
            addCriterion("jiesuanzhuangtaiid >=", value, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidLessThan(String value) {
            addCriterion("jiesuanzhuangtaiid <", value, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidLessThanOrEqualTo(String value) {
            addCriterion("jiesuanzhuangtaiid <=", value, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidLike(String value) {
            addCriterion("jiesuanzhuangtaiid like", value, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidNotLike(String value) {
            addCriterion("jiesuanzhuangtaiid not like", value, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidIn(List<String> values) {
            addCriterion("jiesuanzhuangtaiid in", values, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidNotIn(List<String> values) {
            addCriterion("jiesuanzhuangtaiid not in", values, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidBetween(String value1, String value2) {
            addCriterion("jiesuanzhuangtaiid between", value1, value2, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanzhuangtaiidNotBetween(String value1, String value2) {
            addCriterion("jiesuanzhuangtaiid not between", value1, value2, "jiesuanzhuangtaiid");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeIsNull() {
            addCriterion("jiesuanwanchengtime is null");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeIsNotNull() {
            addCriterion("jiesuanwanchengtime is not null");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeEqualTo(Date value) {
            addCriterion("jiesuanwanchengtime =", value, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeNotEqualTo(Date value) {
            addCriterion("jiesuanwanchengtime <>", value, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeGreaterThan(Date value) {
            addCriterion("jiesuanwanchengtime >", value, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jiesuanwanchengtime >=", value, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeLessThan(Date value) {
            addCriterion("jiesuanwanchengtime <", value, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeLessThanOrEqualTo(Date value) {
            addCriterion("jiesuanwanchengtime <=", value, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeIn(List<Date> values) {
            addCriterion("jiesuanwanchengtime in", values, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeNotIn(List<Date> values) {
            addCriterion("jiesuanwanchengtime not in", values, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeBetween(Date value1, Date value2) {
            addCriterion("jiesuanwanchengtime between", value1, value2, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanwanchengtimeNotBetween(Date value1, Date value2) {
            addCriterion("jiesuanwanchengtime not between", value1, value2, "jiesuanwanchengtime");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidIsNull() {
            addCriterion("jiesuanqingkuangid is null");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidIsNotNull() {
            addCriterion("jiesuanqingkuangid is not null");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidEqualTo(String value) {
            addCriterion("jiesuanqingkuangid =", value, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidNotEqualTo(String value) {
            addCriterion("jiesuanqingkuangid <>", value, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidGreaterThan(String value) {
            addCriterion("jiesuanqingkuangid >", value, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidGreaterThanOrEqualTo(String value) {
            addCriterion("jiesuanqingkuangid >=", value, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidLessThan(String value) {
            addCriterion("jiesuanqingkuangid <", value, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidLessThanOrEqualTo(String value) {
            addCriterion("jiesuanqingkuangid <=", value, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidLike(String value) {
            addCriterion("jiesuanqingkuangid like", value, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidNotLike(String value) {
            addCriterion("jiesuanqingkuangid not like", value, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidIn(List<String> values) {
            addCriterion("jiesuanqingkuangid in", values, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidNotIn(List<String> values) {
            addCriterion("jiesuanqingkuangid not in", values, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidBetween(String value1, String value2) {
            addCriterion("jiesuanqingkuangid between", value1, value2, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andJiesuanqingkuangidNotBetween(String value1, String value2) {
            addCriterion("jiesuanqingkuangid not between", value1, value2, "jiesuanqingkuangid");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangIsNull() {
            addCriterion("shifoujizhang is null");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangIsNotNull() {
            addCriterion("shifoujizhang is not null");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangEqualTo(Integer value) {
            addCriterion("shifoujizhang =", value, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangNotEqualTo(Integer value) {
            addCriterion("shifoujizhang <>", value, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangGreaterThan(Integer value) {
            addCriterion("shifoujizhang >", value, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangGreaterThanOrEqualTo(Integer value) {
            addCriterion("shifoujizhang >=", value, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangLessThan(Integer value) {
            addCriterion("shifoujizhang <", value, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangLessThanOrEqualTo(Integer value) {
            addCriterion("shifoujizhang <=", value, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangIn(List<Integer> values) {
            addCriterion("shifoujizhang in", values, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangNotIn(List<Integer> values) {
            addCriterion("shifoujizhang not in", values, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangBetween(Integer value1, Integer value2) {
            addCriterion("shifoujizhang between", value1, value2, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andShifoujizhangNotBetween(Integer value1, Integer value2) {
            addCriterion("shifoujizhang not between", value1, value2, "shifoujizhang");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoIsNull() {
            addCriterion("jiesuanpifuwenhao is null");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoIsNotNull() {
            addCriterion("jiesuanpifuwenhao is not null");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoEqualTo(String value) {
            addCriterion("jiesuanpifuwenhao =", value, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoNotEqualTo(String value) {
            addCriterion("jiesuanpifuwenhao <>", value, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoGreaterThan(String value) {
            addCriterion("jiesuanpifuwenhao >", value, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoGreaterThanOrEqualTo(String value) {
            addCriterion("jiesuanpifuwenhao >=", value, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoLessThan(String value) {
            addCriterion("jiesuanpifuwenhao <", value, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoLessThanOrEqualTo(String value) {
            addCriterion("jiesuanpifuwenhao <=", value, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoLike(String value) {
            addCriterion("jiesuanpifuwenhao like", value, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoNotLike(String value) {
            addCriterion("jiesuanpifuwenhao not like", value, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoIn(List<String> values) {
            addCriterion("jiesuanpifuwenhao in", values, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoNotIn(List<String> values) {
            addCriterion("jiesuanpifuwenhao not in", values, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoBetween(String value1, String value2) {
            addCriterion("jiesuanpifuwenhao between", value1, value2, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifuwenhaoNotBetween(String value1, String value2) {
            addCriterion("jiesuanpifuwenhao not between", value1, value2, "jiesuanpifuwenhao");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineIsNull() {
            addCriterion("jiesuanpifujine is null");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineIsNotNull() {
            addCriterion("jiesuanpifujine is not null");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineEqualTo(Double value) {
            addCriterion("jiesuanpifujine =", value, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineNotEqualTo(Double value) {
            addCriterion("jiesuanpifujine <>", value, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineGreaterThan(Double value) {
            addCriterion("jiesuanpifujine >", value, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineGreaterThanOrEqualTo(Double value) {
            addCriterion("jiesuanpifujine >=", value, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineLessThan(Double value) {
            addCriterion("jiesuanpifujine <", value, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineLessThanOrEqualTo(Double value) {
            addCriterion("jiesuanpifujine <=", value, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineIn(List<Double> values) {
            addCriterion("jiesuanpifujine in", values, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineNotIn(List<Double> values) {
            addCriterion("jiesuanpifujine not in", values, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineBetween(Double value1, Double value2) {
            addCriterion("jiesuanpifujine between", value1, value2, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJiesuanpifujineNotBetween(Double value1, Double value2) {
            addCriterion("jiesuanpifujine not between", value1, value2, "jiesuanpifujine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineIsNull() {
            addCriterion("jieyushangjiaojine is null");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineIsNotNull() {
            addCriterion("jieyushangjiaojine is not null");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineEqualTo(Double value) {
            addCriterion("jieyushangjiaojine =", value, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineNotEqualTo(Double value) {
            addCriterion("jieyushangjiaojine <>", value, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineGreaterThan(Double value) {
            addCriterion("jieyushangjiaojine >", value, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineGreaterThanOrEqualTo(Double value) {
            addCriterion("jieyushangjiaojine >=", value, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineLessThan(Double value) {
            addCriterion("jieyushangjiaojine <", value, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineLessThanOrEqualTo(Double value) {
            addCriterion("jieyushangjiaojine <=", value, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineIn(List<Double> values) {
            addCriterion("jieyushangjiaojine in", values, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineNotIn(List<Double> values) {
            addCriterion("jieyushangjiaojine not in", values, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineBetween(Double value1, Double value2) {
            addCriterion("jieyushangjiaojine between", value1, value2, "jieyushangjiaojine");
            return (Criteria) this;
        }

        public Criteria andJieyushangjiaojineNotBetween(Double value1, Double value2) {
            addCriterion("jieyushangjiaojine not between", value1, value2, "jieyushangjiaojine");
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
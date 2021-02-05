package jjjf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JingfeiyusuanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JingfeiyusuanExample() {
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

        public Criteria andJingfeiyuansuanidIsNull() {
            addCriterion("jingfeiyuansuanid is null");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidIsNotNull() {
            addCriterion("jingfeiyuansuanid is not null");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidEqualTo(String value) {
            addCriterion("jingfeiyuansuanid =", value, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidNotEqualTo(String value) {
            addCriterion("jingfeiyuansuanid <>", value, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidGreaterThan(String value) {
            addCriterion("jingfeiyuansuanid >", value, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidGreaterThanOrEqualTo(String value) {
            addCriterion("jingfeiyuansuanid >=", value, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidLessThan(String value) {
            addCriterion("jingfeiyuansuanid <", value, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidLessThanOrEqualTo(String value) {
            addCriterion("jingfeiyuansuanid <=", value, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidLike(String value) {
            addCriterion("jingfeiyuansuanid like", value, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidNotLike(String value) {
            addCriterion("jingfeiyuansuanid not like", value, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidIn(List<String> values) {
            addCriterion("jingfeiyuansuanid in", values, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidNotIn(List<String> values) {
            addCriterion("jingfeiyuansuanid not in", values, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidBetween(String value1, String value2) {
            addCriterion("jingfeiyuansuanid between", value1, value2, "jingfeiyuansuanid");
            return (Criteria) this;
        }

        public Criteria andJingfeiyuansuanidNotBetween(String value1, String value2) {
            addCriterion("jingfeiyuansuanid not between", value1, value2, "jingfeiyuansuanid");
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

        public Criteria andJingfeixiadaqingkuangIsNull() {
            addCriterion("jingfeixiadaqingkuang is null");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangIsNotNull() {
            addCriterion("jingfeixiadaqingkuang is not null");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangEqualTo(String value) {
            addCriterion("jingfeixiadaqingkuang =", value, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangNotEqualTo(String value) {
            addCriterion("jingfeixiadaqingkuang <>", value, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangGreaterThan(String value) {
            addCriterion("jingfeixiadaqingkuang >", value, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangGreaterThanOrEqualTo(String value) {
            addCriterion("jingfeixiadaqingkuang >=", value, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangLessThan(String value) {
            addCriterion("jingfeixiadaqingkuang <", value, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangLessThanOrEqualTo(String value) {
            addCriterion("jingfeixiadaqingkuang <=", value, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangLike(String value) {
            addCriterion("jingfeixiadaqingkuang like", value, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangNotLike(String value) {
            addCriterion("jingfeixiadaqingkuang not like", value, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangIn(List<String> values) {
            addCriterion("jingfeixiadaqingkuang in", values, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangNotIn(List<String> values) {
            addCriterion("jingfeixiadaqingkuang not in", values, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangBetween(String value1, String value2) {
            addCriterion("jingfeixiadaqingkuang between", value1, value2, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andJingfeixiadaqingkuangNotBetween(String value1, String value2) {
            addCriterion("jingfeixiadaqingkuang not between", value1, value2, "jingfeixiadaqingkuang");
            return (Criteria) this;
        }

        public Criteria andYusuannianduIsNull() {
            addCriterion("yusuanniandu is null");
            return (Criteria) this;
        }

        public Criteria andYusuannianduIsNotNull() {
            addCriterion("yusuanniandu is not null");
            return (Criteria) this;
        }

        public Criteria andYusuannianduEqualTo(String value) {
            addCriterion("yusuanniandu =", value, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduNotEqualTo(String value) {
            addCriterion("yusuanniandu <>", value, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduGreaterThan(String value) {
            addCriterion("yusuanniandu >", value, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduGreaterThanOrEqualTo(String value) {
            addCriterion("yusuanniandu >=", value, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduLessThan(String value) {
            addCriterion("yusuanniandu <", value, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduLessThanOrEqualTo(String value) {
            addCriterion("yusuanniandu <=", value, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduLike(String value) {
            addCriterion("yusuanniandu like", value, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduNotLike(String value) {
            addCriterion("yusuanniandu not like", value, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduIn(List<String> values) {
            addCriterion("yusuanniandu in", values, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduNotIn(List<String> values) {
            addCriterion("yusuanniandu not in", values, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduBetween(String value1, String value2) {
            addCriterion("yusuanniandu between", value1, value2, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andYusuannianduNotBetween(String value1, String value2) {
            addCriterion("yusuanniandu not between", value1, value2, "yusuanniandu");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoIsNull() {
            addCriterion("lianbaojingfeizhibiao is null");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoIsNotNull() {
            addCriterion("lianbaojingfeizhibiao is not null");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoEqualTo(Double value) {
            addCriterion("lianbaojingfeizhibiao =", value, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoNotEqualTo(Double value) {
            addCriterion("lianbaojingfeizhibiao <>", value, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoGreaterThan(Double value) {
            addCriterion("lianbaojingfeizhibiao >", value, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoGreaterThanOrEqualTo(Double value) {
            addCriterion("lianbaojingfeizhibiao >=", value, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoLessThan(Double value) {
            addCriterion("lianbaojingfeizhibiao <", value, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoLessThanOrEqualTo(Double value) {
            addCriterion("lianbaojingfeizhibiao <=", value, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoIn(List<Double> values) {
            addCriterion("lianbaojingfeizhibiao in", values, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoNotIn(List<Double> values) {
            addCriterion("lianbaojingfeizhibiao not in", values, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoBetween(Double value1, Double value2) {
            addCriterion("lianbaojingfeizhibiao between", value1, value2, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andLianbaojingfeizhibiaoNotBetween(Double value1, Double value2) {
            addCriterion("lianbaojingfeizhibiao not between", value1, value2, "lianbaojingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoIsNull() {
            addCriterion("zhongxinjingfeizhibiao is null");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoIsNotNull() {
            addCriterion("zhongxinjingfeizhibiao is not null");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoEqualTo(Double value) {
            addCriterion("zhongxinjingfeizhibiao =", value, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoNotEqualTo(Double value) {
            addCriterion("zhongxinjingfeizhibiao <>", value, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoGreaterThan(Double value) {
            addCriterion("zhongxinjingfeizhibiao >", value, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoGreaterThanOrEqualTo(Double value) {
            addCriterion("zhongxinjingfeizhibiao >=", value, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoLessThan(Double value) {
            addCriterion("zhongxinjingfeizhibiao <", value, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoLessThanOrEqualTo(Double value) {
            addCriterion("zhongxinjingfeizhibiao <=", value, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoIn(List<Double> values) {
            addCriterion("zhongxinjingfeizhibiao in", values, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoNotIn(List<Double> values) {
            addCriterion("zhongxinjingfeizhibiao not in", values, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoBetween(Double value1, Double value2) {
            addCriterion("zhongxinjingfeizhibiao between", value1, value2, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinjingfeizhibiaoNotBetween(Double value1, Double value2) {
            addCriterion("zhongxinjingfeizhibiao not between", value1, value2, "zhongxinjingfeizhibiao");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineIsNull() {
            addCriterion("zhongxinyuliujine is null");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineIsNotNull() {
            addCriterion("zhongxinyuliujine is not null");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineEqualTo(Double value) {
            addCriterion("zhongxinyuliujine =", value, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineNotEqualTo(Double value) {
            addCriterion("zhongxinyuliujine <>", value, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineGreaterThan(Double value) {
            addCriterion("zhongxinyuliujine >", value, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineGreaterThanOrEqualTo(Double value) {
            addCriterion("zhongxinyuliujine >=", value, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineLessThan(Double value) {
            addCriterion("zhongxinyuliujine <", value, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineLessThanOrEqualTo(Double value) {
            addCriterion("zhongxinyuliujine <=", value, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineIn(List<Double> values) {
            addCriterion("zhongxinyuliujine in", values, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineNotIn(List<Double> values) {
            addCriterion("zhongxinyuliujine not in", values, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineBetween(Double value1, Double value2) {
            addCriterion("zhongxinyuliujine between", value1, value2, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinyuliujineNotBetween(Double value1, Double value2) {
            addCriterion("zhongxinyuliujine not between", value1, value2, "zhongxinyuliujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoIsNull() {
            addCriterion("zhongxinkuaijihao is null");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoIsNotNull() {
            addCriterion("zhongxinkuaijihao is not null");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoEqualTo(Double value) {
            addCriterion("zhongxinkuaijihao =", value, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoNotEqualTo(Double value) {
            addCriterion("zhongxinkuaijihao <>", value, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoGreaterThan(Double value) {
            addCriterion("zhongxinkuaijihao >", value, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoGreaterThanOrEqualTo(Double value) {
            addCriterion("zhongxinkuaijihao >=", value, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoLessThan(Double value) {
            addCriterion("zhongxinkuaijihao <", value, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoLessThanOrEqualTo(Double value) {
            addCriterion("zhongxinkuaijihao <=", value, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoIn(List<Double> values) {
            addCriterion("zhongxinkuaijihao in", values, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoNotIn(List<Double> values) {
            addCriterion("zhongxinkuaijihao not in", values, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoBetween(Double value1, Double value2) {
            addCriterion("zhongxinkuaijihao between", value1, value2, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andZhongxinkuaijihaoNotBetween(Double value1, Double value2) {
            addCriterion("zhongxinkuaijihao not between", value1, value2, "zhongxinkuaijihao");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNull() {
            addCriterion("deptid is null");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNotNull() {
            addCriterion("deptid is not null");
            return (Criteria) this;
        }

        public Criteria andDeptidEqualTo(String value) {
            addCriterion("deptid =", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotEqualTo(String value) {
            addCriterion("deptid <>", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThan(String value) {
            addCriterion("deptid >", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThanOrEqualTo(String value) {
            addCriterion("deptid >=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThan(String value) {
            addCriterion("deptid <", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThanOrEqualTo(String value) {
            addCriterion("deptid <=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLike(String value) {
            addCriterion("deptid like", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotLike(String value) {
            addCriterion("deptid not like", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidIn(List<String> values) {
            addCriterion("deptid in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotIn(List<String> values) {
            addCriterion("deptid not in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidBetween(String value1, String value2) {
            addCriterion("deptid between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotBetween(String value1, String value2) {
            addCriterion("deptid not between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuIsNull() {
            addCriterion("jingfeikemu is null");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuIsNotNull() {
            addCriterion("jingfeikemu is not null");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuEqualTo(String value) {
            addCriterion("jingfeikemu =", value, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuNotEqualTo(String value) {
            addCriterion("jingfeikemu <>", value, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuGreaterThan(String value) {
            addCriterion("jingfeikemu >", value, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuGreaterThanOrEqualTo(String value) {
            addCriterion("jingfeikemu >=", value, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuLessThan(String value) {
            addCriterion("jingfeikemu <", value, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuLessThanOrEqualTo(String value) {
            addCriterion("jingfeikemu <=", value, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuLike(String value) {
            addCriterion("jingfeikemu like", value, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuNotLike(String value) {
            addCriterion("jingfeikemu not like", value, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuIn(List<String> values) {
            addCriterion("jingfeikemu in", values, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuNotIn(List<String> values) {
            addCriterion("jingfeikemu not in", values, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuBetween(String value1, String value2) {
            addCriterion("jingfeikemu between", value1, value2, "jingfeikemu");
            return (Criteria) this;
        }

        public Criteria andJingfeikemuNotBetween(String value1, String value2) {
            addCriterion("jingfeikemu not between", value1, value2, "jingfeikemu");
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

        public Criteria and状态IsNull() {
            addCriterion("状态 is null");
            return (Criteria) this;
        }

        public Criteria and状态IsNotNull() {
            addCriterion("状态 is not null");
            return (Criteria) this;
        }

        public Criteria and状态EqualTo(Integer value) {
            addCriterion("状态 =", value, "状态");
            return (Criteria) this;
        }

        public Criteria and状态NotEqualTo(Integer value) {
            addCriterion("状态 <>", value, "状态");
            return (Criteria) this;
        }

        public Criteria and状态GreaterThan(Integer value) {
            addCriterion("状态 >", value, "状态");
            return (Criteria) this;
        }

        public Criteria and状态GreaterThanOrEqualTo(Integer value) {
            addCriterion("状态 >=", value, "状态");
            return (Criteria) this;
        }

        public Criteria and状态LessThan(Integer value) {
            addCriterion("状态 <", value, "状态");
            return (Criteria) this;
        }

        public Criteria and状态LessThanOrEqualTo(Integer value) {
            addCriterion("状态 <=", value, "状态");
            return (Criteria) this;
        }

        public Criteria and状态In(List<Integer> values) {
            addCriterion("状态 in", values, "状态");
            return (Criteria) this;
        }

        public Criteria and状态NotIn(List<Integer> values) {
            addCriterion("状态 not in", values, "状态");
            return (Criteria) this;
        }

        public Criteria and状态Between(Integer value1, Integer value2) {
            addCriterion("状态 between", value1, value2, "状态");
            return (Criteria) this;
        }

        public Criteria and状态NotBetween(Integer value1, Integer value2) {
            addCriterion("状态 not between", value1, value2, "状态");
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
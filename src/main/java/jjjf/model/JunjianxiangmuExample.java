package jjjf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JunjianxiangmuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JunjianxiangmuExample() {
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

        public Criteria andXiangmunameIsNull() {
            addCriterion("xiangmuname is null");
            return (Criteria) this;
        }

        public Criteria andXiangmunameIsNotNull() {
            addCriterion("xiangmuname is not null");
            return (Criteria) this;
        }

        public Criteria andXiangmunameEqualTo(String value) {
            addCriterion("xiangmuname =", value, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameNotEqualTo(String value) {
            addCriterion("xiangmuname <>", value, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameGreaterThan(String value) {
            addCriterion("xiangmuname >", value, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameGreaterThanOrEqualTo(String value) {
            addCriterion("xiangmuname >=", value, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameLessThan(String value) {
            addCriterion("xiangmuname <", value, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameLessThanOrEqualTo(String value) {
            addCriterion("xiangmuname <=", value, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameLike(String value) {
            addCriterion("xiangmuname like", value, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameNotLike(String value) {
            addCriterion("xiangmuname not like", value, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameIn(List<String> values) {
            addCriterion("xiangmuname in", values, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameNotIn(List<String> values) {
            addCriterion("xiangmuname not in", values, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameBetween(String value1, String value2) {
            addCriterion("xiangmuname between", value1, value2, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmunameNotBetween(String value1, String value2) {
            addCriterion("xiangmuname not between", value1, value2, "xiangmuname");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuIsNull() {
            addCriterion("xiangmupifu is null");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuIsNotNull() {
            addCriterion("xiangmupifu is not null");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuEqualTo(String value) {
            addCriterion("xiangmupifu =", value, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuNotEqualTo(String value) {
            addCriterion("xiangmupifu <>", value, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuGreaterThan(String value) {
            addCriterion("xiangmupifu >", value, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuGreaterThanOrEqualTo(String value) {
            addCriterion("xiangmupifu >=", value, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuLessThan(String value) {
            addCriterion("xiangmupifu <", value, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuLessThanOrEqualTo(String value) {
            addCriterion("xiangmupifu <=", value, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuLike(String value) {
            addCriterion("xiangmupifu like", value, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuNotLike(String value) {
            addCriterion("xiangmupifu not like", value, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuIn(List<String> values) {
            addCriterion("xiangmupifu in", values, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuNotIn(List<String> values) {
            addCriterion("xiangmupifu not in", values, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuBetween(String value1, String value2) {
            addCriterion("xiangmupifu between", value1, value2, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andXiangmupifuNotBetween(String value1, String value2) {
            addCriterion("xiangmupifu not between", value1, value2, "xiangmupifu");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineIsNull() {
            addCriterion("lianbaopifujine is null");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineIsNotNull() {
            addCriterion("lianbaopifujine is not null");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineEqualTo(Double value) {
            addCriterion("lianbaopifujine =", value, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineNotEqualTo(Double value) {
            addCriterion("lianbaopifujine <>", value, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineGreaterThan(Double value) {
            addCriterion("lianbaopifujine >", value, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineGreaterThanOrEqualTo(Double value) {
            addCriterion("lianbaopifujine >=", value, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineLessThan(Double value) {
            addCriterion("lianbaopifujine <", value, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineLessThanOrEqualTo(Double value) {
            addCriterion("lianbaopifujine <=", value, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineIn(List<Double> values) {
            addCriterion("lianbaopifujine in", values, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineNotIn(List<Double> values) {
            addCriterion("lianbaopifujine not in", values, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineBetween(Double value1, Double value2) {
            addCriterion("lianbaopifujine between", value1, value2, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaopifujineNotBetween(Double value1, Double value2) {
            addCriterion("lianbaopifujine not between", value1, value2, "lianbaopifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineIsNull() {
            addCriterion("zhongxinpifujine is null");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineIsNotNull() {
            addCriterion("zhongxinpifujine is not null");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineEqualTo(Double value) {
            addCriterion("zhongxinpifujine =", value, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineNotEqualTo(Double value) {
            addCriterion("zhongxinpifujine <>", value, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineGreaterThan(Double value) {
            addCriterion("zhongxinpifujine >", value, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineGreaterThanOrEqualTo(Double value) {
            addCriterion("zhongxinpifujine >=", value, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineLessThan(Double value) {
            addCriterion("zhongxinpifujine <", value, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineLessThanOrEqualTo(Double value) {
            addCriterion("zhongxinpifujine <=", value, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineIn(List<Double> values) {
            addCriterion("zhongxinpifujine in", values, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineNotIn(List<Double> values) {
            addCriterion("zhongxinpifujine not in", values, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineBetween(Double value1, Double value2) {
            addCriterion("zhongxinpifujine between", value1, value2, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andZhongxinpifujineNotBetween(Double value1, Double value2) {
            addCriterion("zhongxinpifujine not between", value1, value2, "zhongxinpifujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineIsNull() {
            addCriterion("lianbaoyuliujine is null");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineIsNotNull() {
            addCriterion("lianbaoyuliujine is not null");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineEqualTo(Double value) {
            addCriterion("lianbaoyuliujine =", value, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineNotEqualTo(Double value) {
            addCriterion("lianbaoyuliujine <>", value, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineGreaterThan(Double value) {
            addCriterion("lianbaoyuliujine >", value, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineGreaterThanOrEqualTo(Double value) {
            addCriterion("lianbaoyuliujine >=", value, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineLessThan(Double value) {
            addCriterion("lianbaoyuliujine <", value, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineLessThanOrEqualTo(Double value) {
            addCriterion("lianbaoyuliujine <=", value, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineIn(List<Double> values) {
            addCriterion("lianbaoyuliujine in", values, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineNotIn(List<Double> values) {
            addCriterion("lianbaoyuliujine not in", values, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineBetween(Double value1, Double value2) {
            addCriterion("lianbaoyuliujine between", value1, value2, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andLianbaoyuliujineNotBetween(Double value1, Double value2) {
            addCriterion("lianbaoyuliujine not between", value1, value2, "lianbaoyuliujine");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieIsNull() {
            addCriterion("xiangmuleibie is null");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieIsNotNull() {
            addCriterion("xiangmuleibie is not null");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieEqualTo(String value) {
            addCriterion("xiangmuleibie =", value, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieNotEqualTo(String value) {
            addCriterion("xiangmuleibie <>", value, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieGreaterThan(String value) {
            addCriterion("xiangmuleibie >", value, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieGreaterThanOrEqualTo(String value) {
            addCriterion("xiangmuleibie >=", value, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieLessThan(String value) {
            addCriterion("xiangmuleibie <", value, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieLessThanOrEqualTo(String value) {
            addCriterion("xiangmuleibie <=", value, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieLike(String value) {
            addCriterion("xiangmuleibie like", value, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieNotLike(String value) {
            addCriterion("xiangmuleibie not like", value, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieIn(List<String> values) {
            addCriterion("xiangmuleibie in", values, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieNotIn(List<String> values) {
            addCriterion("xiangmuleibie not in", values, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieBetween(String value1, String value2) {
            addCriterion("xiangmuleibie between", value1, value2, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andXiangmuleibieNotBetween(String value1, String value2) {
            addCriterion("xiangmuleibie not between", value1, value2, "xiangmuleibie");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNull() {
            addCriterion("beizhu is null");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNotNull() {
            addCriterion("beizhu is not null");
            return (Criteria) this;
        }

        public Criteria andBeizhuEqualTo(String value) {
            addCriterion("beizhu =", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotEqualTo(String value) {
            addCriterion("beizhu <>", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThan(String value) {
            addCriterion("beizhu >", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThanOrEqualTo(String value) {
            addCriterion("beizhu >=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThan(String value) {
            addCriterion("beizhu <", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThanOrEqualTo(String value) {
            addCriterion("beizhu <=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLike(String value) {
            addCriterion("beizhu like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotLike(String value) {
            addCriterion("beizhu not like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuIn(List<String> values) {
            addCriterion("beizhu in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotIn(List<String> values) {
            addCriterion("beizhu not in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuBetween(String value1, String value2) {
            addCriterion("beizhu between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotBetween(String value1, String value2) {
            addCriterion("beizhu not between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidIsNull() {
            addCriterion("jieshoudanweiid is null");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidIsNotNull() {
            addCriterion("jieshoudanweiid is not null");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidEqualTo(String value) {
            addCriterion("jieshoudanweiid =", value, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidNotEqualTo(String value) {
            addCriterion("jieshoudanweiid <>", value, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidGreaterThan(String value) {
            addCriterion("jieshoudanweiid >", value, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidGreaterThanOrEqualTo(String value) {
            addCriterion("jieshoudanweiid >=", value, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidLessThan(String value) {
            addCriterion("jieshoudanweiid <", value, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidLessThanOrEqualTo(String value) {
            addCriterion("jieshoudanweiid <=", value, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidLike(String value) {
            addCriterion("jieshoudanweiid like", value, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidNotLike(String value) {
            addCriterion("jieshoudanweiid not like", value, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidIn(List<String> values) {
            addCriterion("jieshoudanweiid in", values, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidNotIn(List<String> values) {
            addCriterion("jieshoudanweiid not in", values, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidBetween(String value1, String value2) {
            addCriterion("jieshoudanweiid between", value1, value2, "jieshoudanweiid");
            return (Criteria) this;
        }

        public Criteria andJieshoudanweiidNotBetween(String value1, String value2) {
            addCriterion("jieshoudanweiid not between", value1, value2, "jieshoudanweiid");
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
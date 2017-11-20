package com.mybatis;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAnswerExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public FavoriteAnswerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
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

        public Criteria andAnswerIdIsNull() {
            addCriterion("ANSWER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("ANSWER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(Integer value) {
            addCriterion("ANSWER_ID =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(Integer value) {
            addCriterion("ANSWER_ID <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(Integer value) {
            addCriterion("ANSWER_ID >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ANSWER_ID >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(Integer value) {
            addCriterion("ANSWER_ID <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(Integer value) {
            addCriterion("ANSWER_ID <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<Integer> values) {
            addCriterion("ANSWER_ID in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<Integer> values) {
            addCriterion("ANSWER_ID not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(Integer value1, Integer value2) {
            addCriterion("ANSWER_ID between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ANSWER_ID not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNull() {
            addCriterion("QUESTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("QUESTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Integer value) {
            addCriterion("QUESTION_ID =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Integer value) {
            addCriterion("QUESTION_ID <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Integer value) {
            addCriterion("QUESTION_ID >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("QUESTION_ID >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Integer value) {
            addCriterion("QUESTION_ID <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("QUESTION_ID <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Integer> values) {
            addCriterion("QUESTION_ID in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Integer> values) {
            addCriterion("QUESTION_ID not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("QUESTION_ID between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("QUESTION_ID not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteIsNull() {
            addCriterion("IS_FAVORITE is null");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteIsNotNull() {
            addCriterion("IS_FAVORITE is not null");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteEqualTo(String value) {
            addCriterion("IS_FAVORITE =", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteNotEqualTo(String value) {
            addCriterion("IS_FAVORITE <>", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteGreaterThan(String value) {
            addCriterion("IS_FAVORITE >", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteGreaterThanOrEqualTo(String value) {
            addCriterion("IS_FAVORITE >=", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteLessThan(String value) {
            addCriterion("IS_FAVORITE <", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteLessThanOrEqualTo(String value) {
            addCriterion("IS_FAVORITE <=", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteLike(String value) {
            addCriterion("IS_FAVORITE like", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteNotLike(String value) {
            addCriterion("IS_FAVORITE not like", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteIn(List<String> values) {
            addCriterion("IS_FAVORITE in", values, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteNotIn(List<String> values) {
            addCriterion("IS_FAVORITE not in", values, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteBetween(String value1, String value2) {
            addCriterion("IS_FAVORITE between", value1, value2, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteNotBetween(String value1, String value2) {
            addCriterion("IS_FAVORITE not between", value1, value2, "isFavorite");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated do_not_delete_during_merge Mon Nov 20 10:00:46 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PUBLIC.FAVORITE_ANSWER
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
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
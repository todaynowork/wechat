package com.mybatis;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public QuestionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
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

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andDescIsNull() {
			addCriterion("DESC is null");
			return (Criteria) this;
		}

		public Criteria andDescIsNotNull() {
			addCriterion("DESC is not null");
			return (Criteria) this;
		}

		public Criteria andDescEqualTo(String value) {
			addCriterion("DESC =", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotEqualTo(String value) {
			addCriterion("DESC <>", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescGreaterThan(String value) {
			addCriterion("DESC >", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescGreaterThanOrEqualTo(String value) {
			addCriterion("DESC >=", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLessThan(String value) {
			addCriterion("DESC <", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLessThanOrEqualTo(String value) {
			addCriterion("DESC <=", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescLike(String value) {
			addCriterion("DESC like", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotLike(String value) {
			addCriterion("DESC not like", value, "desc");
			return (Criteria) this;
		}

		public Criteria andDescIn(List<String> values) {
			addCriterion("DESC in", values, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotIn(List<String> values) {
			addCriterion("DESC not in", values, "desc");
			return (Criteria) this;
		}

		public Criteria andDescBetween(String value1, String value2) {
			addCriterion("DESC between", value1, value2, "desc");
			return (Criteria) this;
		}

		public Criteria andDescNotBetween(String value1, String value2) {
			addCriterion("DESC not between", value1, value2, "desc");
			return (Criteria) this;
		}

		public Criteria andOwnerIsNull() {
			addCriterion("OWNER is null");
			return (Criteria) this;
		}

		public Criteria andOwnerIsNotNull() {
			addCriterion("OWNER is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerEqualTo(String value) {
			addCriterion("OWNER =", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerNotEqualTo(String value) {
			addCriterion("OWNER <>", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerGreaterThan(String value) {
			addCriterion("OWNER >", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerGreaterThanOrEqualTo(String value) {
			addCriterion("OWNER >=", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerLessThan(String value) {
			addCriterion("OWNER <", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerLessThanOrEqualTo(String value) {
			addCriterion("OWNER <=", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerLike(String value) {
			addCriterion("OWNER like", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerNotLike(String value) {
			addCriterion("OWNER not like", value, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerIn(List<String> values) {
			addCriterion("OWNER in", values, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerNotIn(List<String> values) {
			addCriterion("OWNER not in", values, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerBetween(String value1, String value2) {
			addCriterion("OWNER between", value1, value2, "owner");
			return (Criteria) this;
		}

		public Criteria andOwnerNotBetween(String value1, String value2) {
			addCriterion("OWNER not between", value1, value2, "owner");
			return (Criteria) this;
		}

		public Criteria andCreditIdIsNull() {
			addCriterion("CREDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreditIdIsNotNull() {
			addCriterion("CREDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreditIdEqualTo(Integer value) {
			addCriterion("CREDIT_ID =", value, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdNotEqualTo(Integer value) {
			addCriterion("CREDIT_ID <>", value, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdGreaterThan(Integer value) {
			addCriterion("CREDIT_ID >", value, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREDIT_ID >=", value, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdLessThan(Integer value) {
			addCriterion("CREDIT_ID <", value, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdLessThanOrEqualTo(Integer value) {
			addCriterion("CREDIT_ID <=", value, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdIn(List<Integer> values) {
			addCriterion("CREDIT_ID in", values, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdNotIn(List<Integer> values) {
			addCriterion("CREDIT_ID not in", values, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdBetween(Integer value1, Integer value2) {
			addCriterion("CREDIT_ID between", value1, value2, "creditId");
			return (Criteria) this;
		}

		public Criteria andCreditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CREDIT_ID not between", value1, value2, "creditId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdIsNull() {
			addCriterion("FAVORITES_ID is null");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdIsNotNull() {
			addCriterion("FAVORITES_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdEqualTo(Integer value) {
			addCriterion("FAVORITES_ID =", value, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdNotEqualTo(Integer value) {
			addCriterion("FAVORITES_ID <>", value, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdGreaterThan(Integer value) {
			addCriterion("FAVORITES_ID >", value, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FAVORITES_ID >=", value, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdLessThan(Integer value) {
			addCriterion("FAVORITES_ID <", value, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdLessThanOrEqualTo(Integer value) {
			addCriterion("FAVORITES_ID <=", value, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdIn(List<Integer> values) {
			addCriterion("FAVORITES_ID in", values, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdNotIn(List<Integer> values) {
			addCriterion("FAVORITES_ID not in", values, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdBetween(Integer value1, Integer value2) {
			addCriterion("FAVORITES_ID between", value1, value2, "favoritesId");
			return (Criteria) this;
		}

		public Criteria andFavoritesIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FAVORITES_ID not between", value1, value2, "favoritesId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PUBLIC.QUESTIONS
     *
     * @mbg.generated do_not_delete_during_merge Mon Nov 20 10:00:46 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
package com.mybatis;

import java.util.ArrayList;
import java.util.List;

public class CourseParticipantExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public CourseParticipantExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
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

		public Criteria andCourseScheduleIdIsNull() {
			addCriterion("COURSE_SCHEDULE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdIsNotNull() {
			addCriterion("COURSE_SCHEDULE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdEqualTo(Integer value) {
			addCriterion("COURSE_SCHEDULE_ID =", value, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdNotEqualTo(Integer value) {
			addCriterion("COURSE_SCHEDULE_ID <>", value, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdGreaterThan(Integer value) {
			addCriterion("COURSE_SCHEDULE_ID >", value, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COURSE_SCHEDULE_ID >=", value, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdLessThan(Integer value) {
			addCriterion("COURSE_SCHEDULE_ID <", value, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdLessThanOrEqualTo(Integer value) {
			addCriterion("COURSE_SCHEDULE_ID <=", value, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdIn(List<Integer> values) {
			addCriterion("COURSE_SCHEDULE_ID in", values, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdNotIn(List<Integer> values) {
			addCriterion("COURSE_SCHEDULE_ID not in", values, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdBetween(Integer value1, Integer value2) {
			addCriterion("COURSE_SCHEDULE_ID between", value1, value2, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andCourseScheduleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COURSE_SCHEDULE_ID not between", value1, value2, "courseScheduleId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdIsNull() {
			addCriterion("PARTICIPANT_ID is null");
			return (Criteria) this;
		}

		public Criteria andParticipantIdIsNotNull() {
			addCriterion("PARTICIPANT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andParticipantIdEqualTo(Integer value) {
			addCriterion("PARTICIPANT_ID =", value, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdNotEqualTo(Integer value) {
			addCriterion("PARTICIPANT_ID <>", value, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdGreaterThan(Integer value) {
			addCriterion("PARTICIPANT_ID >", value, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PARTICIPANT_ID >=", value, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdLessThan(Integer value) {
			addCriterion("PARTICIPANT_ID <", value, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdLessThanOrEqualTo(Integer value) {
			addCriterion("PARTICIPANT_ID <=", value, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdIn(List<Integer> values) {
			addCriterion("PARTICIPANT_ID in", values, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdNotIn(List<Integer> values) {
			addCriterion("PARTICIPANT_ID not in", values, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdBetween(Integer value1, Integer value2) {
			addCriterion("PARTICIPANT_ID between", value1, value2, "participantId");
			return (Criteria) this;
		}

		public Criteria andParticipantIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PARTICIPANT_ID not between", value1, value2, "participantId");
			return (Criteria) this;
		}

		public Criteria andCheckInIsNull() {
			addCriterion("CHECK_IN is null");
			return (Criteria) this;
		}

		public Criteria andCheckInIsNotNull() {
			addCriterion("CHECK_IN is not null");
			return (Criteria) this;
		}

		public Criteria andCheckInEqualTo(Integer value) {
			addCriterion("CHECK_IN =", value, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInNotEqualTo(Integer value) {
			addCriterion("CHECK_IN <>", value, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInGreaterThan(Integer value) {
			addCriterion("CHECK_IN >", value, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInGreaterThanOrEqualTo(Integer value) {
			addCriterion("CHECK_IN >=", value, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInLessThan(Integer value) {
			addCriterion("CHECK_IN <", value, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInLessThanOrEqualTo(Integer value) {
			addCriterion("CHECK_IN <=", value, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInIn(List<Integer> values) {
			addCriterion("CHECK_IN in", values, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInNotIn(List<Integer> values) {
			addCriterion("CHECK_IN not in", values, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInBetween(Integer value1, Integer value2) {
			addCriterion("CHECK_IN between", value1, value2, "checkIn");
			return (Criteria) this;
		}

		public Criteria andCheckInNotBetween(Integer value1, Integer value2) {
			addCriterion("CHECK_IN not between", value1, value2, "checkIn");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeIsNull() {
			addCriterion("PARTICIPANT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeIsNotNull() {
			addCriterion("PARTICIPANT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeEqualTo(String value) {
			addCriterion("PARTICIPANT_TYPE =", value, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeNotEqualTo(String value) {
			addCriterion("PARTICIPANT_TYPE <>", value, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeGreaterThan(String value) {
			addCriterion("PARTICIPANT_TYPE >", value, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeGreaterThanOrEqualTo(String value) {
			addCriterion("PARTICIPANT_TYPE >=", value, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeLessThan(String value) {
			addCriterion("PARTICIPANT_TYPE <", value, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeLessThanOrEqualTo(String value) {
			addCriterion("PARTICIPANT_TYPE <=", value, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeLike(String value) {
			addCriterion("PARTICIPANT_TYPE like", value, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeNotLike(String value) {
			addCriterion("PARTICIPANT_TYPE not like", value, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeIn(List<String> values) {
			addCriterion("PARTICIPANT_TYPE in", values, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeNotIn(List<String> values) {
			addCriterion("PARTICIPANT_TYPE not in", values, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeBetween(String value1, String value2) {
			addCriterion("PARTICIPANT_TYPE between", value1, value2, "participantType");
			return (Criteria) this;
		}

		public Criteria andParticipantTypeNotBetween(String value1, String value2) {
			addCriterion("PARTICIPANT_TYPE not between", value1, value2, "participantType");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
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
     * This class corresponds to the database table PUBLIC.COURSE_PARTICIPANT
     *
     * @mbg.generated do_not_delete_during_merge Mon Nov 20 10:00:46 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
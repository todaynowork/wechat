package com.mybatis;

public class FavoriteAnswerKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.FAVORITE_ANSWER.ANSWER_ID
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	private Integer answerId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.FAVORITE_ANSWER.QUESTION_ID
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	private Integer questionId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.FAVORITE_ANSWER.ANSWER_ID
	 * @return  the value of PUBLIC.FAVORITE_ANSWER.ANSWER_ID
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	public Integer getAnswerId() {
		return answerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.FAVORITE_ANSWER.ANSWER_ID
	 * @param answerId  the value for PUBLIC.FAVORITE_ANSWER.ANSWER_ID
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.FAVORITE_ANSWER.QUESTION_ID
	 * @return  the value of PUBLIC.FAVORITE_ANSWER.QUESTION_ID
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.FAVORITE_ANSWER.QUESTION_ID
	 * @param questionId  the value for PUBLIC.FAVORITE_ANSWER.QUESTION_ID
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
}
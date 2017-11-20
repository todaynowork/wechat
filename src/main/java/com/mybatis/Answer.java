package com.mybatis;

public class Answer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANSWERS.ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANSWERS.QUESTION_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    private Integer questionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANSWERS.PARENT_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANSWERS.DESC
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANSWERS.VOTES
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    private Integer votes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANSWERS.ANSWER_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    private Integer answerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ANSWERS.USER_OPEN_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    private String userOpenId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANSWERS.ID
     *
     * @return the value of PUBLIC.ANSWERS.ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANSWERS.ID
     *
     * @param id the value for PUBLIC.ANSWERS.ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANSWERS.QUESTION_ID
     *
     * @return the value of PUBLIC.ANSWERS.QUESTION_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANSWERS.QUESTION_ID
     *
     * @param questionId the value for PUBLIC.ANSWERS.QUESTION_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANSWERS.PARENT_ID
     *
     * @return the value of PUBLIC.ANSWERS.PARENT_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANSWERS.PARENT_ID
     *
     * @param parentId the value for PUBLIC.ANSWERS.PARENT_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANSWERS.DESC
     *
     * @return the value of PUBLIC.ANSWERS.DESC
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANSWERS.DESC
     *
     * @param desc the value for PUBLIC.ANSWERS.DESC
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANSWERS.VOTES
     *
     * @return the value of PUBLIC.ANSWERS.VOTES
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public Integer getVotes() {
        return votes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANSWERS.VOTES
     *
     * @param votes the value for PUBLIC.ANSWERS.VOTES
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANSWERS.ANSWER_ID
     *
     * @return the value of PUBLIC.ANSWERS.ANSWER_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANSWERS.ANSWER_ID
     *
     * @param answerId the value for PUBLIC.ANSWERS.ANSWER_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ANSWERS.USER_OPEN_ID
     *
     * @return the value of PUBLIC.ANSWERS.USER_OPEN_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public String getUserOpenId() {
        return userOpenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ANSWERS.USER_OPEN_ID
     *
     * @param userOpenId the value for PUBLIC.ANSWERS.USER_OPEN_ID
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }
}
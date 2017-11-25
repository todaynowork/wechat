package com.mybatis;

import java.util.List;

public class Question {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.QUESTIONS.ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.QUESTIONS.DESC
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	private String desc;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.QUESTIONS.OWNER
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	private Integer owner;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.QUESTIONS.CREDIT_ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	private Integer creditId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.QUESTIONS.FAVORITES_ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	private Integer favoritesId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.QUESTIONS.ID
	 * @return  the value of PUBLIC.QUESTIONS.ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.QUESTIONS.ID
	 * @param id  the value for PUBLIC.QUESTIONS.ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.QUESTIONS.DESC
	 * @return  the value of PUBLIC.QUESTIONS.DESC
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.QUESTIONS.DESC
	 * @param desc  the value for PUBLIC.QUESTIONS.DESC
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.QUESTIONS.OWNER
	 * @return  the value of PUBLIC.QUESTIONS.OWNER
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public Integer getOwner() {
		return owner;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.QUESTIONS.OWNER
	 * @param owner  the value for PUBLIC.QUESTIONS.OWNER
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.QUESTIONS.CREDIT_ID
	 * @return  the value of PUBLIC.QUESTIONS.CREDIT_ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public Integer getCreditId() {
		return creditId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.QUESTIONS.CREDIT_ID
	 * @param creditId  the value for PUBLIC.QUESTIONS.CREDIT_ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void setCreditId(Integer creditId) {
		this.creditId = creditId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.QUESTIONS.FAVORITES_ID
	 * @return  the value of PUBLIC.QUESTIONS.FAVORITES_ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public Integer getFavoritesId() {
		return favoritesId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.QUESTIONS.FAVORITES_ID
	 * @param favoritesId  the value for PUBLIC.QUESTIONS.FAVORITES_ID
	 * @mbg.generated  Sat Nov 25 21:10:41 CST 2017
	 */
	public void setFavoritesId(Integer favoritesId) {
		this.favoritesId = favoritesId;
	}

	private List<Answer> answers;

	public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
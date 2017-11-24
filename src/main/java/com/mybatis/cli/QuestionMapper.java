package com.mybatis.cli;

import com.mybatis.Question;
import com.mybatis.QuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	long countByExample(QuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	int deleteByExample(QuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	int insert(Question record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	int insertSelective(Question record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	List<Question> selectByExample(QuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	Question selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	int updateByPrimaryKeySelective(Question record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.QUESTIONS
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	int updateByPrimaryKey(Question record);
	
	Question selectByPrimaryKeyWithAnswer(Integer id);
}
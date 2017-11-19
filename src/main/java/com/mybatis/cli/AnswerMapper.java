package com.mybatis.cli;

import com.mybatis.Answer;
import com.mybatis.AnswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    long countByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    int deleteByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    int insert(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    int insertSelective(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    List<Answer> selectByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    Answer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    int updateByPrimaryKeySelective(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ANSWER
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    int updateByPrimaryKey(Answer record);
}
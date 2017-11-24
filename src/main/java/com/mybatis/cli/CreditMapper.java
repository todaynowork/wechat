package com.mybatis.cli;

import com.mybatis.Credit;
import com.mybatis.CreditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	long countByExample(CreditExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	int deleteByExample(CreditExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	int insert(Credit record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	int insertSelective(Credit record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	List<Credit> selectByExample(CreditExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	Credit selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Credit record, @Param("example") CreditExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	int updateByExample(@Param("record") Credit record, @Param("example") CreditExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	int updateByPrimaryKeySelective(Credit record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.CREDITS
	 * @mbg.generated  Fri Nov 24 16:52:28 CST 2017
	 */
	int updateByPrimaryKey(Credit record);
}
package com.mybatis.cli;

import com.mybatis.MyFavoriteExample;
import com.mybatis.MyFavoriteKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.mybatis.MyFavorite;

public interface MyFavoriteMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	long countByExample(MyFavoriteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int deleteByExample(MyFavoriteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int deleteByPrimaryKey(MyFavoriteKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int insert(MyFavorite record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int insertSelective(MyFavorite record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	List<MyFavorite> selectByExample(MyFavoriteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	MyFavorite selectByPrimaryKey(MyFavoriteKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int updateByExampleSelective(@Param("record") MyFavorite record, @Param("example") MyFavoriteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int updateByExample(@Param("record") MyFavorite record, @Param("example") MyFavoriteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int updateByPrimaryKeySelective(MyFavorite record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.MY_FAVORITES
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int updateByPrimaryKey(MyFavorite record);
}
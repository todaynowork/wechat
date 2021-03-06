package com.mybatis.cli;

import com.mybatis.CourseParticipant;
import com.mybatis.CourseParticipantExample;
import com.mybatis.CourseParticipantKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseParticipantMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	long countByExample(CourseParticipantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int deleteByExample(CourseParticipantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int deleteByPrimaryKey(CourseParticipantKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int insert(CourseParticipant record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int insertSelective(CourseParticipant record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	List<CourseParticipant> selectByExample(CourseParticipantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	CourseParticipant selectByPrimaryKey(CourseParticipantKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int updateByExampleSelective(@Param("record") CourseParticipant record,
			@Param("example") CourseParticipantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int updateByExample(@Param("record") CourseParticipant record, @Param("example") CourseParticipantExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int updateByPrimaryKeySelective(CourseParticipant record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table PUBLIC.COURSE_PARTICIPANT
	 * @mbg.generated  Tue Nov 28 12:49:57 CST 2017
	 */
	int updateByPrimaryKey(CourseParticipant record);

	List<CourseParticipant> selectAllCourseParticipant();
}
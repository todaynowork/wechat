package com.mybatis;

import java.util.Date;

public class CourseSchedule {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.COURSE_SCHEDULE.ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.COURSE_SCHEDULE.COURSE_ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	private Integer courseId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.COURSE_SCHEDULE.INSTRUCTOR_ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	private String instructorId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.COURSE_SCHEDULE.START_TIME
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	private Date startTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column PUBLIC.COURSE_SCHEDULE.END_ENDTIME
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	private Date endEndtime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.COURSE_SCHEDULE.ID
	 * @return  the value of PUBLIC.COURSE_SCHEDULE.ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.COURSE_SCHEDULE.ID
	 * @param id  the value for PUBLIC.COURSE_SCHEDULE.ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.COURSE_SCHEDULE.COURSE_ID
	 * @return  the value of PUBLIC.COURSE_SCHEDULE.COURSE_ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.COURSE_SCHEDULE.COURSE_ID
	 * @param courseId  the value for PUBLIC.COURSE_SCHEDULE.COURSE_ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.COURSE_SCHEDULE.INSTRUCTOR_ID
	 * @return  the value of PUBLIC.COURSE_SCHEDULE.INSTRUCTOR_ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public String getInstructorId() {
		return instructorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.COURSE_SCHEDULE.INSTRUCTOR_ID
	 * @param instructorId  the value for PUBLIC.COURSE_SCHEDULE.INSTRUCTOR_ID
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.COURSE_SCHEDULE.START_TIME
	 * @return  the value of PUBLIC.COURSE_SCHEDULE.START_TIME
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.COURSE_SCHEDULE.START_TIME
	 * @param startTime  the value for PUBLIC.COURSE_SCHEDULE.START_TIME
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column PUBLIC.COURSE_SCHEDULE.END_ENDTIME
	 * @return  the value of PUBLIC.COURSE_SCHEDULE.END_ENDTIME
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public Date getEndEndtime() {
		return endEndtime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column PUBLIC.COURSE_SCHEDULE.END_ENDTIME
	 * @param endEndtime  the value for PUBLIC.COURSE_SCHEDULE.END_ENDTIME
	 * @mbg.generated  Fri Nov 24 13:12:07 CST 2017
	 */
	public void setEndEndtime(Date endEndtime) {
		this.endEndtime = endEndtime;
	}
}
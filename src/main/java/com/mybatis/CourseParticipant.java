package com.mybatis;

public class CourseParticipant extends CourseParticipantKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE_PARTICIPANT.CHECK_IN
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    private Integer checkIn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE_PARTICIPANT.CHECK_IN
     *
     * @return the value of PUBLIC.COURSE_PARTICIPANT.CHECK_IN
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public Integer getCheckIn() {
        return checkIn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE_PARTICIPANT.CHECK_IN
     *
     * @param checkIn the value for PUBLIC.COURSE_PARTICIPANT.CHECK_IN
     *
     * @mbg.generated Mon Nov 20 10:00:46 CST 2017
     */
    public void setCheckIn(Integer checkIn) {
        this.checkIn = checkIn;
    }
}
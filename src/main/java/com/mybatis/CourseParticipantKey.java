package com.mybatis;

public class CourseParticipantKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE_PARTICIPANT.COURSE_SCHEDULE_ID
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    private Integer courseScheduleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE_PARTICIPANT.PARTICIPANT_ID
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    private String participantId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE_PARTICIPANT.COURSE_SCHEDULE_ID
     *
     * @return the value of PUBLIC.COURSE_PARTICIPANT.COURSE_SCHEDULE_ID
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    public Integer getCourseScheduleId() {
        return courseScheduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE_PARTICIPANT.COURSE_SCHEDULE_ID
     *
     * @param courseScheduleId the value for PUBLIC.COURSE_PARTICIPANT.COURSE_SCHEDULE_ID
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    public void setCourseScheduleId(Integer courseScheduleId) {
        this.courseScheduleId = courseScheduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE_PARTICIPANT.PARTICIPANT_ID
     *
     * @return the value of PUBLIC.COURSE_PARTICIPANT.PARTICIPANT_ID
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    public String getParticipantId() {
        return participantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE_PARTICIPANT.PARTICIPANT_ID
     *
     * @param participantId the value for PUBLIC.COURSE_PARTICIPANT.PARTICIPANT_ID
     *
     * @mbg.generated Sun Nov 19 12:53:08 CST 2017
     */
    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }
}
package com.tn.wechat.entity;

public class Course {
	int id;
	String courseName;
	String courseDetail;
	String courseNumber;
	boolean isSubscribe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDetail() {
		return courseDetail;
	}
	public void setCourseDetail(String courseDetail) {
		this.courseDetail = courseDetail;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public boolean isSubscribe() {
		return isSubscribe;
	}
	public void setSubscribe(boolean isSubscribe) {
		this.isSubscribe = isSubscribe;
	}
	
	
}

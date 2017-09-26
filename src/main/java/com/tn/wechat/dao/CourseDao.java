package com.tn.wechat.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tn.wechat.dbhelper.DBHelper;
import com.tn.wechat.entity.Course;

public class CourseDao {
	public List<Course> getCourseInfo(){
		DBHelper dbHelper = new DBHelper();
		SqlSession sqlSession = null;
		List<Course> courseList = new ArrayList<Course>();
		try{
			sqlSession = dbHelper.getSqlSession();
			courseList = sqlSession.selectList("Course.select");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
				sqlSession=null;
			}
		}
		return courseList;
	}
//	public static void main(String[] args) {
//		CourseDao forumDao = new CourseDao();
//		List<Forum> forumList = forumDao.getForumInfo();
//		for (Forum forum : forumList) {
//			System.out.println(forum.toString());
//		}
//	}
}

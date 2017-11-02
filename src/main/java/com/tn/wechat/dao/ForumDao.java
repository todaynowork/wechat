package com.tn.wechat.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tn.wechat.dbhelper.DBHelper;
import com.tn.wechat.entity.Forum;

public class ForumDao {
	public List<Forum> getForumInfo(){
		DBHelper dbHelper = new DBHelper();
		SqlSession sqlSession = null;
		List<Forum> forumList = new ArrayList<Forum>();
		try{
			sqlSession = dbHelper.getSqlSession();
			forumList = sqlSession.selectList("Forum.select");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
				sqlSession=null;
			}
		}
		return forumList;
	}
//********************************************************
	public List<Forum> getMyQuestion(String openid){
		DBHelper dbHelper = new DBHelper();
		SqlSession sqlSession = null;
		List<Forum> forumList = new ArrayList<Forum>();
		try{
			sqlSession = dbHelper.getSqlSession();
			forumList = sqlSession.selectList("Forum.getMyQuestion",openid);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
				sqlSession=null;
			}
		}
		return forumList;
	}
}

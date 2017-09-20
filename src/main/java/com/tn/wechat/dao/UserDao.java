package com.tn.wechat.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tn.wechat.dbhelper.DBHelper;
import com.tn.wechat.entity.User;

public class UserDao {
	public List<User> getUserInfo(){
		DBHelper dbHelper = new DBHelper();
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		try{
			sqlSession = dbHelper.getSqlSession();
			userList = sqlSession.selectList("User.select");
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
				sqlSession=null;
			}
		}
		return userList;
	}
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		List<User> userList = userDao.getUserInfo();
		for (User user : userList) {
			System.out.println(user.getName()+"&"+user.getPassword());
		}
	}
}


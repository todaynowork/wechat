package com.tn.wechat.dbhelper;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

public class TestConnect {
	public void test() {
		DBHelper dbHelper = new DBHelper();
		SqlSession sqlSession = null;
		// List<Question> questionList = new ArrayList<Question>();
		try {
			sqlSession = dbHelper.getSqlSession();
			if(sqlSession==null){
				System.out.println("NO");
			}else{
				System.out.println("Yes");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		TestConnect tc = new TestConnect();
		tc.test();
	}
}

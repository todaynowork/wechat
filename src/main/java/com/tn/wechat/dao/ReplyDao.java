package com.tn.wechat.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tn.wechat.dbhelper.DBHelper;
import com.tn.wechat.entity.Reply;

public class ReplyDao {
	public List<Reply> getReplyInfo(){
		List<Reply> replyList = new ArrayList<Reply>();
		DBHelper dbHelper = new DBHelper();
		SqlSession sqlSession = null;
		try {
			 sqlSession = dbHelper.getSqlSession();
			 replyList = sqlSession.selectList("Reply.select");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return replyList;
	}
	public static void main(String[] args) {
		ReplyDao replyDao = new ReplyDao();
		for (Reply reply : replyDao.getReplyInfo()) {
			System.out.println(reply.toString());
		}
	}
}

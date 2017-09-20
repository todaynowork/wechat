package com.tn.wechat.dbhelper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Get sqlsession function
 */
public class DBHelper{
	public SqlSession getSqlSession() throws IOException{
		//通过配置文件获取数据库连接
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		//获取sqlsessionfactory
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		//通过sqlsessionfactory打开一个session
		SqlSession sqlSession = ssf.openSession();
		return sqlSession;
	}
}

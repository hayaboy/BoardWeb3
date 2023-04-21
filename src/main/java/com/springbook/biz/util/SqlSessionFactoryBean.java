package com.springbook.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	
	private static SqlSessionFactory sessionFactory = null;
	
	static {
		
		try {
		
			if(sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		
		}catch(Exception e) {
			System.out.println("SqlSessionFactory 관련 에러");
//			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	//The primary Java interface for working with MyBatis.Through this interface you can execute commands, get mappers and manage transactions.
	public static SqlSession getSqlSessionInstance(){
		return sessionFactory.openSession();
	}
	
	
	
	
	

}

package cn.itsource.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itsource.domain.Product;

public class HelloTest {
      
	 @Test
	public void testGetSqlSession() throws Exception {
		 
		 InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream("mybatis.xml");
		 
		 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		 
		 SqlSession sqlSession = factory.openSession();
		 
		 System.out.println(sqlSession);
		 
		 sqlSession.close();
		 	 
	}
	
	 
	 
	 @Test
	public void testGet() throws Exception {
		 
		 InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream("mybatis.xml");
		 
		 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		 
		  SqlSession sqlSession = factory.openSession();
		  //  参数    是命名空间+id
		  Product product= sqlSession.selectOne("cn.itsource.domain.ProductMapper.get",1L);
		  
		  System.out.println(product);
		  
		  sqlSession.close();
		 
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

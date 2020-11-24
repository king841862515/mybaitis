package cn.itsource.util;


import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * Mybatis的工具类（单例或者是静态方法）
 * @author admin
 *
 */
public class MybatisUtil {

	
	// 私有化构造器，让这对象不能创建
	private MybatisUtil(){}
	
	
//	  InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream("mybatis.xml");
//	 
//	  SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//	 
//	  SqlSession sqlSession = factory.openSession();
//	  上面是不在工具类中的写法
	
	private static SqlSessionFactory sqlSessionFactory;// SqlSessionFactory是线程安全的，可以做成员变量，一个项目只需要一个sqlSessionFactory，他是重量级对象，非常消耗资源
	
	//静态代码块只会运行一次，在类开始加载的时候加载
	static {
		
		try {
			 InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			 
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			 
		} catch (Exception e) {      //这里抓最大异常
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		  throw new RuntimeException("配置文件出错！" + e.getMessage());
		}
		
			
	}
	//每次调用都要单独创建一次sqlSession，sqlSession是线程不安全的
	//通过sqlSessionFactory得到sqlSession
	//sqlSession是轻量级对象
	 public static SqlSession openSession() {
		 
		 return sqlSessionFactory.openSession();
		
	}
	
	
	
	
}

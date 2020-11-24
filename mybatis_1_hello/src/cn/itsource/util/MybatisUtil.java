package cn.itsource.util;


import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * Mybatis�Ĺ����ࣨ���������Ǿ�̬������
 * @author admin
 *
 */
public class MybatisUtil {

	
	// ˽�л�����������������ܴ���
	private MybatisUtil(){}
	
	
//	  InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream("mybatis.xml");
//	 
//	  SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//	 
//	  SqlSession sqlSession = factory.openSession();
//	  �����ǲ��ڹ������е�д��
	
	private static SqlSessionFactory sqlSessionFactory;// SqlSessionFactory���̰߳�ȫ�ģ���������Ա������һ����Ŀֻ��Ҫһ��sqlSessionFactory���������������󣬷ǳ�������Դ
	
	//��̬�����ֻ������һ�Σ����࿪ʼ���ص�ʱ�����
	static {
		
		try {
			 InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			 
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			 
		} catch (Exception e) {      //����ץ����쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		  throw new RuntimeException("�����ļ�����" + e.getMessage());
		}
		
			
	}
	//ÿ�ε��ö�Ҫ��������һ��sqlSession��sqlSession���̲߳���ȫ��
	//ͨ��sqlSessionFactory�õ�sqlSession
	//sqlSession������������
	 public static SqlSession openSession() {
		 
		 return sqlSessionFactory.openSession();
		
	}
	
	
	
	
}

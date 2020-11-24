package cn.itsource.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.itsource.dao.IproductDao;
import cn.itsource.domain.Product;
import cn.itsource.util.MybatisUtil;

public class ProductDaoImpl implements IproductDao {

	private static final String NAME_SPACE = "cn.itsource.domain.ProductMapper.";

	@Override
	public void save(Product p) {
		SqlSession session = null;

		try {
			session = MybatisUtil.openSession();
			session.insert(NAME_SPACE + "save", p);

			// ������Ҫע�⣬��ɾ����Ҫ�ύ������Ϊ����һ���õı��������innodb����֧������ģ���ֻ��myisam������ı��ǿ���ֱ�Ӳ����

			session.commit();

		} catch (Exception e) {
			session.rollback();//����ع�
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void update(Product p) {
		SqlSession session = null;

		try {
			session = MybatisUtil.openSession();
			session.insert(NAME_SPACE + "update", p);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Long id) {
		SqlSession session = null;

		try {
			session = MybatisUtil.openSession();
			session.delete(NAME_SPACE + "delete", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Product getOne(Long id) {
		SqlSession session = null;
		try {
			session = MybatisUtil.openSession();
			return session.selectOne(NAME_SPACE + "get", id); // return�������ǽ����÷���������ִ�з��������䡣

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null; // �����return�ǽ������
	}
	// return��try-catch-finally����е�ʹ�ã�����
	// try��catch���������return��䣬finally����return����ִ��˳�����⣺

	// 1.����finally��䣬��������Σ�����ִ�и���䣬��try��catch�е�return���Ὣ���ķ���ֵѹ��ջ�ڣ�Ȼ��ִ��finally��䣬

	// ��finallyִ����ɺ���finally�������return��䣬��ִ��return��䲢������

	// 2.��finallyû��return��䣬�򷵻ر������ջ���return��䣬��ִ�С�Ȼ������ѹջʱ��Ҫע��ѹ��ջ�ڵ���ʲô��������ֵ���������ã��������������õ�ֵ��ı䣬���Ǳ���ֵ���򲻻�ı䡣

	@Override
	public List<Product> getAll() {

		SqlSession session = null;
		try {
			session = MybatisUtil.openSession();
			return session.selectList(NAME_SPACE + "getAll");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

}

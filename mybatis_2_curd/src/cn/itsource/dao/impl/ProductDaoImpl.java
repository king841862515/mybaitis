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

			// 这里需要注意，增删改需要提交事务，因为我们一般用的表的引擎是innodb，是支持事务的，而只有myisam的引擎的表是可以直接插入的

			session.commit();

		} catch (Exception e) {
			session.rollback();//事务回滚
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
			return session.selectOne(NAME_SPACE + "get", id); // return的作用是结束该方法，继续执行方法后的语句。

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null; // 这里的return是结束语句
	}
	// return在try-catch-finally语句中的使用，若在
	// try或catch语句里面有return语句，finally语句和return语句的执行顺序问题：

	// 1.若有finally语句，则无论如何，都会执行该语句，在try或catch中的return语句会将它的返回值压入栈内，然后执行finally语句，

	// 当finally执行完成后，若finally语句里有return语句，则执行return语句并结束。

	// 2.若finally没有return语句，则返回被保存的栈里的return语句，再执行。然而，在压栈时候，要注意压入栈内的是什么东西，是值本身还是引用，若是引用则引用的值会改变，若是变量值，则不会改变。

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

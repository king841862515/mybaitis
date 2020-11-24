package cn.itsource.test;

import java.util.List;

import org.junit.Test;

import cn.itsource.dao.IproductDao;
import cn.itsource.dao.impl.ProductDaoImpl;
import cn.itsource.domain.Product;

public class ProductDaoTest {

	// 这里没有spring，没有依赖注入，所以需要自己new一个对象出来
	IproductDao productDao = new ProductDaoImpl();

	@Test
	public void testGet() throws Exception {
		Product product = productDao.getOne(2L);
		System.out.println(product);
	}

	@Test
	public void testGetAll() throws Exception {

		List<Product> all = productDao.getAll();
		System.out.println(all.size());
		for (Product product : all) {
			System.out.println(product);
		}
	}

	@Test
	public void testSave() throws Exception {
		// 取出一条数据，然后改造之后再保存新数据
		Product product = productDao.getOne(2L);
		product.setPid(10L);
//		product.setPname("博士");

		System.out.println(product);
		productDao.save(product);

	}

	@Test
	public void testUpdate() throws Exception {
		Product product = productDao.getOne(10L);
//		product.setPname("超级赛亚人");	

		productDao.update(product);
	}

	@Test
	public void testDelete() throws Exception {
		productDao.delete(10L);
	}

}

package cn.itsource.test;

import java.util.List;

import org.junit.Test;

import cn.itsource.dao.IproductDao;
import cn.itsource.dao.impl.ProductDaoImpl;
import cn.itsource.domain.Product;

public class ProductDaoTest {

	// ����û��spring��û������ע�룬������Ҫ�Լ�newһ���������
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
		// ȡ��һ�����ݣ�Ȼ�����֮���ٱ���������
		Product product = productDao.getOne(2L);
		product.setPid(10L);
//		product.setPname("��ʿ");

		System.out.println(product);
		productDao.save(product);

	}

	@Test
	public void testUpdate() throws Exception {
		Product product = productDao.getOne(10L);
//		product.setPname("����������");	

		productDao.update(product);
	}

	@Test
	public void testDelete() throws Exception {
		productDao.delete(10L);
	}

}

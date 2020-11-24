package cn.itsource.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.itsource.domain.many2one.Category;
import cn.itsource.domain.many2one.Product;
import cn.itsource.util.MybatisUtil;

public class MainTestDaoMany2one {

	private static final String NAME_SPACE_Category = "cn.itsource.domain.many2one.CategoryMapper.";
	private static final String NAME_SPACE_Ƕ�׽��_Product = "cn.itsource.domain.many2one.ProductǶ�׽��Mapper.";
	private static final String NAME_SPACE_Ƕ�ײ�ѯ_Product = "cn.itsource.domain.many2one.ProductǶ�ײ�ѯMapper.";
	private static final String NAME_SPACE_Ұ����_Product = "cn.itsource.domain.many2one.ProductҰ����Mapper.";

	@Test
	public void testgetAllProducts() throws Exception {
		SqlSession session = MybatisUtil.openSession();
		// List<Product> products = session.selectList(NAME_SPACE_Product +
		// "getProducts");// �Զ�������߱���ʹ��ctrl+1+l
		List<Product> products = session.selectList(NAME_SPACE_Ƕ�ײ�ѯ_Product + "getProducts");// �Զ�������߱���ʹ��ctrl+1+l
		System.out.println("product.size:" + products.size());
		for (Product product : products) {
			System.out.println(product);
			System.out.println(product.getCategory());
			System.out.println("-----------------------------");
		}
		session.commit();
		session.close();
	}

	@Test
	public void testSave() throws Exception {

		SqlSession session = MybatisUtil.openSession();
		// ����Ŀ¼
		Category category1 = new Category(4L, "�����Ʒ");
		Category category2 = new Category(5L, "�߲�ˮ��");

		session.insert(NAME_SPACE_Category + "saveCategory", category1);
		session.insert(NAME_SPACE_Category + "saveCategory", category2);

		// ������Ʒ
		for (int i = 1; i < 6; i++) {
			Product product = new Product();
			product.setPid(9L + i);
			product.setPname("�ֻ�" + i);
			product.setPrice(2000.0);
			product.setFlag("1");
			product.setCategory(category1);
			session.insert(NAME_SPACE_Ƕ�׽��_Product + "saveProduct", product);
		}
		for (int i = 1; i < 6; i++) {
			Product product = new Product();
			product.setPid(14L + i);
			product.setPname("ƻ��" + i);
			product.setPrice(2000.0);
			product.setFlag("1");
			product.setCategory(category2);
			session.insert(NAME_SPACE_Ƕ�׽��_Product + "saveProduct", product);
		}

		session.commit();
		session.close();

	}
}
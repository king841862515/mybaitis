package cn.itsource.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.itsource.domain.many2one.Category;
import cn.itsource.domain.many2one.Product;
import cn.itsource.util.MybatisUtil;

public class MainTestDaoMany2one {

	private static final String NAME_SPACE_Category = "cn.itsource.domain.many2one.CategoryMapper.";
	private static final String NAME_SPACE_嵌套结果_Product = "cn.itsource.domain.many2one.Product嵌套结果Mapper.";
	private static final String NAME_SPACE_嵌套查询_Product = "cn.itsource.domain.many2one.Product嵌套查询Mapper.";
	private static final String NAME_SPACE_野方法_Product = "cn.itsource.domain.many2one.Product野方法Mapper.";

	@Test
	public void testgetAllProducts() throws Exception {
		SqlSession session = MybatisUtil.openSession();
		// List<Product> products = session.selectList(NAME_SPACE_Product +
		// "getProducts");// 自动生成左边变量使用ctrl+1+l
		List<Product> products = session.selectList(NAME_SPACE_嵌套查询_Product + "getProducts");// 自动生成左边变量使用ctrl+1+l
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
		// 保存目录
		Category category1 = new Category(4L, "数码产品");
		Category category2 = new Category(5L, "蔬菜水果");

		session.insert(NAME_SPACE_Category + "saveCategory", category1);
		session.insert(NAME_SPACE_Category + "saveCategory", category2);

		// 保存商品
		for (int i = 1; i < 6; i++) {
			Product product = new Product();
			product.setPid(9L + i);
			product.setPname("手机" + i);
			product.setPrice(2000.0);
			product.setFlag("1");
			product.setCategory(category1);
			session.insert(NAME_SPACE_嵌套结果_Product + "saveProduct", product);
		}
		for (int i = 1; i < 6; i++) {
			Product product = new Product();
			product.setPid(14L + i);
			product.setPname("苹果" + i);
			product.setPrice(2000.0);
			product.setFlag("1");
			product.setCategory(category2);
			session.insert(NAME_SPACE_嵌套结果_Product + "saveProduct", product);
		}

		session.commit();
		session.close();

	}
}
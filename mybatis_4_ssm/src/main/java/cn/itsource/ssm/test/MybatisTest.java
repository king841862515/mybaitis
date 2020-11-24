package cn.itsource.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itsource.ssm.domain.Product;
import cn.itsource.ssm.mapper.ProductMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	ProductMapper productMapper;

	@Test
	public void testGetAll() throws Exception {

		List<Product> products = productMapper.getAll();
		System.out.println(products);
	}

}

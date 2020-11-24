package cn.itsource.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.itsource.domain.one2many.CategoryAlias;
import cn.itsource.util.MybatisUtil;

public class MainTestDaoOne2many {

	private static final String NAME_SPACE_嵌套结果_Category = "cn.itsource.domain.one2many.CategoryAlias嵌套结果Mapper.";
	private static final String NAME_SPACE_嵌套查询_Category = "cn.itsource.domain.one2many.CategoryAlias嵌套查询Mapper.";

	@Test
	public void testGetAllCategory() throws Exception {
		SqlSession session = MybatisUtil.openSession();
		List<CategoryAlias> categorys = session.selectList(NAME_SPACE_嵌套查询_Category + "getCategorys");// 自动生成左边变量使用ctrl+1+l
		System.out.println("categorys.size:" + categorys.size());
		for (CategoryAlias category : categorys) {
			System.out.println(category);
			System.out.println(category.getProducts());
			System.out.println("-----------------------------");
		}
		session.commit();
		session.close();
	}
}

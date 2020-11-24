package cn.itsource.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.itsource.domain.one2many.CategoryAlias;
import cn.itsource.util.MybatisUtil;

public class MainTestDaoOne2many {

	private static final String NAME_SPACE_Ƕ�׽��_Category = "cn.itsource.domain.one2many.CategoryAliasǶ�׽��Mapper.";
	private static final String NAME_SPACE_Ƕ�ײ�ѯ_Category = "cn.itsource.domain.one2many.CategoryAliasǶ�ײ�ѯMapper.";

	@Test
	public void testGetAllCategory() throws Exception {
		SqlSession session = MybatisUtil.openSession();
		List<CategoryAlias> categorys = session.selectList(NAME_SPACE_Ƕ�ײ�ѯ_Category + "getCategorys");// �Զ�������߱���ʹ��ctrl+1+l
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

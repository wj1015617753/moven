package com.wj.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wj.entity.Admin;



public class TestAdmin {

	@Test
	public void test() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
		SqlSessionFactory sqlSession = new SqlSessionFactoryBuilder().build(is);
		SqlSession sql = sqlSession.openSession(true);
		AdminDao admin = sql.getMapper(AdminDao.class);
		Admin ad = admin.selAdminByNP(new Admin("wj","123"));
		System.out.println(ad);
	}

}

package com.test.project.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.project.dao.gen.UserDetailMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath*:spring/wei-dataSource.xml"
	})
public class TestDao {
	
	@Resource
	private UserDetailMapper mapper;

	@Test
	public void test() {
		String name = mapper.selectByPrimaryKey("123456").getPassword();
		System.out.println(name);
	}

}

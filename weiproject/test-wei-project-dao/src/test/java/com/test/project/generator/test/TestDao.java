package com.test.project.generator.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath*:spring/test-dataSource.xml"
	})
public class TestDao {
	
	/*@Resource
	private UserDetailMapper mapper;

	@Test
	public void test() {
		String name = mapper.selectByPrimaryKey("123456").getUserName();
		System.out.println(name);
	}*/

}

package com.text.project.auth.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.project.po.gen.UserDetail;
import com.text.project.service.IUserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath*:spring/wei-dataSource.xml",
	"classpath*:spring/wei-project-service.xml"
	})
public class TestCreateUser {

	@Resource
	private IUserService userservic;
	
	
	@Test
	public void testCreate(){
		UserDetail user = new UserDetail();
		user.setLoginName("lijunli@qq.com");
		user.setPassword("123456");
		userservic.createUser(user);
	}
}

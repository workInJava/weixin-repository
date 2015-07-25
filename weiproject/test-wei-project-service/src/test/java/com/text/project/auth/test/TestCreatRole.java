package com.text.project.auth.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.project.po.gen.Role;
import com.text.project.service.IRoleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath*:spring/wei-dataSource.xml",
	"classpath*:spring/wei-project-service.xml"
	})
public class TestCreatRole {
	
	@Resource
	private IRoleService roleService;

	@Test
	public void test() {
		for(int i=0;i<1000;i++){
			Role role = new Role();
			role.setRoleName("admin"+i);
			role.setRoleDescription("¹ÜÀíÔ±"+i);
			roleService.createRole(role);
		}
	}

}

package com.text.project.auth.test;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.common.utils.Sequence;
import com.test.project.dao.gen.RoleMapper;
import com.test.project.dao.gen.RoleOfUserMapper;
import com.test.project.dao.gen.UserDetailMapper;
import com.test.project.po.gen.Role;
import com.test.project.po.gen.RoleExample;
import com.test.project.po.gen.RoleOfUser;
import com.test.project.po.gen.UserDetail;
import com.test.project.po.gen.UserDetailExample;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath*:spring/wei-dataSource.xml",
	"classpath*:spring/wei-project-service.xml"
	})
public class TestAuthor {
	@Resource
	private RoleOfUserMapper ruDao;
	@Resource
	private UserDetailMapper userDao;
	@Resource
	private RoleMapper roleDao;
	
	@Test
	public void test() {
		RoleOfUser record = new RoleOfUser();
		RoleExample rexample = new RoleExample();
		List<Role>  roles = roleDao.selectByExample(rexample);
		UserDetailExample uexample = new UserDetailExample();
		List<UserDetail> uses = userDao.selectByExample(uexample);
		Random random1 = new Random();
		Random random2 = new Random();
		for(int i=0;i<1000;i++){
			int nu = random1.nextInt(roles.size());
			int e = random2.nextInt(uses.size());
			System.out.println(nu+"-----------------------roles-------------");
			Role  r = roles.get(nu);
			record.setRoleId(r.getRoleId());
			Date now = new Date(); 
			record.setCreateTime(now);
			record.setUpdateTime(now);
			record.setRoleUserId(Sequence.nextId());
			System.out.println(e+"===========================user=============================================");
			UserDetail u = uses.get(e);
			record.setUserId(u.getUserId());
			ruDao.insertSelective(record);
		}
	}

}

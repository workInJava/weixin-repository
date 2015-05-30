package com.text.project.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.test.project.dao.gen.UserDetailMapper;
import com.test.project.po.gen.UserDetail;
import com.test.project.po.gen.UserDetailExample;
import com.text.project.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserDetailMapper useDao;

	@Override
	public UserDetail createUser(UserDetail user) {
		return null;
	}

	@Override
	public UserDetail updateUser(UserDetail user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDetail findOne(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetail findByUsername(String username) {
		UserDetail userDetail = null;
		UserDetailExample example = new UserDetailExample();
		example.createCriteria().andLoginNameEqualTo(username);
		List<UserDetail> userDetails = useDao.selectByExample(example);
		if(!CollectionUtils.isEmpty(userDetails)){
			userDetail = userDetails.get(0);
		}
		return userDetail;
		
	}

}

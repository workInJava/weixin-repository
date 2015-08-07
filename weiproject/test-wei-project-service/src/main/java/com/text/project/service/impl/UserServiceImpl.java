package com.text.project.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.test.common.enums.UserStateEnum;
import com.test.common.exception.WeiException;
import com.test.common.utils.Sequence;
import com.test.project.dao.gen.UserDetailMapper;
import com.test.project.po.gen.UserDetail;
import com.test.project.po.gen.UserDetailExample;
import com.text.project.service.IUserService;
import com.text.project.utils.EndecryptUtils;

@Service
public class UserServiceImpl implements IUserService{

	private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserDetailMapper useDao;

	@Override
	public UserDetail createUser(UserDetail user) {
		try {
			if (user == null || StringUtils.isEmpty(user.getLoginName())
					|| StringUtils.isEmpty(user.getPassword())) {
				throw new WeiException("loginName or password can not empty");
			}
		} catch (WeiException e) {
			LOGGER.error(e.getMessage());
		}
		Date now = new Date();
		String userId =Sequence.nextId();
		user.setUserId(userId);
		user.setUpdateTime(now);
		user.setCreateTime(now);
		user.setLastLognTime(now);
		user.setType(UserStateEnum.NORM.toString());
		EndecryptUtils.md5Password(user);
		useDao.insert(user);
		return user;
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
		if (!CollectionUtils.isEmpty(userDetails)) {
			userDetail = userDetails.get(0);
		}
		return userDetail;

	}

}

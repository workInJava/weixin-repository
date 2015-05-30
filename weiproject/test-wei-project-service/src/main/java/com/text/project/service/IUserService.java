package com.text.project.service;

import java.util.List;

import com.test.project.po.gen.UserDetail;

public interface IUserService {
	public UserDetail createUser(UserDetail user);// 创建用户
	public UserDetail updateUser(UserDetail user);// 更新用户
	public void deleteUser(Long userId);// 删除用户
	public void changePassword(Long userId, String newPassword); //修改密码
	UserDetail findOne(Long userId);// 根据id 查找用户
	List<UserDetail> findAll();// 得到所有用户
	public UserDetail findByUsername(String username);// 根据用户名查找用户
}

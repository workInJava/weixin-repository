package com.text.project.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.common.utils.Sequence;
import com.test.project.dao.gen.RoleMapper;
import com.test.project.po.gen.Role;
import com.text.project.service.IRoleService;
@Service
public class RoleService implements IRoleService {
	
	@Resource
	private RoleMapper roleDao;
	
	@Override
	public Role createRole(Role role) {
		String roleId = Sequence.nextId();
		Date now = new Date();
		role.setRoleId(roleId);
		role.setCreateTime(now);
		role.setUpdateTime(now);
		roleDao.insertSelective(role);
		return role;
	}

	@Override
	public void deleteRole(Long roleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void correlationPermissions(Long roleId, Long... permissionIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
		// TODO Auto-generated method stub

	}

}

package com.text.project.service;

import com.test.project.po.gen.Role;

public interface IRoleService {
	public Role createRole(Role role);

	public void deleteRole(Long roleId);

	// 添加角色-权限之间关系
	public void correlationPermissions(Long roleId, Long... permissionIds);

	// 移除角色-权限之间关系
	public void uncorrelationPermissions(Long roleId, Long... permissionIds);//
}
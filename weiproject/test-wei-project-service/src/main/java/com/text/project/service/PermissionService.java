package com.text.project.service;

import com.test.project.po.gen.Permission;

public interface PermissionService {
	
	public Permission createPermission(Permission permission);

	public void deletePermission(Long permissionId);
}
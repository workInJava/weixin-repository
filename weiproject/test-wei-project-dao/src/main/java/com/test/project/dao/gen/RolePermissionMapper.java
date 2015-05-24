package com.test.project.dao.gen;

import com.test.project.po.gen.RolePermission;
import com.test.project.po.gen.RolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RolePermissionMapper {
    int countByExample(RolePermissionExample example);

    int deleteByExample(RolePermissionExample example);

    int deleteByPrimaryKey(String rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExampleWithRowbounds(RolePermissionExample example, RowBounds rowBounds);

    List<RolePermission> selectByExample(RolePermissionExample example);

    RolePermission selectByPrimaryKey(String rolePermissionId);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}
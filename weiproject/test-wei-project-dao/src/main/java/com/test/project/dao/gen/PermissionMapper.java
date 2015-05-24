package com.test.project.dao.gen;

import com.test.project.po.gen.Permission;
import com.test.project.po.gen.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PermissionMapper {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(String permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExampleWithRowbounds(PermissionExample example, RowBounds rowBounds);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(String permissionId);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}
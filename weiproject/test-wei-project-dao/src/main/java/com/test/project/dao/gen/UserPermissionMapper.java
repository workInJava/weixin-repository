package com.test.project.dao.gen;

import com.test.project.po.gen.UserPermission;
import com.test.project.po.gen.UserPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserPermissionMapper {
    int countByExample(UserPermissionExample example);

    int deleteByExample(UserPermissionExample example);

    int deleteByPrimaryKey(String userPermissionId);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    List<UserPermission> selectByExampleWithRowbounds(UserPermissionExample example, RowBounds rowBounds);

    List<UserPermission> selectByExample(UserPermissionExample example);

    UserPermission selectByPrimaryKey(String userPermissionId);

    int updateByExampleSelective(@Param("record") UserPermission record, @Param("example") UserPermissionExample example);

    int updateByExample(@Param("record") UserPermission record, @Param("example") UserPermissionExample example);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
}
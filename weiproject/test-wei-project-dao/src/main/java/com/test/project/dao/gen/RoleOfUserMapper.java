package com.test.project.dao.gen;

import com.test.project.po.gen.RoleOfUser;
import com.test.project.po.gen.RoleOfUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RoleOfUserMapper {
    int countByExample(RoleOfUserExample example);

    int deleteByExample(RoleOfUserExample example);

    int deleteByPrimaryKey(String roleUserId);

    int insert(RoleOfUser record);

    int insertSelective(RoleOfUser record);

    List<RoleOfUser> selectByExampleWithRowbounds(RoleOfUserExample example, RowBounds rowBounds);

    List<RoleOfUser> selectByExample(RoleOfUserExample example);

    RoleOfUser selectByPrimaryKey(String roleUserId);

    int updateByExampleSelective(@Param("record") RoleOfUser record, @Param("example") RoleOfUserExample example);

    int updateByExample(@Param("record") RoleOfUser record, @Param("example") RoleOfUserExample example);

    int updateByPrimaryKeySelective(RoleOfUser record);

    int updateByPrimaryKey(RoleOfUser record);
}
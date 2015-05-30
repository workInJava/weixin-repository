package com.test.project.dao.gen;

import com.test.project.po.gen.UserDetail;
import com.test.project.po.gen.UserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserDetailMapper {
    int countByExample(UserDetailExample example);

    int deleteByExample(UserDetailExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    List<UserDetail> selectByExampleWithRowbounds(UserDetailExample example, RowBounds rowBounds);

    List<UserDetail> selectByExample(UserDetailExample example);

    UserDetail selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserDetail record, @Param("example") UserDetailExample example);

    int updateByExample(@Param("record") UserDetail record, @Param("example") UserDetailExample example);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}
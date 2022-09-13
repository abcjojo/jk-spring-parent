package com.liyijun.jk.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liyijun.jk.entity.SysUser;
import org.apache.ibatis.annotations.*;

/**
 * mapper接口
 *
 * @Author: liyh
 */
@Mapper
public interface MasterMapper extends BaseMapper<SysUser> {

    @Select("select * from sys_user where user_id = #{userId}")
    SysUser getMasterInfo(@Param("userId") String userId);

    @Select("select count(*) from sys_user")
    int selectCount();

    @Options(useGeneratedKeys=true,keyProperty="userId")
    @Insert("insert into sys_user" +
            " (user_name,nick_name)" +
            " values(#{userName},#{nickName})")
    int insert(SysUser sysUser);
}
package com.liyijun.jk.mapper.master;

import com.liyijun.jk.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * mapper接口
 *
 * @Author: liyh
 */
@Mapper
public interface MasterMapper {

    @Select("select * from sys_user where user_id = #{userId}")
    SysUser getMasterInfo(@Param("userId") String userId);

}
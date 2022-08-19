package com.liyijun.jk.mapper.slave1;

import com.liyijun.jk.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * test接口
 *
 * @Author: liyh
 */
@Mapper
public interface Slave1Mapper {

//    @Select("select * from sys_user where user_id = #{userId}")
    SysUser getTestInfo(@Param("userId") String userId);

}
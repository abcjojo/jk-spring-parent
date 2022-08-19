package com.liyijun.jk.service;


import com.liyijun.jk.entity.SysUser;

/**
 * 用户业务接口
 *
 * @Author: liyh
 */
public interface UserService {

    SysUser getMasterInfo(String userId);

    SysUser getTestInfo(String userId);

}
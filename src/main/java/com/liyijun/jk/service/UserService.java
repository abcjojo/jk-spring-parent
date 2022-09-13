package com.liyijun.jk.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.liyijun.jk.entity.SysUser;

/**
 * 用户业务接口
 *
 * @Author: liyh
 */
public interface UserService {

    SysUser getMasterInfo(String userId);

    SysUser getTestInfo(String userId);


    void txTest();

    public void insertUser2() ;

    public void insertUser1();
}
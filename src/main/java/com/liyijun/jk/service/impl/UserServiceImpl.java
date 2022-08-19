package com.liyijun.jk.service.impl;

import com.liyijun.jk.entity.SysUser;
import com.liyijun.jk.mapper.master.MasterMapper;
import com.liyijun.jk.mapper.slave1.Slave1Mapper;
import com.liyijun.jk.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户业务实现类
 *
 * @Author: liyh
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private MasterMapper masterMapper;

    @Resource
    private Slave1Mapper testMapper;

    @Override
    public SysUser getMasterInfo(String userId) {
        return masterMapper.getMasterInfo(userId);
    }

    @Override
    public SysUser getTestInfo(String userId) {
        return testMapper.getTestInfo(userId);
    }

}
package com.liyijun.jk.service.impl;

import com.liyijun.jk.entity.SysUser;
import com.liyijun.jk.mapper.master.MasterMapper;
import com.liyijun.jk.mapper.slave1.Slave1Mapper;
import com.liyijun.jk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户业务实现类
 *
 * @Author: liyh
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private MasterMapper masterMapper;

    @Resource
    private Slave1Mapper slave1Mapper;

    @Override
    public SysUser getMasterInfo(String userId) {
        return masterMapper.getMasterInfo(userId);
    }

    @Override
    public SysUser getTestInfo(String userId) {
        return slave1Mapper.getTestInfo(userId);
    }

    @Override
    public void txTest() {

    }

    /**
    * @Description:  多数据源下，创建多个事务管理器，在使用 @Transactional 注解时需要指定 使用哪一个事务管理器，否则会抛出异常
    */
    @Transactional(value = "masterTxManager")
    @Override
    public void insertUser1() {
        log.info("记录打印：{}", masterMapper.selectCount());
        log.info("开始插入数据");
        SysUser sysUser = new SysUser("测试2", "小明");
        masterMapper.insert(sysUser);
        log.info("记录打印：{}", masterMapper.selectCount());
        int a = 2/0;
    }

    /**
     *   1、两个方法都有事务时，insertUser1方法抛出异常，会导致两个方法都回滚 当 propagation = Propagation.NESTED 时，里面的事务回滚不会影响到外面的事务
     *   2、insertUser2有事务，insertUser1无事务，且在insertUser1中抛出异常后，会导致insertUser2方法回滚
     *   3、insertUser1有事务，insertUser2没有事务，insertUser1的事务不会回滚，且抛出异常代码段之前的upd操作都不会回滚，因为方法内部调用时
     *      不会出发事务管理器，因此事务没生效，相当于普通的方法调用。
    */
//    @Transactional("masterTxManager")
    @Override
    public void insertUser2(){
        SysUser sysUser = new SysUser("测试3", "小兰");
        masterMapper.insert(sysUser);
        insertUser1();
        SysUser sysUser1 = new SysUser("测试4", "小刚");
        masterMapper.insert(sysUser1);
    }
}
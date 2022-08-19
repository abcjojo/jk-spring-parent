package com.liyijun.jk.controller;


import com.liyijun.jk.entity.SysUser;
import com.liyijun.jk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liyh
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/getMasterInfo")
    public SysUser getMasterInfo(@RequestParam String userId) {
        SysUser user = userService.getMasterInfo(userId);
        log.info("master user : {}", user);
        return user;
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/getSlaveInfo")
    public SysUser getTestInfo(@RequestParam String userId) {
        SysUser user = userService.getTestInfo(userId);
        log.info("slave user : {}", user);
        return user;
    }

}
package com.liyijun.jk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户对象 sys_user
 *
 * @author liyh
 */
@Data
@NoArgsConstructor
public class SysUser {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    public SysUser(String userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }
}
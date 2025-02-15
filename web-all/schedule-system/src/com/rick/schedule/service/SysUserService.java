package com.rick.schedule.service;

import com.rick.schedule.pojo.SysUser;

/**
 * 該接口定義sys_user表格為核心的業務處理功能
 */
public interface SysUserService {

    /**
     * 註冊用戶的方法
     * @param sysUser   要註冊的用戶名和明文密碼以SysUser對象的形式接收
     * @return 註冊成功返回1 註冊失敗返回0
     */
    int regist(SysUser sysUser);

    /**
     * 根據用戶名獲得完整用戶訊息的方法
     * @param username  要查詢的用戶名
     * @return  如果找到了就返回SysUser對象,找不到返回null
     */
    SysUser findByUsername(String username);
}

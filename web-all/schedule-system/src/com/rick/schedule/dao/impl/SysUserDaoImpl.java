package com.rick.schedule.dao.impl;

import com.rick.schedule.dao.BaseDao;
import com.rick.schedule.dao.SysUserDao;
import com.rick.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {


    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "INSERT INTO sys_user (username, user_pwd) VALUES (?, ?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());


    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "SELECT uid,username,user_pwd userPwd FROM sys_user WHERE username = ?";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);

        return sysUserList != null && sysUserList.size() > 0 ? sysUserList.get(0) : null;
    }
}

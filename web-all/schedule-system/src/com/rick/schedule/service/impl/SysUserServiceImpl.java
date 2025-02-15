package com.rick.schedule.service.impl;

import com.rick.schedule.dao.SysUserDao;
import com.rick.schedule.dao.impl.SysUserDaoImpl;
import com.rick.schedule.pojo.SysUser;
import com.rick.schedule.service.SysUserService;
import com.rick.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {

        // 將用戶的明文密碼轉換為密文密碼
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));

        //  調用DAO層的方法將SysUser信息傳入數據庫
        int rows = userDao.addSysUser(sysUser);

        // 紀錄影響行數
        System.out.println("影響行數: " + rows);

        return rows;
    }

    @Override
    public SysUser findByUsername(String username) {

        return userDao.findByUsername(username);
    }


}

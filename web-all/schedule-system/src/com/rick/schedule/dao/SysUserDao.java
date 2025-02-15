package com.rick.schedule.dao;

/*
    Data Access Object 數據訪問對象
    該類中用於定義針對表格的CRUD方法
    DAO層一般需要定義接口跟實現類



 */


import com.rick.schedule.pojo.SysSchedule;
import com.rick.schedule.pojo.SysUser;

public interface SysUserDao {

    /**
     * 向數據庫增加一條用戶紀錄的方法
     * @param sysUser   要增加的紀錄的username和user_pwd字段以SysUser實體類對象的形式接收
     * @return  增加成功返回1 增加失敗返回0
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根據用戶名獲得完整用戶訊息的方法
     * @param username  要查詢的用戶名
     * @return  如果找到了就返回SysUser對象,找不到返回null
     */
    SysUser findByUsername(String username);
}

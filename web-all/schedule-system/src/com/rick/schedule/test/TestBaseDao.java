package com.rick.schedule.test;

import com.rick.schedule.dao.BaseDao;
import com.rick.schedule.pojo.SysUser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestBaseDao {


    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }


    @Test
    public void testBaseQueryObject() {
        // 查詢用戶數量 baseQueryObject  查詢結果集是單行 單列的 一個值的數據的方法

        String sql = "SELECT CAST(COUNT(1) AS BIGINT) FROM sys_user";
        Object result = baseDao.baseQueryObject(SysUser.class, sql);
        Long count = ((Number) result).longValue();
        System.out.println(count);

    }

    @Test
    public void testBaseQuery() {

        String sql = "SELECT uid,username,user_pwd userPwd FROM sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);

    }
    @Test
    public void testBaseUpdate() {
        String sql = "insert into sys_schedule  (uid, title, completed) values(?,?,?)";
        int rows = baseDao.baseUpdate(sql, 1, "學習JAVA", 0);
        System.out.println(rows);
    }
}

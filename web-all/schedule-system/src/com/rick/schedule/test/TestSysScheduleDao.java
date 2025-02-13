package com.rick.schedule.test;

import com.rick.schedule.dao.SysScheduleDao;
import com.rick.schedule.dao.impl.SysScheduleDaoImpl;
import com.rick.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestSysScheduleDao {
    private static SysScheduleDao scheduleDao;

    @BeforeClass
    public static void initScheduleDao() {
        scheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule() {
        int rows = scheduleDao.addSchedule(new SysSchedule(2, 1, "學習數據庫", 1));
        System.out.println(rows);
    }
    @Test
    public void testFindAll(){
        List<SysSchedule> scheduleList = scheduleDao.findAll();
        scheduleList.forEach(System.out::println);
    }

}

package com.rick.schedule.dao;

import com.rick.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * 介紹一下當前類......
 * 作者:......
 * 時間:......
 */

public interface SysScheduleDao {
    /**
     * 用於向數據庫增加一條日程紀錄
     * @param schedule 日程數據以SysSchedule實體類對象形式入參
     * @return 返回影響數據庫紀錄的行數，行數為0說明增加失敗，行數大於0說明增加成功
     */
    int addSchedule(SysSchedule schedule);

    /**
     * 查詢所有用戶的所有日程
     * @return 將所有日程放入一個:List<SysSchedule>集合中返回
     */
    List<SysSchedule> findAll();
}

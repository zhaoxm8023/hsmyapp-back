package com.hsmy.app.service;

import java.util.Date;
import java.util.List;

import com.hsmy.app.domain.Schedule;

public interface ScheduleService {

    /**
     * 查找指定会议室指定日期区间的排期，会自动对按周重复的排期进行计算.
     *
     * @param meetingRoomId 会议室 id
     * @param date          指定日期
     * @return 符合条件的排期列表
     */
    List<Schedule> find(Long meetingRoomId, Date date);
}

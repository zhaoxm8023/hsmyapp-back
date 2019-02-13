package com.hsmy.app.web;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.hsmy.app.domain.MeetingRoom;
import com.hsmy.app.domain.MeetingRoomRepository;
import com.hsmy.app.domain.Participant;
import com.hsmy.app.domain.Schedule;
import com.hsmy.app.domain.ScheduleRepository;
import com.hsmy.app.domain.User;
import com.hsmy.app.domain.UserRepository;
import com.hsmy.app.service.ScheduleService;
import com.hsmy.app.utils.DateUtils;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetingRoomController {

    @Autowired
    private MeetingRoomRepository meetingRoomRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/meetingRooms/{id}", method = RequestMethod.GET)
    public Result<List<MeetingRoom>> list(@PathVariable Long id) {
        return DefaultResult.newResult(meetingRoomRepository.findByTeamId(id));
    }

    /**
     * 创新排期，单 JVM 并发量可期的情况下，简单粗暴的使用 synchronized 来解决并发创建、更新排期的问题.
     *
     * @param id       会议室 id
     * @param schedule 新建的排期
     */
    @RequestMapping(path = "/meetingRooms/{id}/schedule", method = RequestMethod.POST)
    public synchronized Result<Schedule> createOrUpdateSchedule(@PathVariable(name = "id") Long id,
                                                                @RequestParam(name = "formId", required = false) String formId, @RequestBody Schedule schedule) {
        MeetingRoom meetingRoom = meetingRoomRepository.findOne(id);
        validate(id, schedule);
        if (null == schedule.getId()) {
            schedule.setMeetingRoom(meetingRoom);
            schedule.addParticipant(creatorAsParticipant(schedule, formId));
            scheduleRepository.save(schedule);
        } else {
            Schedule s = scheduleRepository.findOne(schedule.getId());
            Assert.notNull(s, "修改的排期不存在.");
            s.setTitle(schedule.getTitle());
            s.setStartTime(schedule.getStartTime());
            s.setEndTime(schedule.getEndTime());
            s.setDate(schedule.getDate());
            s.setRepeatMode(schedule.getRepeatMode());
            scheduleRepository.save(s);
        }
        return DefaultResult.newResult(schedule);
    }

    private Participant creatorAsParticipant(Schedule schedule, String formId) {
        Participant p = new Participant();
        p.setAvatarUrl(schedule.getCreatorAvatarUrl());
        p.setDate(schedule.getDate());
        p.setNickName(schedule.getCreatorNickName());
        p.setSchedule(schedule);
        p.setOpenId(schedule.getCreatorOpenId());
        p.setFormId(formId);
        return p;
    }

    /**
     * 取消已设置的排期.
     *
     * @param id 排期 id
     */
    @RequestMapping(path = "/meetingRooms/schedule/{id}", method = RequestMethod.DELETE)
    public Result<?> cancelSchedule(@PathVariable Long id) {
        Schedule schedule = scheduleRepository.findOne(id);
        scheduleRepository.delete(schedule);
        return DefaultResult.newResult();
    }

    /**
     * 查询指定会议室下指定日期区间的排期.
     *
     * @param id   会议室 id
     * @param date 指定日期
     * @return 指定的会议室指定日期的排期列表
     */
    @RequestMapping(path = "/meetingRooms/{id}/schedule", method = RequestMethod.GET)
    public Result<List<Schedule>> schedules(@PathVariable Long id,
                                            @RequestParam(name = "date") @DateTimeFormat(pattern = DateUtils.PATTERN_SIMPLE_DATE) Date date) {
        return DefaultResult.newResult(scheduleService.find(id, date).stream().map(s -> {
            User user = userRepository.findOneByOpenId(s.getCreatorOpenId());
            s.setCreatorNickName(s.getCreatorNickName() + "/" + user.getName());
            return s;
        }).collect(Collectors.toList()));
    }

    private void validate(Long id, Schedule schedule) {
        Assert.isTrue(schedule.getStartTime().compareTo(schedule.getEndTime()) < 0, "会议开始时间需小于结束时间.");
        Assert.isTrue(!scheduleService.find(id, schedule.getDate()).stream().anyMatch(s -> s.isConflict(schedule)),
                "同已有排期冲突.");
    }

    public void setMeetingRoomRepository(MeetingRoomRepository meetingRoomRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
    }

    public void setScheduleRepository(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}

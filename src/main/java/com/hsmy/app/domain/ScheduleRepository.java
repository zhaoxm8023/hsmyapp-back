package com.hsmy.app.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryCustom {

	List<Schedule> findByMeetingRoomAndDate(MeetingRoom meetingRoom, Date date);

	List<Schedule> findByMeetingRoomAndRepeatMode(MeetingRoom meetingRoom, String repeatMode);
}

package com.hsmy.app.web;

import java.util.Optional;

import com.hsmy.app.domain.MeetingRoomRepository;
import com.hsmy.app.domain.Participant;
import com.hsmy.app.domain.Schedule;
import com.hsmy.app.domain.ScheduleRepository;
import com.hsmy.app.domain.TeamRepository;
import com.hsmy.app.domain.User;
import com.hsmy.app.domain.UserRepository;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private MeetingRoomRepository meetingRoomRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path = "/schedules/{id}/join", method = RequestMethod.POST)
	public Result<Schedule> join(@PathVariable Long id, @RequestBody Participant participant) {
		Schedule schedule = scheduleRepository.findOne(id);
		// 根据 MeetingRoom 找到 Team 找到其下的 Users 判断是否当前用户已加入其中
		Optional<User> user = teamRepository
				.findOne(meetingRoomRepository.findOne(schedule.getMeetingRoom().getId()).getTeamId()).getUsers()
				.stream().filter(s -> s.getOpenId().equals(participant.getOpenId())).findAny();
		Assert.isTrue(user.isPresent(), "用户未绑定.");
		if (!schedule.getParticipants().stream().anyMatch((p) -> {
			return p.getOpenId().equals(participant.getOpenId());
		})) {
			schedule.addParticipant(participant);
			scheduleRepository.save(schedule);
			return DefaultResult.newResult(schedule);
		} else {
			throw new RuntimeException("您已加入过此会议啦.");
		}
	}

	@RequestMapping(path = "/schedules/{id}", method = RequestMethod.GET)
	public Result<Schedule> get(@PathVariable Long id) {
		Schedule schedule = scheduleRepository.findOne(id);
		User user = userRepository.findOneByOpenId(schedule.getCreatorOpenId());
		schedule.setCreatorNickName(schedule.getCreatorNickName()+"/"+user.getName());
		return DefaultResult.newResult(schedule);
	}

	public void setScheduleRepository(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	public void setMeetingRoomRepository(MeetingRoomRepository meetingRoomRepository) {
		this.meetingRoomRepository = meetingRoomRepository;
	}

	public void setTeamRepository(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
}

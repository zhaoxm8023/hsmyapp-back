//package com.hsmy.app.service.impl;
//
//import static org.junit.Assert.assertEquals;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.List;
//
//import com.hsmy.app.domain.MeetingRoom;
//import com.hsmy.app.domain.MeetingRoomFactory;
//import com.hsmy.app.domain.MeetingRoomRepository;
//import com.hsmy.app.domain.Schedule;
//import com.hsmy.app.domain.ScheduleFactory;
//import com.hsmy.app.domain.ScheduleRepository;
//import com.hsmy.app.domain.User;
//import com.hsmy.app.domain.UserFactory;
//import com.hsmy.app.domain.UserRepository;
//import com.hsmy.app.utils.DateUtils;
//import com.hsmy.app.web.MeetingRoomController;
//import com.hsmy.app.web.support.Result;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ScheduleServiceImplTest {
//
//	@Autowired
//	private MeetingRoomController meetingRoomController;
//
//	@Autowired
//	private MeetingRoomRepository meetingRoomRepository;
//
//	@Autowired
//	private ScheduleRepository scheduleRepository;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	private List<MeetingRoom> meetingRooms = MeetingRoomFactory.defaultMeetingRooms();
//
//	private User user = UserFactory.newDefaultUser();
//
//	@Before
//	public void before() {
//		user.setOpenId("七猫");
//		userRepository.save(user);
//		meetingRoomRepository.save(meetingRooms);
//	}
//
//	@After
//	public void after() {
//		meetingRoomRepository.delete(meetingRooms);
//		userRepository.delete(user);
//	}
//
//	@Test
//	public void testCalendar() throws ParseException {
//		Calendar cal = Calendar.getInstance();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		cal.setTime(dateFormat.parse("2017-08-01"));
//		assertEquals(Calendar.TUESDAY, cal.get(Calendar.DAY_OF_WEEK));
//	}
//
//	@Test
//	public void testFind() {
//		Schedule s1 = ScheduleFactory.newSchedule("分行业务平台项目组临时会议", "七猫", "2017-08-09", "09:00", "12:00");
//		Schedule s2 = ScheduleFactory.newWeeklySchedule("分行业务平台项目组临时会议", "七猫", "2017-08-02", "12:00", "14:00");
//		Schedule s3 = ScheduleFactory.newSchedule("分行业务平台项目组临时会议", "七猫", "2017-08-16", "14:00", "16:00");
//		try {
//			meetingRoomController.createOrUpdateSchedule(meetingRooms.get(0).getId(),"fakeFormId" ,s1);
//			meetingRoomController.createOrUpdateSchedule(meetingRooms.get(0).getId(),"fakeFormId",s2);
//			meetingRoomController.createOrUpdateSchedule(meetingRooms.get(0).getId(),"fakeFormId",s3);
//			Result<List<Schedule>> result = meetingRoomController.schedules(meetingRooms.get(0).getId(),
//					DateUtils.parse("2017-08-09", DateUtils.PATTERN_SIMPLE_DATE));
//			assertEquals(2, result.getPayload().size());
//		} finally {
//			scheduleRepository.delete(s1);
//			scheduleRepository.delete(s2);
//			scheduleRepository.delete(s3);
//		}
//	}
//}

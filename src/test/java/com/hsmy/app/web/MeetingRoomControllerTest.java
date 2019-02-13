//package com.hsmy.app.web;
//
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
//import com.hsmy.app.web.support.Result;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MeetingRoomControllerTest {
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
//	private User user1 = UserFactory.newDefaultUser();
//	private User user2 = UserFactory.newDefaultUser();
//
//	private List<MeetingRoom> meetingRooms = MeetingRoomFactory.defaultMeetingRooms();
//
//	@Before
//	public void before() {
//		user1.setOpenId("七猫");
//		user2.setOpenId("发哥");
//		userRepository.save(user1);
//		userRepository.save(user2);
//		meetingRoomRepository.save(meetingRooms);
//	}
//
//	@After
//	public void after() {
//		meetingRoomRepository.delete(meetingRooms);
//		userRepository.delete(user1);
//		userRepository.delete(user2);
//
//	}
//
//	@Test
//	public void list() throws Exception {
//		Result<List<MeetingRoom>> result = meetingRoomController.list(MeetingRoomFactory.DEFAULT_TEAM_ID);
//		Assert.assertTrue(result.isSuccess());
//		org.junit.Assert.assertEquals(4, result.getPayload().size());
//	}
//
//	@Test
//	public void newSchedule() {
//		Result<List<MeetingRoom>> result = meetingRoomController.list(MeetingRoomFactory.DEFAULT_TEAM_ID);
//
//		// 创建一个每周重复的排期
//		Schedule schedule1 = ScheduleFactory.newWeeklySchedule("分行业务平台项目组临时会议", "七猫", "2017-08-02", "09:00", "12:00");
//		try {
//			meetingRoomController.createOrUpdateSchedule(result.getPayload().get(0).getId(), "fakeFormId", schedule1);
//			Assert.assertNotNull(schedule1.getId());
//			// 案例验证更新排期
//			schedule1.setTitle("分行业务平台项目组临时会议-修订后");
//			meetingRoomController.createOrUpdateSchedule(result.getPayload().get(0).getId(), "fakeFormId", schedule1);
//			Schedule dbSchedule = scheduleRepository.findOne(schedule1.getId());
//			Assert.assertEquals(schedule1.getTitle(), dbSchedule.getTitle());
//			// 创建人默人参加会议
//			Assert.assertEquals(1, dbSchedule.getParticipants().size());
//			Assert.assertEquals(schedule1.getCreatorAvatarUrl(), dbSchedule.getParticipants().get(0).getAvatarUrl());
//
//			// 当天时间有冲突的案例
//			Schedule schedule2 = ScheduleFactory.newSchedule("POS清算代码评审", "发哥", "2017-08-02", "10:00", "11:00");
//			try {
//				meetingRoomController.createOrUpdateSchedule(result.getPayload().get(0).getId(), "fakeFormId",
//						schedule2);
//				Assert.fail();
//			} catch (Exception e) {
//				Assert.assertEquals("同已有排期冲突.", e.getMessage());
//			}
//
//			// 下周时间有冲突的案例
//			Schedule schedule3 = ScheduleFactory.newSchedule("POS清算代码评审", "发哥", "2017-08-09", "09:30", "15:00");
//			try {
//				meetingRoomController.createOrUpdateSchedule(result.getPayload().get(0).getId(), "fakeFormId",
//						schedule3);
//				Assert.fail();
//			} catch (Exception e) {
//				Assert.assertEquals("同已有排期冲突.", e.getMessage());
//			}
//		} finally {
//			scheduleRepository.delete(schedule1);
//		}
//
//	}
//
//	@Test
//	public void cancelSchedule() {
//		Result<List<MeetingRoom>> result = meetingRoomController.list(MeetingRoomFactory.DEFAULT_TEAM_ID);
//		// 创建一个每周重复的排期
//		Schedule s = ScheduleFactory.newWeeklySchedule("分行业务平台项目组临时会议", "七猫", "2017-08-02", "13:00", "14:00");
//		meetingRoomController.createOrUpdateSchedule(result.getPayload().get(0).getId(), "fakeFormId", s);
//		Assert.assertNotNull(scheduleRepository.findOne(s.getId()));
//		meetingRoomController.cancelSchedule(s.getId());
//		Assert.assertNull(scheduleRepository.findOne(s.getId()));
//	}
//
//	@Test
//	public void schedules() {
//		Result<List<MeetingRoom>> result = meetingRoomController.list(MeetingRoomFactory.DEFAULT_TEAM_ID);
//		// 创建一个每周重复的排期
//		Schedule schedule1 = ScheduleFactory.newWeeklySchedule("分行业务平台项目组临时会议", "七猫", "2017-08-02", "13:00", "14:00");
//		meetingRoomController.createOrUpdateSchedule(result.getPayload().get(0).getId(), "fakeFormId", schedule1);
//		Schedule schedule2 = ScheduleFactory.newWeeklySchedule("CPOS临时例会", "发哥", "2017-08-09", "14:00", "16:00");
//		meetingRoomController.createOrUpdateSchedule(result.getPayload().get(0).getId(), "fakeFormId", schedule2);
//		try {
//			Result<List<Schedule>> schedulesResult = meetingRoomController.schedules(result.getPayload().get(0).getId(),
//					DateUtils.parse("2017-08-09", DateUtils.PATTERN_SIMPLE_DATE));
//			Assert.assertEquals(2, schedulesResult.getPayload().size());
//		} finally {
//			scheduleRepository.delete(schedule1);
//			scheduleRepository.delete(schedule2);
//		}
//	}
//}

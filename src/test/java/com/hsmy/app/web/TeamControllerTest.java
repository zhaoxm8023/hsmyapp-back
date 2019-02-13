//package com.hsmy.app.web;
//
//import java.util.List;
//
//import com.hsmy.app.domain.Team;
//import com.hsmy.app.domain.TeamFactory;
//import com.hsmy.app.domain.TeamRepository;
//import com.hsmy.app.domain.User;
//import com.hsmy.app.domain.UserFactory;
//import com.hsmy.app.domain.UserRepository;
//import com.hsmy.app.service.WebTokenService;
//import com.hsmy.app.web.support.Result;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TeamControllerTest {
//
//	@Autowired
//	private TeamRepository teamRepository;
//
//	@Autowired
//	private TeamController teamController;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private WebTokenService webTokenService;
//
//	@Test
//	public void testJoin() {
//		Team team = teamRepository.save(TeamFactory.newDefaultTeam());
//		User user = UserFactory.newDefaultUser();
//		userRepository.save(user);
//		team = teamRepository.findOne(team.getId());
//		Result<User> result = teamController.join(team.getId(), user, team.getToken());
//		String token = (String) result.getHeader("token");
//		Assert.assertEquals(webTokenService.generate(user.getOpenId()), token);
//		team = teamRepository.findOne(team.getId());
//		Assert.assertEquals(1, team.getUsers().size());
//		team.getUsers().clear();
//		teamRepository.save(team);
//		team = teamRepository.findOne(team.getId());
//		Assert.assertEquals(0, team.getUsers().size());
//		userRepository.delete(user);
//		teamRepository.delete(team);
//	}
//
//	@Test
//	public void testList() {
//		Team team = teamRepository.save(TeamFactory.newDefaultTeam());
//		Result<List<Team>> result = teamController.findAll();
//		Assert.assertEquals(1, result.getPayload().size());
//		teamRepository.delete(team);
//	}
//
//	@Test
//	public void testGetUser() {
//		Team team = teamRepository.save(TeamFactory.newDefaultTeam());
//		User user = UserFactory.newDefaultUser();
//		userRepository.save(user);
//		Result<User> result = teamController.getUser(team.getId(), user.getOpenId());
//		Assert.assertFalse(result.isSuccess());
//		Assert.assertEquals("用户未绑定.", result.getResponseMessage());
//		teamController.join(team.getId(), user, team.getToken());
//		result = teamController.getUser(team.getId(), user.getOpenId());
//		Assert.assertTrue(result.isSuccess());
//		String token = (String) result.getHeader("token");
//		Assert.assertEquals(webTokenService.generate(user.getOpenId()), token);
//		userRepository.delete(user);
//		teamRepository.delete(team);
//	}
//}

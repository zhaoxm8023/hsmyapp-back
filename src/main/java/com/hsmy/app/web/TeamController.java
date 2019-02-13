package com.hsmy.app.web;

import java.util.List;
import java.util.Optional;

import com.hsmy.app.domain.Team;
import com.hsmy.app.domain.TeamRepository;
import com.hsmy.app.domain.User;
import com.hsmy.app.domain.UserRepository;
import com.hsmy.app.service.WebTokenService;
import com.hsmy.app.web.support.DefaultResult;
import com.hsmy.app.web.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebTokenService webTokenService;

    // 加入团队
    @RequestMapping(path = "/team/{id}/join", method = RequestMethod.POST)
    public Result<User> join(@PathVariable Long id, @RequestBody User user,
                             @RequestParam(name = "token") String token) {
        Team team = teamRepository.findOne(id);
        Assert.notNull(team, "团队不存在.");
        Assert.isTrue(team.getToken().equals(token), "口令校验失败.");
        if (user.getId() == null) {
            userRepository.save(user);
        }
        if (team.getUsers().stream().noneMatch(u -> user.getId().equals(u.getId()))) {
            team.addUser(user);
            teamRepository.save(team);
            return DefaultResult.newResult(user).setHeader("token", webTokenService.generate(user.getOpenId()));
        } else {
            throw new RuntimeException("不可重复加入团队.");
        }

    }

    // 查询所有的团队
    @RequestMapping(path = "/teams", method = RequestMethod.GET)
    public Result<List<Team>> findAll() {
        return DefaultResult.newResult(teamRepository.findAll());
    }

    // 根据团队 id 及 微信 openId 查询绑定的用户
    @RequestMapping(path = "/team/{teamId}/user/{openId}", method = RequestMethod.GET)
    public Result<User> getUser(@PathVariable(name = "teamId") Long teamId,
                                @PathVariable(name = "openId") String openId) {
        Team team = teamRepository.findOne(teamId);
        Optional<User> optional = team.getUsers().stream().filter(s -> s.getOpenId().equals(openId)).findAny();
        if (optional.isPresent()) {
            String token = webTokenService.generate(optional.get().getOpenId());
            return DefaultResult.newResult(optional.get()).setHeader("token", token);
        } else {
            return DefaultResult.newFailResult("用户未绑定.");
        }
    }

    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setWebTokenService(WebTokenService webTokenService) {
        this.webTokenService = webTokenService;
    }
}

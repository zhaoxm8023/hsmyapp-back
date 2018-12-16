package com.hsmy.app.scheduling;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.hsmy.app.domain.Schedule;
import com.hsmy.app.domain.ScheduleRepository;
import com.hsmy.app.domain.User;
import com.hsmy.app.domain.UserRepository;
import com.hsmy.app.utils.DateUtils;
import com.hsmy.app.utils.JsonUtils;
import com.hsmy.app.vo.NotifyMessageTemplate;
import com.hsmy.app.vo.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 发送会议通知，每60秒轮训一次，在会前 15 分钟发送提醒，目前的实现比较简单仅在内存中增加了缓存来存放已发送的排期.
 * 
 * 提示：目前版本只考虑了单 JVM 环境运行，作业调度未考虑并发的问题，如果运行在集群环境下，需要修改此类.
 * 
 * @author devzzm
 */
@Component
public class SendNotifyMessageJob {

	private static final Log logger = LogFactory.getLog(SendNotifyMessageJob.class);

	@Value("${wechat.app-id}")
	private String appId;

	@Value("${wechat.app-secret}")
	private String appSecret;

	@Value("${wechat.notify.template-id}")
	private String templateId;

	@Value("${wecaht.acquire-access-token-url}")
	private String acquireAccessTokenUrl;

	@Value("${wecaht.send-messag-url}")
	private String sendMessageUrl;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private UserRepository userRepository;

	private RestTemplate restTemplate = new RestTemplate();

	private Set<Long> cache = new HashSet<>();

	private Date date = DateUtils.parse(DateUtils.format(new Date(), DateUtils.PATTERN_SIMPLE_DATE),
			DateUtils.PATTERN_SIMPLE_DATE);

	@Scheduled(fixedDelay = 60 * 1000)
	public void execute() {
		Date date = DateUtils.parse(DateUtils.format(new Date(), DateUtils.PATTERN_SIMPLE_DATE),
				DateUtils.PATTERN_SIMPLE_DATE);
		if (date.compareTo(this.date) > 0) {
			this.date = date;
			cache.clear();
		}

		String accessToken = getAccessToken();
//		scheduleRepository.findByDate(date).forEach(s -> {
//			if (cache.contains(new Long(s.getScheduleId().intValue()))) {
//				return;
//			}
//			if (isNeedSendMessageNow(s)) {
//				doSend(accessToken, s);
//				cache.add(new Long(s.getScheduleId().intValue()));
//			}
//		});
	}

	private void doSend(String accessToken, ScheduleVO s) {
		Schedule schedule = scheduleRepository.findOne(new Long(s.getScheduleId().intValue()));
		User creator = userRepository.findOneByOpenId(s.getOpenId());
		schedule.getParticipants().stream().forEach(p -> {
			NotifyMessageTemplate template = new NotifyMessageTemplate(creator, schedule, p, templateId);
			String result = restTemplate.postForObject(sendMessageUrl, template.toTemplateMessage(), String.class,
					accessToken);
			logger.info("send notify message result is :" + result);
		});
	}

	/* 会议开始前15分钟开始发送通知. */
	private boolean isNeedSendMessageNow(ScheduleVO scheduleVO) {
		long now = System.currentTimeMillis();
		return (now + 15 * 60 * 1000) > DateUtils.parse(
				DateUtils.format(scheduleVO.getDate(), DateUtils.PATTERN_SIMPLE_DATE) + " " + scheduleVO.getStartTime(),
				DateUtils.PATTERN_SIMPLE_DATE + " HH:mm").getTime();
	}

	private String getAccessToken() {
		String result = restTemplate.getForObject(acquireAccessTokenUrl, String.class, appId, appSecret);
		return (String) JsonUtils.decode(result).get("access_token");

	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public void setScheduleRepository(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}

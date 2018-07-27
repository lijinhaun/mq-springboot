package com.lijinhuan.mq.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lijinhuan.mq.annotation.ReturnValue;
import com.lijinhuan.mq.common.ErrorConstants;
import com.lijinhuan.mq.dto.User;
import com.lijinhuan.mq.exception.MqException;
import com.lijinhuan.mq.service.TestService;

@RestController
public class TestControler {
	
	@Autowired
	TestService testService;
	@Autowired
	RabbitTemplate rabbitTemplate;

	@GetMapping("/test")
	@ReturnValue
	public Map<String, Object> test() throws MqException {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = testService.test();
		rabbitTemplate.send("testQueue",new Message(user.toString().getBytes(), new MessageProperties()));
		return map;
	}
	
	@RabbitListener(queues= {"testQueue"})
	public void processMessage(String message) {
		System.out.println(message);
	}
}

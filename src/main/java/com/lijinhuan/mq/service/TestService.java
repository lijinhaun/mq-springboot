package com.lijinhuan.mq.service;

import org.springframework.stereotype.Service;

import com.lijinhuan.mq.common.ErrorConstants;
import com.lijinhuan.mq.dto.User;
import com.lijinhuan.mq.exception.MqException;

@Service
public class TestService {
	
	public User test() throws MqException {
		User user = new User();
		user.setPassword("213");
		user.setUsername("test");
		if(user.getUsername().equals("test")) {
			throw new MqException(ErrorConstants.E000002);
		}
		return user;
	}

}

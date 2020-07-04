package com.shamus.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamus.app.ws.UserService;
import com.shamus.app.ws.shared.Utils;
import com.shamus.app.ws.ui.model.request.UserDetailsRequestModel;
import com.shamus.app.ws.ui.model.response.UserRest;

@Service
public class UserServiceImpl implements UserService {
	
	Map<String, UserRest> users;
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest retVal = new UserRest();
		retVal.setEmail(userDetails.getEmail());
		retVal.setFirstName(userDetails.getFirstName());
		retVal.setLastName(userDetails.getLastName());

		String userId = utils.generateUserId();
		retVal.setUserId(userId);

		if (users == null)
			users = new HashMap<>();
		users.put(userId, retVal);

		return retVal;
	}

}

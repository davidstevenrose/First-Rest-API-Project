package com.shamus.app.ws;

import com.shamus.app.ws.ui.model.request.UserDetailsRequestModel;
import com.shamus.app.ws.ui.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel userDetails);

}

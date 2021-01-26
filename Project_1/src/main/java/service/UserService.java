package service;

import org.apache.log4j.Logger;

import Connections.UserDataHandler;
import models.User;

public class UserService {
	
	private static UserDataHandler handler = new UserDataHandler();
	private final static Logger logger = Logger.getLogger(UserService.class);
	
	public User getUser(String username, String password) {
		User user = handler.getUser(username, password);
		if(user != null) {
			logger.info(user.getName() + " is logged in.");
			return user;
		}
		else {
			logger.info("Login failed");
			return null;
		}
	}
}

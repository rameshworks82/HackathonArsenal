package org.rkworks.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.rkworks.demo.model.LoginModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	static Logger logger = Logger.getLogger(LoginController.class.getName());
	private static final String template = "Hello, %s!";
	private static final String templateUserAdd = "New User Created , UserName: %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/login")
	public LoginModel login(@RequestParam(value = "username", defaultValue = "UserName") String userName,
			@RequestParam(value = "password", defaultValue = "********") String password) {
		logger.info("User Try to Login into System "+userName);
		logger.info("User " + userName + " Log-in Successfully");		
		String message = String.format(template, userName);
		return new LoginModel(userName, password, message);
		// http://localhost:7070/login?username=Rameshkumar&password=GoodPassword
	}
	
	@RequestMapping(value = "/adduser")
	public LoginModel addUser(@RequestParam(value = "username", defaultValue = "UserName") String userName,
			@RequestParam(value = "password", defaultValue = "********") String password) {
		String message = String.format(templateUserAdd, userName);
		logger.info(message);			
		return new LoginModel(userName, password, message);
		// http://localhost:7070/adduser?username=Rameshkumar&password=GoodPassword
	}

}

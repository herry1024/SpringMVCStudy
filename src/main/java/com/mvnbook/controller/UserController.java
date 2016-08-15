package com.mvnbook.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvnbook.model.User;
import com.mvnbook.service.UserService;

@Controller
@RequestMapping("/test/")
@ResponseBody
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	@Qualifier(value="userServiceImpl")
	private UserService userService;

	@RequestMapping("/getUserById")
	public User getUserById(int id) {
		logger.info("根据用户ID查找用户");
		return userService.getUserById(id);
	}
	
	@RequestMapping("/getAllUsers")
	public List<User> getAllUsers() {
		logger.info("查询所有用户");
		return userService.getAllUsers();
	}
}

package com.mvnbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvnbook.model.User;
import com.mvnbook.service.UserService;

@Controller
@RequestMapping("/manage/login")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	@Qualifier(value = "userServiceImpl")
	private UserService userService;

	@RequestMapping("/getUserById")
	@ResponseBody
	public User getUserById(@RequestParam("id") int id) {
		logger.info("根据用户ID查找用户 " + id);
		return userService.getUserById(id);
	}

	@RequestMapping("/getAllUsers")
	@ResponseBody
	public List<User> getAllUsers() {
		logger.info("查询所有用户");
		return userService.getAllUsers();
	}

	@RequestMapping("/checkLogin")
	@ResponseBody
	public ModelAndView login(@RequestParam("name") String name, @RequestParam("password") String password) {
		logger.info("登录");
		User user = userService.getUserByPassword(name, password);
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			mav.addObject(user);
			mav.setViewName("/manage/report/NewFile");
			return mav;
		} else {
			mav.addObject("message", "请输入正确的用户名密码");
			mav.setViewName("error");
			return mav;
		}
	}
	
	@RequestMapping(value="/checkLogin1")
	@ResponseBody
	public ModelAndView login1(@RequestParam("name") String name, @RequestParam("password") String password) {
		logger.info("checkLogin1");
		ModelAndView mav = new ModelAndView();
		User user = userService.getUserByPassword(name, password);
		if (user != null) {
			mav.addObject(user);
			mav.setViewName("/manage/report/NewFile");
			return mav;
		} else {
			mav.addObject("message", "请输入正确的用户名密码");
			mav.setViewName("error");
			return mav;
		}
	}
	
	@RequestMapping("/addUser.do")
	@ResponseBody
	public ModelAndView  AddUser(ModelMap model) {
		User user = new User(); //用于转换到form表单的对象
		return new ModelAndView("NewFile").addObject(user); //跳转到NewFile页面
	}
	
	@RequestMapping("/getUser.do")
	@ResponseBody
	public ModelAndView  getUser(@ModelAttribute("user") User user) {
		return new ModelAndView("NewFile").addObject(user); //跳转到NewFile页面
	}
}

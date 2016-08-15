package com.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.mvnbook.dao.UserMapper;
import com.mvnbook.service.UserService;


public class Test1 {
	private static Logger logger = Logger.getLogger(Test1.class);
	private  ApplicationContext context;
	
	@Test
	public  void testspringmybatis()
    {
		context = new ClassPathXmlApplicationContext("classpath*:config/SpringMVCStudy-context.xml");
		UserMapper userMapper = (UserMapper)context.getBean("userDaoImpl");
		logger.info(userMapper.getUserById(1).getName());
		System.out.println(context.getClass());

    }
	@Test
	public  void testspringmybatis1()
    {
		context = new ClassPathXmlApplicationContext("classpath*:config/SpringMVCStudy-context.xml");
		UserService userService = (UserService)context.getBean("userService");
		logger.info(userService.getUserById(1).getName());
    }
}
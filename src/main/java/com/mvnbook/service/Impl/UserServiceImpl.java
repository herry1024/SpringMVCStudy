package com.mvnbook.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mvnbook.dao.UserMapper;
import com.mvnbook.model.User;
import com.mvnbook.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	@Qualifier(value="userDaoImpl")
	private UserMapper userMapper;

	@Override
	public User getUserById(Integer id) {
		logger.info("进入到UserServiceImpl");
		return userMapper.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("进入到UserServiceImpl");
		return userMapper.getAllUsers();
	}

	@Override
	public User getUserByPassword(String name, String password) {
		return  userMapper.getUserByPassword(name, password);
	}

}

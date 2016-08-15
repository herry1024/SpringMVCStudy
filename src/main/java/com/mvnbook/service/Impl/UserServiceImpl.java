package com.mvnbook.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mvnbook.dao.UserMapper;
import com.mvnbook.model.User;
import com.mvnbook.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier(value="userDaoImpl")
	private UserMapper userMapper;

	@Override
	public User getUserById(int id) {
		System.err.println("进入到UserServiceImpl");
		return userMapper.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userMapper.getAllUsers();
	}

}

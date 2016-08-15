package com.mvnbook.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mvnbook.dao.UserMapper;
import com.mvnbook.model.User;
@Repository("userDaoImpl")//定义生成的bean的名称
public class UserDaoImpl implements UserMapper{
	
	@Autowired
	@Qualifier(value="userMapper")//定义需要使用的bean的名称
	private UserMapper userMapper;
	@Override
	public User getUserById(int id) {
		System.err.println("进入到UserDaoImpl");
		return userMapper.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

}

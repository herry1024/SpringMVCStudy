package com.mvnbook.dao.Impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mvnbook.dao.UserMapper;
import com.mvnbook.model.User;

@Repository("userDaoImpl") // 定义生成的bean的名称
public class UserDaoImpl implements UserMapper {
	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	@Qualifier(value = "userMapper") // 定义需要使用的bean的名称
	private UserMapper userMapper;

	@Override
	public User getUserById(Integer id) {
		logger.info("查询getUserById");
		User u=userMapper.getUserById(id);
//		if(u!=null){
//			return u;
//		}else{
//			return null;
//		}
		return userMapper.getUserById(id);
		
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("查询getAllUsers");
		return userMapper.getAllUsers();
	}

	@Override
	public User getUserByPassword(String name, String password) {
		logger.info("UserDaoImpl login");
		return userMapper.getUserByPassword(name, password);
	}

	@Override
	public void UpdateUserById(@Param("id") Integer id) {
		
		
	}
	
	

}

package com.mvnbook.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mvnbook.model.User;

@Service("userService")
public interface UserService {

		User getUserById(Integer id);
		List<User> getAllUsers();
		User getUserByPassword(String name,String password);
}

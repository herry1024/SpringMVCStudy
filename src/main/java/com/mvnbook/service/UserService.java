package com.mvnbook.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mvnbook.model.User;

@Service("userService")
public interface UserService {

		User getUserById(int id);
		List<User> getAllUsers();
}

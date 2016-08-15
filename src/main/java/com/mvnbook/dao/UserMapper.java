package com.mvnbook.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mvnbook.model.User;
@Service("userMapper")
public interface UserMapper {
	User getUserById(int id);
	List<User> getAllUsers();
}

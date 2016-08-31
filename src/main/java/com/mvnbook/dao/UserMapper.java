package com.mvnbook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mvnbook.model.User;
@Service("userMapper")
public interface UserMapper {
	User getUserById(@Param("id") Integer id);
	List<User> getAllUsers();
	User getUserByPassword(@Param("name") String name,@Param("password") String password);
	
	void UpdateUserById(@Param("id") Integer id);
}

package com.example.dao;

import com.example.pojo.Users;

public interface UsersMapper {
	
	void insertUser(Users users);

	int deleteUserById(Integer id);
}

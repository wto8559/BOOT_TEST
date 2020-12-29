package com.example.service;


import com.example.pojo.Users;

public interface UsersService {
	
	void addUser(Users users);

	int delUser(int id);
}

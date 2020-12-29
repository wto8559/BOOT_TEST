package com.example.service.impl;

import com.example.dao.UsersMapper;
import com.example.pojo.Users;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void addUser(Users users) {
		usersMapper.insertUser(users);
	}

	public int delUser(int id){
		return usersMapper.deleteUserById(id);
	}


}

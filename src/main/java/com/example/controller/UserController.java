package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.pojo.Users;
import com.example.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * SpringBoot整合jsp
 *
 *
 */
@Controller
public class UserController {

	@Resource
	private UsersService usersService;

	/**
	 * 添加用户并回显
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUser")
	public String showUser(Model model){
		List<Users> list = new ArrayList<>();
		Users user=new Users("张三",1,20);
		usersService.addUser(user);
		System.out.println("--------insertUser--------"+user.getId());
		list.add(user);
		//需要一个Model对象
		model.addAttribute("list", list);

		//跳转视图
		return "testJSPpage";
	}


	/**
	 * 添加用户并回显
	 * @param id
	 * @return
	 */
	@RequestMapping("/delUser")
	@ResponseBody
	public int delUser(int id){
		return usersService.delUser(id);
	}

}

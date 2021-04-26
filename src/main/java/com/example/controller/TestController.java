package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SpringBoot HelloWorld
 * @author Administrator
 *
 */
@Controller
public class TestController {

	@RequestMapping("/hello")
	@ResponseBody
	public Map<String, Object> showHelloWorld(){
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "HelloWorld");
		return map;
	}


	@PostMapping("/testMockMvc")
	public  Object deleteByMessageId(@RequestBody(required = false)Users user) {
		System.out.println("--------------"+user.getName());
		Object obj=new Object();
		return obj;
	}

}

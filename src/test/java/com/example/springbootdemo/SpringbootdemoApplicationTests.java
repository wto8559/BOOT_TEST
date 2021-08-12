package com.example.springbootdemo;


import com.alibaba.fastjson.JSON;
import com.example.pojo.Users;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@WebAppConfiguration
public class SpringbootdemoApplicationTests {



	@Autowired
	private MockMvc mvc;
	private MockHttpSession session;

	@Test
	public void test1() throws Exception {
		System.out.println("------------------------");
	}


	@Test
	public void contextLoads() throws Exception {


		Users user=new Users("abc",123,456);



		MvcResult mvcResult= mvc.perform(
				        post("/testMockMvc").
						contentType(MediaType.APPLICATION_JSON).
						content(JSON.toJSONString(user))
		).andReturn();


		System.out.println(mvcResult.getResponse().getContentAsString());

	}

}

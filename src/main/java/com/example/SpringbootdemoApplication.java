package com.example;

import com.example.filter.SecondFilter;
import com.example.listener.SecondListener;
import com.example.servlet.SecondServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 注意，启动器只加载其所在同级别包下的内容，对其上级包中内容不扫描
 *
 *
 *
 */

@SpringBootApplication
//开启spring对Aspectj的支持
@EnableAspectJAutoProxy
@ServletComponentScan  //在springBoot启动时会扫描@WebServlet，并将该类实例化
@MapperScan("com.example.dao") //@MapperScan 用户扫描MyBatis的Mapper接口
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}


	/**
	 * 注册servlet
	 * @return
	 *//*
	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/hello");
		return bean;
	}


	*//**
	 * 注册Filter
	 *//*
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		//bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
		bean.addUrlPatterns("/hello");
		return bean;
	}


	*//**
	 * 注册listener
	 *//*
	@Bean
	public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
		ServletListenerRegistrationBean<SecondListener> bean= new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
		return bean;
	}*/

}

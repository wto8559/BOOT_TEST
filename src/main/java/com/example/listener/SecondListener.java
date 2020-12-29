package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * springBoot整合Listener方式二。
 * 启动类中注册该listerer
 *
 */
public class SecondListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("SecondListener..init.....");
	}

}

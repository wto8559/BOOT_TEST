package com.example.listener;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class TestSpringApplicationRunListener implements SpringApplicationRunListener {

    @Override
    public void starting() {
        System.out.println("-------------starting-----------");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o=environment.getPropertySources().get("os.name");
        System.out.println("------------environmentPrepared------------"+o);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("-----------contextPrepared-------------");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("-----------contextLoaded-------------");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("------------started------------");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("-------------running-----------");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("-----------failed-------------");
    }
}

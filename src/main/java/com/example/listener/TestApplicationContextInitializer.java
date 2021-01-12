package com.example.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import sun.security.krb5.Config;

public class TestApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("---------TestApplicationContextInitializer ... initialize----------"+applicationContext);
    }
}

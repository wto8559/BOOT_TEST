package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常测试
 */


@Controller
public class exceptionController {
    @RequestMapping("/show")
    public String showInfo(){
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(){
        int a = 10/0;
        return "index";
    }

    @RequestMapping("/showUsers")
    public String showUser(){
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/showUsers2")
    public String showUser2(){
        int a = 100/0;
        return "index";
    }


}

package com.example.pojo;

public class Father {
    String name;
    String age;

    public void say(String word){
        System.out.println(name+"---say---"+word);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

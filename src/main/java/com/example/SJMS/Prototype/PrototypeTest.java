package com.example.SJMS.Prototype;

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype obj1 = new Prototype();
        Prototype obj2 = (Prototype) obj1.clone();
        System.out.println("obj1==obj2?" + (obj1 == obj2));
    }

}

package com.lh.reflect;

/**
 * @Description:
 * @author LuoH
 * @date 2019/11/13
 */
public class Fruit {
    public Fruit() {
        System.out.println("无参构造器 Run...");
    }

    public Fruit(String type) {
        System.out.println("有参构造器 Run..." + type);
    }
}

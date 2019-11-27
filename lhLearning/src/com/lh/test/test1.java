package com.lh.test;

import java.util.*;

/**
 * @Description: 为什么药品重写hashCode equals方法
 * @author LuoH
 * @date 2019/11/6
 */
public class test1 {
    public static void main(String[] args) {
        Map computer = new HashMap();
        Computer c1 = new Computer("华硕", 3200.0);
        Computer c2 = new Computer("联想", 3100.0);
        Computer c3 = new Computer("Mac", 6700.0);
        Computer c4 = new Computer("方正", 3200.0);
        Computer c5 = new Computer("惠普", 4200.0);
        Computer c6 = new Computer("惠普", 4200.0);
        computer.put(c1, 15);
        computer.put(c2, 14);
        computer.put(c3, 17);
        computer.put(c4, 19);
        computer.put(c6, 12);
        computer.put(c5, 12);

        //key值重复自动覆盖
        System.out.println(computer.size());
        computer.containsKey("联想");
        computer.containsValue(12);
        computer.remove("方正");
        computer.get("Mac");
        Collection numbers = computer.values();
        Iterator numberIt = numbers.iterator();
        while (numberIt.hasNext()) {
            Integer number = (Integer) numberIt.next();
            System.out.println(number);
        }
        //Set和Iterator必须指明存储类型否则编译报错
        Set computers = computer.keySet();
        Iterator computersIt = computers.iterator();
        while (computersIt.hasNext()) {
            //类型不统一的话则需要,使用Object，instanceof分情况
            Computer c = (Computer) computersIt.next();
            System.out.println(c.name + "," + c.price + "元," + computer.get(c) + "台");
        }
    }
}

class Computer {
    String name;
    double price;
    Computer(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return "name = " + name + " ,price = " + price;
    }
    //HashMap中必须重写hashCode和equals方法否则会出现重复元素
    //首先比较hashCode若不等,直接存入
    //若想等,再比较equals,若不等,则放弃
    public int hashCode() {
        return name.hashCode() * (price + "").hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Computer) {
            Computer c = (Computer) o;
            if (c.name.equals(name) && c.price == price) {
                return true;
            }
        }
        return false;
    }
}
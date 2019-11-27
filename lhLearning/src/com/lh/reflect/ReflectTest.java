package com.lh.reflect;

import java.lang.reflect.Constructor;

/**
 * @Description:
 * @author LuoH
 * @date 2019/11/13
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class clazz = null;
        clazz = Class.forName("com.lh.reflect.Fruit");
        Constructor<Fruit> constructor1 = clazz.getConstructor();
        Constructor<Fruit> constructor2 = clazz.getConstructor(String.class);

        Fruit fruit1 = constructor1.newInstance();
        Fruit fruit2 = constructor2.newInstance("Apple");
    }
}

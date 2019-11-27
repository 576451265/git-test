package com.lh.reflect;

/**
 * @Description: 获取反射机制的三种方式
 * @author LuoH
 * @date 2019/11/13
 */
public class ReflectGet {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一：通过建立对象
        Student stu = new Student();
        Class classobj1 = stu.getClass();
        System.out.println(classobj1.getName());
        //方式二：通过所在路径，相对路径
        Class classobj2 = Class.forName("com.lh.reflect.Student");
        System.out.println(classobj2.getName());
        //方式三：通过类名
        Class classobj3 = Student.class;
        System.out.println(classobj3.getName());
    }
}

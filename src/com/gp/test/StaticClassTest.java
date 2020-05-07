package com.gp.test;

/**
 * @author gp
 * @create 2020/2/28 9:31
 */
public class StaticClassTest {
    static {
        System.out.println("正在初始化StaticClassTest类!");
    }
    public static void test(){
        System.out.println("test()方法!");
    }
}

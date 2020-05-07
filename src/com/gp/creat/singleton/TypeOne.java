package com.gp.creat.singleton;

/**
 * @author gp
 * @create 2020/2/20 16:14
 */

/**
 * 单例模式的第一种写法:
 * 饿汉式(静态变量)
 * 可用,但可能造成内存浪费
 */
public class TypeOne {
    public static void main(String[] args) {
        One instance = One.getInstance();
        One instance1 = One.getInstance();
        System.out.println(instance == instance1);//true
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }
}

class One {
    //私有的构造方法,防止外部new一个对象
    private One() {

    }

    private final static One singleton = new One();

    //提供一个public的方法,返回该对象
    public static One getInstance(){
        return singleton;
    }
}
package com.gp.creat.singleton;

/**
 * @author gp
 * @create 2020/2/20 16:31
 */

/**
 * 单例模式的第二种写法:
 * 饿汉式(静态代码块)
 * 可用,但有可能会造成内存浪费
 */
public class TypeTwo {
}
class Two{
    private Two(){

    }

    private static Two singleton;

    static {
        singleton = new Two();
    }
    public static Two getInstance(){
        return singleton;
    }
}

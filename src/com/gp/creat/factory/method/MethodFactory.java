package com.gp.creat.factory.method;


import java.util.Scanner;

/**
 * @author gp
 * @create 2020/2/20 20:14
 */

/**
 * 工厂方法模式
 */
public abstract class MethodFactory {

    //该方法的实现交给子类,当实例化子类时,会自动调用该父类的构造方法
    abstract Pizza getPizza(String name);

    private Pizza pizza;
    private String name;

    public MethodFactory() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您想要订购的披萨类型:");
            name = sc.nextLine();
            pizza = getPizza(name);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.pack();
                System.out.println("------------");
            } else {
                System.out.println("老八还没开发这种披萨!");
                sc.close();
                break;
            }
        }
        System.out.println("程序退出!");
    }
}

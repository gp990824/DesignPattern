package com.gp.creat.factory.abstractfactory;

import java.util.Scanner;

/**
 * @author gp
 * @create 2020/2/20 21:09
 */

/**
 * 抽象工厂的
 */
public class PizzaOrder {
    private AbstractFactory factory;//聚合


    public PizzaOrder(AbstractFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbstractFactory factory) {
        Pizza pizza;
        String name;
        this.factory = factory;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您想要订购的披萨类型:");
            name = sc.nextLine();
            pizza = this.factory.getPizza(name);
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

package com.gp.creat.factory.simple;

import java.util.Scanner;

/**
 * @author gp
 * @create 2020/2/20 19:28
 */
public class PizzaOrder {

    private Pizza pizza;
    private String name;

    public PizzaOrder() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您想要订购的披萨类型:");
            name = sc.nextLine();
            pizza = PizzaFactory.getPizza(name);
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

package com.gp.creat.factory.abstractfactory;

import java.util.Scanner;

/**
 * @author gp
 * @create 2020/2/20 20:57
 */
//工厂子类
public class AlgcdfFactory implements AbstractFactory {


    @Override
    public Pizza getPizza(String name) {
        Pizza pizza = null;
        if (name.equals("奥利给")) {
            pizza = new AoligeiPizza();
            pizza.setName(name);
        } else if (name.equals("臭豆腐")) {
            pizza = new ChoudoufuPizza();
            pizza.setName(name);
        }
        return pizza;
    }
}


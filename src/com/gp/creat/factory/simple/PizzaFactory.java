package com.gp.creat.factory.simple;

/**
 * @author gp
 * @create 2020/2/20 19:31
 */

/**
 * 静态工厂
 */
public class PizzaFactory {
    public static Pizza getPizza(String name){
        Pizza pizza = null;
        if(name.equals("奥利给")){
            pizza = new AoligeiPizza();
            pizza.setName(name);
        }else if(name.equals("臭豆腐")) {
            pizza = new ChoudoufuPizza();
            pizza.setName(name);
        }
        return pizza;
    }
}

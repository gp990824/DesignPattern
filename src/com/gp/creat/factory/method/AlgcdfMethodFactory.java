package com.gp.creat.factory.method;

/**
 * @author gp
 * @create 2020/2/20 20:13
 */
public class AlgcdfMethodFactory extends MethodFactory {
    @Override
    Pizza getPizza(String name) {
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

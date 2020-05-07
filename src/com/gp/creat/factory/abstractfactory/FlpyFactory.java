package com.gp.creat.factory.abstractfactory;

/**
 * @author gp
 * @create 2020/2/20 20:58
 */
//工厂子类
public class FlpyFactory implements AbstractFactory {

    @Override
    public Pizza getPizza(String name) {
       Pizza pizza = null;
        if (name.equals("俘虏")) {
            pizza = new FuluPizza();
            pizza.setName(name);
        } else if (name.equals("扒鸭屁股")) {
            pizza = new PayaPizza();
            pizza.setName(name);
        }
        return pizza;
    }

}

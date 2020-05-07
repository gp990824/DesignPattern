package com.gp.creat.factory.method;


/**
 * @author gp
 * @create 2020/2/20 20:14
 */
public class FlpyMethodFactory extends MethodFactory {

    @Override
    Pizza getPizza(String name) {
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

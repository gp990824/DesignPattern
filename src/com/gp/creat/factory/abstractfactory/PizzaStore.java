package com.gp.creat.factory.abstractfactory;

/**
 * @author gp
 * @create 2020/2/20 21:16
 */

public class PizzaStore {
    public static void main(String[] args) {
        //根据传入的参数的不同来实现不同的代码
//        new PizzaOrder(new AlgcdfFactory());
        new PizzaOrder(new FlpyFactory());
    }
}

package com.gp.creat.factory.abstractfactory;


/**
 * @author gp
 * @create 2020/2/20 19:26
 */
public class AoligeiPizza extends Pizza {
    @Override
    protected void prepare() {
        System.out.println("奥利给披萨正在准备...");
    }
}

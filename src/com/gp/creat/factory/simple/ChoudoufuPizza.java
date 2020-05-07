package com.gp.creat.factory.simple;

/**
 * @author gp
 * @create 2020/2/20 19:27
 */
public class ChoudoufuPizza extends Pizza {
    @Override
    protected void prepare() {
        System.out.println("臭豆腐披萨正在准备...");
    }
}

package com.gp.creat.factory.method;


/**
 * @author gp
 * @create 2020/2/20 20:10
 */
public class FuluPizza extends Pizza {
    @Override
    protected void prepare() {
        System.out.println("俘虏披萨正在准备...");
    }
}

package com.gp.creat.factory.method;

/**
 * @author gp
 * @create 2020/2/20 20:12
 */
public class PayaPizza extends Pizza {
    @Override
    protected void prepare() {
        System.out.println("扒鸭屁股披萨正在准备...");
    }
}

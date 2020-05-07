package com.gp.creat.builder;

/**
 * @author gp
 * @create 2020/2/24 20:22
 */
public class Builder extends AbstractBuilder {
    @Override
    void buyStone() {
        System.out.println("正在购买石头!");
    }

    @Override
    void buildWall() {
        System.out.println("正在建造围墙!");
    }
}

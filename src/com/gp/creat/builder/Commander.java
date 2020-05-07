package com.gp.creat.builder;

/**
 * @author gp
 * @create 2020/2/24 20:23
 */
//指挥者
public class Commander {
    private AbstractBuilder abstractBuilder;

    public Commander(AbstractBuilder abstractBuilder) {
        this.abstractBuilder = abstractBuilder;
    }

    public House buildHouse() {
        abstractBuilder.buyStone();
        abstractBuilder.buildWall();
        return abstractBuilder.buildHouse();
    }
}

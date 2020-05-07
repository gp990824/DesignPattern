package com.gp.creat.builder;

/**
 * @author gp
 * @create 2020/2/24 20:17
 */
public abstract class AbstractBuilder {
    abstract void buyStone();
    abstract void buildWall();
    protected House buildHouse(){
        return new House("green",800000);
    }

}

package com.gp.creat.prototype;

import java.io.Serializable;

/**
 * @author gp
 * @create 2020/2/24 10:31
 */
public class Sheep2 implements Cloneable, Serializable {
    String name;
    String color;

    public Sheep2(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

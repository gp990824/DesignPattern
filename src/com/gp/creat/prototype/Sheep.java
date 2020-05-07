package com.gp.creat.prototype;

/**
 * @author gp
 * @create 2020/2/21 9:42
 */
public class Sheep implements Cloneable {

    public Sheep friend ;
    //克隆该实例,使用默认的clone()方法
    @Override
    protected Object clone() {
        Sheep clone = null;
        try {
            clone = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "friend=" + friend +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Sheep() {
    }

    public Sheep(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private int age;
    private String name;
    private String color;
}

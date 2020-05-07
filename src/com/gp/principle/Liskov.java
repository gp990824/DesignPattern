package com.gp.principle;

/**
 * @author gp
 * @create 2020/2/19 15:37
 */

/**
 * 里氏替换原则
 *      子类尽量不要重写父类的方法
 *
 *  让原来的父类和子类都继承一个更通俗的基类
 */
public class Liskov {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.add(3, 2));
        Child child = new Child();
        System.out.println(child.add(3, 2));
        System.out.println(child.addNum(3, 2));
    }
}

class Base {
}

class Parent extends Base {
    public int add(int a, int b) {
        return a + b;
    }

    public Parent() {
        System.out.println("A的无参构造!");
    }
}

class Child extends Base {
    private Parent parent = new Parent();

    public int add(int a, int b) {
        return a * a - b * b;
    }

    public int addNum(int a, int b) {
        return this.parent.add(a, b);
    }

    public Child() {
        System.out.println("B的无参构造!");
    }
}
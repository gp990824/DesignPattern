package com.gp.creat.prototype;

/**
 * @author gp
 * @create 2020/2/21 9:49
 */

/**
 * 原型模式,要克隆的对象实现Cloneable接口,并重写clone()方法
 * spring 的bean的创建  scope="prototype"就是使用的是原型模式
 * 浅拷贝:
 * 如果被克隆的对象有基本类型,浅拷贝会直接进行值传递,也就是将该属性的值复制一份该新的对象
 * 如果有引用类型(数组,String,类的对象),那么浅拷贝会进行引用传递,也就是将该属性的地址复制一份给新的对象,
 * 实际上两个对象的属性都指向同一个实例
 * 深拷贝:
 * 所有属性都拷贝一份,包括引用类型
 */
public class Main {
    public static void main(String[] args) {
        Sheep sheep = new Sheep(1, "tom", "white");
        sheep.friend = new Sheep(2, "jack", "black");//被克隆的对象
        Sheep clone = (Sheep) sheep.clone();
        Sheep clone1 = (Sheep) sheep.clone();
        Sheep clone2 = (Sheep) sheep.clone();
        Sheep clone3 = (Sheep) sheep.clone();
        //克隆的对象与原对象的地址不一致
        System.out.println(clone.hashCode() + "\tfriend:" + clone.friend.hashCode() + "\t" + clone.getName().hashCode());
        System.out.println(clone1.hashCode() + "\tfriend:" + clone1.friend.hashCode() + "\t" + clone1.getName().hashCode());
        System.out.println(clone2.hashCode() + "\tfriend:" + clone2.friend.hashCode() + "\t" + clone2.getName().hashCode());
        System.out.println(clone3.hashCode() + "\tfriend:" + clone3.friend.hashCode() + "\t" + clone3.getName().hashCode());

    }
}

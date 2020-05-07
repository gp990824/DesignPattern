package com.gp.creat.prototype;

/**
 * @author gp
 * @create 2020/2/24 10:38
 */
public class DeepCloneMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepClone deepClone = new DeepClone();
        deepClone.name = "jj";
        deepClone.sheep2 = new Sheep2("aa", "red");
//        DeepClone clone = (DeepClone)deepClone.clone();
//        DeepClone clone1 = (DeepClone)deepClone.clone();
        DeepClone clone = (DeepClone) deepClone.deepClone();
        DeepClone clone1 = (DeepClone) deepClone.deepClone();
        System.out.println(deepClone.sheep2.hashCode());
        System.out.println(clone1.sheep2.hashCode());
        System.out.println(clone.sheep2.hashCode());
    }
}

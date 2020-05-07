package com.gp.creat.factory.method;

import java.util.Scanner;

/**
 * @author gp
 * @create 2020/2/20 20:23
 */
public class PizzaStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想吃的披萨口味(奥利给,臭豆腐披萨请按 1,俘虏,扒鸭屁股披萨请按 2):");
        int i = sc.nextInt();
        if (i == 1) {
            new AlgcdfMethodFactory();
        } else if (i == 2) {
            new FlpyMethodFactory();
        }else {
            System.out.println("输入有误!");
        }

        sc.close();
    }
}

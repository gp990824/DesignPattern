package com.gp.creat.builder;

/**
 * @author gp
 * @create 2020/2/24 20:25
 */

/**
 * 建造者模式:
 * 所创建的产品一般具有较多的共同点,其组成部分相似
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Commander(new Builder()).buildHouse());
    }
}

package com.gp.creat.factory.abstractfactory;

/**
 * @author gp
 * @create 2020/2/20 20:56
 */

/**
 * 抽象工厂的抽象层
 */
public interface AbstractFactory {
    Pizza getPizza(String name);
}

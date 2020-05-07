package com.gp.uml;

/**
 * @author gp
 * @create 2020/2/20 13:16
 */

/**
 * 关联:
 *      类与类之间的关系,有单向的和多向的
 */
public class Association {
}
class Person{
    private IDCard idCard;
}
class IDCard{
    private Person person;
}

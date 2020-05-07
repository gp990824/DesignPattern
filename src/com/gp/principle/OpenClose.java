package com.gp.principle;

/**
 * @author gp
 * @create 2020/2/19 19:10
 */

/**
 * 开闭原则:
 *      对扩展(提供方)开放,对修改(使用方)关闭
 *      用抽象构建框架,用实现拓展细节
 */
public class OpenClose {
    public static void main(String[] args) {
        Draw.draw(new Circle());
        Draw.draw(new Rectangle());
    }
}
//使用方,如果需要继续添加图形时,只需要增加一个类继承Shape类即可,而该类及其方法都不用修改
class Draw{
    public static void draw(Shape shape){
        shape.draw();
    }
}
abstract class Shape{
    abstract void draw();
}
class Circle extends Shape{

    @Override
    void draw() {
        System.out.println("我是圆形!");
    }
}

class Rectangle extends Shape{
    @Override
    void draw() {
        System.out.println("我是矩形!");
    }
}
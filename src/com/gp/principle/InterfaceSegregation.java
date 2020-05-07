package com.gp.principle;

/**
 * @author gp
 * @create 2020/2/19 10:13
 */

/**
 * 接口隔离原则
 * 一个类对一个类的依赖,一般是通过接口来依赖的
 * 将大接口拆成多个小接口,每个小接口的方法都有实现
 */
public class InterfaceSegregation {
    public static void main(String[] args) {
        C c = new C();
        c.method2(new A());
    }
}

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();

    void method3();
}

interface Interface3 {
    void method4();

    void method5();
}

class A implements Interface1, Interface2 {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }
}

class B implements Interface1, Interface3 {

    @Override
    public void method1() {

    }

    @Override
    public void method4() {

    }

    @Override
    public void method5() {

    }
}

class C {//C通过接口interface1,interface2依赖A类

    public void method1(Interface1 interface1) {
        interface1.method1();
    }

    public void method2(Interface2 interface1) {
        interface1.method2();
    }

    public void method3(Interface2 interface1) {
        interface1.method3();
    }
}

class D {//D通过接口interface1,interface3依赖B类

    public void method1(Interface1 interface1) {
        interface1.method1();
    }

    public void method4(Interface3 interface1) {
        interface1.method4();
    }

    public void method5(Interface3 interface1) {
        interface1.method5();
    }
}

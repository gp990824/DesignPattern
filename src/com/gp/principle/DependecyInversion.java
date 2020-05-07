package com.gp.principle;

/**
 * @author gp
 * @create 2020/2/19 11:11
 */

/**
 * 依赖倒置原则(就是多态的利用,面向接口编程)
 * 细节依赖抽象,抽象不要依赖细节
 */
public class DependecyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.recieve(new Message());
        person.recieve(new Wechat());
    }
}

interface Phone {
    String getMessage();
}

class Wechat implements Phone {

    @Override
    public String getMessage() {
        return "我手机收到了一条微信!";
    }
}

class Message implements Phone {

    @Override
    public String getMessage() {
        return "我手机收到了一条短信!";
    }
}

class Person {
    public void recieve(Phone phone) {
        System.out.println(phone.getMessage());
    }
}


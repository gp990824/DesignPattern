package com.gp.creat.singleton;

/**
 * @author gp
 * @create 2020/2/20 16:43
 */

/**
 * 第四种写法:
 * 懒汉式(线程安全,同步方法)
 * 效率低,实际开发中不要使用该方法!
 */
public class TypeFour extends Thread {
    @Override
    public void run() {
        Four four = Four.getInstance();
        Four four1 = Four.getInstance();
        Four four2 = Four.getInstance();
        Four four3 = Four.getInstance();
        Four four4 = Four.getInstance();
        System.out.println(four == four1);
        System.out.println(four == four2);
        System.out.println(four2 == four3);
        System.out.println(four == four3);
    }

    public static void main(String[] args) {
        TypeFour typeFour = new TypeFour();
        TypeFour typeFour1 = new TypeFour();
        TypeFour typeFour2 = new TypeFour();
        typeFour.start();
        typeFour1.start();
        typeFour2.start();
    }
}

class Four {
    private Four() {

    }

    private static Four singleton;

    //在使用该方式时,再创建该对象
    public synchronized static Four getInstance() {
        if (singleton == null) {
            singleton = new Four();
        }
        return singleton;
    }
}

package com.gp.creat.singleton;

/**
 * @author gp
 * @create 2020/2/20 17:01
 */

/**
 * 第五种写法:
 *      懒汉式(线程安全,同步代码块)
 *      实际上会造成线程不安全,实际开发不要使用该方法!
 */
public class TypeFive implements Runnable{
    @Override
    public void run() {
        Five instance = Five.getInstance();
        Five instance1 = Five.getInstance();
        Five instance2 = Five.getInstance();
        Five instance3 = Five.getInstance();
        Five instance4 = Five.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance == instance1);
        System.out.println(instance == instance3);
        System.out.println(instance3 == instance2);
        System.out.println(instance4 == instance);

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TypeFive());
        Thread thread2 = new Thread(new TypeFive());
        Thread thread1 = new Thread(new TypeFive());
        Thread thread3 = new Thread(new TypeFive());
        thread.start();
        thread2.start();
        thread1.start();
        thread3.start();
    }
}

class Five {
    private Five() {

    }

    private static Five singleton;

    public static Five getInstance() {
        if (singleton == null) {
            synchronized (Five.class) {
                singleton = new Five();
            }
        }
        return singleton;
    }
}

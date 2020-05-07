package com.gp.creat.singleton;

/**
 * @author gp
 * @create 2020/2/20 17:20
 */

/**
 * 第七种写法:
 *  静态内部类
 *  外部类在被装载的时候,内部类不会被装载,只会在被调用的时候被装载
 *  且只会比装载一次,线程安全
 *  推荐使用该方法
 */
public class TypeSeven implements Runnable {
    @Override
    public void run() {
        Seven instance = Seven.getInstance();
        Seven instance1 = Seven.getInstance();
        Seven instance2 = Seven.getInstance();
        Seven instance3 = Seven.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance == instance2);
        System.out.println(instance == instance3);
        System.out.println(instance2 == instance3);
        System.out.println(instance1 == instance2);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TypeSeven());
        Thread thread1 = new Thread(new TypeSeven());
        Thread thread2 = new Thread(new TypeSeven());
        Thread thread3 = new Thread(new TypeSeven());
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Seven{
    private Seven(){

    }
    //jvm在装载类的时候是线程安全的
    private static class Singleton{
        private final static Seven INSTANCE = new Seven();
    }
    public static Seven getInstance(){
        return Singleton.INSTANCE;
    }
}

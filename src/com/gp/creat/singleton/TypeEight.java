package com.gp.creat.singleton;

/**
 * @author gp
 * @create 2020/2/20 17:30
 */

/**
 * 第八种写法:
 * 枚举
 * 推荐使用
 */
public class TypeEight implements Runnable {
    @Override
    public void run() {
        Eight instance = Eight.getInstance();
        Eight instance1 = Eight.getInstance();
        Eight instance2 = Eight.getInstance();
        Eight instance3 = Eight.getInstance();
        Eight instance4 = Eight.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance == instance2);
        System.out.println(instance == instance3);
        System.out.println(instance == instance4);
        System.out.println(instance1 == instance2);
        System.out.println(instance2 == instance3);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TypeEight());
        Thread thread1 = new Thread(new TypeEight());
        Thread thread2 = new Thread(new TypeEight());
        Thread thread3 = new Thread(new TypeEight());
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Eight {
    private Eight() {

    }

    //枚举是天然的单例
    private enum Singleton {
        INSTANCE;

        private Eight singleton;
        Singleton(){
            singleton = new Eight();
        }
        public Eight getInstance(){
            return singleton;
        }
    }

    public static Eight getInstance() {
        return Singleton.INSTANCE.getInstance();
    }
}


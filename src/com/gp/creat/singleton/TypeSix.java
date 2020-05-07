package com.gp.creat.singleton;

/**
 * @author gp
 * @create 2020/2/20 17:11
 */

/**
 * 第六种写法:
 * 双重检查式
 * 实际开发推荐使用该方法
 */
public class TypeSix{
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Six.getInstance();
                }
            }).start();
        }
    }
}

class Six {
    private Six() {
        System.out.println("实例化....");
    }

    private static volatile Six singleton;

    public static Six getInstance() {
        if (singleton == null) {
            synchronized (Six.class) {
                if (singleton == null) {
                    singleton = new Six();
                }
            }
        }
        return singleton;
    }
}

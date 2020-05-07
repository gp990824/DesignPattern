package com.gp.creat.singleton;

/**
 * @author gp
 * @create 2020/2/20 16:37
 */

/**
 * 单例模式的第三种写法:
 *      懒汉式(线程不安全)
 * 在实际开发中,不要使用该方式!
 */
public class TypeThree implements Runnable{
    @Override
    public void run() {
        Three instance = Three.getInstance();
        Three instance1 = Three.getInstance();
        Three instance2 = Three.getInstance();
        Three instance3 = Three.getInstance();
        Three instance4 = Three.getInstance();
        Three instance5 = Three.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance == instance2);
        System.out.println(instance == instance3);
        System.out.println(instance2 == instance4);
        System.out.println(instance3 == instance5);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TypeThree());
        Thread thread1 = new Thread(new TypeThree());
        Thread thread2 = new Thread(new TypeThree());
        thread.start();thread1.start();thread2.start();
    }
}
class Three{
    private Three(){

    }
    private static Three singleton;
    //在使用该方式时,再创建该对象
    public static Three getInstance(){
        if (singleton == null) {
            singleton = new Three();
        }
        return singleton;
    }
}

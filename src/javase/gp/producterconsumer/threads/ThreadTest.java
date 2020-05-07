package javase.gp.producterconsumer.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Gp
 * @create 2020/4/10 18:26
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
//        for (int i = 0; i < 50; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    myThread.sale();
//
//                }
//            }).start();
//        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myThread.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myThread1.test2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class MyThread {
    private Lock lock = new ReentrantLock();
    private int num = 10;

    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第 " + (num--) + " 票, 当前剩余 " + num + " 张票!");
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public synchronized static void test1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("test1 come in...");
    }
    public synchronized void test2(){
        System.out.println("test2 come in...");
    }
}

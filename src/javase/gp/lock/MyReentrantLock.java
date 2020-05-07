package javase.gp.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Gp
 * @create 2020/4/5 13:05
 */
public class MyReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.lock();
            }
        }, "线程1").start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.lock();
            }
        }, "线程2").start();
    }
}
class Test{
    private Lock lock = new ReentrantLock();
    public void lock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "已进入!");
            while (true) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

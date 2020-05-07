package javase.gp.spinlock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Gp
 * @create 2020/3/29 17:47
 */
//手写一个自旋锁
public class MySpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " 已进入myLock()方法!");
        while (true) {
            //如果线程不是第一次进入, 则需要自旋   否则需要立即退出循环
            if (atomicReference.compareAndSet(null, thread)) {//如果是第一次进入, 则跳出循环
                break;
            }
        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " 已进入myUnLock()方法!");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {
        MySpinLock lock = new MySpinLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.myLock();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.myUnLock();
            }
        }, "线程1").start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.myLock();
                lock.myUnLock();
            }
        }, "线程2").start();

    }
}

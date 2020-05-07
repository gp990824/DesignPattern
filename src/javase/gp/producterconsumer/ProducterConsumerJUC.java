package javase.gp.producterconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Gp
 * @create 2020/3/30 17:35
 */

/**
 * J.U.C 版生产着消费者写法, 相对于传统synchronized的优势:
 * 可以唤醒指定的线程或线程组, 不像传统版那样只能唤醒某个线程和全部线程
 */
public class ProducterConsumerJUC {
    public static void main(String[] args) {
        Production production = new Production();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    production.increase();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    production.decrease();
                }
            }
        }).start();
    }
}

class Production {
    private volatile int num;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase() {
        lock.lock();
        try {
            while (true) {
                //当没有产品时, 生产
                if (num == 0) {
                    break;
                }
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "正在生产产品!");
            condition.signalAll();//唤醒处于等待状态的线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() {
        lock.lock();
        try {
            while (true) {
                //当有产品时, 消费
                if (num != 0) {
                    break;
                }
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "正在消费产品!");
            condition.signalAll();//唤醒处于等待状态的线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

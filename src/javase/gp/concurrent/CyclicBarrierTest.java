package javase.gp.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Gp
 * @create 2020/4/11 13:31
 */
//循环路障
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("七颗龙珠已经集齐, 可以召唤神龙了!");
            }
        });
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                task();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void task() {
        System.out.println(Thread.currentThread().getName() + "集齐了一颗龙珠!");
    }
}

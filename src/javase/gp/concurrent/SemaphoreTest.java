package javase.gp.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author Gp
 * @create 2020/4/11 13:45
 */
//信号量
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//设置最大通行证数量, 最多同时只有三个线程持有通行证
        for (int i = 0; i < 9; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "获取到通行证了!");
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            }).start();
        }
    }
}

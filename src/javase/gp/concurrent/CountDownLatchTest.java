package javase.gp.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author Gp
 * @create 2020/4/11 13:26
 */
//倒计时器
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {task(); countDownLatch.countDown();}).start();
        }
        countDownLatch.await();
        System.out.println("同学都走光了, 班长可以锁门了.");
    }
    public static void task(){
        System.out.println(Thread.currentThread().getName() + "同学走了");
    }
}

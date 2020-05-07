package javase.gp.producterconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Gp
 * @create 2020/4/1 14:54
 */
//新版生产者消费者写法
public class ProducterConsumerNew {
    public static void main(String[] args) throws InterruptedException {
        ProductionNew productionNew = new ProductionNew(new ArrayBlockingQueue<>(5));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("生产者线程启动");
                    productionNew.producter();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("消费者线程启动");
                    productionNew.consumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(10000);
        System.out.println("大老板叫停!");
        productionNew.setFlag(false);
    }
}

class ProductionNew {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private BlockingQueue<String> blockingQueue;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ProductionNew(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void producter() throws InterruptedException {
        String prod;
        boolean offer;
        while (flag) {
            prod = atomicInteger.incrementAndGet() + "";
            offer = blockingQueue.offer(prod, 2L, TimeUnit.SECONDS);//如果两秒之内都没有插入对列成功, 则退出
            if (offer) {
                System.out.println(Thread.currentThread().getName() + "往队列放入产品成功" + prod);
            } else {
                System.out.println(Thread.currentThread().getName() + "往队列放入产品失败" + prod);
            }
            Thread.sleep(500);
        }
        System.out.println("大老板叫停, 停止生产");
    }

    public void consumer() throws InterruptedException {
        String offer;
        while (flag) {
            offer = blockingQueue.poll(2L, TimeUnit.SECONDS);//如果两秒之内都没有取出元素成功, 则退出
            if (offer == null || "".equals(offer)) {
                flag = false;
                System.out.println("队列中已经没有产品了");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "往队列取出产品成功" + offer);
        }
    }
}

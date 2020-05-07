package javase.gp.producterconsumer;

/**
 * @author Gp
 * @create 2020/4/11 12:07
 */

/**
 * 传统 synchronized wait  notifyAll 写法
 */
public class ProducterConsumerBefore {
    public static void main(String[] args) {
        Production1 pro = new Production1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        pro.increase();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "生产者").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        pro.decrease();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "消费者").start();
    }
}

class Production1 {
    private int num = 0;

    public synchronized void increase() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "正在生产产品" + num);
        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {//消费
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "正在消费产品" + num);
        this.notifyAll();
    }
}

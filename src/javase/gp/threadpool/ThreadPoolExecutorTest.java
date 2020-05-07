package javase.gp.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Gp
 * @create 2020/4/1 17:34
 */
//线程池的使用
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newFixedThreadPool(5);
        ExecutorService pool3 = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 5; i++) {
                pool3.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "正在执行任务!");
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool3.shutdown();
        }

    }
}

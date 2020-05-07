package javase.gp.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Gp
 * @create 2020/3/30 14:24
 */
//读-读可以共存, 读-写, 写-写不能共存
public class MyReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        for (int i = 0; i < 5; i++) {//五个线程同时写
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cache.set(String.valueOf(temp), temp);
                }
            }).start();
        }

//        Thread.sleep(1000);

        for (int i = 0; i < 5; i++) {//五个线程同时读
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cache.get(String.valueOf(temp));
                }
            }).start();
        }
    }
}
class Cache{
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public Object get(String key) {
        lock.readLock().lock();
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在读: " + key);
            return map.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set(String key, Object value) {
        lock.writeLock().lock();
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在写 :" + key);
            map.put(key, value);
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

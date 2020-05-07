package javase.gp.deadlock;

/**
 * @author Gp
 * @create 2020/4/2 16:49
 */
//手写一个死锁
public class MyDeadLock {
    public static void main(String[] args)  {
        new Thread(new GetLockThread("lock1","lock2")).start();
        new Thread(new GetLockThread("lock2","lock1")).start();
//        new Thread(new GetLockThread("lock2","lock1")).start();
    }
}
class GetLockThread implements Runnable{
    private String lock1;
    private String lock2;

    public GetLockThread(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " 持有 :" + lock1 +" 尝试获得 : " + lock2 + "---");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " 持有 :" + lock2 +" 尝试获得 : " + lock1);
            }
        }
    }
}

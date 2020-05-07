package javase.gp.threadlocal;


/**
 * @author Gp
 * @create 2020/4/14 14:53
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        Data data = new Data();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (data) {
                        data.setValue(Thread.currentThread().getName());
                        System.out.println(Thread.currentThread().getName() + "取出数据 : " + data.getValue());
                    }
                }
            }).start();

        }
    }
}

class Data {
    private String value;

    //    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public String getValue() {
//        return threadLocal.get();
        return value;
    }

    public void setValue(String value) {
        this.value = value;
//        threadLocal.set(value);
    }
}

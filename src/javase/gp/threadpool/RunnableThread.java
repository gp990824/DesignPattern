package javase.gp.threadpool;

/**
 * @author Gp
 * @create 2020/4/1 16:51
 */
public class RunnableThread {
    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        new Thread(runnableTest).start();
        new Thread(new RunnableTest()).start();
    }
}
class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println("come in run()--------");
    }
}

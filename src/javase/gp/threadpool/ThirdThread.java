package javase.gp.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Gp
 * @create 2020/4/1 16:20
 */
public class ThirdThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Third third = new Third();
        FutureTask<Integer> task = new FutureTask<>(third);
//        FutureTask<Integer> task1 = new FutureTask<>(third);
        new Thread(task).start();
//        new Thread(task1).start();
        System.out.println(task.get());
    }

}

class Third implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("进入call()方法");
        return 1;
    }
}

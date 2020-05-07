package javase.gp.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author Gp
 * @create 2020/4/11 15:56
 */
//三种方式求和, 传统for循环, ForkJoin, Stream并行流计算
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
//        Long result = test1();
//        Long result = test2();
        Long result = test3();
        long end = System.currentTimeMillis();
        System.out.println("结果为 : " + result + "  |  共耗时(ms) : " + (end - start));
    }

    public static Long test1() {
        Long sum = 0L;
        for (Long i = 1L; i <= 100000000; i++) {
            sum += i;
        }
        return sum;
    }

    public static Long test2() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(new Data(1L, 100000000L));
        return submit.get();
    }

    public static Long test3() {
        return LongStream.rangeClosed(0L, 100000000L).parallel().reduce(0, Long::sum);
    }
}

class Data extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long threshold = 5000000L;

    public Data(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        boolean flag = (end - start) <= threshold;
        if (flag) {
            Long result = 0L;
            for (Long i = start; i <= end; i++) {
                result += i;
            }
            return result;
        } else {
            Long mid = (start + end) / 2;
            Data data1 = new Data(start, mid);
            Data data2 = new Data(mid + 1, end);
            data1.fork();
            data2.fork();
            return data1.join() + data2.join();
        }
    }
}
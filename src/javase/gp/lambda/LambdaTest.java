package javase.gp.lambda;

/**
 * @author gp
 * @create 2020/2/28 13:41
 */
/**
 * lambda 表达式: () -> 具体实现
 *
 * 相当于匿名内部类,括号内填参数,后面是该方法的实现,如果有多行代码,用{}包围
 *
 * 只能用于函数接口(只有一个犯法的接口),改接口可以用@Functionalinterface注解
 */
public class LambdaTest {
    public static void main(String[] args) {
        //匿名内部类
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类!");
            }
        };
        run.run();

        Runnable runnable = () -> System.out.println("Lambda表达式!");
        runnable.run();
    }


}

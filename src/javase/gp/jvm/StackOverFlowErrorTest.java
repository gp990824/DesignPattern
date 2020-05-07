package javase.gp.jvm;

/**
 * @author gp
 * @create 2020/2/26 20:21
 */
public class StackOverFlowErrorTest {
    private static int i = 1;//9835
    public static void main(String[] args) {
        System.out.println(i++);
        main(args);
    }
}

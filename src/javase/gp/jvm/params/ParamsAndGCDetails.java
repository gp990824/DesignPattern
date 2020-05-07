package javase.gp.jvm.params;

/**
 * @author Gp
 * @create 2020/4/3 12:28
 */

/**
 * -Xmx30m
 * -Xms30m
 * -XX:NewRatio=4
 * -XX:+UseSerialGC
 * -XX:SurvivorRatio=4
 * -XX:+PrintGCDetails
 * -XX:+PrintCommandLineFlags
 */
public class ParamsAndGCDetails {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("come in  ......");
        Thread.sleep(100000);
//        byte[] bytes = new byte[1024 * 1024 * 50];
    }
}

package javase.gp.jvm;

/**
 * @author gp
 * @create 2020/2/26 20:06
 */
public class JVMStack {
//    static char c = '\u0454';
    public static void main(String[] args) {
        JVMStack jvmStack = new JVMStack();
        method1();

//        System.out.println(c);
    }
    private static void method() {
        throw new RuntimeException("运行时异常!");
//        System.out.println("method");
    }
    private static void method1() {
        try {
            method();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("mehod1");
    }
}

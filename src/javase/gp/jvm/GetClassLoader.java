package javase.gp.jvm;

/**
 * @author gp
 * @create 2020/2/26 15:25
 */
public class GetClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            System.out.println(clazz.getClassLoader());

            //获取到该线程的类加载器, sun.misc.Launcher$AppClassLoader 是Launcher类内部类
            System.out.println(Thread.currentThread().getContextClassLoader());

            //获取到该类加载器的父类加载器  ExtClassLoader
            System.out.println(ClassLoader.getSystemClassLoader().getParent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package javase.gp.singleton;

/**
 * @author gp
 * @create 2020/2/25 19:03
 */
//单例模式,枚举,双重检查式
public class Singleton {
    private Singleton() {

    }

    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Singleton instance3 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance1 == instance2);
        System.out.println(instance == instance1);
        System.out.println(instance1 == instance3);
    }
}

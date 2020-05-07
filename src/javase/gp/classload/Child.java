package javase.gp.classload;

/**
 * @author gp
 * @create 2020/2/25 18:33
 */
public class Child extends Person {
    private int i = test1();
    private static int j = test3();

    static {
        System.out.println("子类静态代码块!");
    }

    {
        System.out.println("子类非静态代码块!");
    }

    //该无参构造一定在最后执行!
    Child() {
//        super();//不管写或者不写,子类在初始化的时候一定会初始化其父类
        System.out.println("子类无参构造方法!");
    }

    @Override
    public int test1() {
        System.out.println("正在加载子类非静态成员属性!");
        return 1;
    }

    //被final,static,private修饰的方法不能被重写
    public static int test3() {
        System.out.println("正在初始化子类静态成员属性!");
        return 1;
    }

    /**
     * main()方法所在的类需要先被加载和初始化(会经过前面四个过程),子类的初始化必先初始化其父类
     * 类的加载顺序:(先加载静态的属性或代码块) 被static修饰的只会被加载一次
     *  父类的静态属性/代码块->子类静态/代码块->父类非静态属性/代码块->
     *  父类无参构造方法->子类的非静态属性/代码块->子类构造方法(属性与代码块的加载顺序由代码顺序决定)
     * @param args
     */
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println("--------------");
//        Child child1 = new Child();
        Person person = new Person();
        System.out.println("------------");
        child.test1();
        person.test1();
    }
}

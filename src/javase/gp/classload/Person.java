package javase.gp.classload;

/**
 * @author gp
 * @create 2020/2/25 18:30
 */
public class Person {
    private int i = /*this.*/test1();//调用的是子类重写的方法,非静态方法默认调用的对象是this,在实例化子类的时候,this=new Child();
    private static int j = test();

    static {
        System.out.println("父类静态代码块!");
    }

    {
        System.out.println("父类非静态代码块!");
    }

    Person() {
        System.out.println("父类无参构造方法!");
    }

    public static int test() {
        System.out.println("正在加载父类静态成员属性!");
        return 1;
    }

    public int test1() {
        System.out.println("正在加载父类非静态成员属性!");
        return 1;
    }
}

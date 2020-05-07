package javase.gp.reflect;

import java.lang.reflect.Field;

/**
 * @author Gp
 * @create 2020/4/5 11:58
 */
public class ReflectDemo {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("javase.gp.reflect.Test");
//            Field[] fields = clazz.getFields();
//            Field[] fields = clazz.getDeclaredFields();
//            for (Field field : fields) {
//                System.out.println(field);
//            }
            Field name = clazz.getDeclaredField("name");
            System.out.println(name.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Test{
    private String name = "baba";
    public Integer age = 21;

}

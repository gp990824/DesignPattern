package javase.gp.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gp
 * @create 2020/4/3 16:35
 */
//元空间溢出
public class MetaSpaceError {
    public static void main(String[] args) {
        try {
            while (true) {
            }
        } catch (Throwable e) {
            System.out.println("一共创建了"  + "个静态内部类");
            e.printStackTrace();
        }
    }

    private static class MetaClass {
    }
}

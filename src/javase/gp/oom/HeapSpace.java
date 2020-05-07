package javase.gp.oom;

/**
 * @author Gp
 * @create 2020/4/3 15:58
 */
//堆空间溢出异常
public class HeapSpace {
    public static void main(String[] args) {
        String str = "gp";
        while (true) {
            str = str + str;
        }
    }
}

package javase.gp.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gp
 * @create 2020/4/3 16:00
 */
public class GCOverhead {
    public static void main(String[] args) {
        int i =0;
        List<String> list = new ArrayList<>();
        try {

            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

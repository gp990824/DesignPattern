package javase.gp.weakreference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Gp
 * @create 2020/4/3 14:21
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Integer key = new Integer(1);
        String value = "value";
        hashMap.put(key, value);
        System.out.println(hashMap);
        key = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);
        System.out.println("------------------------");
        //WeakHashMap适用于做缓存
        Map<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key1 = new Integer(1);
        String value1 = "value";
        weakHashMap.put(key1, value1);
        System.out.println(weakHashMap);
        key1 = null;
        System.out.println(weakHashMap);
        System.gc();//一旦触发GC, 所有数据都会被回收
        System.out.println(weakHashMap);
    }
}

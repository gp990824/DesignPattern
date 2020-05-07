package javase.gp.hashmap;

import java.util.HashMap;

/**
 * @author gp
 * @create 2020/2/28 19:57
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>(10);
        map.put("aaa", "Fuck you");
        System.out.println(map.get("aaa"));
    }
}

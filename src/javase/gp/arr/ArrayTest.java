package javase.gp.arr;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author gp
 * @create 2020/2/26 15:32
 */
public class ArrayTest {
    public static void main(String[] args) {
       test();
    }
//    public static void test1(){
//        ArrayList<String> strings = new ArrayList<>();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                strings.add(UUID.randomUUID().toString().substring(0,5));
//                System.out.println(strings);
//            }
//        }).start();
//    }
    public static void test(){
//        String[] str = new String[2];
//        Object[] obj = str;
//        str[0] = "Hello";
//        obj[1] = 1;
//        System.out.println(Arrays.toString(str));
//        System.out.println(Arrays.toString(obj));

//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);

//        List<String> arrayList = new ArrayList<>();
//        List<String> arrayList = Collections.synchronizedList(new ArrayList<>());
        List<String> arrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    arrayList.add(UUID.randomUUID().toString().substring(0, 5));
                    System.out.println(arrayList);
                }
            }, "线程").start();
        }
    }


}

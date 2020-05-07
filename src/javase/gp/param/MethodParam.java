package javase.gp.param;

import java.util.Arrays;

/**
 * @author gp
 * @create 2020/2/25 19:33
 */
public class MethodParam {
    //  String  包装类等对象不可变性
    public static void change(int i, Integer j, String str, int[] arr, MyClass my) {
        i += 1;//单独的值,只在该方法栈帧中有效,不会修改main方法栈帧中的 i 值
        j += 1;//同 String对象一致
        str += " world";//拼接完会产生一个新的String对象 此时的str指向 "Hello world"
        arr[0] += 1;
        my.data += 1;
    }


    public static void main(String[] args) {
        int i = 1;
        Integer j = 1;//Integer 对象的值相同且在[-128,127]区间内 则这两个对象指向相同地址
//        Integer k = 127;
//        System.out.println(j == k);
        String str = "Hello";
        int[] arr = {1, 2, 3};
        MyClass myClass = new MyClass();
        //方法参数的传递: 基本类型通过值传递,  引用类型通过地址传递
        change(i, j, str, arr, myClass);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("str = " + str);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("myClass.data = " + myClass.data);
    }
}

class MyClass {
    int data = 1;
}

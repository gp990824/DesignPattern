package javase.gp.numupup;

/**
 * @author gp
 * @create 2020/2/25 18:48
 */
public class NumUpUp {
    public static void main(String[] args) {
        int i = 1;
        //先把i的值(1)压入操作数栈中,然后i自增(2),最后把操作数栈的值(1)赋给i,所以i的值没有改变
        i = i++;//此操作没有任何意义
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i = " + i);//4
        System.out.println("j = " + j);//1
        System.out.println("k = " + k);// 2 + 3 * 3
    }
}

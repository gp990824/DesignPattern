package javase.gp.stream;

/**
 * @author Gp
 * @create 2020/4/11 15:17
 */


import java.util.Arrays;
import java.util.List;

/**
 * 要求一行代码输出
 * 1. 年龄为偶数
 * 2. 年龄大于22
 * 3. 名字转成大写
 * 4. 逆序输出
 * 5. 只要1个结果
 */
public class StreamTest {
    public static void main(String[] args) {
        Data date1 = new Data("Jack", 20, "男");
        Data date2 = new Data("Rose", 21, "女");
        Data date3 = new Data("Smith", 22, "男");
        Data date4 = new Data("Lily", 23, "女");
        Data date5 = new Data("John", 24, "男");
        List<Data> datas = Arrays.asList(date1, date2, date3, date4, date5);
        datas.stream().filter(data -> data.getAge() % 2 == 0)
                .filter(data -> data.getAge() > 21)
                .map(data -> data.getName().toUpperCase())
                .sorted((d1, d2) -> {
                    return d1.compareTo(d2);
                })
                .limit(1)
                .forEach(System.out::println);
    }
}

class Data /*implements Comparator<Integer>*/ {
    private String name;
    private Integer age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Data(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

//    @Override
//    public int compare(Integer o1, Integer o2) {
//        return o1 - o2;
//    }
}

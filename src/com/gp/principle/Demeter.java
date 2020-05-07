package com.gp.principle;

/**
 * @author gp
 * @create 2020/2/19 19:35
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特原则:
 *      只与直接朋友通讯
 *      降低类之间的耦合关系
 */
public class Demeter {
    public static void main(String[] args) {
        new MiddleSchool().printAllStudent(new HighSchool());
    }
}

class Student {
    private int id;

    public Student(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}

class HighSchool {
    public List<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            students.add(new Student(i));
        }
        return students;
    }

    public void printHighSchoolStudent() {
        List<Student> students = getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

/**
 * 直接朋友:成员变量,方法的返回值,方法的参数
 *      Student,HighSchool
 * 陌生朋友:局部变量
 */
class MiddleSchool {
    public List<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 6; i <= 10; i++) {
            students.add(new Student(i));
        }
        return students;
    }

    public void printAllStudent(HighSchool school) {
        school.printHighSchoolStudent();
        System.out.println("------------");
        List<Student> students = getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

package 面试题.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int order = in.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String name = in.next();
            int score = in.nextInt();
            Student stu = new Student(name, score);
            list.add(stu);
        }
        List<Student> res = new ArrayList<>();
        if (order == 0) {
            res = list.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
        } else {
            res = list.stream().sorted(Comparator.comparing(Student::getScore)).collect(Collectors.toList());
        }
        for (Student student : res) {
            System.out.println(student.getName() + " " + student.getScore());
        }
    }

    static class Student{
        String name;
        Integer score;
        public Student(){}

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }
    }
}

package 面试题;

import org.aspectj.weaver.ast.Var;

import java.util.Objects;

public class HashCodeEquals {
    public static void main(String[] args) {
        Student tony1 = new Student(1, "Tony");
        Student tony2 = new Student(1, "Tony");
        System.out.println(tony2.equals(tony1));
        System.out.println(tony2 == tony1);
        System.out.println(tony1.hashCode());
        System.out.println(tony2.hashCode());
    }
}

class Student {

    int id;

    String name;

    public Student (int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

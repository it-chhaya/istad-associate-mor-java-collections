package co.istad.collectionframework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListWithOOP {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Dara");
        student1.setGender("Male");
        student1.setScore(90.99);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Kanha");
        student2.setGender("Female");
        student2.setScore(95.99);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        for (Student student : students) {
            System.out.println("------------------");
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getGender());
            System.out.println(student.getScore());
        }
    }
}

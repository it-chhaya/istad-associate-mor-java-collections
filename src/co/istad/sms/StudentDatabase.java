package co.istad.sms;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {

    private List<Student> students;

    public StudentDatabase() {
        students = new ArrayList<>();

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

        students.add(student1);
        students.add(student2);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getStudentsDesc() {
        return students.reversed();
    }

    private Integer autoId() {
        return students.size() + 1;
    }

    public void addStudent(Student student) {
        student.setId(autoId());
        students.add(student);
    }

}

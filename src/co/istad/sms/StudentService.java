package co.istad.sms;

import java.util.List;

public interface StudentService {

    void deleteStudentById(Integer id);

    void updateStudentById(Integer id, Student newStudent);

    void addStudent(Student student);
    List<Student> findAll();
    Student findStudentById(Integer id);
    List<Student> findStudentByName(String name);
    List<Student> findStudentByGender(String gender);
    List<Student> findStudentByScore(Double score, Boolean order);

}

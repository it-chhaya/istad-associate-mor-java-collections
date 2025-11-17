package co.istad.sms;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements
StudentService {

    // Variant 2
    private final StudentDatabase studentDatabase;

    public StudentServiceImpl() {
        studentDatabase = new StudentDatabase();
    }


    @Override
    public void addStudent(Student student) {
        studentDatabase.addStudent(student);
    }


    @Override
    public List<Student> findAll() {
        return studentDatabase.getStudentsDesc();
    }


    @Override
    public Student findStudentById(Integer id) {

        Optional<Student> foundStudent = studentDatabase
                .getStudents()
                .stream()
                .filter(student -> {
                    System.out.println(student.getId());
                    return student.getId().equals(id);
                })
                .findFirst();

        System.out.println("foundStudent: " + foundStudent);

        if (foundStudent.isPresent())
            return foundStudent.get();
        else {
            DisplayUtil.printf("Student ID = %d not found", id);
            return null;
        }

    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentDatabase
                .getStudents()
                .stream()
                .filter(student -> student.getName().toLowerCase()
                        .contains(name.toLowerCase()))
                .toList();
    }

    @Override
    public List<Student> findStudentByGender(String gender) {
        return studentDatabase
                .getStudents()
                .stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .toList();
    }

    @Override
    public List<Student> findStudentByScore(Double score, Boolean order) {
        return studentDatabase
                .getStudents()
                .stream()
                .filter(student -> {
                    if (order) { // Bigger or Equal
                        return student.getScore() >= score;
                    } else { // Smaller or Equal
                        return student.getScore() <= score;
                    }
                })
                .toList();
    }
}

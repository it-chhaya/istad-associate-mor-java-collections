package co.istad.sms;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    // Variant 2
    private final StudentDatabase studentDatabase;

    public StudentServiceImpl() {
        studentDatabase = new StudentDatabase();
    }


    @Override
    public void deleteStudentById(Integer id) {
        // TODO
        List<Student> students = studentDatabase.getStudents()
                .stream()
                .filter(student -> !student.getId().equals(id))
                .collect(Collectors.toList());
        studentDatabase.setStudents(students);
    }

    @Override
    public void updateStudentById(Integer id, Student newStudent) {
        List<Student> students = studentDatabase.getStudents()
                .stream()
                .peek(student -> {
                    if (student.getId().equals(id)) {
                        student.setName(newStudent.getName());
                        student.setGender(newStudent.getGender());
                        student.setScore(newStudent.getScore());
                    }
                })
                .collect(Collectors.toList());
        studentDatabase.setStudents(students);
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

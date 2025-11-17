package co.istad.sms;

import java.util.List;

public class SmsApp {
    public static void main(String[] args) {

        StudentService studentService = new StudentServiceImpl();

        do {
            System.out.println("--------------");
            System.out.println(DisplayUtil.MENU);

            Integer menuNo = InputUtil.getInteger("Enter menu no: ");

            switch (menuNo) {
                case 1 -> {
                    DisplayUtil.print("Student List", true);
                    DisplayUtil.table(studentService.findAll());
                }
                case 2 -> {
                    DisplayUtil.print("Search student by ID, NAME, GENDER, SCORE", true);
                    DisplayUtil.print("1. ID", true);
                    DisplayUtil.print("2. NAME", true);
                    DisplayUtil.print("3. GENDER", true);
                    DisplayUtil.print("4. SCORE", true);
                    int option = InputUtil.getInteger("Enter option to search: ");

                    switch (option) {
                        case 1 -> {
                            int idForSearch = InputUtil.getInteger("Enter ID: ");
                            Student foundStudent = studentService.findStudentById(idForSearch);
                            DisplayUtil.table(foundStudent);
                        }
                        case 2 -> {
                            String nameForSearch = InputUtil.getText("Enter NAME: ");
                            List<Student> foundStudents = studentService
                                    .findStudentByName(nameForSearch);
                            DisplayUtil.table(foundStudents);
                        }
                        case 3 -> {
                            DisplayUtil.print("1. Female", true);
                            DisplayUtil.print("2. Male", true);
                            int genderOpt = InputUtil.getInteger("Enter option: ");
                            String foundGender = "";
                            if (genderOpt == 1)
                                foundGender = "female";
                            else if(genderOpt == 2) {
                                foundGender = "male";
                            } else {
                                System.out.println("Gender option is invalid..!");
                            }
                            List<Student> students = studentService.findStudentByGender(foundGender);
                            DisplayUtil.table(students);
                        }
                        case 4 -> {
                            Double scoreForSearch = InputUtil.getDouble("Enter SCORE: ");
                            DisplayUtil.print("1. ASC", true);
                            DisplayUtil.print("2. DESC", true);
                            int scoreOpt = InputUtil.getInteger("Enter option: ");
                            Boolean isOrder = null;
                            if (scoreOpt == 1)
                                isOrder = true;
                            else if(scoreOpt == 2) {
                                isOrder = false;
                            } else {
                                System.out.println("Order option is invalid..!");
                            }
                            List<Student> students = studentService.findStudentByScore(scoreForSearch, isOrder);
                            DisplayUtil.table(students);
                        }
                        default -> throw new IllegalStateException();
                    }
                }
                case 3 -> {
                    DisplayUtil.print("Add new student", true);
                    String name = InputUtil.getText("Enter name: ");
                    String gender = InputUtil.getText("Enter gender: ");
                    Double score = InputUtil.getDouble("Enter score: ");
                    Student newStudent = new Student(name, gender, score);
                    studentService.addStudent(newStudent);
                    DisplayUtil.showSuccessMsg("Student added");
                }
                case 4 -> {
                    DisplayUtil.print("Update student by ID", true);
                    Integer id = InputUtil.getInteger("Enter ID: ");
                    String name = InputUtil.getText("Enter name: ");
                    String gender = InputUtil.getText("Enter gender: ");
                    Double score = InputUtil.getDouble("Enter score: ");
                    Student newStudent = new Student(name, gender, score);
                    studentService.updateStudentById(id, newStudent);
                    DisplayUtil.showSuccessMsg("Student updated");
                }
                case 5 -> {
                    DisplayUtil.print("Delete student by ID", true);
                    Integer id = InputUtil.getInteger("Enter ID: ");
                    studentService.deleteStudentById(id);
                    DisplayUtil.showSuccessMsg("Student deleted");
                }
                case 0 -> System.exit(0);
                default -> throw new IllegalStateException();
            }
        } while (true);

    }
}

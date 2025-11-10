package co.istad.sms;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;

public class SmsApp {
    public static void main(String[] args) {

        StudentDatabase studentDb = new StudentDatabase();

        do {
            System.out.println("--------------");
            System.out.println(DisplayUtil.MENU);

            Integer menuNo = InputUtil.getInteger("Enter menu no: ");

            switch (menuNo) {
                case 1 -> {
                    DisplayUtil.print("Student List");
                    Table table = new Table(4, BorderStyle.UNICODE_ROUND_BOX_WIDE);
                    table.addCell("ID");
                    table.addCell("NAME");
                    table.addCell("GENDER");
                    table.addCell("SCORE");
                    for (Student student : studentDb.getStudentsDesc()) {
                        table.addCell(student.getId().toString());
                        table.addCell(student.getName());
                        table.addCell(student.getGender());
                        table.addCell(student.getScore().toString());
                    }
                    DisplayUtil.print(table.render());
                }
                case 2 -> {
                    DisplayUtil.print("Search student by ID, NAME, GENDER, SCORE");
                }
                case 3 -> {
                    DisplayUtil.print("Add new student");
                    String name = InputUtil.getText("Enter name: ");
                    String gender = InputUtil.getText("Enter gender: ");
                    Double score = InputUtil.getDouble("Enter score: ");
                    Student newStudent = new Student(name, gender, score);
                    studentDb.addStudent(newStudent);
                    DisplayUtil.showSuccessMsg("Student added");
                }
                case 4 -> {
                    System.out.println("Update student by ID");
                }
                case 5 -> {
                    System.out.println("Delete student by ID");
                }
                case 0 -> System.exit(0);
                default -> throw new IllegalStateException();
            }
        } while (true);

    }
}

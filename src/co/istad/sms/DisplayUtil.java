package co.istad.sms;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class DisplayUtil {
    public final static String MENU = """
            Student Management System
            1. List students
            2. Search student (ID, NAME, GENDER, SCORE)
            3. Add new student
            4. Update student by ID
            5. Delete student by ID
            0. Exit application
            """;

    public static void showSuccessMsg(String prefix) {
        System.out.println(prefix + " successfully");
    }

    public static void print(String text, boolean isNewLine) {
        if (isNewLine)
            System.out.println(text);
        else
            System.out.print(text);
    }

    public static void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }

    public static void table(Student student) {
        Table table = new Table(4, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("ID");
        table.addCell("NAME");
        table.addCell("GENDER");
        table.addCell("SCORE");
        table.addCell(student.getId().toString());
        table.addCell(student.getName());
        table.addCell(student.getGender());
        table.addCell(student.getScore().toString());
        DisplayUtil.print(table.render(), true);
    }

    public static void table(List<Student> students) {
        Table table = new Table(4, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("ID");
        table.addCell("NAME");
        table.addCell("GENDER");
        table.addCell("SCORE");
        for (Student student : students) {
            table.addCell(student.getId().toString());
            table.addCell(student.getName());
            table.addCell(student.getGender());
            table.addCell(student.getScore().toString());
        }
        DisplayUtil.print(table.render(), true);
    }
}

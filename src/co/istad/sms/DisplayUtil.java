package co.istad.sms;

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

    public static void print(String text) {
        System.out.println(text);
    }
}

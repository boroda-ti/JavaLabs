package org.example.lab5.view;

import org.example.lab5.model.Student;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class StudentView {

    private static final Locale UKRAINIAN = Locale.of("uk");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final String ROW_FORMAT = "%-4s %-38s %-12s %-10s%n";

    public void showMenu() {
        System.out.println("\nВведіть номер місяця (1-12) або 0 для виходу:");
    }

    public void showStudents(Month month, List<Student> students) {
        String monthName = month.getDisplayName(TextStyle.FULL_STANDALONE, UKRAINIAN);
        if (students.isEmpty()) {
            System.out.println("У місяці \"" + monthName + "\" немає студентів з днем народження.");
            return;
        }
        System.out.println("Студенти, що народилися в місяці \"" + monthName + "\" ("
                + students.size() + "):");
        System.out.printf(ROW_FORMAT, "ID", "ПІБ", "Дата нар.", "Залікова");
        for (Student student : students) {
            System.out.printf(ROW_FORMAT, student.getId(), student.getFullName(),
                    student.getBirthDate().format(DATE_FORMAT), student.getRecordBookNumber());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
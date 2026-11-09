package org.example.lab5.controller;

import org.example.lab5.dao.StudentDao;
import org.example.lab5.model.Student;
import org.example.lab5.view.StudentView;

import java.sql.SQLException;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

public class StudentController {

    private static final int EXIT_CODE = 0;

    private final StudentDao studentDao;
    private final StudentView view;
    private final Scanner scanner;

    public StudentController(StudentDao studentDao, StudentView view, Scanner scanner) {
        this.studentDao = studentDao;
        this.view = view;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            view.showMenu();
            if (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    return;
                }
                scanner.next();
                view.showMessage("Помилка! Введіть ціле число.");
                continue;
            }
            int monthNumber = scanner.nextInt();
            if (monthNumber == EXIT_CODE) {
                view.showMessage("Роботу завершено.");
                return;
            }
            if (monthNumber < 1 || monthNumber > 12) {
                view.showMessage("Номер місяця має бути від 1 до 12.");
                continue;
            }
            showStudentsBornIn(Month.of(monthNumber));
        }
    }

    private void showStudentsBornIn(Month month) {
        try {
            List<Student> students = studentDao.findByBirthMonth(month);
            view.showStudents(month, students);
        } catch (SQLException e) {
            view.showMessage("Помилка роботи з базою даних: " + e.getMessage());
        }
    }
}
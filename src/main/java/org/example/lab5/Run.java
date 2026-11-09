package org.example.lab5;

import org.example.lab5.controller.StudentController;
import org.example.lab5.dao.JdbcStudentDao;
import org.example.lab5.db.DatabaseConnector;
import org.example.lab5.view.StudentView;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        DatabaseConnector connector = new DatabaseConnector();
        JdbcStudentDao studentDao = new JdbcStudentDao(connector);
        StudentController controller =
                new StudentController(studentDao, new StudentView(), new Scanner(System.in));
        controller.run();
    }
}
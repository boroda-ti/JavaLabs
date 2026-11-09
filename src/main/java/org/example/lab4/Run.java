package org.example.lab4;

import org.example.lab4.controller.*;
import org.example.lab4.json.JsonManager;
import org.example.lab4.model.*;

import java.io.IOException;
import java.nio.file.Path;

public class Run {

    private static final Path JSON_FILE = Path.of("university.json");
    private static final String UNIVERSITY_NAME = "Національний технічний університет";
    private static final int FACULTY_COUNT = 2;
    private static final int DEPARTMENTS_PER_FACULTY = 2;
    private static final int GROUPS_PER_DEPARTMENT = 2;
    private static final int STUDENTS_PER_GROUP = 3;

    public static void main(String[] args) throws IOException {
        JsonManager jsonManager = new JsonManager();

        University oldUniversity = createTypicalUniversity();
        jsonManager.writeToFile(oldUniversity, JSON_FILE);
        System.out.println("Університет записано у файл: " + JSON_FILE.toAbsolutePath());

        University newUniversity = jsonManager.readFromFile(JSON_FILE);
        System.out.println("Університет зчитано з файлу:");
        printUniversity(newUniversity);

        System.out.println("\noldUniversity.equals(newUniversity) = "
                + oldUniversity.equals(newUniversity));
    }

    public static University createTypicalUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator(humanCreator);
        GroupCreator groupCreator =
                new GroupCreator(studentCreator, humanCreator, STUDENTS_PER_GROUP);
        DepartmentCreator departmentCreator =
                new DepartmentCreator(groupCreator, humanCreator, GROUPS_PER_DEPARTMENT);
        FacultyCreator facultyCreator =
                new FacultyCreator(departmentCreator, humanCreator, DEPARTMENTS_PER_FACULTY);
        UniversityCreator universityCreator =
                new UniversityCreator(facultyCreator, humanCreator, FACULTY_COUNT);
        return universityCreator.create(UNIVERSITY_NAME);
    }

    private static void printUniversity(University university) {
        System.out.println("Університет: " + university);
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("  " + faculty);
            for (Department department : faculty.getDepartments()) {
                System.out.println("    " + department);
                for (Group group : department.getGroups()) {
                    System.out.println("      Група " + group);
                    for (Student student : group.getStudents()) {
                        System.out.println("        - " + student);
                    }
                }
            }
        }
    }
}
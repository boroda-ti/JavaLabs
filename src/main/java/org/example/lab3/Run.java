package org.example.lab3;

import org.example.lab3.controller.DepartmentCreator;
import org.example.lab3.controller.FacultyCreator;
import org.example.lab3.controller.GroupCreator;
import org.example.lab3.controller.HumanCreator;
import org.example.lab3.controller.StudentCreator;
import org.example.lab3.controller.UniversityCreator;
import org.example.lab3.model.Department;
import org.example.lab3.model.Faculty;
import org.example.lab3.model.Group;
import org.example.lab3.model.Student;
import org.example.lab3.model.University;

public class Run {

    private static final String UNIVERSITY_NAME = "Національний технічний університет";
    private static final int FACULTY_COUNT = 2;
    private static final int DEPARTMENTS_PER_FACULTY = 2;
    private static final int GROUPS_PER_DEPARTMENT = 2;
    private static final int STUDENTS_PER_GROUP = 3;

    public static void main(String[] args) {
        University university = createTypicalUniversity();
        printUniversity(university);
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
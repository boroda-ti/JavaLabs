package org.example.lab4.controller;

import org.example.lab4.controller.Creator;
import org.example.lab4.controller.DepartmentCreator;
import org.example.lab4.controller.HumanCreator;
import org.example.lab4.model.Department;
import org.example.lab4.model.Faculty;
import org.example.lab4.model.Human;


public class FacultyCreator extends UnitCreator<Faculty, Department> {

    private static final String[] FACULTY_NAMES = {
        "Факультет комп'ютерних наук", "Економічний факультет",
        "Факультет прикладної математики"
    };

    public FacultyCreator(Creator<Department> departmentCreator, HumanCreator humanCreator,
                          int departmentCount) {
        super(departmentCreator, humanCreator, FACULTY_NAMES, departmentCount);
    }

    @Override
    protected Faculty createUnit(String name, Human head) {
        return new Faculty(name, head);
    }
}
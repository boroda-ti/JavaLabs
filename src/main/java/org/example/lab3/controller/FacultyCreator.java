package org.example.lab3.controller;

import org.example.lab3.controller.Creator;
import org.example.lab3.controller.DepartmentCreator;
import org.example.lab3.controller.HumanCreator;
import org.example.lab3.controller.UnitCreator;
import org.example.lab3.model.Department;
import org.example.lab3.model.Faculty;
import org.example.lab3.model.Human;

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
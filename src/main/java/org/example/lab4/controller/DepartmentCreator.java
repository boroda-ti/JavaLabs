package org.example.lab4.controller;

import org.example.lab4.controller.HumanCreator;
import org.example.lab4.model.Department;
import org.example.lab4.model.Group;
import org.example.lab4.model.Human;

public class DepartmentCreator extends UnitCreator<Department, Group> {

    private static final String[] DEPARTMENT_NAMES = {
        "Кафедра системного аналізу", "Кафедра програмної інженерії",
        "Кафедра економічної кібернетики", "Кафедра вищої математики"
    };

    public DepartmentCreator(Creator<Group> groupCreator, HumanCreator humanCreator,
                             int groupCount) {
        super(groupCreator, humanCreator, DEPARTMENT_NAMES, groupCount);
    }

    @Override
    protected Department createUnit(String name, Human head) {
        return new Department(name, head);
    }
}
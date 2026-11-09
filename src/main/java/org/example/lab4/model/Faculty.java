package org.example.lab4.model;

import org.example.lab4.model.CompositeUnit;
import org.example.lab4.model.Department;
import org.example.lab4.model.Human;

import java.util.List;

public class Faculty extends CompositeUnit<Department> {

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public List<Department> getDepartments() {
        return getSubunits();
    }
}
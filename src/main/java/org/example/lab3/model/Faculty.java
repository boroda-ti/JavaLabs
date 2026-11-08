package org.example.lab3.model;

import org.example.lab3.model.CompositeUnit;
import org.example.lab3.model.Department;
import org.example.lab3.model.Human;

import java.util.List;

public class Faculty extends CompositeUnit<Department> {

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public List<Department> getDepartments() {
        return getSubunits();
    }
}
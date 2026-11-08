package org.example.lab3.model;

import org.example.lab3.model.CompositeUnit;
import org.example.lab3.model.Human;
import org.example.lab3.model.Student;

import java.util.List;

public class Group extends CompositeUnit<Student> {

    public Group(String name, Human head) {
        super(name, head);
    }

    public List<Student> getStudents() {
        return getSubunits();
    }
}
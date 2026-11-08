package org.example.lab3.model;

import org.example.lab3.model.Human;

import java.util.List;

public class Department extends CompositeUnit<Group> {

    public Department(String name, Human head) {
        super(name, head);
    }

    public List<Group> getGroups() {
        return getSubunits();
    }
}
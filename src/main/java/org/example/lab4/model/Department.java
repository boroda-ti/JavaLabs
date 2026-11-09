package org.example.lab4.model;

import java.util.List;

public class Department extends CompositeUnit<Group> {

    public Department(String name, Human head) {
        super(name, head);
    }

    public List<Group> getGroups() {
        return getSubunits();
    }
}
package org.example.lab4.model;

import java.util.List;

public class University extends CompositeUnit<Faculty> {

    public University(String name, Human head) {
        super(name, head);
    }

    public List<Faculty> getFaculties() {
        return getSubunits();
    }
}
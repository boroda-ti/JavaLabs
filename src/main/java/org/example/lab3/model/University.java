package org.example.lab3.model;

import org.example.lab3.model.Human;

import java.util.List;

public class University extends CompositeUnit<Faculty> {

    public University(String name, Human head) {
        super(name, head);
    }

    public List<Faculty> getFaculties() {
        return getSubunits();
    }
}
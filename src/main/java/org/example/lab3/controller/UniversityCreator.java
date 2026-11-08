package org.example.lab3.controller;

import org.example.lab3.model.Faculty;
import org.example.lab3.model.Human;
import org.example.lab3.model.University;

public class UniversityCreator extends UnitCreator<University, Faculty> {

    private static final String[] UNIVERSITY_NAMES = {
        "Національний університет"
    };

    public UniversityCreator(Creator<Faculty> facultyCreator, HumanCreator humanCreator,
                             int facultyCount) {
        super(facultyCreator, humanCreator, UNIVERSITY_NAMES, facultyCount);
    }

    @Override
    protected University createUnit(String name, Human head) {
        return new University(name, head);
    }
}
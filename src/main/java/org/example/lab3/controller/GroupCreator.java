package org.example.lab3.controller;

import org.example.lab3.controller.Creator;
import org.example.lab3.controller.HumanCreator;
import org.example.lab3.controller.StudentCreator;
import org.example.lab3.controller.UnitCreator;
import org.example.lab3.model.Group;
import org.example.lab3.model.Human;
import org.example.lab3.model.Student;

public class GroupCreator extends UnitCreator<Group, Student> {

    private static final String[] GROUP_NAMES = {
        "СА-41", "СА-42", "ПІ-41", "ПІ-42", "ЕК-41", "ЕК-42", "ВМ-41", "ВМ-42"
    };

    public GroupCreator(Creator<Student> studentCreator, HumanCreator humanCreator,
                        int studentCount) {
        super(studentCreator, humanCreator, GROUP_NAMES, studentCount);
    }

    @Override
    protected Group createUnit(String name, Human head) {
        return new Group(name, head);
    }
}
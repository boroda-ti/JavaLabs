package org.example.lab4.controller;

import org.example.lab4.controller.HumanCreator;
import org.example.lab4.model.Human;
import org.example.lab4.model.Student;

public class StudentCreator implements Creator<Student> {

    private static final String RECORD_BOOK_PREFIX = "ЗК-";

    private final HumanCreator humanCreator;
    private int recordBookCounter;

    public StudentCreator(HumanCreator humanCreator) {
        this.humanCreator = humanCreator;
    }

    @Override
    public Student create() {
        Human human = humanCreator.create();
        return new Student(human.getFirstName(), human.getLastName(), human.getPatronymic(),
                human.getSex(), nextRecordBookNumber());
    }

    private String nextRecordBookNumber() {
        recordBookCounter++;
        return RECORD_BOOK_PREFIX + String.format("%05d", recordBookCounter);
    }
}
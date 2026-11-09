package org.example.lab4.model;

import org.example.lab4.model.Human;

import java.util.Objects;

public class Student extends Human {

    private String recordBookNumber;

    public Student(String firstName, String lastName, String patronymic, Sex sex,
                   String recordBookNumber) {
        super(firstName, lastName, patronymic, sex);
        this.recordBookNumber = recordBookNumber;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(String recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(recordBookNumber, student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordBookNumber);
    }

    @Override
    public String toString() {
        return getFullName() + ", залікова книжка № " + recordBookNumber;
    }
}
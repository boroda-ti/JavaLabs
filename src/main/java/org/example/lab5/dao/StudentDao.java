package org.example.lab5.dao;

import org.example.lab5.model.Student;

import java.sql.SQLException;
import java.time.Month;
import java.util.List;

public interface StudentDao {
    List<Student> findByBirthMonth(Month month) throws SQLException;
}
package org.example.lab4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.example.lab4.controller.DepartmentCreator;
import org.example.lab4.controller.FacultyCreator;
import org.example.lab4.controller.GroupCreator;
import org.example.lab4.controller.HumanCreator;
import org.example.lab4.controller.StudentCreator;
import org.example.lab4.controller.UniversityCreator;
import org.example.lab4.json.JsonManager;
import org.example.lab4.model.University;

class UniversityJsonTest {

    private static final int SUBUNITS_COUNT = 2;

    @TempDir
    Path tempDir;

    @Test
    void universityRestoredFromJsonFileEqualsOriginal() throws IOException {
        University oldUniversity = createUniversity();
        JsonManager jsonManager = new JsonManager();
        Path file = tempDir.resolve("university.json");

        jsonManager.writeToFile(oldUniversity, file);
        University newUniversity = jsonManager.readFromFile(file);

        assertTrue(Files.exists(file));
        assertNotSame(oldUniversity, newUniversity);
        assertEquals(oldUniversity, newUniversity);
        assertTrue(oldUniversity.equals(newUniversity));
    }

    private University createUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator(humanCreator);
        GroupCreator groupCreator =
                new GroupCreator(studentCreator, humanCreator, SUBUNITS_COUNT);
        DepartmentCreator departmentCreator =
                new DepartmentCreator(groupCreator, humanCreator, SUBUNITS_COUNT);
        FacultyCreator facultyCreator =
                new FacultyCreator(departmentCreator, humanCreator, SUBUNITS_COUNT);
        UniversityCreator universityCreator =
                new UniversityCreator(facultyCreator, humanCreator, SUBUNITS_COUNT);
        return universityCreator.create("Тестовий університет");
    }
}
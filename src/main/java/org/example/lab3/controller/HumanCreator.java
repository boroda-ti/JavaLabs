package org.example.lab3.controller;

import org.example.lab3.model.Human;
import org.example.lab3.model.Sex;

import java.util.Random;

public class HumanCreator implements Creator<Human> {

    private static final String[] MALE_FIRST_NAMES = {
        "Олександр", "Андрій", "Дмитро", "Максим", "Іван", "Сергій", "Богдан", "Тарас"
    };
    private static final String[] FEMALE_FIRST_NAMES = {
        "Олена", "Марія", "Анна", "Ірина", "Юлія", "Катерина", "Софія", "Наталія"
    };
    private static final String[] LAST_NAMES = {
        "Шевченко", "Коваленко", "Бондаренко", "Ткаченко", "Кравченко", "Мельник",
        "Савчук", "Поліщук", "Литвиненко", "Мороз", "Руденко", "Гончаренко"
    };
    private static final String[] MALE_PATRONYMICS = {
        "Олександрович", "Іванович", "Петрович", "Сергійович", "Миколайович", "Васильович"
    };
    private static final String[] FEMALE_PATRONYMICS = {
        "Олександрівна", "Іванівна", "Петрівна", "Сергіївна", "Миколаївна", "Василівна"
    };

    private final Random random = new Random();

    @Override
    public Human create() {
        Sex sex = random.nextBoolean() ? Sex.MALE : Sex.FEMALE;
        String firstName = pickRandom(sex == Sex.MALE ? MALE_FIRST_NAMES : FEMALE_FIRST_NAMES);
        String patronymic = pickRandom(sex == Sex.MALE ? MALE_PATRONYMICS : FEMALE_PATRONYMICS);
        return create(firstName, pickRandom(LAST_NAMES), patronymic, sex);
    }

    public Human create(String firstName, String lastName, String patronymic, Sex sex) {
        return new Human(firstName, lastName, patronymic, sex);
    }

    private String pickRandom(String[] values) {
        return values[random.nextInt(values.length)];
    }
}
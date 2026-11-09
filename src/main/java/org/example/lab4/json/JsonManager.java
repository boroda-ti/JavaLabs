package org.example.lab4.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.lab4.model.University;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonManager {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public String toJson(University university) {
        return gson.toJson(university);
    }

    public University fromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    public void writeToFile(University university, Path file) throws IOException {
        Files.writeString(file, toJson(university), StandardCharsets.UTF_8);
    }

    public University readFromFile(Path file) throws IOException {
        String json = Files.readString(file, StandardCharsets.UTF_8);
        return fromJson(json);
    }
}
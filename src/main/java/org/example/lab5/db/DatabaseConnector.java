package org.example.lab5.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {

    private static final String PROPERTIES_FILE = "db.properties";

    private final String url;
    private final String user;
    private final String password;

    public DatabaseConnector() {
        Properties properties = loadProperties();
        this.url = properties.getProperty("db.url");
        this.user = properties.getProperty("db.user");
        this.password = properties.getProperty("db.password");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new IllegalStateException("Не знайдено файл " + PROPERTIES_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Помилка читання " + PROPERTIES_FILE, e);
        }
        return properties;
    }
}
package com.softServe.ivko.config;

import com.softServe.ivko.exception.ApplicationException;
import org.apache.commons.lang3.CharUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class PropertiesManager {
    private static final String PROPERTY_FILE_NAME = "application.properties";
    private static PropertiesManager Instance;
    private Properties properties;

    private PropertiesManager() {
    }

    public static PropertiesManager getInstance() {
        if (Instance == null) {
            Instance = new PropertiesManager();
        }
        return Instance;
    }

    public Properties getApplicationProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream stream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(PROPERTY_FILE_NAME)) {
                properties.load(stream);
            } catch (IOException e) {
                throw new ApplicationException("Failed to load property file", e);
            }
        }
        return properties;
    }

    public static char charExpression(int a) {
        char c;
        c = (char)a;
        return c;
    }

    public static void main(String[] args) {
        System.out.println(charExpression(29));
    }
}
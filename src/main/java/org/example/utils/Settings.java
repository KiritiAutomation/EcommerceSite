package org.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {

    private static final Properties globalProperties=loadGlobalProperties();
    private static final Properties scriptConfigProperties=loadScriptConfigProperties();


    private static Properties loadGlobalProperties(){
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "//src//test//resources//Global.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }



    private static Properties loadScriptConfigProperties(){
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "//src//test//resources//scriptConfig.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }


    public static String getGlobalProperty(String key) {

        return globalProperties.getProperty(key);
    }

    public static String getGlobalProperty(String key, String defaultValue) {
        return globalProperties.getProperty(key, defaultValue);
    }


    public static int getGlobalPropertyAsInt(String key) {

        String value = globalProperties.getProperty(key);
        return Integer.parseInt(value);
    }

    public static int getGlobalPropertyAsInt(String key, int defaultValue) {
        try {
            String value = globalProperties.getProperty(key);
            return value != null ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static int getScriptConfigPropertyAsInt(String key) {

        String value = scriptConfigProperties.getProperty(key);
        return Integer.parseInt(value);
    }
}

package org.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Settings {

    private static final Properties globalProperties=loadGlobalProperties();


    public static Properties getInstanceGlobal(){
        return globalProperties;
    }
    private static Properties loadGlobalProperties(){
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "//src//test//resources//Global.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}

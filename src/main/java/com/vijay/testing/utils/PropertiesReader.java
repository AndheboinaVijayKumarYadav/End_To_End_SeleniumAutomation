package com.vijay.testing.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final Logger logger = LogManager.getLogger(PropertiesReader.class);
    private static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/data.properties";

    // reading the properties from the data.properties file
    public static String readKey(String key) {
        Properties p = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            p.load(fileInputStream);
            String value = p.getProperty(key);

            if (value == null) {
                logger.warn("Key '{}' not found in properties file.", key);
            } else {
                logger.info("Successfully read key '{}': {}", key, value);
            }
            return value;
        }
        catch (IOException e) {
            logger.error("Error reading properties file: " + FILE_PATH, e);
            throw new RuntimeException("Failed to read property: " + key, e);
        }

    }

}

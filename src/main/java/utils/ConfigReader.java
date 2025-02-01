package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Static block to load the properties file when the class is loaded
    static {
        properties = new Properties();
        loadProperties();
    }

    // Method to load properties from the file
    private static void loadProperties() {
        try {
            // Path to the properties file
            String filePath = "src/test/resources/config.properties";

            // Create a FileInputStream to read the file
            FileInputStream input = new FileInputStream(filePath);

            // Load the properties from the file
            properties.load(input);

            // Close the input stream
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }

    // Method to get a property value by key
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties file.");
        }
        return value;
    }

    // Method to get a property value with a default value if the key is not found
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}

package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config/config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties not found at "
                        + "C:\\Users\\VARUN REDDY\\eclipse-workspace\\ECommerce\\src\\main\\resources\\config\\config.properties");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read config.properties", e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Property '" + key
                    + "' not found in config.properties");
        }

        return value.trim();
    }
}

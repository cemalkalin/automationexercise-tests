package com.cemalkalin.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

    private static Properties prop;

    /**
     * This method will read the properties file
     *
     * @param filePath
     */

    public static void readProperties (String filePath){
        try{
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /// This method will return the value for a specific key
    ///
    /// @param key
    /// @return String value
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}

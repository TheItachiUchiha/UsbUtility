package com.usb.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads a properties file which contains details of the application
 */
public class PropertiesUtil extends Properties {

    private static PropertiesUtil instance = null;

    protected PropertiesUtil() {

    }

    @Override
    public synchronized void load(InputStream inStream) throws IOException {
        super.load(inStream);
    }

    public static String getValue(String key) {
        try {
            if (null == instance) {
                instance = new PropertiesUtil();
                instance.load(PropertiesUtil.class.getResourceAsStream("/properties/application.properties"));
            }
        } catch (IOException iox){
            iox.printStackTrace();
        }
        return instance.get(key).toString();
    }
}

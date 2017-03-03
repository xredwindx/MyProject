package com.my.util.com;

/**
 * Created on 2017-03-03.
 */
public class CommonConfig {
    private static String localeDefault = "en";

    public static String getLocaleDefault() {
        return localeDefault;
    }

    public static void setLocaleDefault(String localeDefault) {
        CommonConfig.localeDefault = localeDefault;
    }
}

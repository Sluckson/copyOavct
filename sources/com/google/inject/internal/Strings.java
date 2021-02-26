package com.google.inject.internal;

public class Strings {
    private Strings() {
    }

    public static String capitalize(String str) {
        char charAt;
        char upperCase;
        if (str.length() == 0 || (charAt = str.charAt(0)) == (upperCase = Character.toUpperCase(charAt))) {
            return str;
        }
        return upperCase + str.substring(1);
    }
}

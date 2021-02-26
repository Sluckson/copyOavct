package com.google.android.apps.analytics.easytracking;

interface ParameterLoader {
    boolean getBoolean(String str);

    int getInt(String str, int i);

    String getString(String str);
}

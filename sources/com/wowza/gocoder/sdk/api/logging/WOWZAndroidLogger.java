package com.wowza.gocoder.sdk.api.logging;

import android.util.Log;

/* compiled from: GoCoderSDK */
public class WOWZAndroidLogger extends WOWZLogger {

    /* renamed from: a */
    private static volatile WOWZAndroidLogger f3819a = new WOWZAndroidLogger();

    public static WOWZAndroidLogger getInstance() {
        return f3819a;
    }

    WOWZAndroidLogger() {
    }

    public void verbose(String str, String str2) {
        Log.v(str, str2);
    }

    public void info(String str, String str2) {
        Log.i(str, str2);
    }

    public void debug(String str, String str2) {
        Log.d(str, str2);
    }

    public void warn(String str, String str2) {
        Log.w(str, str2);
    }

    public void error(String str, String str2) {
        Log.e(str, str2);
    }

    public void error(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    public void error(String str, Throwable th) {
        Log.wtf(str, th);
    }
}

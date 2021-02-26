package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger {
    static final Logger DEFAULT_LOGGER = new Logger(TAG);
    public static final String TAG = "FirebaseCrashlytics";
    private int logLevel = 4;
    private final String tag;

    public Logger(String str) {
        this.tag = str;
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    private boolean canLog(int i) {
        return this.logLevel <= i || Log.isLoggable(this.tag, i);
    }

    /* renamed from: d */
    public void mo33258d(String str, Throwable th) {
        if (canLog(3)) {
            Log.d(this.tag, str, th);
        }
    }

    /* renamed from: v */
    public void mo33266v(String str, Throwable th) {
        if (canLog(2)) {
            Log.v(this.tag, str, th);
        }
    }

    /* renamed from: i */
    public void mo33262i(String str, Throwable th) {
        if (canLog(4)) {
            Log.i(this.tag, str, th);
        }
    }

    /* renamed from: w */
    public void mo33268w(String str, Throwable th) {
        if (canLog(5)) {
            Log.w(this.tag, str, th);
        }
    }

    /* renamed from: e */
    public void mo33260e(String str, Throwable th) {
        if (canLog(6)) {
            Log.e(this.tag, str, th);
        }
    }

    /* renamed from: d */
    public void mo33257d(String str) {
        mo33258d(str, (Throwable) null);
    }

    /* renamed from: v */
    public void mo33265v(String str) {
        mo33266v(str, (Throwable) null);
    }

    /* renamed from: i */
    public void mo33261i(String str) {
        mo33262i(str, (Throwable) null);
    }

    /* renamed from: w */
    public void mo33267w(String str) {
        mo33268w(str, (Throwable) null);
    }

    /* renamed from: e */
    public void mo33259e(String str) {
        mo33260e(str, (Throwable) null);
    }

    public void log(int i, String str) {
        log(i, str, false);
    }

    public void log(int i, String str, boolean z) {
        if (z || canLog(i)) {
            Log.println(i, this.tag, str);
        }
    }
}

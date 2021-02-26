package com.wowza.gocoder.sdk.api.logging;

import com.wowza.gocoder.sdk.api.errors.WOWZError;

/* compiled from: GoCoderSDK */
public final class WOWZLog {
    public static final String DEFAULT_LOGGING_TAG = "GoCoderSDK";
    public static boolean LOGGING_ENABLED = false;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    public static final int MAX_LOG_LEVEL = 5;
    public static final int MIN_LOG_LEVEL = 1;

    /* renamed from: a */
    private static WOWZLogger f3820a;

    public static boolean isValidLogLevel(int i) {
        return i >= 1 && i <= 5;
    }

    public static void registerLogger(WOWZLogger wOWZLogger) {
        f3820a = wOWZLogger;
    }

    public static void unregisterLogger(WOWZLogger wOWZLogger) {
        if (f3820a == wOWZLogger) {
            f3820a = null;
        }
    }

    public static WOWZLogger getLogger() {
        return f3820a;
    }

    public static void verbose(String str, String str2) {
        WOWZLogger wOWZLogger = f3820a;
        if (wOWZLogger != null && LOGGING_ENABLED) {
            wOWZLogger.verbose(str, str2);
        }
    }

    public static void verbose(String str) {
        verbose(DEFAULT_LOGGING_TAG, str);
    }

    public static void info(String str, String str2) {
        WOWZLogger wOWZLogger = f3820a;
        if (wOWZLogger != null && LOGGING_ENABLED) {
            wOWZLogger.info(str, str2);
        }
    }

    public static void info(String str) {
        info(DEFAULT_LOGGING_TAG, str);
    }

    public static void debug(String str, String str2) {
        WOWZLogger wOWZLogger = f3820a;
        if (wOWZLogger != null && LOGGING_ENABLED) {
            wOWZLogger.debug(str, str2);
        }
    }

    public static void debug(String str) {
        debug(DEFAULT_LOGGING_TAG, str);
    }

    public static void warn(String str, String str2) {
        WOWZLogger wOWZLogger = f3820a;
        if (wOWZLogger != null) {
            wOWZLogger.warn(str, str2);
        }
    }

    public static void warn(String str) {
        warn(DEFAULT_LOGGING_TAG, str);
    }

    public static void warn(String str, WOWZError wOWZError) {
        warn(str, wOWZError.getErrorDescription());
    }

    public static void warn(WOWZError wOWZError) {
        warn(DEFAULT_LOGGING_TAG, wOWZError);
    }

    public static void error(String str, String str2) {
        WOWZLogger wOWZLogger = f3820a;
        if (wOWZLogger != null) {
            wOWZLogger.error(str, str2);
        }
    }

    public static void error(String str, String str2, Throwable th) {
        WOWZLogger wOWZLogger = f3820a;
        if (wOWZLogger != null) {
            wOWZLogger.error(str, str2, th);
        }
    }

    public static void error(String str) {
        error(DEFAULT_LOGGING_TAG, str);
    }

    public static void error(String str, WOWZError wOWZError) {
        if (wOWZError.getException() != null) {
            error(str, wOWZError.getErrorDescription(), (Throwable) wOWZError.getException());
        } else {
            error(str, wOWZError.getErrorDescription());
        }
    }

    public static void error(String str, WOWZError wOWZError, Throwable th) {
        error(str, wOWZError.getErrorDescription(), th);
    }

    public static void error(WOWZError wOWZError, Throwable th) {
        error(DEFAULT_LOGGING_TAG, wOWZError.getErrorDescription(), th);
    }

    public static void error(WOWZError wOWZError) {
        error(DEFAULT_LOGGING_TAG, wOWZError);
    }

    public static void error(String str, Throwable th) {
        WOWZLogger wOWZLogger = f3820a;
        if (wOWZLogger != null) {
            wOWZLogger.error(str, th);
        }
    }

    public static void error(Throwable th) {
        error(DEFAULT_LOGGING_TAG, th);
    }
}

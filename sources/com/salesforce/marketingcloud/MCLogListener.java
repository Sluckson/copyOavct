package com.salesforce.marketingcloud;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MCKeep
public interface MCLogListener {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    @MCKeep
    public static class AndroidLogListener implements MCLogListener {
        public void out(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i == 6) {
                                if (th == null) {
                                    Log.e(str, str2);
                                } else {
                                    Log.e(str, str2, th);
                                }
                            }
                        } else if (th == null) {
                            Log.w(str, str2);
                        } else {
                            Log.w(str, str2, th);
                        }
                    } else if (th == null) {
                        Log.i(str, str2);
                    } else {
                        Log.i(str, str2, th);
                    }
                } else if (th == null) {
                    Log.d(str, str2);
                } else {
                    Log.d(str, str2, th);
                }
            } else if (th == null) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, th);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.MCLogListener$a */
    public @interface C3834a {
    }

    void out(int i, @NonNull String str, @NonNull String str2, @Nullable Throwable th);
}

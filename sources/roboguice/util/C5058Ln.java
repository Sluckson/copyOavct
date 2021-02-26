package roboguice.util;

import android.content.Context;
import android.util.Log;
import com.google.inject.Inject;
import java.text.SimpleDateFormat;

/* renamed from: roboguice.util.Ln */
public class C5058Ln {
    @Inject
    protected static BaseConfig config = new BaseConfig();
    @Inject
    protected static Print print = new Print();

    /* renamed from: roboguice.util.Ln$Config */
    public interface Config {
        int getLoggingLevel();

        void setLoggingLevel(int i);
    }

    public static String logLevelToString(int i) {
        switch (i) {
            case 2:
                return "VERBOSE";
            case 3:
                return "DEBUG";
            case 4:
                return "INFO";
            case 5:
                return "WARN";
            case 6:
                return "ERROR";
            case 7:
                return "ASSERT";
            default:
                return "UNKNOWN";
        }
    }

    private C5058Ln() {
    }

    /* renamed from: v */
    public static int m4839v(Throwable th) {
        if (config.minimumLogLevel <= 2) {
            return print.println(2, Log.getStackTraceString(th));
        }
        return 0;
    }

    /* renamed from: v */
    public static int m4838v(Object obj, Object... objArr) {
        if (config.minimumLogLevel > 2) {
            return 0;
        }
        String strings = Strings.toString(obj);
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        return print.println(2, strings);
    }

    /* renamed from: v */
    public static int m4840v(Throwable th, Object obj, Object... objArr) {
        if (config.minimumLogLevel > 2) {
            return 0;
        }
        String strings = Strings.toString(obj);
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        sb.append(strings);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        return print.println(2, sb.toString());
    }

    /* renamed from: d */
    public static int m4830d(Throwable th) {
        if (config.minimumLogLevel <= 3) {
            return print.println(3, Log.getStackTraceString(th));
        }
        return 0;
    }

    /* renamed from: d */
    public static int m4829d(Object obj, Object... objArr) {
        if (config.minimumLogLevel > 3) {
            return 0;
        }
        String strings = Strings.toString(obj);
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        return print.println(3, strings);
    }

    /* renamed from: d */
    public static int m4831d(Throwable th, Object obj, Object... objArr) {
        if (config.minimumLogLevel > 3) {
            return 0;
        }
        String strings = Strings.toString(obj);
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        sb.append(strings);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        return print.println(3, sb.toString());
    }

    /* renamed from: i */
    public static int m4836i(Throwable th) {
        if (config.minimumLogLevel <= 4) {
            return print.println(4, Log.getStackTraceString(th));
        }
        return 0;
    }

    /* renamed from: i */
    public static int m4835i(Object obj, Object... objArr) {
        if (config.minimumLogLevel > 4) {
            return 0;
        }
        String strings = Strings.toString(obj);
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        return print.println(4, strings);
    }

    /* renamed from: i */
    public static int m4837i(Throwable th, Object obj, Object... objArr) {
        if (config.minimumLogLevel > 4) {
            return 0;
        }
        String strings = Strings.toString(obj);
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        sb.append(strings);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        return print.println(4, sb.toString());
    }

    /* renamed from: w */
    public static int m4842w(Throwable th) {
        if (config.minimumLogLevel <= 5) {
            return print.println(5, Log.getStackTraceString(th));
        }
        return 0;
    }

    /* renamed from: w */
    public static int m4841w(Object obj, Object... objArr) {
        if (config.minimumLogLevel > 5) {
            return 0;
        }
        String strings = Strings.toString(obj);
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        return print.println(5, strings);
    }

    /* renamed from: w */
    public static int m4843w(Throwable th, Object obj, Object... objArr) {
        if (config.minimumLogLevel > 5) {
            return 0;
        }
        String strings = Strings.toString(obj);
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        sb.append(strings);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        return print.println(5, sb.toString());
    }

    /* renamed from: e */
    public static int m4833e(Throwable th) {
        if (config.minimumLogLevel <= 6) {
            return print.println(6, Log.getStackTraceString(th));
        }
        return 0;
    }

    /* renamed from: e */
    public static int m4832e(Object obj, Object... objArr) {
        if (config.minimumLogLevel > 6) {
            return 0;
        }
        String strings = Strings.toString(obj);
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        return print.println(6, strings);
    }

    /* renamed from: e */
    public static int m4834e(Throwable th, Object obj, Object... objArr) {
        if (config.minimumLogLevel > 6) {
            return 0;
        }
        String strings = Strings.toString(obj);
        StringBuilder sb = new StringBuilder();
        if (objArr.length > 0) {
            strings = String.format(strings, objArr);
        }
        sb.append(strings);
        sb.append(10);
        sb.append(Log.getStackTraceString(th));
        return print.println(6, sb.toString());
    }

    public static boolean isDebugEnabled() {
        return config.minimumLogLevel <= 3;
    }

    public static boolean isVerboseEnabled() {
        return config.minimumLogLevel <= 2;
    }

    public static Config getConfig() {
        return config;
    }

    /* renamed from: roboguice.util.Ln$BaseConfig */
    public static class BaseConfig implements Config {
        protected int minimumLogLevel = 2;
        protected String packageName = "";
        protected String scope = "";

        protected BaseConfig() {
        }

        @Inject
        public BaseConfig(Context context) {
            int i = 2;
            try {
                this.packageName = context.getPackageName();
                if ((context.getPackageManager().getApplicationInfo(this.packageName, 0).flags & 2) == 0) {
                    i = 4;
                }
                this.minimumLogLevel = i;
                this.scope = this.packageName.toUpperCase();
                C5058Ln.m4829d("Configuring Logging, minimum log level is %s", C5058Ln.logLevelToString(this.minimumLogLevel));
            } catch (Exception e) {
                Log.e(this.packageName, "Error configuring logger", e);
            }
        }

        public int getLoggingLevel() {
            return this.minimumLogLevel;
        }

        public void setLoggingLevel(int i) {
            this.minimumLogLevel = i;
        }
    }

    /* renamed from: roboguice.util.Ln$Print */
    public static class Print {
        public int println(int i, String str) {
            return Log.println(i, getScope(), processMessage(str));
        }

        /* access modifiers changed from: protected */
        public String processMessage(String str) {
            if (C5058Ln.config.minimumLogLevel > 3) {
                return str;
            }
            return String.format("%s %s %s", new Object[]{new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis())), Thread.currentThread().getName(), str});
        }

        protected static String getScope() {
            if (C5058Ln.config.minimumLogLevel > 3) {
                return C5058Ln.config.scope;
            }
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            return C5058Ln.config.scope + "/" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber();
        }
    }
}

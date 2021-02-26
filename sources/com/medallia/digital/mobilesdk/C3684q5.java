package com.medallia.digital.mobilesdk;

import android.text.format.DateFormat;
import java.util.Calendar;

/* renamed from: com.medallia.digital.mobilesdk.q5 */
public class C3684q5 {

    /* renamed from: a */
    private static final String f1679a = "yyyy-MM-dd";

    /* renamed from: b */
    private static final String f1680b = "HH:mm:ss";

    /* renamed from: com.medallia.digital.mobilesdk.q5$a */
    protected static class C3685a {

        /* renamed from: a */
        protected static final int f1681a = 1024;

        /* renamed from: b */
        protected static final int f1682b = 1048576;

        /* renamed from: c */
        private static final double f1683c = 8.0d;

        /* renamed from: d */
        protected static final double f1684d = 7.62939453125E-6d;

        protected C3685a() {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.q5$b */
    protected static class C3686b {

        /* renamed from: a */
        public static final long f1685a = 1000;

        /* renamed from: b */
        public static final long f1686b = 60000;

        /* renamed from: c */
        public static final long f1687c = 3600000;

        /* renamed from: d */
        public static final long f1688d = 86400000;

        protected C3686b() {
        }
    }

    /* renamed from: a */
    protected static String m1500a(long j) {
        return m1501a(j, "yyyy-MM-dd HH:mm:ss");
    }

    /* renamed from: a */
    private static String m1501a(long j, String str) {
        if (j <= 0) {
            return "";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return DateFormat.format(str, instance).toString();
    }

    /* renamed from: b */
    public static String m1502b(long j) {
        return m1501a(j, f1680b);
    }
}

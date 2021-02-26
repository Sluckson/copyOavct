package com.medallia.digital.mobilesdk;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.e3 */
class C3490e3 implements C3713r5 {

    /* renamed from: d */
    private static final String f1033d = "com.medallia.digital";

    /* renamed from: e */
    private static final int f1034e = 3;

    /* renamed from: f */
    protected static C3490e3 f1035f;

    /* renamed from: a */
    private SimpleDateFormat f1036a = new SimpleDateFormat("dd-MM HH:mm:ss.SSS", Locale.US);

    /* renamed from: b */
    private MDLogLevel f1037b;

    /* renamed from: c */
    private C3492b f1038c;

    /* renamed from: com.medallia.digital.mobilesdk.e3$a */
    static /* synthetic */ class C3491a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1039a = new int[MDLogLevel.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.medallia.digital.mobilesdk.MDLogLevel[] r0 = com.medallia.digital.mobilesdk.MDLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1039a = r0
                int[] r0 = f1039a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.MDLogLevel r1 = com.medallia.digital.mobilesdk.MDLogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1039a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.MDLogLevel r1 = com.medallia.digital.mobilesdk.MDLogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1039a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.medallia.digital.mobilesdk.MDLogLevel r1 = com.medallia.digital.mobilesdk.MDLogLevel.WARN     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f1039a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.medallia.digital.mobilesdk.MDLogLevel r1 = com.medallia.digital.mobilesdk.MDLogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f1039a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.medallia.digital.mobilesdk.MDLogLevel r1 = com.medallia.digital.mobilesdk.MDLogLevel.FATAL     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3490e3.C3491a.<clinit>():void");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.e3$b */
    protected interface C3492b {
        /* renamed from: a */
        void mo55335a(String str);
    }

    private C3490e3() {
        MDLogLevel mDLogLevel = MDLogLevel.OFF;
        this.f1037b = mDLogLevel;
        this.f1037b = mDLogLevel;
    }

    /* renamed from: a */
    protected static C3490e3 m657a() {
        if (f1035f == null) {
            f1035f = new C3490e3();
        }
        return f1035f;
    }

    /* renamed from: a */
    private String m658a(MDLogLevel mDLogLevel, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[3];
        return String.format(Locale.US, "%s [%s][%s][%s:%d]%s> %s", new Object[]{this.f1036a.format(new Date()), mDLogLevel.toString(), Thread.currentThread(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()), stackTraceElement.getMethodName(), str});
    }

    /* renamed from: a */
    public static void m659a(String str) {
        C3490e3 a = m657a();
        MDLogLevel mDLogLevel = MDLogLevel.DEBUG;
        a.m660b(mDLogLevel, "Clear and Disconnect - " + str);
    }

    /* renamed from: b */
    private void m660b(MDLogLevel mDLogLevel, String str) {
        if (!this.f1037b.equals(MDLogLevel.OFF) && this.f1037b.getLevel() >= mDLogLevel.getLevel()) {
            String a = m658a(mDLogLevel, str);
            m662c(mDLogLevel, a);
            C3492b bVar = this.f1038c;
            if (bVar != null) {
                bVar.mo55335a(a);
            }
        }
    }

    /* renamed from: b */
    public static void m661b(String str) {
        m657a().m660b(MDLogLevel.DEBUG, str);
    }

    /* renamed from: c */
    private void m662c(MDLogLevel mDLogLevel, String str) {
        int i = C3491a.f1039a[mDLogLevel.ordinal()];
        if (i == 1) {
            Log.d(f1033d, str);
        } else if (i == 2) {
            Log.i(f1033d, str);
        } else if (i == 3) {
            Log.w(f1033d, str);
        } else if (i == 4) {
            Log.e(f1033d, str);
        } else if (i == 5) {
            Log.wtf(f1033d, str);
        }
    }

    /* renamed from: c */
    public static void m663c(String str) {
        m657a().m660b(MDLogLevel.ERROR, str);
    }

    /* renamed from: d */
    public static void m664d(String str) {
        m657a().m660b(MDLogLevel.FATAL, str);
    }

    /* renamed from: e */
    public static void m665e(String str) {
        m657a().m660b(MDLogLevel.INFO, str);
    }

    /* renamed from: f */
    public static void m666f(String str) {
        m657a().m660b(MDLogLevel.WARN, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55333a(MDLogLevel mDLogLevel) {
        this.f1037b = mDLogLevel;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55334a(C3492b bVar) {
        this.f1038c = bVar;
    }

    public void clearAndDisconnect() {
        m659a(C3490e3.class.getSimpleName());
        f1035f = null;
    }
}

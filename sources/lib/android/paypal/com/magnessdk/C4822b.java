package lib.android.paypal.com.magnessdk;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* renamed from: lib.android.paypal.com.magnessdk.b */
final class C4822b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static C4822b f5529a;

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f5530b = Thread.getDefaultUncaughtExceptionHandler();

    private C4822b() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    public static synchronized C4822b m4651a() {
        C4822b bVar;
        synchronized (C4822b.class) {
            if (f5529a == null) {
                f5529a = new C4822b();
            }
            bVar = f5529a;
        }
        return bVar;
    }

    /* renamed from: a */
    public static void m4652a(Throwable th) {
        th.printStackTrace(new PrintWriter(new StringWriter()));
    }

    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace(new PrintWriter(new StringWriter()));
        m4652a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f5530b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}

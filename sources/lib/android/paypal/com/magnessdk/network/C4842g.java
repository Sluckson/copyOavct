package lib.android.paypal.com.magnessdk.network;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: lib.android.paypal.com.magnessdk.network.g */
final class C4842g {

    /* renamed from: a */
    private static final Object f5773a = new Object();

    /* renamed from: b */
    private static C4842g f5774b;

    /* renamed from: c */
    private ThreadPoolExecutor f5775c;

    private C4842g() {
        try {
            this.f5775c = new ThreadPoolExecutor(10, 10, 60000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(256), new ThreadPoolExecutor.DiscardPolicy());
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static C4842g m4732a() {
        C4842g gVar;
        synchronized (f5773a) {
            if (f5774b == null) {
                f5774b = new C4842g();
            }
            gVar = f5774b;
        }
        return gVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo68935a(C4841f fVar) {
        this.f5775c.execute(fVar);
    }
}

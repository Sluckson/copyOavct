package com.medallia.digital.mobilesdk;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.medallia.digital.mobilesdk.h5 */
class C3561h5 {

    /* renamed from: c */
    private static C3561h5 f1268c;

    /* renamed from: a */
    private final Executor f1269a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private final Executor f1270b = new C3563b();

    /* renamed from: com.medallia.digital.mobilesdk.h5$b */
    private static class C3563b implements Executor {

        /* renamed from: a */
        private Handler f1271a;

        private C3563b() {
            this.f1271a = new Handler(Looper.getMainLooper());
        }

        public void execute(@NonNull Runnable runnable) {
            this.f1271a.post(runnable);
        }
    }

    private C3561h5() {
    }

    /* renamed from: c */
    static C3561h5 m954c() {
        if (f1268c == null) {
            f1268c = new C3561h5();
        }
        return f1268c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Executor mo55465a() {
        return this.f1269a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Executor mo55466b() {
        return this.f1270b;
    }
}

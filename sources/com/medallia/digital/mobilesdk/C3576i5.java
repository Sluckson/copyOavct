package com.medallia.digital.mobilesdk;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.medallia.digital.mobilesdk.i5 */
class C3576i5<T> {

    /* renamed from: d */
    private static final long f1303d = 10;

    /* renamed from: e */
    private static final long f1304e = 10000;

    /* renamed from: a */
    private long f1305a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C3579b f1306b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f1307c = -1;

    /* renamed from: com.medallia.digital.mobilesdk.i5$a */
    class C3577a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ Object f1308a;

        /* renamed from: com.medallia.digital.mobilesdk.i5$a$a */
        class C3578a extends C3666p3 {
            C3578a() {
            }

            /* renamed from: a */
            public void mo55177a() {
                C3576i5.this.f1306b.mo55348a(C3577a.this.f1308a);
                long unused = C3576i5.this.f1307c = -1;
            }
        }

        C3577a(Object obj) {
            this.f1308a = obj;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3561h5.m954c().mo55465a().execute(new C3578a());
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.i5$b */
    protected interface C3579b<T> {
        /* renamed from: a */
        void mo55348a(T t);
    }

    protected C3576i5(long j, C3579b bVar) {
        this.f1305a = (j < 0 || j > f1304e) ? 10000 : j;
        this.f1306b = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55488a(T t) {
        if (this.f1307c != -1) {
            return false;
        }
        this.f1307c = System.currentTimeMillis() + this.f1305a;
        new Handler(Looper.getMainLooper()).postDelayed(new C3577a(t), this.f1305a);
        return true;
    }
}

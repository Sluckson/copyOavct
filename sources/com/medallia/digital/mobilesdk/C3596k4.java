package com.medallia.digital.mobilesdk;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.medallia.digital.mobilesdk.C3461c3;
import com.medallia.digital.mobilesdk.C3474d0;
import com.medallia.digital.mobilesdk.C3667p4;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.k4 */
class C3596k4 implements C3461c3.C3469h {

    /* renamed from: p */
    private static final int f1379p = 401;

    /* renamed from: q */
    private static final double f1380q = 2.0d;

    /* renamed from: a */
    private C3667p4.C3668a f1381a;

    /* renamed from: b */
    private C3474d0.C3478d f1382b;

    /* renamed from: c */
    private String f1383c;

    /* renamed from: d */
    private int f1384d;

    /* renamed from: e */
    private int f1385e;

    /* renamed from: f */
    private ExecutorService f1386f;

    /* renamed from: g */
    private HashMap<String, String> f1387g;

    /* renamed from: h */
    private JSONObject f1388h;

    /* renamed from: i */
    private C3667p4.C3669b f1389i;

    /* renamed from: j */
    private C3474d0 f1390j;

    /* renamed from: k */
    private int f1391k;

    /* renamed from: l */
    private long f1392l;

    /* renamed from: m */
    private long f1393m;

    /* renamed from: n */
    private Handler f1394n;

    /* renamed from: o */
    private C3666p3 f1395o;

    /* renamed from: com.medallia.digital.mobilesdk.k4$a */
    class C3597a extends C3666p3 {
        C3597a() {
        }

        /* renamed from: a */
        public void mo55177a() {
            C3596k4.this.m1066d();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.k4$b */
    class C3598b implements C3667p4.C3668a {
        C3598b() {
        }

        /* renamed from: a */
        public void mo55240a() {
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            C3596k4.this.mo55516a(j4Var);
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            C3596k4.this.mo55517a(l4Var);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.k4$c */
    class C3599c implements C3667p4.C3668a {
        C3599c() {
        }

        /* renamed from: a */
        public void mo55240a() {
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            C3596k4.this.mo55516a(j4Var);
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            C3596k4.this.mo55517a(l4Var);
        }
    }

    C3596k4() {
        this.f1391k = 0;
        this.f1394n = new Handler(Looper.getMainLooper());
        this.f1395o = new C3597a();
        C3461c3.m562g().mo55265a((C3461c3.C3469h) this);
    }

    C3596k4(ExecutorService executorService, C3667p4.C3669b bVar, C3474d0.C3478d dVar, String str, HashMap<String, String> hashMap, JSONObject jSONObject, int i, int i2, C3667p4.C3668a aVar, long j) {
        this();
        mo55518a(executorService, bVar, dVar, str, hashMap, jSONObject, i, i2, aVar, j);
        mo55515a();
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    /* renamed from: d */
    public void m1066d() {
        C3490e3.m661b("Retrying: " + this.f1391k + "/" + this.f1384d + " (" + this.f1390j.mo55302d() + ")");
        try {
            this.f1386f.submit(this.f1390j);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* renamed from: e */
    private boolean m1067e() {
        return System.currentTimeMillis() - this.f1392l < this.f1393m;
    }

    /* renamed from: f */
    private boolean m1068f() {
        return m1067e() && this.f1391k > 0;
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [com.medallia.digital.mobilesdk.d0] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.medallia.digital.mobilesdk.h0] */
    /* JADX WARNING: type inference failed for: r2v3, types: [com.medallia.digital.mobilesdk.a5] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.VisibleForTesting
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo55515a() {
        /*
            r9 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r9.f1392l = r0
            com.medallia.digital.mobilesdk.p4$b r0 = r9.f1389i
            com.medallia.digital.mobilesdk.p4$b r1 = com.medallia.digital.mobilesdk.C3667p4.C3669b.String
            if (r0 != r1) goto L_0x0024
            com.medallia.digital.mobilesdk.a5 r0 = new com.medallia.digital.mobilesdk.a5
            com.medallia.digital.mobilesdk.d0$d r3 = r9.f1382b
            java.lang.String r4 = r9.f1383c
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r9.f1387g
            org.json.JSONObject r6 = r9.f1388h
            int r7 = r9.f1385e
            com.medallia.digital.mobilesdk.k4$b r8 = new com.medallia.digital.mobilesdk.k4$b
            r8.<init>()
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L_0x0021:
            r9.f1390j = r0
            goto L_0x003c
        L_0x0024:
            com.medallia.digital.mobilesdk.p4$b r1 = com.medallia.digital.mobilesdk.C3667p4.C3669b.BYTES
            if (r0 != r1) goto L_0x003c
            com.medallia.digital.mobilesdk.h0 r0 = new com.medallia.digital.mobilesdk.h0
            com.medallia.digital.mobilesdk.d0$d r3 = r9.f1382b
            java.lang.String r4 = r9.f1383c
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r9.f1387g
            int r6 = r9.f1385e
            com.medallia.digital.mobilesdk.k4$c r7 = new com.medallia.digital.mobilesdk.k4$c
            r7.<init>()
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0021
        L_0x003c:
            java.util.concurrent.ExecutorService r0 = r9.f1386f
            com.medallia.digital.mobilesdk.d0 r1 = r9.f1390j
            r0.submit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3596k4.mo55515a():void");
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55516a(C3588j4 j4Var) {
        if (j4Var.mo55503b() != 401) {
            int i = this.f1391k;
            if (i == this.f1384d) {
                C3461c3.m562g().mo55270b((C3461c3.C3469h) this);
                C3667p4.C3668a aVar = this.f1381a;
                if (aVar != null) {
                    aVar.mo55241a(j4Var);
                }
                Double d = null;
                if (this.f1382b == C3474d0.C3478d.GET) {
                    d = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                }
                AnalyticsBridge.getInstance().reportRestClientEvent(this.f1392l, System.currentTimeMillis(), this.f1383c, j4Var.mo55503b(), this.f1391k, d);
                return;
            }
            this.f1391k = i + 1;
            mo55519b();
            return;
        }
        C3461c3.m562g().mo55270b((C3461c3.C3469h) this);
        C3667p4.C3668a aVar2 = this.f1381a;
        if (aVar2 != null) {
            aVar2.mo55241a(j4Var);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55517a(C3609l4 l4Var) {
        Double d;
        int i;
        if (this.f1382b == C3474d0.C3478d.GET) {
            d = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            if (l4Var != null) {
                if (l4Var.mo55546b() != null && l4Var.mo55546b().getBytes() != null) {
                    i = l4Var.mo55546b().getBytes().length;
                } else if (l4Var.mo55545a() != null) {
                    i = l4Var.mo55545a().length;
                }
                d = Double.valueOf(((double) i) / 1024.0d);
            }
        } else {
            d = null;
        }
        AnalyticsBridge.getInstance().reportRestClientEvent(this.f1392l, System.currentTimeMillis(), this.f1383c, l4Var.mo55547c(), this.f1391k, d);
        C3461c3.m562g().mo55270b((C3461c3.C3469h) this);
        C3667p4.C3668a aVar = this.f1381a;
        if (aVar != null) {
            aVar.mo55242a(l4Var);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55518a(ExecutorService executorService, C3667p4.C3669b bVar, C3474d0.C3478d dVar, String str, HashMap<String, String> hashMap, JSONObject jSONObject, int i, int i2, C3667p4.C3668a aVar, long j) {
        this.f1389i = bVar;
        this.f1382b = dVar;
        this.f1383c = str;
        this.f1387g = hashMap;
        this.f1388h = jSONObject;
        this.f1384d = i;
        this.f1385e = i2;
        this.f1381a = aVar;
        this.f1386f = executorService;
        this.f1393m = j;
    }

    @VisibleForTesting
    /* renamed from: b */
    public void mo55519b() {
        if (!C3461c3.m562g().mo55272d()) {
            long pow = ((long) Math.pow(f1380q, (double) this.f1391k)) * 1000;
            mo55520c();
            if (this.f1394n == null) {
                this.f1394n = new Handler(Looper.getMainLooper());
            }
            this.f1394n.postDelayed(this.f1395o, pow);
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    public void mo55520c() {
        this.f1394n.removeCallbacks(this.f1395o);
        this.f1394n.removeCallbacksAndMessages((Object) null);
    }

    public void onBackground() {
        mo55520c();
    }

    public void onForeground() {
        if (m1068f()) {
            mo55519b();
        } else if (!m1067e()) {
            C3490e3.m661b("Request = " + this.f1390j.mo55302d() + " was paused because of refresh session");
        }
    }
}

package com.wowza.gocoder.sdk.support.p038e;

import android.os.Handler;
import android.os.Looper;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.api.status.WOWZStatusCallback;
import com.wowza.gocoder.sdk.support.p040g.C4300a;
import com.wowza.gocoder.sdk.support.p040g.C4301b;
import java.util.Locale;

/* renamed from: com.wowza.gocoder.sdk.support.e.b */
/* compiled from: GoCoderSDK */
abstract class C4285b implements C4301b.C4302a, Runnable {

    /* renamed from: a */
    protected static final int f4166a = 1;

    /* renamed from: b */
    protected static final int f4167b = 2;

    /* renamed from: c */
    protected static final int f4168c = 3;

    /* renamed from: d */
    protected static final int f4169d = 4;

    /* renamed from: e */
    protected static final int f4170e = -1;

    /* renamed from: A */
    private long f4171A;

    /* renamed from: B */
    private int f4172B;

    /* renamed from: C */
    private int f4173C;

    /* renamed from: D */
    private int f4174D;

    /* renamed from: E */
    private int f4175E;

    /* renamed from: F */
    private int f4176F;

    /* renamed from: G */
    private int f4177G;

    /* renamed from: H */
    private long f4178H;

    /* renamed from: I */
    private long f4179I;

    /* renamed from: J */
    private long f4180J;

    /* renamed from: K */
    private boolean f4181K;

    /* renamed from: L */
    private boolean f4182L;

    /* renamed from: M */
    private int f4183M;

    /* renamed from: N */
    private int f4184N;

    /* renamed from: O */
    private long f4185O;

    /* renamed from: P */
    private long f4186P;

    /* renamed from: Q */
    private long f4187Q;

    /* renamed from: R */
    private long f4188R;

    /* renamed from: S */
    private long f4189S;

    /* renamed from: T */
    private C4301b.C4302a f4190T = this;

    /* renamed from: f */
    protected WOWZStatus f4191f = new WOWZStatus(0);

    /* renamed from: g */
    protected boolean f4192g = false;

    /* renamed from: h */
    public boolean f4193h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WOWZStatusCallback f4194i;

    /* renamed from: j */
    private WOWZMediaConfig f4195j;

    /* renamed from: k */
    private byte[] f4196k;

    /* renamed from: l */
    private final Object f4197l = new Object();

    /* renamed from: m */
    private boolean f4198m = false;

    /* renamed from: n */
    private C4283a f4199n;

    /* renamed from: o */
    private long f4200o = 750;

    /* renamed from: p */
    private boolean f4201p;

    /* renamed from: q */
    private long f4202q;

    /* renamed from: r */
    private long f4203r;

    /* renamed from: s */
    private long f4204s;

    /* renamed from: t */
    private long f4205t;

    /* renamed from: u */
    private long f4206u;

    /* renamed from: v */
    private int f4207v;

    /* renamed from: w */
    private int f4208w;

    /* renamed from: x */
    private long f4209x;

    /* renamed from: y */
    private long f4210y;

    /* renamed from: z */
    private long f4211z;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo59133a(int i, byte[] bArr, long j, long j2, long j3, long j4);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract WOWZMediaConfig mo59135a(byte[] bArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract WOWZStatus mo59136a(WOWZMediaConfig wOWZMediaConfig, byte[] bArr);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo59137a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo59138a(int i) {
        switch (i) {
            case 1:
                return "VIDEO_IFRAME";
            case 2:
                return "VIDEO_PFRAME";
            case 3:
                return "VIDEO_BFRAME";
            case 4:
                return "VIDEO_CONFIG";
            case 5:
                return "AUDIO_SAMPLE";
            case 6:
                return "AUDIO_CONFIG";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract String mo59147b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo59148c();

    C4285b() {
        mo59182ac();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59140a(int i, String str) {
        WOWZLog.debug("DECODER STATUS: current: " + this.f4191f.toString() + ", proposed: " + i + " :: " + str);
        this.f4191f.setState(i);
        WOWZStatusCallback wOWZStatusCallback = this.f4194i;
        if (wOWZStatusCallback != null) {
            wOWZStatusCallback.onWZStatus(new WOWZStatus(i));
        }
    }

    /* renamed from: ac */
    private void mo59182ac() {
        this.f4191f.clearLastError();
        mo59140a(0, "DecoderBase.initSessionDefaults");
        this.f4195j = new WOWZMediaConfig();
        this.f4196k = null;
        this.f4201p = false;
        this.f4198m = false;
        this.f4199n = new C4283a();
        this.f4204s = -1;
        this.f4209x = -1;
        this.f4210y = -1;
        this.f4211z = -1;
        this.f4171A = -1;
        this.f4202q = -1;
        this.f4203r = -1;
        this.f4205t = -1;
        this.f4206u = -1;
        this.f4207v = 0;
        this.f4208w = 0;
        this.f4172B = 0;
        this.f4173C = 0;
        this.f4174D = 0;
        this.f4175E = 0;
        this.f4176F = 0;
        this.f4177G = 0;
        this.f4178H = 0;
        this.f4179I = 0;
        this.f4180J = 0;
        this.f4186P = -1;
        this.f4187Q = -1;
        this.f4185O = -1;
        this.f4188R = 0;
        this.f4189S = 0;
        this.f4183M = 0;
        this.f4184N = 0;
        this.f4181K = false;
        this.f4182L = false;
    }

    /* renamed from: d */
    public String mo59149d() {
        return mo59147b();
    }

    /* renamed from: e */
    public WOWZStatusCallback mo59150e() {
        return this.f4194i;
    }

    /* renamed from: a */
    public void mo59142a(WOWZStatusCallback wOWZStatusCallback) {
        synchronized (this) {
            this.f4194i = wOWZStatusCallback;
        }
    }

    /* renamed from: f */
    public WOWZStatus mo59151f() {
        return this.f4191f;
    }

    /* renamed from: g */
    public WOWZMediaConfig mo59152g() {
        return this.f4195j;
    }

    /* renamed from: h */
    public C4301b.C4302a mo59153h() {
        return this.f4190T;
    }

    /* renamed from: a */
    public void mo59143a(C4301b.C4302a aVar) {
        if (aVar == null) {
            aVar = this;
        }
        this.f4190T = aVar;
    }

    /* renamed from: i */
    public long mo59154i() {
        return this.f4200o;
    }

    /* renamed from: a */
    public synchronized void mo59141a(long j) {
        if (this.f4191f.isIdle()) {
            this.f4200o += j;
        } else {
            WOWZLog.warn(mo59137a(), "The pre-roll buffer duration cannot be set while the decoder is running.");
        }
    }

    /* renamed from: j */
    public boolean mo59155j() {
        return !this.f4198m;
    }

    /* renamed from: k */
    public long mo59156k() {
        return this.f4202q;
    }

    /* renamed from: l */
    public long mo59157l() {
        return this.f4203r;
    }

    /* renamed from: m */
    public long mo59158m() {
        long j;
        long j2;
        if (this.f4191f.isRunning()) {
            j = System.currentTimeMillis();
            j2 = this.f4202q;
        } else {
            j = this.f4203r;
            if (j == -1) {
                return 0;
            }
            j2 = this.f4202q;
        }
        return j - j2;
    }

    /* renamed from: n */
    public long mo59159n() {
        return this.f4205t;
    }

    /* renamed from: o */
    public long mo59160o() {
        return this.f4205t;
    }

    /* renamed from: p */
    public long mo59161p() {
        return this.f4206u;
    }

    /* renamed from: q */
    public long mo59162q() {
        return this.f4206u - this.f4205t;
    }

    /* renamed from: r */
    public long mo59163r() {
        return (long) this.f4207v;
    }

    /* renamed from: s */
    public long mo59165s() {
        return (long) this.f4208w;
    }

    /* renamed from: t */
    public long mo59166t() {
        try {
            if (this.f4199n != null) {
                return this.f4199n.mo59099e();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: u */
    public long mo59167u() {
        C4283a aVar = this.f4199n;
        if (aVar != null) {
            return aVar.mo59100f();
        }
        return 0;
    }

    /* renamed from: v */
    public int mo59168v() {
        long m = mo59158m() - this.f4189S;
        if (m > 0) {
            return (int) Math.floor((double) (((float) (this.f4208w * 8)) / (((float) m) / 1000.0f)));
        }
        return 0;
    }

    /* renamed from: w */
    public long mo59169w() {
        return this.f4209x;
    }

    /* renamed from: x */
    public long mo59170x() {
        return this.f4210y;
    }

    /* renamed from: y */
    public long mo59171y() {
        long j;
        long j2;
        if (this.f4191f.isRunning()) {
            j = System.currentTimeMillis();
            j2 = this.f4209x;
        } else {
            j = this.f4210y;
            if (j == -1) {
                return 0;
            }
            j2 = this.f4209x;
        }
        return j - j2;
    }

    /* renamed from: z */
    public long mo59172z() {
        return this.f4211z;
    }

    /* renamed from: A */
    public long mo59107A() {
        return this.f4171A;
    }

    /* renamed from: B */
    public long mo59108B() {
        return this.f4171A - this.f4211z;
    }

    /* renamed from: C */
    public int mo59109C() {
        return this.f4172B;
    }

    /* renamed from: D */
    public int mo59110D() {
        return this.f4173C;
    }

    /* renamed from: E */
    public int mo59111E() {
        long y = mo59171y() - this.f4189S;
        if (y > 0) {
            return (int) Math.floor((double) (((float) (this.f4173C * 8)) / (((float) y) / 1000.0f)));
        }
        return 0;
    }

    /* renamed from: F */
    public int mo59112F() {
        return this.f4174D;
    }

    /* renamed from: G */
    public int mo59113G() {
        return this.f4175E;
    }

    /* renamed from: H */
    public int mo59114H() {
        return this.f4177G;
    }

    /* renamed from: I */
    public long mo59115I() {
        return this.f4178H;
    }

    /* renamed from: J */
    public long mo59116J() {
        return this.f4179I;
    }

    /* renamed from: K */
    public long mo59117K() {
        return this.f4180J;
    }

    /* renamed from: L */
    public long mo59118L() {
        long j = this.f4179I;
        if (j > 0) {
            return (long) ((int) Math.floor((double) (((float) this.f4207v) / ((float) j))));
        }
        return 0;
    }

    /* renamed from: M */
    public float mo59119M() {
        long j = this.f4179I;
        if (j > 0) {
            return (((float) (this.f4206u - this.f4205t)) / 10000.0f) / ((float) j);
        }
        return 0.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r1.f4199n;
     */
    /* renamed from: N */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo59120N() {
        /*
            r1 = this;
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f4191f
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x0014
            com.wowza.gocoder.sdk.support.e.a r0 = r1.f4199n
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.mo59101g()
            if (r0 == 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p038e.C4285b.mo59120N():boolean");
    }

    /* renamed from: O */
    public int mo59121O() {
        return this.f4183M;
    }

    /* renamed from: P */
    public int mo59122P() {
        return this.f4184N;
    }

    /* renamed from: Q */
    public long mo59123Q() {
        return this.f4186P;
    }

    /* renamed from: R */
    public long mo59124R() {
        return this.f4187Q;
    }

    /* renamed from: S */
    public long mo59125S() {
        return this.f4188R;
    }

    /* renamed from: T */
    public long mo59126T() {
        return this.f4189S;
    }

    /* renamed from: U */
    public long mo59127U() {
        if (!this.f4191f.isIdle() && this.f4209x >= 0) {
            return System.currentTimeMillis() - this.f4209x;
        }
        return 0;
    }

    /* renamed from: V */
    public void mo59128V() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                C4285b.this.f4194i.onWZStatus(new WOWZStatus(12));
            }
        });
    }

    /* renamed from: W */
    public void mo59129W() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                C4285b.this.f4194i.onWZStatus(new WOWZStatus(13));
            }
        });
    }

    /* renamed from: X */
    public boolean mo59130X() {
        return this.f4191f.getState() == 3;
    }

    /* renamed from: Y */
    public void mo59131Y() {
        this.f4193h = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                C4285b.this.f4194i.onWZStatus(new WOWZStatus(10));
            }
        });
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0051 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051 A[LOOP:0: B:12:0x0051->B:84:0x0051, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r23 = this;
            r12 = r23
            r0 = 0
            r12.f4193h = r0
            com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig r1 = r12.f4195j
            byte[] r2 = r12.f4196k
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r12.mo59136a((com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig) r1, (byte[]) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "We have a preroll buffer default of "
            r2.append(r3)
            long r3 = r12.f4200o
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r2)
            boolean r2 = r1.isRunning()
            if (r2 == 0) goto L_0x01ef
            r1 = 3
            java.lang.String r2 = "DecoderBase.run"
            r12.mo59140a((int) r1, (java.lang.String) r2)
            com.wowza.gocoder.sdk.api.status.WOWZStatusCallback r1 = r12.f4194i
            if (r1 == 0) goto L_0x0038
            com.wowza.gocoder.sdk.api.status.WOWZStatus r2 = r12.f4191f
            r1.onWZStatus(r2)
        L_0x0038:
            long r1 = r12.f4200o
            r14 = 0
            int r3 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r3 <= 0) goto L_0x004e
            com.wowza.gocoder.sdk.api.status.WOWZStatusCallback r1 = r12.f4194i
            if (r1 == 0) goto L_0x004e
            com.wowza.gocoder.sdk.api.status.WOWZStatus r2 = new com.wowza.gocoder.sdk.api.status.WOWZStatus
            r3 = 12
            r2.<init>((int) r3)
            r1.onWZStatus(r2)
        L_0x004e:
            java.lang.Object r2 = r12.f4197l
            monitor-enter(r2)
        L_0x0051:
            boolean r1 = r12.f4198m     // Catch:{ all -> 0x01ec }
            if (r1 != 0) goto L_0x0063
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r12.f4191f     // Catch:{ all -> 0x01ec }
            boolean r1 = r1.isRunning()     // Catch:{ all -> 0x01ec }
            if (r1 == 0) goto L_0x0063
            java.lang.Object r1 = r12.f4197l     // Catch:{ InterruptedException -> 0x0051 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0051 }
            goto L_0x0051
        L_0x0063:
            monitor-exit(r2)     // Catch:{ all -> 0x01ec }
            long r1 = r12.f4200o
            int r3 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r3 <= 0) goto L_0x0078
            com.wowza.gocoder.sdk.api.status.WOWZStatusCallback r1 = r12.f4194i
            if (r1 == 0) goto L_0x0078
            com.wowza.gocoder.sdk.api.status.WOWZStatus r2 = new com.wowza.gocoder.sdk.api.status.WOWZStatus
            r3 = 13
            r2.<init>((int) r3)
            r1.onWZStatus(r2)
        L_0x0078:
            boolean r1 = r12.f4198m
            if (r1 == 0) goto L_0x01e5
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r12.f4191f
            boolean r1 = r1.isRunning()
            if (r1 == 0) goto L_0x01e5
            long r1 = r12.f4209x
            r10 = -1
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x00b0
            long r1 = java.lang.System.currentTimeMillis()
            r12.f4209x = r1
            java.lang.String r1 = r23.mo59137a()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Decoding loop started at "
            r2.append(r3)
            long r3 = r12.f4209x
            java.lang.String r3 = com.wowza.gocoder.sdk.support.p040g.C4300a.m4217b(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r1, r2)
        L_0x00b0:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r12.f4191f
            boolean r1 = r1.isRunning()
            if (r1 == 0) goto L_0x01df
            com.wowza.gocoder.sdk.support.e.a r1 = r12.f4199n
            com.wowza.gocoder.sdk.support.e.a$a r1 = r1.mo59097c()
            r8 = 1
            if (r1 == 0) goto L_0x01ae
            int r9 = r1.mo59103a()
            long r6 = r1.mo59104b()
            byte[] r4 = r1.mo59106d()
            long r16 = r1.mo59105c()
            int r1 = r12.f4183M
            if (r1 == 0) goto L_0x00f5
            long r1 = r12.f4187Q
            long r14 = r12.f4185O
            long r1 = r1 - r14
            long r14 = r12.f4189S
            long r14 = r14 + r1
            r12.f4189S = r14
            long r14 = r12.f4188R
            long r1 = java.lang.Math.max(r1, r14)
            r12.f4188R = r1
            int r1 = r12.f4183M
            int r2 = r12.f4184N
            int r1 = java.lang.Math.max(r1, r2)
            r12.f4184N = r1
            r12.f4183M = r0
            r12.f4185O = r10
        L_0x00f5:
            long r1 = r12.f4211z
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x00fe
            r14 = 0
            goto L_0x00ff
        L_0x00fe:
            r14 = r1
        L_0x00ff:
            long r2 = r12.f4209x
            r1 = r23
            r18 = r2
            r2 = r9
            r3 = r4
            r13 = r4
            r4 = r6
            r20 = r6
            r6 = r14
            r22 = r9
            r0 = 1
            r8 = r18
            r18 = r10
            r10 = r16
            int r1 = r1.mo59133a(r2, r3, r4, r6, r8, r10)
            r2 = -1
            if (r1 == r2) goto L_0x0195
            if (r1 == r0) goto L_0x0151
            r2 = 2
            if (r1 == r2) goto L_0x0123
            goto L_0x01d8
        L_0x0123:
            int r1 = r12.f4174D
            int r1 = r1 + r0
            r12.f4174D = r1
            int r1 = r12.f4175E
            int r2 = r13.length
            int r1 = r1 + r2
            r12.f4175E = r1
            int r1 = r12.f4176F
            int r1 = r1 + r0
            r12.f4176F = r1
            int r0 = r12.f4176F
            int r1 = r12.f4177G
            int r0 = java.lang.Math.max(r0, r1)
            r12.f4177G = r0
            r1 = r20
            long r0 = r12.mo59134a((long) r1, (long) r14)
            long r0 = java.lang.Math.abs(r0)
            long r2 = r12.f4178H
            long r0 = java.lang.Math.max(r0, r2)
            r12.f4178H = r0
            goto L_0x01d8
        L_0x0151:
            r1 = r20
            long r3 = r12.f4211z
            int r5 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r5 != 0) goto L_0x0179
            r12.f4211z = r1
            java.lang.String r3 = r23.mo59137a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "First sample timecode processed: "
            r4.append(r5)
            long r5 = r12.f4211z
            java.lang.String r5 = com.wowza.gocoder.sdk.support.p040g.C4300a.m4217b(r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r3, r4)
        L_0x0179:
            r12.f4171A = r1
            int r1 = r12.f4172B
            int r1 = r1 + r0
            r12.f4172B = r1
            int r1 = r12.f4173C
            int r2 = r13.length
            int r1 = r1 + r2
            r12.f4173C = r1
            r1 = 0
            r12.f4176F = r1
            r1 = r22
            if (r1 != r0) goto L_0x01d8
            long r0 = r12.f4180J
            r2 = 1
            long r0 = r0 + r2
            r12.f4180J = r0
            goto L_0x01d8
        L_0x0195:
            java.lang.String r0 = "DecoderBase.run[BUFFER_ACTION_ERROR]"
            r1 = 4
            r12.mo59140a((int) r1, (java.lang.String) r0)
            com.wowza.gocoder.sdk.api.status.WOWZStatusCallback r0 = r12.f4194i
            if (r0 == 0) goto L_0x01a4
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r12.f4191f
            r0.onWZError(r1)
        L_0x01a4:
            com.wowza.gocoder.sdk.api.status.WOWZStatusCallback r0 = r12.f4194i
            if (r0 == 0) goto L_0x01d8
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r12.f4191f
            r0.onWZStatus(r1)
            goto L_0x01d8
        L_0x01ae:
            r18 = r10
            r0 = 1
            long r1 = r12.f4185O
            int r3 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r3 != 0) goto L_0x01c0
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r12.f4209x
            long r1 = r1 - r3
            r12.f4185O = r1
        L_0x01c0:
            long r1 = r12.f4186P
            int r3 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r3 != 0) goto L_0x01ca
            long r1 = r12.f4185O
            r12.f4186P = r1
        L_0x01ca:
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r12.f4209x
            long r1 = r1 - r3
            r12.f4187Q = r1
            int r1 = r12.f4183M
            int r1 = r1 + r0
            r12.f4183M = r1
        L_0x01d8:
            r10 = r18
            r0 = 0
            r14 = 0
            goto L_0x00b0
        L_0x01df:
            long r0 = java.lang.System.currentTimeMillis()
            r12.f4210y = r0
        L_0x01e5:
            r23.mo59148c()
            r23.mo59132Z()
            goto L_0x0202
        L_0x01ec:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x01ec }
            throw r0
        L_0x01ef:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r12.f4191f
            com.wowza.gocoder.sdk.api.errors.WOWZError r1 = r1.getLastError()
            r2 = 4
            r0.set(r2, r1)
            com.wowza.gocoder.sdk.api.status.WOWZStatusCallback r0 = r12.f4194i
            if (r0 == 0) goto L_0x0202
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r12.f4191f
            r0.onWZStatus(r1)
        L_0x0202:
            java.lang.String r0 = "WOWZSTATE.IDLE BEING SET"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r0)
            java.lang.String r0 = "DecoderBase.run[end]"
            r1 = 0
            r12.mo59140a((int) r1, (java.lang.String) r0)
            com.wowza.gocoder.sdk.api.status.WOWZStatusCallback r0 = r12.f4194i
            if (r0 == 0) goto L_0x0216
            com.wowza.gocoder.sdk.api.status.WOWZStatus r1 = r12.f4191f
            r0.onWZStatus(r1)
        L_0x0216:
            r23.mo59183ad()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p038e.C4285b.run():void");
    }

    /* renamed from: Z */
    public void mo59132Z() {
        String a = mo59137a();
        StringBuilder sb = new StringBuilder();
        sb.append("playback stats: \n\n             decoder type: ");
        sb.append(mo59147b());
        sb.append("\n\n         playback started: ");
        sb.append(C4300a.m4217b(mo59156k()));
        sb.append("\n         playback stopped: ");
        sb.append(C4300a.m4217b(mo59157l()));
        sb.append("\n    elapsed playback time: ");
        sb.append(C4300a.m4214a(mo59158m()));
        sb.append("\n pre-roll buffer duration: ");
        sb.append(C4300a.m4214a(mo59154i()));
        sb.append("\n\n     no. buffers received: ");
        sb.append(mo59163r());
        sb.append("\n       no. bytes received: ");
        sb.append(mo59165s());
        sb.append("\n  first timecode received: ");
        sb.append(C4300a.m4214a(mo59160o()));
        sb.append("\n   last timecode received: ");
        sb.append(C4300a.m4214a(mo59161p()));
        sb.append("\n  received timecode range: ");
        sb.append(C4300a.m4214a(mo59162q()));
        sb.append("\n\n    buffers received rate: ");
        sb.append(C4300a.m4212a(mo59111E()));
        sb.append("\n\n    no. buffers processed: ");
        sb.append(mo59109C());
        sb.append("\n      no. bytes processed: ");
        sb.append(mo59110D());
        sb.append("\n first timecode processed: ");
        sb.append(C4300a.m4214a(mo59172z()));
        sb.append("\n  last timecode processed: ");
        sb.append(C4300a.m4214a(mo59107A()));
        sb.append("\n  processed timecode span: ");
        sb.append(C4300a.m4214a(mo59108B()));
        sb.append("\n   buffers processed rate: ");
        sb.append(C4300a.m4212a(mo59111E()));
        sb.append("\n\n      no. buffers dropped: ");
        sb.append(mo59112F());
        sb.append("\n        no. bytes dropped: ");
        sb.append(mo59113G());
        sb.append("\n   max. consecutive drops: ");
        sb.append(mo59114H());
        sb.append("\n         max. drop offset: ");
        sb.append(C4300a.m4214a(mo59115I()));
        sb.append("\n\n       no. buffers queued: ");
        sb.append(mo59166t());
        sb.append("\n         no. bytes queued: ");
        sb.append(mo59167u());
        sb.append("\n\n    max. starved duration: ");
        sb.append(C4300a.m4214a(mo59125S()));
        sb.append("\n  max. starved iterations: ");
        sb.append(mo59122P());
        String str = "\n";
        sb.append(str);
        if (this.f4179I > 0) {
            str = "   no. keyframes received: " + mo59116J() + "\n  no. keyframes processed: " + mo59117K() + "\n            keyframe rate: " + String.format(Locale.US, "%.2f sec", new Object[]{Float.valueOf(mo59119M())}) + "\n        keyframe interval: " + mo59118L() + str;
        }
        sb.append(str);
        sb.append("-----------------------------------------------------------------------\n");
        WOWZLog.debug(a, sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo59134a(long j, long j2) {
        return (j - j2) - mo59153h().mo59127U();
    }

    /* renamed from: b */
    public WOWZMediaConfig mo59146b(byte[] bArr) {
        if (!this.f4191f.isIdle()) {
            WOWZLog.warn(mo59137a(), "A codec config buffer was received while the decoder is running. It will be ignored.");
            return this.f4195j;
        }
        mo59182ac();
        boolean z = true;
        this.f4201p = true;
        this.f4191f.clearLastError();
        mo59140a(1, "DecoderBase.processConfigBuffer");
        WOWZStatusCallback wOWZStatusCallback = this.f4194i;
        if (wOWZStatusCallback != null) {
            wOWZStatusCallback.onWZStatus(this.f4191f);
        }
        this.f4195j = mo59135a(bArr);
        if (this.f4195j != null) {
            if (this.f4200o != 0) {
                z = false;
            }
            this.f4198m = z;
            this.f4196k = (byte[]) bArr.clone();
            new Thread(this, mo59137a()).start();
            this.f4191f.waitForState(3);
        } else {
            this.f4191f.setError(new WOWZError("Could not determine codec config from the configuration buffer received"));
            WOWZLog.error(mo59137a(), this.f4191f.getLastError());
            mo59140a(0, "DecoderBase.processConfigBuffer");
        }
        return this.f4195j;
    }

    /* renamed from: a */
    public void mo59139a(int i, long j, byte[] bArr, long j2) {
        long j3 = j;
        byte[] bArr2 = bArr;
        if (this.f4191f.isRunning()) {
            if (this.f4204s == -1) {
                this.f4204s = j3;
                WOWZLog.debug(mo59137a(), "First buffer received (type: " + mo59138a(i) + ", size: " + bArr2.length + ")");
                WOWZLog.debug(mo59137a(), "Unadjusted timecode: " + C4300a.m4214a(j) + ", adjusted timecode: " + C4300a.m4214a(j3 - this.f4204s));
            }
            long j4 = j3 - this.f4204s;
            if (this.f4202q == -1) {
                this.f4202q = System.currentTimeMillis();
                this.f4203r = this.f4202q;
            } else {
                this.f4203r = System.currentTimeMillis();
            }
            this.f4207v++;
            this.f4208w += bArr2.length;
            if (i == 1) {
                this.f4179I++;
            }
            long j5 = this.f4206u;
            if (j5 < 0 || j4 > j5) {
                if (this.f4205t == -1) {
                    this.f4205t = j4;
                }
                this.f4206u = j4;
                this.f4199n.mo59095a(i, j4, bArr, j2);
                if (!this.f4198m && this.f4199n.mo59102h() >= this.f4200o) {
                    synchronized (this.f4197l) {
                        WOWZLog.debug(mo59137a(), "Timecode of sample triggering pre-roll done was " + C4300a.m4214a(j4));
                        this.f4198m = true;
                        this.f4197l.notify();
                    }
                    return;
                }
                return;
            }
            WOWZLog.warn(mo59137a(), "A " + mo59138a(i) + " buffer was received with a timecode (" + C4300a.m4214a(j4) + "ms) less than the prior buffer's timecode (" + C4300a.m4214a(this.f4206u) + "ms). The difference was " + (this.f4206u - j4) + "ms.");
        } else if (!this.f4201p && !this.f4182L) {
            WOWZLog.warn(mo59137a(), "A media buffer was received before the codec config. This warning will only report once a session.");
            this.f4182L = true;
        } else if (!this.f4181K) {
            WOWZLog.warn(mo59137a(), "A media buffer was received but the decoder is not running. This warning will only report once a session.");
            this.f4181K = true;
        }
    }

    /* renamed from: aa */
    public void mo59144aa() {
        this.f4199n.mo59098d();
    }

    /* renamed from: ab */
    public void mo59145ab() {
        mo59140a(4, "DecoderBase.stopDecoder");
        WOWZStatusCallback wOWZStatusCallback = this.f4194i;
        if (wOWZStatusCallback != null) {
            wOWZStatusCallback.onWZStatus(this.f4191f);
        }
        synchronized (this.f4197l) {
            if (!this.f4198m) {
                this.f4198m = true;
                this.f4197l.notify();
            }
        }
    }

    /* renamed from: ad */
    private void mo59183ad() {
        C4283a aVar = this.f4199n;
        if (aVar != null) {
            aVar.mo59098d();
        }
        this.f4199n = null;
        this.f4196k = null;
        this.f4195j = null;
    }
}

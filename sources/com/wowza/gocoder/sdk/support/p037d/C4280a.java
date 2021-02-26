package com.wowza.gocoder.sdk.support.p037d;

import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.monitor.WOWZStreamingStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.wowza.gocoder.sdk.support.d.a */
/* compiled from: GoCoderSDK */
public class C4280a {

    /* renamed from: a */
    public static final int f4125a = 3;

    /* renamed from: b */
    public static final int f4126b = 3;

    /* renamed from: c */
    public static final int f4127c = 0;

    /* renamed from: d */
    public static final int f4128d = 1;

    /* renamed from: e */
    public static final int f4129e = 2;

    /* renamed from: f */
    public static final int f4130f = 3;

    /* renamed from: g */
    public static final int f4131g = 0;

    /* renamed from: h */
    public static final int f4132h = 1;

    /* renamed from: i */
    public static final int f4133i = 2;

    /* renamed from: j */
    public static final int f4134j = 3;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final String f4135k = "a";
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Object f4136l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ArrayList<WOWZStreamingStat> f4137m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ArrayList<Integer[]> f4138n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ArrayList<Integer> f4139o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ArrayList<Long> f4140p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int[] f4141q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int[] f4142r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int[] f4143s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f4144t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public volatile boolean f4145u;

    /* renamed from: v */
    private Thread f4146v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f4147w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public long f4148x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ArrayList<C4282a> f4149y;

    /* renamed from: com.wowza.gocoder.sdk.support.d.a$a */
    /* compiled from: GoCoderSDK */
    public interface C4282a {
        /* renamed from: a */
        void mo59034a(WOWZStreamingStat wOWZStreamingStat);
    }

    /* renamed from: e */
    private boolean m3835e(int i) {
        return i >= 0 && i <= 3;
    }

    /* renamed from: f */
    private boolean m3838f(int i) {
        return i >= 0 && i <= 3;
    }

    /* renamed from: i */
    private static String m3844i() {
        return "------------------------------------------------------------------------\n";
    }

    public C4280a() {
        this(3);
    }

    public C4280a(int i) {
        this.f4136l = new Object();
        this.f4141q = new int[4];
        this.f4142r = new int[4];
        this.f4143s = new int[4];
        this.f4147w = i;
        this.f4137m = new ArrayList<>();
        this.f4138n = new ArrayList<>();
        this.f4139o = new ArrayList<>();
        this.f4140p = new ArrayList<>();
        this.f4149y = new ArrayList<>();
        this.f4148x = 0;
        this.f4144t = false;
        this.f4145u = false;
    }

    /* renamed from: a */
    public int mo59079a() {
        return this.f4147w;
    }

    /* renamed from: a */
    public void mo59080a(int i) {
        this.f4147w = i;
    }

    /* renamed from: a */
    public void mo59083a(C4282a aVar) {
        if (!this.f4149y.contains(aVar)) {
            this.f4149y.add(0, aVar);
        }
    }

    /* renamed from: b */
    public void mo59087b(C4282a aVar) {
        if (this.f4149y.contains(aVar)) {
            this.f4149y.remove(aVar);
        }
    }

    /* renamed from: b */
    public void mo59084b() {
        if (!this.f4144t) {
            this.f4137m.clear();
            this.f4148x = System.currentTimeMillis();
            this.f4144t = true;
            this.f4146v = new Thread(new Runnable() {
                /* JADX WARNING: Can't wrap try/catch for region: R(3:23|24|8b) */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
                    monitor-enter(com.wowza.gocoder.sdk.support.p037d.C4280a.m3827a(r13.f4150a));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
                    com.wowza.gocoder.sdk.support.p037d.C4280a.m3832b(r13.f4150a, false);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:50:0x012f, code lost:
                    r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.m3827a(r13.f4150a);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:51:0x0135, code lost:
                    monitor-enter(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:54:0x0138, code lost:
                    if (com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcast.LOG_STAT_SUMMARY == false) goto L_0x013f;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:55:0x013a, code lost:
                    com.wowza.gocoder.sdk.support.p037d.C4280a.m3849m(r13.f4150a);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:56:0x013f, code lost:
                    com.wowza.gocoder.sdk.support.p037d.C4280a.m3831b(r13.f4150a).clear();
                    com.wowza.gocoder.sdk.support.p037d.C4280a.m3833c(r13.f4150a).clear();
                    com.wowza.gocoder.sdk.support.p037d.C4280a.m3834d(r13.f4150a).clear();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:57:0x015a, code lost:
                    monitor-exit(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:58:0x015b, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:71:0x0165, code lost:
                    com.wowza.gocoder.sdk.support.p037d.C4280a.m3829a(r13.f4150a, false);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:72:0x016a, code lost:
                    throw r0;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0085 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r13 = this;
                        com.wowza.gocoder.sdk.support.d.a r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.this
                        java.lang.Object r0 = r0.f4136l
                        monitor-enter(r0)
                        com.wowza.gocoder.sdk.support.d.a r1 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        java.util.ArrayList r1 = r1.f4138n     // Catch:{ all -> 0x016b }
                        r1.clear()     // Catch:{ all -> 0x016b }
                        com.wowza.gocoder.sdk.support.d.a r1 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        java.util.ArrayList r1 = r1.f4139o     // Catch:{ all -> 0x016b }
                        r1.clear()     // Catch:{ all -> 0x016b }
                        com.wowza.gocoder.sdk.support.d.a r1 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        java.util.ArrayList r1 = r1.f4140p     // Catch:{ all -> 0x016b }
                        r1.clear()     // Catch:{ all -> 0x016b }
                        r1 = 0
                        r2 = 0
                    L_0x0024:
                        com.wowza.gocoder.sdk.support.d.a r3 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        int[] r3 = r3.f4141q     // Catch:{ all -> 0x016b }
                        int r3 = r3.length     // Catch:{ all -> 0x016b }
                        if (r2 >= r3) goto L_0x0038
                        com.wowza.gocoder.sdk.support.d.a r3 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        int[] r3 = r3.f4141q     // Catch:{ all -> 0x016b }
                        r3[r2] = r1     // Catch:{ all -> 0x016b }
                        int r2 = r2 + 1
                        goto L_0x0024
                    L_0x0038:
                        r2 = 0
                    L_0x0039:
                        com.wowza.gocoder.sdk.support.d.a r3 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        int[] r3 = r3.f4142r     // Catch:{ all -> 0x016b }
                        int r3 = r3.length     // Catch:{ all -> 0x016b }
                        if (r2 >= r3) goto L_0x004d
                        com.wowza.gocoder.sdk.support.d.a r3 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        int[] r3 = r3.f4142r     // Catch:{ all -> 0x016b }
                        r3[r2] = r1     // Catch:{ all -> 0x016b }
                        int r2 = r2 + 1
                        goto L_0x0039
                    L_0x004d:
                        r2 = 0
                    L_0x004e:
                        com.wowza.gocoder.sdk.support.d.a r3 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        int[] r3 = r3.f4143s     // Catch:{ all -> 0x016b }
                        int r3 = r3.length     // Catch:{ all -> 0x016b }
                        if (r2 >= r3) goto L_0x0062
                        com.wowza.gocoder.sdk.support.d.a r3 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x016b }
                        int[] r3 = r3.f4143s     // Catch:{ all -> 0x016b }
                        r3[r2] = r1     // Catch:{ all -> 0x016b }
                        int r2 = r2 + 1
                        goto L_0x004e
                    L_0x0062:
                        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016b }
                        monitor-exit(r0)     // Catch:{ all -> 0x016b }
                        r0 = 0
                    L_0x0068:
                        r10 = 1
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ InterruptedException -> 0x0085 }
                        boolean unused = r4.f4145u = r10     // Catch:{ InterruptedException -> 0x0085 }
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ InterruptedException -> 0x0085 }
                        int r4 = r4.f4147w     // Catch:{ InterruptedException -> 0x0085 }
                        long r4 = (long) r4     // Catch:{ InterruptedException -> 0x0085 }
                        r6 = 1000(0x3e8, double:4.94E-321)
                        long r4 = r4 * r6
                        java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x0085 }
                    L_0x007c:
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this
                        boolean unused = r4.f4145u = r1
                        goto L_0x0093
                    L_0x0082:
                        r0 = move-exception
                        goto L_0x0165
                    L_0x0085:
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x0082 }
                        java.lang.Object r4 = r4.f4136l     // Catch:{ all -> 0x0082 }
                        monitor-enter(r4)     // Catch:{ all -> 0x0082 }
                        com.wowza.gocoder.sdk.support.d.a r5 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x0162 }
                        boolean unused = r5.f4144t = r1     // Catch:{ all -> 0x0162 }
                        monitor-exit(r4)     // Catch:{ all -> 0x0162 }
                        goto L_0x007c
                    L_0x0093:
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this
                        java.lang.Object r11 = r4.f4136l
                        monitor-enter(r11)
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        boolean r4 = r4.f4144t     // Catch:{ all -> 0x015f }
                        if (r4 == 0) goto L_0x012e
                        long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.support.d.a r6 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        long r6 = r6.f4148x     // Catch:{ all -> 0x015f }
                        long r8 = r4 - r6
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        int r4 = r4.f4147w     // Catch:{ all -> 0x015f }
                        int r4 = r4 * 1000
                        r12 = 2
                        int r4 = r4 * 2
                        long r4 = (long) r4     // Catch:{ all -> 0x015f }
                        int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                        if (r6 <= 0) goto L_0x012b
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        java.util.ArrayList r4 = r4.f4138n     // Catch:{ all -> 0x015f }
                        int r4 = r4.size()     // Catch:{ all -> 0x015f }
                        if (r4 <= 0) goto L_0x012b
                        com.wowza.gocoder.sdk.support.d.a r4 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        r5 = r2
                        r7 = r0
                        com.wowza.gocoder.sdk.api.monitor.WOWZStreamingStat r4 = r4.m3825a(r5, r7, r8)     // Catch:{ all -> 0x015f }
                        if (r4 == 0) goto L_0x012b
                        boolean r0 = com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcast.LOG_STAT_SAMPLES     // Catch:{ all -> 0x015f }
                        if (r0 == 0) goto L_0x00e3
                        java.lang.String r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.f4135k     // Catch:{ all -> 0x015f }
                        java.lang.String r2 = r4.toRow(r10)     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r0, r2)     // Catch:{ all -> 0x015f }
                    L_0x00e3:
                        com.wowza.gocoder.sdk.support.d.a r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        java.util.ArrayList r0 = r0.f4137m     // Catch:{ all -> 0x015f }
                        r0.add(r1, r4)     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.support.d.a r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        java.util.ArrayList r0 = r0.f4138n     // Catch:{ all -> 0x015f }
                        r0.clear()     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.support.d.a r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        java.util.ArrayList r0 = r0.f4139o     // Catch:{ all -> 0x015f }
                        r0.clear()     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.support.d.a r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        java.util.ArrayList r0 = r0.f4140p     // Catch:{ all -> 0x015f }
                        r0.clear()     // Catch:{ all -> 0x015f }
                        long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.support.d.a r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        int r0 = r0.mo59090d((int) r12)     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.support.d.a r5 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015f }
                        java.util.ArrayList r5 = r5.f4149y     // Catch:{ all -> 0x015f }
                        java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x015f }
                    L_0x011b:
                        boolean r6 = r5.hasNext()     // Catch:{ all -> 0x015f }
                        if (r6 == 0) goto L_0x012b
                        java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.support.d.a$a r6 = (com.wowza.gocoder.sdk.support.p037d.C4280a.C4282a) r6     // Catch:{ all -> 0x015f }
                        r6.mo59034a(r4)     // Catch:{ all -> 0x015f }
                        goto L_0x011b
                    L_0x012b:
                        monitor-exit(r11)     // Catch:{ all -> 0x015f }
                        goto L_0x0068
                    L_0x012e:
                        monitor-exit(r11)     // Catch:{ all -> 0x015f }
                        com.wowza.gocoder.sdk.support.d.a r0 = com.wowza.gocoder.sdk.support.p037d.C4280a.this
                        java.lang.Object r0 = r0.f4136l
                        monitor-enter(r0)
                        boolean r1 = com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcast.LOG_STAT_SUMMARY     // Catch:{ all -> 0x015c }
                        if (r1 == 0) goto L_0x013f
                        com.wowza.gocoder.sdk.support.d.a r1 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015c }
                        r1.m3840g()     // Catch:{ all -> 0x015c }
                    L_0x013f:
                        com.wowza.gocoder.sdk.support.d.a r1 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015c }
                        java.util.ArrayList r1 = r1.f4138n     // Catch:{ all -> 0x015c }
                        r1.clear()     // Catch:{ all -> 0x015c }
                        com.wowza.gocoder.sdk.support.d.a r1 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015c }
                        java.util.ArrayList r1 = r1.f4139o     // Catch:{ all -> 0x015c }
                        r1.clear()     // Catch:{ all -> 0x015c }
                        com.wowza.gocoder.sdk.support.d.a r1 = com.wowza.gocoder.sdk.support.p037d.C4280a.this     // Catch:{ all -> 0x015c }
                        java.util.ArrayList r1 = r1.f4140p     // Catch:{ all -> 0x015c }
                        r1.clear()     // Catch:{ all -> 0x015c }
                        monitor-exit(r0)     // Catch:{ all -> 0x015c }
                        return
                    L_0x015c:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x015c }
                        throw r1
                    L_0x015f:
                        r0 = move-exception
                        monitor-exit(r11)     // Catch:{ all -> 0x015f }
                        throw r0
                    L_0x0162:
                        r0 = move-exception
                        monitor-exit(r4)     // Catch:{ all -> 0x0162 }
                        throw r0     // Catch:{ all -> 0x0082 }
                    L_0x0165:
                        com.wowza.gocoder.sdk.support.d.a r2 = com.wowza.gocoder.sdk.support.p037d.C4280a.this
                        boolean unused = r2.f4145u = r1
                        throw r0
                    L_0x016b:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x016b }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.p037d.C4280a.C42811.run():void");
                }
            }, f4135k);
            this.f4146v.start();
        }
    }

    /* renamed from: c */
    public boolean mo59089c() {
        boolean z;
        synchronized (this.f4136l) {
            z = this.f4144t;
        }
        return z;
    }

    /* renamed from: d */
    public void mo59091d() {
        if (this.f4144t) {
            synchronized (this.f4136l) {
                this.f4144t = false;
            }
            if (this.f4145u) {
                this.f4146v.interrupt();
            }
        }
    }

    /* renamed from: e */
    public WOWZStreamingStat mo59092e() {
        if (this.f4137m.size() > 0) {
            return new WOWZStreamingStat(this.f4137m.get(0));
        }
        return null;
    }

    /* renamed from: a */
    public void mo59081a(int i, int i2) {
        if (m3838f(i)) {
            synchronized (this.f4136l) {
                if (this.f4144t) {
                    int[] iArr = this.f4142r;
                    iArr[i] = iArr[i] + i2;
                    int[] iArr2 = this.f4142r;
                    iArr2[3] = iArr2[3] + i2;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid packet type specified");
    }

    /* renamed from: b */
    public void mo59086b(int i, int i2) {
        if (m3838f(i)) {
            synchronized (this.f4136l) {
                if (this.f4144t) {
                    int[] iArr = this.f4143s;
                    iArr[i] = iArr[i] + i2;
                    int[] iArr2 = this.f4143s;
                    iArr2[3] = iArr2[3] + i2;
                    int[] iArr3 = this.f4142r;
                    iArr3[i] = iArr3[i] - i2;
                    int[] iArr4 = this.f4142r;
                    iArr4[3] = iArr4[3] - i2;
                    this.f4138n.add(0, new Integer[]{Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid packet type specified");
    }

    /* renamed from: b */
    public void mo59085b(int i) {
        if (m3835e(i)) {
            synchronized (this.f4136l) {
                if (this.f4144t) {
                    int[] iArr = this.f4141q;
                    iArr[i] = iArr[i] + 1;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid frame type specified");
    }

    /* renamed from: c */
    public void mo59088c(int i) {
        synchronized (this.f4136l) {
            if (this.f4144t) {
                this.f4139o.add(0, Integer.valueOf(i));
            }
        }
    }

    /* renamed from: a */
    public void mo59082a(long j) {
        synchronized (this.f4136l) {
            if (this.f4144t) {
                this.f4140p.add(0, Long.valueOf(Math.max(j, 0)));
            }
        }
    }

    /* renamed from: d */
    public int mo59090d(int i) {
        if (m3835e(i)) {
            return this.f4141q[i];
        }
        throw new IllegalArgumentException("Invalid frame type specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public WOWZStreamingStat m3825a(long j, int i, long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        long j3 = 0;
        if (currentTimeMillis <= 0 || this.f4138n.size() <= 0) {
            return null;
        }
        WOWZStreamingStat wOWZStreamingStat = new WOWZStreamingStat();
        wOWZStreamingStat.timeElapsed = j2;
        wOWZStreamingStat.sampleInterval = currentTimeMillis;
        float f = (float) (currentTimeMillis / 1000);
        Iterator<Integer[]> it = this.f4138n.iterator();
        while (it.hasNext()) {
            Integer[] next = it.next();
            int intValue = next[0].intValue();
            if (intValue == 0) {
                wOWZStreamingStat.videoBytesTransmitted += (long) next[1].intValue();
            } else if (intValue == 1) {
                wOWZStreamingStat.audioBytesTransmitted += (long) next[1].intValue();
            }
            wOWZStreamingStat.bytesTransmitted += (long) next[1].intValue();
        }
        wOWZStreamingStat.bps = Math.round((((float) wOWZStreamingStat.bytesTransmitted) * 8.0f) / f);
        wOWZStreamingStat.avgChunkSize = (long) Math.round((float) (wOWZStreamingStat.bytesTransmitted / ((long) this.f4138n.size())));
        int[] iArr = this.f4143s;
        wOWZStreamingStat.totalVideoBytesTransmitted = (long) iArr[0];
        wOWZStreamingStat.totalAudioBytesTransmitted = (long) iArr[1];
        wOWZStreamingStat.totalBytesTransmitted = (long) iArr[3];
        wOWZStreamingStat.videoBytesBuffered = (long) Math.max(this.f4142r[0], 0);
        wOWZStreamingStat.audioBytesBuffered = (long) Math.max(this.f4142r[1], 0);
        wOWZStreamingStat.bytesBuffered = (long) Math.max(this.f4142r[3], 0);
        int[] iArr2 = this.f4141q;
        wOWZStreamingStat.videoFramesBuffered = iArr2[1] - iArr2[2];
        wOWZStreamingStat.videoFramesTransmitted = mo59090d(2) - i;
        if (this.f4139o.size() > 0) {
            Iterator<Integer> it2 = this.f4139o.iterator();
            long j4 = 0;
            while (it2.hasNext()) {
                j4 += (long) it2.next().intValue();
            }
            wOWZStreamingStat.avgEncodedVideoFrameSize = Math.round((float) (j4 / ((long) this.f4139o.size())));
        }
        if (this.f4140p.size() <= 0) {
            return wOWZStreamingStat;
        }
        Iterator<Long> it3 = this.f4140p.iterator();
        while (it3.hasNext()) {
            j3 += it3.next().longValue();
        }
        wOWZStreamingStat.avgVideoFrameLatency = (long) Math.round((float) (j3 / ((long) this.f4140p.size())));
        return wOWZStreamingStat;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m3840g() {
        StringBuilder sb = new StringBuilder();
        sb.append(WOWZStreamingStat.getStatHeader());
        for (int i = 0; i < this.f4137m.size(); i++) {
            sb.append(this.f4137m.get(i).toRow(false) + "\n");
        }
        sb.append(WOWZStreamingStat.getStatSeparator());
        if (this.f4137m.size() > 0) {
            sb.append("\n" + m3828a(this.f4137m.get(0)));
        }
        WOWZLog.debug(f4135k, sb.toString());
    }

    /* renamed from: h */
    private static String m3843h() {
        return "\n" + m3844i() + "   Elapsed             Session Byte Totals                Video\n    Time          Video       Audio       Total     Frames Transmitted\n" + m3844i();
    }

    /* renamed from: a */
    private String m3828a(WOWZStreamingStat wOWZStreamingStat) {
        StringBuilder sb = new StringBuilder();
        sb.append(m3843h());
        sb.append(String.format(Locale.US, "%s | %9d | %9d | %9d | %9d ", new Object[]{m3830b(wOWZStreamingStat.timeElapsed), Long.valueOf(wOWZStreamingStat.totalVideoBytesTransmitted), Long.valueOf(wOWZStreamingStat.totalAudioBytesTransmitted), Long.valueOf(wOWZStreamingStat.totalBytesTransmitted), Integer.valueOf(mo59090d(2))}));
        sb.append("\n" + m3844i());
        return sb.toString();
    }

    /* renamed from: b */
    private static String m3830b(long j) {
        return String.format(Locale.US, "%02dm %02ds %03dms", new Object[]{Long.valueOf(j / 60000), Long.valueOf((j / 1000) % 60), Long.valueOf(j % 1000)});
    }
}

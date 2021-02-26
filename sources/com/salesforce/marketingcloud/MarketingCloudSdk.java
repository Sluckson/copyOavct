package com.salesforce.marketingcloud;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.C3956d;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.analytics.C3921j;
import com.salesforce.marketingcloud.analytics.C3924l;
import com.salesforce.marketingcloud.location.C4058h;
import com.salesforce.marketingcloud.messages.C4086h;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.inbox.C4094c;
import com.salesforce.marketingcloud.messages.inbox.InboxMessageManager;
import com.salesforce.marketingcloud.messages.push.C4099a;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.notifications.C4108c;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p020b.C3935d;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4023b;
import com.salesforce.marketingcloud.p027e.C4025d;
import com.salesforce.marketingcloud.p027e.C4036i;
import com.salesforce.marketingcloud.proximity.C4124g;
import com.salesforce.marketingcloud.registration.C4131c;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class MarketingCloudSdk extends C3956d.C3959b {
    @VisibleForTesting

    /* renamed from: a */
    static final String f2154a = "MarketingCloudPrefs";
    @VisibleForTesting

    /* renamed from: b */
    static final String f2155b = "InitConfig";

    /* renamed from: c */
    static final String f2156c = "_et_default_shared_preferences";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f2157f = C4039h.m2810a((Class<?>) MarketingCloudSdk.class);

    /* renamed from: g */
    private static final Object f2158g = new Object();

    /* renamed from: h */
    private static final List<C3837a> f2159h = new ArrayList();

    /* renamed from: i */
    private static Context f2160i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static MarketingCloudSdk f2161j;

    /* renamed from: k */
    private static volatile boolean f2162k;

    /* renamed from: l */
    private static volatile boolean f2163l;

    /* renamed from: m */
    private static volatile boolean f2164m = true;

    /* renamed from: d */
    C4058h f2165d;

    /* renamed from: e */
    C3931c f2166e;

    /* renamed from: n */
    private final MarketingCloudConfig f2167n;

    /* renamed from: o */
    private C3956d f2168o;

    /* renamed from: p */
    private List<C4021e> f2169p = new ArrayList();

    /* renamed from: q */
    private C4016h f2170q;

    /* renamed from: r */
    private C3949f f2171r;

    /* renamed from: s */
    private C4094c f2172s;

    /* renamed from: t */
    private C4131c f2173t;

    /* renamed from: u */
    private C4108c f2174u;

    /* renamed from: v */
    private C4099a f2175v;

    /* renamed from: w */
    private C4086h f2176w;

    /* renamed from: x */
    private AnalyticsManager f2177x;

    /* renamed from: y */
    private InitializationStatus f2178y;

    @MCKeep
    public interface InitializationListener {
        void complete(@NonNull InitializationStatus initializationStatus);
    }

    @MCKeep
    public interface WhenReadyListener {
        void ready(@NonNull MarketingCloudSdk marketingCloudSdk);
    }

    /* renamed from: com.salesforce.marketingcloud.MarketingCloudSdk$a */
    static abstract class C3837a {

        /* renamed from: a */
        private final Handler f2183a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public volatile boolean f2184b;

        /* renamed from: c */
        private final Runnable f2185c = new Runnable() {
            public void run() {
                synchronized (C3837a.this) {
                    if (!C3837a.this.f2184b) {
                        C3837a.this.mo56181a();
                        boolean unused = C3837a.this.f2184b = true;
                    }
                }
            }
        };

        /* renamed from: d */
        private volatile boolean f2186d;

        C3837a(Looper looper) {
            this.f2183a = new Handler(looper == null ? Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper() : looper);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo56181a();

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            return;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo56184b() {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.f2184b     // Catch:{ all -> 0x0018 }
                if (r0 != 0) goto L_0x0016
                boolean r0 = r2.f2186d     // Catch:{ all -> 0x0018 }
                if (r0 == 0) goto L_0x000a
                goto L_0x0016
            L_0x000a:
                r0 = 1
                r2.f2186d = r0     // Catch:{ all -> 0x0018 }
                android.os.Handler r0 = r2.f2183a     // Catch:{ all -> 0x0018 }
                java.lang.Runnable r1 = r2.f2185c     // Catch:{ all -> 0x0018 }
                r0.post(r1)     // Catch:{ all -> 0x0018 }
                monitor-exit(r2)     // Catch:{ all -> 0x0018 }
                return
            L_0x0016:
                monitor-exit(r2)     // Catch:{ all -> 0x0018 }
                return
            L_0x0018:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0018 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.MarketingCloudSdk.C3837a.mo56184b():void");
        }
    }

    private MarketingCloudSdk(MarketingCloudConfig marketingCloudConfig) {
        this.f2167n = marketingCloudConfig;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.TESTS})
    /* renamed from: a */
    static void m2068a() {
        MarketingCloudSdk marketingCloudSdk = f2161j;
        if (marketingCloudSdk != null) {
            marketingCloudSdk.m2073b(false);
        }
        f2161j = null;
    }

    /* renamed from: a */
    private void m2070a(InitializationStatus initializationStatus) {
        this.f2178y = initializationStatus;
    }

    /* renamed from: a */
    private void m2071a(boolean z) {
        for (int size = this.f2169p.size() - 1; size >= 0; size--) {
            try {
                this.f2169p.get(size).mo56205a(z);
            } catch (Exception e) {
                C4039h.m2830e(f2157f, e, "Error encountered tearing down component.", new Object[0]);
            }
        }
        this.f2169p.clear();
        C4016h hVar = this.f2170q;
        if (hVar != null) {
            try {
                hVar.mo56534f();
            } catch (Exception e2) {
                C4039h.m2830e(f2157f, e2, "Error encountered tearing down storage.", new Object[0]);
            }
            this.f2170q = null;
        }
        f2159h.clear();
        f2163l = false;
        f2164m = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m2072b(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, InitializationListener initializationListener) {
        C4039h.m2817a(f2157f, "executeInit %s", marketingCloudConfig);
        synchronized (f2158g) {
            if (f2161j != null) {
                f2161j.m2071a(marketingCloudConfig.applicationChanged(f2161j.f2167n));
            }
            f2161j = new MarketingCloudSdk(marketingCloudConfig);
            InitializationStatus f = f2161j.m2076f();
            C4039h.m2820b(f2157f, "MarketingCloudSdk init finished with status: %s", f);
            f2163l = f.isUsable();
            f2162k = false;
            if (f2163l) {
                f2161j.m2070a(f);
                f2161j.f2168o.mo56429a((C3956d.C3959b) f2161j);
                synchronized (f2159h) {
                    f2164m = false;
                    C4039h.m2817a(f2157f, "Delivering queued SDK requests to %s listeners", Integer.valueOf(f2159h.size()));
                    if (!f2159h.isEmpty()) {
                        for (C3837a b : f2159h) {
                            b.mo56184b();
                        }
                        f2159h.clear();
                    }
                }
            } else {
                f2161j.m2073b(false);
                f2161j = null;
                synchronized (f2159h) {
                    f2159h.clear();
                }
            }
            f2158g.notifyAll();
            if (initializationListener != null) {
                initializationListener.complete(f);
            }
        }
    }

    /* renamed from: b */
    private void m2073b(boolean z) {
        m2071a(z);
        f2162k = false;
    }

    /* renamed from: f */
    private InitializationStatus m2076f() {
        InitializationStatus.C3832a aVar;
        if (C4023b.m2752a()) {
            return InitializationStatus.amazonDeviceStatus();
        }
        InitializationStatus.C3832a builder = InitializationStatus.builder();
        try {
            String a = C4025d.m2755a(f2160i);
            try {
                this.f2170q = new C4016h(f2160i, new C4022a(f2160i, this.f2167n.applicationId(), this.f2167n.accessToken(), a), this.f2167n.applicationId(), this.f2167n.accessToken());
                this.f2170q.mo56533a(builder);
            } catch (Throwable th) {
                C4039h.m2821b(f2157f, th, "Unable to initialize SDK storage.", new Object[0]);
                builder.mo56099a(th);
            }
            if (!builder.mo56117j()) {
                C4131c.m3420a(this.f2167n, f2160i, a);
                return builder.mo56118k();
            }
            this.f2166e = new C3931c(f2160i);
            this.f2171r = new C3949f(f2160i, this.f2170q.mo56532e());
            this.f2168o = new C3956d(a, this.f2167n, this.f2170q.mo56532e(), this.f2171r, this.f2166e);
            C3872b bVar = new C3872b(f2160i, this.f2170q, this.f2166e);
            this.f2165d = C4058h.m2904a(f2160i, this.f2167n);
            C4124g a2 = C4124g.m3350a(f2160i, this.f2167n);
            C3921j jVar = new C3921j(this.f2167n, this.f2170q, a, bVar, this.f2166e, this.f2171r);
            this.f2177x = jVar;
            this.f2174u = C4108c.m3277a(f2160i, this.f2170q, this.f2167n.notificationCustomizationOptions(), (C3924l) jVar);
            this.f2172s = new C4094c(this.f2167n, this.f2170q, a, this.f2166e, bVar, this.f2171r, jVar);
            Context context = f2160i;
            MarketingCloudConfig marketingCloudConfig = this.f2167n;
            C4016h hVar = this.f2170q;
            C4058h hVar2 = this.f2165d;
            C3931c cVar = this.f2166e;
            C3949f fVar = this.f2171r;
            C4086h hVar3 = r4;
            C3921j jVar2 = jVar;
            InitializationStatus.C3832a aVar2 = builder;
            C4124g gVar = a2;
            String str = a;
            try {
                C4086h hVar4 = new C4086h(context, marketingCloudConfig, hVar, a, hVar2, a2, cVar, bVar, fVar, this.f2174u, jVar2);
                this.f2176w = hVar3;
                Context context2 = f2160i;
                C4016h hVar5 = this.f2170q;
                this.f2175v = new C4099a(context2, hVar5, this.f2174u, bVar, this.f2167n.senderId());
                this.f2173t = new C4131c(f2160i, this.f2167n, this.f2170q, str, this.f2166e, bVar, this.f2171r, this.f2175v, this.f2176w);
                this.f2169p.add(this.f2166e);
                this.f2169p.add(C3935d.m2343a((Application) f2160i.getApplicationContext()));
                this.f2169p.add(this.f2171r);
                this.f2169p.add(this.f2168o);
                this.f2169p.add(bVar);
                this.f2169p.add(this.f2165d);
                this.f2169p.add(gVar);
                this.f2169p.add(jVar2);
                this.f2169p.add(this.f2172s);
                this.f2169p.add(this.f2174u);
                this.f2169p.add(this.f2176w);
                this.f2169p.add(this.f2175v);
                this.f2169p.add(this.f2173t);
                int c = this.f2168o.mo56430c();
                C4039h.m2817a(f2157f, "Initializing all components with control channel flag [%d]", Integer.valueOf(c));
                for (C4021e next : this.f2169p) {
                    C4039h.m2817a(f2157f, "init called for %s", next.mo56210b());
                    if (next instanceof C4037f) {
                        aVar = aVar2;
                        try {
                            ((C4037f) next).mo56339a(aVar, c);
                        } catch (Exception e) {
                            e = e;
                            aVar.mo56099a((Throwable) e);
                            C4039h.m2830e(f2157f, e, "Something wrong with internal init", new Object[0]);
                            return aVar.mo56118k();
                        }
                    } else {
                        aVar = aVar2;
                        if (next instanceof C4038g) {
                            ((C4038g) next).mo56202a(aVar);
                        }
                    }
                    aVar.mo56097a(next);
                    aVar2 = aVar;
                }
                aVar = aVar2;
            } catch (Exception e2) {
                e = e2;
                aVar = aVar2;
                aVar.mo56099a((Throwable) e);
                C4039h.m2830e(f2157f, e, "Something wrong with internal init", new Object[0]);
                return aVar.mo56118k();
            }
            return aVar.mo56118k();
        } catch (Exception e3) {
            e = e3;
            aVar = builder;
            aVar.mo56099a((Throwable) e);
            C4039h.m2830e(f2157f, e, "Something wrong with internal init", new Object[0]);
            return aVar.mo56118k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003b, code lost:
        return r2;
     */
    @androidx.annotation.Nullable
    @com.salesforce.marketingcloud.MCKeep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.salesforce.marketingcloud.MarketingCloudSdk getInstance() {
        /*
            boolean r0 = f2162k
            if (r0 != 0) goto L_0x0011
            boolean r0 = f2163l
            if (r0 == 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Call init"
            r0.<init>(r1)
            throw r0
        L_0x0011:
            java.lang.Object r0 = f2158g
            monitor-enter(r0)
            boolean r1 = f2163l     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x001c
            com.salesforce.marketingcloud.MarketingCloudSdk r1 = f2161j     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return r1
        L_0x001c:
            r1 = 0
        L_0x001d:
            boolean r2 = f2163l     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x002f
            boolean r2 = f2162k     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = f2158g     // Catch:{ InterruptedException -> 0x002d }
            r3 = 0
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x002d }
            goto L_0x001d
        L_0x002d:
            r1 = 1
            goto L_0x001d
        L_0x002f:
            com.salesforce.marketingcloud.MarketingCloudSdk r2 = f2161j     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003a
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0047 }
            r1.interrupt()     // Catch:{ all -> 0x0047 }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return r2
        L_0x003c:
            r2 = move-exception
            if (r1 == 0) goto L_0x0046
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0047 }
            r1.interrupt()     // Catch:{ all -> 0x0047 }
        L_0x0046:
            throw r2     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.MarketingCloudSdk.getInstance():com.salesforce.marketingcloud.MarketingCloudSdk");
    }

    @MCKeep
    public static int getLogLevel() {
        return C4039h.m2809a();
    }

    @MCKeep
    public static int getSdkVersionCode() {
        return C4036i.m2804b();
    }

    @NonNull
    @MCKeep
    public static String getSdkVersionName() {
        return C4036i.m2803a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        return;
     */
    @androidx.annotation.MainThread
    @com.salesforce.marketingcloud.MCKeep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init(@androidx.annotation.NonNull final android.content.Context r6, @androidx.annotation.NonNull final com.salesforce.marketingcloud.MarketingCloudConfig r7, @androidx.annotation.Nullable final com.salesforce.marketingcloud.MarketingCloudSdk.InitializationListener r8) {
        /*
            java.lang.String r0 = f2157f
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = com.salesforce.marketingcloud.p027e.C4036i.m2803a()
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "~~ MarketingCloudSdk v%s init() ~~"
            com.salesforce.marketingcloud.C4039h.m2817a((java.lang.String) r0, (java.lang.String) r3, (java.lang.Object[]) r2)
            java.lang.String r0 = "Context cannot be null."
            com.salesforce.marketingcloud.p027e.C4028g.m2762a(r6, (java.lang.String) r0)
            java.lang.String r0 = "Config cannot be null."
            com.salesforce.marketingcloud.p027e.C4028g.m2762a(r7, (java.lang.String) r0)
            java.lang.String r0 = r7.applicationId()
            java.lang.String r2 = r7.accessToken()
            java.lang.String r3 = r7.senderId()
            com.salesforce.marketingcloud.C4039h.m2816a((java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r3)
            java.lang.Object r0 = f2158g
            monitor-enter(r0)
            boolean r2 = f2163l     // Catch:{ all -> 0x008d }
            if (r2 != 0) goto L_0x0036
            boolean r2 = f2162k     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0069
        L_0x0036:
            com.salesforce.marketingcloud.MarketingCloudSdk r2 = f2161j     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0069
            com.salesforce.marketingcloud.MarketingCloudSdk r2 = f2161j     // Catch:{ all -> 0x008d }
            com.salesforce.marketingcloud.MarketingCloudConfig r2 = r2.f2167n     // Catch:{ all -> 0x008d }
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0069
            java.lang.String r6 = f2157f     // Catch:{ all -> 0x008d }
            java.lang.String r7 = "MarketingCloudSdk is already %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x008d }
            boolean r2 = f2163l     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = "initialized"
            goto L_0x0053
        L_0x0051:
            java.lang.String r2 = "initializing"
        L_0x0053:
            r1[r4] = r2     // Catch:{ all -> 0x008d }
            com.salesforce.marketingcloud.C4039h.m2817a((java.lang.String) r6, (java.lang.String) r7, (java.lang.Object[]) r1)     // Catch:{ all -> 0x008d }
            boolean r6 = isReady()     // Catch:{ all -> 0x008d }
            if (r6 == 0) goto L_0x0067
            if (r8 == 0) goto L_0x0067
            com.salesforce.marketingcloud.MarketingCloudSdk r6 = f2161j     // Catch:{ all -> 0x008d }
            com.salesforce.marketingcloud.InitializationStatus r6 = r6.f2178y     // Catch:{ all -> 0x008d }
            r8.complete(r6)     // Catch:{ all -> 0x008d }
        L_0x0067:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x0069:
            java.lang.String r2 = f2157f     // Catch:{ all -> 0x008d }
            java.lang.String r3 = "Starting initialization"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x008d }
            com.salesforce.marketingcloud.C4039h.m2817a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object[]) r5)     // Catch:{ all -> 0x008d }
            f2163l = r4     // Catch:{ all -> 0x008d }
            f2162k = r1     // Catch:{ all -> 0x008d }
            f2164m = r1     // Catch:{ all -> 0x008d }
            android.content.Context r1 = r6.getApplicationContext()     // Catch:{ all -> 0x008d }
            f2160i = r1     // Catch:{ all -> 0x008d }
            java.lang.Thread r1 = new java.lang.Thread     // Catch:{ all -> 0x008d }
            com.salesforce.marketingcloud.MarketingCloudSdk$1 r2 = new com.salesforce.marketingcloud.MarketingCloudSdk$1     // Catch:{ all -> 0x008d }
            r2.<init>(r6, r7, r8)     // Catch:{ all -> 0x008d }
            r1.<init>(r2)     // Catch:{ all -> 0x008d }
            r1.start()     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x008d:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.MarketingCloudSdk.init(android.content.Context, com.salesforce.marketingcloud.MarketingCloudConfig, com.salesforce.marketingcloud.MarketingCloudSdk$InitializationListener):void");
    }

    @MCKeep
    public static boolean isInitializing() {
        return f2162k;
    }

    @MCKeep
    public static boolean isReady() {
        return f2163l && f2161j != null;
    }

    @MCKeep
    public static void requestSdk(@Nullable Looper looper, @NonNull final WhenReadyListener whenReadyListener) {
        C38362 r0 = new C3837a(looper) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo56181a() {
                WhenReadyListener whenReadyListener = whenReadyListener;
                if (whenReadyListener != null) {
                    whenReadyListener.ready(MarketingCloudSdk.f2161j);
                }
            }
        };
        synchronized (f2159h) {
            if (f2164m) {
                f2159h.add(r0);
            } else {
                r0.mo56184b();
            }
        }
    }

    @MCKeep
    public static void requestSdk(@NonNull WhenReadyListener whenReadyListener) {
        requestSdk((Looper) null, whenReadyListener);
    }

    @MCKeep
    public static void setLogLevel(int i) {
        C4039h.m2813a(i);
    }

    @MCKeep
    public static void setLogListener(@Nullable MCLogListener mCLogListener) {
        C4039h.m2815a(mCLogListener);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void mo56168a(int i) {
        for (int size = this.f2169p.size() - 1; size >= 0; size--) {
            try {
                C4021e eVar = this.f2169p.get(size);
                if (eVar instanceof C4037f) {
                    ((C4037f) eVar).mo56338a(i);
                }
            } catch (Exception e) {
                C4039h.m2830e(f2157f, e, "Error encountered during control channel init.", new Object[0]);
            }
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public C4016h mo56169b() {
        return this.f2170q;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: c */
    public C3949f mo56170c() {
        return this.f2171r;
    }

    @NonNull
    @MCKeep
    public AnalyticsManager getAnalyticsManager() {
        return this.f2177x;
    }

    @NonNull
    @MCKeep
    public InboxMessageManager getInboxMessageManager() {
        return this.f2172s;
    }

    @NonNull
    @MCKeep
    public InitializationStatus getInitializationStatus() {
        return this.f2178y;
    }

    @NonNull
    @MCKeep
    public MarketingCloudConfig getMarketingCloudConfig() {
        return this.f2167n;
    }

    @NonNull
    @MCKeep
    public NotificationManager getNotificationManager() {
        return this.f2174u;
    }

    @NonNull
    @MCKeep
    public PushMessageManager getPushMessageManager() {
        return this.f2175v;
    }

    @NonNull
    @MCKeep
    public RegionMessageManager getRegionMessageManager() {
        return this.f2176w;
    }

    @NonNull
    @MCKeep
    public RegistrationManager getRegistrationManager() {
        return this.f2173t;
    }

    @NonNull
    @MCKeep
    public JSONObject getSdkState() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("initConfig", this.f2167n.toString());
            jSONObject.put("initStatus", this.f2178y.toString());
            for (C4021e next : this.f2169p) {
                if (next != null) {
                    try {
                        jSONObject.put(next.mo56210b(), next.mo56200a());
                    } catch (Exception e) {
                        C4039h.m2830e(f2157f, e, "Failed to create component state for %s", next);
                    }
                }
            }
        } catch (Exception e2) {
            C4039h.m2830e(f2157f, e2, "Unable to create Sdk state json", new Object[0]);
        }
        return jSONObject;
    }
}

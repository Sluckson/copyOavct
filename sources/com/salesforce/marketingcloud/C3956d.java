package com.salesforce.marketingcloud;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3930b;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p021c.C3953g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p052cz.msebera.android.httpclient.cookie.ClientCookie;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d */
public class C3956d implements C3930b, C3949f.C3951a, C4021e {

    /* renamed from: a */
    public static final int f2559a = 0;

    /* renamed from: b */
    public static final int f2560b = 1;

    /* renamed from: c */
    public static final int f2561c = 2;

    /* renamed from: d */
    public static final int f2562d = 4;

    /* renamed from: e */
    public static final int f2563e = 8;

    /* renamed from: f */
    public static final int f2564f = 16;

    /* renamed from: g */
    public static final int f2565g = 32;

    /* renamed from: h */
    public static final int f2566h = 64;

    /* renamed from: i */
    public static final int f2567i = 128;

    /* renamed from: j */
    public static final int f2568j = 256;

    /* renamed from: k */
    public static final int f2569k = 512;

    /* renamed from: l */
    public static final int f2570l = 1024;

    /* renamed from: m */
    public static final int f2571m = 2048;
    @VisibleForTesting

    /* renamed from: n */
    static final String f2572n = "cc_state";
    @VisibleForTesting

    /* renamed from: o */
    static final String f2573o = "next_sync_time_millis";

    /* renamed from: p */
    private static final int f2574p = 1;

    /* renamed from: q */
    private static final String f2575q = C4039h.m2810a((Class<?>) C3956d.class);

    /* renamed from: r */
    private final C3931c f2576r;

    /* renamed from: s */
    private final C3949f f2577s;

    /* renamed from: t */
    private final SharedPreferences f2578t;

    /* renamed from: u */
    private final String f2579u;

    /* renamed from: v */
    private final MarketingCloudConfig f2580v;

    /* renamed from: w */
    private C3959b f2581w;

    /* renamed from: x */
    private C3960c f2582x = null;

    /* renamed from: y */
    private C3960c f2583y = C3960c.NONE;

    /* renamed from: com.salesforce.marketingcloud.d$1 */
    static /* synthetic */ class C39571 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2584a = new int[C3929a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.salesforce.marketingcloud.b.a[] r0 = com.salesforce.marketingcloud.p020b.C3929a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2584a = r0
                int[] r0 = f2584a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_APP_FOREGROUNDED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2584a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_SDK_PUSH_RECEIVED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.C3956d.C39571.<clinit>():void");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.d$a */
    public @interface C3958a {
    }

    /* renamed from: com.salesforce.marketingcloud.d$b */
    static abstract class C3959b {
        C3959b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo56168a(int i);
    }

    @VisibleForTesting
    /* renamed from: com.salesforce.marketingcloud.d$c */
    public enum C3960c {
        RTBF(C3770w2.f1976b),
        ROP(4094),
        f2587c(1888),
        NONE(0);
        

        /* renamed from: e */
        public final int f2590e;

        private C3960c(int i) {
            this.f2590e = i;
        }

        /* renamed from: a */
        public static C3960c m2470a(String str) {
            try {
                return valueOf(str);
            } catch (Exception unused) {
                return NONE;
            }
        }
    }

    C3956d(String str, MarketingCloudConfig marketingCloudConfig, SharedPreferences sharedPreferences, C3949f fVar, C3931c cVar) {
        this.f2579u = str;
        this.f2580v = marketingCloudConfig;
        this.f2578t = sharedPreferences;
        this.f2576r = cVar;
        this.f2577s = fVar;
        String string = sharedPreferences.getString(f2572n, (String) null);
        if (string != null) {
            this.f2583y = C3960c.m2470a(string);
        }
        if (this.f2583y != C3960c.RTBF) {
            fVar.mo56415a(C3944d.SYNC, (C3949f.C3951a) this);
            cVar.mo56346a((C3930b) this, (EnumSet<C3929a>) EnumSet.of(C3929a.BEHAVIOR_APP_FOREGROUNDED, C3929a.BEHAVIOR_SDK_PUSH_RECEIVED));
        }
    }

    /* renamed from: a */
    private synchronized void m2455a(int i) {
        C3960c cVar = m2459b(i, C3960c.RTBF.f2590e) ? C3960c.RTBF : m2459b(i, C3960c.ROP.f2590e) ? C3960c.ROP : m2459b(i, C3960c.f2587c.f2590e) ? C3960c.f2587c : C3960c.NONE;
        C4039h.m2817a(f2575q, "Control Channel blocked value %d received", Integer.valueOf(i));
        this.f2578t.edit().putString(f2572n, cVar.name()).apply();
        if (cVar != this.f2583y) {
            if (this.f2581w != null) {
                this.f2583y = cVar;
                this.f2581w.mo56168a(this.f2583y.f2590e);
            } else {
                this.f2582x = cVar;
            }
        }
    }

    /* renamed from: a */
    private void m2456a(@NonNull JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getString("name").equals("blocked") && jSONObject.optInt(ClientCookie.VERSION_ATTR, -1) == 1) {
                m2455a(jSONObject.getJSONObject(FirebaseAnalytics.Param.ITEMS).getInt("blocked"));
            }
        }
    }

    /* renamed from: a */
    public static boolean m2457a(int i, int i2) {
        return !m2459b(i, i2);
    }

    /* renamed from: a */
    public static boolean m2458a(@NonNull Map<String, String> map) {
        return map.containsKey("_nodes");
    }

    /* renamed from: b */
    public static boolean m2459b(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: c */
    public static boolean m2460c(int i, int i2) {
        if (m2457a(i, i2)) {
            return false;
        }
        if (i2 != 2) {
            if (!(i2 == 4 || i2 == 8 || i2 == 16 || i2 == 32 || i2 == 64 || i2 == 128)) {
                if (!(i2 == 256 || i2 == 512 || i2 == 2048)) {
                    return false;
                }
            }
        }
        return C3960c.ROP.f2590e != i;
    }

    /* renamed from: d */
    private boolean m2461d() {
        return this.f2583y != C3960c.RTBF && System.currentTimeMillis() > this.f2578t.getLong(f2573o, 0);
    }

    @Nullable
    /* renamed from: a */
    public JSONObject mo56200a() {
        try {
            return new JSONObject().put("flag", this.f2583y.name());
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo56204a(@NonNull C3929a aVar, @NonNull Bundle bundle) {
        String string;
        int i = C39571.f2584a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2 && (string = bundle.getString("_nodes")) != null) {
                try {
                    m2456a(new JSONArray(string));
                } catch (Exception e) {
                    C4039h.m2830e(f2575q, e, "Failed to parse push message", new Object[0]);
                }
            }
        } else if (m2461d()) {
            C3949f fVar = this.f2577s;
            C3944d dVar = C3944d.SYNC;
            MarketingCloudConfig marketingCloudConfig = this.f2580v;
            fVar.mo56416a(dVar.mo56405a(marketingCloudConfig, C3944d.m2384a(marketingCloudConfig.applicationId(), this.f2579u), "{}"));
        }
    }

    /* renamed from: a */
    public void mo56262a(C3946e eVar, C3953g gVar) {
        if (gVar.mo56419h()) {
            try {
                JSONArray jSONArray = new JSONObject(gVar.mo56359a()).getJSONArray("nodes");
                if (jSONArray != null) {
                    m2456a(jSONArray);
                }
                this.f2578t.edit().putLong(f2573o, System.currentTimeMillis() + 86400000).apply();
            } catch (Exception e) {
                C4039h.m2830e(f2575q, e, "Failed to parse /sync route response", new Object[0]);
            }
        } else {
            C4039h.m2829e("SYNC", gVar.mo56360b(), new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo56429a(C3959b bVar) {
        this.f2581w = bVar;
        if (!(bVar == null || this.f2582x == null)) {
            this.f2583y = this.f2582x;
            this.f2582x = null;
            bVar.mo56168a(this.f2583y.f2590e);
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
        this.f2576r.mo56345a((C3930b) this);
        this.f2577s.mo56414a(C3944d.SYNC);
        this.f2581w = null;
    }

    @NonNull
    /* renamed from: b */
    public String mo56210b() {
        return "ControlChannel";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo56430c() {
        return this.f2583y.f2590e;
    }
}

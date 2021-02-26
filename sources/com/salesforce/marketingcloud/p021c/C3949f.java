package com.salesforce.marketingcloud.p021c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.security.ProviderInstaller;
import com.salesforce.marketingcloud.C4038g;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.C4040i;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.c.f */
public class C3949f extends C4038g {

    /* renamed from: a */
    public static final String f2545a = "com.salesforce.marketingcloud.http.RESPONSE";

    /* renamed from: b */
    public static final String f2546b = "http_response";

    /* renamed from: c */
    public static final String f2547c = "http_request";

    /* renamed from: e */
    private static final int f2548e = 10;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f2549f = C4039h.m2810a((Class<?>) C3949f.class);
    @VisibleForTesting

    /* renamed from: d */
    final Map<C3944d, C3951a> f2550d = new ArrayMap();

    /* renamed from: g */
    private final Map<String, String> f2551g = new LinkedHashMap<String, String>() {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 10;
        }
    };

    /* renamed from: h */
    private final Context f2552h;

    /* renamed from: i */
    private final SharedPreferences f2553i;

    /* renamed from: j */
    private BroadcastReceiver f2554j;

    /* renamed from: com.salesforce.marketingcloud.c.f$a */
    public interface C3951a {
        /* renamed from: a */
        void mo56262a(C3946e eVar, C3953g gVar);
    }

    /* renamed from: com.salesforce.marketingcloud.c.f$b */
    private class C3952b extends BroadcastReceiver {
        private C3952b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4039h.m2817a(C3949f.f2549f, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4039h.m2817a(C3949f.f2549f, "Received null action", new Object[0]);
                return;
            }
            char c = 65535;
            if (action.hashCode() == 431436234 && action.equals(C3949f.f2545a)) {
                c = 0;
            }
            if (c != 0) {
                C4039h.m2820b(C3949f.f2549f, "Received unknown action: %s", action);
                return;
            }
            C3946e a = C3946e.m2395a(intent.getBundleExtra(C3949f.f2547c));
            C3953g gVar = (C3953g) intent.getParcelableExtra(C3949f.f2546b);
            if (a == null || gVar == null) {
                C4039h.m2817a(C3949f.f2549f, "Received null request/response", new Object[0]);
            } else {
                C3949f.this.m2424a(a, gVar);
            }
        }
    }

    public C3949f(Context context, SharedPreferences sharedPreferences) {
        this.f2552h = (Context) C4028g.m2762a(context, "Context is null");
        this.f2553i = (SharedPreferences) C4028g.m2762a(sharedPreferences, "SharedPreferences is null");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2424a(@NonNull C3946e eVar, @NonNull C3953g gVar) {
        String str = f2549f;
        Object[] objArr = new Object[3];
        objArr[0] = eVar.mo56383h() != null ? eVar.mo56383h().name() : "unknown";
        objArr[1] = Long.valueOf(gVar.mo56420i());
        objArr[2] = Integer.valueOf(gVar.mo56361c());
        C4039h.m2817a(str, "%s request took %dms with code: %d", objArr);
        if (eVar.mo56383h() != null) {
            eVar.mo56383h().mo56407a(this.f2553i, gVar);
        }
        try {
            this.f2551g.put(eVar.mo56381f(), String.format(Locale.ENGLISH, "%s - %d", new Object[]{gVar.mo56360b(), Integer.valueOf(gVar.mo56361c())}));
        } catch (Exception e) {
            C4039h.m2830e(f2549f, e, "Failed to record response.", new Object[0]);
        }
        synchronized (this.f2550d) {
            C3951a aVar = this.f2550d.get(eVar.mo56383h());
            if (aVar != null) {
                try {
                    aVar.mo56262a(eVar, gVar);
                } catch (Exception e2) {
                    C4039h.m2830e(f2549f, e2, "Failed to deliver response.", new Object[0]);
                }
            } else {
                C4039h.m2829e(f2549f, "Request %s complete, but no listener was present to handle response %d.", eVar.mo56381f(), Integer.valueOf(gVar.mo56361c()));
            }
        }
    }

    /* renamed from: d */
    private void m2427d() {
        ProviderInstaller.installIfNeeded(this.f2552h);
    }

    @Nullable
    /* renamed from: a */
    public final JSONObject mo56200a() {
        return new JSONObject(this.f2551g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo56202a(@NonNull InitializationStatus.C3832a aVar) {
        try {
            m2427d();
        } catch (Exception e) {
            aVar.mo56112f(true);
            aVar.mo56103b("Failed to install providers: " + e.getMessage());
        }
        this.f2554j = new C3952b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f2545a);
        LocalBroadcastManager.getInstance(this.f2552h).registerReceiver(this.f2554j, intentFilter);
    }

    /* renamed from: a */
    public void mo56414a(@NonNull C3944d dVar) {
        synchronized (this.f2550d) {
            this.f2550d.remove(dVar);
        }
    }

    /* renamed from: a */
    public void mo56415a(@NonNull C3944d dVar, @NonNull C3951a aVar) {
        synchronized (this.f2550d) {
            if (this.f2550d.put(dVar, aVar) != null) {
                C4039h.m2820b(f2549f, "%s replaces previous listener for $s requests", aVar.getClass().getName(), dVar.name());
            }
        }
    }

    /* renamed from: a */
    public void mo56416a(@NonNull C3946e eVar) {
        C4028g.m2762a(eVar, "request is null");
        try {
            m2427d();
        } catch (Exception unused) {
            C4039h.m2826d(f2549f, "Failed to verify SSL providers via Google Play Services.", new Object[0]);
        }
        if (eVar.mo56383h().mo56402a(this.f2553i) < System.currentTimeMillis()) {
            C4040i.m2833a(this.f2552h, eVar);
            return;
        }
        synchronized (this.f2550d) {
            C3951a aVar = this.f2550d.get(eVar.mo56383h());
            if (aVar != null) {
                aVar.mo56262a(eVar, C3953g.m2436a("Too many requests", -1));
            }
        }
    }

    /* renamed from: a */
    public final void mo56205a(boolean z) {
        synchronized (this.f2550d) {
            this.f2550d.clear();
        }
        Context context = this.f2552h;
        if (context != null && this.f2554j != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f2554j);
        }
    }

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return "RequestManager";
    }
}

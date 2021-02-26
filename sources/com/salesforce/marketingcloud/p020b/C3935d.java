package com.salesforce.marketingcloud.p020b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.C4038g;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.b.d */
public final class C3935d extends C4038g implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    @VisibleForTesting

    /* renamed from: a */
    static C3935d f2479a = null;

    /* renamed from: c */
    private static final String f2480c = C4039h.m2810a((Class<?>) C3935d.class);
    @VisibleForTesting

    /* renamed from: b */
    AtomicBoolean f2481b = new AtomicBoolean(false);

    /* renamed from: d */
    private final Application f2482d;

    /* renamed from: e */
    private final AtomicBoolean f2483e = new AtomicBoolean(false);

    private C3935d(Application application) {
        this.f2482d = application;
        application.registerActivityLifecycleCallbacks(this);
        application.registerComponentCallbacks(this);
    }

    /* renamed from: a */
    public static synchronized C3935d m2343a(Application application) {
        C3935d dVar;
        synchronized (C3935d.class) {
            if (f2479a == null) {
                f2479a = new C3935d(application);
            }
            dVar = f2479a;
        }
        return dVar;
    }

    @Nullable
    /* renamed from: a */
    public JSONObject mo56200a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inForeground", this.f2481b.get());
        } catch (JSONException e) {
            C4039h.m2830e(f2480c, e, "Failed to create component state", new Object[0]);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo56202a(@NonNull InitializationStatus.C3832a aVar) {
        this.f2483e.set(true);
        if (this.f2481b.get()) {
            C3931c.m2333a((Context) this.f2482d, C3929a.BEHAVIOR_APP_FOREGROUNDED, (Bundle) null);
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
        this.f2483e.set(false);
    }

    @NonNull
    /* renamed from: b */
    public String mo56210b() {
        return "LifecycleManager";
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (!this.f2481b.getAndSet(true) && this.f2483e.get()) {
            C4039h.m2820b(f2480c, "App came into the foreground.", new Object[0]);
            C3931c.m2333a((Context) this.f2482d, C3929a.BEHAVIOR_APP_FOREGROUNDED, (Bundle) null);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i >= 20 && this.f2481b.getAndSet(false)) {
            C4039h.m2820b(f2480c, "App went into the background.", new Object[0]);
            C3931c.m2333a((Context) this.f2482d, C3929a.BEHAVIOR_APP_BACKGROUNDED, (Bundle) null);
        }
    }
}

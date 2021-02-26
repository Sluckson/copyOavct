package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbo;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.internal.zzd;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class FirebasePerformance {
    public static final int MAX_TRACE_NAME_LENGTH = 100;
    private static volatile FirebasePerformance zzaa;
    private final Map<String, String> zzab;
    private final zzah zzac;
    private final zzbo zzad;
    @Nullable
    private Boolean zzae;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public @interface HttpMethod {
        public static final String CONNECT = "CONNECT";
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTIONS = "OPTIONS";
        public static final String PATCH = "PATCH";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String TRACE = "TRACE";
    }

    @NonNull
    public static FirebasePerformance getInstance() {
        if (zzaa == null) {
            synchronized (FirebasePerformance.class) {
                if (zzaa == null) {
                    zzaa = (FirebasePerformance) FirebaseApp.getInstance().get(FirebasePerformance.class);
                }
            }
        }
        return zzaa;
    }

    FirebasePerformance(FirebaseApp firebaseApp, FirebaseRemoteConfig firebaseRemoteConfig) {
        this(firebaseApp, firebaseRemoteConfig, RemoteConfigManager.zzci(), zzah.zzo(), GaugeManager.zzby());
    }

    @VisibleForTesting
    private FirebasePerformance(FirebaseApp firebaseApp, FirebaseRemoteConfig firebaseRemoteConfig, RemoteConfigManager remoteConfigManager, zzah zzah, GaugeManager gaugeManager) {
        this.zzab = new ConcurrentHashMap();
        this.zzae = null;
        if (firebaseApp == null) {
            this.zzae = false;
            this.zzac = zzah;
            this.zzad = new zzbo(new Bundle());
            return;
        }
        Context applicationContext = firebaseApp.getApplicationContext();
        this.zzad = zza(applicationContext);
        remoteConfigManager.zza(firebaseRemoteConfig);
        this.zzac = zzah;
        this.zzac.zza(this.zzad);
        this.zzac.zzc(applicationContext);
        gaugeManager.zzc(applicationContext);
        this.zzae = zzah.zzq();
    }

    @NonNull
    public static Trace startTrace(@NonNull String str) {
        Trace zzn = Trace.zzn(str);
        zzn.start();
        return zzn;
    }

    public void setPerformanceCollectionEnabled(boolean z) {
        try {
            FirebaseApp.getInstance();
            if (this.zzac.zzr().booleanValue()) {
                Log.i("FirebasePerformance", "Firebase Performance is permanently disabled");
                return;
            }
            this.zzae = Boolean.valueOf(z);
            this.zzac.zza(z);
            if (z) {
                Log.i("FirebasePerformance", "Firebase Performance is Enabled");
            } else {
                Log.i("FirebasePerformance", "Firebase Performance is Disabled");
            }
        } catch (IllegalStateException unused) {
        }
    }

    public boolean isPerformanceCollectionEnabled() {
        Boolean bool = this.zzae;
        if (bool != null) {
            return bool.booleanValue();
        }
        return FirebaseApp.getInstance().isDataCollectionDefaultEnabled();
    }

    @NonNull
    public final Map<String, String> getAttributes() {
        return new HashMap(this.zzab);
    }

    @NonNull
    public Trace newTrace(@NonNull String str) {
        return Trace.zzn(str);
    }

    @NonNull
    public HttpMetric newHttpMetric(@NonNull String str, @NonNull String str2) {
        return new HttpMetric(str, str2, zzd.zzbs(), new zzbw());
    }

    @NonNull
    public HttpMetric newHttpMetric(@NonNull URL url, @NonNull String str) {
        return new HttpMetric(url, str, zzd.zzbs(), new zzbw());
    }

    private static zzbo zza(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.d("isEnabled", valueOf.length() != 0 ? "No perf enable meta data found ".concat(valueOf) : new String("No perf enable meta data found "));
            bundle = null;
        }
        return bundle != null ? new zzbo(bundle) : new zzbo();
    }
}

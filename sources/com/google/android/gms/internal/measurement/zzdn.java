package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzdn implements zzcs {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, zzdn> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc = new zzdm(this);
    private final Object zzd = new Object();
    private volatile Map<String, ?> zze;
    @GuardedBy("this")
    private final List<zzct> zzf = new ArrayList();

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, java.lang.String, com.google.android.gms.internal.measurement.zzdn] */
    static zzdn zza(Context context, String str) {
        zzdn zzdn;
        ? r0 = 0;
        if (!((!zzcm.zza() || r0.startsWith("direct_boot:")) ? true : zzcm.zza(context))) {
            return r0;
        }
        synchronized (zzdn.class) {
            zzdn = zza.get(r0);
            if (zzdn == null) {
                zzdn = new zzdn(zzb(context, r0));
                zza.put(r0, zzdn);
            }
        }
        return zzdn;
    }

    private static SharedPreferences zzb(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzcm.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private zzdn(SharedPreferences sharedPreferences) {
        this.zzb = sharedPreferences;
        this.zzb.registerOnSharedPreferenceChangeListener(this.zzc);
    }

    /* JADX INFO: finally extract failed */
    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zza() {
        synchronized (zzdn.class) {
            for (zzdn next : zza.values()) {
                next.zzb.unregisterOnSharedPreferenceChangeListener(next.zzc);
            }
            zza.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzdc.zza();
        }
        synchronized (this) {
            for (zzct zza2 : this.zzf) {
                zza2.zza();
            }
        }
    }
}

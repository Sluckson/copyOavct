package com.google.android.gms.internal.p010firebaseperf;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.FirebaseApp;

@VisibleForTesting(otherwise = 3)
/* renamed from: com.google.android.gms.internal.firebase-perf.zzbb */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzbb {
    private static zzbb zzbk;
    private zzbi zzaj = zzbi.zzcl();
    private SharedPreferences zzbl;

    @VisibleForTesting
    private zzbb() {
    }

    public static synchronized zzbb zzbd() {
        zzbb zzbb;
        synchronized (zzbb.class) {
            if (zzbk == null) {
                zzbk = new zzbb();
            }
            zzbb = zzbk;
        }
        return zzbb;
    }

    public final synchronized void zzd(Context context) {
        if (this.zzbl == null && context != null) {
            this.zzbl = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        }
    }

    public final zzbn<Boolean> zzb(String str) {
        if (str == null) {
            this.zzaj.zzm("Key is null when getting boolean value on device cache.");
            return zzbn.zzda();
        }
        if (this.zzbl == null) {
            zzd(zzbe());
            if (this.zzbl == null) {
                return zzbn.zzda();
            }
        }
        if (!this.zzbl.contains(str)) {
            return zzbn.zzda();
        }
        try {
            return zzbn.zzb(Boolean.valueOf(this.zzbl.getBoolean(str, false)));
        } catch (ClassCastException e) {
            this.zzaj.zzm(String.format("Key %s from sharedPreferences has type other than long: %s", new Object[]{str, e.getMessage()}));
            return zzbn.zzda();
        }
    }

    public final boolean zza(String str, boolean z) {
        if (str == null) {
            this.zzaj.zzm("Key is null when setting boolean value on device cache.");
            return false;
        }
        if (this.zzbl == null) {
            zzd(zzbe());
            if (this.zzbl == null) {
                return false;
            }
        }
        this.zzbl.edit().putBoolean(str, z).apply();
        return true;
    }

    public final zzbn<String> zzc(String str) {
        if (str == null) {
            this.zzaj.zzm("Key is null when getting String value on device cache.");
            return zzbn.zzda();
        }
        if (this.zzbl == null) {
            zzd(zzbe());
            if (this.zzbl == null) {
                return zzbn.zzda();
            }
        }
        if (!this.zzbl.contains(str)) {
            return zzbn.zzda();
        }
        try {
            return zzbn.zzb(this.zzbl.getString(str, ""));
        } catch (ClassCastException e) {
            this.zzaj.zzm(String.format("Key %s from sharedPreferences has type other than String: %s", new Object[]{str, e.getMessage()}));
            return zzbn.zzda();
        }
    }

    public final boolean zza(String str, String str2) {
        if (str == null) {
            this.zzaj.zzm("Key is null when setting String value on device cache.");
            return false;
        }
        if (this.zzbl == null) {
            zzd(zzbe());
            if (this.zzbl == null) {
                return false;
            }
        }
        if (str2 == null) {
            this.zzbl.edit().remove(str).apply();
            return true;
        }
        this.zzbl.edit().putString(str, str2).apply();
        return true;
    }

    public final zzbn<Float> zzd(String str) {
        if (str == null) {
            this.zzaj.zzm("Key is null when getting float value on device cache.");
            return zzbn.zzda();
        }
        if (this.zzbl == null) {
            zzd(zzbe());
            if (this.zzbl == null) {
                return zzbn.zzda();
            }
        }
        if (!this.zzbl.contains(str)) {
            return zzbn.zzda();
        }
        try {
            return zzbn.zzb(Float.valueOf(this.zzbl.getFloat(str, 0.0f)));
        } catch (ClassCastException e) {
            this.zzaj.zzm(String.format("Key %s from sharedPreferences has type other than float: %s", new Object[]{str, e.getMessage()}));
            return zzbn.zzda();
        }
    }

    public final boolean zza(String str, float f) {
        if (str == null) {
            this.zzaj.zzm("Key is null when setting float value on device cache.");
            return false;
        }
        if (this.zzbl == null) {
            zzd(zzbe());
            if (this.zzbl == null) {
                return false;
            }
        }
        this.zzbl.edit().putFloat(str, f).apply();
        return true;
    }

    public final zzbn<Long> zze(String str) {
        if (str == null) {
            this.zzaj.zzm("Key is null when getting long value on device cache.");
            return zzbn.zzda();
        }
        if (this.zzbl == null) {
            zzd(zzbe());
            if (this.zzbl == null) {
                return zzbn.zzda();
            }
        }
        if (!this.zzbl.contains(str)) {
            return zzbn.zzda();
        }
        try {
            return zzbn.zzb(Long.valueOf(this.zzbl.getLong(str, 0)));
        } catch (ClassCastException e) {
            this.zzaj.zzm(String.format("Key %s from sharedPreferences has type other than long: %s", new Object[]{str, e.getMessage()}));
            return zzbn.zzda();
        }
    }

    public final boolean zza(String str, long j) {
        if (str == null) {
            this.zzaj.zzm("Key is null when setting long value on device cache.");
            return false;
        }
        if (this.zzbl == null) {
            zzd(zzbe());
            if (this.zzbl == null) {
                return false;
            }
        }
        this.zzbl.edit().putLong(str, j).apply();
        return true;
    }

    @Nullable
    private static Context zzbe() {
        try {
            FirebaseApp.getInstance();
            return FirebaseApp.getInstance().getApplicationContext();
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}

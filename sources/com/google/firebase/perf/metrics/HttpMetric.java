package com.google.firebase.perf.metrics;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.firebase.perf.internal.zzd;
import com.google.firebase.perf.internal.zzs;
import java.net.URL;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class HttpMetric {
    private zzbg zzgh;
    private zzbw zzgi;
    private final Map<String, String> zzgj;
    private boolean zzgk;
    private boolean zzgl;

    public HttpMetric(String str, String str2, zzd zzd, zzbw zzbw) {
        this.zzgk = false;
        this.zzgl = false;
        this.zzgj = new ConcurrentHashMap();
        this.zzgi = zzbw;
        this.zzgh = zzbg.zza(zzd).zzf(str).zzg(str2);
        this.zzgh.zzbg();
        if (!zzah.zzo().zzp()) {
            Log.i("FirebasePerformance", String.format("HttpMetric feature is disabled. URL %s", new Object[]{str}));
            this.zzgl = true;
        }
    }

    public HttpMetric(URL url, String str, zzd zzd, zzbw zzbw) {
        this(url.toString(), str, zzd, zzbw);
    }

    public void setHttpResponseCode(int i) {
        this.zzgh.zzb(i);
    }

    public void setRequestPayloadSize(long j) {
        this.zzgh.zzj(j);
    }

    public void setResponsePayloadSize(long j) {
        this.zzgh.zzo(j);
    }

    public void setResponseContentType(@Nullable String str) {
        this.zzgh.zzh(str);
    }

    public void start() {
        this.zzgi.reset();
        this.zzgh.zzk(this.zzgi.zzdb());
    }

    public void stop() {
        if (!this.zzgl) {
            this.zzgh.zzn(this.zzgi.getDurationMicros()).zza(this.zzgj).zzbk();
            this.zzgk = true;
        }
    }

    public void putAttribute(@NonNull String str, @NonNull String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            if (this.zzgk) {
                throw new IllegalArgumentException("HttpMetric has been logged already so unable to modify attributes");
            } else if (str == null || str2 == null) {
                throw new IllegalArgumentException("Attribute must not have null key or value.");
            } else {
                if (!this.zzgj.containsKey(str)) {
                    if (this.zzgj.size() >= 5) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", new Object[]{5}));
                    }
                }
                String zza = zzs.zza(new AbstractMap.SimpleEntry(str, str2));
                if (zza == null) {
                    z = true;
                    if (z) {
                        this.zzgj.put(str, str2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(zza);
            }
        } catch (Exception e) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", new Object[]{str, str2, e.getMessage()}));
        }
    }

    public void removeAttribute(@NonNull String str) {
        if (this.zzgk) {
            Log.e("FirebasePerformance", "Can't remove a attribute from a HttpMetric that's stopped.");
        } else {
            this.zzgj.remove(str);
        }
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        return this.zzgj.get(str);
    }

    @NonNull
    public Map<String, String> getAttributes() {
        return new HashMap(this.zzgj);
    }
}

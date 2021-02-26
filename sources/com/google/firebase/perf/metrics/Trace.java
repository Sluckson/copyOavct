package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbk;
import com.google.android.gms.internal.p010firebaseperf.zzbl;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.android.gms.internal.p010firebaseperf.zzj;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.zza;
import com.google.firebase.perf.internal.zzc;
import com.google.firebase.perf.internal.zzd;
import com.google.firebase.perf.internal.zzr;
import com.google.firebase.perf.internal.zzs;
import com.google.firebase.perf.internal.zzw;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class Trace extends zzc implements Parcelable, zzw {
    @Keep
    public static final Parcelable.Creator<Trace> CREATOR = new zzd();
    private static final Map<String, Trace> zzfy = new ConcurrentHashMap();
    @VisibleForTesting
    private static final Parcelable.Creator<Trace> zzgg = new zzc();
    private final String name;
    private final List<zzr> zzbv;
    private final GaugeManager zzbw;
    private final WeakReference<zzw> zzcb;
    private final zzd zzcx;
    private final Trace zzfz;
    private final List<Trace> zzga;
    private final Map<String, zzb> zzgb;
    private final zzbk zzgc;
    private final Map<String, String> zzgd;
    private zzbw zzge;
    private zzbw zzgf;

    @Keep
    public int describeContents() {
        return 0;
    }

    public final void zza(zzr zzr) {
        if (zzr == null) {
            Log.i("FirebasePerformance", "Unable to add new SessionId to the Trace. Continuing without it.");
        } else if (hasStarted() && !isStopped()) {
            this.zzbv.add(zzr);
        }
    }

    @NonNull
    public static Trace zzn(@NonNull String str) {
        return new Trace(str);
    }

    private Trace(@NonNull String str) {
        this(str, zzd.zzbs(), new zzbk(), zza.zzbl(), GaugeManager.zzby());
    }

    public Trace(@NonNull String str, @NonNull zzd zzd, @NonNull zzbk zzbk, @NonNull zza zza) {
        this(str, zzd, zzbk, zza, GaugeManager.zzby());
    }

    private Trace(@NonNull String str, @NonNull zzd zzd, @NonNull zzbk zzbk, @NonNull zza zza, @NonNull GaugeManager gaugeManager) {
        super(zza);
        this.zzcb = new WeakReference<>(this);
        this.zzfz = null;
        this.name = str.trim();
        this.zzga = new ArrayList();
        this.zzgb = new ConcurrentHashMap();
        this.zzgd = new ConcurrentHashMap();
        this.zzgc = zzbk;
        this.zzcx = zzd;
        this.zzbv = new ArrayList();
        this.zzbw = gaugeManager;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private Trace(@NonNull Parcel parcel, boolean z) {
        super(z ? null : zza.zzbl());
        this.zzcb = new WeakReference<>(this);
        this.zzfz = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.name = parcel.readString();
        this.zzga = new ArrayList();
        parcel.readList(this.zzga, Trace.class.getClassLoader());
        this.zzgb = new ConcurrentHashMap();
        this.zzgd = new ConcurrentHashMap();
        parcel.readMap(this.zzgb, zzb.class.getClassLoader());
        this.zzge = (zzbw) parcel.readParcelable(zzbw.class.getClassLoader());
        this.zzgf = (zzbw) parcel.readParcelable(zzbw.class.getClassLoader());
        this.zzbv = new ArrayList();
        parcel.readList(this.zzbv, zzr.class.getClassLoader());
        if (z) {
            this.zzcx = null;
            this.zzgc = null;
            this.zzbw = null;
            return;
        }
        this.zzcx = zzd.zzbs();
        this.zzgc = new zzbk();
        this.zzbw = GaugeManager.zzby();
    }

    @Keep
    public void start() {
        String str;
        if (!zzah.zzo().zzp()) {
            Log.i("FirebasePerformance", "Trace feature is disabled.");
            return;
        }
        String str2 = this.name;
        if (str2 == null) {
            str = "Trace name must not be null";
        } else if (str2.length() > 100) {
            str = String.format(Locale.US, "Trace name must not exceed %d characters", new Object[]{100});
        } else {
            if (str2.startsWith("_")) {
                zzbl[] values = zzbl.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (values[i].toString().equals(str2)) {
                            break;
                        }
                        i++;
                    } else if (!str2.startsWith("_st_")) {
                        str = "Trace name must not start with '_'";
                    }
                }
            }
            str = null;
        }
        if (str != null) {
            Log.e("FirebasePerformance", String.format("Cannot start trace %s. Trace name is invalid.(%s)", new Object[]{this.name, str}));
        } else if (this.zzge != null) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has already started, should not start again!", new Object[]{this.name}));
        } else {
            this.zzge = new zzbw();
            zzbq();
            zzr zzcn = SessionManager.zzcm().zzcn();
            SessionManager.zzcm().zzc(this.zzcb);
            zza(zzcn);
            if (zzcn.zzcg()) {
                this.zzbw.zzj(zzcn.zzcf());
            }
        }
    }

    @Keep
    public void stop() {
        if (!hasStarted()) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has not been started so unable to stop!", new Object[]{this.name}));
        } else if (isStopped()) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has already stopped, should not stop again!", new Object[]{this.name}));
        } else {
            SessionManager.zzcm().zzd(this.zzcb);
            zzbr();
            this.zzgf = new zzbw();
            if (this.zzfz == null) {
                zzbw zzbw2 = this.zzgf;
                if (!this.zzga.isEmpty()) {
                    Trace trace = this.zzga.get(this.zzga.size() - 1);
                    if (trace.zzgf == null) {
                        trace.zzgf = zzbw2;
                    }
                }
                if (!this.name.isEmpty()) {
                    zzd zzd = this.zzcx;
                    if (zzd != null) {
                        zzd.zza(new zze(this).zzcx(), zzbn());
                        if (SessionManager.zzcm().zzcn().zzcg()) {
                            this.zzbw.zzj(SessionManager.zzcm().zzcn().zzcf());
                            return;
                        }
                        return;
                    }
                    return;
                }
                Log.e("FirebasePerformance", "Trace name is empty, no log is sent to server");
            }
        }
    }

    @NonNull
    private final zzb zzo(@NonNull String str) {
        zzb zzb = this.zzgb.get(str);
        if (zzb != null) {
            return zzb;
        }
        zzb zzb2 = new zzb(str);
        this.zzgb.put(str, zzb2);
        return zzb2;
    }

    @Keep
    public void incrementMetric(@NonNull String str, long j) {
        String zzk = zzs.zzk(str);
        if (zzk != null) {
            Log.e("FirebasePerformance", String.format("Cannot increment metric %s. Metric name is invalid.(%s)", new Object[]{str, zzk}));
        } else if (!hasStarted()) {
            Log.w("FirebasePerformance", String.format("Cannot increment metric '%s' for trace '%s' because it's not started", new Object[]{str, this.name}));
        } else if (isStopped()) {
            Log.w("FirebasePerformance", String.format("Cannot increment metric '%s' for trace '%s' because it's been stopped", new Object[]{str, this.name}));
        } else {
            zzo(str.trim()).zzr(j);
        }
    }

    @Keep
    public long getLongMetric(@NonNull String str) {
        zzb zzb = str != null ? this.zzgb.get(str.trim()) : null;
        if (zzb == null) {
            return 0;
        }
        return zzb.getCount();
    }

    @Keep
    public void putMetric(@NonNull String str, long j) {
        String zzk = zzs.zzk(str);
        if (zzk != null) {
            Log.e("FirebasePerformance", String.format("Cannot set value for metric %s. Metric name is invalid.(%s)", new Object[]{str, zzk}));
        } else if (!hasStarted()) {
            Log.w("FirebasePerformance", String.format("Cannot set value for metric '%s' for trace '%s' because it's not started", new Object[]{str, this.name}));
        } else if (isStopped()) {
            Log.w("FirebasePerformance", String.format("Cannot set value for metric '%s' for trace '%s' because it's been stopped", new Object[]{str, this.name}));
        } else {
            zzo(str.trim()).zzs(j);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (hasStarted() && !isStopped()) {
                Log.w("FirebasePerformance", String.format("Trace '%s' is started but not stopped when it is destructed!", new Object[]{this.name}));
                zzc(1);
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @VisibleForTesting
    public final String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @VisibleForTesting
    public final Map<String, zzb> zzcs() {
        return this.zzgb;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzbw zzct() {
        return this.zzge;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzbw zzcu() {
        return this.zzgf;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @VisibleForTesting
    public final List<Trace> zzcv() {
        return this.zzga;
    }

    @VisibleForTesting
    private final boolean isStopped() {
        return this.zzgf != null;
    }

    @VisibleForTesting
    private final boolean hasStarted() {
        return this.zzge != null;
    }

    @Keep
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.zzfz, 0);
        parcel.writeString(this.name);
        parcel.writeList(this.zzga);
        parcel.writeMap(this.zzgb);
        parcel.writeParcelable(this.zzge, 0);
        parcel.writeParcelable(this.zzgf, 0);
        parcel.writeList(this.zzbv);
    }

    @Keep
    public void putAttribute(@NonNull String str, @NonNull String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            if (!isStopped()) {
                if (!this.zzgd.containsKey(str)) {
                    if (this.zzgd.size() >= 5) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", new Object[]{5}));
                    }
                }
                String zza = zzs.zza(new AbstractMap.SimpleEntry(str, str2));
                if (zza == null) {
                    z = true;
                    if (z) {
                        this.zzgd.put(str, str2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(zza);
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Trace %s has been stopped", new Object[]{this.name}));
        } catch (Exception e) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", new Object[]{str, str2, e.getMessage()}));
        }
    }

    @Keep
    public void removeAttribute(@NonNull String str) {
        if (isStopped()) {
            Log.e("FirebasePerformance", "Can't remove a attribute from a Trace that's stopped.");
        } else {
            this.zzgd.remove(str);
        }
    }

    @Keep
    @Nullable
    public String getAttribute(@NonNull String str) {
        return this.zzgd.get(str);
    }

    @NonNull
    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.zzgd);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzj<zzr> zzcw() {
        return zzj.zza(this.zzbv);
    }

    /* synthetic */ Trace(Parcel parcel, boolean z, zzd zzd) {
        this(parcel, z);
    }
}

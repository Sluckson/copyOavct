package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p010firebaseperf.zzcg;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Keep
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class SessionManager extends zzc {
    @SuppressLint({"StaticFieldLeak"})
    private static final SessionManager zzfh = new SessionManager();
    private final GaugeManager zzbw;
    private final zza zzdh;
    private final Set<WeakReference<zzw>> zzfi;
    private zzr zzfj;

    public static SessionManager zzcm() {
        return zzfh;
    }

    public final zzr zzcn() {
        return this.zzfj;
    }

    private SessionManager() {
        this(GaugeManager.zzby(), zzr.zzcd(), zza.zzbl());
    }

    @VisibleForTesting
    private SessionManager(GaugeManager gaugeManager, zzr zzr, zza zza) {
        this.zzfi = new HashSet();
        this.zzbw = gaugeManager;
        this.zzfj = zzr;
        this.zzdh = zza;
        zzbq();
    }

    public final void zza(zzcg zzcg) {
        super.zza(zzcg);
        if (!this.zzdh.zzbm()) {
            if (zzcg == zzcg.FOREGROUND) {
                zzc(zzcg);
            } else if (!zzco()) {
                zzd(zzcg);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzco() {
        if (!this.zzfj.isExpired()) {
            return false;
        }
        zzc(this.zzdh.zzbn());
        return true;
    }

    public final void zzc(zzcg zzcg) {
        synchronized (this.zzfi) {
            this.zzfj = zzr.zzcd();
            Iterator<WeakReference<zzw>> it = this.zzfi.iterator();
            while (it.hasNext()) {
                zzw zzw = (zzw) it.next().get();
                if (zzw != null) {
                    zzw.zza(this.zzfj);
                } else {
                    it.remove();
                }
            }
        }
        if (this.zzfj.zzcg()) {
            this.zzbw.zzb(this.zzfj.zzce(), zzcg);
        }
        zzd(zzcg);
    }

    public final void zzc(WeakReference<zzw> weakReference) {
        synchronized (this.zzfi) {
            this.zzfi.add(weakReference);
        }
    }

    public final void zzd(WeakReference<zzw> weakReference) {
        synchronized (this.zzfi) {
            this.zzfi.remove(weakReference);
        }
    }

    private final void zzd(zzcg zzcg) {
        if (this.zzfj.zzcg()) {
            this.zzbw.zza(this.zzfj, zzcg);
        } else {
            this.zzbw.zzbz();
        }
    }
}

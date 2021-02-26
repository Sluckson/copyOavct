package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzmb;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
public final class zzjv extends zzkm {
    private String zzb;
    private boolean zzc;
    private long zzd;

    zzjv(zzkp zzkp) {
        super(zzkp);
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> zza(String str, zzad zzad) {
        if (!zzmb.zzb() || !zzs().zza(zzat.zzcp) || zzad.zzc()) {
            return zzb(str);
        }
        return new Pair<>("", false);
    }

    @WorkerThread
    @NonNull
    @Deprecated
    private final Pair<String, Boolean> zzb(String str) {
        zzc();
        long elapsedRealtime = zzl().elapsedRealtime();
        String str2 = this.zzb;
        if (str2 != null && elapsedRealtime < this.zzd) {
            return new Pair<>(str2, Boolean.valueOf(this.zzc));
        }
        this.zzd = elapsedRealtime + zzs().zze(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzm());
            if (advertisingIdInfo != null) {
                this.zzb = advertisingIdInfo.getId();
                this.zzc = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzb == null) {
                this.zzb = "";
            }
        } catch (Exception e) {
            zzq().zzv().zza("Unable to get advertising id", e);
            this.zzb = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzb, Boolean.valueOf(this.zzc));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @Deprecated
    public final String zza(String str) {
        zzc();
        String str2 = (String) zzb(str).first;
        MessageDigest zzh = zzkx.zzh();
        if (zzh == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzh.digest(str2.getBytes()))});
    }

    public final /* bridge */ /* synthetic */ zzjv zzf() {
        return super.zzf();
    }

    /* renamed from: f_ */
    public final /* bridge */ /* synthetic */ zzkt mo23251f_() {
        return super.mo23251f_();
    }

    public final /* bridge */ /* synthetic */ zzo zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzac zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfv zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzev zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfu zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzex zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }
}

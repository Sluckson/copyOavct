package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmb;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfj extends zzgx {
    @VisibleForTesting
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private String zzaa;
    private boolean zzab;
    private long zzac;
    public zzfm zzb;
    public final zzfn zzc = new zzfn(this, "last_upload", 0);
    public final zzfn zzd = new zzfn(this, "last_upload_attempt", 0);
    public final zzfn zze = new zzfn(this, "backoff", 0);
    public final zzfn zzf = new zzfn(this, "last_delete_stale", 0);
    public final zzfn zzg = new zzfn(this, "midnight_offset", 0);
    public final zzfn zzh = new zzfn(this, "first_open_time", 0);
    public final zzfn zzi = new zzfn(this, "app_install_time", 0);
    public final zzfp zzj = new zzfp(this, "app_instance_id", (String) null);
    public final zzfn zzk = new zzfn(this, "time_before_start", 10000);
    public final zzfn zzl = new zzfn(this, "session_timeout", 1800000);
    public final zzfl zzm = new zzfl(this, "start_new_session", true);
    public final zzfp zzn = new zzfp(this, "non_personalized_ads", (String) null);
    public final zzfl zzo = new zzfl(this, "allow_remote_dynamite", false);
    public final zzfn zzp = new zzfn(this, "last_pause_time", 0);
    public boolean zzq;
    public zzfl zzr = new zzfl(this, "app_backgrounded", false);
    public zzfl zzs = new zzfl(this, "deep_link_retrieval_complete", false);
    public zzfn zzt = new zzfn(this, "deep_link_retrieval_attempts", 0);
    public final zzfp zzu = new zzfp(this, "firebase_feature_rollouts", (String) null);
    public final zzfp zzv = new zzfp(this, "deferred_attribution_cache", (String) null);
    public final zzfn zzw = new zzfn(this, "deferred_attribution_cache_timestamp", 0);
    public final zzfk zzx = new zzfk(this, "default_event_parameters", (Bundle) null);
    private SharedPreferences zzz;

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> zza(String str) {
        zzc();
        long elapsedRealtime = zzl().elapsedRealtime();
        String str2 = this.zzaa;
        if (str2 != null && elapsedRealtime < this.zzac) {
            return new Pair<>(str2, Boolean.valueOf(this.zzab));
        }
        this.zzac = elapsedRealtime + zzs().zze(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzm());
            if (advertisingIdInfo != null) {
                this.zzaa = advertisingIdInfo.getId();
                this.zzab = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzaa == null) {
                this.zzaa = "";
            }
        } catch (Exception e) {
            zzq().zzv().zza("Unable to get advertising id", e);
            this.zzaa = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzaa, Boolean.valueOf(this.zzab));
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return true;
    }

    zzfj(zzgb zzgb) {
        super(zzgb);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    /* renamed from: g_ */
    public final void mo23267g_() {
        this.zzz = zzm().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzq = this.zzz.getBoolean("has_been_opened", false);
        if (!this.zzq) {
            SharedPreferences.Editor edit = this.zzz.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzfm(this, "health_monitor", Math.max(0, zzat.zzb.zza(null).longValue()));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final SharedPreferences zzf() {
        zzc();
        zzaa();
        return this.zzz;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(String str) {
        zzc();
        SharedPreferences.Editor edit = zzf().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzg() {
        zzc();
        return zzf().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(String str) {
        zzc();
        SharedPreferences.Editor edit = zzf().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzh() {
        zzc();
        return zzf().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzi() {
        zzc();
        if (!zzf().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzf().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(boolean z) {
        zzc();
        SharedPreferences.Editor edit = zzf().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzj() {
        zzc();
        Boolean zzu2 = zzu();
        SharedPreferences.Editor edit = zzf().edit();
        edit.clear();
        edit.apply();
        if (zzu2 != null) {
            zza(zzu2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(Boolean bool) {
        zzc();
        SharedPreferences.Editor edit = zzf().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzu() {
        zzc();
        if (zzf().contains("measurement_enabled")) {
            return Boolean.valueOf(zzf().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(Boolean bool) {
        if (zzmb.zzb() && zzs().zza(zzat.zzco)) {
            zzc();
            SharedPreferences.Editor edit = zzf().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzv() {
        if (!zzmb.zzb() || !zzs().zza(zzat.zzco)) {
            return null;
        }
        zzc();
        if (zzf().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(zzf().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zza(zzad zzad, int i) {
        if (!zzmb.zzb() || !zzs().zza(zzat.zzco)) {
            return false;
        }
        zzc();
        if (!zza(i)) {
            return false;
        }
        SharedPreferences.Editor edit = zzf().edit();
        edit.putString("consent_settings", zzad.zza());
        edit.putInt("consent_source", i);
        edit.apply();
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zza(int i) {
        return zzad.zza(i, zzf().getInt("consent_source", 100));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzad zzw() {
        zzc();
        return zzad.zza(zzf().getString("consent_settings", "G1"));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzx() {
        zzc();
        String string = zzf().getString("previous_os_version", (String) null);
        zzk().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzf().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(boolean z) {
        zzc();
        zzq().zzw().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzf().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzy() {
        return this.zzz.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzp.zza();
    }
}

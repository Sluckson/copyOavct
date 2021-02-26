package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzmn;
import com.google.android.gms.internal.measurement.zznr;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public class zzgb implements zzgw {
    private static volatile zzgb zzb;
    @VisibleForTesting
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    @VisibleForTesting
    private Boolean zzad;
    @VisibleForTesting
    private Boolean zzae;
    private volatile boolean zzaf;
    private int zzag;
    private AtomicInteger zzah = new AtomicInteger(0);
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzx zzh;
    private final zzy zzi;
    private final zzfj zzj;
    private final zzex zzk;
    private final zzfu zzl;
    private final zzkb zzm;
    private final zzkx zzn;
    private final zzev zzo;
    private final Clock zzp;
    private final zzim zzq;
    private final zzhe zzr;
    private final zza zzs;
    private final zzih zzt;
    private zzet zzu;
    private zziv zzv;
    private zzal zzw;
    private zzeq zzx;
    private zzfo zzy;
    private boolean zzz = false;

    private zzgb(zzhf zzhf) {
        long j;
        boolean z = false;
        Preconditions.checkNotNull(zzhf);
        this.zzh = new zzx(zzhf.zza);
        zzen.zza = this.zzh;
        this.zzc = zzhf.zza;
        this.zzd = zzhf.zzb;
        this.zze = zzhf.zzc;
        this.zzf = zzhf.zzd;
        this.zzg = zzhf.zzh;
        this.zzac = zzhf.zze;
        this.zzaf = true;
        zzae zzae2 = zzhf.zzg;
        if (!(zzae2 == null || zzae2.zzg == null)) {
            Object obj = zzae2.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzae2.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        zzdc.zza(this.zzc);
        this.zzp = DefaultClock.getInstance();
        if (zzhf.zzi != null) {
            j = zzhf.zzi.longValue();
        } else {
            j = this.zzp.currentTimeMillis();
        }
        this.zza = j;
        this.zzi = new zzy(this);
        zzfj zzfj = new zzfj(this);
        zzfj.zzab();
        this.zzj = zzfj;
        zzex zzex = new zzex(this);
        zzex.zzab();
        this.zzk = zzex;
        zzkx zzkx = new zzkx(this);
        zzkx.zzab();
        this.zzn = zzkx;
        zzev zzev = new zzev(this);
        zzev.zzab();
        this.zzo = zzev;
        this.zzs = new zza(this);
        zzim zzim = new zzim(this);
        zzim.zzw();
        this.zzq = zzim;
        zzhe zzhe = new zzhe(this);
        zzhe.zzw();
        this.zzr = zzhe;
        zzkb zzkb = new zzkb(this);
        zzkb.zzw();
        this.zzm = zzkb;
        zzih zzih = new zzih(this);
        zzih.zzab();
        this.zzt = zzih;
        zzfu zzfu = new zzfu(this);
        zzfu.zzab();
        this.zzl = zzfu;
        if (!(zzhf.zzg == null || zzhf.zzg.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        if (this.zzc.getApplicationContext() instanceof Application) {
            zzhe zzg2 = zzg();
            if (zzg2.zzm().getApplicationContext() instanceof Application) {
                Application application = (Application) zzg2.zzm().getApplicationContext();
                if (zzg2.zza == null) {
                    zzg2.zza = new zzic(zzg2, (zzhj) null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzg2.zza);
                    application.registerActivityLifecycleCallbacks(zzg2.zza);
                    zzg2.zzq().zzw().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzq().zzh().zza("Application context is not an Application");
        }
        this.zzl.zza((Runnable) new zzgd(this, zzhf));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzhf zzhf) {
        String str;
        zzez zzez;
        zzp().zzc();
        zzal zzal = new zzal(this);
        zzal.zzab();
        this.zzw = zzal;
        zzeq zzeq = new zzeq(this, zzhf.zzf);
        zzeq.zzw();
        this.zzx = zzeq;
        zzet zzet = new zzet(this);
        zzet.zzw();
        this.zzu = zzet;
        zziv zziv = new zziv(this);
        zziv.zzw();
        this.zzv = zziv;
        this.zzn.zzac();
        this.zzj.zzac();
        this.zzy = new zzfo(this);
        this.zzx.zzx();
        zzq().zzu().zza("App measurement initialized, version", 31049L);
        zzq().zzu().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzaa2 = zzeq.zzaa();
        if (TextUtils.isEmpty(this.zzd)) {
            if (zzh().zze(zzaa2)) {
                zzez = zzq().zzu();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzez = zzq().zzu();
                String valueOf = String.valueOf(zzaa2);
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
            }
            zzez.zza(str);
        }
        zzq().zzv().zza("Debug-level message logging enabled");
        if (this.zzag != this.zzah.get()) {
            zzq().zze().zza("Not all components initialized", Integer.valueOf(this.zzag), Integer.valueOf(this.zzah.get()));
        }
        this.zzz = true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzae zzae2) {
        zzad zzad2;
        zzp().zzc();
        if (zzmb.zzb() && this.zzi.zza(zzat.zzco)) {
            zzad zzw2 = zzb().zzw();
            if (!(zzae2 == null || zzae2.zzg == null || !zzb().zza(30))) {
                zzad2 = zzad.zzb(zzae2.zzg);
                if (!zzad2.equals(zzad.zza)) {
                    zzg().zza(zzad2, 30, this.zza);
                    zzg().zza(zzad2);
                }
            }
            zzad2 = zzw2;
            zzg().zza(zzad2);
        }
        if (zzb().zzc.zza() == 0) {
            zzb().zzc.zza(this.zzp.currentTimeMillis());
        }
        if (Long.valueOf(zzb().zzh.zza()).longValue() == 0) {
            zzq().zzw().zza("Persisting first open", Long.valueOf(this.zza));
            zzb().zzh.zza(this.zza);
        }
        if (this.zzi.zza(zzat.zzck)) {
            zzg().zzb.zzb();
        }
        if (zzaf()) {
            if (!TextUtils.isEmpty(zzx().zzab()) || !TextUtils.isEmpty(zzx().zzac())) {
                zzh();
                if (zzkx.zza(zzx().zzab(), zzb().zzg(), zzx().zzac(), zzb().zzh())) {
                    zzq().zzu().zza("Rechecking which service to use due to a GMP App Id change");
                    zzb().zzj();
                    zzj().zzaa();
                    this.zzv.zzag();
                    this.zzv.zzae();
                    zzb().zzh.zza(this.zza);
                    zzb().zzj.zza((String) null);
                }
                zzb().zzb(zzx().zzab());
                zzb().zzc(zzx().zzac());
            }
            if (zzmb.zzb() && this.zzi.zza(zzat.zzco) && !zzb().zzw().zze()) {
                zzb().zzj.zza((String) null);
            }
            zzg().zza(zzb().zzj.zza());
            if (zzmn.zzb() && this.zzi.zza(zzat.zzbq) && !zzh().zzj() && !TextUtils.isEmpty(zzb().zzu.zza())) {
                zzq().zzh().zza("Remote config removed with active feature rollouts");
                zzb().zzu.zza((String) null);
            }
            if (!TextUtils.isEmpty(zzx().zzab()) || !TextUtils.isEmpty(zzx().zzac())) {
                boolean zzaa2 = zzaa();
                if (!zzb().zzy() && !this.zzi.zzf()) {
                    zzb().zzb(!zzaa2);
                }
                if (zzaa2) {
                    zzg().zzah();
                }
                zzd().zza.zza();
                zzv().zza((AtomicReference<String>) new AtomicReference());
                if (zznr.zzb() && this.zzi.zza(zzat.zzcg)) {
                    zzv().zza(zzb().zzx.zza());
                }
            }
        } else if (zzaa()) {
            if (!zzh().zzc("android.permission.INTERNET")) {
                zzq().zze().zza("App is missing INTERNET permission");
            }
            if (!zzh().zzc("android.permission.ACCESS_NETWORK_STATE")) {
                zzq().zze().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zzc).isCallerInstantApp() && !this.zzi.zzw()) {
                if (!zzft.zza(this.zzc)) {
                    zzq().zze().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzkx.zza(this.zzc, false)) {
                    zzq().zze().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzq().zze().zza("Uploading is not possible. App measurement disabled");
        }
        zzb().zzo.zza(this.zzi.zza(zzat.zzay));
    }

    public final zzx zzt() {
        return this.zzh;
    }

    public final zzy zza() {
        return this.zzi;
    }

    public final zzfj zzb() {
        zza((zzgu) this.zzj);
        return this.zzj;
    }

    public final zzex zzq() {
        zzb((zzgx) this.zzk);
        return this.zzk;
    }

    public final zzex zzc() {
        zzex zzex = this.zzk;
        if (zzex == null || !zzex.zzz()) {
            return null;
        }
        return this.zzk;
    }

    public final zzfu zzp() {
        zzb((zzgx) this.zzl);
        return this.zzl;
    }

    public final zzkb zzd() {
        zzb((zzg) this.zzm);
        return this.zzm;
    }

    public final zzfo zze() {
        return this.zzy;
    }

    /* access modifiers changed from: package-private */
    public final zzfu zzf() {
        return this.zzl;
    }

    public final zzhe zzg() {
        zzb((zzg) this.zzr);
        return this.zzr;
    }

    public final zzkx zzh() {
        zza((zzgu) this.zzn);
        return this.zzn;
    }

    public final zzev zzi() {
        zza((zzgu) this.zzo);
        return this.zzo;
    }

    public final zzet zzj() {
        zzb((zzg) this.zzu);
        return this.zzu;
    }

    private final zzih zzah() {
        zzb((zzgx) this.zzt);
        return this.zzt;
    }

    public final Context zzm() {
        return this.zzc;
    }

    public final boolean zzk() {
        return TextUtils.isEmpty(this.zzd);
    }

    public final String zzn() {
        return this.zzd;
    }

    public final String zzo() {
        return this.zze;
    }

    public final String zzr() {
        return this.zzf;
    }

    public final boolean zzs() {
        return this.zzg;
    }

    public final Clock zzl() {
        return this.zzp;
    }

    public final zzim zzu() {
        zzb((zzg) this.zzq);
        return this.zzq;
    }

    public final zziv zzv() {
        zzb((zzg) this.zzv);
        return this.zzv;
    }

    public final zzal zzw() {
        zzb((zzgx) this.zzw);
        return this.zzw;
    }

    public final zzeq zzx() {
        zzb((zzg) this.zzx);
        return this.zzx;
    }

    public final zza zzy() {
        zza zza2 = this.zzs;
        if (zza2 != null) {
            return zza2;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzgb zza(Context context, zzae zzae2, Long l) {
        if (zzae2 != null && (zzae2.zze == null || zzae2.zzf == null)) {
            zzae2 = new zzae(zzae2.zza, zzae2.zzb, zzae2.zzc, zzae2.zzd, (String) null, (String) null, zzae2.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzgb.class) {
                if (zzb == null) {
                    zzb = new zzgb(new zzhf(context, zzae2, l));
                }
            }
        } else if (!(zzae2 == null || zzae2.zzg == null || !zzae2.zzg.containsKey("dataCollectionDefaultEnabled"))) {
            zzb.zza(zzae2.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzb;
    }

    private static void zzb(zzgx zzgx) {
        if (zzgx == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgx.zzz()) {
            String valueOf = String.valueOf(zzgx.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zzb(zzg zzg2) {
        if (zzg2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzg2.zzu()) {
            String valueOf = String.valueOf(zzg2.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zza(zzgu zzgu) {
        if (zzgu == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    @WorkerThread
    public final boolean zzz() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    @WorkerThread
    public final boolean zzaa() {
        return zzab() == 0;
    }

    @WorkerThread
    public final int zzab() {
        zzp().zzc();
        if (this.zzi.zzf()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (zzmb.zzb() && this.zzi.zza(zzat.zzco) && !zzac()) {
            return 8;
        }
        Boolean zzu2 = zzb().zzu();
        if (zzu2 == null) {
            Boolean zzf2 = this.zzi.zzf("firebase_analytics_collection_enabled");
            if (zzf2 == null) {
                Boolean bool2 = this.zzad;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                    return 6;
                } else {
                    if (!this.zzi.zza(zzat.zzas) || this.zzac == null || this.zzac.booleanValue()) {
                        return 0;
                    }
                    return 7;
                }
            } else if (zzf2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzu2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @WorkerThread
    public final void zzb(boolean z) {
        zzp().zzc();
        this.zzaf = z;
    }

    @WorkerThread
    public final boolean zzac() {
        zzp().zzc();
        return this.zzaf;
    }

    /* access modifiers changed from: package-private */
    public final void zzad() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgx zzgx) {
        this.zzag++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzg zzg2) {
        this.zzag++;
    }

    /* access modifiers changed from: package-private */
    public final void zzae() {
        this.zzah.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzaf() {
        if (this.zzz) {
            zzp().zzc();
            Boolean bool = this.zzaa;
            if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
                this.zzab = this.zzp.elapsedRealtime();
                boolean z = true;
                this.zzaa = Boolean.valueOf(zzh().zzc("android.permission.INTERNET") && zzh().zzc("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzw() || (zzft.zza(this.zzc) && zzkx.zza(this.zzc, false))));
                if (this.zzaa.booleanValue()) {
                    if (!zzh().zza(zzx().zzab(), zzx().zzac(), zzx().zzad()) && TextUtils.isEmpty(zzx().zzac())) {
                        z = false;
                    }
                    this.zzaa = Boolean.valueOf(z);
                }
            }
            return this.zzaa.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @WorkerThread
    public final void zzag() {
        zzp().zzc();
        zzb((zzgx) zzah());
        String zzaa2 = zzx().zzaa();
        Pair<String, Boolean> zza2 = zzb().zza(zzaa2);
        if (!this.zzi.zzg().booleanValue() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzq().zzv().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!zzah().zzf()) {
            zzq().zzh().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            zzkx zzh2 = zzh();
            zzx();
            URL zza3 = zzh2.zza(31049, zzaa2, (String) zza2.first, zzb().zzt.zza() - 1);
            zzih zzah2 = zzah();
            zzga zzga = new zzga(this);
            zzah2.zzc();
            zzah2.zzaa();
            Preconditions.checkNotNull(zza3);
            Preconditions.checkNotNull(zzga);
            zzah2.zzp().zzc((Runnable) new zzij(zzah2, zzaa2, zza3, (byte[]) null, (Map<String, String>) null, zzga));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzq().zzh().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzb().zzs.zza(true);
        if (bArr.length == 0) {
            zzq().zzv().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            if (TextUtils.isEmpty(optString)) {
                zzq().zzv().zza("Deferred Deep Link is empty.");
                return;
            }
            zzkx zzh2 = zzh();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzh2.zzm().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzq().zzh().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", bundle);
            zzkx zzh3 = zzh();
            if (!TextUtils.isEmpty(optString) && zzh3.zza(optString, optDouble)) {
                zzh3.zzm().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzq().zze().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}

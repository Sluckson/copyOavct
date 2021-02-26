package com.google.android.gms.internal.p010firebaseperf;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.internal.zzb;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzah */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzah {
    private static volatile zzah zzac;
    private zzbo zzag = new zzbo();
    private RemoteConfigManager zzah = RemoteConfigManager.zzci();
    private zzbb zzai = zzbb.zzbd();
    private zzbi zzaj = zzbi.zzcl();

    @VisibleForTesting
    private zzah(@Nullable RemoteConfigManager remoteConfigManager, @Nullable zzbo zzbo, @Nullable zzbb zzbb) {
    }

    private static boolean zza(float f) {
        return 0.0f <= f && f <= 1.0f;
    }

    private static boolean zzb(long j) {
        return j >= 0;
    }

    private static boolean zzc(long j) {
        return j > 0;
    }

    private static boolean zzd(long j) {
        return j >= 0;
    }

    private static boolean zze(long j) {
        return j > 0;
    }

    public static synchronized zzah zzo() {
        zzah zzah2;
        synchronized (zzah.class) {
            if (zzac == null) {
                zzac = new zzah((RemoteConfigManager) null, (zzbo) null, (zzbb) null);
            }
            zzah2 = zzac;
        }
        return zzah2;
    }

    public final void zzb(Context context) {
        zzc(context.getApplicationContext());
    }

    public final void zzc(Context context) {
        zzbi.zzcl().zze(zzca.zzg(context));
        this.zzai.zzd(context);
    }

    public final void zza(zzbo zzbo) {
        this.zzag = zzbo;
    }

    public final boolean zzp() {
        Boolean zzq = zzq();
        if ((zzq == null || zzq.booleanValue()) && zzs()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Boolean zzq() {
        if (zzr().booleanValue()) {
            return false;
        }
        zzaj zzal = zzaj.zzal();
        zzbn<Boolean> zzg = zzg(zzal);
        if (zzg.isPresent()) {
            return (Boolean) zza(zzal, zzg.get());
        }
        zzbn<Boolean> zza = zza((zzay<Boolean>) zzal);
        if (zza.isPresent()) {
            return (Boolean) zza(zzal, zza.get());
        }
        this.zzaj.zzm("CollectionEnabled metadata key unknown or value not found in manifest.");
        return (Boolean) zza(zzal, (Object) null);
    }

    @Nullable
    public final Boolean zzr() {
        zzag zzm = zzag.zzm();
        zzbn<Boolean> zza = zza((zzay<Boolean>) zzm);
        if (zza.isPresent()) {
            return (Boolean) zza(zzm, zza.get());
        }
        return (Boolean) zza(zzm, false);
    }

    public final void zza(boolean z) {
        String zzak;
        if (!zzr().booleanValue() && (zzak = zzaj.zzal().zzak()) != null) {
            this.zzai.zza(zzak, z);
        }
    }

    public final boolean zzs() {
        boolean z;
        boolean z2;
        this.zzaj.zzm("Retrieving master flag for Firebase Performance SDK enabled configuration value.");
        zzao zzaq = zzao.zzaq();
        zzbn<Boolean> zzb = this.zzah.zzb(zzaq.zzaj());
        if (!zzb.isPresent()) {
            zzbn<Boolean> zzg = zzg(zzaq);
            if (zzg.isPresent()) {
                z = ((Boolean) zza(zzaq, zzg.get())).booleanValue();
            } else {
                z = ((Boolean) zza(zzaq, true)).booleanValue();
            }
        } else if (this.zzah.zzcj()) {
            z = ((Boolean) zza(zzaq, false)).booleanValue();
        } else {
            this.zzai.zza(zzaq.zzak(), zzb.get().booleanValue());
            z = ((Boolean) zza(zzaq, zzb.get())).booleanValue();
        }
        if (z) {
            this.zzaj.zzm("Retrieving Firebase Performance SDK disabled versions configuration value.");
            zzap zzar = zzap.zzar();
            zzbn<String> zzc = this.zzah.zzc(zzar.zzaj());
            if (zzc.isPresent()) {
                this.zzai.zza(zzar.zzak(), zzc.get());
                z2 = zza(zzar, zzc.get(), zza(zzc.get()));
            } else {
                zzbn<String> zzh = zzh(zzar);
                if (zzh.isPresent()) {
                    z2 = zza(zzar, zzh.get(), zza(zzh.get()));
                } else {
                    z2 = zza(zzar, "", zza(""));
                }
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    private static boolean zza(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String trim : str.split(";")) {
            if (trim.trim().equals(zzb.VERSION_NAME)) {
                return true;
            }
        }
        return false;
    }

    public final float zzt() {
        this.zzaj.zzm("Retrieving trace sampling rate configuration value.");
        zzaz zzba = zzaz.zzba();
        zzbn<Float> zzc = zzc((zzay<Float>) zzba);
        if (!zzc.isPresent() || !zza(zzc.get().floatValue())) {
            zzbn<Float> zze = zze((zzay<Float>) zzba);
            if (!zze.isPresent() || !zza(zze.get().floatValue())) {
                return ((Float) zza(zzba, Float.valueOf(1.0f))).floatValue();
            }
            return ((Float) zza(zzba, zze.get())).floatValue();
        }
        this.zzai.zza(zzba.zzak(), zzc.get().floatValue());
        return ((Float) zza(zzba, zzc.get())).floatValue();
    }

    public final float zzu() {
        this.zzaj.zzm("Retrieving network request sampling rate configuration value.");
        zzan zzap = zzan.zzap();
        zzbn<Float> zzc = zzc((zzay<Float>) zzap);
        if (!zzc.isPresent() || !zza(zzc.get().floatValue())) {
            zzbn<Float> zze = zze((zzay<Float>) zzap);
            if (!zze.isPresent() || !zza(zze.get().floatValue())) {
                return ((Float) zza(zzap, Float.valueOf(1.0f))).floatValue();
            }
            return ((Float) zza(zzap, zze.get())).floatValue();
        }
        this.zzai.zza(zzap.zzak(), zzc.get().floatValue());
        return ((Float) zza(zzap, zzc.get())).floatValue();
    }

    public final float zzv() {
        this.zzaj.zzm("Retrieving session sampling rate configuration value.");
        zzau zzaw = zzau.zzaw();
        zzbn<Float> zzd = this.zzag.zzd(zzaw.zzn());
        if (zzd.isPresent()) {
            float floatValue = zzd.get().floatValue() / 100.0f;
            if (zza(floatValue)) {
                return ((Float) zza(zzaw, Float.valueOf(floatValue))).floatValue();
            }
        }
        zzbn<Float> zzc = zzc((zzay<Float>) zzaw);
        if (!zzc.isPresent() || !zza(zzc.get().floatValue())) {
            zzbn<Float> zze = zze((zzay<Float>) zzaw);
            if (!zze.isPresent() || !zza(zze.get().floatValue())) {
                return ((Float) zza(zzaw, Float.valueOf(0.01f))).floatValue();
            }
            return ((Float) zza(zzaw, zze.get())).floatValue();
        }
        this.zzai.zza(zzaw.zzak(), zzc.get().floatValue());
        return ((Float) zza(zzaw, zzc.get())).floatValue();
    }

    public final long zzw() {
        this.zzaj.zzm("Retrieving Session CPU Capture Frequency on foreground (milliseonds) configuration value.");
        zzaq zzas = zzaq.zzas();
        zzbn<Long> zzb = zzb((zzay<Long>) zzas);
        if (zzb.isPresent() && zzd(zzb.get().longValue())) {
            return ((Long) zza(zzas, zzb.get())).longValue();
        }
        zzbn<Long> zzd = zzd((zzay<Long>) zzas);
        if (!zzd.isPresent() || !zzd(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzas);
            if (!zzf.isPresent() || !zzd(zzf.get().longValue())) {
                return ((Long) zza(zzas, 100L)).longValue();
            }
            return ((Long) zza(zzas, zzf.get())).longValue();
        }
        this.zzai.zza(zzas.zzak(), zzd.get().longValue());
        return ((Long) zza(zzas, zzd.get())).longValue();
    }

    public final long zzx() {
        this.zzaj.zzm("Retrieving Session CPU Capture Frequency on background (milliseonds) configuration value.");
        zzar zzat = zzar.zzat();
        zzbn<Long> zzb = zzb((zzay<Long>) zzat);
        if (zzb.isPresent() && zzd(zzb.get().longValue())) {
            return ((Long) zza(zzat, zzb.get())).longValue();
        }
        zzbn<Long> zzd = zzd((zzay<Long>) zzat);
        if (!zzd.isPresent() || !zzd(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzat);
            if (!zzf.isPresent() || !zzd(zzf.get().longValue())) {
                return ((Long) zza(zzat, 0L)).longValue();
            }
            return ((Long) zza(zzat, zzf.get())).longValue();
        }
        this.zzai.zza(zzat.zzak(), zzd.get().longValue());
        return ((Long) zza(zzat, zzd.get())).longValue();
    }

    public final long zzy() {
        this.zzaj.zzm("Retrieving Session Memory Capture Frequency on foreground (milliseonds) configuration value.");
        zzav zzax = zzav.zzax();
        zzbn<Long> zzb = zzb((zzay<Long>) zzax);
        if (zzb.isPresent() && zzd(zzb.get().longValue())) {
            return ((Long) zza(zzax, zzb.get())).longValue();
        }
        zzbn<Long> zzd = zzd((zzay<Long>) zzax);
        if (!zzd.isPresent() || !zzd(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzax);
            if (!zzf.isPresent() || !zzd(zzf.get().longValue())) {
                return ((Long) zza(zzax, 100L)).longValue();
            }
            return ((Long) zza(zzax, zzf.get())).longValue();
        }
        this.zzai.zza(zzax.zzak(), zzd.get().longValue());
        return ((Long) zza(zzax, zzd.get())).longValue();
    }

    public final long zzz() {
        this.zzaj.zzm("Retrieving Session Memory Capture Frequency on background (milliseonds) configuration value.");
        zzas zzau = zzas.zzau();
        zzbn<Long> zzb = zzb((zzay<Long>) zzau);
        if (zzb.isPresent() && zzd(zzb.get().longValue())) {
            return ((Long) zza(zzau, zzb.get())).longValue();
        }
        zzbn<Long> zzd = zzd((zzay<Long>) zzau);
        if (!zzd.isPresent() || !zzd(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzau);
            if (!zzf.isPresent() || !zzd(zzf.get().longValue())) {
                return ((Long) zza(zzau, 0L)).longValue();
            }
            return ((Long) zza(zzau, zzf.get())).longValue();
        }
        this.zzai.zza(zzau.zzak(), zzd.get().longValue());
        return ((Long) zza(zzau, zzd.get())).longValue();
    }

    public final long zzaa() {
        this.zzaj.zzm("Retrieving Max Duration (in minutes) of single Session configuration value.");
        zzat zzav = zzat.zzav();
        zzbn<Long> zzb = zzb((zzay<Long>) zzav);
        if (zzb.isPresent() && zze(zzb.get().longValue())) {
            return ((Long) zza(zzav, zzb.get())).longValue();
        }
        zzbn<Long> zzd = zzd((zzay<Long>) zzav);
        if (!zzd.isPresent() || !zze(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzav);
            if (!zzf.isPresent() || !zze(zzf.get().longValue())) {
                return ((Long) zza(zzav, 240L)).longValue();
            }
            return ((Long) zza(zzav, zzf.get())).longValue();
        }
        this.zzai.zza(zzav.zzak(), zzd.get().longValue());
        return ((Long) zza(zzav, zzd.get())).longValue();
    }

    public final long zzab() {
        this.zzaj.zzm("Retrieving trace event count foreground configuration value.");
        zzaw zzay = zzaw.zzay();
        zzbn<Long> zzd = zzd((zzay<Long>) zzay);
        if (!zzd.isPresent() || !zzb(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzay);
            if (!zzf.isPresent() || !zzb(zzf.get().longValue())) {
                return ((Long) zza(zzay, 300L)).longValue();
            }
            return ((Long) zza(zzay, zzf.get())).longValue();
        }
        this.zzai.zza(zzay.zzak(), zzd.get().longValue());
        return ((Long) zza(zzay, zzd.get())).longValue();
    }

    public final long zzac() {
        this.zzaj.zzm("Retrieving trace event count background configuration value.");
        zzax zzaz = zzax.zzaz();
        zzbn<Long> zzd = zzd((zzay<Long>) zzaz);
        if (!zzd.isPresent() || !zzb(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzaz);
            if (!zzf.isPresent() || !zzb(zzf.get().longValue())) {
                return ((Long) zza(zzaz, 30L)).longValue();
            }
            return ((Long) zza(zzaz, zzf.get())).longValue();
        }
        this.zzai.zza(zzaz.zzak(), zzd.get().longValue());
        return ((Long) zza(zzaz, zzd.get())).longValue();
    }

    public final long zzad() {
        this.zzaj.zzm("Retrieving network event count foreground configuration value.");
        zzak zzam = zzak.zzam();
        zzbn<Long> zzd = zzd((zzay<Long>) zzam);
        if (!zzd.isPresent() || !zzb(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzam);
            if (!zzf.isPresent() || !zzb(zzf.get().longValue())) {
                return ((Long) zza(zzam, 700L)).longValue();
            }
            return ((Long) zza(zzam, zzf.get())).longValue();
        }
        this.zzai.zza(zzam.zzak(), zzd.get().longValue());
        return ((Long) zza(zzam, zzd.get())).longValue();
    }

    public final long zzae() {
        this.zzaj.zzm("Retrieving network event count background configuration value.");
        zzal zzan = zzal.zzan();
        zzbn<Long> zzd = zzd((zzay<Long>) zzan);
        if (!zzd.isPresent() || !zzb(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzan);
            if (!zzf.isPresent() || !zzb(zzf.get().longValue())) {
                return ((Long) zza(zzan, 70L)).longValue();
            }
            return ((Long) zza(zzan, zzf.get())).longValue();
        }
        this.zzai.zza(zzan.zzak(), zzd.get().longValue());
        return ((Long) zza(zzan, zzd.get())).longValue();
    }

    public final long zzaf() {
        this.zzaj.zzm("Retrieving rate limiting time range (in seconds) configuration value.");
        zzam zzao = zzam.zzao();
        zzbn<Long> zzd = zzd((zzay<Long>) zzao);
        if (!zzd.isPresent() || !zzc(zzd.get().longValue())) {
            zzbn<Long> zzf = zzf(zzao);
            if (!zzf.isPresent() || !zzc(zzf.get().longValue())) {
                return ((Long) zza(zzao, 600L)).longValue();
            }
            return ((Long) zza(zzao, zzf.get())).longValue();
        }
        this.zzai.zza(zzao.zzak(), zzd.get().longValue());
        return ((Long) zza(zzao, zzd.get())).longValue();
    }

    public final String zzag() {
        String zzf;
        zzai zzah2 = zzai.zzah();
        if (zzb.zzcs) {
            return (String) zza(zzah2, zzai.zzai());
        }
        String zzaj2 = zzah2.zzaj();
        long j = -1;
        if (zzaj2 != null) {
            j = ((Long) this.zzah.zza(zzaj2, -1L)).longValue();
        }
        String zzak = zzah2.zzak();
        if (!zzai.zzg(j) || (zzf = zzai.zzf(j)) == null) {
            zzbn<String> zzh = zzh(zzah2);
            if (zzh.isPresent()) {
                return (String) zza(zzah2, zzh.get());
            }
            return (String) zza(zzah2, zzai.zzai());
        }
        this.zzai.zza(zzak, zzf);
        return (String) zza(zzah2, zzf);
    }

    private final zzbn<Boolean> zza(zzay<Boolean> zzay) {
        return this.zzag.zzb(zzay.zzn());
    }

    private final zzbn<Long> zzb(zzay<Long> zzay) {
        return this.zzag.zze(zzay.zzn());
    }

    private final zzbn<Float> zzc(zzay<Float> zzay) {
        return this.zzah.zzd(zzay.zzaj());
    }

    private final zzbn<Long> zzd(zzay<Long> zzay) {
        return this.zzah.zze(zzay.zzaj());
    }

    private final zzbn<Float> zze(zzay<Float> zzay) {
        return this.zzai.zzd(zzay.zzak());
    }

    private final zzbn<Long> zzf(zzay<Long> zzay) {
        return this.zzai.zze(zzay.zzak());
    }

    private final zzbn<Boolean> zzg(zzay<Boolean> zzay) {
        return this.zzai.zzb(zzay.zzak());
    }

    private final zzbn<String> zzh(zzay<String> zzay) {
        return this.zzai.zzc(zzay.zzak());
    }

    private final <T> T zza(zzay<T> zzay, T t) {
        this.zzaj.zzm(String.format("Config resolver result for flag: '%s' is: '%s'.", new Object[]{zzay.getClass().getName(), String.valueOf(t)}));
        return t;
    }

    private final <T> boolean zza(zzay<T> zzay, T t, boolean z) {
        this.zzaj.zzm(String.format("Config resolver result for flag: '%s' is: '%s'. Resolving value as '%s'", new Object[]{zzay.getClass().getName(), String.valueOf(t), String.valueOf(z)}));
        return z;
    }
}

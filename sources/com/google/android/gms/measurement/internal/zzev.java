package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzmh;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzev extends zzgx {
    private static final AtomicReference<String[]> zza = new AtomicReference<>();
    private static final AtomicReference<String[]> zzb = new AtomicReference<>();
    private static final AtomicReference<String[]> zzc = new AtomicReference<>();

    zzev(zzgb zzgb) {
        super(zzgb);
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    private final boolean zzf() {
        return this.zzy.zzk() && this.zzy.zzq().zza(3);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        return zza(str, zzgy.zzc, zzgy.zza, zza);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        return zza(str, zzhb.zzb, zzhb.zza, zzb);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzha.zzb, zzha.zza, zzc);
        }
        return "experiment_id" + "(" + str + ")";
    }

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzkx.zzc(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzar zzar) {
        String str = null;
        if (zzar == null) {
            return null;
        }
        if (!zzf()) {
            return zzar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzar.zzc);
        sb.append(",name=");
        sb.append(zza(zzar.zza));
        sb.append(",params=");
        zzam zzam = zzar.zzb;
        if (zzam != null) {
            if (!zzf()) {
                str = zzam.toString();
            } else {
                str = zza(zzam.zzb());
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!zzf()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str2 : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(zzb(str2));
            sb.append("=");
            if (!zzmh.zzb() || !zzs().zza(zzat.zzbx)) {
                sb.append(bundle.get(str2));
            } else {
                Object obj = bundle.get(str2);
                if (obj instanceof Bundle) {
                    str = zza(new Object[]{obj});
                } else if (obj instanceof Object[]) {
                    str = zza((Object[]) obj);
                } else if (obj instanceof ArrayList) {
                    str = zza(((ArrayList) obj).toArray());
                } else {
                    str = String.valueOf(obj);
                }
                sb.append(str);
            }
        }
        sb.append("}]");
        return sb.toString();
    }

    @Nullable
    private final String zza(Object[] objArr) {
        String str;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = zza(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append("]");
        return sb.toString();
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

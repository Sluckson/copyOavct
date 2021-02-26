package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzex extends zzgx {
    /* access modifiers changed from: private */
    public char zza = 0;
    /* access modifiers changed from: private */
    public long zzb = -1;
    @GuardedBy("this")
    private String zzc;
    private final zzez zzd = new zzez(this, 6, false, false);
    private final zzez zze = new zzez(this, 6, true, false);
    private final zzez zzf = new zzez(this, 6, false, true);
    private final zzez zzg = new zzez(this, 5, false, false);
    private final zzez zzh = new zzez(this, 5, true, false);
    private final zzez zzi = new zzez(this, 5, false, true);
    private final zzez zzj = new zzez(this, 4, false, false);
    private final zzez zzk = new zzez(this, 3, false, false);
    private final zzez zzl = new zzez(this, 2, false, false);

    zzex(zzgb zzgb) {
        super(zzgb);
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    public final zzez zze() {
        return this.zzd;
    }

    public final zzez zzf() {
        return this.zze;
    }

    public final zzez zzg() {
        return this.zzf;
    }

    public final zzez zzh() {
        return this.zzg;
    }

    public final zzez zzi() {
        return this.zzh;
    }

    public final zzez zzj() {
        return this.zzi;
    }

    public final zzez zzu() {
        return this.zzj;
    }

    public final zzez zzv() {
        return this.zzk;
    }

    public final zzez zzw() {
        return this.zzl;
    }

    protected static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzey(str);
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zza(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzfu zzf2 = this.zzy.zzf();
            if (zzf2 == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
            } else if (!zzf2.zzz()) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i < 0) {
                    i = 0;
                }
                zzf2.zza((Runnable) new zzew(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
            }
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean zza(int i) {
        return Log.isLoggable(zzy(), i);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(int i, String str) {
        Log.println(i, zzy(), str);
    }

    @VisibleForTesting
    private final String zzy() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                this.zzc = this.zzy.zzr() != null ? this.zzy.zzr() : "FA";
            }
            str = this.zzc;
        }
        return str;
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zza2 = zza(z, obj);
        String zza3 = zza(z, obj2);
        String zza4 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zza2)) {
            sb.append(str2);
            sb.append(zza2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza3)) {
            sb.append(str2);
            sb.append(zza3);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza4)) {
            sb.append(str2);
            sb.append(zza4);
        }
        return sb.toString();
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + 43 + str.length());
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzb2 = zzb(zzgb.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(zzb2)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i++;
                }
                return sb2.toString();
            } else if (obj instanceof zzey) {
                return ((zzey) obj).zza;
            } else {
                if (z) {
                    return "-";
                }
                return String.valueOf(obj);
            }
        }
    }

    private static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public final String zzx() {
        Pair<String, Long> zza2 = zzr().zzb.zza();
        if (zza2 == null || zza2 == zzfj.zza) {
            return null;
        }
        String valueOf = String.valueOf(zza2.second);
        String str = (String) zza2.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
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

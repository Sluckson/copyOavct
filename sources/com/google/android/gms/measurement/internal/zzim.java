package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznf;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzim extends zzg {
    @VisibleForTesting
    protected zzin zza;
    private volatile zzin zzb;
    private zzin zzc;
    private final Map<Activity, zzin> zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzin zzg;
    /* access modifiers changed from: private */
    public zzin zzh;
    private boolean zzi;
    private final Object zzj = new Object();
    private zzin zzk;
    private String zzl;

    public zzim(zzgb zzgb) {
        super(zzgb);
    }

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return false;
    }

    @WorkerThread
    public final zzin zza(boolean z) {
        zzv();
        zzc();
        if (!zzs().zza(zzat.zzbw) || !z) {
            return this.zza;
        }
        zzin zzin = this.zza;
        return zzin != null ? zzin : this.zzh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00da, code lost:
        r1 = zzq().zzw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e2, code lost:
        if (r10 != null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e4, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e8, code lost:
        if (r11 != null) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ea, code lost:
        r3 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ed, code lost:
        r3 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ee, code lost:
        r1.zza("Logging screen view with name, class", r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f5, code lost:
        if (r8.zzb != null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f7, code lost:
        r1 = r8.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fa, code lost:
        r1 = r8.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fc, code lost:
        r5 = r1;
        r9 = new com.google.android.gms.measurement.internal.zzin(r10, r11, zzo().zzf(), true, r19);
        r8.zzb = r9;
        r8.zzc = r5;
        r8.zzg = r9;
        zzp().zza((java.lang.Runnable) new com.google.android.gms.measurement.internal.zzip(r17, r18, r9, r5, zzl().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.os.Bundle r18, long r19) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            com.google.android.gms.measurement.internal.zzy r1 = r17.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzbw
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r1 != 0) goto L_0x001e
            com.google.android.gms.measurement.internal.zzex r0 = r17.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzj()
            java.lang.String r1 = "Manual screen reporting is disabled."
            r0.zza(r1)
            return
        L_0x001e:
            java.lang.Object r1 = r8.zzj
            monitor-enter(r1)
            boolean r2 = r8.zzi     // Catch:{ all -> 0x012e }
            if (r2 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzex r0 = r17.zzq()     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzj()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = "Cannot log screen view event when the app is in the background."
            r0.zza(r2)     // Catch:{ all -> 0x012e }
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            return
        L_0x0034:
            r2 = 0
            if (r0 == 0) goto L_0x0092
            java.lang.String r2 = "screen_name"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x012e }
            r3 = 100
            if (r2 == 0) goto L_0x0064
            int r4 = r2.length()     // Catch:{ all -> 0x012e }
            if (r4 <= 0) goto L_0x004d
            int r4 = r2.length()     // Catch:{ all -> 0x012e }
            if (r4 <= r3) goto L_0x0064
        L_0x004d:
            com.google.android.gms.measurement.internal.zzex r0 = r17.zzq()     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzj()     // Catch:{ all -> 0x012e }
            java.lang.String r3 = "Invalid screen name length for screen view. Length"
            int r2 = r2.length()     // Catch:{ all -> 0x012e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x012e }
            r0.zza(r3, r2)     // Catch:{ all -> 0x012e }
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            return
        L_0x0064:
            java.lang.String r4 = "screen_class"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x012e }
            if (r4 == 0) goto L_0x008f
            int r5 = r4.length()     // Catch:{ all -> 0x012e }
            if (r5 <= 0) goto L_0x0078
            int r5 = r4.length()     // Catch:{ all -> 0x012e }
            if (r5 <= r3) goto L_0x008f
        L_0x0078:
            com.google.android.gms.measurement.internal.zzex r0 = r17.zzq()     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzj()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = "Invalid screen class length for screen view. Length"
            int r3 = r4.length()     // Catch:{ all -> 0x012e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x012e }
            r0.zza(r2, r3)     // Catch:{ all -> 0x012e }
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            return
        L_0x008f:
            r10 = r2
            r2 = r4
            goto L_0x0093
        L_0x0092:
            r10 = r2
        L_0x0093:
            if (r2 != 0) goto L_0x00aa
            android.app.Activity r2 = r8.zze     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00a8
            android.app.Activity r2 = r8.zze     // Catch:{ all -> 0x012e }
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = r2.getCanonicalName()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = zza((java.lang.String) r2)     // Catch:{ all -> 0x012e }
            goto L_0x00aa
        L_0x00a8:
            java.lang.String r2 = "Activity"
        L_0x00aa:
            r11 = r2
            boolean r2 = r8.zzf     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzin r2 = r8.zzb     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00d9
            r2 = 0
            r8.zzf = r2     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzin r2 = r8.zzb     // Catch:{ all -> 0x012e }
            java.lang.String r2 = r2.zzb     // Catch:{ all -> 0x012e }
            boolean r2 = com.google.android.gms.measurement.internal.zzkx.zzc((java.lang.String) r2, (java.lang.String) r11)     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzin r3 = r8.zzb     // Catch:{ all -> 0x012e }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x012e }
            boolean r3 = com.google.android.gms.measurement.internal.zzkx.zzc((java.lang.String) r3, (java.lang.String) r10)     // Catch:{ all -> 0x012e }
            if (r2 == 0) goto L_0x00d9
            if (r3 == 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzex r0 = r17.zzq()     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzj()     // Catch:{ all -> 0x012e }
            java.lang.String r2 = "Ignoring call to log screen view event with duplicate parameters."
            r0.zza(r2)     // Catch:{ all -> 0x012e }
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            return
        L_0x00d9:
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            com.google.android.gms.measurement.internal.zzex r1 = r17.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            if (r10 != 0) goto L_0x00e7
            java.lang.String r2 = "null"
            goto L_0x00e8
        L_0x00e7:
            r2 = r10
        L_0x00e8:
            if (r11 != 0) goto L_0x00ed
            java.lang.String r3 = "null"
            goto L_0x00ee
        L_0x00ed:
            r3 = r11
        L_0x00ee:
            java.lang.String r4 = "Logging screen view with name, class"
            r1.zza(r4, r2, r3)
            com.google.android.gms.measurement.internal.zzin r1 = r8.zzb
            if (r1 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzin r1 = r8.zzc
            goto L_0x00fc
        L_0x00fa:
            com.google.android.gms.measurement.internal.zzin r1 = r8.zzb
        L_0x00fc:
            r5 = r1
            com.google.android.gms.measurement.internal.zzin r4 = new com.google.android.gms.measurement.internal.zzin
            com.google.android.gms.measurement.internal.zzkx r1 = r17.zzo()
            long r12 = r1.zzf()
            r14 = 1
            r9 = r4
            r15 = r19
            r9.<init>(r10, r11, r12, r14, r15)
            r8.zzb = r4
            r8.zzc = r5
            r8.zzg = r4
            com.google.android.gms.common.util.Clock r1 = r17.zzl()
            long r6 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzfu r9 = r17.zzp()
            com.google.android.gms.measurement.internal.zzip r10 = new com.google.android.gms.measurement.internal.zzip
            r1 = r10
            r2 = r17
            r3 = r18
            r1.<init>(r2, r3, r4, r5, r6)
            r9.zza((java.lang.Runnable) r10)
            return
        L_0x012e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x012e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzim.zza(android.os.Bundle, long):void");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(Bundle bundle, @NonNull zzin zzin, zzin zzin2, long j) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zza(zzin, zzin2, j, true, zzo().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, true, true));
    }

    @MainThread
    @Deprecated
    public final void zza(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        if (!zzs().zzh().booleanValue()) {
            zzq().zzj().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (this.zzb == null) {
            zzq().zzj().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzq().zzj().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean zzc2 = zzkx.zzc(this.zzb.zzb, str2);
            boolean zzc3 = zzkx.zzc(this.zzb.zza, str);
            if (zzc2 && zzc3) {
                zzq().zzj().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzq().zzj().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzq().zzw().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzin zzin = new zzin(str, str2, zzo().zzf());
                this.zzd.put(activity, zzin);
                zza(activity, zzin, true);
            } else {
                zzq().zzj().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzin zzaa() {
        return this.zzb;
    }

    @MainThread
    private final void zza(Activity activity, zzin zzin, boolean z) {
        zzin zzin2;
        zzin zzin3 = zzin;
        zzin zzin4 = this.zzb == null ? this.zzc : this.zzb;
        if (zzin3.zzb == null) {
            zzin2 = new zzin(zzin3.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzin3.zzc, zzin3.zze, zzin3.zzf);
        } else {
            zzin2 = zzin3;
        }
        this.zzc = this.zzb;
        this.zzb = zzin2;
        zzp().zza((Runnable) new zzio(this, zzin2, zzin4, zzl().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzin zzin, zzin zzin2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        zzin zzin3;
        zzc();
        boolean z3 = false;
        if (zzs().zza(zzat.zzat)) {
            z2 = z && this.zza != null;
            if (z2) {
                zza(this.zza, true, j);
            }
        } else {
            if (z && (zzin3 = this.zza) != null) {
                zza(zzin3, true, j);
            }
            z2 = false;
        }
        if (zzin2 == null || zzin2.zzc != zzin.zzc || !zzkx.zzc(zzin2.zzb, zzin.zzb) || !zzkx.zzc(zzin2.zza, zzin.zza)) {
            z3 = true;
        }
        if (z3) {
            Bundle bundle2 = new Bundle();
            if (zzs().zza(zzat.zzbw)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            Bundle bundle3 = bundle2;
            zza(zzin, bundle3, true);
            if (zzin2 != null) {
                if (zzin2.zza != null) {
                    bundle3.putString("_pn", zzin2.zza);
                }
                if (zzin2.zzb != null) {
                    bundle3.putString("_pc", zzin2.zzb);
                }
                bundle3.putLong("_pi", zzin2.zzc);
            }
            if (zzs().zza(zzat.zzat) && z2) {
                if (!zznf.zzb() || !zzs().zza(zzat.zzav)) {
                    j2 = zzj().zzb.zzb();
                } else {
                    j2 = zzj().zza(j);
                }
                if (j2 > 0) {
                    zzo().zza(bundle3, j2);
                }
            }
            boolean zza2 = zzs().zza(zzat.zzbw);
            String str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            if (zza2) {
                if (!zzs().zzh().booleanValue()) {
                    bundle3.putLong("_mst", 1);
                }
                if (zzin.zze) {
                    str = "app";
                }
            }
            String str2 = str;
            if (zzs().zza(zzat.zzbw)) {
                long currentTimeMillis = zzl().currentTimeMillis();
                if (zzin.zze && zzin.zzf != 0) {
                    currentTimeMillis = zzin.zzf;
                }
                zze().zza(str2, "_vs", currentTimeMillis, bundle3);
            } else {
                zze().zzb(str2, "_vs", bundle3);
            }
        }
        this.zza = zzin;
        if (zzs().zza(zzat.zzbw) && zzin.zze) {
            this.zzh = zzin;
        }
        zzg().zza(zzin);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzin zzin, boolean z, long j) {
        zzd().zza(zzl().elapsedRealtime());
        if (zzj().zza(zzin != null && zzin.zzd, z, j) && zzin != null) {
            zzin.zzd = false;
        }
    }

    public static void zza(zzin zzin, Bundle bundle, boolean z) {
        if (bundle != null && zzin != null && (!bundle.containsKey("_sc") || z)) {
            if (zzin.zza != null) {
                bundle.putString("_sn", zzin.zza);
            } else {
                bundle.remove("_sn");
            }
            if (zzin.zzb != null) {
                bundle.putString("_sc", zzin.zzb);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", zzin.zzc);
        } else if (bundle != null && zzin == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @WorkerThread
    public final void zza(String str, zzin zzin) {
        zzc();
        synchronized (this) {
            if (this.zzl == null || this.zzl.equals(str) || zzin != null) {
                this.zzl = str;
                this.zzk = zzin;
            }
        }
    }

    @VisibleForTesting
    private static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    private final zzin zzd(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzin zzin = this.zzd.get(activity);
        if (zzin == null) {
            zzin zzin2 = new zzin((String) null, zza(activity.getClass().getCanonicalName()), zzo().zzf());
            this.zzd.put(activity, zzin2);
            zzin = zzin2;
        }
        return (zzs().zza(zzat.zzbw) && this.zzg != null) ? this.zzg : zzin;
    }

    @MainThread
    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (zzs().zzh().booleanValue() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzin(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void zza(Activity activity) {
        if (zzs().zza(zzat.zzbw)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (zzs().zza(zzat.zzbv) && zzs().zzh().booleanValue()) {
                        this.zzg = null;
                        zzp().zza((Runnable) new zzis(this));
                    }
                }
            }
        }
        if (!zzs().zza(zzat.zzbv) || zzs().zzh().booleanValue()) {
            zza(activity, zzd(activity), false);
            zza zzd2 = zzd();
            zzd2.zzp().zza((Runnable) new zze(zzd2, zzd2.zzl().elapsedRealtime()));
            return;
        }
        this.zzb = this.zzg;
        zzp().zza((Runnable) new zzir(this));
    }

    @MainThread
    public final void zzb(Activity activity) {
        if (zzs().zza(zzat.zzbw)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long elapsedRealtime = zzl().elapsedRealtime();
        if (!zzs().zza(zzat.zzbv) || zzs().zzh().booleanValue()) {
            zzin zzd2 = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzp().zza((Runnable) new zzit(this, zzd2, elapsedRealtime));
            return;
        }
        this.zzb = null;
        zzp().zza((Runnable) new zziq(this, elapsedRealtime));
    }

    @MainThread
    public final void zzb(Activity activity, Bundle bundle) {
        zzin zzin;
        if (zzs().zzh().booleanValue() && bundle != null && (zzin = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzin.zzc);
            bundle2.putString("name", zzin.zza);
            bundle2.putString("referrer_name", zzin.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    @MainThread
    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zzs().zzh().booleanValue()) {
            this.zzd.remove(activity);
        }
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

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzhe zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzeq zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zziv zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzim zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzet zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzkb zzj() {
        return super.zzj();
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

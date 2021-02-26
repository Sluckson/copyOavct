package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzlj;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzmt;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzhe extends zzg {
    @VisibleForTesting
    protected zzic zza;
    final zzp zzb;
    private zzhd zzc;
    private final Set<zzhc> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();
    private final Object zzg = new Object();
    @GuardedBy("consentLock")
    private zzad zzh = new zzad((Boolean) null, (Boolean) null);
    @GuardedBy("consentLock")
    private int zzi = 100;
    private final AtomicLong zzj = new AtomicLong(0);
    private long zzk = -1;
    private int zzl = 100;
    @VisibleForTesting
    private boolean zzm = true;

    protected zzhe(zzgb zzgb) {
        super(zzgb);
        this.zzb = new zzp(zzgb);
    }

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return false;
    }

    public final void zzaa() {
        if (zzm().getApplicationContext() instanceof Application) {
            ((Application) zzm().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzp().zza(atomicReference, 15000, "boolean test flag value", new zzhj(this, atomicReference));
    }

    public final String zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzp().zza(atomicReference, 15000, "String test flag value", new zzht(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzp().zza(atomicReference, 15000, "long test flag value", new zzhx(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzp().zza(atomicReference, 15000, "int test flag value", new zzhw(this, atomicReference));
    }

    public final Double zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzp().zza(atomicReference, 15000, "double test flag value", new zzhz(this, atomicReference));
    }

    public final void zza(@Nullable Boolean bool) {
        zzv();
        zzp().zza((Runnable) new zzhy(this, bool));
    }

    public final void zza(zzad zzad, int i, long j) {
        boolean z;
        zzad zzad2;
        boolean z2;
        boolean z3;
        zzad zzad3 = zzad;
        if (zzmb.zzb() && zzs().zza(zzat.zzco)) {
            zzv();
            if (zzad.zzb() == null && zzad.zzd() == null) {
                zzq().zzj().zza("Discarding empty consent settings");
                return;
            }
            synchronized (this.zzg) {
                z = true;
                boolean z4 = false;
                if (zzad.zza(i, this.zzi)) {
                    z2 = zzad.zza(this.zzh);
                    if (zzad.zze() && !this.zzh.zze()) {
                        z4 = true;
                    }
                    zzad zzc2 = zzad.zzc(this.zzh);
                    this.zzh = zzc2;
                    boolean z5 = z4;
                    zzad2 = zzc2;
                    z3 = z5;
                } else {
                    zzad2 = zzad3;
                    z3 = false;
                    z2 = false;
                    z = false;
                }
            }
            if (!z) {
                zzq().zzu().zza("Ignoring lower-priority consent settings, proposed settings", zzad2);
                return;
            }
            long andIncrement = this.zzj.getAndIncrement();
            if (z2) {
                zza((String) null);
                zzp().zzb((Runnable) new zzib(this, zzad2, j, i, andIncrement, z3));
                return;
            }
            zzp().zza((Runnable) new zzia(this, zzad2, i, andIncrement, z3));
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzad zzad) {
        zzc();
        boolean z = (zzad.zze() && zzad.zzc()) || zzg().zzai();
        if (z != this.zzy.zzac()) {
            this.zzy.zzb(z);
            Boolean zzv = zzr().zzv();
            if (!z || zzv == null || zzv.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(@Nullable Boolean bool, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Setting app measurement enabled (FE)", bool);
        zzr().zza(bool);
        if (zzmb.zzb() && zzs().zza(zzat.zzco) && z) {
            zzr().zzb(bool);
        }
        if (!zzmb.zzb() || !zzs().zza(zzat.zzco) || this.zzy.zzac() || !bool.booleanValue()) {
            zzal();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzad zzad, int i, long j, boolean z, boolean z2) {
        zzc();
        zzv();
        if (j <= this.zzk && zzad.zza(this.zzl, i)) {
            zzq().zzu().zza("Dropped out-of-date consent setting, proposed settings", zzad);
        } else if (zzr().zza(zzad, i)) {
            this.zzk = j;
            this.zzl = i;
            zzg().zza(z);
            if (z2) {
                zzg().zza((AtomicReference<String>) new AtomicReference());
            }
        } else {
            zzq().zzu().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzal() {
        zzc();
        String zza2 = zzr().zzn.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zza("app", "_npa", (Object) null, zzl().currentTimeMillis());
            } else {
                zza("app", "_npa", (Object) Long.valueOf("true".equals(zza2) ? 1 : 0), zzl().currentTimeMillis());
            }
        }
        if (!this.zzy.zzaa() || !this.zzm) {
            zzq().zzv().zza("Updating Scion state (FE)");
            zzg().zzab();
            return;
        }
        zzq().zzv().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzah();
        if (zzne.zzb() && zzs().zza(zzat.zzbr)) {
            zzj().zza.zza();
        }
        if (zzmt.zzb() && zzs().zza(zzat.zzbu)) {
            if (!(this.zzy.zze().zza.zzb().zzi.zza() > 0)) {
                zzfo zze2 = this.zzy.zze();
                zze2.zza(zze2.zza.zzm().getPackageName());
            }
        }
        if (zzs().zza(zzat.zzck)) {
            zzp().zza((Runnable) new zzhi(this));
        }
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzl().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(String str, String str2, Bundle bundle) {
        zzc();
        zza(str, str2, zzl().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzc();
        zza(str, str2, j, bundle, true, this.zzc == null || zzkx.zzd(str2), false, (String) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x05a4  */
    /* JADX WARNING: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r27, java.lang.String r28, long r29, android.os.Bundle r31, boolean r32, boolean r33, boolean r34, java.lang.String r35) {
        /*
            r26 = this;
            r7 = r26
            r8 = r27
            r15 = r28
            r13 = r29
            r12 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r31)
            r26.zzc()
            r26.zzv()
            com.google.android.gms.measurement.internal.zzgb r0 = r7.zzy
            boolean r0 = r0.zzaa()
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.measurement.internal.zzex r0 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        L_0x002c:
            com.google.android.gms.measurement.internal.zzeq r0 = r26.zzf()
            java.util.List r0 = r0.zzag()
            if (r0 == 0) goto L_0x004a
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzex r0 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r1, r15, r8)
            return
        L_0x004a:
            boolean r0 = r7.zze
            r11 = 0
            r10 = 0
            r9 = 1
            if (r0 != 0) goto L_0x00a2
            r7.zze = r9
            com.google.android.gms.measurement.internal.zzgb r0 = r7.zzy     // Catch:{ ClassNotFoundException -> 0x0095 }
            boolean r0 = r0.zzs()     // Catch:{ ClassNotFoundException -> 0x0095 }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x006a
            android.content.Context r0 = r26.zzm()     // Catch:{ ClassNotFoundException -> 0x0095 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0095 }
            java.lang.Class r0 = java.lang.Class.forName(r1, r9, r0)     // Catch:{ ClassNotFoundException -> 0x0095 }
            goto L_0x006e
        L_0x006a:
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0095 }
        L_0x006e:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x0086 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r10] = r3     // Catch:{ Exception -> 0x0086 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0086 }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0086 }
            android.content.Context r2 = r26.zzm()     // Catch:{ Exception -> 0x0086 }
            r1[r10] = r2     // Catch:{ Exception -> 0x0086 }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x0086 }
            goto L_0x00a2
        L_0x0086:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()     // Catch:{ ClassNotFoundException -> 0x0095 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzh()     // Catch:{ ClassNotFoundException -> 0x0095 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zza(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0095 }
            goto L_0x00a2
        L_0x0095:
            com.google.android.gms.measurement.internal.zzex r0 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzu()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00a2:
            com.google.android.gms.measurement.internal.zzy r0 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzbe
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x00d3
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00d3
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00d3
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r26.zzl()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r26
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
        L_0x00d3:
            boolean r0 = com.google.android.gms.internal.measurement.zznr.zzb()
            if (r0 == 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzy r0 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzcg
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x00fe
            if (r32 == 0) goto L_0x00fe
            boolean r0 = com.google.android.gms.measurement.internal.zzkx.zzf(r28)
            if (r0 == 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzkx r0 = r26.zzo()
            com.google.android.gms.measurement.internal.zzfj r1 = r26.zzr()
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzx
            android.os.Bundle r1 = r1.zza()
            r0.zza((android.os.Bundle) r12, (android.os.Bundle) r1)
        L_0x00fe:
            r0 = 40
            if (r34 == 0) goto L_0x0183
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0183
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkx r1 = r1.zzh()
            boolean r2 = com.google.android.gms.internal.measurement.zzlj.zzb()
            if (r2 == 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzy r2 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcr
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0124
            r2 = 1
            goto L_0x0125
        L_0x0124:
            r2 = 0
        L_0x0125:
            java.lang.String r3 = "event"
            boolean r4 = r1.zza((java.lang.String) r3, (java.lang.String) r15)
            r5 = 13
            r6 = 2
            if (r4 != 0) goto L_0x0131
            goto L_0x0151
        L_0x0131:
            if (r2 == 0) goto L_0x013e
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzgy.zza
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzgy.zzb
            boolean r2 = r1.zza((java.lang.String) r3, (java.lang.String[]) r2, (java.lang.String[]) r4, (java.lang.String) r15)
            if (r2 != 0) goto L_0x0149
            goto L_0x0146
        L_0x013e:
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzgy.zza
            boolean r2 = r1.zza((java.lang.String) r3, (java.lang.String[]) r2, (java.lang.String) r15)
            if (r2 != 0) goto L_0x0149
        L_0x0146:
            r6 = 13
            goto L_0x0151
        L_0x0149:
            boolean r1 = r1.zza((java.lang.String) r3, (int) r0, (java.lang.String) r15)
            if (r1 != 0) goto L_0x0150
            goto L_0x0151
        L_0x0150:
            r6 = 0
        L_0x0151:
            if (r6 == 0) goto L_0x0183
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzg()
            com.google.android.gms.measurement.internal.zzev r2 = r26.zzn()
            java.lang.String r2 = r2.zza((java.lang.String) r15)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            r1.zzh()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkx.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x0177
            int r10 = r28.length()
        L_0x0177:
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkx r1 = r1.zzh()
            java.lang.String r2 = "_ev"
            r1.zza((int) r6, (java.lang.String) r2, (java.lang.String) r0, (int) r10)
            return
        L_0x0183:
            com.google.android.gms.measurement.internal.zzim r1 = r26.zzh()
            com.google.android.gms.measurement.internal.zzin r1 = r1.zza((boolean) r10)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x0197
            boolean r3 = r12.containsKey(r2)
            if (r3 != 0) goto L_0x0197
            r1.zzd = r9
        L_0x0197:
            if (r32 == 0) goto L_0x019d
            if (r34 == 0) goto L_0x019d
            r3 = 1
            goto L_0x019e
        L_0x019d:
            r3 = 0
        L_0x019e:
            com.google.android.gms.measurement.internal.zzim.zza((com.google.android.gms.measurement.internal.zzin) r1, (android.os.Bundle) r12, (boolean) r3)
            java.lang.String r3 = "am"
            boolean r16 = r3.equals(r8)
            boolean r3 = com.google.android.gms.measurement.internal.zzkx.zzd(r28)
            if (r32 == 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzhd r4 = r7.zzc
            if (r4 == 0) goto L_0x01e0
            if (r3 != 0) goto L_0x01e0
            if (r16 != 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzex r0 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()
            com.google.android.gms.measurement.internal.zzev r1 = r26.zzn()
            java.lang.String r1 = r1.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzev r2 = r26.zzn()
            java.lang.String r2 = r2.zza((android.os.Bundle) r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzhd r1 = r7.zzc
            r2 = r27
            r3 = r28
            r4 = r31
            r5 = r29
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01e0:
            com.google.android.gms.measurement.internal.zzgb r3 = r7.zzy
            boolean r3 = r3.zzaf()
            if (r3 != 0) goto L_0x01e9
            return
        L_0x01e9:
            com.google.android.gms.measurement.internal.zzkx r3 = r26.zzo()
            boolean r4 = com.google.android.gms.internal.measurement.zzlj.zzb()
            if (r4 == 0) goto L_0x0201
            com.google.android.gms.measurement.internal.zzy r4 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzat.zzcr
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r5)
            if (r4 == 0) goto L_0x0201
            r4 = 1
            goto L_0x0202
        L_0x0201:
            r4 = 0
        L_0x0202:
            int r3 = r3.zza((java.lang.String) r15, (boolean) r4)
            if (r3 == 0) goto L_0x0242
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzg()
            com.google.android.gms.measurement.internal.zzev r2 = r26.zzn()
            java.lang.String r2 = r2.zza((java.lang.String) r15)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r1.zza(r4, r2)
            r26.zzo()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkx.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x022a
            int r10 = r28.length()
        L_0x022a:
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkx r1 = r1.zzh()
            java.lang.String r2 = "_ev"
            r27 = r1
            r28 = r35
            r29 = r3
            r30 = r2
            r31 = r0
            r32 = r10
            r27.zza((java.lang.String) r28, (int) r29, (java.lang.String) r30, (java.lang.String) r31, (int) r32)
            return
        L_0x0242:
            java.lang.String r0 = "_sn"
            java.lang.String r5 = "_o"
            java.lang.String r3 = "_si"
            java.lang.String[] r4 = new java.lang.String[]{r5, r0, r2, r3}
            java.util.List r17 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r4)
            com.google.android.gms.measurement.internal.zzkx r4 = r26.zzo()
            r6 = 1
            r9 = r4
            r4 = 0
            r10 = r35
            r19 = r11
            r11 = r28
            r12 = r31
            r13 = r17
            r14 = r34
            r15 = r6
            android.os.Bundle r15 = r9.zza((java.lang.String) r10, (java.lang.String) r11, (android.os.Bundle) r12, (java.util.List<java.lang.String>) r13, (boolean) r14, (boolean) r15)
            if (r15 == 0) goto L_0x0291
            boolean r6 = r15.containsKey(r2)
            if (r6 == 0) goto L_0x0291
            boolean r6 = r15.containsKey(r3)
            if (r6 != 0) goto L_0x0277
            goto L_0x0291
        L_0x0277:
            java.lang.String r0 = r15.getString(r0)
            java.lang.String r2 = r15.getString(r2)
            long r9 = r15.getLong(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r9)
            com.google.android.gms.measurement.internal.zzin r11 = new com.google.android.gms.measurement.internal.zzin
            long r9 = r3.longValue()
            r11.<init>(r0, r2, r9)
            goto L_0x0293
        L_0x0291:
            r11 = r19
        L_0x0293:
            if (r11 != 0) goto L_0x0297
            r0 = r1
            goto L_0x0298
        L_0x0297:
            r0 = r11
        L_0x0298:
            com.google.android.gms.measurement.internal.zzy r1 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzat
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            java.lang.String r14 = "_ae"
            r9 = 0
            if (r1 == 0) goto L_0x02d0
            com.google.android.gms.measurement.internal.zzim r1 = r26.zzh()
            com.google.android.gms.measurement.internal.zzin r1 = r1.zza((boolean) r4)
            if (r1 == 0) goto L_0x02d0
            r13 = r28
            boolean r1 = r14.equals(r13)
            if (r1 == 0) goto L_0x02d2
            com.google.android.gms.measurement.internal.zzkb r1 = r26.zzj()
            com.google.android.gms.measurement.internal.zzkh r1 = r1.zzb
            long r1 = r1.zzb()
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x02d2
            com.google.android.gms.measurement.internal.zzkx r3 = r26.zzo()
            r3.zza((android.os.Bundle) r15, (long) r1)
            goto L_0x02d2
        L_0x02d0:
            r13 = r28
        L_0x02d2:
            boolean r1 = com.google.android.gms.internal.measurement.zzmn.zzb()
            if (r1 == 0) goto L_0x0356
            com.google.android.gms.measurement.internal.zzy r1 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzbq
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r1 == 0) goto L_0x0356
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x0337
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x0337
            com.google.android.gms.measurement.internal.zzkx r1 = r26.zzo()
            java.lang.String r2 = "_ffr"
            java.lang.String r2 = r15.getString(r2)
            boolean r3 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r2)
            if (r3 == 0) goto L_0x0307
            r11 = r19
            goto L_0x030b
        L_0x0307:
            java.lang.String r11 = r2.trim()
        L_0x030b:
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzu
            java.lang.String r2 = r2.zza()
            boolean r2 = com.google.android.gms.measurement.internal.zzkx.zzc((java.lang.String) r11, (java.lang.String) r2)
            if (r2 == 0) goto L_0x032a
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzv()
            java.lang.String r2 = "Not logging duplicate session_start_with_rollout event"
            r1.zza(r2)
            r1 = 0
            goto L_0x0334
        L_0x032a:
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zzu
            r1.zza(r11)
            r1 = 1
        L_0x0334:
            if (r1 != 0) goto L_0x0356
            return
        L_0x0337:
            boolean r1 = r14.equals(r13)
            if (r1 == 0) goto L_0x0356
            com.google.android.gms.measurement.internal.zzkx r1 = r26.zzo()
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zzu
            java.lang.String r1 = r1.zza()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0356
            java.lang.String r2 = "_ffr"
            r15.putString(r2, r1)
        L_0x0356:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r12.add(r15)
            com.google.android.gms.measurement.internal.zzkx r1 = r26.zzo()
            java.security.SecureRandom r1 = r1.zzg()
            long r2 = r1.nextLong()
            com.google.android.gms.measurement.internal.zzfj r1 = r26.zzr()
            com.google.android.gms.measurement.internal.zzfn r1 = r1.zzp
            long r19 = r1.zza()
            int r1 = (r19 > r9 ? 1 : (r19 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x03dd
            com.google.android.gms.measurement.internal.zzfj r1 = r26.zzr()
            r9 = r29
            boolean r1 = r1.zza((long) r9)
            if (r1 == 0) goto L_0x03df
            com.google.android.gms.measurement.internal.zzfj r1 = r26.zzr()
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzr
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x03df
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r6 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r6)
            r6 = 0
            com.google.android.gms.common.util.Clock r1 = r26.zzl()
            long r19 = r1.currentTimeMillis()
            java.lang.String r11 = "auto"
            java.lang.String r21 = "_sid"
            r1 = r26
            r22 = r2
            r2 = r11
            r3 = r21
            r11 = 0
            r4 = r6
            r8 = r5
            r5 = r19
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            r4 = 0
            com.google.android.gms.common.util.Clock r1 = r26.zzl()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r26
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            com.google.android.gms.common.util.Clock r1 = r26.zzl()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r26
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            goto L_0x03e3
        L_0x03dd:
            r9 = r29
        L_0x03df:
            r22 = r2
            r8 = r5
            r11 = 0
        L_0x03e3:
            java.lang.String r1 = "extend_session"
            r2 = 0
            long r1 = r15.getLong(r1, r2)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x040b
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkb r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzkj r1 = r1.zza
            r5 = 1
            r1.zza(r9, r5)
            goto L_0x040c
        L_0x040b:
            r5 = 1
        L_0x040c:
            java.util.Set r1 = r15.keySet()
            int r2 = r15.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            boolean r2 = com.google.android.gms.internal.measurement.zzmh.zzb()
            if (r2 == 0) goto L_0x045d
            com.google.android.gms.measurement.internal.zzy r2 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzca
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x045d
            com.google.android.gms.measurement.internal.zzy r2 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbz
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x045d
            int r0 = r1.length
            r2 = 0
        L_0x043f:
            if (r2 >= r0) goto L_0x0456
            r3 = r1[r2]
            r26.zzo()
            java.lang.Object r4 = r15.get(r3)
            android.os.Bundle[] r4 = com.google.android.gms.measurement.internal.zzkx.zzb((java.lang.Object) r4)
            if (r4 == 0) goto L_0x0453
            r15.putParcelableArray(r3, r4)
        L_0x0453:
            int r2 = r2 + 1
            goto L_0x043f
        L_0x0456:
            r10 = r12
            r1 = r13
            r0 = r14
            r18 = 1
            goto L_0x0520
        L_0x045d:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0460:
            if (r3 >= r2) goto L_0x050c
            r6 = r1[r3]
            java.lang.Object r18 = r15.get(r6)
            r26.zzo()
            android.os.Bundle[] r5 = com.google.android.gms.measurement.internal.zzkx.zzb((java.lang.Object) r18)
            if (r5 == 0) goto L_0x04ea
            int r11 = r5.length
            r15.putInt(r6, r11)
            r32 = r1
            r11 = 0
        L_0x0478:
            int r1 = r5.length
            if (r11 >= r1) goto L_0x04db
            r1 = r5[r11]
            r18 = r15
            r15 = 1
            com.google.android.gms.measurement.internal.zzim.zza((com.google.android.gms.measurement.internal.zzin) r0, (android.os.Bundle) r1, (boolean) r15)
            com.google.android.gms.measurement.internal.zzkx r19 = r26.zzo()
            r20 = 0
            java.lang.String r21 = "_ep"
            r9 = r19
            r10 = r35
            r24 = r11
            r11 = r21
            r25 = r12
            r12 = r1
            r1 = r13
            r13 = r17
            r19 = r0
            r0 = r14
            r14 = r34
            r21 = r2
            r2 = r18
            r18 = 1
            r15 = r20
            android.os.Bundle r9 = r9.zza((java.lang.String) r10, (java.lang.String) r11, (android.os.Bundle) r12, (java.util.List<java.lang.String>) r13, (boolean) r14, (boolean) r15)
            java.lang.String r10 = "_en"
            r9.putString(r10, r1)
            java.lang.String r10 = "_eid"
            r11 = r22
            r9.putLong(r10, r11)
            java.lang.String r10 = "_gn"
            r9.putString(r10, r6)
            int r10 = r5.length
            java.lang.String r13 = "_ll"
            r9.putInt(r13, r10)
            java.lang.String r10 = "_i"
            r13 = r24
            r9.putInt(r10, r13)
            r10 = r25
            r10.add(r9)
            int r9 = r13 + 1
            r14 = r0
            r13 = r1
            r15 = r2
            r0 = r19
            r2 = r21
            r11 = r9
            r12 = r10
            r9 = r29
            goto L_0x0478
        L_0x04db:
            r19 = r0
            r21 = r2
            r10 = r12
            r1 = r13
            r0 = r14
            r2 = r15
            r11 = r22
            r18 = 1
            int r5 = r5.length
            int r4 = r4 + r5
            goto L_0x04f8
        L_0x04ea:
            r19 = r0
            r32 = r1
            r21 = r2
            r10 = r12
            r1 = r13
            r0 = r14
            r2 = r15
            r11 = r22
            r18 = 1
        L_0x04f8:
            int r3 = r3 + 1
            r14 = r0
            r13 = r1
            r15 = r2
            r22 = r11
            r0 = r19
            r2 = r21
            r5 = 1
            r11 = 0
            r1 = r32
            r12 = r10
            r9 = r29
            goto L_0x0460
        L_0x050c:
            r10 = r12
            r1 = r13
            r0 = r14
            r2 = r15
            r11 = r22
            r18 = 1
            if (r4 == 0) goto L_0x0520
            java.lang.String r3 = "_eid"
            r2.putLong(r3, r11)
            java.lang.String r3 = "_epc"
            r2.putInt(r3, r4)
        L_0x0520:
            r9 = 0
        L_0x0521:
            int r2 = r10.size()
            if (r9 >= r2) goto L_0x0591
            java.lang.Object r2 = r10.get(r9)
            android.os.Bundle r2 = (android.os.Bundle) r2
            if (r9 == 0) goto L_0x0531
            r3 = 1
            goto L_0x0532
        L_0x0531:
            r3 = 0
        L_0x0532:
            if (r3 == 0) goto L_0x0537
            java.lang.String r3 = "_ep"
            goto L_0x0538
        L_0x0537:
            r3 = r1
        L_0x0538:
            r11 = r8
            r8 = r27
            r2.putString(r11, r8)
            if (r33 == 0) goto L_0x0548
            com.google.android.gms.measurement.internal.zzkx r4 = r26.zzo()
            android.os.Bundle r2 = r4.zza((android.os.Bundle) r2)
        L_0x0548:
            r12 = r2
            com.google.android.gms.measurement.internal.zzar r13 = new com.google.android.gms.measurement.internal.zzar
            com.google.android.gms.measurement.internal.zzam r4 = new com.google.android.gms.measurement.internal.zzam
            r4.<init>(r12)
            r14 = r1
            r1 = r13
            r2 = r3
            r3 = r4
            r4 = r27
            r15 = 1
            r5 = r29
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zziv r1 = r26.zzg()
            r5 = r35
            r1.zza((com.google.android.gms.measurement.internal.zzar) r13, (java.lang.String) r5)
            if (r16 != 0) goto L_0x058a
            java.util.Set<com.google.android.gms.measurement.internal.zzhc> r1 = r7.zzd
            java.util.Iterator r13 = r1.iterator()
        L_0x056d:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x058a
            java.lang.Object r1 = r13.next()
            com.google.android.gms.measurement.internal.zzhc r1 = (com.google.android.gms.measurement.internal.zzhc) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r12)
            r2 = r27
            r3 = r28
            r5 = r29
            r1.onEvent(r2, r3, r4, r5)
            r5 = r35
            goto L_0x056d
        L_0x058a:
            int r9 = r9 + 1
            r8 = r11
            r1 = r14
            r18 = 1
            goto L_0x0521
        L_0x0591:
            r14 = r1
            r15 = 1
            com.google.android.gms.measurement.internal.zzim r1 = r26.zzh()
            r2 = 0
            com.google.android.gms.measurement.internal.zzin r1 = r1.zza((boolean) r2)
            if (r1 == 0) goto L_0x05b3
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x05b3
            com.google.android.gms.measurement.internal.zzkb r0 = r26.zzj()
            com.google.android.gms.common.util.Clock r1 = r26.zzl()
            long r1 = r1.elapsedRealtime()
            r0.zza(r15, r15, r1)
        L_0x05b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhe.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        boolean z3;
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (!zzs().zza(zzat.zzbw)) {
            String str4 = str2;
        } else if (zzkx.zzc(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzh().zza(bundle2, j);
            return;
        }
        long j2 = j;
        if (z2) {
            if (this.zzc != null && !zzkx.zzd(str2)) {
                z3 = false;
                zzp().zza((Runnable) new zzhn(this, str3, str2, j, zzkx.zzb(bundle2), z2, z3, !z, (String) null));
            }
        }
        z3 = true;
        zzp().zza((Runnable) new zzhn(this, str3, str2, j, zzkx.zzb(bundle2), z2, z3, !z, (String) null));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, true, zzl().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzo().zzb(str2);
        } else {
            zzkx zzo = zzo();
            if (zzo.zza("user property", str2)) {
                if (!zzo.zza("user property", zzha.zza, str2)) {
                    i = 15;
                } else if (zzo.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzo();
            String zza2 = zzkx.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzy.zzh().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzo().zzb(str2, obj);
            if (zzb2 != 0) {
                zzo();
                String zza3 = zzkx.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzy.zzh().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzo().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzp().zza((Runnable) new zzhm(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzc()
            r8.zzv()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0063
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0053
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0035
            r4 = r2
            goto L_0x0037
        L_0x0035:
            r4 = 0
        L_0x0037:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzfj r0 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfp r0 = r0.zzn
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004e
            java.lang.String r11 = "true"
        L_0x004e:
            r0.zza(r11)
            r6 = r10
            goto L_0x0061
        L_0x0053:
            if (r11 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzfj r10 = r8.zzr()
            com.google.android.gms.measurement.internal.zzfp r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x0061:
            r3 = r1
            goto L_0x0065
        L_0x0063:
            r3 = r10
            r6 = r11
        L_0x0065:
            com.google.android.gms.measurement.internal.zzgb r10 = r8.zzy
            boolean r10 = r10.zzaa()
            if (r10 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzex r9 = r8.zzq()
            com.google.android.gms.measurement.internal.zzez r9 = r9.zzw()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007b:
            com.google.android.gms.measurement.internal.zzgb r10 = r8.zzy
            boolean r10 = r10.zzaf()
            if (r10 != 0) goto L_0x0084
            return
        L_0x0084:
            com.google.android.gms.measurement.internal.zzkw r10 = new com.google.android.gms.measurement.internal.zzkw
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zziv r9 = r8.zzg()
            r9.zza((com.google.android.gms.measurement.internal.zzkw) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhe.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzkw> zza(boolean z) {
        zzv();
        zzq().zzw().zza("Getting user properties (FE)");
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzx.zza()) {
            zzq().zze().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, "get user properties", new zzhp(this, atomicReference, z));
            List<zzkw> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzq().zze().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    @Nullable
    public final String zzag() {
        return this.zzf.get();
    }

    /* access modifiers changed from: package-private */
    public final void zza(@Nullable String str) {
        this.zzf.set(str);
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Resetting analytics data (FE)");
        zzkb zzj2 = zzj();
        zzj2.zzc();
        zzj2.zzb.zza();
        boolean zzaa = this.zzy.zzaa();
        zzfj zzr = zzr();
        zzr.zzh.zza(j);
        if (!TextUtils.isEmpty(zzr.zzr().zzu.zza())) {
            zzr.zzu.zza((String) null);
        }
        if (zzne.zzb() && zzr.zzs().zza(zzat.zzbr)) {
            zzr.zzp.zza(0);
        }
        if (!zzr.zzs().zzf()) {
            zzr.zzb(!zzaa);
        }
        zzr.zzv.zza((String) null);
        zzr.zzw.zza(0);
        zzr.zzx.zza((Bundle) null);
        if (z) {
            zzg().zzac();
        }
        if (zzne.zzb() && zzs().zza(zzat.zzbr)) {
            zzj().zza.zza();
        }
        this.zzm = !zzaa;
    }

    @WorkerThread
    public final void zzah() {
        zzc();
        zzv();
        if (this.zzy.zzaf()) {
            if (zzs().zza(zzat.zzbd)) {
                Boolean zzf2 = zzs().zzf("google_analytics_deferred_deep_link_enabled");
                if (zzf2 != null && zzf2.booleanValue()) {
                    zzq().zzv().zza("Deferred Deep Link feature enabled.");
                    zzp().zza((Runnable) new zzhg(this));
                }
            }
            zzg().zzad();
            this.zzm = false;
            String zzx = zzr().zzx();
            if (!TextUtils.isEmpty(zzx)) {
                zzk().zzaa();
                if (!zzx.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzx);
                    zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    public final void zza(zzhd zzhd) {
        zzhd zzhd2;
        zzc();
        zzv();
        if (!(zzhd == null || zzhd == (zzhd2 = this.zzc))) {
            Preconditions.checkState(zzhd2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzhd;
    }

    public final void zza(zzhc zzhc) {
        zzv();
        Preconditions.checkNotNull(zzhc);
        if (!this.zzd.add(zzhc)) {
            zzq().zzh().zza("OnEventListener already registered");
        }
    }

    public final void zzb(zzhc zzhc) {
        zzv();
        Preconditions.checkNotNull(zzhc);
        if (!this.zzd.remove(zzhc)) {
            zzq().zzh().zza("OnEventListener had not been registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzl().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzq().zzh().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzl().currentTimeMillis());
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgz.zza(bundle, "app_id", String.class, null);
        zzgz.zza(bundle, "origin", String.class, null);
        zzgz.zza(bundle, "name", String.class, null);
        zzgz.zza(bundle, "value", Object.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (zzo().zzb(string) != 0) {
            zzq().zze().zza("Invalid conditional user property name", zzn().zzc(string));
        } else if (zzo().zzb(string, obj) != 0) {
            zzq().zze().zza("Invalid conditional user property value", zzn().zzc(string), obj);
        } else {
            Object zzc2 = zzo().zzc(string, obj);
            if (zzc2 == null) {
                zzq().zze().zza("Unable to normalize conditional user property value", zzn().zzc(string), obj);
                return;
            }
            zzgz.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzq().zze().zza("Invalid conditional user property time to live", zzn().zzc(string), Long.valueOf(j3));
                } else {
                    zzp().zza((Runnable) new zzhq(this, bundle));
                }
            } else {
                zzq().zze().zza("Invalid conditional user property timeout", zzn().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb((String) null, str, str2, bundle);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzl().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzp().zza((Runnable) new zzhs(this, bundle2));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        try {
            zzg().zza(new zzw(bundle2.getString("app_id"), bundle2.getString("origin"), new zzkw(bundle2.getString("name"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin")), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlj.zzb() && zzs().zza(zzat.zzcr)), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlj.zzb() && zzs().zza(zzat.zzcr)), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlj.zzb() && zzs().zza(zzat.zzcr))));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkw zzkw = new zzkw(bundle2.getString("name"), 0, (Object) null, (String) null);
        try {
            zzg().zza(new zzw(bundle2.getString("app_id"), bundle2.getString("origin"), zzkw, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean("active"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzar) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzar) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false, zzlj.zzb() && zzs().zza(zzat.zzcr))));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    @VisibleForTesting
    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzx.zza()) {
            zzq().zze().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, "get conditional user properties", new zzhv(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzkx.zzb((List<zzw>) list);
            }
            zzq().zze().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzx.zza()) {
            zzq().zze().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS, "get user properties", new zzhu(this, atomicReference, str, str2, str3, z));
            List<zzkw> list = (List) atomicReference.get();
            if (list == null) {
                zzq().zze().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkw zzkw : list) {
                arrayMap.put(zzkw.zza, zzkw.zza());
            }
            return arrayMap;
        }
    }

    @Nullable
    public final String zzai() {
        zzin zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    @Nullable
    public final String zzaj() {
        zzin zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    @Nullable
    public final String zzak() {
        if (this.zzy.zzn() != null) {
            return this.zzy.zzn();
        }
        try {
            return zzik.zza(zzm(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzy.zzq().zze().zza("getGoogleAppId failed with exception", e);
            return null;
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

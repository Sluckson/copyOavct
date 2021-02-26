package com.google.firebase.perf.internal;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p010firebaseperf.zzbi;
import com.google.android.gms.internal.p010firebaseperf.zzbn;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class RemoteConfigManager {
    private static final RemoteConfigManager zzer = new RemoteConfigManager();
    private static final long zzes = TimeUnit.HOURS.toMillis(12);
    private final Executor executor;
    private zzbi zzaj;
    private long zzet;
    @Nullable
    private FirebaseRemoteConfig zzeu;

    private RemoteConfigManager() {
        this(new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue()), (FirebaseRemoteConfig) null);
    }

    @VisibleForTesting
    private RemoteConfigManager(Executor executor2, FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zzet = 0;
        this.executor = executor2;
        this.zzeu = null;
        this.zzaj = zzbi.zzcl();
    }

    public static RemoteConfigManager zzci() {
        return zzer;
    }

    public final void zza(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.zzeu = firebaseRemoteConfig;
    }

    public final zzbn<Float> zzd(String str) {
        if (str == null) {
            this.zzaj.zzm("The key to get Remote Config float value is null.");
            return zzbn.zzda();
        }
        FirebaseRemoteConfigValue zzl = zzl(str);
        if (zzl != null) {
            try {
                return zzbn.zzb(Float.valueOf(Double.valueOf(zzl.asDouble()).floatValue()));
            } catch (IllegalArgumentException unused) {
                if (!zzl.asString().isEmpty()) {
                    this.zzaj.zzm(String.format("Could not parse value: '%s' for key: '%s'.", new Object[]{zzl.asString(), str}));
                }
            }
        }
        return zzbn.zzda();
    }

    public final zzbn<Long> zze(String str) {
        if (str == null) {
            this.zzaj.zzm("The key to get Remote Config long value is null.");
            return zzbn.zzda();
        }
        FirebaseRemoteConfigValue zzl = zzl(str);
        if (zzl != null) {
            try {
                return zzbn.zzb(Long.valueOf(zzl.asLong()));
            } catch (IllegalArgumentException unused) {
                if (!zzl.asString().isEmpty()) {
                    this.zzaj.zzm(String.format("Could not parse value: '%s' for key: '%s'.", new Object[]{zzl.asString(), str}));
                }
            }
        }
        return zzbn.zzda();
    }

    public final zzbn<Boolean> zzb(String str) {
        if (str == null) {
            this.zzaj.zzm("The key to get Remote Config boolean value is null.");
            return zzbn.zzda();
        }
        FirebaseRemoteConfigValue zzl = zzl(str);
        if (zzl != null) {
            try {
                return zzbn.zzb(Boolean.valueOf(zzl.asBoolean()));
            } catch (IllegalArgumentException unused) {
                if (!zzl.asString().isEmpty()) {
                    this.zzaj.zzm(String.format("Could not parse value: '%s' for key: '%s'.", new Object[]{zzl.asString(), str}));
                }
            }
        }
        return zzbn.zzda();
    }

    public final zzbn<String> zzc(String str) {
        if (str == null) {
            this.zzaj.zzm("The key to get Remote Config String value is null.");
            return zzbn.zzda();
        }
        FirebaseRemoteConfigValue zzl = zzl(str);
        if (zzl != null) {
            return zzbn.zzb(zzl.asString());
        }
        return zzbn.zzda();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T zza(java.lang.String r8, T r9) {
        /*
            r7 = this;
            com.google.firebase.remoteconfig.FirebaseRemoteConfigValue r0 = r7.zzl(r8)
            if (r0 == 0) goto L_0x007c
            r1 = 1
            r2 = 0
            boolean r3 = r9 instanceof java.lang.Boolean     // Catch:{ IllegalArgumentException -> 0x005c }
            if (r3 == 0) goto L_0x0015
            boolean r3 = r0.asBoolean()     // Catch:{ IllegalArgumentException -> 0x005c }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x005c }
            goto L_0x007c
        L_0x0015:
            boolean r3 = r9 instanceof java.lang.Float     // Catch:{ IllegalArgumentException -> 0x005c }
            if (r3 == 0) goto L_0x002a
            double r3 = r0.asDouble()     // Catch:{ IllegalArgumentException -> 0x005c }
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x005c }
            float r3 = r3.floatValue()     // Catch:{ IllegalArgumentException -> 0x005c }
            java.lang.Float r9 = java.lang.Float.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x005c }
            goto L_0x007c
        L_0x002a:
            boolean r3 = r9 instanceof java.lang.Long     // Catch:{ IllegalArgumentException -> 0x005c }
            if (r3 != 0) goto L_0x0053
            boolean r3 = r9 instanceof java.lang.Integer     // Catch:{ IllegalArgumentException -> 0x005c }
            if (r3 == 0) goto L_0x0033
            goto L_0x0053
        L_0x0033:
            boolean r3 = r9 instanceof java.lang.String     // Catch:{ IllegalArgumentException -> 0x005c }
            if (r3 == 0) goto L_0x003c
            java.lang.String r9 = r0.asString()     // Catch:{ IllegalArgumentException -> 0x005c }
            goto L_0x007c
        L_0x003c:
            java.lang.String r3 = r0.asString()     // Catch:{ IllegalArgumentException -> 0x005c }
            com.google.android.gms.internal.firebase-perf.zzbi r4 = r7.zzaj     // Catch:{ IllegalArgumentException -> 0x0051 }
            java.lang.String r5 = "No matching type found for the defaultValue: '%s', using String."
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ IllegalArgumentException -> 0x0051 }
            r6[r2] = r9     // Catch:{ IllegalArgumentException -> 0x0051 }
            java.lang.String r9 = java.lang.String.format(r5, r6)     // Catch:{ IllegalArgumentException -> 0x0051 }
            r4.zzm(r9)     // Catch:{ IllegalArgumentException -> 0x0051 }
            r9 = r3
            goto L_0x007c
        L_0x0051:
            r9 = r3
            goto L_0x005c
        L_0x0053:
            long r3 = r0.asLong()     // Catch:{ IllegalArgumentException -> 0x005c }
            java.lang.Long r9 = java.lang.Long.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x005c }
            goto L_0x007c
        L_0x005c:
            java.lang.String r3 = r0.asString()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x007c
            com.google.android.gms.internal.firebase-perf.zzbi r3 = r7.zzaj
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r0 = r0.asString()
            r4[r2] = r0
            r4[r1] = r8
            java.lang.String r8 = "Could not parse value: '%s' for key: '%s'."
            java.lang.String r8 = java.lang.String.format(r8, r4)
            r3.zzm(r8)
        L_0x007c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.RemoteConfigManager.zza(java.lang.String, java.lang.Object):java.lang.Object");
    }

    private final FirebaseRemoteConfigValue zzl(String str) {
        if (zzck()) {
            if (System.currentTimeMillis() - this.zzet > zzes) {
                this.zzet = System.currentTimeMillis();
                this.zzeu.fetchAndActivate().addOnFailureListener(this.executor, (OnFailureListener) new zzx(this));
            }
        }
        if (!zzck()) {
            return null;
        }
        FirebaseRemoteConfigValue value = this.zzeu.getValue(str);
        if (value.getSource() != 2) {
            return null;
        }
        this.zzaj.zzm(String.format("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", new Object[]{value.asString(), str}));
        return value;
    }

    public final boolean zzcj() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.zzeu;
        if (firebaseRemoteConfig == null || firebaseRemoteConfig.getInfo().getLastFetchStatus() == 1) {
            return true;
        }
        return false;
    }

    private final boolean zzck() {
        return this.zzeu != null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Exception exc) {
        this.zzet = 0;
    }
}

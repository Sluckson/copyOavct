package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
public class zzil {
    private static final zzhi zza = zzhi.zza();
    private zzgm zzb;
    private volatile zzjg zzc;
    private volatile zzgm zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzil)) {
            return false;
        }
        zzil zzil = (zzil) obj;
        zzjg zzjg = this.zzc;
        zzjg zzjg2 = zzil.zzc;
        if (zzjg == null && zzjg2 == null) {
            return zzc().equals(zzil.zzc());
        }
        if (zzjg != null && zzjg2 != null) {
            return zzjg.equals(zzjg2);
        }
        if (zzjg != null) {
            return zzjg.equals(zzil.zzb(zzjg.zzbv()));
        }
        return zzb(zzjg2.zzbv()).equals(zzjg2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzjg zzb(com.google.android.gms.internal.measurement.zzjg r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzjg r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzjg r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzig -> 0x0012 }
            com.google.android.gms.internal.measurement.zzgm r0 = com.google.android.gms.internal.measurement.zzgm.zza     // Catch:{ zzig -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzig -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzgm r2 = com.google.android.gms.internal.measurement.zzgm.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzjg r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzil.zzb(com.google.android.gms.internal.measurement.zzjg):com.google.android.gms.internal.measurement.zzjg");
    }

    public final zzjg zza(zzjg zzjg) {
        zzjg zzjg2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjg;
        return zzjg2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbp();
        }
        return 0;
    }

    public final zzgm zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzgm zzgm = this.zzd;
                return zzgm;
            }
            if (this.zzc == null) {
                this.zzd = zzgm.zza;
            } else {
                this.zzd = this.zzc.zzbj();
            }
            zzgm zzgm2 = this.zzd;
            return zzgm2;
        }
    }
}

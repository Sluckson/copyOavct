package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzjm<T> implements zzjv<T> {
    private final zzjg zza;
    private final zzkn<?, ?> zzb;
    private final boolean zzc;
    private final zzhk<?> zzd;

    private zzjm(zzkn<?, ?> zzkn, zzhk<?> zzhk, zzjg zzjg) {
        this.zzb = zzkn;
        this.zzc = zzhk.zza(zzjg);
        this.zzd = zzhk;
        this.zza = zzjg;
    }

    static <T> zzjm<T> zza(zzkn<?, ?> zzkn, zzhk<?> zzhk, zzjg zzjg) {
        return new zzjm<>(zzkn, zzhk, zzjg);
    }

    public final T zza() {
        return this.zza.zzbu().zzx();
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    public final void zzb(T t, T t2) {
        zzjx.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzjx.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzlk zzlk) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzhq zzhq = (zzhq) next.getKey();
            if (zzhq.zzc() != zzlh.MESSAGE || zzhq.zzd() || zzhq.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzij) {
                zzlk.zza(zzhq.zza(), (Object) ((zzij) next).zza().zzc());
            } else {
                zzlk.zza(zzhq.zza(), next.getValue());
            }
        }
        zzkn<?, ?> zzkn = this.zzb;
        zzkn.zzb(zzkn.zzb(t), zzlk);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzhv$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzgl r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzhv r0 = (com.google.android.gms.internal.measurement.zzhv) r0
            com.google.android.gms.internal.measurement.zzkq r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzkq r2 = com.google.android.gms.internal.measurement.zzkq.zza()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzkq r1 = com.google.android.gms.internal.measurement.zzkq.zzb()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzhv$zzd r10 = (com.google.android.gms.internal.measurement.zzhv.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.zzhk<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzhi r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzjg r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzhv$zzf r0 = (com.google.android.gms.internal.measurement.zzhv.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzgi.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzkq) r6, (com.google.android.gms.internal.measurement.zzgl) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.zzjr.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.measurement.zzgi.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgl) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzgi.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzgm r2 = (com.google.android.gms.internal.measurement.zzgm) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.measurement.zzjr.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzhi r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzjg r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzhv$zzf r0 = (com.google.android.gms.internal.measurement.zzhv.zzf) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgl) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzig r10 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjm.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgl):void");
    }

    public final void zza(T t, zzjw zzjw, zzhi zzhi) throws IOException {
        boolean z;
        zzkn<?, ?> zzkn = this.zzb;
        zzhk<?> zzhk = this.zzd;
        Object zzc2 = zzkn.zzc(t);
        zzho<?> zzb2 = zzhk.zzb(t);
        do {
            try {
                if (zzjw.zza() == Integer.MAX_VALUE) {
                    zzkn.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzjw.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgm zzgm = null;
                    while (zzjw.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzjw.zzb();
                        if (zzb4 == 16) {
                            i = zzjw.zzo();
                            obj = zzhk.zza(zzhi, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzhk.zza(zzjw, obj, zzhi, zzb2);
                            } else {
                                zzgm = zzjw.zzn();
                            }
                        } else if (!zzjw.zzc()) {
                            break;
                        }
                    }
                    if (zzjw.zzb() != 12) {
                        throw zzig.zze();
                    } else if (zzgm != null) {
                        if (obj != null) {
                            zzhk.zza(zzgm, obj, zzhi, zzb2);
                        } else {
                            zzkn.zza(zzc2, i, zzgm);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzhk.zza(zzhi, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzhk.zza(zzjw, zza2, zzhi, zzb2);
                    } else {
                        z = zzkn.zza(zzc2, zzjw);
                        continue;
                    }
                } else {
                    z = zzjw.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzkn.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    public final int zzb(T t) {
        zzkn<?, ?> zzkn = this.zzb;
        int zze = zzkn.zze(zzkn.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }
}

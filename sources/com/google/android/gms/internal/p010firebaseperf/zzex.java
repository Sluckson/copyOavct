package com.google.android.gms.internal.p010firebaseperf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzex */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzex implements zziu {
    private final zzev zzng;

    public static zzex zza(zzev zzev) {
        if (zzev.zznp != null) {
            return zzev.zznp;
        }
        return new zzex(zzev);
    }

    private zzex(zzev zzev) {
        this.zzng = (zzev) zzfj.checkNotNull(zzev, "output");
        this.zzng.zznp = this;
    }

    public final int zzgx() {
        return zzhe.zzua;
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zzng.zzh(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzng.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzng.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzng.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzng.zza(i, d);
    }

    public final void zzp(int i, int i2) throws IOException {
        this.zzng.zze(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzng.zza(i, j);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zzng.zze(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzng.zzc(i, j);
    }

    public final void zzh(int i, int i2) throws IOException {
        this.zzng.zzh(i, i2);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zzng.zza(i, z);
    }

    public final void zza(int i, String str) throws IOException {
        this.zzng.zza(i, str);
    }

    public final void zza(int i, zzee zzee) throws IOException {
        this.zzng.zza(i, zzee);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zzng.zzf(i, i2);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzng.zzg(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzng.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzhi zzhi) throws IOException {
        this.zzng.zza(i, (zzgs) obj, zzhi);
    }

    public final void zzb(int i, Object obj, zzhi zzhi) throws IOException {
        zzev zzev = this.zzng;
        zzev.writeTag(i, 3);
        zzhi.zza((zzgs) obj, zzev.zznp);
        zzev.writeTag(i, 4);
    }

    public final void zzai(int i) throws IOException {
        this.zzng.writeTag(i, 3);
    }

    public final void zzaj(int i) throws IOException {
        this.zzng.writeTag(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzee) {
            this.zzng.zzb(i, (zzee) obj);
        } else {
            this.zzng.zza(i, (zzgs) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzz(list.get(i4).intValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzu(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzac(list.get(i4).intValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzat(list.get(i4).longValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzaq(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzau(list.get(i4).longValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzaq(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzaw(list.get(i4).longValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzas(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzc(list.get(i4).floatValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzb(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzb(list.get(i4).doubleValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzae(list.get(i4).intValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzu(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzg(list.get(i4).booleanValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzf(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            while (i2 < list.size()) {
                Object raw = zzfz.getRaw(i2);
                if (raw instanceof String) {
                    this.zzng.zza(i, (String) raw);
                } else {
                    this.zzng.zza(i, (zzee) raw);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzee> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzng.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzaa(list.get(i4).intValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzv(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzad(list.get(i4).intValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzax(list.get(i4).longValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzas(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzab(list.get(i4).intValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzw(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzng.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzev.zzav(list.get(i4).longValue());
            }
            this.zzng.zzv(i3);
            while (i2 < list.size()) {
                this.zzng.zzar(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzng.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzhi zzhi) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzhi);
        }
    }

    public final void zzb(int i, List<?> list, zzhi zzhi) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzhi);
        }
    }

    public final <K, V> void zza(int i, zzgj<K, V> zzgj, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzng.writeTag(i, 2);
            this.zzng.zzv(zzgk.zza(zzgj, next.getKey(), next.getValue()));
            zzev zzev = this.zzng;
            Object key = next.getKey();
            Object value = next.getValue();
            zzfa.zza(zzev, zzgj.zzsq, 1, key);
            zzfa.zza(zzev, zzgj.zzss, 2, value);
        }
    }
}

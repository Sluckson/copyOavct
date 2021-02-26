package com.google.android.gms.internal.p010firebaseperf;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhk */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhk {
    private static final Class<?> zzuk = zzjb();
    private static final zzia<?, ?> zzul = zzi(false);
    private static final zzia<?, ?> zzum = zzi(true);
    private static final zzia<?, ?> zzun = new zzic();

    public static void zzf(Class<?> cls) {
        Class<?> cls2;
        if (!zzfi.class.isAssignableFrom(cls) && (cls2 = zzuk) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zziu zziu, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zziu zziu) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzee> list, zziu zziu) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zziu zziu, zzhi zzhi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zza(i, list, zzhi);
        }
    }

    public static void zzb(int i, List<?> list, zziu zziu, zzhi zzhi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziu.zzb(i, list, zzhi);
        }
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgg) {
            zzgg zzgg = (zzgg) list;
            i = 0;
            while (i2 < size) {
                i += zzev.zzat(zzgg.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzev.zzat(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzc(list) + (list.size() * zzev.zzy(i));
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgg) {
            zzgg zzgg = (zzgg) list;
            i = 0;
            while (i2 < size) {
                i += zzev.zzau(zzgg.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzev.zzau(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzev.zzy(i));
    }

    static int zze(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgg) {
            zzgg zzgg = (zzgg) list;
            i = 0;
            while (i2 < size) {
                i += zzev.zzav(zzgg.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzev.zzav(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzev.zzy(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfk) {
            zzfk zzfk = (zzfk) list;
            i = 0;
            while (i2 < size) {
                i += zzev.zzae(zzfk.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzev.zzae(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzev.zzy(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfk) {
            zzfk zzfk = (zzfk) list;
            i = 0;
            while (i2 < size) {
                i += zzev.zzz(zzfk.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzev.zzz(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzev.zzy(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfk) {
            zzfk zzfk = (zzfk) list;
            i = 0;
            while (i2 < size) {
                i += zzev.zzaa(zzfk.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzev.zzaa(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzev.zzy(i));
    }

    static int zzi(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfk) {
            zzfk zzfk = (zzfk) list;
            i = 0;
            while (i2 < size) {
                i += zzev.zzab(zzfk.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzev.zzab(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzev.zzy(i));
    }

    static int zzj(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.zzl(i, 0);
    }

    static int zzk(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.zzg(i, 0);
    }

    static int zzl(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzy = zzev.zzy(i) * size;
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            while (i4 < size) {
                Object raw = zzfz.getRaw(i4);
                if (raw instanceof zzee) {
                    i3 = zzev.zzb((zzee) raw);
                } else {
                    i3 = zzev.zzal((String) raw);
                }
                zzy += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzee) {
                    i2 = zzev.zzb((zzee) obj);
                } else {
                    i2 = zzev.zzal((String) obj);
                }
                zzy += i2;
                i4++;
            }
        }
        return zzy;
    }

    static int zzc(int i, Object obj, zzhi zzhi) {
        if (obj instanceof zzfx) {
            return zzev.zza(i, (zzfx) obj);
        }
        return zzev.zzb(i, (zzgs) obj, zzhi);
    }

    static int zzc(int i, List<?> list, zzhi zzhi) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzev.zzy(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzfx) {
                i2 = zzev.zza((zzfx) obj);
            } else {
                i2 = zzev.zza((zzgs) obj, zzhi);
            }
            zzy += i2;
        }
        return zzy;
    }

    static int zzd(int i, List<zzee> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzev.zzy(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzy += zzev.zzb(list.get(i2));
        }
        return zzy;
    }

    static int zzd(int i, List<zzgs> list, zzhi zzhi) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzev.zzc(i, list.get(i3), zzhi);
        }
        return i2;
    }

    public static zzia<?, ?> zziy() {
        return zzul;
    }

    public static zzia<?, ?> zziz() {
        return zzum;
    }

    public static zzia<?, ?> zzja() {
        return zzun;
    }

    private static zzia<?, ?> zzi(boolean z) {
        try {
            Class<?> zzjc = zzjc();
            if (zzjc == null) {
                return null;
            }
            return (zzia) zzjc.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzjb() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzjc() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzgl zzgl, T t, T t2, long j) {
        zzig.zza((Object) t, j, zzgl.zzc(zzig.zzo(t, j), zzig.zzo(t2, j)));
    }

    static <T, FT extends zzfc<FT>> void zza(zzez<FT> zzez, T t, T t2) {
        zzfa<FT> zzd = zzez.zzd(t2);
        if (!zzd.zznv.isEmpty()) {
            zzez.zze((Object) t).zza(zzd);
        }
    }

    static <T, UT, UB> void zza(zzia<UT, UB> zzia, T t, T t2) {
        zzia.zzf(t, zzia.zzg(zzia.zzp(t), zzia.zzp(t2)));
    }
}

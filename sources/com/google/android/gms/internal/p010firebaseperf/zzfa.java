package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfa */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzfa<T extends zzfc<T>> {
    private static final zzfa zzny = new zzfa(true);
    final zzhj<T, Object> zznv;
    private boolean zznw;
    private boolean zznx;

    private zzfa() {
        this.zznv = zzhj.zzat(16);
    }

    private zzfa(boolean z) {
        this(zzhj.zzat(0));
        zzgk();
    }

    private zzfa(zzhj<T, Object> zzhj) {
        this.zznv = zzhj;
        zzgk();
    }

    public static <T extends zzfc<T>> zzfa<T> zzgy() {
        return zzny;
    }

    public final void zzgk() {
        if (!this.zznw) {
            this.zznv.zzgk();
            this.zznw = true;
        }
    }

    public final boolean isImmutable() {
        return this.zznw;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfa)) {
            return false;
        }
        return this.zznv.equals(((zzfa) obj).zznv);
    }

    public final int hashCode() {
        return this.zznv.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zznx) {
            return new zzfy(this.zznv.entrySet().iterator());
        }
        return this.zznv.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zznx) {
            return new zzfy(this.zznv.zziv().iterator());
        }
        return this.zznv.zziv().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zznv.get(t);
        if (!(obj instanceof zzft)) {
            return obj;
        }
        zzft zzft = (zzft) obj;
        return zzft.zzhu();
    }

    private final void zza(T t, Object obj) {
        if (!t.zzhf()) {
            zza(t.zzhd(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzhd(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzft) {
            this.zznx = true;
        }
        this.zznv.put(t, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.p010firebaseperf.zzfm) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.p010firebaseperf.zzft) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.p010firebaseperf.zzio r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.p010firebaseperf.zzfj.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.p010firebaseperf.zzfd.zzob
            com.google.android.gms.internal.firebase-perf.zzir r2 = r2.zzjo()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.p010firebaseperf.zzgs
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.p010firebaseperf.zzft
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.p010firebaseperf.zzfm
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.p010firebaseperf.zzee
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzfa.zza(com.google.android.gms.internal.firebase-perf.zzio, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zznv.zzit(); i++) {
            if (!zzc(this.zznv.zzau(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzc : this.zznv.zziu()) {
            if (!zzc(zzc)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzfc<T>> boolean zzc(Map.Entry<T, Object> entry) {
        zzfc zzfc = (zzfc) entry.getKey();
        if (zzfc.zzhe() == zzir.MESSAGE) {
            if (zzfc.zzhf()) {
                for (zzgs isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgs) {
                    if (!((zzgs) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzft) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfa<T> zzfa) {
        for (int i = 0; i < zzfa.zznv.zzit(); i++) {
            zzd(zzfa.zznv.zzau(i));
        }
        for (Map.Entry<T, Object> zzd : zzfa.zznv.zziu()) {
            zzd(zzd);
        }
    }

    private static Object zzg(Object obj) {
        if (obj instanceof zzgy) {
            return ((zzgy) obj).zzgg();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzd(Map.Entry<T, Object> entry) {
        Object obj;
        zzfc zzfc = (zzfc) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzft) {
            zzft zzft = (zzft) value;
            value = zzft.zzhu();
        }
        if (zzfc.zzhf()) {
            Object zza = zza(zzfc);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzg : (List) value) {
                ((List) zza).add(zzg(zzg));
            }
            this.zznv.put(zzfc, zza);
        } else if (zzfc.zzhe() == zzir.MESSAGE) {
            Object zza2 = zza(zzfc);
            if (zza2 == null) {
                this.zznv.put(zzfc, zzg(value));
                return;
            }
            if (zza2 instanceof zzgy) {
                obj = zzfc.zza((zzgy) zza2, (zzgy) value);
            } else {
                obj = zzfc.zza(((zzgs) zza2).zzhr(), (zzgs) value).zzhm();
            }
            this.zznv.put(zzfc, obj);
        } else {
            this.zznv.put(zzfc, zzg(value));
        }
    }

    static void zza(zzev zzev, zzio zzio, int i, Object obj) throws IOException {
        if (zzio == zzio.GROUP) {
            zzgs zzgs = (zzgs) obj;
            zzfj.zzf(zzgs);
            zzev.writeTag(i, 3);
            zzgs.writeTo(zzev);
            zzev.writeTag(i, 4);
            return;
        }
        zzev.writeTag(i, zzio.zzjp());
        switch (zzfd.zzoc[zzio.ordinal()]) {
            case 1:
                zzev.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzev.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzev.zzaq(((Long) obj).longValue());
                return;
            case 4:
                zzev.zzaq(((Long) obj).longValue());
                return;
            case 5:
                zzev.zzu(((Integer) obj).intValue());
                return;
            case 6:
                zzev.zzas(((Long) obj).longValue());
                return;
            case 7:
                zzev.zzx(((Integer) obj).intValue());
                return;
            case 8:
                zzev.zzf(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgs) obj).writeTo(zzev);
                return;
            case 10:
                zzev.zzb((zzgs) obj);
                return;
            case 11:
                if (obj instanceof zzee) {
                    zzev.zza((zzee) obj);
                    return;
                } else {
                    zzev.zzak((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzee) {
                    zzev.zza((zzee) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzev.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzev.zzv(((Integer) obj).intValue());
                return;
            case 14:
                zzev.zzx(((Integer) obj).intValue());
                return;
            case 15:
                zzev.zzas(((Long) obj).longValue());
                return;
            case 16:
                zzev.zzw(((Integer) obj).intValue());
                return;
            case 17:
                zzev.zzar(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfm) {
                    zzev.zzu(((zzfm) obj).getNumber());
                    return;
                } else {
                    zzev.zzu(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzgz() {
        int i = 0;
        for (int i2 = 0; i2 < this.zznv.zzit(); i2++) {
            i += zze(this.zznv.zzau(i2));
        }
        for (Map.Entry<T, Object> zze : this.zznv.zziu()) {
            i += zze(zze);
        }
        return i;
    }

    private static int zze(Map.Entry<T, Object> entry) {
        zzfc zzfc = (zzfc) entry.getKey();
        Object value = entry.getValue();
        if (zzfc.zzhe() != zzir.MESSAGE || zzfc.zzhf() || zzfc.zzhg()) {
            return zzb((zzfc<?>) zzfc, value);
        }
        if (value instanceof zzft) {
            return zzev.zzb(((zzfc) entry.getKey()).getNumber(), (zzfx) (zzft) value);
        }
        return zzev.zzb(((zzfc) entry.getKey()).getNumber(), (zzgs) value);
    }

    static int zza(zzio zzio, int i, Object obj) {
        int zzy = zzev.zzy(i);
        if (zzio == zzio.GROUP) {
            zzfj.zzf((zzgs) obj);
            zzy <<= 1;
        }
        return zzy + zzb(zzio, obj);
    }

    private static int zzb(zzio zzio, Object obj) {
        switch (zzfd.zzoc[zzio.ordinal()]) {
            case 1:
                return zzev.zzb(((Double) obj).doubleValue());
            case 2:
                return zzev.zzc(((Float) obj).floatValue());
            case 3:
                return zzev.zzat(((Long) obj).longValue());
            case 4:
                return zzev.zzau(((Long) obj).longValue());
            case 5:
                return zzev.zzz(((Integer) obj).intValue());
            case 6:
                return zzev.zzaw(((Long) obj).longValue());
            case 7:
                return zzev.zzac(((Integer) obj).intValue());
            case 8:
                return zzev.zzg(((Boolean) obj).booleanValue());
            case 9:
                return zzev.zzd((zzgs) obj);
            case 10:
                if (obj instanceof zzft) {
                    return zzev.zza((zzfx) (zzft) obj);
                }
                return zzev.zzc((zzgs) obj);
            case 11:
                if (obj instanceof zzee) {
                    return zzev.zzb((zzee) obj);
                }
                return zzev.zzal((String) obj);
            case 12:
                if (obj instanceof zzee) {
                    return zzev.zzb((zzee) obj);
                }
                return zzev.zzb((byte[]) obj);
            case 13:
                return zzev.zzaa(((Integer) obj).intValue());
            case 14:
                return zzev.zzad(((Integer) obj).intValue());
            case 15:
                return zzev.zzax(((Long) obj).longValue());
            case 16:
                return zzev.zzab(((Integer) obj).intValue());
            case 17:
                return zzev.zzav(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfm) {
                    return zzev.zzae(((zzfm) obj).getNumber());
                }
                return zzev.zzae(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzfc<?> zzfc, Object obj) {
        zzio zzhd = zzfc.zzhd();
        int number = zzfc.getNumber();
        if (!zzfc.zzhf()) {
            return zza(zzhd, number, obj);
        }
        int i = 0;
        if (zzfc.zzhg()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzhd, zzb);
            }
            return zzev.zzy(number) + i + zzev.zzah(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzhd, number, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfa zzfa = new zzfa();
        for (int i = 0; i < this.zznv.zzit(); i++) {
            Map.Entry<T, Object> zzau = this.zznv.zzau(i);
            zzfa.zza((zzfc) zzau.getKey(), zzau.getValue());
        }
        for (Map.Entry next : this.zznv.zziu()) {
            zzfa.zza((zzfc) next.getKey(), next.getValue());
        }
        zzfa.zznx = this.zznx;
        return zzfa;
    }
}

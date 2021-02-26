package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzho<T extends zzhq<T>> {
    private static final zzho zzd = new zzho(true);
    final zzka<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzho() {
        this.zza = zzka.zza(16);
    }

    private zzho(boolean z) {
        this(zzka.zza(0));
        zzb();
    }

    private zzho(zzka<T, Object> zzka) {
        this.zza = zzka;
        zzb();
    }

    public static <T extends zzhq<T>> zzho<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzho)) {
            return false;
        }
        return this.zza.equals(((zzho) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzim(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzim(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzih)) {
            return obj;
        }
        zzih zzih = (zzih) obj;
        return zzih.zza();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzih) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzia) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzih) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzle r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzhx.zza(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzhn.zza
            com.google.android.gms.internal.measurement.zzlh r2 = r2.zza()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzjg
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzih
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzia
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgm
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzho.zza(com.google.android.gms.internal.measurement.zzle, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza(this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzd()) {
            if (!zza(zza2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzhq<T>> boolean zza(Map.Entry<T, Object> entry) {
        zzhq zzhq = (zzhq) entry.getKey();
        if (zzhq.zzc() == zzlh.MESSAGE) {
            if (zzhq.zzd()) {
                for (zzjg zzbn : (List) entry.getValue()) {
                    if (!zzbn.zzbn()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjg) {
                    if (!((zzjg) value).zzbn()) {
                        return false;
                    }
                } else if (value instanceof zzih) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzho<T> zzho) {
        for (int i = 0; i < zzho.zza.zzc(); i++) {
            zzb(zzho.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zzho.zza.zzd()) {
            zzb(zzb2);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzjl) {
            return ((zzjl) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzhq zzhq = (zzhq) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzih) {
            zzih zzih = (zzih) value;
            value = zzih.zza();
        }
        if (zzhq.zzd()) {
            Object zza2 = zza(zzhq);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzhq, zza2);
        } else if (zzhq.zzc() == zzlh.MESSAGE) {
            Object zza4 = zza(zzhq);
            if (zza4 == null) {
                this.zza.put(zzhq, zza(value));
                return;
            }
            if (zza4 instanceof zzjl) {
                obj = zzhq.zza((zzjl) zza4, (zzjl) value);
            } else {
                obj = zzhq.zza(((zzjg) zza4).zzbt(), (zzjg) value).zzy();
            }
            this.zza.put(zzhq, obj);
        } else {
            this.zza.put(zzhq, zza(value));
        }
    }

    static void zza(zzhf zzhf, zzle zzle, int i, Object obj) throws IOException {
        if (zzle == zzle.GROUP) {
            zzjg zzjg = (zzjg) obj;
            zzhx.zza(zzjg);
            zzhf.zza(i, 3);
            zzjg.zza(zzhf);
            zzhf.zza(i, 4);
            return;
        }
        zzhf.zza(i, zzle.zzb());
        switch (zzle) {
            case DOUBLE:
                zzhf.zza(((Double) obj).doubleValue());
                return;
            case FLOAT:
                zzhf.zza(((Float) obj).floatValue());
                return;
            case INT64:
                zzhf.zza(((Long) obj).longValue());
                return;
            case UINT64:
                zzhf.zza(((Long) obj).longValue());
                return;
            case INT32:
                zzhf.zza(((Integer) obj).intValue());
                return;
            case FIXED64:
                zzhf.zzc(((Long) obj).longValue());
                return;
            case FIXED32:
                zzhf.zzd(((Integer) obj).intValue());
                return;
            case BOOL:
                zzhf.zza(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                ((zzjg) obj).zza(zzhf);
                return;
            case MESSAGE:
                zzhf.zza((zzjg) obj);
                return;
            case STRING:
                if (obj instanceof zzgm) {
                    zzhf.zza((zzgm) obj);
                    return;
                } else {
                    zzhf.zza((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof zzgm) {
                    zzhf.zza((zzgm) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzhf.zzb(bArr, 0, bArr.length);
                return;
            case UINT32:
                zzhf.zzb(((Integer) obj).intValue());
                return;
            case SFIXED32:
                zzhf.zzd(((Integer) obj).intValue());
                return;
            case SFIXED64:
                zzhf.zzc(((Long) obj).longValue());
                return;
            case SINT32:
                zzhf.zzc(((Integer) obj).intValue());
                return;
            case SINT64:
                zzhf.zzb(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof zzia) {
                    zzhf.zza(((zzia) obj).zza());
                    return;
                } else {
                    zzhf.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzd()) {
            i += zzc(zzc2);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        zzhq zzhq = (zzhq) entry.getKey();
        Object value = entry.getValue();
        if (zzhq.zzc() != zzlh.MESSAGE || zzhq.zzd() || zzhq.zze()) {
            return zza((zzhq<?>) zzhq, value);
        }
        if (value instanceof zzih) {
            return zzhf.zzb(((zzhq) entry.getKey()).zza(), (zzil) (zzih) value);
        }
        return zzhf.zzb(((zzhq) entry.getKey()).zza(), (zzjg) value);
    }

    static int zza(zzle zzle, int i, Object obj) {
        int zze = zzhf.zze(i);
        if (zzle == zzle.GROUP) {
            zzhx.zza((zzjg) obj);
            zze <<= 1;
        }
        return zze + zzb(zzle, obj);
    }

    private static int zzb(zzle zzle, Object obj) {
        switch (zzle) {
            case DOUBLE:
                return zzhf.zzb(((Double) obj).doubleValue());
            case FLOAT:
                return zzhf.zzb(((Float) obj).floatValue());
            case INT64:
                return zzhf.zzd(((Long) obj).longValue());
            case UINT64:
                return zzhf.zze(((Long) obj).longValue());
            case INT32:
                return zzhf.zzf(((Integer) obj).intValue());
            case FIXED64:
                return zzhf.zzg(((Long) obj).longValue());
            case FIXED32:
                return zzhf.zzi(((Integer) obj).intValue());
            case BOOL:
                return zzhf.zzb(((Boolean) obj).booleanValue());
            case GROUP:
                return zzhf.zzc((zzjg) obj);
            case MESSAGE:
                if (obj instanceof zzih) {
                    return zzhf.zza((zzil) (zzih) obj);
                }
                return zzhf.zzb((zzjg) obj);
            case STRING:
                if (obj instanceof zzgm) {
                    return zzhf.zzb((zzgm) obj);
                }
                return zzhf.zzb((String) obj);
            case BYTES:
                if (obj instanceof zzgm) {
                    return zzhf.zzb((zzgm) obj);
                }
                return zzhf.zzb((byte[]) obj);
            case UINT32:
                return zzhf.zzg(((Integer) obj).intValue());
            case SFIXED32:
                return zzhf.zzj(((Integer) obj).intValue());
            case SFIXED64:
                return zzhf.zzh(((Long) obj).longValue());
            case SINT32:
                return zzhf.zzh(((Integer) obj).intValue());
            case SINT64:
                return zzhf.zzf(((Long) obj).longValue());
            case ENUM:
                if (obj instanceof zzia) {
                    return zzhf.zzk(((zzia) obj).zza());
                }
                return zzhf.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzhq<?> zzhq, Object obj) {
        zzle zzb2 = zzhq.zzb();
        int zza2 = zzhq.zza();
        if (!zzhq.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzhq.zze()) {
            for (Object zzb3 : (List) obj) {
                i += zzb(zzb2, zzb3);
            }
            return zzhf.zze(zza2) + i + zzhf.zzl(i);
        }
        for (Object zza3 : (List) obj) {
            i += zza(zzb2, zza2, zza3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzho zzho = new zzho();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzho.zzb((zzhq) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzd()) {
            zzho.zzb((zzhq) next.getKey(), next.getValue());
        }
        zzho.zzc = this.zzc;
        return zzho;
    }
}

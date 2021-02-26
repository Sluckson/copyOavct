package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhf */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhf implements zzgq {
    private final int flags;
    private final String info;
    private final zzgs zzsz;
    private final Object[] zztg;

    zzhf(zzgs zzgs, String str, Object[] objArr) {
        this.zzsz = zzgs;
        this.info = str;
        this.zztg = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zziq() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzir() {
        return this.zztg;
    }

    public final zzgs zzil() {
        return this.zzsz;
    }

    public final int zzij() {
        return (this.flags & 1) == 1 ? zzhe.zztx : zzhe.zzty;
    }

    public final boolean zzik() {
        return (this.flags & 2) == 2;
    }
}

package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzes */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzes extends zzeq {
    private final byte[] buffer;
    private final boolean immutable;
    private int limit;
    private int pos;
    private int zznl;
    private int zznm;
    private int zznn;

    private zzes(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zznn = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zznm = this.pos;
        this.immutable = z;
    }

    public final int zzt(int i) throws zzfs {
        if (i >= 0) {
            int zzgs = i + zzgs();
            int i2 = this.zznn;
            if (zzgs <= i2) {
                this.zznn = zzgs;
                this.limit += this.zznl;
                int i3 = this.limit;
                int i4 = i3 - this.zznm;
                int i5 = this.zznn;
                if (i4 > i5) {
                    this.zznl = i4 - i5;
                    this.limit = i3 - this.zznl;
                } else {
                    this.zznl = 0;
                }
                return i2;
            }
            throw new zzfs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzfs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int zzgs() {
        return this.pos - this.zznm;
    }
}

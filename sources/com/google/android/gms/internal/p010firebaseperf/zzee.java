package com.google.android.gms.internal.p010firebaseperf;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzee */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzee implements Serializable, Iterable<Byte> {
    public static final zzee zzna = new zzeo(zzfj.EMPTY_BYTE_ARRAY);
    private static final zzek zznb = (zzec.zzgh() ? new zzer((zzeh) null) : new zzei((zzeh) null));
    private static final Comparator<zzee> zznc = new zzeg();
    private int zzy = 0;

    zzee() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzef zzef) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int zzb(int i, int i2, int i3);

    public abstract zzee zzd(int i, int i2);

    public abstract boolean zzgn();

    public abstract byte zzq(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzr(int i);

    public static zzee zzaj(String str) {
        return new zzeo(str.getBytes(zzfj.UTF_8));
    }

    public final String zzgm() {
        return size() == 0 ? "" : zza(zzfj.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzy;
        if (i == 0) {
            int size = size();
            i = zzb(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzy = i;
        }
        return i;
    }

    static zzem zzs(int i) {
        return new zzem(i, (zzeh) null);
    }

    /* access modifiers changed from: protected */
    public final int zzgo() {
        return this.zzy;
    }

    static int zzc(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzhw.zzd(this) : String.valueOf(zzhw.zzd(zzd(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public /* synthetic */ Iterator iterator() {
        return new zzeh(this);
    }
}

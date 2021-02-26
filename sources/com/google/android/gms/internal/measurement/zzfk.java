package com.google.android.gms.internal.measurement;

import java.util.Map;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfk<K, V> extends zzfb<K, V> {
    static final zzfb<Object, Object> zza = new zzfk((Object) null, new Object[0], 0);
    private final transient Object zzb;
    private final transient Object[] zzc;
    private final transient int zzd;

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r2v4 ?, r2v1 ?, r2v5 ?, r2v6 ?, r2v8 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static <K, V> com.google.android.gms.internal.measurement.zzfk<K, V> zza(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.gms.internal.measurement.zzfb<java.lang.Object, java.lang.Object> r10 = zza
            com.google.android.gms.internal.measurement.zzfk r10 = (com.google.android.gms.internal.measurement.zzfk) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            com.google.android.gms.internal.measurement.zzei.zza(r10, r1)
            com.google.android.gms.internal.measurement.zzfk r10 = new com.google.android.gms.internal.measurement.zzfk
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            com.google.android.gms.internal.measurement.zzdw.zzb((int) r10, (int) r3)
            int r3 = com.google.android.gms.internal.measurement.zzff.zza(r10)
            if (r10 != r2) goto L_0x002e
            r1 = r11[r1]
            r2 = r11[r2]
            com.google.android.gms.internal.measurement.zzei.zza(r1, r2)
            r2 = r0
            goto L_0x00df
        L_0x002e:
            int r0 = r3 + -1
            r2 = 128(0x80, float:1.794E-43)
            r4 = -1
            if (r3 > r2) goto L_0x006d
            byte[] r2 = new byte[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x003a:
            if (r1 >= r10) goto L_0x00df
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.measurement.zzei.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.measurement.zzeu.zza((int) r6)
        L_0x004f:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x005d
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x003a
        L_0x005d:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0068
            int r6 = r6 + 1
            goto L_0x004f
        L_0x0068:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x006d:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r3 > r2) goto L_0x00ab
            short[] r2 = new short[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x0077:
            if (r1 >= r10) goto L_0x00df
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.measurement.zzei.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.measurement.zzeu.zza((int) r6)
        L_0x008c:
            r6 = r6 & r0
            short r7 = r2[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x009b
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0077
        L_0x009b:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00a6
            int r6 = r6 + 1
            goto L_0x008c
        L_0x00a6:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x00ab:
            int[] r2 = new int[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x00b0:
            if (r1 >= r10) goto L_0x00df
            int r3 = r1 * 2
            r5 = r11[r3]
            r6 = r3 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.measurement.zzei.zza(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.measurement.zzeu.zza((int) r7)
        L_0x00c5:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r4) goto L_0x00cf
            r2[r7] = r3
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00cf:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x00da
            int r7 = r7 + 1
            goto L_0x00c5
        L_0x00da:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x00df:
            com.google.android.gms.internal.measurement.zzfk r0 = new com.google.android.gms.internal.measurement.zzfk
            r0.<init>(r2, r11, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfk.zza(int, java.lang.Object[]):com.google.android.gms.internal.measurement.zzfk");
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private zzfk(Object obj, Object[] objArr, int i) {
        this.zzb = obj;
        this.zzc = objArr;
        this.zzd = i;
    }

    public final int size() {
        return this.zzd;
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzb;
        V[] vArr = this.zzc;
        int i = this.zzd;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zza2 = zzeu.zza(obj.hashCode());
                while (true) {
                    int i2 = zza2 & length;
                    byte b = bArr[i2] & 255;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zza2 = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zza3 = zzeu.zza(obj.hashCode());
                while (true) {
                    int i3 = zza3 & length2;
                    short s = sArr[i3] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    zza3 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zza4 = zzeu.zza(obj.hashCode());
                while (true) {
                    int i4 = zza4 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zza4 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzff<Map.Entry<K, V>> zza() {
        return new zzfn(this, this.zzc, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzff<K> zzb() {
        return new zzfp(this, new zzfo(this.zzc, 0, this.zzd));
    }

    /* access modifiers changed from: package-private */
    public final zzex<V> zzc() {
        return new zzfo(this.zzc, 1, this.zzd);
    }
}

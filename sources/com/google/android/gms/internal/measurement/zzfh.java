package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzfh<K, V> extends zzfc<K, V> {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        if (r9.zzg() == false) goto L_0x00cb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzfe<K, V> zza() {
        /*
            r19 = this;
            r0 = r19
            java.util.Map r1 = r0.zza
            java.util.Set r1 = r1.entrySet()
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0011
            com.google.android.gms.internal.measurement.zzev r1 = com.google.android.gms.internal.measurement.zzev.zza
            return r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzfa r2 = new com.google.android.gms.internal.measurement.zzfa
            int r3 = r1.size()
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
            r4 = 0
        L_0x001f:
            boolean r5 = r1.hasNext()
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x012c
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r8 = r5.getKey()
            java.lang.Object r5 = r5.getValue()
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r9 = r5 instanceof com.google.android.gms.internal.measurement.zzff
            if (r9 == 0) goto L_0x004a
            boolean r9 = r5 instanceof java.util.SortedSet
            if (r9 != 0) goto L_0x004a
            r9 = r5
            com.google.android.gms.internal.measurement.zzff r9 = (com.google.android.gms.internal.measurement.zzff) r9
            boolean r10 = r9.zzg()
            if (r10 != 0) goto L_0x004a
            goto L_0x00cb
        L_0x004a:
            java.lang.Object[] r5 = r5.toArray()
            int r9 = r5.length
        L_0x004f:
            if (r9 == 0) goto L_0x00c9
            if (r9 == r7) goto L_0x00c0
            int r10 = com.google.android.gms.internal.measurement.zzff.zza(r9)
            java.lang.Object[] r14 = new java.lang.Object[r10]
            int r15 = r10 + -1
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x005e:
            if (r11 >= r9) goto L_0x008c
            r3 = r5[r11]
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzfi.zza(r3, r11)
            int r16 = r3.hashCode()
            int r17 = com.google.android.gms.internal.measurement.zzeu.zza((int) r16)
        L_0x006e:
            r18 = r17 & r15
            r7 = r14[r18]
            if (r7 != 0) goto L_0x007e
            int r7 = r13 + 1
            r5[r13] = r3
            r14[r18] = r3
            int r12 = r12 + r16
            r13 = r7
            goto L_0x0088
        L_0x007e:
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0088
            int r17 = r17 + 1
            r7 = 1
            goto L_0x006e
        L_0x0088:
            int r11 = r11 + 1
            r7 = 1
            goto L_0x005e
        L_0x008c:
            java.util.Arrays.fill(r5, r13, r9, r6)
            r3 = 1
            if (r13 != r3) goto L_0x009b
            r3 = 0
            r5 = r5[r3]
            com.google.android.gms.internal.measurement.zzft r9 = new com.google.android.gms.internal.measurement.zzft
            r9.<init>(r5, r12)
            goto L_0x00cb
        L_0x009b:
            int r3 = com.google.android.gms.internal.measurement.zzff.zza(r13)
            int r10 = r10 / 2
            if (r3 >= r10) goto L_0x00a6
            r9 = r13
            r7 = 1
            goto L_0x004f
        L_0x00a6:
            int r3 = r5.length
            int r6 = r3 >> 1
            int r3 = r3 >> 2
            int r6 = r6 + r3
            if (r13 >= r6) goto L_0x00b2
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r13)
        L_0x00b2:
            com.google.android.gms.internal.measurement.zzfr r3 = new com.google.android.gms.internal.measurement.zzfr
            r11 = r3
            r6 = r12
            r12 = r5
            r5 = r13
            r13 = r6
            r16 = r5
            r11.<init>(r12, r13, r14, r15, r16)
            r9 = r3
            goto L_0x00cb
        L_0x00c0:
            r3 = 0
            r5 = r5[r3]
            com.google.android.gms.internal.measurement.zzft r9 = new com.google.android.gms.internal.measurement.zzft
            r9.<init>(r5)
            goto L_0x00cb
        L_0x00c9:
            com.google.android.gms.internal.measurement.zzfr<java.lang.Object> r9 = com.google.android.gms.internal.measurement.zzfr.zza
        L_0x00cb:
            boolean r3 = r9.isEmpty()
            if (r3 != 0) goto L_0x0129
            int r3 = r2.zzb
            r5 = 1
            int r3 = r3 + r5
            int r3 = r3 << r5
            java.lang.Object[] r6 = r2.zza
            int r6 = r6.length
            if (r3 <= r6) goto L_0x0107
            java.lang.Object[] r6 = r2.zza
            java.lang.Object[] r7 = r2.zza
            int r7 = r7.length
            if (r3 < 0) goto L_0x00ff
            int r10 = r7 >> 1
            int r7 = r7 + r10
            int r7 = r7 + r5
            if (r7 >= r3) goto L_0x00f0
            int r3 = r3 + -1
            int r3 = java.lang.Integer.highestOneBit(r3)
            int r7 = r3 << 1
        L_0x00f0:
            if (r7 >= 0) goto L_0x00f5
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x00f5:
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r6, r7)
            r2.zza = r3
            r3 = 0
            r2.zzc = r3
            goto L_0x0108
        L_0x00ff:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            java.lang.String r2 = "cannot store more than MAX_VALUE elements"
            r1.<init>(r2)
            throw r1
        L_0x0107:
            r3 = 0
        L_0x0108:
            com.google.android.gms.internal.measurement.zzei.zza(r8, r9)
            java.lang.Object[] r5 = r2.zza
            int r6 = r2.zzb
            int r6 = r6 * 2
            r5[r6] = r8
            java.lang.Object[] r5 = r2.zza
            int r6 = r2.zzb
            int r6 = r6 * 2
            r7 = 1
            int r6 = r6 + r7
            r5[r6] = r9
            int r5 = r2.zzb
            int r5 = r5 + r7
            r2.zzb = r5
            int r5 = r9.size()
            int r4 = r4 + r5
            goto L_0x001f
        L_0x0129:
            r3 = 0
            goto L_0x001f
        L_0x012c:
            com.google.android.gms.internal.measurement.zzfe r1 = new com.google.android.gms.internal.measurement.zzfe
            r2.zzc = r7
            int r3 = r2.zzb
            java.lang.Object[] r2 = r2.zza
            com.google.android.gms.internal.measurement.zzfk r2 = com.google.android.gms.internal.measurement.zzfk.zza(r3, r2)
            r1.<init>(r2, r4, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfh.zza():com.google.android.gms.internal.measurement.zzfe");
    }
}

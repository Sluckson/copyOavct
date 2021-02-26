package com.google.firebase.perf.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.p010firebaseperf.zzdm;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzl extends zzs {
    private zzdm zzdr;

    zzl(@NonNull zzdm zzdm) {
        this.zzdr = zzdm;
    }

    public final boolean zzbx() {
        boolean z;
        boolean z2;
        if (!zzb(this.zzdr, 0)) {
            String valueOf = String.valueOf(this.zzdr.getName());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Invalid Trace:".concat(valueOf) : new String("Invalid Trace:"));
            return false;
        }
        zzdm zzdm = this.zzdr;
        if (zzdm.zzfr() > 0) {
            z = true;
        } else {
            Iterator<zzdm> it = zzdm.zzfu().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next().zzfr() > 0) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            z = true;
        }
        if (!z || zza(this.zzdr, 0)) {
            return true;
        }
        String valueOf2 = String.valueOf(this.zzdr.getName());
        Log.w("FirebasePerformance", valueOf2.length() != 0 ? "Invalid Counters for Trace:".concat(valueOf2) : new String("Invalid Counters for Trace:"));
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0052 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(@androidx.annotation.Nullable com.google.android.gms.internal.p010firebaseperf.zzdm r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "FirebasePerformance"
            r2 = 1
            if (r9 <= r2) goto L_0x000f
            java.lang.String r8 = "Exceed MAX_SUBTRACE_DEEP:1"
            android.util.Log.w(r1, r8)
            return r0
        L_0x000f:
            java.util.Map r3 = r8.zzfs()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x001b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00a7
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L_0x0031
        L_0x002f:
            r5 = 0
            goto L_0x0050
        L_0x0031:
            java.lang.String r5 = r5.trim()
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x0041
            java.lang.String r5 = "counterId is empty"
            android.util.Log.w(r1, r5)
            goto L_0x002f
        L_0x0041:
            int r5 = r5.length()
            r6 = 100
            if (r5 <= r6) goto L_0x004f
            java.lang.String r5 = "counterId exceeded max length 100"
            android.util.Log.w(r1, r5)
            goto L_0x002f
        L_0x004f:
            r5 = 1
        L_0x0050:
            if (r5 != 0) goto L_0x0073
            java.lang.String r8 = "invalid CounterId:"
            java.lang.Object r9 = r4.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r2 = r9.length()
            if (r2 == 0) goto L_0x0069
            java.lang.String r8 = r8.concat(r9)
            goto L_0x006f
        L_0x0069:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r8)
            r8 = r9
        L_0x006f:
            android.util.Log.w(r1, r8)
            return r0
        L_0x0073:
            java.lang.Object r5 = r4.getValue()
            java.lang.Long r5 = (java.lang.Long) r5
            if (r5 == 0) goto L_0x007d
            r5 = 1
            goto L_0x007e
        L_0x007d:
            r5 = 0
        L_0x007e:
            if (r5 != 0) goto L_0x001b
            java.lang.Object r8 = r4.getValue()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r9 = java.lang.String.valueOf(r8)
            int r9 = r9.length()
            int r9 = r9 + 21
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            java.lang.String r9 = "invalid CounterValue:"
            r2.append(r9)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.util.Log.w(r1, r8)
            return r0
        L_0x00a7:
            java.util.List r8 = r8.zzfu()
            java.util.Iterator r8 = r8.iterator()
        L_0x00af:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x00c4
            java.lang.Object r1 = r8.next()
            com.google.android.gms.internal.firebase-perf.zzdm r1 = (com.google.android.gms.internal.p010firebaseperf.zzdm) r1
            int r3 = r9 + 1
            boolean r1 = r7.zza(r1, r3)
            if (r1 != 0) goto L_0x00af
            return r0
        L_0x00c4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.zzl.zza(com.google.android.gms.internal.firebase-perf.zzdm, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(@androidx.annotation.Nullable com.google.android.gms.internal.p010firebaseperf.zzdm r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "FirebasePerformance"
            r1 = 0
            if (r9 != 0) goto L_0x000b
            java.lang.String r9 = "TraceMetric is null"
            android.util.Log.w(r0, r9)
            return r1
        L_0x000b:
            r2 = 1
            if (r10 <= r2) goto L_0x0014
            java.lang.String r9 = "Exceed MAX_SUBTRACE_DEEP:1"
            android.util.Log.w(r0, r9)
            return r1
        L_0x0014:
            java.lang.String r3 = r9.getName()
            if (r3 == 0) goto L_0x002e
            java.lang.String r3 = r3.trim()
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x002e
            int r3 = r3.length()
            r4 = 100
            if (r3 > r4) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            if (r3 != 0) goto L_0x004f
            java.lang.String r10 = "invalid TraceId:"
            java.lang.String r9 = r9.getName()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r2 = r9.length()
            if (r2 == 0) goto L_0x0046
            java.lang.String r9 = r10.concat(r9)
            goto L_0x004b
        L_0x0046:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r10)
        L_0x004b:
            android.util.Log.w(r0, r9)
            return r1
        L_0x004f:
            if (r9 == 0) goto L_0x005d
            long r3 = r9.getDurationUs()
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005d
            r3 = 1
            goto L_0x005e
        L_0x005d:
            r3 = 0
        L_0x005e:
            if (r3 != 0) goto L_0x007b
            long r9 = r9.getDurationUs()
            r2 = 42
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "invalid TraceDuration:"
            r3.append(r2)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.w(r0, r9)
            return r1
        L_0x007b:
            boolean r3 = r9.zzeq()
            if (r3 != 0) goto L_0x0087
            java.lang.String r9 = "clientStartTimeUs is null."
            android.util.Log.w(r0, r9)
            return r1
        L_0x0087:
            java.util.List r3 = r9.zzfu()
            java.util.Iterator r3 = r3.iterator()
        L_0x008f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00a4
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.firebase-perf.zzdm r4 = (com.google.android.gms.internal.p010firebaseperf.zzdm) r4
            int r5 = r10 + 1
            boolean r4 = r8.zzb(r4, r5)
            if (r4 != 0) goto L_0x008f
            return r1
        L_0x00a4:
            java.util.Map r9 = r9.zzfw()
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x00b0:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00c7
            java.lang.Object r10 = r9.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.String r10 = com.google.firebase.perf.internal.zzs.zza(r10)
            if (r10 == 0) goto L_0x00b0
            android.util.Log.w(r0, r10)
            r9 = 0
            goto L_0x00c8
        L_0x00c7:
            r9 = 1
        L_0x00c8:
            if (r9 != 0) goto L_0x00cb
            return r1
        L_0x00cb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.zzl.zzb(com.google.android.gms.internal.firebase-perf.zzdm, int):boolean");
    }
}

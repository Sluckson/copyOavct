package com.google.android.gms.internal.p010firebaseperf;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzge */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzge extends zzgc {
    private static final Class<?> zzsk = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzge() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzig.zzo(obj, j);
        if (list instanceof zzfz) {
            obj2 = ((zzfz) list).zzhy();
        } else if (!zzsk.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzhb) || !(list instanceof zzfp)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzfp zzfp = (zzfp) list;
                if (zzfp.zzgj()) {
                    zzfp.zzgk();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzig.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.firebase-perf.zzga} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: com.google.android.gms.internal.firebase-perf.zzga} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.google.android.gms.internal.firebase-perf.zzga} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E> void zza(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.util.List r6 = zzc(r6, r7)
            int r0 = r6.size()
            java.util.List r1 = zzc(r5, r7)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0034
            boolean r2 = r1 instanceof com.google.android.gms.internal.p010firebaseperf.zzfz
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.firebase-perf.zzga r1 = new com.google.android.gms.internal.firebase-perf.zzga
            r1.<init>((int) r0)
            goto L_0x0030
        L_0x001c:
            boolean r2 = r1 instanceof com.google.android.gms.internal.p010firebaseperf.zzhb
            if (r2 == 0) goto L_0x002b
            boolean r2 = r1 instanceof com.google.android.gms.internal.p010firebaseperf.zzfp
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.internal.firebase-perf.zzfp r1 = (com.google.android.gms.internal.p010firebaseperf.zzfp) r1
            com.google.android.gms.internal.firebase-perf.zzfp r1 = r1.zzao(r0)
            goto L_0x0030
        L_0x002b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0030:
            com.google.android.gms.internal.p010firebaseperf.zzig.zza((java.lang.Object) r5, (long) r7, (java.lang.Object) r1)
            goto L_0x0087
        L_0x0034:
            java.lang.Class<?> r2 = zzsk
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0052
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
            com.google.android.gms.internal.p010firebaseperf.zzig.zza((java.lang.Object) r5, (long) r7, (java.lang.Object) r2)
        L_0x0050:
            r1 = r2
            goto L_0x0087
        L_0x0052:
            boolean r2 = r1 instanceof com.google.android.gms.internal.p010firebaseperf.zzib
            if (r2 == 0) goto L_0x0069
            com.google.android.gms.internal.firebase-perf.zzga r2 = new com.google.android.gms.internal.firebase-perf.zzga
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>((int) r3)
            com.google.android.gms.internal.firebase-perf.zzib r1 = (com.google.android.gms.internal.p010firebaseperf.zzib) r1
            r2.addAll(r1)
            com.google.android.gms.internal.p010firebaseperf.zzig.zza((java.lang.Object) r5, (long) r7, (java.lang.Object) r2)
            goto L_0x0050
        L_0x0069:
            boolean r2 = r1 instanceof com.google.android.gms.internal.p010firebaseperf.zzhb
            if (r2 == 0) goto L_0x0087
            boolean r2 = r1 instanceof com.google.android.gms.internal.p010firebaseperf.zzfp
            if (r2 == 0) goto L_0x0087
            r2 = r1
            com.google.android.gms.internal.firebase-perf.zzfp r2 = (com.google.android.gms.internal.p010firebaseperf.zzfp) r2
            boolean r3 = r2.zzgj()
            if (r3 != 0) goto L_0x0087
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.firebase-perf.zzfp r0 = r2.zzao(r1)
            com.google.android.gms.internal.p010firebaseperf.zzig.zza((java.lang.Object) r5, (long) r7, (java.lang.Object) r0)
            r1 = r0
        L_0x0087:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x0096
            if (r2 <= 0) goto L_0x0096
            r1.addAll(r6)
        L_0x0096:
            if (r0 <= 0) goto L_0x0099
            r6 = r1
        L_0x0099:
            com.google.android.gms.internal.p010firebaseperf.zzig.zza((java.lang.Object) r5, (long) r7, (java.lang.Object) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzge.zza(java.lang.Object, java.lang.Object, long):void");
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzig.zzo(obj, j);
    }
}

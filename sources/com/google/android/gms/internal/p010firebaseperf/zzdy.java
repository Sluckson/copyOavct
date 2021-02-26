package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzdy;
import com.google.android.gms.internal.p010firebaseperf.zzdz;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdy */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzdy<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzdy<MessageType, BuilderType>> implements zzgr {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzgd */
    public abstract BuilderType clone();

    public final /* synthetic */ zzgr zza(zzgs zzgs) {
        if (zzhn().getClass().isInstance(zzgs)) {
            return zza((zzdz) zzgs);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}

package com.google.android.gms.internal.p010firebaseperf;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfv */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzfv<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzft> zzsa;

    private zzfv(Map.Entry<K, zzft> entry) {
        this.zzsa = entry;
    }

    public final K getKey() {
        return this.zzsa.getKey();
    }

    public final Object getValue() {
        if (this.zzsa.getValue() == null) {
            return null;
        }
        return zzft.zzhu();
    }

    public final zzft zzhw() {
        return this.zzsa.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzgs) {
            return this.zzsa.getValue().zzh((zzgs) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}

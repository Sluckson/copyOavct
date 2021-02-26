package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzij<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzih> zza;

    private zzij(Map.Entry<K, zzih> entry) {
        this.zza = entry;
    }

    public final K getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzih.zza();
    }

    public final zzih zza() {
        return this.zza.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzjg) {
            return this.zza.getValue().zza((zzjg) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}

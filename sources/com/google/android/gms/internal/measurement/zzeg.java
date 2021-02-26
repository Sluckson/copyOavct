package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
abstract class zzeg<K, V> implements zzfj<K, V> {
    @NullableDecl
    private transient Map<K, Collection<V>> zza;

    zzeg() {
    }

    /* access modifiers changed from: package-private */
    public abstract Map<K, Collection<V>> zzb();

    public boolean zza(@NullableDecl Object obj) {
        for (Collection contains : zza().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Map<K, Collection<V>> zza() {
        Map<K, Collection<V>> map = this.zza;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> zzb = zzb();
        this.zza = zzb;
        return zzb;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfj) {
            return zza().equals(((zzfj) obj).zza());
        }
        return false;
    }

    public int hashCode() {
        return zza().hashCode();
    }

    public String toString() {
        return zza().toString();
    }
}

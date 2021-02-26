package com.google.android.gms.internal.p010firebaseperf;

import com.lowagie.text.ElementTags;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzo */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzo<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzg = new Map.Entry[0];
    private transient zzn<Map.Entry<K, V>> zzh;
    private transient zzn<K> zzi;
    private transient zzk<V> zzj;

    public static <K, V> zzo<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        zzi.zza(k, v);
        zzi.zza(k2, v2);
        zzi.zza(k3, v3);
        zzi.zza(k4, v4);
        return zzp.zza(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzn<Map.Entry<K, V>> zzi();

    /* access modifiers changed from: package-private */
    public abstract zzn<K> zzj();

    /* access modifiers changed from: package-private */
    public abstract zzk<V> zzk();

    zzo() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzk) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return zzw.zza((zzn) entrySet());
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                z = false;
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            sb.append('}');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(ElementTags.SIZE.length() + 40);
        sb2.append(ElementTags.SIZE);
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public /* synthetic */ Set entrySet() {
        zzn<Map.Entry<K, V>> zzn = this.zzh;
        if (zzn != null) {
            return zzn;
        }
        zzn<Map.Entry<K, V>> zzi2 = zzi();
        this.zzh = zzi2;
        return zzi2;
    }

    public /* synthetic */ Collection values() {
        zzk<V> zzk = this.zzj;
        if (zzk != null) {
            return zzk;
        }
        zzk<V> zzk2 = zzk();
        this.zzj = zzk2;
        return zzk2;
    }

    public /* synthetic */ Set keySet() {
        zzn<K> zzn = this.zzi;
        if (zzn != null) {
            return zzn;
        }
        zzn<K> zzj2 = zzj();
        this.zzi = zzj2;
        return zzj2;
    }
}

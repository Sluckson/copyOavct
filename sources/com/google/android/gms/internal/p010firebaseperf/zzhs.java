package com.google.android.gms.internal.p010firebaseperf;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhs */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhs implements Comparable<zzhs>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzhj zzup;
    private final K zzut;

    zzhs(zzhj zzhj, Map.Entry<K, V> entry) {
        this(zzhj, (Comparable) entry.getKey(), entry.getValue());
    }

    zzhs(zzhj zzhj, K k, V v) {
        this.zzup = zzhj;
        this.zzut = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzup.zziw();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzut, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        K k = this.zzut;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzut);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.zzut;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzhs) obj).getKey());
    }
}

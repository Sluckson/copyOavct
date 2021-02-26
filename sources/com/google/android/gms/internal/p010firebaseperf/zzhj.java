package com.google.android.gms.internal.p010firebaseperf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhj */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
class zzhj<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zznw;
    private final int zzue;
    /* access modifiers changed from: private */
    public List<zzhs> zzuf;
    /* access modifiers changed from: private */
    public Map<K, V> zzug;
    private volatile zzhu zzuh;
    /* access modifiers changed from: private */
    public Map<K, V> zzui;
    private volatile zzho zzuj;

    static <FieldDescriptorType extends zzfc<FieldDescriptorType>> zzhj<FieldDescriptorType, Object> zzat(int i) {
        return new zzhm(i);
    }

    private zzhj(int i) {
        this.zzue = i;
        this.zzuf = Collections.emptyList();
        this.zzug = Collections.emptyMap();
        this.zzui = Collections.emptyMap();
    }

    public void zzgk() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zznw) {
            if (this.zzug.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzug);
            }
            this.zzug = map;
            if (this.zzui.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzui);
            }
            this.zzui = map2;
            this.zznw = true;
        }
    }

    public final boolean isImmutable() {
        return this.zznw;
    }

    public final int zzit() {
        return this.zzuf.size();
    }

    public final Map.Entry<K, V> zzau(int i) {
        return this.zzuf.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zziu() {
        if (this.zzug.isEmpty()) {
            return zzhn.zzje();
        }
        return this.zzug.entrySet();
    }

    public int size() {
        return this.zzuf.size() + this.zzug.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzug.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzuf.get(zza).getValue();
        }
        return this.zzug.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zziw();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzuf.get(zza).setValue(v);
        }
        zziw();
        if (this.zzuf.isEmpty() && !(this.zzuf instanceof ArrayList)) {
            this.zzuf = new ArrayList(this.zzue);
        }
        int i = -(zza + 1);
        if (i >= this.zzue) {
            return zzix().put(k, v);
        }
        int size = this.zzuf.size();
        int i2 = this.zzue;
        if (size == i2) {
            zzhs remove = this.zzuf.remove(i2 - 1);
            zzix().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzuf.add(i, new zzhs(this, k, v));
        return null;
    }

    public void clear() {
        zziw();
        if (!this.zzuf.isEmpty()) {
            this.zzuf.clear();
        }
        if (!this.zzug.isEmpty()) {
            this.zzug.clear();
        }
    }

    public V remove(Object obj) {
        zziw();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzav(zza);
        }
        if (this.zzug.isEmpty()) {
            return null;
        }
        return this.zzug.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzav(int i) {
        zziw();
        V value = this.zzuf.remove(i).getValue();
        if (!this.zzug.isEmpty()) {
            Iterator it = zzix().entrySet().iterator();
            this.zzuf.add(new zzhs(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzuf.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzuf.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzuf.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzuh == null) {
            this.zzuh = new zzhu(this, (zzhm) null);
        }
        return this.zzuh;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zziv() {
        if (this.zzuj == null) {
            this.zzuj = new zzho(this, (zzhm) null);
        }
        return this.zzuj;
    }

    /* access modifiers changed from: private */
    public final void zziw() {
        if (this.zznw) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzix() {
        zziw();
        if (this.zzug.isEmpty() && !(this.zzug instanceof TreeMap)) {
            this.zzug = new TreeMap();
            this.zzui = ((TreeMap) this.zzug).descendingMap();
        }
        return (SortedMap) this.zzug;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhj)) {
            return super.equals(obj);
        }
        zzhj zzhj = (zzhj) obj;
        int size = size();
        if (size != zzhj.size()) {
            return false;
        }
        int zzit = zzit();
        if (zzit != zzhj.zzit()) {
            return entrySet().equals(zzhj.entrySet());
        }
        for (int i = 0; i < zzit; i++) {
            if (!zzau(i).equals(zzhj.zzau(i))) {
                return false;
            }
        }
        if (zzit != size) {
            return this.zzug.equals(zzhj.zzug);
        }
        return true;
    }

    public int hashCode() {
        int zzit = zzit();
        int i = 0;
        for (int i2 = 0; i2 < zzit; i2++) {
            i += this.zzuf.get(i2).hashCode();
        }
        return this.zzug.size() > 0 ? i + this.zzug.hashCode() : i;
    }

    /* synthetic */ zzhj(int i, zzhm zzhm) {
        this(i);
    }
}

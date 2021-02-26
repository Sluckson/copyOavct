package com.google.android.gms.internal.p010firebaseperf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzga */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzga extends zzed<String> implements zzfz, RandomAccess {
    private static final zzga zzsf;
    private static final zzfz zzsg = zzsf;
    private final List<Object> zzsh;

    public zzga() {
        this(10);
    }

    public zzga(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzga(ArrayList<Object> arrayList) {
        this.zzsh = arrayList;
    }

    public final int size() {
        return this.zzsh.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzgl();
        if (collection instanceof zzfz) {
            collection = ((zzfz) collection).zzhx();
        }
        boolean addAll = this.zzsh.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzgl();
        this.zzsh.clear();
        this.modCount++;
    }

    public final void zzc(zzee zzee) {
        zzgl();
        this.zzsh.add(zzee);
        this.modCount++;
    }

    public final Object getRaw(int i) {
        return this.zzsh.get(i);
    }

    private static String zzh(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzee) {
            return ((zzee) obj).zzgm();
        }
        return zzfj.zzd((byte[]) obj);
    }

    public final List<?> zzhx() {
        return Collections.unmodifiableList(this.zzsh);
    }

    public final zzfz zzhy() {
        return zzgj() ? new zzib(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzgl();
        return zzh(this.zzsh.set(i, (String) obj));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzgl();
        Object remove = this.zzsh.remove(i);
        this.modCount++;
        return zzh(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzgj() {
        return super.zzgj();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzgl();
        this.zzsh.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzfp zzao(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzsh);
            return new zzga((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzsh.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzee) {
            zzee zzee = (zzee) obj;
            String zzgm = zzee.zzgm();
            if (zzee.zzgn()) {
                this.zzsh.set(i, zzgm);
            }
            return zzgm;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzfj.zzd(bArr);
        if (zzfj.zzc(bArr)) {
            this.zzsh.set(i, zzd);
        }
        return zzd;
    }

    static {
        zzga zzga = new zzga();
        zzsf = zzga;
        zzga.zzgk();
    }
}

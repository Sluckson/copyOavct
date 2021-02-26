package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzdy;
import com.google.android.gms.internal.p010firebaseperf.zzdz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdz */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzdz<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzdy<MessageType, BuilderType>> implements zzgs {
    protected int zzmu = 0;

    public final zzee zzge() {
        try {
            zzem zzs = zzee.zzs(getSerializedSize());
            writeTo(zzs.zzgr());
            return zzs.zzgq();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            zzev zza = zzev.zza(bArr);
            writeTo(zza);
            zza.zzgu();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzgf() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzp(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfj.checkNotNull(iterable);
        if (iterable instanceof zzfz) {
            List<?> zzhx = ((zzfz) iterable).zzhx();
            zzfz zzfz = (zzfz) list;
            int size = list.size();
            for (Object next : zzhx) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzfz.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzfz.size() - 1; size2 >= size; size2--) {
                        zzfz.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzee) {
                    zzfz.zzc((zzee) next);
                } else {
                    zzfz.add((String) next);
                }
            }
        } else if (iterable instanceof zzhb) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}

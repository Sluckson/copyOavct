package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
public abstract class zzgd<MessageType extends zzgd<MessageType, BuilderType>, BuilderType extends zzgf<MessageType, BuilderType>> implements zzjg {
    protected int zza = 0;

    public final zzgm zzbj() {
        try {
            zzgu zzc = zzgm.zzc(zzbp());
            zza(zzc.zzb());
            return zzc.zza();
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

    public final byte[] zzbk() {
        try {
            byte[] bArr = new byte[zzbp()];
            zzhf zza2 = zzhf.zza(bArr);
            zza(zza2);
            zza2.zzb();
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
    public int zzbl() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzhx.zza(iterable);
        if (iterable instanceof zzin) {
            List<?> zzb = ((zzin) iterable).zzb();
            zzin zzin = (zzin) list;
            int size = list.size();
            for (Object next : zzb) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzin.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzin.size() - 1; size2 >= size; size2--) {
                        zzin.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzgm) {
                    zzin.zza((zzgm) next);
                } else {
                    zzin.add((String) next);
                }
            }
        } else if (iterable instanceof zzjs) {
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

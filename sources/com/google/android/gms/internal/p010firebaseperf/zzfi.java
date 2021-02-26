package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;
import com.google.android.gms.internal.p010firebaseperf.zzfi.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfi */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzfi<MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdz<MessageType, BuilderType> {
    private static Map<Object, zzfi<?, ?>> zzqx = new ConcurrentHashMap();
    protected zzhz zzqv = zzhz.zzjg();
    private int zzqw = -1;

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzfi$zzb */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzfi<MessageType, BuilderType> implements zzgu {
        protected zzfa<zze> zzqy = zzfa.zzgy();
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzfi$zzc */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static class zzc<T extends zzfi<T, ?>> extends zzea<T> {
        private final T zzqs;

        public zzc(T t) {
            this.zzqs = t;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzfi$zzd */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public enum zzd {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzfi$zze */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static final class zze implements zzfc<zze> {
        public final int getNumber() {
            throw new NoSuchMethodError();
        }

        public final zzio zzhd() {
            throw new NoSuchMethodError();
        }

        public final zzir zzhe() {
            throw new NoSuchMethodError();
        }

        public final boolean zzhf() {
            throw new NoSuchMethodError();
        }

        public final boolean zzhg() {
            throw new NoSuchMethodError();
        }

        public final zzgr zza(zzgr zzgr, zzgs zzgs) {
            throw new NoSuchMethodError();
        }

        public final zzgy zza(zzgy zzgy, zzgy zzgy2) {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object dynamicMethod(zzd zzd2, Object obj, Object obj2);

    public String toString() {
        return zzgt.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzmu != 0) {
            return this.zzmu;
        }
        this.zzmu = zzhd.zzip().zzo(this).hashCode(this);
        return this.zzmu;
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzfi$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static abstract class zza<MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdy<MessageType, BuilderType> {
        private final MessageType zzqs;
        protected MessageType zzqt;
        protected boolean zzqu = false;

        protected zza(MessageType messagetype) {
            this.zzqs = messagetype;
            this.zzqt = (zzfi) messagetype.dynamicMethod(zzd.NEW_MUTABLE_INSTANCE, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void zzhi() {
            MessageType messagetype = (zzfi) this.zzqt.dynamicMethod(zzd.NEW_MUTABLE_INSTANCE, (Object) null, (Object) null);
            zza(messagetype, this.zzqt);
            this.zzqt = messagetype;
        }

        public final boolean isInitialized() {
            return zzfi.zza(this.zzqt, false);
        }

        /* renamed from: zzhj */
        public MessageType zzhl() {
            if (this.zzqu) {
                return this.zzqt;
            }
            MessageType messagetype = this.zzqt;
            zzhd.zzip().zzo(messagetype).zzf(messagetype);
            this.zzqu = true;
            return this.zzqt;
        }

        /* renamed from: zzhk */
        public final MessageType zzhm() {
            MessageType messagetype = (zzfi) zzhl();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzhx(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            zza(this.zzqt, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzhd.zzip().zzo(messagetype).zzd(messagetype, messagetype2);
        }

        public final /* synthetic */ zzdy zzgd() {
            return (zza) clone();
        }

        public final /* synthetic */ zzgs zzhn() {
            return this.zzqs;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzfi) this.zzqs).dynamicMethod(zzd.NEW_BUILDER, (Object) null, (Object) null);
            zza.zza((zzfi) zzhl());
            return zza;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzhd.zzip().zzo(this).equals(this, (zzfi) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzho() {
        return (zza) dynamicMethod(zzd.NEW_BUILDER, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int zzgf() {
        return this.zzqw;
    }

    /* access modifiers changed from: package-private */
    public final void zzp(int i) {
        this.zzqw = i;
    }

    public void writeTo(zzev zzev) throws IOException {
        zzhd.zzip().zzo(this).zza(this, zzex.zza(zzev));
    }

    public int getSerializedSize() {
        if (this.zzqw == -1) {
            this.zzqw = zzhd.zzip().zzo(this).zzn(this);
        }
        return this.zzqw;
    }

    static <T extends zzfi<?, ?>> T zzc(Class<T> cls) {
        T t = (zzfi) zzqx.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzfi) zzqx.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzfi) ((zzfi) zzig.zzg(cls)).dynamicMethod(zzd.GET_DEFAULT_INSTANCE, (Object) null, (Object) null);
            if (t != null) {
                zzqx.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzfi<?, ?>> void zza(Class<T> cls, T t) {
        zzqx.put(cls, t);
    }

    protected static Object zza(zzgs zzgs, String str, Object[] objArr) {
        return new zzhf(zzgs, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzfi<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(zzd.GET_MEMOIZED_IS_INITIALIZED, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzm = zzhd.zzip().zzo(t).zzm(t);
        if (z) {
            t.dynamicMethod(zzd.SET_MEMOIZED_IS_INITIALIZED, zzm ? t : null, (Object) null);
        }
        return zzm;
    }

    protected static zzfn zzhp() {
        return zzfk.zzhs();
    }

    protected static <E> zzfp<E> zzhq() {
        return zzhg.zzis();
    }

    protected static <E> zzfp<E> zza(zzfp<E> zzfp) {
        int size = zzfp.size();
        return zzfp.zzao(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzgr zzhr() {
        zza zza2 = (zza) dynamicMethod(zzd.NEW_BUILDER, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzgs zzhn() {
        return (zzfi) dynamicMethod(zzd.GET_DEFAULT_INSTANCE, (Object) null, (Object) null);
    }
}

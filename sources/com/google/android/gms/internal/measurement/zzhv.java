package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhv.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
public abstract class zzhv<MessageType extends zzhv<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgd<MessageType, BuilderType> {
    private static Map<Object, zzhv<?, ?>> zzd = new ConcurrentHashMap();
    protected zzkq zzb = zzkq.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
    public static class zza<T extends zzhv<T, ?>> extends zzgh<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
    static final class zzc implements zzhq<zzc> {
        public final int zza() {
            throw new NoSuchMethodError();
        }

        public final zzle zzb() {
            throw new NoSuchMethodError();
        }

        public final zzlh zzc() {
            throw new NoSuchMethodError();
        }

        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        public final zzjf zza(zzjf zzjf, zzjg zzjg) {
            throw new NoSuchMethodError();
        }

        public final zzjl zza(zzjl zzjl, zzjl zzjl2) {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {zza, zzb, zzc, zzd, zze, zzf, zzg};
        private static final /* synthetic */ int[] zzm = {zzh, zzi};
        private static final /* synthetic */ int[] zzn = {zzj, zzk};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
    public static class zzf<ContainingType extends zzjg, Type> extends zzhj<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzhv<MessageType, BuilderType> implements zzji {
        protected zzho<zzc> zzc = zzho.zza();

        /* access modifiers changed from: package-private */
        public final zzho<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzho) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzjh.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzjr.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
    public static abstract class zzb<MessageType extends zzhv<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgf<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (zzhv) messagetype.zza(zze.zzd, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void zzu() {
            MessageType messagetype = (zzhv) this.zza.zza(zze.zzd, (Object) null, (Object) null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        public final boolean zzbn() {
            return zzhv.zza(this.zza, false);
        }

        /* renamed from: zzv */
        public MessageType zzx() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzjr.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zzw */
        public final MessageType zzy() {
            MessageType messagetype = (zzhv) zzx();
            if (messagetype.zzbn()) {
                return messagetype;
            }
            throw new zzko(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjr.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzhi zzhi) throws zzig {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            try {
                zzjr.zza().zza(this.zza).zza(this.zza, bArr, 0, i2, new zzgl(zzhi));
                return this;
            } catch (zzig e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzig.zza();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzgy zzgy, zzhi zzhi) throws IOException {
            if (this.zzb) {
                zzu();
                this.zzb = false;
            }
            try {
                zzjr.zza().zza(this.zza).zza(this.zza, zzhd.zza(zzgy), zzhi);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzgf zza(byte[] bArr, int i, int i2, zzhi zzhi) throws zzig {
            return zzb(bArr, 0, i2, zzhi);
        }

        public final /* synthetic */ zzgf zza(byte[] bArr, int i, int i2) throws zzig {
            return zzb(bArr, 0, i2, zzhi.zza());
        }

        public final /* synthetic */ zzgf zzt() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzjg zzbv() {
            return this.zzc;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) ((zzhv) this.zzc).zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza((zzhv) zzx());
            return zzb2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzjr.zza().zza(this).zza(this, (zzhv) obj);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzhv<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbm() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final boolean zzbn() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbo() {
        BuilderType buildertype = (zzb) zza(zze.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public final int zzbl() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i) {
        this.zzc = i;
    }

    public final void zza(zzhf zzhf) throws IOException {
        zzjr.zza().zza(this).zza(this, (zzlk) zzhh.zza(zzhf));
    }

    public final int zzbp() {
        if (this.zzc == -1) {
            this.zzc = zzjr.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzhv<?, ?>> T zza(Class<T> cls) {
        T t = (zzhv) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzhv) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzhv) ((zzhv) zzkt.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzhv<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzjg zzjg, String str, Object[] objArr) {
        return new zzjt(zzjg, str, objArr);
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

    protected static final <T extends zzhv<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzjr.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }

    protected static zzib zzbq() {
        return zzhy.zzd();
    }

    protected static zzie zzbr() {
        return zziu.zzd();
    }

    protected static zzie zza(zzie zzie) {
        int size = zzie.size();
        return zzie.zzc(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzid<E> zzbs() {
        return zzju.zzd();
    }

    protected static <E> zzid<E> zza(zzid<E> zzid) {
        int size = zzid.size();
        return zzid.zza(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzjf zzbt() {
        zzb zzb2 = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzjf zzbu() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzjg zzbv() {
        return (zzhv) zza(zze.zzf, (Object) null, (Object) null);
    }
}

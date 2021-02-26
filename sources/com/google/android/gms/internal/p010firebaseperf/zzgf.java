package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgf */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzgf implements zzhh {
    private static final zzgp zzsm = new zzgi();
    private final zzgp zzsl;

    public zzgf() {
        this(new zzgh(zzfg.zzhh(), zzib()));
    }

    private zzgf(zzgp zzgp) {
        this.zzsl = (zzgp) zzfj.checkNotNull(zzgp, "messageInfoFactory");
    }

    public final <T> zzhi<T> zzd(Class<T> cls) {
        zzhk.zzf((Class<?>) cls);
        zzgq zzb = this.zzsl.zzb(cls);
        if (zzb.zzik()) {
            if (zzfi.class.isAssignableFrom(cls)) {
                return zzgv.zza(zzhk.zzja(), zzfb.zzhb(), zzb.zzil());
            }
            return zzgv.zza(zzhk.zziy(), zzfb.zzhc(), zzb.zzil());
        } else if (zzfi.class.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzgw.zza(cls, zzb, zzgz.zzin(), zzgc.zzia(), zzhk.zzja(), zzfb.zzhb(), zzgn.zzih());
            }
            return zzgw.zza(cls, zzb, zzgz.zzin(), zzgc.zzia(), zzhk.zzja(), (zzez<?>) null, zzgn.zzih());
        } else if (zza(zzb)) {
            return zzgw.zza(cls, zzb, zzgz.zzim(), zzgc.zzhz(), zzhk.zziy(), zzfb.zzhc(), zzgn.zzig());
        } else {
            return zzgw.zza(cls, zzb, zzgz.zzim(), zzgc.zzhz(), zzhk.zziz(), (zzez<?>) null, zzgn.zzig());
        }
    }

    private static boolean zza(zzgq zzgq) {
        return zzgq.zzij() == zzhe.zztx;
    }

    private static zzgp zzib() {
        try {
            return (zzgp) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzsm;
        }
    }
}

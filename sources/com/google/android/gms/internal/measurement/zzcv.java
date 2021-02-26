package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final /* synthetic */ class zzcv {
    public static <V> V zza(zzcu<V> zzcu) {
        long clearCallingIdentity;
        try {
            return zzcu.zza();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zza = zzcu.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zza;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}

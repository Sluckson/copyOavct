package com.google.android.gms.measurement.module;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zzgb;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzhb;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public class Analytics {
    @ShowFirstParty
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";
    @ShowFirstParty
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";
    @ShowFirstParty
    @KeepForSdk
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile Analytics zza;
    private final zzgb zzb;

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
    public static final class Event extends zzgy {
        @ShowFirstParty
        @KeepForSdk
        public static final String AD_REWARD = "_ar";
        @ShowFirstParty
        @KeepForSdk
        public static final String APP_EXCEPTION = "_ae";

        private Event() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
    public static final class Param extends zzhb {
        @ShowFirstParty
        @KeepForSdk
        public static final String FATAL = "fatal";
        @ShowFirstParty
        @KeepForSdk
        public static final String TIMESTAMP = "timestamp";
        @ShowFirstParty
        @KeepForSdk
        public static final String TYPE = "type";

        private Param() {
        }
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @ShowFirstParty
    @Keep
    public static Analytics getInstance(Context context) {
        if (zza == null) {
            synchronized (Analytics.class) {
                if (zza == null) {
                    zza = new Analytics(zzgb.zza(context, (zzae) null, (Long) null));
                }
            }
        }
        return zza;
    }

    private Analytics(zzgb zzgb) {
        Preconditions.checkNotNull(zzgb);
        this.zzb = zzgb;
    }
}

package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class InstantApps {
    private static Context zzik;
    private static Boolean zzil;

    @KeepForSdk
    public static synchronized boolean isInstantApp(Context context) {
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzik == null || zzil == null || zzik != applicationContext) {
                zzil = null;
                if (PlatformVersion.isAtLeastO()) {
                    zzil = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzil = true;
                    } catch (ClassNotFoundException unused) {
                        zzil = false;
                    }
                }
                zzik = applicationContext;
                boolean booleanValue = zzil.booleanValue();
                return booleanValue;
            }
            boolean booleanValue2 = zzil.booleanValue();
            return booleanValue2;
        }
    }
}

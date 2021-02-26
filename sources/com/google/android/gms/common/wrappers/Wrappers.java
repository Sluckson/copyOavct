package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class Wrappers {
    private static Wrappers zzio = new Wrappers();
    private PackageManagerWrapper zzin = null;

    @VisibleForTesting
    private final synchronized PackageManagerWrapper zzk(Context context) {
        if (this.zzin == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzin = new PackageManagerWrapper(context);
        }
        return this.zzin;
    }

    @KeepForSdk
    public static PackageManagerWrapper packageManager(Context context) {
        return zzio.zzk(context);
    }
}

package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zzdo = new Object();
    private static ClassLoader zzdp = null;
    private static Integer zzdq = null;
    private boolean zzdr = false;

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract boolean prepareForClientVersion(int i);

    private static ClassLoader zzp() {
        synchronized (zzdo) {
        }
        return null;
    }

    @KeepForSdk
    protected static Integer getUnparcelClientVersion() {
        synchronized (zzdo) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean shouldDowngrade() {
        return this.zzdr;
    }

    @KeepForSdk
    public void setShouldDowngrade(boolean z) {
        this.zzdr = z;
    }

    @KeepForSdk
    protected static boolean canUnparcelSafely(String str) {
        zzp();
        return true;
    }
}

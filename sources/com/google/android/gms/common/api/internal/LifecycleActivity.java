package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class LifecycleActivity {
    private final Object zzbk;

    public LifecycleActivity(Activity activity) {
        this.zzbk = Preconditions.checkNotNull(activity, "Activity must not be null");
    }

    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    @KeepForSdk
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean isSupport() {
        return this.zzbk instanceof FragmentActivity;
    }

    public final boolean zzh() {
        return this.zzbk instanceof Activity;
    }

    @NonNull
    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.zzbk;
    }

    @NonNull
    @KeepForSdk
    public FragmentActivity asFragmentActivity() {
        return (FragmentActivity) this.zzbk;
    }

    @NonNull
    @KeepForSdk
    public Object asObject() {
        return this.zzbk;
    }
}

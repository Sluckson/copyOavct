package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final BackgroundDetector zzbf = new BackgroundDetector();
    private final AtomicBoolean zzbg = new AtomicBoolean();
    private final AtomicBoolean zzbh = new AtomicBoolean();
    @GuardedBy("sInstance")
    private final ArrayList<BackgroundStateChangeListener> zzbi = new ArrayList<>();
    @GuardedBy("sInstance")
    private boolean zzbj = false;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return zzbf;
    }

    @KeepForSdk
    public static void initialize(Application application) {
        synchronized (zzbf) {
            if (!zzbf.zzbj) {
                application.registerActivityLifecycleCallbacks(zzbf);
                application.registerComponentCallbacks(zzbf);
                zzbf.zzbj = true;
            }
        }
    }

    @TargetApi(16)
    @KeepForSdk
    public final boolean readCurrentStateIfPossible(boolean z) {
        if (!this.zzbh.get()) {
            if (!PlatformVersion.isAtLeastJellyBean()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.zzbh.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.zzbg.set(true);
            }
        }
        return isInBackground();
    }

    @KeepForSdk
    public final boolean isInBackground() {
        return this.zzbg.get();
    }

    @KeepForSdk
    public final void addListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (zzbf) {
            this.zzbi.add(backgroundStateChangeListener);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.zzbg.compareAndSet(true, false);
        this.zzbh.set(true);
        if (compareAndSet) {
            onBackgroundStateChanged(false);
        }
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.zzbg.compareAndSet(true, false);
        this.zzbh.set(true);
        if (compareAndSet) {
            onBackgroundStateChanged(false);
        }
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.zzbg.compareAndSet(false, true)) {
            this.zzbh.set(true);
            onBackgroundStateChanged(true);
        }
    }

    private final void onBackgroundStateChanged(boolean z) {
        synchronized (zzbf) {
            ArrayList arrayList = this.zzbi;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((BackgroundStateChangeListener) obj).onBackgroundStateChanged(z);
            }
        }
    }
}

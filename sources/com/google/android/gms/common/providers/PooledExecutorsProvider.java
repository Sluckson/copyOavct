package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zzfk;

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public interface PooledExecutorFactory {
        @KeepForSdk
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    @KeepForSdk
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (zzfk == null) {
                zzfk = new zza();
            }
            pooledExecutorFactory = zzfk;
        }
        return pooledExecutorFactory;
    }

    private PooledExecutorsProvider() {
    }
}

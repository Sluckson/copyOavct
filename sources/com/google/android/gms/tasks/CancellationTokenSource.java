package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
public class CancellationTokenSource {
    private final zza zza = new zza();

    @NonNull
    public CancellationToken getToken() {
        return this.zza;
    }

    public void cancel() {
        this.zza.zza();
    }
}

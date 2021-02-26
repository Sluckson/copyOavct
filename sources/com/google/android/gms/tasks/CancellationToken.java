package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    @NonNull
    public abstract CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener onTokenCanceledListener);
}

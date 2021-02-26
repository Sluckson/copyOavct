package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(@NonNull Task<TResult> task) throws Exception;
}

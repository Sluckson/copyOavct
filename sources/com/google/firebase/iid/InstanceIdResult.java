package com.google.firebase.iid;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
public interface InstanceIdResult {
    @NonNull
    String getId();

    @NonNull
    String getToken();
}

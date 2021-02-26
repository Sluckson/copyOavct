package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public interface FirebaseRemoteConfigInfo {
    @NonNull
    FirebaseRemoteConfigSettings getConfigSettings();

    long getFetchTimeMillis();

    int getLastFetchStatus();
}

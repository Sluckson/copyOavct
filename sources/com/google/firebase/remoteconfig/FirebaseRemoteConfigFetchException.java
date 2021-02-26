package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class FirebaseRemoteConfigFetchException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigFetchException(@NonNull String str) {
        super(str);
    }

    public FirebaseRemoteConfigFetchException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
    }
}

package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class FirebaseRemoteConfigClientException extends FirebaseRemoteConfigException {
    public FirebaseRemoteConfigClientException(@NonNull String str) {
        super(str);
    }

    public FirebaseRemoteConfigClientException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
    }
}

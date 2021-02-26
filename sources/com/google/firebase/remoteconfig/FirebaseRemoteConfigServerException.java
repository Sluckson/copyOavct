package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    private final int httpStatusCode;

    public FirebaseRemoteConfigServerException(int i, @NonNull String str) {
        super(str);
        this.httpStatusCode = i;
    }

    public FirebaseRemoteConfigServerException(int i, @NonNull String str, @Nullable Throwable th) {
        super(str, th);
        this.httpStatusCode = i;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}

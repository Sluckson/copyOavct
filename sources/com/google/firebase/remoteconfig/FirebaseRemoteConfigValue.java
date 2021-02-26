package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public interface FirebaseRemoteConfigValue {
    boolean asBoolean() throws IllegalArgumentException;

    @NonNull
    byte[] asByteArray();

    double asDouble() throws IllegalArgumentException;

    long asLong() throws IllegalArgumentException;

    @NonNull
    String asString();

    int getSource();
}

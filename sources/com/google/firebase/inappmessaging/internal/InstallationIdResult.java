package com.google.firebase.inappmessaging.internal;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.InstallationTokenResult;

@AutoValue
public abstract class InstallationIdResult {
    /* access modifiers changed from: package-private */
    public abstract String installationId();

    /* access modifiers changed from: package-private */
    public abstract InstallationTokenResult installationTokenResult();

    public static InstallationIdResult create(String str, InstallationTokenResult installationTokenResult) {
        return new AutoValue_InstallationIdResult(str, installationTokenResult);
    }
}

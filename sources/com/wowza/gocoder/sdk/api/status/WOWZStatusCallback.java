package com.wowza.gocoder.sdk.api.status;

/* compiled from: GoCoderSDK */
public interface WOWZStatusCallback {
    void onWZError(WOWZStatus wOWZStatus);

    void onWZStatus(WOWZStatus wOWZStatus);
}

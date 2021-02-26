package com.wowza.gocoder.sdk.api.data;

/* compiled from: GoCoderSDK */
public class WOWZDataEvent {

    /* compiled from: GoCoderSDK */
    public interface EventListener {
        WOWZDataMap onWZDataEvent(String str, WOWZDataMap wOWZDataMap);
    }

    /* compiled from: GoCoderSDK */
    public interface ResultCallback {
        void onWZDataEventResult(WOWZDataMap wOWZDataMap, boolean z);
    }
}

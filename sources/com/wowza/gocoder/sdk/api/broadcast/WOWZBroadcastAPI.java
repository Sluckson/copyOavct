package com.wowza.gocoder.sdk.api.broadcast;

import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.monitor.WOWZStreamingStat;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;

/* compiled from: GoCoderSDK */
public final class WOWZBroadcastAPI {

    /* compiled from: GoCoderSDK */
    public interface AdaptiveBroadcaster {
        void changeAdaptiveBitrate(int i);

        void changeAdaptiveFramerate(int i);

        int getAdaptiveBitrate();

        int getAdaptiveFramerate();
    }

    /* compiled from: GoCoderSDK */
    public interface AdaptiveChangeListener {
        int adaptiveBitRateChange(WOWZStreamingStat wOWZStreamingStat, int i);

        int adaptiveFrameRateChange(WOWZStreamingStat wOWZStreamingStat, int i);
    }

    /* compiled from: GoCoderSDK */
    public interface AudioBroadcaster extends Broadcaster {
        boolean isAudioEnabled();

        boolean isAudioPaused();

        void setAudioEnabled(boolean z);

        void setAudioPaused(boolean z);
    }

    /* compiled from: GoCoderSDK */
    public interface BroadcastErrorCallback {
        void onBroadcastError(WOWZError wOWZError);
    }

    /* compiled from: GoCoderSDK */
    public interface Broadcaster {
        WOWZBroadcastConfig getBroadcastConfig();

        WOWZStatus getBroadcasterStatus();

        WOWZStatus getStatus();

        WOWZStatus prepareForBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig);

        WOWZStatus startBroadcasting();

        WOWZStatus stopBroadcasting();
    }

    /* compiled from: GoCoderSDK */
    public interface VideoBroadcaster extends Broadcaster {
        WOWZMediaConfig getVideoSourceConfig();

        boolean isVideoEnabled();

        boolean isVideoPaused();

        void setVideoEnabled(boolean z);

        void setVideoPaused(boolean z);
    }
}

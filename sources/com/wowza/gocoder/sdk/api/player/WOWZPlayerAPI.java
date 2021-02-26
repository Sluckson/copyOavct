package com.wowza.gocoder.sdk.api.player;

/* compiled from: GoCoderSDK */
public class WOWZPlayerAPI {

    /* compiled from: GoCoderSDK */
    public interface WZAudioStreamReceiver {
        void onAudioSampleReceived(int i, long j, byte[] bArr);
    }

    /* compiled from: GoCoderSDK */
    public interface WZVideoStreamReceiver {
        void onEnhancedSeekEnd();

        void onEnhancedSeekStart();

        void onVideoFrameReceived(int i, long j, byte[] bArr, long j2);
    }
}

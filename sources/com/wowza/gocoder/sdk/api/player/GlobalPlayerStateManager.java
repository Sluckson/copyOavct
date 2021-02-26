package com.wowza.gocoder.sdk.api.player;

import com.wowza.gocoder.sdk.api.logging.WOWZLog;

/* compiled from: GoCoderSDK */
public class GlobalPlayerStateManager {
    public static int CONNECTION_STATE;
    public static int DECODER_AUDIO_STATE;
    public static int DECODER_VIDEO_STATE;

    public static void setAll(int i) {
        CONNECTION_STATE = i;
        DECODER_AUDIO_STATE = i;
        DECODER_VIDEO_STATE = i;
    }

    public static boolean isReady() {
        WOWZLog.debug("DECODER STATUS CONNECTION STATE: " + CONNECTION_STATE + ", DECODER AUDIO: " + DECODER_AUDIO_STATE + ", DECODER VIDEO: " + DECODER_VIDEO_STATE);
        return CONNECTION_STATE == 0 && DECODER_AUDIO_STATE == 0 && DECODER_VIDEO_STATE == 0;
    }
}

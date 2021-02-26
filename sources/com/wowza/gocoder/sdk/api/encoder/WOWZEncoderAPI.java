package com.wowza.gocoder.sdk.api.encoder;

import android.media.MediaCodecInfo;
import com.wowza.gocoder.sdk.api.codec.WOWZCodecUtils;
import com.wowza.gocoder.sdk.api.h264.WOWZProfileLevel;

/* compiled from: GoCoderSDK */
public class WOWZEncoderAPI {
    public static final String AAC_MIME_TYPE = "audio/mp4a-latm";
    public static final String H264_MIME_TYPE = "video/avc";

    public static MediaCodecInfo[] getEncodersForType(String str) {
        return WOWZCodecUtils.getEncodersForType(str);
    }

    public static int[] getProfiles() {
        return WOWZCodecUtils.getProfiles();
    }

    public static WOWZProfileLevel[] getProfileLevels() {
        return WOWZCodecUtils.getProfileLevels();
    }

    public static MediaCodecInfo.CodecProfileLevel WZProfileLevelToProfileLevel(WOWZProfileLevel wOWZProfileLevel) {
        return WOWZCodecUtils.WZProfileLevelToProfileLevel(wOWZProfileLevel);
    }

    public static WOWZProfileLevel ProfileLevelToWZProfileLevel(MediaCodecInfo.CodecProfileLevel codecProfileLevel) {
        return WOWZCodecUtils.ProfileLevelToWZProfileLevel(codecProfileLevel);
    }
}

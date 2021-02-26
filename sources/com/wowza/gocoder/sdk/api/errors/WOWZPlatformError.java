package com.wowza.gocoder.sdk.api.errors;

/* compiled from: GoCoderSDK */
public class WOWZPlatformError extends WOWZError {
    public static final int AUDIO_DECODER_CONFIGURATION_FAILURE = 84;
    public static final int AUDIO_DECODER_NOT_FOUND = 82;
    public static final int AUDIO_DECODER_NOT_RUNNING = 88;
    public static final int AUDIO_DECODER_START_FAILURE = 86;
    public static final int AUDIO_ENCODER_CONFIGURATION_FAILURE = 64;
    public static final int AUDIO_ENCODER_NOT_FOUND = 62;
    public static final int AUDIO_ENCODER_NOT_RUNNING = 87;
    public static final int AUDIO_ENCODER_START_FAILURE = 66;
    public static final int AUDIO_RECORDER_BUFFER_CONFIGURATION_FAILURE = 70;
    public static final int AUDIO_RECORDER_INITIALIZATION_FAILURE = 71;
    public static final int AUDIO_RECORDER_READ_FAILURE = 69;
    public static final int CAMERA_ACTIVATION_FAILURE = 52;
    public static final int CAMERA_AUTOFOCUS_FAILURE = 55;
    public static final int CAMERA_DISCOVERY_FAILURE = 50;
    public static final int CAMERA_INIT_FAILURE = 51;
    public static final int CAMERA_INTERROGATION_ERROR = 58;
    public static final int CAMERA_PREVIEW_SDK_INIT_FAILURE = 49;
    public static final int CAMERA_PREVIEW_TEXTURE_FAILURE = 57;
    public static final int CAMERA_RELEASE_FAILURE = 54;
    public static final int CAMERA_TEXTURE_NOT_SET = 56;
    public static final int CAMERA_TORCH_FAILURE = 53;
    public static final int DECODER_NOT_RUNNING = 90;
    public static final int DECODER_START_FAILURE = 91;
    public static final String ERROR_CLASS = "WOWZPlatformError";
    public static final int MP4_FILE_OPEN_OUTPUT_FAILURE = 59;
    public static final int MP4_FILE_PATH_NOT_SPECIFIED = 60;
    public static final int VIDEO_DECODER_CONFIGURATION_FAILURE = 83;
    public static final int VIDEO_DECODER_NOT_FOUND = 81;
    public static final int VIDEO_DECODER_NOT_RUNNING = 89;
    public static final int VIDEO_DECODER_START_FAILURE = 85;
    public static final int VIDEO_ENCODER_BITRATE_CHANGE_FAILURE = 67;
    public static final int VIDEO_ENCODER_CONFIGURATION_FAILURE = 63;
    public static final int VIDEO_ENCODER_NOT_FOUND = 61;
    public static final int VIDEO_ENCODER_NOT_RUNNING = 68;
    public static final int VIDEO_ENCODER_START_FAILURE = 65;

    public WOWZPlatformError(int i) {
        super(ERROR_CLASS, i);
    }

    public WOWZPlatformError(int i, boolean z) {
        super(ERROR_CLASS, i, z);
    }

    public WOWZPlatformError(int i, Exception exc) {
        super(ERROR_CLASS, i, exc);
    }
}

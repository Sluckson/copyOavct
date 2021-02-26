package com.wowza.gocoder.sdk.api.errors;

/* compiled from: GoCoderSDK */
public class WOWZSDKError extends WOWZError {
    public static final int CAPTURE_DEVICE_FAILED_TO_SHUTDOWN = 49;
    public static final int CAPTURE_DEVICE_FAILED_TO_START = 48;
    public static final int CAPTURE_DEVICE_FAILURE = 50;
    public static final int ENCODER_FAILED_TO_SHUTDOWN = 17;
    public static final int ENCODER_FAILED_TO_START = 16;
    public static final int ENCODING_FAIURE = 18;
    public static final String ERROR_CLASS = "WOWZSDKError";
    public static final int ERROR_MESSAGE_RESOURCE_FAILURE = 3;
    public static final int INVALID_SDK_LICENSE_KEY = 1;
    public static final int INVALID_SESSION_STATE = 64;
    public static final int LIBRARY_LOAD_FAILURE = 4;
    public static final int SDK_LICENSE_KEY_APP_ID_MISMATCH = 6;
    public static final int SDK_LICENSE_KEY_HAS_EXPIRED = 2;
    public static final int SDK_LICENSE_KEY_VERSION_MISMATCH = 5;
    public static final int SDK_NOT_INITIALZED_ERROR = 7;
    public static final int SINK_FAILED_TO_SHUTDOWN = 33;
    public static final int SINK_FAILED_TO_START = 32;
    public static final int SINK_FAILURE = 34;

    public WOWZSDKError(int i) {
        super(ERROR_CLASS, i);
    }

    public WOWZSDKError(int i, Exception exc) {
        super(ERROR_CLASS, i, exc);
    }
}

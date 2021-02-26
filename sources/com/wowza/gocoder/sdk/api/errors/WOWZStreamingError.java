package com.wowza.gocoder.sdk.api.errors;

/* compiled from: GoCoderSDK */
public class WOWZStreamingError extends WOWZError {
    public static final int AUDIO_SOURCE_NOT_SPECIFIED = 18;
    public static final int AUTHENTICATION_FAILED = 5;
    public static final int CONNECTION_FAILURE = 7;
    public static final int CONNECTION_IO_ERROR = 51;
    public static final int CONNECTION_MISC_ERROR = 52;
    public static final int CONNECTION_REFUSED = 60;
    public static final int CONNECTION_REJECTED = 6;
    public static final int CONNECTION_SECURITY_ERROR = 50;
    public static final int CONNECTION_TIMEOUT = 49;
    public static final int ENCODING_AUDIO_FRAME_FAILURE = 13;
    public static final int ENCODING_VIDEO_FRAME_FAILURE = 12;
    public static final String ERROR_CLASS = "WOWZStreamingError";
    public static final int INIT_STREAMING_SESSION_FAILED = 3;
    public static final int INVALID_APP_NAME = 10;
    public static final int INVALID_HOST_ADDRESS = 8;
    public static final int INVALID_PORT_NUMBER = 9;
    public static final int INVALID_SESSION_COMPONENT_STATE = 33;
    public static final int INVALID_STREAM_NAME = 11;
    public static final int MAX_RECONNECT_ATTEMPTS_ATTEMPTED = 4;
    public static final int OPEN_CONNECTION_FAILED = 1;
    public static final int SESSION_AUTH_REQUIRED = 57;
    public static final int SESSION_COMPONENT_TRANSITION_ERROR = 34;
    public static final int SESSION_INVALID_REDIRECT_URI = 58;
    public static final int SESSION_MISC_ERROR = 59;
    public static final int SESSION_READ_ERROR = 54;
    public static final int SESSION_WRITE_ERROR = 53;
    public static final int START_STREAMING_SESSION_FAILED = 2;
    public static final int STREAMING_AUDIO_FRAME_FAILURE = 15;
    public static final int STREAMING_DATA_FRAME_FAILURE = 65;
    public static final int STREAMING_VIDEO_FRAME_FAILURE = 14;
    public static final int STREAM_CREATION_ERROR = 55;
    public static final int STREAM_NOT_FOUND = 56;
    public static final int STREAM_PLAY_FAILED = 66;
    public static final int STREAM_PUBLISH_DENIED = 67;
    public static final int STREAM_UNPUBLISHED = 68;
    public static final int UNKNOWN_HOST = 48;
    public static final int VIDEO_SOURCE_NOT_SPECIFIED = 17;

    public WOWZStreamingError(int i) {
        super(ERROR_CLASS, i);
    }

    public WOWZStreamingError(int i, Exception exc) {
        super(ERROR_CLASS, i, exc);
    }
}

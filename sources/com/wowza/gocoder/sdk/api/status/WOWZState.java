package com.wowza.gocoder.sdk.api.status;

/* compiled from: GoCoderSDK */
public class WOWZState {
    public static final int COMPLETE = 7;
    public static final int DECODER_ENDED = 15;
    public static final int DECODER_STARTED = 14;
    public static final int ERROR = 10;
    public static final int IDLE = 0;
    public static final int MAX_STATE = 13;
    public static final int MIN_STATE = 0;
    public static final int PAUSED = 5;
    public static final int PREBUFFERING_ENDED = 13;
    public static final int PREBUFFERING_STARTED = 12;
    public static final int READY = 2;
    public static final int RUNNING = 3;
    public static final int SHUTDOWN = 9;
    public static final int STARTING = 1;
    public static final int STOPPED = 6;
    public static final int STOPPING = 4;
    public static final int UNKNOWN = 11;

    public static boolean isValidState(int i) {
        return i >= 0 && i <= 13 && i != 8;
    }

    public static String toLabel(int i) {
        switch (i) {
            case 0:
                return "IDLE";
            case 1:
                return "STARTING";
            case 2:
                return "READY";
            case 3:
                return "RUNNING";
            case 4:
                return "STOPPING";
            case 5:
                return "PAUSED";
            case 6:
                return "STOPPED";
            case 7:
                return "COMPLETE";
            case 9:
                return "SHUTDOWN";
            case 10:
                return "ERROR";
            case 12:
                return "PREBUFFERING_STARTED";
            case 13:
                return "PREBUFFERING_ENDED";
            default:
                return "(UNKNOWN STATE)";
        }
    }
}

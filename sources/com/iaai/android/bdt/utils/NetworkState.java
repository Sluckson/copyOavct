package com.iaai.android.bdt.utils;

public class NetworkState {
    public static final NetworkState LOADED = new NetworkState(Status.SUCCESS, "Success");
    public static final NetworkState LOADING = new NetworkState(Status.RUNNING, "Running");
    private final String msg;
    private final Status status;

    public enum Status {
        RUNNING,
        SUCCESS,
        FAILED
    }

    public NetworkState(Status status2, String str) {
        this.status = status2;
        this.msg = str;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }
}

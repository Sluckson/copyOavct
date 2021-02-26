package com.paypal.android.sdk.onetouch.core.fpti;

public enum TrackingPoint {
    SwitchToBrowser("switchaway", "browser"),
    SwitchToWallet("switchaway", "wallet"),
    Cancel("switchback", "cancel"),
    Return("switchback", "return"),
    Error("switchback", "cancel", true);
    

    /* renamed from: mC */
    private final String f2141mC;

    /* renamed from: mD */
    private final String f2142mD;
    private final boolean mHasError;

    private TrackingPoint(String str, String str2, boolean z) {
        this.f2141mC = str;
        this.f2142mD = str2;
        this.mHasError = z;
    }

    private TrackingPoint(String str, String str2) {
        this(r7, r8, str, str2, false);
    }

    public String getCd() {
        return this.f2141mC + ":" + this.f2142mD;
    }

    public boolean hasError() {
        return this.mHasError;
    }
}

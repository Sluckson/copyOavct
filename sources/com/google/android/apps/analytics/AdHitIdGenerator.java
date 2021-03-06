package com.google.android.apps.analytics;

public class AdHitIdGenerator {
    private boolean adMobSdkInstalled;

    public AdHitIdGenerator() {
        try {
            this.adMobSdkInstalled = Class.forName("com.google.ads.AdRequest") != null;
        } catch (ClassNotFoundException unused) {
            this.adMobSdkInstalled = false;
        }
    }

    AdHitIdGenerator(boolean z) {
        this.adMobSdkInstalled = z;
    }

    /* access modifiers changed from: package-private */
    public int getAdHitId() {
        if (!this.adMobSdkInstalled) {
            return 0;
        }
        return AdMobInfo.getInstance().generateAdHitId();
    }
}

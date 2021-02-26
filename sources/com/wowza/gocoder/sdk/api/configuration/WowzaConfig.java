package com.wowza.gocoder.sdk.api.configuration;

import java.io.Serializable;

/* compiled from: GoCoderSDK */
public class WowzaConfig extends WOWZStreamConfig implements Serializable {

    /* renamed from: a */
    private boolean f3595a;

    public WowzaConfig() {
        this.f3595a = true;
    }

    public WowzaConfig(WowzaConfig wowzaConfig) {
        this();
        set(wowzaConfig);
    }

    public WowzaConfig(WOWZMediaConfig wOWZMediaConfig) {
        this();
        set(wOWZMediaConfig);
    }

    public void set(WowzaConfig wowzaConfig) {
        if (wowzaConfig != null) {
            super.set((WOWZStreamConfig) wowzaConfig);
            this.f3595a = wowzaConfig.getCapturedVideoRotates();
        }
    }

    public void set(WOWZMediaConfig wOWZMediaConfig) {
        if (wOWZMediaConfig != null) {
            super.set(wOWZMediaConfig);
        }
    }

    public void setCapturedVideoRotates(boolean z) {
        this.f3595a = z;
    }

    public boolean getCapturedVideoRotates() {
        return this.f3595a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nCaptured video rotates   : ");
        sb.append(this.f3595a ? "yes" : "no");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }
}

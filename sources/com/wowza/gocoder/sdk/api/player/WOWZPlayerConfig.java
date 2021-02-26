package com.wowza.gocoder.sdk.api.player;

import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZStreamConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import java.util.Locale;

/* compiled from: GoCoderSDK */
public class WOWZPlayerConfig extends WOWZStreamConfig {

    /* renamed from: a */
    private long f3842a;

    public WOWZPlayerConfig() {
        this.f3842a = 0;
    }

    public WOWZPlayerConfig(WOWZPlayerConfig wOWZPlayerConfig) {
        this();
        set(wOWZPlayerConfig);
    }

    public WOWZPlayerConfig(WOWZMediaConfig wOWZMediaConfig) {
        this();
        set(wOWZMediaConfig);
    }

    public void set(WOWZPlayerConfig wOWZPlayerConfig) {
        if (wOWZPlayerConfig != null) {
            super.set((WOWZStreamConfig) wOWZPlayerConfig);
            this.f3842a = wOWZPlayerConfig.f3842a;
        }
    }

    public void set(WOWZMediaConfig wOWZMediaConfig) {
        if (wOWZMediaConfig != null) {
            super.set(wOWZMediaConfig);
        }
    }

    public float getPreRollBufferDuration() {
        return ((float) this.f3842a) / 1000.0f;
    }

    public long getPreRollBufferDurationMillis() {
        return this.f3842a;
    }

    public void setPreRollBufferDuration(float f) {
        synchronized (this) {
            if (f >= 0.0f) {
                this.f3842a = (long) Math.round(f * 1000.0f);
            } else {
                this.f3842a = 0;
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        return stringBuffer.toString();
    }

    public WOWZDataMap toDataMap(WOWZDataMap wOWZDataMap) {
        super.toDataMap(wOWZDataMap);
        wOWZDataMap.put("preRollBufferDurationSec", String.format(Locale.US, "%.2f mbps", new Object[]{Float.valueOf(getPreRollBufferDuration())}));
        return wOWZDataMap;
    }
}

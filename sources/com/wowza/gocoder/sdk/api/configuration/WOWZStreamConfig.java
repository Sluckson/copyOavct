package com.wowza.gocoder.sdk.api.configuration;

import com.wowza.gocoder.sdk.api.data.WOWZData;
import com.wowza.gocoder.sdk.api.data.WOWZDataItem;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.data.WOWZDataType;
import com.wowza.gocoder.sdk.api.errors.WOWZStreamingError;
import com.wowza.gocoder.sdk.support.p040g.C4300a;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

/* compiled from: GoCoderSDK */
public class WOWZStreamConfig extends WOWZMediaConfig implements Serializable {
    public static final String DEFAULT_APP = "live";
    public static final int DEFAULT_PORT = 1935;
    public static final String DEFAULT_STREAM = "myStream";

    /* renamed from: a */
    private String f3586a;

    /* renamed from: b */
    private int f3587b;

    /* renamed from: c */
    private String f3588c;

    /* renamed from: d */
    private String f3589d;

    /* renamed from: e */
    private String f3590e;

    /* renamed from: f */
    private String f3591f;

    /* renamed from: g */
    private int f3592g;

    /* renamed from: h */
    private WOWZDataMap f3593h;

    /* renamed from: i */
    private WOWZDataMap f3594i;

    public WOWZStreamConfig() {
        this.f3586a = null;
        this.f3587b = 1935;
        this.f3588c = "live";
        this.f3589d = DEFAULT_STREAM;
        this.f3590e = null;
        this.f3591f = null;
        this.f3592g = 4;
        this.f3593h = null;
        this.f3594i = null;
    }

    public WOWZStreamConfig(WOWZStreamConfig wOWZStreamConfig) {
        this();
        set(wOWZStreamConfig);
    }

    public WOWZStreamConfig(WOWZMediaConfig wOWZMediaConfig) {
        this();
        set(wOWZMediaConfig);
    }

    public void set(WOWZStreamConfig wOWZStreamConfig) {
        if (wOWZStreamConfig != null) {
            super.set(wOWZStreamConfig);
            this.f3586a = wOWZStreamConfig.getHostAddress();
            this.f3587b = wOWZStreamConfig.getPortNumber();
            this.f3588c = wOWZStreamConfig.getApplicationName();
            this.f3589d = wOWZStreamConfig.getStreamName();
            this.f3590e = wOWZStreamConfig.getUsername();
            this.f3591f = wOWZStreamConfig.getPassword();
            this.f3594i = wOWZStreamConfig.getStreamMetadata();
            this.f3593h = wOWZStreamConfig.getConnectionParameters();
        }
    }

    public void set(WOWZMediaConfig wOWZMediaConfig) {
        if (wOWZMediaConfig != null) {
            super.set(wOWZMediaConfig);
        }
    }

    public String getHostAddress() {
        return this.f3586a;
    }

    public void setHostAddress(String str) {
        this.f3586a = (str == null || str.trim().length() <= 0) ? null : str.trim();
    }

    public int getPortNumber() {
        return this.f3587b;
    }

    public void setPortNumber(int i) {
        this.f3587b = i;
    }

    public String getApplicationName() {
        return this.f3588c;
    }

    public void setApplicationName(String str) {
        this.f3588c = (str == null || str.trim().length() <= 0) ? null : str.trim();
    }

    public String getStreamName() {
        return this.f3589d;
    }

    public void setStreamName(String str) {
        this.f3589d = (str == null || str.trim().length() <= 0) ? null : str.trim();
    }

    public String getUsername() {
        return this.f3590e;
    }

    public void setUsername(String str) {
        this.f3590e = (str == null || str.trim().length() <= 0) ? null : str.trim();
    }

    public String getPassword() {
        return this.f3591f;
    }

    public void setPassword(String str) {
        this.f3591f = (str == null || str.trim().length() <= 0) ? null : str.trim();
    }

    public void setStreamMetadata(WOWZDataMap wOWZDataMap) {
        this.f3594i = wOWZDataMap;
    }

    public WOWZDataMap getStreamMetadata() {
        return this.f3594i;
    }

    public void setConnectionParameters(WOWZDataMap wOWZDataMap) {
        this.f3593h = wOWZDataMap;
    }

    public WOWZDataMap getConnectionParameters() {
        return this.f3593h;
    }

    public String getConnectionURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("wowz://%s/%s", new Object[]{this.f3586a, this.f3588c}));
        WOWZDataMap wOWZDataMap = this.f3593h;
        if (wOWZDataMap != null && wOWZDataMap.keys().length > 0) {
            sb.append("?");
            String[] keys = this.f3593h.keys();
            for (int i = 0; i < keys.length; i++) {
                if (i > 0) {
                    sb.append("&");
                }
                WOWZData wOWZData = this.f3593h.get(keys[i]);
                try {
                    if (wOWZData instanceof WOWZDataItem) {
                        if (wOWZData.getDataType() == WOWZDataType.DATE) {
                            sb.append(String.format("%s=%s", new Object[]{URLEncoder.encode(keys[i], "UTF-8"), URLEncoder.encode(Long.toString(((WOWZDataItem) wOWZData).dateValue().getTime()), "UTF-8")}));
                        } else if (!((WOWZDataItem) wOWZData).isNull()) {
                            sb.append(String.format("%s=%s", new Object[]{URLEncoder.encode(keys[i], "UTF-8"), URLEncoder.encode(wOWZData.toString(), "UTF-8")}));
                        }
                    }
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        return sb.toString();
    }

    public int getLogLevel() {
        return this.f3592g;
    }

    public void setLogLevel(int i) {
        this.f3592g = i;
    }

    public WOWZStreamingError validateForBroadcast() {
        int i;
        String str = this.f3586a;
        if (str == null || str.trim().length() == 0) {
            i = 8;
        } else if (this.f3587b <= 0) {
            i = 9;
        } else {
            String str2 = this.f3588c;
            if (str2 == null || str2.trim().length() == 0) {
                i = 10;
            } else {
                String str3 = this.f3589d;
                i = (str3 == null || str3.trim().length() == 0) ? 11 : 0;
            }
        }
        if (i == 0) {
            return null;
        }
        return new WOWZStreamingError(i);
    }

    public WOWZStreamingError validateForPlayback() {
        int i;
        String str = this.f3586a;
        if (str == null || str.trim().length() == 0) {
            i = 8;
        } else if (this.f3587b <= 0) {
            i = 9;
        } else {
            String str2 = this.f3588c;
            if (str2 == null || str2.trim().length() == 0) {
                i = 10;
            } else {
                String str3 = this.f3589d;
                i = (str3 == null || str3.trim().length() == 0) ? 11 : 0;
            }
        }
        if (i == 0) {
            return null;
        }
        return new WOWZStreamingError(i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString() + "\n");
        stringBuffer.append("\nHost address              : " + this.f3586a);
        stringBuffer.append("\nPort number               : " + this.f3587b);
        stringBuffer.append("\nApplication name          : " + this.f3588c);
        stringBuffer.append("\nStream name               : " + this.f3589d);
        stringBuffer.append("\nUsername                  : " + this.f3590e);
        stringBuffer.append("\nPassword                  : ");
        String str = this.f3591f;
        String str2 = "(not set)";
        if (str == null || str.length() <= 0) {
            stringBuffer.append(str2);
        } else {
            char[] cArr = new char[this.f3591f.length()];
            Arrays.fill(cArr, '*');
            stringBuffer.append(String.valueOf(cArr));
        }
        stringBuffer.append("\n\nConnection parameters:\n");
        WOWZDataMap wOWZDataMap = this.f3593h;
        stringBuffer.append((wOWZDataMap == null || wOWZDataMap.size() <= 0) ? str2 : this.f3593h.toString(true));
        stringBuffer.append("\n\nStream metadata:\n");
        WOWZDataMap wOWZDataMap2 = this.f3594i;
        if (wOWZDataMap2 != null && wOWZDataMap2.size() > 0) {
            str2 = this.f3594i.toString(true);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public WOWZDataMap toDataMap(WOWZDataMap wOWZDataMap) {
        super.toDataMap(wOWZDataMap);
        wOWZDataMap.put("connectionHostAddress", this.f3586a);
        wOWZDataMap.put("connectionPortNumber", String.valueOf(this.f3587b));
        wOWZDataMap.put("connectionApplicationName", this.f3588c);
        wOWZDataMap.put("connectionStreamName", this.f3589d);
        wOWZDataMap.put("connectionUsername", this.f3590e);
        String a = C4300a.m4215a(this.f3591f);
        if (a == null) {
            a = "";
        }
        wOWZDataMap.put("connectionPassword", a);
        return wOWZDataMap;
    }
}

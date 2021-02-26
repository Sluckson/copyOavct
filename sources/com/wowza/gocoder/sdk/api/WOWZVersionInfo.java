package com.wowza.gocoder.sdk.api;

import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import java.util.Locale;
import java.util.ResourceBundle;

/* compiled from: GoCoderSDK */
public class WOWZVersionInfo {

    /* renamed from: a */
    private static final String f3463a = "VersionInfo";

    /* renamed from: b */
    private static volatile WOWZVersionInfo f3464b = new WOWZVersionInfo();

    /* renamed from: c */
    private int f3465c = 0;

    /* renamed from: d */
    private int f3466d = 0;

    /* renamed from: e */
    private int f3467e = 0;

    /* renamed from: f */
    private int f3468f = 0;

    /* renamed from: g */
    private String f3469g = null;

    public static WOWZVersionInfo getInstance() {
        return f3464b;
    }

    WOWZVersionInfo() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(f3463a, Locale.getDefault());
            this.f3465c = Integer.parseInt(bundle.getString("majorVersion"));
            this.f3466d = Integer.parseInt(bundle.getString("minorVersion"));
            this.f3467e = Integer.parseInt(bundle.getString("revision"));
            this.f3468f = Integer.parseInt(bundle.getString("buildNumber"));
            this.f3469g = bundle.getString("preRelease");
        } catch (Exception unused) {
            WOWZLog.warn("Version information couldn't be loaded.");
        }
    }

    public int getMajorVersion() {
        return this.f3465c;
    }

    public int getMinorVersion() {
        return this.f3466d;
    }

    public int getRevision() {
        return this.f3467e;
    }

    public int getBuildNumber() {
        return this.f3468f;
    }

    public String getPreRelease() {
        return this.f3469g;
    }

    public WOWZDataMap toDataMap() {
        WOWZDataMap wOWZDataMap = new WOWZDataMap();
        wOWZDataMap.put("majorVersion", this.f3465c);
        wOWZDataMap.put("minorVersion", this.f3466d);
        wOWZDataMap.put("revision", this.f3467e);
        wOWZDataMap.put("buildNumber", this.f3468f);
        String str = this.f3469g;
        if (str != null) {
            wOWZDataMap.put("preRelease", str);
        }
        return wOWZDataMap;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(this.f3465c));
        sb.append(".");
        sb.append(String.valueOf(this.f3466d));
        String str2 = "";
        if (this.f3467e >= 0) {
            str = "." + String.valueOf(this.f3467e);
        } else {
            str = str2;
        }
        sb.append(str);
        String str3 = this.f3469g;
        if (str3 != null && str3.length() > 0) {
            str2 = this.f3469g;
        }
        sb.append(str2);
        return sb.toString();
    }

    public String toVerboseString() {
        return toDataMap().toString(true);
    }
}

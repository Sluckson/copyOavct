package com.wowza.gocoder.sdk.api;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.codec.WOWZCodecUtils;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;

/* compiled from: GoCoderSDK */
public class WOWZPlatformInfo {

    /* renamed from: a */
    private static volatile WOWZPlatformInfo f3462a = new WOWZPlatformInfo();
    public static final String androidRelease = Build.VERSION.RELEASE;
    public static final int androidSDK = Build.VERSION.SDK_INT;
    public static final String brand = Build.BRAND;
    public static final String device = Build.DEVICE;
    public static final String manufacturer = Build.MANUFACTURER;
    public static final String model = Build.MODEL;

    /* renamed from: a */
    private static String m3469a(int i) {
        if (i == 120) {
            return "low";
        }
        if (i == 160) {
            return FirebaseAnalytics.Param.MEDIUM;
        }
        if (i == 213) {
            return "tv";
        }
        if (i == 240) {
            return "high";
        }
        if (i == 320) {
            return "xhigh";
        }
        if (i == 400 || i == 480 || i == 640) {
            return "xxxhigh";
        }
        return null;
    }

    public static WOWZPlatformInfo getInstance() {
        return f3462a;
    }

    public String toString() {
        return toDataMap().toString(true);
    }

    public WOWZDataMap toDataMap() {
        WOWZDataMap wOWZDataMap = new WOWZDataMap();
        wOWZDataMap.put("manufacturer", manufacturer);
        wOWZDataMap.put("brand", brand);
        wOWZDataMap.put("model", model);
        wOWZDataMap.put("device", device);
        wOWZDataMap.put("release", androidRelease);
        wOWZDataMap.put("sdk", androidSDK);
        return wOWZDataMap;
    }

    public static String displayInfo(Context context) {
        return displayInfoDataMap(context).toString(true);
    }

    public static WOWZDataMap displayInfoDataMap(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String a = m3469a(displayMetrics.densityDpi);
        WOWZDataMap wOWZDataMap = new WOWZDataMap();
        wOWZDataMap.put("width", displayMetrics.widthPixels);
        wOWZDataMap.put("height", displayMetrics.heightPixels);
        wOWZDataMap.put("dpiX", displayMetrics.xdpi);
        wOWZDataMap.put("dpiY", displayMetrics.ydpi);
        if (a != null) {
            wOWZDataMap.put("dpiDensity", m3469a(displayMetrics.densityDpi));
        }
        return wOWZDataMap;
    }

    public static String getEglInfo() {
        return WOWZGLES.getEglInfo(true);
    }

    public static String getEncoderInfo() {
        return WOWZCodecUtils.getCodecInfo();
    }
}

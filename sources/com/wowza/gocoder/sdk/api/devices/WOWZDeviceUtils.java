package com.wowza.gocoder.sdk.api.devices;

import android.content.Context;
import android.view.WindowManager;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;

/* compiled from: GoCoderSDK */
public class WOWZDeviceUtils {

    /* renamed from: a */
    private static final String f3724a = "WOWZDeviceUtils";

    public static int getDeviceOrientation(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? 1 : 2;
    }

    public static int getDeviceRotation(Context context) {
        int orientationToRotation = WOWZMediaConfig.orientationToRotation(getDeviceOrientation(context));
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return (rotation == 2 || rotation == 3) ? orientationToRotation + 180 : orientationToRotation;
    }

    public static int getSurfaceRotation(Context context) {
        return getDeviceRotation(context);
    }
}

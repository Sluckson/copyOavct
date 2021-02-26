package com.wowza.gocoder.sdk.api.android;

import android.graphics.Color;
import android.graphics.Point;
import android.hardware.Camera;
import com.wowza.gocoder.sdk.api.geometry.WOWZPoint;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.graphics.WOWZColor;

/* compiled from: GoCoderSDK */
public class WOWZAndroid {
    public static WOWZSize CameraSizeToWZSize(Camera.Size size) {
        return new WOWZSize(size.width, size.height);
    }

    public static Point WZPointToPoint(WOWZPoint wOWZPoint) {
        return new Point(wOWZPoint.f3734x, wOWZPoint.f3735y);
    }

    public static WOWZSize PointToWZPoint(Point point) {
        return new WOWZSize(point.x, point.y);
    }

    public static int WZColorToColor(WOWZColor wOWZColor) {
        return wOWZColor.toPacked();
    }

    public static WOWZColor ColorToWZColor(int i) {
        return new WOWZColor(Color.red(i), Color.green(i), Color.blue(i), Color.alpha(i));
    }
}

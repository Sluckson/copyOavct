package com.salesforce.marketingcloud.p020b;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.b.a */
public enum C3929a {
    BEHAVIOR_DEVICE_SHUTDOWN("android.intent.action.ACTION_SHUTDOWN"),
    BEHAVIOR_DEVICE_BOOT_COMPLETE("android.intent.action.BOOT_COMPLETED"),
    BEHAVIOR_DEVICE_TIME_ZONE_CHANGED("android.intent.action.TIMEZONE_CHANGED"),
    BEHAVIOR_APP_PACKAGE_REPLACED("android.intent.action.MY_PACKAGE_REPLACED"),
    BEHAVIOR_APP_BACKGROUNDED("com.salesforce.marketingcloud.APP_BACKGROUNDED"),
    BEHAVIOR_APP_FOREGROUNDED("com.salesforce.marketingcloud.APP_FOREGROUNDED", true),
    BEHAVIOR_SDK_REGISTRATION_SEND("com.salesforce.marketingcloud.REGISTRATION_SEND"),
    BEHAVIOR_SDK_PUSH_RECEIVED("com.salesforce.marketingcloud.PUSH_RECEIVED"),
    BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED("com.salesforce.marketingcloud.FENCE_MESSAGING_TOGGLED"),
    BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED("com.salesforce.marketingcloud.PROXIMITY_MESSAGING_TOGGLED"),
    BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED("com.salesforce.marketingcloud.PUSH_MESSAGING_TOGGLED"),
    BEHAVIOR_SDK_NOTIFICATION_OPENED("com.salesforce.marketingcloud.NOTIFICATION_OPENED"),
    BEHAVIOR_SDK_TOKEN_REFRESHED("com.salesforce.marketingcloud.TOKEN_REFRESHED");
    
    @SuppressLint({"NoHardKeywords"})

    /* renamed from: n */
    public final String f2465n;

    /* renamed from: o */
    public final boolean f2466o;

    private C3929a(String str) {
        this(r2, r3, str, false);
    }

    private C3929a(String str, boolean z) {
        this.f2465n = str;
        this.f2466o = z;
    }

    /* renamed from: a */
    public static C3929a m2331a(String str) {
        if (str == null) {
            return null;
        }
        for (C3929a aVar : values()) {
            if (str.equals(aVar.f2465n)) {
                return aVar;
            }
        }
        return null;
    }

    public String toString() {
        return this.f2465n;
    }
}

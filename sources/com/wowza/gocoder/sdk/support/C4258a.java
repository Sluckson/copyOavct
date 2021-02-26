package com.wowza.gocoder.sdk.support;

import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZSDKError;
import com.wowza.gocoder.sdk.api.errors.WOWZStreamingError;
import com.wowza.gocoder.sdk.support.licensing.LicenseManager;

/* renamed from: com.wowza.gocoder.sdk.support.a */
/* compiled from: GoCoderSDK */
public final class C4258a {

    /* renamed from: a */
    public static final String f3907a = "wzcommon";

    /* renamed from: b */
    public static final String f3908b = "wmstransport";

    /* renamed from: c */
    private static final String f3909c = "a";

    static {
        try {
            WOWZError.registerErrors(WOWZSDKError.ERROR_CLASS);
            try {
                System.loadLibrary(f3907a);
                try {
                    System.loadLibrary(f3908b);
                    try {
                        WOWZError.registerErrors(WOWZStreamingError.ERROR_CLASS);
                    } catch (Exception e) {
                        throw new RuntimeException(new WOWZSDKError(3).getErrorDescription() + " : " + WOWZStreamingError.ERROR_CLASS, e);
                    }
                } catch (Exception e2) {
                    throw new RuntimeException(new WOWZSDKError(4).getErrorDescription() + " : " + f3908b, e2);
                }
            } catch (Exception e3) {
                throw new RuntimeException(new WOWZSDKError(4).getErrorDescription() + " : " + f3907a, e3);
            }
        } catch (Exception e4) {
            throw new RuntimeException("Failed to load error message resources for WOWZSDKError", e4);
        }
    }

    /* renamed from: a */
    public static void m3698a(String str, String str2) {
        LicenseManager.init(str, str2);
    }
}

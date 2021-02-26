package com.wowza.gocoder.sdk.support.p029a;

import com.wowza.gocoder.sdk.support.C4258a;
import com.wowza.gocoder.sdk.support.licensing.LicenseManager;
import com.wowza.gocoder.sdk.support.p029a.p033b.C4270a;

/* renamed from: com.wowza.gocoder.sdk.support.a.a */
/* compiled from: GoCoderSDK */
public final class C4259a {

    /* renamed from: a */
    private static final String f3910a = "a";

    /* renamed from: b */
    private static C4270a f3911b;

    /* renamed from: a */
    public static C4270a m3699a() {
        return f3911b;
    }

    /* renamed from: a */
    public static void m3700a(String str, String str2) {
        C4258a.m3698a(str, str2);
        if (LicenseManager.getInstance().isEvaluation()) {
            f3911b = new C4270a();
        }
    }
}

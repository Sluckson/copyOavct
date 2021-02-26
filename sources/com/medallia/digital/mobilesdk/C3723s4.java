package com.medallia.digital.mobilesdk;

import android.os.Build;
import com.medallia.digital.mobilesdk.C3815z4;

/* renamed from: com.medallia.digital.mobilesdk.s4 */
class C3723s4 {
    C3723s4() {
    }

    /* renamed from: a */
    protected static boolean m1628a() {
        return !C3815z4.m2010d().mo55975a(C3815z4.C3816a.LAST_OS_VERSION, "").equals(Build.VERSION.RELEASE);
    }

    /* renamed from: b */
    protected static boolean m1629b() {
        return !C3815z4.m2010d().mo55975a(C3815z4.C3816a.LAST_SDK_VERSION, "").equals(BuildConfig.VERSION_NAME);
    }

    /* renamed from: c */
    protected static void m1630c() {
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.LAST_SDK_VERSION, BuildConfig.VERSION_NAME);
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.LAST_OS_VERSION, Build.VERSION.RELEASE);
    }
}

package com.salesforce.marketingcloud.proximity;

import android.annotation.SuppressLint;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MCKeep;
import org.altbeacon.beacon.logging.Logger;

@SuppressLint({"UnknownNullness"})
@MCKeep
public final class BeaconLogger implements Logger {
    private static final String TAG = C4039h.m2810a((Class<?>) BeaconLogger.class);

    /* renamed from: d */
    public void mo56891d(String str, String str2, Object... objArr) {
        C4039h.m2820b(TAG, str2, objArr);
    }

    /* renamed from: d */
    public void mo56892d(Throwable th, String str, String str2, Object... objArr) {
        C4039h.m2821b(TAG, th, str2, objArr);
    }

    /* renamed from: e */
    public void mo56893e(String str, String str2, Object... objArr) {
        C4039h.m2829e(TAG, str2, objArr);
    }

    /* renamed from: e */
    public void mo56894e(Throwable th, String str, String str2, Object... objArr) {
        C4039h.m2830e(TAG, th, str2, objArr);
    }

    /* renamed from: i */
    public void mo56895i(String str, String str2, Object... objArr) {
        C4039h.m2823c(TAG, str2, objArr);
    }

    /* renamed from: i */
    public void mo56896i(Throwable th, String str, String str2, Object... objArr) {
        C4039h.m2824c(TAG, th, str2, objArr);
    }

    /* renamed from: v */
    public void mo56897v(String str, String str2, Object... objArr) {
        C4039h.m2817a(TAG, str2, objArr);
    }

    /* renamed from: v */
    public void mo56898v(Throwable th, String str, String str2, Object... objArr) {
        C4039h.m2818a(TAG, th, str2, objArr);
    }

    /* renamed from: w */
    public void mo56899w(String str, String str2, Object... objArr) {
        C4039h.m2826d(TAG, str2, objArr);
    }

    /* renamed from: w */
    public void mo56900w(Throwable th, String str, String str2, Object... objArr) {
        C4039h.m2827d(TAG, th, str2, objArr);
    }
}

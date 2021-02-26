package com.iaai.android.bdt.analytics;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ(\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/FireBaseAnalytics;", "", "()V", "logFireBaseEvent", "", "IAAEvents", "Lcom/iaai/android/bdt/analytics/IAAAnalytics$IAAEvents;", "bundle", "Landroid/os/Bundle;", "logFireBaseNetworkEvent", "method", "", "success", "", "query", "error", "logFireBaseScreenName", "screenName", "context", "Landroid/app/Activity;", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Lcom/iaai/android/bdt/base/BaseFragment;", "registerFireAppVersionUserProperty", "registerFireBaseUserProperties", "userId", "isGuest", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FireBaseAnalytics.kt */
public final class FireBaseAnalytics {
    public static final FireBaseAnalytics INSTANCE = new FireBaseAnalytics();

    private FireBaseAnalytics() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if ((r5 == null || r5.length() == 0) == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r6 == false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void logFireBaseNetworkEvent(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            r4 = this;
            java.lang.String r0 = "method"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r1 = "query"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r1)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r2.putString(r0, r5)
            java.lang.String r5 = "success"
            r2.putBoolean(r5, r6)
            r5 = r8
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 0
            r0 = 1
            if (r5 == 0) goto L_0x0027
            boolean r3 = kotlin.text.StringsKt.isBlank(r5)
            if (r3 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r3 = 0
            goto L_0x0028
        L_0x0027:
            r3 = 1
        L_0x0028:
            if (r3 == 0) goto L_0x0038
            if (r5 == 0) goto L_0x0035
            int r3 = r5.length()
            if (r3 != 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = 0
            goto L_0x0036
        L_0x0035:
            r3 = 1
        L_0x0036:
            if (r3 != 0) goto L_0x003b
        L_0x0038:
            r2.putString(r1, r7)
        L_0x003b:
            if (r5 == 0) goto L_0x0046
            boolean r7 = kotlin.text.StringsKt.isBlank(r5)
            if (r7 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r7 = 0
            goto L_0x0047
        L_0x0046:
            r7 = 1
        L_0x0047:
            if (r7 == 0) goto L_0x0054
            if (r5 == 0) goto L_0x0051
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0052
        L_0x0051:
            r6 = 1
        L_0x0052:
            if (r6 != 0) goto L_0x006b
        L_0x0054:
            com.iaai.android.bdt.utils.InternetUtil r5 = com.iaai.android.bdt.utils.InternetUtil.INSTANCE
            boolean r5 = r5.isInternetOn()
            java.lang.String r6 = "error"
            if (r5 != 0) goto L_0x0068
            com.iaai.android.bdt.base.BaseFragment$ErrorType r5 = com.iaai.android.bdt.base.BaseFragment.ErrorType.NO_INTERNET
            java.lang.String r5 = r5.getValue()
            r2.putString(r6, r5)
            goto L_0x006b
        L_0x0068:
            r2.putString(r6, r8)
        L_0x006b:
            com.iaai.android.IaaiApplication r5 = com.iaai.android.IaaiApplication.getInstance()
            com.google.firebase.analytics.FirebaseAnalytics r5 = r5.getmFirebaseAnalytics()
            java.lang.String r6 = "network_call"
            r5.logEvent(r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.analytics.FireBaseAnalytics.logFireBaseNetworkEvent(java.lang.String, boolean, java.lang.String, java.lang.String):void");
    }

    public final void logFireBaseScreenName(@NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(str, "screenName");
        Intrinsics.checkParameterIsNotNull(activity, "context");
        IaaiApplication.getInstance().getmFirebaseAnalytics().setCurrentScreen(activity, str, activity.getClass().getSimpleName());
    }

    public final void logFireBaseScreenName(@NotNull String str, @NotNull FragmentActivity fragmentActivity, @NotNull BaseFragment baseFragment) {
        Intrinsics.checkParameterIsNotNull(str, "screenName");
        Intrinsics.checkParameterIsNotNull(fragmentActivity, "context");
        Intrinsics.checkParameterIsNotNull(baseFragment, "fragment");
        IaaiApplication.getInstance().getmFirebaseAnalytics().setCurrentScreen(fragmentActivity, str, baseFragment.getClass().getSimpleName());
    }

    public final void registerFireBaseUserProperties(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, "isGuest");
        IaaiApplication.getInstance().getmFirebaseAnalytics().setUserId(str);
        IaaiApplication.getInstance().getmFirebaseAnalytics().setUserProperty(IAAAnalytics.UserProperty.IS_GUEST.getId(), str2);
    }

    public final void registerFireAppVersionUserProperty() {
        IaaiApplication.getInstance().getmFirebaseAnalytics().setUserProperty(IAAAnalytics.UserProperty.APP_VERSION.getId(), "1376");
    }

    public final void logFireBaseEvent(@NotNull IAAAnalytics.IAAEvents iAAEvents, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(iAAEvents, "IAAEvents");
        IaaiApplication.getInstance().getmFirebaseAnalytics().logEvent(iAAEvents.getId(), bundle);
    }
}

package com.iaai.android.bdt.analytics;

import android.os.Bundle;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.analytics.MedalliaCustomParameters;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.medallia.digital.mobilesdk.MedalliaDigital;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/MedalliaAnalytics;", "", "()V", "logMedalliaIntercept", "", "IAAEvents", "Lcom/iaai/android/bdt/analytics/IAAAnalytics$IAAEvents;", "bundle", "Landroid/os/Bundle;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "setLoginInfoOnMedallia", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MedalliaAnalytics.kt */
public final class MedalliaAnalytics {
    public static final MedalliaAnalytics INSTANCE = new MedalliaAnalytics();

    private MedalliaAnalytics() {
    }

    public final void logMedalliaIntercept(@NotNull IAAAnalytics.IAAEvents iAAEvents, @Nullable Bundle bundle, @Nullable SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(iAAEvents, "IAAEvents");
        if (Intrinsics.areEqual((Object) iAAEvents.getId(), (Object) IAAAnalytics.IAAEvents.PAYMENT.getId())) {
            MedalliaDigital.setCustomParameter(iAAEvents.getId(), true);
            MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.PAYMENT_SOURCE.getId(), bundle != null ? bundle.getString(IAAAnalytics.FireBaseKeyNames.SOURCE.getId()) : null);
        } else {
            MedalliaDigital.setCustomParameter(iAAEvents.getId(), true);
        }
        if (sessionManager != null) {
            setLoginInfoOnMedallia(sessionManager);
        }
        MedalliaDigital.enableIntercept();
    }

    private final void setLoginInfoOnMedallia(SessionManager sessionManager) {
        CharSequence currentSessionUserId = sessionManager.getCurrentSessionUserId();
        boolean z = true;
        int i = 0;
        int parseInt = !(currentSessionUserId == null || currentSessionUserId.length() == 0) ? Integer.parseInt(sessionManager.getCurrentSessionUserId()) : 0;
        CharSequence currentSessionUserId2 = sessionManager.getCurrentSessionUserId();
        if ((currentSessionUserId2 == null || currentSessionUserId2.length() == 0) || !Intrinsics.areEqual((Object) sessionManager.getCurrentSessionBuyerId(), (Object) "0")) {
            CharSequence currentSessionBuyerId = sessionManager.getCurrentSessionBuyerId();
            int parseInt2 = !(currentSessionBuyerId == null || currentSessionBuyerId.length() == 0) ? Integer.parseInt(sessionManager.getCurrentSessionBuyerId()) : 0;
            CharSequence buyerEmployeeId = sessionManager.getBuyerEmployeeId();
            if (!(buyerEmployeeId == null || buyerEmployeeId.length() == 0)) {
                z = false;
            }
            if (!z) {
                i = Integer.parseInt(sessionManager.getBuyerEmployeeId());
            }
            MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.EMPLOYER_ID.getId(), Integer.valueOf(i));
            MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.BUYER_ID.getId(), Integer.valueOf(parseInt2));
            MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.USER_ID.getId(), Integer.valueOf(parseInt));
            return;
        }
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.EMPLOYER_ID.getId(), 0);
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.BUYER_ID.getId(), 0);
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.USER_ID.getId(), Integer.valueOf(parseInt));
    }
}

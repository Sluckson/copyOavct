package com.iaai.android.bdt.feature.login;

import android.view.View;
import com.iaai.android.old.utils.AppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTTermsOfUseActivity.kt */
final class BDTTermsOfUseActivity$initializeUI$1 implements View.OnClickListener {
    final /* synthetic */ BDTTermsOfUseActivity this$0;

    BDTTermsOfUseActivity$initializeUI$1(BDTTermsOfUseActivity bDTTermsOfUseActivity) {
        this.this$0 = bDTTermsOfUseActivity;
    }

    public final void onClick(View view) {
        BDTTermsOfUseActivity bDTTermsOfUseActivity = this.this$0;
        String deviceId = AppUtils.getDeviceId(bDTTermsOfUseActivity);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(this@BDTTermsOfUseActivity)");
        bDTTermsOfUseActivity.acceptTermsOfUse(deviceId);
    }
}

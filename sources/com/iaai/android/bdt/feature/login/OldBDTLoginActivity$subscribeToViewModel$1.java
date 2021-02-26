package com.iaai.android.bdt.feature.login;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/login/BDTLoginResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: OldBDTLoginActivity.kt */
final class OldBDTLoginActivity$subscribeToViewModel$1<T> implements Observer<BDTLoginResponse> {
    final /* synthetic */ OldBDTLoginActivity this$0;

    OldBDTLoginActivity$subscribeToViewModel$1(OldBDTLoginActivity oldBDTLoginActivity) {
        this.this$0 = oldBDTLoginActivity;
    }

    public final void onChanged(BDTLoginResponse bDTLoginResponse) {
        String tag = this.this$0.getTAG();
        Log.e(tag, "login success: " + bDTLoginResponse.getFName());
        CharSequence userID = bDTLoginResponse.getUserID();
        if (userID == null || userID.length() == 0) {
            Context_ExtensionKt.showToast(this.this$0, bDTLoginResponse.getMessage());
            return;
        }
        OldBDTLoginActivity oldBDTLoginActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(bDTLoginResponse, "it");
        oldBDTLoginActivity.loginResponse = bDTLoginResponse;
        this.this$0.setUserId(bDTLoginResponse.getUserID());
        this.this$0.getViewModel().checkIsValidEmail(this.this$0.getUsername());
    }
}

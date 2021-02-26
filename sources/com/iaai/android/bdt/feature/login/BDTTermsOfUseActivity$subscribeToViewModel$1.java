package com.iaai.android.bdt.feature.login;

import android.content.Intent;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.model.termsofuse.TermsOfUseResponse;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/termsofuse/TermsOfUseResponse;", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTTermsOfUseActivity.kt */
final class BDTTermsOfUseActivity$subscribeToViewModel$1<T> implements Observer<TermsOfUseResponse> {
    final /* synthetic */ BDTTermsOfUseActivity this$0;

    BDTTermsOfUseActivity$subscribeToViewModel$1(BDTTermsOfUseActivity bDTTermsOfUseActivity) {
        this.this$0 = bDTTermsOfUseActivity;
    }

    public final void onChanged(@Nullable TermsOfUseResponse termsOfUseResponse) {
        Log.e(this.this$0.getTAG(), "Accept terms and condition: Success");
        if (termsOfUseResponse != null && termsOfUseResponse.getIsSuccessful()) {
            IAASharedPreference.saveTncInPrefs(this.this$0);
        }
        if (this.this$0.comeFrom != TermsOfUseOrigin.FROM_LOGIN.getValue()) {
            Intent intent = new Intent(this.this$0, BDTLandingPageActivity.class);
            intent.addFlags(536870912);
            this.this$0.startActivity(intent);
            this.this$0.finish();
            return;
        }
        this.this$0.setResult(-1);
        BDTTermsOfUseActivity bDTTermsOfUseActivity = this.this$0;
        String string = bDTTermsOfUseActivity.getResources().getString(C2723R.string.msg_login_successful);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.msg_login_successful)");
        Context_ExtensionKt.showToast(bDTTermsOfUseActivity, string);
        this.this$0.finish();
    }
}

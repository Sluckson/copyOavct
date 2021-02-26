package com.iaai.android.bdt.feature.login;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.login.AuctionRuleResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/login/AuctionRuleResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: OldBDTLoginActivity.kt */
final class OldBDTLoginActivity$subscribeToViewModel$4<T> implements Observer<AuctionRuleResponse> {
    final /* synthetic */ OldBDTLoginActivity this$0;

    OldBDTLoginActivity$subscribeToViewModel$4(OldBDTLoginActivity oldBDTLoginActivity) {
        this.this$0 = oldBDTLoginActivity;
    }

    public final void onChanged(AuctionRuleResponse auctionRuleResponse) {
        String tag = this.this$0.getTAG();
        Log.e(tag, "auction rule success: " + auctionRuleResponse.getUrl());
        if (auctionRuleResponse.getUrl().length() > 0) {
            this.this$0.launchAuctionRuleActivity(auctionRuleResponse.getUrl());
        } else {
            this.this$0.navigateFromLogin();
        }
    }
}

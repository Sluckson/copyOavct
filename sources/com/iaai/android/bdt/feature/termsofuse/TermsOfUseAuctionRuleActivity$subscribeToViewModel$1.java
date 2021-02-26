package com.iaai.android.bdt.feature.termsofuse;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.termsofuse.AuctionRuleAcceptModel;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "auctionAcceptModel", "Lcom/iaai/android/bdt/model/termsofuse/AuctionRuleAcceptModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: TermsOfUseAuctionRuleActivity.kt */
final class TermsOfUseAuctionRuleActivity$subscribeToViewModel$1<T> implements Observer<AuctionRuleAcceptModel> {
    final /* synthetic */ TermsOfUseAuctionRuleActivity this$0;

    TermsOfUseAuctionRuleActivity$subscribeToViewModel$1(TermsOfUseAuctionRuleActivity termsOfUseAuctionRuleActivity) {
        this.this$0 = termsOfUseAuctionRuleActivity;
    }

    public final void onChanged(AuctionRuleAcceptModel auctionRuleAcceptModel) {
        if (auctionRuleAcceptModel != null) {
            TermsOfUseAuctionRuleActivity termsOfUseAuctionRuleActivity = this.this$0;
            termsOfUseAuctionRuleActivity.stopService(termsOfUseAuctionRuleActivity.getServiceIntent());
            this.this$0.setResult(-1);
            this.this$0.finish();
        }
    }
}

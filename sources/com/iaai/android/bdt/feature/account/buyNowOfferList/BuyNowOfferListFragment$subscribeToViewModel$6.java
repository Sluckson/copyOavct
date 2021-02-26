package com.iaai.android.bdt.feature.account.buyNowOfferList;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "reposne", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListFragment.kt */
final class BuyNowOfferListFragment$subscribeToViewModel$6<T> implements Observer<BuyNowOfferListResponse> {
    final /* synthetic */ BuyNowOfferListFragment this$0;

    BuyNowOfferListFragment$subscribeToViewModel$6(BuyNowOfferListFragment buyNowOfferListFragment) {
        this.this$0 = buyNowOfferListFragment;
    }

    public final void onChanged(BuyNowOfferListResponse buyNowOfferListResponse) {
        if (buyNowOfferListResponse != null) {
            this.this$0.setDashBoardCountAtSharePreference(buyNowOfferListResponse.getBuyNowOfferCount());
            this.this$0.setToolbarCount(buyNowOfferListResponse.getBuyNowOfferCount());
        }
    }
}

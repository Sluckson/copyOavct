package com.iaai.android.bdt.feature.account.buyNowOfferList;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListModel;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListActivity.kt */
final class BuyNowOfferListActivity$subscribeToViewModel$1<T> implements Observer<BuyNowOfferListResponse> {
    final /* synthetic */ BuyNowOfferListActivity this$0;

    BuyNowOfferListActivity$subscribeToViewModel$1(BuyNowOfferListActivity buyNowOfferListActivity) {
        this.this$0 = buyNowOfferListActivity;
    }

    public final void onChanged(BuyNowOfferListResponse buyNowOfferListResponse) {
        List<BuyNowOfferListModel> buyNowOfferList;
        Log.e("Error", "subscribeToViewModel");
        ArrayList arrayList = new ArrayList();
        if (!(buyNowOfferListResponse == null || (buyNowOfferList = buyNowOfferListResponse.getBuyNowOfferList()) == null)) {
            for (BuyNowOfferListModel itemId : buyNowOfferList) {
                arrayList.add(String.valueOf(itemId.getItemId()));
            }
        }
        BuyNowOfferListActivity.access$getOnNextPageLoad$p(this.this$0).OnNextSlotOfItemID(arrayList);
    }
}

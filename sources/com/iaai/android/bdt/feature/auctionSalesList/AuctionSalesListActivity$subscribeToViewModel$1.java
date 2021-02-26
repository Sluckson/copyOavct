package com.iaai.android.bdt.feature.auctionSalesList;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListResponse;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListActivity.kt */
final class AuctionSalesListActivity$subscribeToViewModel$1<T> implements Observer<AuctionSalesListResponse> {
    final /* synthetic */ AuctionSalesListActivity this$0;

    AuctionSalesListActivity$subscribeToViewModel$1(AuctionSalesListActivity auctionSalesListActivity) {
        this.this$0 = auctionSalesListActivity;
    }

    public final void onChanged(AuctionSalesListResponse auctionSalesListResponse) {
        List<ResultData> resultData;
        Log.e("Error", "subscribeToViewModel");
        ArrayList arrayList = new ArrayList();
        if (!(auctionSalesListResponse == null || (resultData = auctionSalesListResponse.getResultData()) == null)) {
            for (ResultData itemId : resultData) {
                arrayList.add(String.valueOf(itemId.getItemId()));
            }
        }
        AuctionSalesListActivity.access$getOnNextPageLoad$p(this.this$0).OnNextSlotOfItemID(arrayList);
    }
}

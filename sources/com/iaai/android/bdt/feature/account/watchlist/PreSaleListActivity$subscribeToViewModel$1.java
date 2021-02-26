package com.iaai.android.bdt.feature.account.watchlist;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.model.MyAccount.WatchListResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/MyAccount/WatchListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListActivity.kt */
final class PreSaleListActivity$subscribeToViewModel$1<T> implements Observer<WatchListResponse> {
    final /* synthetic */ PreSaleListActivity this$0;

    PreSaleListActivity$subscribeToViewModel$1(PreSaleListActivity preSaleListActivity) {
        this.this$0 = preSaleListActivity;
    }

    public final void onChanged(WatchListResponse watchListResponse) {
        List<WatchListModel> listModel;
        Log.e("Error", "subscribeToViewModel");
        ArrayList arrayList = new ArrayList();
        if (!(watchListResponse == null || (listModel = watchListResponse.getListModel()) == null)) {
            for (WatchListModel itemid : listModel) {
                arrayList.add(String.valueOf(itemid.getItemid()));
            }
        }
        PreSaleListActivity.access$getOnNextPageLoad$p(this.this$0).OnNextSlotOfItemID(arrayList);
    }
}

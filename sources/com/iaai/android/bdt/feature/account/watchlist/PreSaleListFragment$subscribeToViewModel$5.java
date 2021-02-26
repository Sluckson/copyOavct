package com.iaai.android.bdt.feature.account.watchlist;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.model.MyAccount.WatchListResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "reposne", "Lcom/iaai/android/bdt/model/MyAccount/WatchListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
final class PreSaleListFragment$subscribeToViewModel$5<T> implements Observer<WatchListResponse> {
    final /* synthetic */ PreSaleListFragment this$0;

    PreSaleListFragment$subscribeToViewModel$5(PreSaleListFragment preSaleListFragment) {
        this.this$0 = preSaleListFragment;
    }

    public final void onChanged(WatchListResponse watchListResponse) {
        List<WatchListModel> listModel;
        String itemid;
        if (watchListResponse != null) {
            PreSaleListFragment preSaleListFragment = this.this$0;
            String totalcount = watchListResponse.getTotalcount();
            preSaleListFragment.setDashBoardCountAtSharePreference(totalcount != null ? Integer.parseInt(totalcount) : 0);
            if (StringsKt.equals(this.this$0.mKeywordSearch, "", true)) {
                PreSaleListFragment preSaleListFragment2 = this.this$0;
                String totalcount2 = watchListResponse.getTotalcount();
                preSaleListFragment2.setToolbarCount(totalcount2 != null ? Integer.parseInt(totalcount2) : 0);
            } else {
                PreSaleListFragment preSaleListFragment3 = this.this$0;
                List<WatchListModel> listModel2 = watchListResponse.getListModel();
                preSaleListFragment3.setToolbarCount(listModel2 != null ? listModel2.size() : 0);
            }
            if (StringsKt.equals(this.this$0.myAccountStatus, String.valueOf(PreSaleListStatus.WATCHING_LIST.getValue()), false) && (listModel = watchListResponse.getListModel()) != null) {
                for (WatchListModel watchListModel : listModel) {
                    PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).setWatchingData(true, (watchListModel == null || (itemid = watchListModel.getItemid()) == null) ? 0 : Long.parseLong(itemid));
                }
            }
        }
    }
}

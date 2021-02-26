package com.iaai.android.bdt.feature.account.watchlist;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "watchListResponse", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
final class PreSaleListFragment$subscribeToViewModel$6<T> implements Observer<UpdateWatchListResponse> {
    final /* synthetic */ PreSaleListFragment this$0;

    PreSaleListFragment$subscribeToViewModel$6(PreSaleListFragment preSaleListFragment) {
        this.this$0 = preSaleListFragment;
    }

    public final void onChanged(UpdateWatchListResponse updateWatchListResponse) {
        if (updateWatchListResponse != null && this.this$0.isAdded()) {
            if (Intrinsics.areEqual((Object) this.this$0.action, (Object) "add")) {
                PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).setWatchingData(true, this.this$0.itemIdWatch);
                PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).notifyItemChanged(this.this$0.indexToUpdate);
                PreSaleListFragment preSaleListFragment = this.this$0;
                preSaleListFragment.totalCountWatchDashBoard = preSaleListFragment.totalCountWatchDashBoard + 1;
                PreSaleListFragment preSaleListFragment2 = this.this$0;
                preSaleListFragment2.setDashBoardCountAtSharePreference(preSaleListFragment2.totalCountWatchDashBoard);
            } else if (Intrinsics.areEqual((Object) this.this$0.action, (Object) "delete")) {
                PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).setWatchingData(false, this.this$0.itemIdWatch);
                PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).notifyItemChanged(this.this$0.indexToUpdate);
                PreSaleListFragment preSaleListFragment3 = this.this$0;
                preSaleListFragment3.totalCountWatchDashBoard = preSaleListFragment3.totalCountWatchDashBoard - 1;
                PreSaleListFragment preSaleListFragment4 = this.this$0;
                preSaleListFragment4.setDashBoardCountAtSharePreference(preSaleListFragment4.totalCountWatchDashBoard);
            }
        }
    }
}

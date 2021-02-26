package com.iaai.android.bdt.feature.auctionSalesList;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.auctionSalesList.AuctionDetails;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListResponse;
import com.iaai.android.bdt.model.auctionSalesList.Scope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListFragment.kt */
final class AuctionSalesListFragment$subscribeToViewModel$1<T> implements Observer<AuctionSalesListResponse> {
    final /* synthetic */ AuctionSalesListFragment this$0;

    AuctionSalesListFragment$subscribeToViewModel$1(AuctionSalesListFragment auctionSalesListFragment) {
        this.this$0 = auctionSalesListFragment;
    }

    public final void onChanged(AuctionSalesListResponse auctionSalesListResponse) {
        List<Scope> scope;
        this.this$0.scopeList.clear();
        AuctionSalesListFragment auctionSalesListFragment = this.this$0;
        AuctionDetails auctionDetails = null;
        Integer valueOf = auctionSalesListResponse != null ? Integer.valueOf(auctionSalesListResponse.getListCount()) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        auctionSalesListFragment.totalCount = valueOf.intValue();
        if (this.this$0.auctionSalesListAdapter != null) {
            AuctionSalesListFragment auctionSalesListFragment2 = this.this$0;
            if (auctionSalesListResponse != null) {
                auctionDetails = auctionSalesListResponse.getAuctionDetails();
            }
            auctionSalesListFragment2.auctionDetails = auctionDetails;
            this.this$0.addHeaderToAuctionSalesList("");
        }
        if (auctionSalesListResponse != null && (scope = auctionSalesListResponse.getScope()) != null) {
            for (Scope scope2 : scope) {
                this.this$0.scopeList.add(scope2.getName());
                this.this$0.scopeListLaneCount.add(String.valueOf(scope2.getCount()));
            }
        }
    }
}

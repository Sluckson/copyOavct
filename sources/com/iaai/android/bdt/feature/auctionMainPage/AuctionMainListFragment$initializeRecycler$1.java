package com.iaai.android.bdt.feature.auctionMainPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import com.iaai.android.old.activities.MDLocationDetailActivity;
import com.iaai.android.old.fragments.MDLocationDetailFragment;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, mo66933d2 = {"com/iaai/android/bdt/feature/auctionMainPage/AuctionMainListFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionItemClickListener;", "onAuctionClick", "", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "onAuctionJoinNowClick", "isBidLive", "", "onAuctionViewListClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListFragment.kt */
public final class AuctionMainListFragment$initializeRecycler$1 implements AuctionItemClickListener {
    final /* synthetic */ AuctionMainListFragment this$0;

    AuctionMainListFragment$initializeRecycler$1(AuctionMainListFragment auctionMainListFragment) {
        this.this$0 = auctionMainListFragment;
    }

    public void onAuctionJoinNowClick(@NotNull View view, @NotNull AuctionLocations auctionLocations, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(auctionLocations, "data");
        String str = null;
        if (z) {
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.BID_LIVE.getId());
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.BID_LIVE, (Bundle) null);
        } else {
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.JOIN_AUCTION.getId());
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.JOIN_AUCTION, (Bundle) null);
        }
        this.this$0.selectedAuction = auctionLocations;
        if (!this.this$0.getSessionManager().promptForLoginIfNeedFromFragment(AuctionMainListFragment.access$getAuctionMainListActivity$p(this.this$0), this.this$0, 29)) {
            this.this$0.launchIBidLive(auctionLocations);
        }
        AuctionMainListFragment auctionMainListFragment = this.this$0;
        Context access$getAuctionMainListActivity$p = AuctionMainListFragment.access$getAuctionMainListActivity$p(auctionMainListFragment);
        AuctionLocations access$getSelectedAuction$p = this.this$0.selectedAuction;
        if (access$getSelectedAuction$p != null) {
            str = access$getSelectedAuction$p.getBranchid();
        }
        auctionMainListFragment.updateSuggestions(access$getAuctionMainListActivity$p, str);
    }

    public void onAuctionViewListClick(@NotNull View view, @NotNull AuctionLocations auctionLocations) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(auctionLocations, "data");
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.AUCTION_SALES_LIST.getId());
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.AUCTION_SALES_LIST, (Bundle) null);
        Intent intent = new Intent(AuctionMainListFragment.access$getAuctionMainListActivity$p(this.this$0), AuctionSalesListActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra(Constants.EXTRA_BRANCH, auctionLocations.getBranchid());
        intent.putExtra(Constants.EXTRA_NAME, auctionLocations.getName());
        intent.putExtra(Constants.EXTRA_AUCTION_VEHICLE_COUNT, auctionLocations.getVehiclecount());
        intent.putExtra(Constants.EXTRA_BRANCH_NAME_TITLE, auctionLocations.getName());
        intent.putExtra(Constants.EXTRA_IS_IBID_LIVE, auctionLocations.isIBuyLive());
        intent.putExtra(Constants.EXTRA_DATE, auctionLocations.getLiveDate());
        intent.putExtra(Constants.EXTRA_IS_NF_INDICATOR, auctionLocations.getNfInd());
        this.this$0.startActivity(intent);
        AuctionMainListFragment auctionMainListFragment = this.this$0;
        auctionMainListFragment.updateSuggestions(AuctionMainListFragment.access$getAuctionMainListActivity$p(auctionMainListFragment), auctionLocations.getBranchid());
    }

    public void onAuctionClick(@NotNull View view, @NotNull AuctionLocations auctionLocations) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(auctionLocations, "data");
        AuctionMainListFragment auctionMainListFragment = this.this$0;
        auctionMainListFragment.updateSuggestions(AuctionMainListFragment.access$getAuctionMainListActivity$p(auctionMainListFragment), auctionLocations.getBranchid());
        Intent intent = new Intent(this.this$0.getContext(), MDLocationDetailActivity.class);
        intent.putExtra("item_id", "" + auctionLocations.getBranchid());
        intent.putExtra(MDLocationDetailFragment.ARG_BRANCH_NAME, auctionLocations.getName());
        this.this$0.startActivity(intent);
        AuctionMainListFragment auctionMainListFragment2 = this.this$0;
        auctionMainListFragment2.updateSuggestions(AuctionMainListFragment.access$getAuctionMainListActivity$p(auctionMainListFragment2), auctionLocations.getBranchid());
    }
}

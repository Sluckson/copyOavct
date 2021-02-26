package com.iaai.android.bdt.feature.account.watchlist;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "pagedList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
final class PreSaleListFragment$subscribeToViewModel$2<T> implements Observer<PagedList<WatchListModel>> {
    final /* synthetic */ PreSaleListFragment this$0;

    PreSaleListFragment$subscribeToViewModel$2(PreSaleListFragment preSaleListFragment) {
        this.this$0 = preSaleListFragment;
    }

    public final void onChanged(PagedList<WatchListModel> pagedList) {
        String itemid;
        Log.e(this.this$0.TAG, String.valueOf(pagedList.size()));
        if (pagedList == null || pagedList.size() != 0) {
            this.this$0.isError = false;
        } else {
            this.this$0.errorType = BaseFragment.ErrorType.NO_STOCKS;
            this.this$0.isError = true;
            PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).submitList(pagedList);
            PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
            if (this.this$0.isTablet()) {
                Bundle bundle = new Bundle();
                bundle.putString(Constants.EXTRA_ITEM_ID, "");
                Fragment findFragmentById = this.this$0.getChildFragmentManager().findFragmentById(C2723R.C2726id.auction_sales_nav_container);
                if (findFragmentById != null) {
                    NavHostFragment navHostFragment = (NavHostFragment) findFragmentById;
                    navHostFragment.getNavController().popBackStack();
                    navHostFragment.getNavController().navigate((int) C2723R.C2726id.PDFragment, bundle);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
                }
            }
        }
        PreSaleListFragment preSaleListFragment = this.this$0;
        int access$getCurrentCount$p = preSaleListFragment.currentCount;
        String str = null;
        Integer valueOf = pagedList != null ? Integer.valueOf(pagedList.size()) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        preSaleListFragment.currentCount = access$getCurrentCount$p + valueOf.intValue();
        this.this$0.addHeaderToAuctionSalesList("");
        if (pagedList == null) {
            Intrinsics.throwNpe();
        }
        if (pagedList.size() > 0) {
            PreSaleListFragment preSaleListFragment2 = this.this$0;
            StringBuilder sb = new StringBuilder();
            WatchListModel watchListModel = pagedList.get(0);
            sb.append(watchListModel != null ? watchListModel.getYear() : null);
            sb.append(' ');
            WatchListModel watchListModel2 = pagedList.get(0);
            sb.append(watchListModel2 != null ? watchListModel2.getMake() : null);
            sb.append(' ');
            WatchListModel watchListModel3 = pagedList.get(0);
            sb.append(watchListModel3 != null ? watchListModel3.getModel() : null);
            preSaleListFragment2.year_make_model = sb.toString();
        }
        NetworkState value = PreSaleListFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
        if ((value != null ? value.getStatus() : null) == NetworkState.Status.SUCCESS) {
            this.this$0.errorType = BaseFragment.ErrorType.NO_STOCKS;
            this.this$0.isError = false;
            PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).submitList(pagedList);
            PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
            if (this.this$0.isTablet()) {
                WatchListModel watchListModel4 = pagedList.get(0);
                String valueOf2 = String.valueOf(watchListModel4 != null ? watchListModel4.getItemid() : null);
                Bundle bundle2 = new Bundle();
                WatchListModel watchListModel5 = pagedList.get(0);
                PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).setSelectedItemForTablet((watchListModel5 == null || (itemid = watchListModel5.getItemid()) == null) ? null : Long.valueOf(Long.parseLong(itemid)));
                PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
                bundle2.putString(Constants.EXTRA_ITEM_ID, valueOf2);
                Fragment findFragmentById2 = this.this$0.getChildFragmentManager().findFragmentById(C2723R.C2726id.auction_sales_nav_container);
                if (findFragmentById2 != null) {
                    NavHostFragment navHostFragment2 = (NavHostFragment) findFragmentById2;
                    navHostFragment2.getNavController().popBackStack();
                    navHostFragment2.getNavController().navigate((int) C2723R.C2726id.PDFragment, bundle2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
                }
            }
        }
        this.this$0.showLoadingIndicator(false);
        if (!this.this$0.isError) {
            NetworkState value2 = PreSaleListFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
            if ((value2 != null ? value2.getStatus() : null) == NetworkState.Status.FAILED) {
                this.this$0.errorType = BaseFragment.ErrorType.NETWORK_ERROR;
                this.this$0.isError = true;
                PreSaleListFragment preSaleListFragment3 = this.this$0;
                NetworkState value3 = PreSaleListFragment.access$getViewModel$p(preSaleListFragment3).getNetworkState().getValue();
                if (value3 != null) {
                    str = value3.getMsg();
                }
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                preSaleListFragment3.addHeaderToAuctionSalesList(str);
                PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).submitList(pagedList);
            }
        }
    }
}

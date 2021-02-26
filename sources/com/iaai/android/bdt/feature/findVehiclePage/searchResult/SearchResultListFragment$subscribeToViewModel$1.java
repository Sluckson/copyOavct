package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "pagedList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultListFragment.kt */
final class SearchResultListFragment$subscribeToViewModel$1<T> implements Observer<PagedList<Vehicle>> {
    final /* synthetic */ SearchResultListFragment this$0;

    SearchResultListFragment$subscribeToViewModel$1(SearchResultListFragment searchResultListFragment) {
        this.this$0 = searchResultListFragment;
    }

    public final void onChanged(PagedList<Vehicle> pagedList) {
        Vehicle vehicle;
        Vehicle vehicle2;
        Boolean isWatching;
        Log.e("FastSearchResponse", new Gson().toJson((Object) pagedList));
        String str = null;
        if (pagedList != null && pagedList.size() == 0) {
            this.this$0.isSingleSearchProductDeatil = false;
            this.this$0.errorType = BaseFragment.ErrorType.NO_SEARCH_RESULT;
            this.this$0.isError = true;
            this.this$0.totalCount = 0;
            this.this$0.setToolBarTitle();
            this.this$0.addHeaderToAuctionSalesList("");
            this.this$0.showLoadingIndicator(false);
            if (this.this$0.isTablet()) {
                Bundle bundle = new Bundle();
                SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).setSelectedItemForTablet(34567845);
                SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).notifyDataSetChanged();
                bundle.putString(Constants.EXTRA_ITEM_ID, "34567845");
                Fragment findFragmentById = this.this$0.getChildFragmentManager().findFragmentById(C2723R.C2726id.auction_sales_nav_container);
                if (findFragmentById != null) {
                    NavHostFragment navHostFragment = (NavHostFragment) findFragmentById;
                    navHostFragment.getNavController().popBackStack();
                    navHostFragment.getNavController().navigate((int) C2723R.C2726id.PDFragment, bundle);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
                }
            }
        } else if (pagedList.size() == 1) {
            this.this$0.isSingleSearchProductDeatil = true;
            this.this$0.navigateToProductDetailsPageForSingle(pagedList.get(0), 0);
        } else {
            this.this$0.isSingleSearchProductDeatil = false;
            this.this$0.isError = false;
            SearchResultListFragment searchResultListFragment = this.this$0;
            int access$getCurrentCount$p = searchResultListFragment.currentCount;
            Integer valueOf = pagedList != null ? Integer.valueOf(pagedList.size()) : null;
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            searchResultListFragment.currentCount = access$getCurrentCount$p + valueOf.intValue();
            this.this$0.addHeaderToAuctionSalesList("");
            if (pagedList != null) {
                for (Vehicle vehicle3 : pagedList) {
                    SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).setWatchingData((vehicle3 == null || (isWatching = vehicle3.isWatching()) == null) ? false : isWatching.booleanValue(), vehicle3 != null ? vehicle3.getItemId() : 0);
                }
            }
            SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).submitList((PagedList) null);
            SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).notifyDataSetChanged();
            SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).submitList(pagedList);
            SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).notifyDataSetChanged();
            if (this.this$0.isTablet()) {
                String valueOf2 = String.valueOf((pagedList == null || (vehicle2 = pagedList.get(0)) == null) ? null : Integer.valueOf(vehicle2.getItemId()));
                Bundle bundle2 = new Bundle();
                SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).setSelectedItemForTablet((pagedList == null || (vehicle = pagedList.get(0)) == null) ? null : Integer.valueOf(vehicle.getItemId()));
                SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).notifyDataSetChanged();
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
            if (pagedList.size() < 3 || this.this$0.isTablet()) {
                this.this$0.showLoadingIndicator(false);
            }
        }
        NetworkState value = SearchResultListFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
        if ((value != null ? value.getStatus() : null) == NetworkState.Status.FAILED) {
            this.this$0.errorType = BaseFragment.ErrorType.NETWORK_ERROR;
            this.this$0.isError = true;
            SearchResultListFragment searchResultListFragment2 = this.this$0;
            NetworkState value2 = SearchResultListFragment.access$getViewModel$p(searchResultListFragment2).getNetworkState().getValue();
            if (value2 != null) {
                str = value2.getMsg();
            }
            if (str == null) {
                Intrinsics.throwNpe();
            }
            searchResultListFragment2.addHeaderToAuctionSalesList(str);
            SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).submitList(pagedList);
            SearchResultListFragment.access$getSearchReultListAdapter$p(this.this$0).notifyDataSetChanged();
            this.this$0.showLoadingIndicator(false);
        }
    }
}

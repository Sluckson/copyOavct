package com.iaai.android.bdt.feature.account.buyNowOfferList;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListModel;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "pagedList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListFragment.kt */
final class BuyNowOfferListFragment$subscribeToViewModel$2<T> implements Observer<PagedList<BuyNowOfferListModel>> {
    final /* synthetic */ BuyNowOfferListFragment this$0;

    BuyNowOfferListFragment$subscribeToViewModel$2(BuyNowOfferListFragment buyNowOfferListFragment) {
        this.this$0 = buyNowOfferListFragment;
    }

    public final void onChanged(PagedList<BuyNowOfferListModel> pagedList) {
        String itemId;
        Log.e(this.this$0.TAG, String.valueOf(pagedList.size()));
        if (pagedList == null || pagedList.size() != 0) {
            this.this$0.isError = false;
        } else {
            this.this$0.errorType = BaseFragment.ErrorType.NO_STOCKS;
            this.this$0.isError = true;
            BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).submitList(pagedList);
            BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).notifyDataSetChanged();
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
        BuyNowOfferListFragment buyNowOfferListFragment = this.this$0;
        int access$getCurrentCount$p = buyNowOfferListFragment.currentCount;
        String str = null;
        Integer valueOf = pagedList != null ? Integer.valueOf(pagedList.size()) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        buyNowOfferListFragment.currentCount = access$getCurrentCount$p + valueOf.intValue();
        this.this$0.addHeaderToAuctionSalesList("");
        if (pagedList == null) {
            Intrinsics.throwNpe();
        }
        if (pagedList.size() > 0) {
            BuyNowOfferListFragment buyNowOfferListFragment2 = this.this$0;
            StringBuilder sb = new StringBuilder();
            BuyNowOfferListModel buyNowOfferListModel = pagedList.get(0);
            sb.append(buyNowOfferListModel != null ? buyNowOfferListModel.getYear() : null);
            sb.append(' ');
            BuyNowOfferListModel buyNowOfferListModel2 = pagedList.get(0);
            sb.append(buyNowOfferListModel2 != null ? buyNowOfferListModel2.getMake() : null);
            sb.append(' ');
            BuyNowOfferListModel buyNowOfferListModel3 = pagedList.get(0);
            sb.append(buyNowOfferListModel3 != null ? buyNowOfferListModel3.getModel() : null);
            buyNowOfferListFragment2.year_make_model = sb.toString();
        }
        NetworkState value = BuyNowOfferListFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
        if ((value != null ? value.getStatus() : null) == NetworkState.Status.SUCCESS) {
            this.this$0.errorType = BaseFragment.ErrorType.NO_STOCKS;
            this.this$0.isError = false;
            BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).submitList(pagedList);
            BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).notifyDataSetChanged();
            if (this.this$0.isTablet()) {
                BuyNowOfferListModel buyNowOfferListModel4 = pagedList.get(0);
                String valueOf2 = String.valueOf(buyNowOfferListModel4 != null ? buyNowOfferListModel4.getItemId() : null);
                Bundle bundle2 = new Bundle();
                BuyNowOfferListModel buyNowOfferListModel5 = pagedList.get(0);
                BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).setSelectedItemForTablet((buyNowOfferListModel5 == null || (itemId = buyNowOfferListModel5.getItemId()) == null) ? null : Long.valueOf(Long.parseLong(itemId)));
                BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).notifyDataSetChanged();
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
            NetworkState value2 = BuyNowOfferListFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
            if ((value2 != null ? value2.getStatus() : null) == NetworkState.Status.FAILED) {
                this.this$0.errorType = BaseFragment.ErrorType.NETWORK_ERROR;
                this.this$0.isError = true;
                BuyNowOfferListFragment buyNowOfferListFragment3 = this.this$0;
                NetworkState value3 = BuyNowOfferListFragment.access$getViewModel$p(buyNowOfferListFragment3).getNetworkState().getValue();
                if (value3 != null) {
                    str = value3.getMsg();
                }
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                buyNowOfferListFragment3.addHeaderToAuctionSalesList(str);
                BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).submitList(pagedList);
            }
        }
    }
}

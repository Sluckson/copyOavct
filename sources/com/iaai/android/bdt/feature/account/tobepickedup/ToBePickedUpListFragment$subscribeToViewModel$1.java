package com.iaai.android.bdt.feature.account.tobepickedup;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "pagedList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpFragment.kt */
final class ToBePickedUpListFragment$subscribeToViewModel$1<T> implements Observer<PagedList<ToBePickedUpVehiclesModel>> {
    final /* synthetic */ ToBePickedUpListFragment this$0;

    ToBePickedUpListFragment$subscribeToViewModel$1(ToBePickedUpListFragment toBePickedUpListFragment) {
        this.this$0 = toBePickedUpListFragment;
    }

    public final void onChanged(PagedList<ToBePickedUpVehiclesModel> pagedList) {
        String itemId;
        Log.e(this.this$0.TAG, String.valueOf(pagedList.size()));
        if (pagedList == null || pagedList.size() != 0) {
            this.this$0.isError = false;
        } else {
            this.this$0.errorType = BaseFragment.ErrorType.NO_STOCKS;
            this.this$0.isError = true;
            ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).submitList(pagedList);
            ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
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
        ToBePickedUpListFragment toBePickedUpListFragment = this.this$0;
        int access$getCurrentCount$p = toBePickedUpListFragment.currentCount;
        String str = null;
        Integer valueOf = pagedList != null ? Integer.valueOf(pagedList.size()) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        toBePickedUpListFragment.currentCount = access$getCurrentCount$p + valueOf.intValue();
        this.this$0.addHeaderToAuctionSalesList("");
        if (pagedList == null) {
            Intrinsics.throwNpe();
        }
        if (pagedList.size() > 0) {
            ToBePickedUpListFragment toBePickedUpListFragment2 = this.this$0;
            StringBuilder sb = new StringBuilder();
            ToBePickedUpVehiclesModel toBePickedUpVehiclesModel = pagedList.get(0);
            sb.append(toBePickedUpVehiclesModel != null ? toBePickedUpVehiclesModel.getYear() : null);
            sb.append(' ');
            ToBePickedUpVehiclesModel toBePickedUpVehiclesModel2 = pagedList.get(0);
            sb.append(toBePickedUpVehiclesModel2 != null ? toBePickedUpVehiclesModel2.getMake() : null);
            sb.append(' ');
            ToBePickedUpVehiclesModel toBePickedUpVehiclesModel3 = pagedList.get(0);
            sb.append(toBePickedUpVehiclesModel3 != null ? toBePickedUpVehiclesModel3.getModel() : null);
            toBePickedUpListFragment2.year_make_model = sb.toString();
        }
        NetworkState value = ToBePickedUpListFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
        if ((value != null ? value.getStatus() : null) == NetworkState.Status.SUCCESS) {
            this.this$0.errorType = BaseFragment.ErrorType.NO_STOCKS;
            this.this$0.isError = false;
            ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).submitList(pagedList);
            ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
            if (this.this$0.isTablet()) {
                ToBePickedUpVehiclesModel toBePickedUpVehiclesModel4 = pagedList.get(0);
                String valueOf2 = String.valueOf(toBePickedUpVehiclesModel4 != null ? toBePickedUpVehiclesModel4.getItemId() : null);
                Bundle bundle2 = new Bundle();
                ToBePickedUpVehiclesModel toBePickedUpVehiclesModel5 = pagedList.get(0);
                ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).setSelectedItemForTablet((toBePickedUpVehiclesModel5 == null || (itemId = toBePickedUpVehiclesModel5.getItemId()) == null) ? null : Long.valueOf(Long.parseLong(itemId)));
                ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
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
            NetworkState value2 = ToBePickedUpListFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
            if ((value2 != null ? value2.getStatus() : null) == NetworkState.Status.FAILED) {
                this.this$0.errorType = BaseFragment.ErrorType.NETWORK_ERROR;
                this.this$0.isError = true;
                ToBePickedUpListFragment toBePickedUpListFragment3 = this.this$0;
                NetworkState value3 = ToBePickedUpListFragment.access$getViewModel$p(toBePickedUpListFragment3).getNetworkState().getValue();
                if (value3 != null) {
                    str = value3.getMsg();
                }
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                toBePickedUpListFragment3.addHeaderToAuctionSalesList(str);
                ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).submitList(pagedList);
            }
        }
    }
}

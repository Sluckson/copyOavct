package com.iaai.android.bdt.feature.account.salesdocument;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import com.iaai.android.bdt.utils.NetworkState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "pagedList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentFragment.kt */
final class SalesDocumentFragment$subscribeToViewModel$2<T> implements Observer<PagedList<SaleDocumentListModel>> {
    final /* synthetic */ SalesDocumentFragment this$0;

    SalesDocumentFragment$subscribeToViewModel$2(SalesDocumentFragment salesDocumentFragment) {
        this.this$0 = salesDocumentFragment;
    }

    public final void onChanged(PagedList<SaleDocumentListModel> pagedList) {
        Log.e(this.this$0.TAG, String.valueOf(pagedList.size()));
        if (pagedList == null || pagedList.size() != 0) {
            this.this$0.isError = false;
        } else {
            this.this$0.errorType = BaseFragment.ErrorType.NO_STOCKS;
            this.this$0.isError = true;
            SalesDocumentFragment.access$getSalesDocumentListAdapter$p(this.this$0).submitList(pagedList);
            SalesDocumentFragment.access$getSalesDocumentListAdapter$p(this.this$0).setTitleStatusTab(this.this$0.getTitleStatus());
            SalesDocumentFragment.access$getSalesDocumentListAdapter$p(this.this$0).notifyDataSetChanged();
        }
        SalesDocumentFragment salesDocumentFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(pagedList, "pagedList");
        salesDocumentFragment.setVehicleList(pagedList);
        SalesDocumentFragment salesDocumentFragment2 = this.this$0;
        salesDocumentFragment2.currentCount = salesDocumentFragment2.currentCount + pagedList.size();
        this.this$0.addHeaderToAuctionSalesList("");
        NetworkState value = SalesDocumentFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
        String str = null;
        if ((value != null ? value.getStatus() : null) == NetworkState.Status.SUCCESS) {
            this.this$0.errorType = BaseFragment.ErrorType.NO_STOCKS;
            this.this$0.isError = false;
            SalesDocumentFragment salesDocumentFragment3 = this.this$0;
            Context context = salesDocumentFragment3.getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
            salesDocumentFragment3.salesDocumentListAdapter = new SalesDocumentListAdapter(context, this.this$0);
            this.this$0.addHeaderToAuctionSalesList("");
            SalesDocumentFragment.access$getSalesDocumentListAdapter$p(this.this$0).setTitleStatusTab(this.this$0.getTitleStatus());
            SalesDocumentFragment.access$getSalesDocumentListAdapter$p(this.this$0).submitList(pagedList);
            SalesDocumentFragment.access$getSalesDocumentListAdapter$p(this.this$0).notifyDataSetChanged();
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C2723R.C2726id.rvSalDocList);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSalDocList");
            recyclerView.setAdapter(SalesDocumentFragment.access$getSalesDocumentListAdapter$p(this.this$0));
        }
        this.this$0.showLoadingIndicator(false);
        if (!this.this$0.isError) {
            NetworkState value2 = SalesDocumentFragment.access$getViewModel$p(this.this$0).getNetworkState().getValue();
            if ((value2 != null ? value2.getStatus() : null) == NetworkState.Status.FAILED) {
                this.this$0.errorType = BaseFragment.ErrorType.NETWORK_ERROR;
                this.this$0.isError = true;
                SalesDocumentFragment salesDocumentFragment4 = this.this$0;
                NetworkState value3 = SalesDocumentFragment.access$getViewModel$p(salesDocumentFragment4).getNetworkState().getValue();
                if (value3 != null) {
                    str = value3.getMsg();
                }
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                salesDocumentFragment4.addHeaderToAuctionSalesList(str);
                SalesDocumentFragment.access$getSalesDocumentListAdapter$p(this.this$0).submitList(pagedList);
            }
        }
    }
}

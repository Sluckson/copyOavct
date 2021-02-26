package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Context;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "pagedList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTToBePaidFragment.kt */
final class BDTToBePaidFragment$subscribeToViewModel$3<T> implements Observer<PagedList<PaymentDue>> {
    final /* synthetic */ BDTToBePaidFragment this$0;

    BDTToBePaidFragment$subscribeToViewModel$3(BDTToBePaidFragment bDTToBePaidFragment) {
        this.this$0 = bDTToBePaidFragment;
    }

    public final void onChanged(PagedList<PaymentDue> pagedList) {
        this.this$0.showLoadingIndicator(false);
        this.this$0.resetUI();
        BDTToBePaidFragment bDTToBePaidFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(pagedList, "pagedList");
        bDTToBePaidFragment.setVehicleList(pagedList);
        BDTToBePaidFragment bDTToBePaidFragment2 = this.this$0;
        bDTToBePaidFragment2.currentCount = bDTToBePaidFragment2.currentCount + pagedList.size();
        String str = "";
        if (pagedList.size() == 0) {
            this.this$0.showEmptyState(true);
            this.this$0.displayError(BaseFragment.ErrorType.NO_STOCKS, str);
        } else {
            this.this$0.showEmptyState(false);
            String access$getPaymentMode$p = BDTToBePaidFragment.access$getPaymentMode$p(this.this$0);
            if (Intrinsics.areEqual((Object) access$getPaymentMode$p, (Object) Constants_MVVM.PaymentMethod.CREDIT_CARD.getValue())) {
                str = this.this$0.getResources().getString(C2723R.string.lbl_bdt_credit_card);
            } else if (Intrinsics.areEqual((Object) access$getPaymentMode$p, (Object) Constants_MVVM.PaymentMethod.PAY_PAL.getValue())) {
                str = this.this$0.getResources().getString(C2723R.string.lbl_pay_pal);
            }
            String str2 = str;
            BDTToBePaidFragment bDTToBePaidFragment3 = this.this$0;
            Context context = bDTToBePaidFragment3.getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
            bDTToBePaidFragment3.vehicleRecyclerViewAdapter = new SelectVehiclesAdapter(context, this.this$0);
            SelectVehiclesAdapter access$getVehicleRecyclerViewAdapter$p = BDTToBePaidFragment.access$getVehicleRecyclerViewAdapter$p(this.this$0);
            Intrinsics.checkExpressionValueIsNotNull(str2, Constants.EXTRA_MODE);
            String valueOf = String.valueOf(this.this$0.totalItemCount);
            String valueOf2 = String.valueOf(this.this$0.totalDueAmount);
            String str3 = this.this$0.getResources().getStringArray(C2723R.array.to_paid_sort_item_list)[this.this$0.lastSelectedSort];
            Intrinsics.checkExpressionValueIsNotNull(str3, "resources.getStringArray…m_list)[lastSelectedSort]");
            access$getVehicleRecyclerViewAdapter$p.setHeaderData(str2, valueOf, valueOf2, str3, this.this$0.getSessionManager().getCurrentSessionFName() + ' ' + this.this$0.getSessionManager().getCurrentSessionLName());
            BDTToBePaidFragment.access$getVehicleRecyclerViewAdapter$p(this.this$0).submitList(pagedList);
            BDTToBePaidFragment.access$getVehicleRecyclerViewAdapter$p(this.this$0).notifyDataSetChanged();
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C2723R.C2726id.rvSelectedVehicle);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSelectedVehicle");
            recyclerView.setAdapter(BDTToBePaidFragment.access$getVehicleRecyclerViewAdapter$p(this.this$0));
        }
        NetworkState value = this.this$0.getViewModel().getNetworkState().getValue();
        String str4 = null;
        if ((value != null ? value.getStatus() : null) == NetworkState.Status.FAILED) {
            this.this$0.showEmptyState(true);
            BDTToBePaidFragment bDTToBePaidFragment4 = this.this$0;
            BaseFragment.ErrorType errorType = BaseFragment.ErrorType.NETWORK_ERROR;
            NetworkState value2 = this.this$0.getViewModel().getNetworkState().getValue();
            if (value2 != null) {
                str4 = value2.getMsg();
            }
            if (str4 == null) {
                Intrinsics.throwNpe();
            }
            bDTToBePaidFragment4.displayError(errorType, str4);
        }
    }
}

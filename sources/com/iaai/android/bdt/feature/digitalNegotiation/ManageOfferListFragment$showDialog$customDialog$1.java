package com.iaai.android.bdt.feature.digitalNegotiation;

import android.app.Dialog;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo66933d2 = {"com/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListFragment$showDialog$customDialog$1", "Lcom/iaai/android/bdt/feature/digitalNegotiation/RaiseBidCallback;", "getRaisedBid", "", "bidvalue", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListFragment.kt */
public final class ManageOfferListFragment$showDialog$customDialog$1 implements RaiseBidCallback {
    final /* synthetic */ ManageOfferListFragment$showDialog$onAlertButtonClick$1 $onAlertButtonClick;
    final /* synthetic */ Ref.LongRef $raisebidAmount;
    final /* synthetic */ ManageOfferListFragment this$0;

    ManageOfferListFragment$showDialog$customDialog$1(ManageOfferListFragment manageOfferListFragment, Ref.LongRef longRef, ManageOfferListFragment$showDialog$onAlertButtonClick$1 manageOfferListFragment$showDialog$onAlertButtonClick$1) {
        this.this$0 = manageOfferListFragment;
        this.$raisebidAmount = longRef;
        this.$onAlertButtonClick = manageOfferListFragment$showDialog$onAlertButtonClick$1;
    }

    public void getRaisedBid(long j) {
        String valueOf = String.valueOf(j);
        this.$raisebidAmount.element = j;
        String string = this.this$0.getResources().getString(C2723R.string.lbl_confirm_bid_amount);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…g.lbl_confirm_bid_amount)");
        String string2 = this.this$0.getResources().getString(C2723R.string.lbl_raise_bid_value, new Object[]{valueOf});
        Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.st…aise_bid_value, bidValue)");
        Dialog showAlertWithTitle = Activity_ExtensionKt.showAlertWithTitle(ManageOfferListFragment.access$getManageOfferListActivity$p(this.this$0), string, string2, C2723R.string.lbl_raise_my_bid, 17039360, this.$onAlertButtonClick);
        if (showAlertWithTitle != null) {
            showAlertWithTitle.show();
        }
    }
}

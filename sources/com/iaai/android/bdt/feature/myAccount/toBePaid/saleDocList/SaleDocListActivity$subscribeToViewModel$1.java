package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.GetSaleDocListResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/GetSaleDocListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocListActivity.kt */
final class SaleDocListActivity$subscribeToViewModel$1<T> implements Observer<GetSaleDocListResponse> {
    final /* synthetic */ SaleDocListActivity this$0;

    SaleDocListActivity$subscribeToViewModel$1(SaleDocListActivity saleDocListActivity) {
        this.this$0 = saleDocListActivity;
    }

    public final void onChanged(GetSaleDocListResponse getSaleDocListResponse) {
        String error;
        boolean z = false;
        this.this$0.showLoadingIndicator(false);
        if (!(getSaleDocListResponse == null || (error = getSaleDocListResponse.getError()) == null)) {
            if (error.length() > 0) {
                z = true;
            }
            if (z) {
                Context_ExtensionKt.showToast(this.this$0, getSaleDocListResponse.getError());
                return;
            }
        }
        this.this$0.filterResponse(getSaleDocListResponse.getTitleInstructionItemList());
        this.this$0.updateRecyclerUI();
    }
}

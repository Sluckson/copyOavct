package com.iaai.android.bdt.feature.account.salesdocument;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "reposne", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentFragment.kt */
final class SalesDocumentFragment$subscribeToViewModel$5<T> implements Observer<SaleDocumentListResponse> {
    final /* synthetic */ SalesDocumentFragment this$0;

    SalesDocumentFragment$subscribeToViewModel$5(SalesDocumentFragment salesDocumentFragment) {
        this.this$0 = salesDocumentFragment;
    }

    public final void onChanged(SaleDocumentListResponse saleDocumentListResponse) {
        if (saleDocumentListResponse != null) {
            this.this$0.setToolbarCount(saleDocumentListResponse.getItemCount());
        }
    }
}

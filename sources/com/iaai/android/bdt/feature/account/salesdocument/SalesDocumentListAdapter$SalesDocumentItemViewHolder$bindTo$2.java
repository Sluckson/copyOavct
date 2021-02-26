package com.iaai.android.bdt.feature.account.salesdocument;

import android.view.View;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentListAdapter.kt */
final class SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$2 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ SalesDocumentListAdapter.SalesDocumentItemViewHolder this$0;

    SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$2(SalesDocumentListAdapter.SalesDocumentItemViewHolder salesDocumentItemViewHolder, int i) {
        this.this$0 = salesDocumentItemViewHolder;
        this.$position = i;
    }

    public final void onClick(View view) {
        SaleDocumentListModel access$getItem = SalesDocumentListAdapter.access$getItem(this.this$0.this$0, this.$position - 1);
        if (access$getItem != null) {
            SaleDocumentListModel access$getItem2 = SalesDocumentListAdapter.access$getItem(this.this$0.this$0, this.$position - 1);
            Boolean valueOf = access$getItem2 != null ? Boolean.valueOf(access$getItem2.isFeeVisible()) : null;
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            access$getItem.setFeeVisible(!valueOf.booleanValue());
        }
        this.this$0.this$0.notifyItemChanged(this.$position, SalesDocumentListAdapter.access$getItem(this.this$0.this$0, this.$position - 1));
    }
}

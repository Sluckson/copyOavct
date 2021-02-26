package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.view.View;
import com.iaai.android.bdt.feature.myAccount.toBePaid.SelectVehiclesAdapter;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SelectVehiclesAdapter.kt */
final class SelectVehiclesAdapter$ToBePaidHeaderViewHolder$bindTo$3 implements View.OnClickListener {
    final /* synthetic */ SelectVehiclesAdapter.ToBePaidHeaderViewHolder this$0;

    SelectVehiclesAdapter$ToBePaidHeaderViewHolder$bindTo$3(SelectVehiclesAdapter.ToBePaidHeaderViewHolder toBePaidHeaderViewHolder) {
        this.this$0 = toBePaidHeaderViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.this$0.toBePaidClickListener.onChangePaymentClick();
    }
}

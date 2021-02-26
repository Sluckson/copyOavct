package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$handlePickUpFedExClick$4 implements View.OnClickListener {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$handlePickUpFedExClick$4(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onClick(View view) {
        InsertRepOrAddFragment.Companion.newInstance(this.this$0, DeliveryMethod.FED_EX).show(this.this$0.getSupportFragmentManager(), "add_representative_dialog_fragment");
    }
}

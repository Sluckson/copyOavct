package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "compoundButton", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "b", "", "onCheckedChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$updateUI$2 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$updateUI$2(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llFedExAccountNo);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llFedExAccountNo");
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llFedExAccountNo);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llFedExAccountNo");
        linearLayout2.setVisibility(8);
    }
}

package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.view.View;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$initializeUI$3 implements View.OnClickListener {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$initializeUI$3(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onClick(View view) {
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivSetForAll);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "ivSetForAll");
        ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivSetForAll);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivSetForAll");
        imageView.setSelected(!imageView2.isSelected());
    }
}

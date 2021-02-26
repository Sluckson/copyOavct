package com.iaai.android.bdt.feature.productDetail;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$initializeUI$18 implements View.OnClickListener {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$initializeUI$18(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onClick(View view) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.rvPartsDetails);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "rvPartsDetails");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.rvPartsLogin);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "rvPartsLogin");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.rvVinDetails);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "rvVinDetails");
        linearLayout3.setVisibility(0);
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.btn_Vehicle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "btn_Vehicle");
        textView.setSelected(true);
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_parts);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_parts");
        textView2.setSelected(false);
        Button button = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnChromeData);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnChromeData");
        button.setVisibility(0);
        TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_parts);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        textView3.setTextColor(ContextCompat.getColor(activity.getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
        TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.btn_Vehicle);
        FragmentActivity activity2 = this.this$0.getActivity();
        if (activity2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity2, "activity!!");
        textView4.setTextColor(ContextCompat.getColor(activity2.getApplicationContext(), C2723R.C2724color.bdt_red));
        this.this$0.updatePartsButtonUI(true, 0);
    }
}

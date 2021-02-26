package com.iaai.android.bdt.feature.productDetail.costCalculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorFragment.kt */
final class CostCalculatorFragment$onActivityCreated$2 implements View.OnClickListener {
    final /* synthetic */ CostCalculatorFragment this$0;

    CostCalculatorFragment$onActivityCreated$2(CostCalculatorFragment costCalculatorFragment) {
        this.this$0 = costCalculatorFragment;
    }

    public final void onClick(View view) {
        Button button = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnRemoveEdit);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnRemoveEdit");
        button.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.linearLayout3);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "linearLayout3");
        linearLayout.setVisibility(8);
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_deliver_transport_lable);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_deliver_transport_lable");
        textView.setVisibility(8);
        CostCalculatorFragment costCalculatorFragment = this.this$0;
        EditText editText = (EditText) costCalculatorFragment._$_findCachedViewById(C2723R.C2726id.txt_zip_code);
        Intrinsics.checkExpressionValueIsNotNull(editText, "txt_zip_code");
        costCalculatorFragment.dropOffzipCode = editText.getText().toString();
        IAASharedPreference.setZipCodeValue(CostCalculatorFragment.access$getBaseActivity$p(this.this$0), this.this$0.dropOffzipCode, this.this$0.itemId);
        AppUtils.hideSoftkeyBoard(CostCalculatorFragment.access$getBaseActivity$p(this.this$0), view);
        this.this$0.checkNetworkConnection();
    }
}

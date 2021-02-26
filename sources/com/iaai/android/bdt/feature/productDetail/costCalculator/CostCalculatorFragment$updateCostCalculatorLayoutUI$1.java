package com.iaai.android.bdt.feature.productDetail.costCalculator;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.iaai.android.C2723R;
import com.lowagie.text.html.HtmlTags;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorFragment$updateCostCalculatorLayoutUI$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorFragment.kt */
public final class CostCalculatorFragment$updateCostCalculatorLayoutUI$1 implements TextWatcher {
    final /* synthetic */ CostCalculatorFragment this$0;

    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkParameterIsNotNull(editable, HtmlTags.f607S);
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, HtmlTags.f607S);
    }

    CostCalculatorFragment$updateCostCalculatorLayoutUI$1(CostCalculatorFragment costCalculatorFragment) {
        this.this$0 = costCalculatorFragment;
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, HtmlTags.f607S);
        String obj = charSequence.toString();
        if (obj != null) {
            if (StringsKt.trim((CharSequence) obj).toString().length() > 0) {
                CostCalculatorFragment costCalculatorFragment = this.this$0;
                String obj2 = charSequence.toString();
                if (obj2 != null) {
                    costCalculatorFragment.bidAmount = StringsKt.trim((CharSequence) obj2).toString();
                    Button button = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnViewEstimate);
                    Intrinsics.checkExpressionValueIsNotNull(button, "btnViewEstimate");
                    button.setEnabled(true);
                    Button button2 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnViewEstimate);
                    Intrinsics.checkExpressionValueIsNotNull(button2, "btnViewEstimate");
                    button2.setAlpha(1.0f);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            Button button3 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnViewEstimate);
            Intrinsics.checkExpressionValueIsNotNull(button3, "btnViewEstimate");
            button3.setAlpha(0.5f);
            Button button4 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnViewEstimate);
            Intrinsics.checkExpressionValueIsNotNull(button4, "btnViewEstimate");
            button4.setEnabled(false);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}

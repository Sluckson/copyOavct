package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.widget.RadioGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "it", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$updateUI$4 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ DeliveryMethodActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeliveryMethodActivity$updateUI$4(DeliveryMethodActivity deliveryMethodActivity) {
        super(1);
        this.this$0 = deliveryMethodActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        boolean z = false;
        if (str.length() == 0) {
            TextInputLayout textInputLayout = (TextInputLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.tlFedexAccountNo);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "tlFedexAccountNo");
            textInputLayout.setErrorEnabled(true);
            TextInputLayout textInputLayout2 = (TextInputLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.tlFedexAccountNo);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "tlFedexAccountNo");
            textInputLayout2.setError(this.this$0.getString(C2723R.string.lbl_error_valid_fedex_accountno));
        } else if (str.length() < 9) {
            TextInputLayout textInputLayout3 = (TextInputLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.tlFedexAccountNo);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout3, "tlFedexAccountNo");
            textInputLayout3.setErrorEnabled(true);
            TextInputLayout textInputLayout4 = (TextInputLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.tlFedexAccountNo);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout4, "tlFedexAccountNo");
            textInputLayout4.setError(this.this$0.getString(C2723R.string.lbl_error_valid_number, new Object[]{"9"}));
        } else {
            TextInputLayout textInputLayout5 = (TextInputLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.tlFedexAccountNo);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout5, "tlFedexAccountNo");
            textInputLayout5.setErrorEnabled(false);
        }
        DeliveryMethodActivity deliveryMethodActivity = this.this$0;
        TextInputLayout textInputLayout6 = (TextInputLayout) deliveryMethodActivity._$_findCachedViewById(C2723R.C2726id.tlFedexAccountNo);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout6, "tlFedexAccountNo");
        deliveryMethodActivity.isAccountValid = !textInputLayout6.isErrorEnabled();
        RadioGroup radioGroup = (RadioGroup) this.this$0._$_findCachedViewById(C2723R.C2726id.rgFedEx);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup, "rgFedEx");
        if (radioGroup.getCheckedRadioButtonId() != -1) {
            TextInputLayout textInputLayout7 = (TextInputLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.tlFedexAccountNo);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout7, "tlFedexAccountNo");
            if (!textInputLayout7.isErrorEnabled()) {
                z = true;
            }
        }
        this.this$0.updateApplyDeliverMethodButton(z);
    }
}

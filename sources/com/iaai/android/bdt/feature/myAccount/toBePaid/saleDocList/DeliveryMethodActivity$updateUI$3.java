package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.widget.RadioGroup;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onCheckedChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$updateUI$3 implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$updateUI$3(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioGroup radioGroup2 = (RadioGroup) this.this$0._$_findCachedViewById(C2723R.C2726id.rgFedEx);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup2, "rgFedEx");
        if (radioGroup2.getCheckedRadioButtonId() != -1) {
            RadioGroup radioGroup3 = (RadioGroup) this.this$0._$_findCachedViewById(C2723R.C2726id.rgContainer);
            Intrinsics.checkExpressionValueIsNotNull(radioGroup3, "rgContainer");
            if (radioGroup3.getCheckedRadioButtonId() != -1) {
                RadioGroup radioGroup4 = (RadioGroup) this.this$0._$_findCachedViewById(C2723R.C2726id.rgContainer);
                Intrinsics.checkExpressionValueIsNotNull(radioGroup4, "rgContainer");
                switch (radioGroup4.getCheckedRadioButtonId()) {
                    case C2723R.C2726id.rbBFA:
                        if (this.this$0.isAccountValid) {
                            this.this$0.updateApplyDeliverMethodButton(true);
                            return;
                        } else {
                            this.this$0.updateApplyDeliverMethodButton(false);
                            return;
                        }
                    case C2723R.C2726id.rbIFA:
                        this.this$0.updateApplyDeliverMethodButton(true);
                        return;
                    default:
                        return;
                }
            }
        }
        this.this$0.updateApplyDeliverMethodButton(false);
    }
}

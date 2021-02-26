package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodActivity;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.MailAddres;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.RepresentativeInfo;
import com.iaai.android.bdt.model.toBePaid.saleDocument.SaveDeliveryRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$initializeUI$2 implements View.OnClickListener {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$initializeUI$2(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onClick(View view) {
        SaveDeliveryRequest saveDeliveryRequest;
        int i = DeliveryMethodActivity.WhenMappings.$EnumSwitchMapping$0[this.this$0.deliveryMode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                RadioGroup radioGroup = (RadioGroup) this.this$0._$_findCachedViewById(C2723R.C2726id.rgFedEx);
                Intrinsics.checkExpressionValueIsNotNull(radioGroup, "rgFedEx");
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioGroup radioGroup2 = (RadioGroup) this.this$0._$_findCachedViewById(C2723R.C2726id.rgContainer);
                Intrinsics.checkExpressionValueIsNotNull(radioGroup2, "rgContainer");
                switch (radioGroup2.getCheckedRadioButtonId()) {
                    case C2723R.C2726id.rbBFA:
                        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etFedexAccountNo);
                        Intrinsics.checkExpressionValueIsNotNull(editText, "etFedexAccountNo");
                        int i2 = checkedRadioButtonId - 1;
                        saveDeliveryRequest = this.this$0.getRequestBodyForSave("BFA", (RepresentativeInfo) null, new MailAddres(editText.getText().toString(), ((MailAddres) this.this$0.mailAddressInfo.get(i2)).getAddress(), ((MailAddres) this.this$0.mailAddressInfo.get(i2)).getBusinessName(), true, ((MailAddres) this.this$0.mailAddressInfo.get(i2)).getPhone(), ((MailAddres) this.this$0.mailAddressInfo.get(i2)).getUseMailingInd()));
                        break;
                    case C2723R.C2726id.rbIFA:
                        int i3 = checkedRadioButtonId - 1;
                        saveDeliveryRequest = this.this$0.getRequestBodyForSave("IFA", (RepresentativeInfo) null, new MailAddres("", ((MailAddres) this.this$0.mailAddressInfo.get(i3)).getAddress(), ((MailAddres) this.this$0.mailAddressInfo.get(i3)).getBusinessName(), true, ((MailAddres) this.this$0.mailAddressInfo.get(i3)).getPhone(), ((MailAddres) this.this$0.mailAddressInfo.get(i3)).getUseMailingInd()));
                        break;
                    default:
                        saveDeliveryRequest = this.this$0.getRequestBodyForSave("", (RepresentativeInfo) null, (MailAddres) null);
                        break;
                }
            } else if (i == 3) {
                saveDeliveryRequest = this.this$0.getRequestBodyForSave("", (RepresentativeInfo) null, (MailAddres) null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            RadioGroup radioGroup3 = (RadioGroup) this.this$0._$_findCachedViewById(C2723R.C2726id.rgPickUp);
            Intrinsics.checkExpressionValueIsNotNull(radioGroup3, "rgPickUp");
            int checkedRadioButtonId2 = radioGroup3.getCheckedRadioButtonId();
            if (checkedRadioButtonId2 == 0) {
                saveDeliveryRequest = this.this$0.getRequestBodyForSave("OPU", (RepresentativeInfo) null, (MailAddres) null);
            } else {
                DeliveryMethodActivity deliveryMethodActivity = this.this$0;
                saveDeliveryRequest = deliveryMethodActivity.getRequestBodyForSave("RPU", (RepresentativeInfo) deliveryMethodActivity.representativeInfo.get(checkedRadioButtonId2 - 1), (MailAddres) null);
            }
        }
        this.this$0.showLoadingIndicator(true);
        this.this$0.getViewModel().applyDeliveryMethods(this.this$0.getAuthString(), "android", saveDeliveryRequest);
    }
}

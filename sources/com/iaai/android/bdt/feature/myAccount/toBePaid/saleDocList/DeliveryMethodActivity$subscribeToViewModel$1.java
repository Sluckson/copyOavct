package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.GetDeliveryMethodResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$subscribeToViewModel$1<T> implements Observer<GetDeliveryMethodResponse> {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$subscribeToViewModel$1(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onChanged(GetDeliveryMethodResponse getDeliveryMethodResponse) {
        this.this$0.showLoadingIndicator(false);
        this.this$0.representativeInfo = new ArrayList(getDeliveryMethodResponse.getTitleHanldingInstructionPickup().getRepresentativeInfo());
        this.this$0.mailAddressInfo = new ArrayList(getDeliveryMethodResponse.getTitleHandlingInstructionMail().getMailAddress());
        if (getDeliveryMethodResponse.getTitleHanldingInstructionPickup().getTitleInstructionTypeCode() != null) {
            this.this$0.titleInstructionTypeCode = getDeliveryMethodResponse.getTitleHanldingInstructionPickup().getTitleInstructionTypeCode();
        }
        if (getDeliveryMethodResponse.getTitleHandlingInstructionMail().getTitleInstructionTypeCode() != null) {
            this.this$0.titleInstructionTypeCode = getDeliveryMethodResponse.getTitleHandlingInstructionMail().getTitleInstructionTypeCode();
        }
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvSetForAll);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvSetForAll");
        textView.setText(this.this$0.getResources().getString(C2723R.string.lbl_apply_method_on_future_stock) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.this$0.getStringForAllBranches());
        this.this$0.initializeOptionsUI();
        this.this$0.updateUI();
        this.this$0.handlePickUpFedExClick();
    }
}

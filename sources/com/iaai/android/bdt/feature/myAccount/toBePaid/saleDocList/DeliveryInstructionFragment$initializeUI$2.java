package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionFragment.kt */
final class DeliveryInstructionFragment$initializeUI$2 implements View.OnClickListener {
    final /* synthetic */ DeliveryInstructionFragment this$0;

    DeliveryInstructionFragment$initializeUI$2(DeliveryInstructionFragment deliveryInstructionFragment) {
        this.this$0 = deliveryInstructionFragment;
    }

    public final void onClick(View view) {
        Collection arrayList = new ArrayList();
        for (Object next : this.this$0.stockList) {
            if (((TitleInstructionItem) next).isSelected()) {
                arrayList.add(next);
            }
        }
        Intent intent = new Intent(DeliveryInstructionFragment.access$getBdtPaymentActivity$p(this.this$0), DeliveryMethodActivity.class);
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_LIST, (ArrayList) ((List) arrayList));
        intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_BRANCH_LIST, Constants_MVVM.SetDeliveryAction.IS_FROM_PAYPAl_LIST.getValue());
        this.this$0.startActivityForResult(intent, 41);
    }
}

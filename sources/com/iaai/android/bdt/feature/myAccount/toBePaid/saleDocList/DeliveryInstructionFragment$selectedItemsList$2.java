package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.os.Bundle;
import com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo66933d2 = {"<anonymous>", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionFragment.kt */
final class DeliveryInstructionFragment$selectedItemsList$2 extends Lambda implements Function0<List<PaymentDue>> {
    final /* synthetic */ DeliveryInstructionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeliveryInstructionFragment$selectedItemsList$2(DeliveryInstructionFragment deliveryInstructionFragment) {
        super(0);
        this.this$0 = deliveryInstructionFragment;
    }

    @Nullable
    public final List<PaymentDue> invoke() {
        ToBePaidReviewFragmentArgs.Companion companion = ToBePaidReviewFragmentArgs.Companion;
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(arguments, "arguments!!");
        PaymentDue[] selectedItemsList = companion.fromBundle(arguments).getSelectedItemsList();
        if (selectedItemsList != null) {
            return ArraysKt.toMutableList((T[]) selectedItemsList);
        }
        return null;
    }
}

package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.os.Bundle;
import com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionFragment.kt */
final class DeliveryInstructionFragment$cdfFee$2 extends Lambda implements Function0<Double> {
    final /* synthetic */ DeliveryInstructionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeliveryInstructionFragment$cdfFee$2(DeliveryInstructionFragment deliveryInstructionFragment) {
        super(0);
        this.this$0 = deliveryInstructionFragment;
    }

    public final double invoke() {
        ToBePaidReviewFragmentArgs.Companion companion = ToBePaidReviewFragmentArgs.Companion;
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(arguments, "arguments!!");
        return (double) companion.fromBundle(arguments).getCdfFee();
    }
}

package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.os.Bundle;
import com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidConfirmationFragmentArgs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidConfirmationFragment.kt */
final class ToBePaidConfirmationFragment$cdfFee$2 extends Lambda implements Function0<Double> {
    final /* synthetic */ ToBePaidConfirmationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToBePaidConfirmationFragment$cdfFee$2(ToBePaidConfirmationFragment toBePaidConfirmationFragment) {
        super(0);
        this.this$0 = toBePaidConfirmationFragment;
    }

    public final double invoke() {
        ToBePaidConfirmationFragmentArgs.Companion companion = ToBePaidConfirmationFragmentArgs.Companion;
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(arguments, "arguments!!");
        return (double) companion.fromBundle(arguments).getCdfFee();
    }
}

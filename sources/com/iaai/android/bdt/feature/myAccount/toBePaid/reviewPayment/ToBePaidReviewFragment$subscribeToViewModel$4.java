package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012F\u0010\u0002\u001aB\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0004\u0012\u00020\u0007 \b* \u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "response", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidReviewFragment.kt */
final class ToBePaidReviewFragment$subscribeToViewModel$4<T> implements Observer<Pair<? extends ArrayList<String>, ? extends Boolean>> {
    final /* synthetic */ ToBePaidReviewFragment this$0;

    ToBePaidReviewFragment$subscribeToViewModel$4(ToBePaidReviewFragment toBePaidReviewFragment) {
        this.this$0 = toBePaidReviewFragment;
    }

    public final void onChanged(Pair<? extends ArrayList<String>, Boolean> pair) {
        PaymentDue paymentDue;
        for (String split$default : (Iterable) pair.getFirst()) {
            for (String split$default2 : StringsKt.split$default((CharSequence) split$default, new String[]{","}, false, 0, 6, (Object) null)) {
                int i = 0;
                String str = (String) StringsKt.split$default((CharSequence) split$default2, new String[]{"~"}, false, 0, 6, (Object) null).get(0);
                List access$getSelectedItemsList$p = this.this$0.getSelectedItemsList();
                if (access$getSelectedItemsList$p != null) {
                    Iterator it = access$getSelectedItemsList$p.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        }
                        PaymentDue paymentDue2 = (PaymentDue) it.next();
                        if (Intrinsics.areEqual((Object) str, (Object) String.valueOf(paymentDue2.getSalvageId())) || Intrinsics.areEqual((Object) str, (Object) String.valueOf(paymentDue2.getSalvageBuyerChargeId())) || Intrinsics.areEqual((Object) str, (Object) String.valueOf(paymentDue2.getBuyerChargeId()))) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                }
                List access$getSelectedItemsList$p2 = this.this$0.getSelectedItemsList();
                if (!(access$getSelectedItemsList$p2 == null || (paymentDue = (PaymentDue) access$getSelectedItemsList$p2.get(i)) == null)) {
                    paymentDue.setPaymentSuccess(pair.getSecond().booleanValue());
                }
            }
        }
    }
}

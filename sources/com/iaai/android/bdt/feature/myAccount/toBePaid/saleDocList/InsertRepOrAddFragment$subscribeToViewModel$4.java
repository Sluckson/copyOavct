package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddFragment.kt */
final class InsertRepOrAddFragment$subscribeToViewModel$4<T> implements Observer<String> {
    final /* synthetic */ InsertRepOrAddFragment this$0;

    InsertRepOrAddFragment$subscribeToViewModel$4(InsertRepOrAddFragment insertRepOrAddFragment) {
        this.this$0 = insertRepOrAddFragment;
    }

    public final void onChanged(String str) {
        this.this$0.showLoadingIndicator(false);
        Intrinsics.checkExpressionValueIsNotNull(str, "it");
        Activity_ExtensionKt.showAlert(InsertRepOrAddFragment.access$getDeliveryMethodActivity$p(this.this$0), "", str);
    }
}

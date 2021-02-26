package com.iaai.android.bdt.feature.digitalNegotiation;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListFragment.kt */
final class ManageOfferListFragment$subscribeToViewModel$2<T> implements Observer<String> {
    final /* synthetic */ ManageOfferListFragment this$0;

    ManageOfferListFragment$subscribeToViewModel$2(ManageOfferListFragment manageOfferListFragment) {
        this.this$0 = manageOfferListFragment;
    }

    public final void onChanged(String str) {
        Context context;
        this.this$0.showLoadingIndicator(false);
        if (this.this$0.isAdded() && (context = this.this$0.getContext()) != null) {
            if (str == null) {
                str = "Unable to process the request";
            }
            Context_ExtensionKt.showToast(context, str);
        }
    }
}

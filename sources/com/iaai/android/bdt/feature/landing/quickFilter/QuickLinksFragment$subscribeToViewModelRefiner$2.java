package com.iaai.android.bdt.feature.landing.quickFilter;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: QuickLinksFragment.kt */
final class QuickLinksFragment$subscribeToViewModelRefiner$2<T> implements Observer<String> {
    final /* synthetic */ QuickLinksFragment this$0;

    QuickLinksFragment$subscribeToViewModelRefiner$2(QuickLinksFragment quickLinksFragment) {
        this.this$0 = quickLinksFragment;
    }

    public final void onChanged(String str) {
        QuickLinksFragment.access$getViewModel$p(this.this$0).getQuickFilter();
    }
}

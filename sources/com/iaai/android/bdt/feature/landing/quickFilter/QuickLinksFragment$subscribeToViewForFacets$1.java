package com.iaai.android.bdt.feature.landing.quickFilter;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.utils.BDTUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "fastSearchresponse", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: QuickLinksFragment.kt */
final class QuickLinksFragment$subscribeToViewForFacets$1<T> implements Observer<FastSearchResponse2> {
    final /* synthetic */ QuickLinksFragment this$0;

    QuickLinksFragment$subscribeToViewForFacets$1(QuickLinksFragment quickLinksFragment) {
        this.this$0 = quickLinksFragment;
    }

    public final void onChanged(FastSearchResponse2 fastSearchResponse2) {
        Intrinsics.checkExpressionValueIsNotNull(fastSearchResponse2, "fastSearchresponse");
        BDTUtils.INSTANCE.updateFacetJson(QuickLinksFragment.access$getBdtLandingPageActivity$p(this.this$0), fastSearchResponse2);
        QuickLinksFragment.access$getViewModel$p(this.this$0).getQuickFilter();
    }
}

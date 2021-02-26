package com.iaai.android.bdt.feature.landing.quickFilter;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "quickFilterList", "", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: QuickLinksFragment.kt */
final class QuickLinksFragment$subscribeToViewModel$2<T> implements Observer<List<? extends QuickFilterResponse>> {
    final /* synthetic */ QuickLinksFragment this$0;

    QuickLinksFragment$subscribeToViewModel$2(QuickLinksFragment quickLinksFragment) {
        this.this$0 = quickLinksFragment;
    }

    public final void onChanged(List<QuickFilterResponse> list) {
        if (list != null && this.this$0.isAdded()) {
            this.this$0.showEmptyState(false);
            this.this$0.displayQuickFilters(list);
        }
    }
}

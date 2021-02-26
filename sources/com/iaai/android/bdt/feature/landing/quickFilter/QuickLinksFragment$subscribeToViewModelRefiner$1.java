package com.iaai.android.bdt.feature.landing.quickFilter;

import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "fastSearchresponse", "Lcom/iaai/android/bdt/model/fastSearch/FastSearchResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: QuickLinksFragment.kt */
final class QuickLinksFragment$subscribeToViewModelRefiner$1<T> implements Observer<FastSearchResponse> {
    final /* synthetic */ QuickLinksFragment this$0;

    QuickLinksFragment$subscribeToViewModelRefiner$1(QuickLinksFragment quickLinksFragment) {
        this.this$0 = quickLinksFragment;
    }

    public final void onChanged(FastSearchResponse fastSearchResponse) {
        Gson gson = new Gson();
        if (fastSearchResponse.getRefiners() != null && (!fastSearchResponse.getRefiners().isEmpty())) {
            String json = gson.toJson((Object) fastSearchResponse.getRefiners());
            IaaiApplication.loadRefinerFirstTime = false;
            IAASharedPreference.setRefinerJson(QuickLinksFragment.access$getBdtLandingPageActivity$p(this.this$0), json);
            this.this$0.setFilterRefinersValues(fastSearchResponse.getRefiners());
            IAASharedPreference.setRefinerTimeStamp(QuickLinksFragment.access$getBdtLandingPageActivity$p(this.this$0), System.currentTimeMillis());
        }
        QuickLinksFragment.access$getViewModel$p(this.this$0).getQuickFilter();
    }
}

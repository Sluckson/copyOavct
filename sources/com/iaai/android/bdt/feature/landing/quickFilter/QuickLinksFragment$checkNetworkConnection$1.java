package com.iaai.android.bdt.feature.landing.quickFilter;

import androidx.lifecycle.Observer;
import com.iaai.android.IaaiApplication;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "status", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: QuickLinksFragment.kt */
final class QuickLinksFragment$checkNetworkConnection$1<T> implements Observer<Boolean> {
    final /* synthetic */ QuickLinksFragment this$0;

    QuickLinksFragment$checkNetworkConnection$1(QuickLinksFragment quickLinksFragment) {
        this.this$0 = quickLinksFragment;
    }

    public final void onChanged(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            if (IaaiApplication.is_new_fast_Search) {
                this.this$0.loadQuickLinkAndFacets();
            } else {
                this.this$0.loadQuickLinkAndRefinerInfo();
            }
        }
    }
}

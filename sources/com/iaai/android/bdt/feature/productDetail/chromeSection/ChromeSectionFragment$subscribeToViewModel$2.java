package com.iaai.android.bdt.feature.productDetail.chromeSection;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.productDetail.chromeSection.ChromeData;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/ChromeData;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ChromeSectionFragment.kt */
final class ChromeSectionFragment$subscribeToViewModel$2<T> implements Observer<ChromeData> {
    final /* synthetic */ ChromeSectionFragment this$0;

    ChromeSectionFragment$subscribeToViewModel$2(ChromeSectionFragment chromeSectionFragment) {
        this.this$0 = chromeSectionFragment;
    }

    public final void onChanged(ChromeData chromeData) {
        if (this.this$0.isAdded()) {
            this.this$0.updateChromeSectionUI(chromeData);
        }
    }
}

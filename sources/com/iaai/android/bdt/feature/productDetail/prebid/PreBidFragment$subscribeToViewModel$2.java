package com.iaai.android.bdt.feature.productDetail.prebid;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidPlacedResult;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidPlacedResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreBidFragment.kt */
final class PreBidFragment$subscribeToViewModel$2<T> implements Observer<PreBidPlacedResult> {
    final /* synthetic */ PreBidFragment this$0;

    PreBidFragment$subscribeToViewModel$2(PreBidFragment preBidFragment) {
        this.this$0 = preBidFragment;
    }

    public final void onChanged(PreBidPlacedResult preBidPlacedResult) {
        if (this.this$0.isAdded()) {
            this.this$0.handlePlaceBidResult(preBidPlacedResult);
        }
    }
}

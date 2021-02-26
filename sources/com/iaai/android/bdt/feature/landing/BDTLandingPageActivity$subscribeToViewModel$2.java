package com.iaai.android.bdt.feature.landing;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.recommendedVehicles.RecommendedVehiclesResponse;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "recommendedVehiclesResponse", "", "Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLandingPageActivity.kt */
final class BDTLandingPageActivity$subscribeToViewModel$2<T> implements Observer<List<? extends RecommendedVehiclesResponse>> {
    final /* synthetic */ BDTLandingPageActivity this$0;

    BDTLandingPageActivity$subscribeToViewModel$2(BDTLandingPageActivity bDTLandingPageActivity) {
        this.this$0 = bDTLandingPageActivity;
    }

    public final void onChanged(List<RecommendedVehiclesResponse> list) {
        if (list != null && (!list.isEmpty())) {
            this.this$0.updateRecommendedVehiclesSection(list);
        }
    }
}

package com.iaai.android.bdt.feature.landing;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.DashBoardDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "dashBoardDestilsResponse", "Lcom/iaai/android/bdt/model/DashBoardDetails;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLandingPageActivity.kt */
final class BDTLandingPageActivity$subscribeToViewModel$1<T> implements Observer<DashBoardDetails> {
    final /* synthetic */ BDTLandingPageActivity this$0;

    BDTLandingPageActivity$subscribeToViewModel$1(BDTLandingPageActivity bDTLandingPageActivity) {
        this.this$0 = bDTLandingPageActivity;
    }

    public final void onChanged(DashBoardDetails dashBoardDetails) {
        BDTLandingPageActivity bDTLandingPageActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(dashBoardDetails, "dashBoardDestilsResponse");
        bDTLandingPageActivity.setDashBoardDetails(dashBoardDetails);
        this.this$0.updateDashBoardCount();
    }
}

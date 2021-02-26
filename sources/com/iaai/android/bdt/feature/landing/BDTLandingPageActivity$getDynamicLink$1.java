package com.iaai.android.bdt.feature.landing;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "pendingDynamicLinkData", "Lcom/google/firebase/dynamiclinks/PendingDynamicLinkData;", "kotlin.jvm.PlatformType", "onSuccess"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLandingPageActivity.kt */
final class BDTLandingPageActivity$getDynamicLink$1<TResult> implements OnSuccessListener<PendingDynamicLinkData> {
    final /* synthetic */ BDTLandingPageActivity this$0;

    BDTLandingPageActivity$getDynamicLink$1(BDTLandingPageActivity bDTLandingPageActivity) {
        this.this$0 = bDTLandingPageActivity;
    }

    public final void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
        this.this$0.handleDeeplink(pendingDynamicLinkData != null ? pendingDynamicLinkData.getLink() : null);
    }
}

package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.p014v1.CampaignProto;
import p011io.reactivex.functions.Function;

/* compiled from: InAppMessageStreamManager */
final /* synthetic */ class InAppMessageStreamManager$$Lambda$7 implements Function {
    private final CampaignProto.ThickContent arg$1;

    private InAppMessageStreamManager$$Lambda$7(CampaignProto.ThickContent thickContent) {
        this.arg$1 = thickContent;
    }

    public static Function lambdaFactory$(CampaignProto.ThickContent thickContent) {
        return new InAppMessageStreamManager$$Lambda$7(thickContent);
    }

    public Object apply(Object obj) {
        return InAppMessageStreamManager.lambda$getContentIfNotRateLimited$24(this.arg$1, (Boolean) obj);
    }
}

package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.p014v1.CampaignProto;
import java.util.Comparator;

/* compiled from: InAppMessageStreamManager */
final /* synthetic */ class InAppMessageStreamManager$$Lambda$10 implements Comparator {
    private static final InAppMessageStreamManager$$Lambda$10 instance = new InAppMessageStreamManager$$Lambda$10();

    private InAppMessageStreamManager$$Lambda$10() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    public int compare(Object obj, Object obj2) {
        return InAppMessageStreamManager.compareByPriority((CampaignProto.ThickContent) obj, (CampaignProto.ThickContent) obj2);
    }
}

package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.FetchEligibleCampaignsResponse;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.InAppMessagingSdkServingGrpc;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@FirebaseAppScope
public class GrpcClient {
    private final InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub stub;

    @Inject
    GrpcClient(InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub inAppMessagingSdkServingBlockingStub) {
        this.stub = inAppMessagingSdkServingBlockingStub;
    }

    public FetchEligibleCampaignsResponse fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
        return ((InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub) this.stub.withDeadlineAfter(30000, TimeUnit.MILLISECONDS)).fetchEligibleCampaigns(fetchEligibleCampaignsRequest);
    }
}

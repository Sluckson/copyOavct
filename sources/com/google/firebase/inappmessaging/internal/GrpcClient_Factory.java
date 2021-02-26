package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.InAppMessagingSdkServingGrpc;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GrpcClient_Factory implements Factory<GrpcClient> {
    private final Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> stubProvider;

    public GrpcClient_Factory(Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> provider) {
        this.stubProvider = provider;
    }

    public GrpcClient get() {
        return new GrpcClient(this.stubProvider.get());
    }

    public static GrpcClient_Factory create(Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> provider) {
        return new GrpcClient_Factory(provider);
    }

    public static GrpcClient newInstance(InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub inAppMessagingSdkServingBlockingStub) {
        return new GrpcClient(inAppMessagingSdkServingBlockingStub);
    }
}

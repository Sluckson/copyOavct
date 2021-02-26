package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForCampaignFactory */
public final class C2365x58415996 implements Factory<ProtoStorageClient> {
    private final Provider<Application> applicationProvider;
    private final ProtoStorageClientModule module;

    public C2365x58415996(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        this.module = protoStorageClientModule;
        this.applicationProvider = provider;
    }

    public ProtoStorageClient get() {
        return providesProtoStorageClientForCampaign(this.module, this.applicationProvider.get());
    }

    public static C2365x58415996 create(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        return new C2365x58415996(protoStorageClientModule, provider);
    }

    public static ProtoStorageClient providesProtoStorageClientForCampaign(ProtoStorageClientModule protoStorageClientModule, Application application) {
        return (ProtoStorageClient) Preconditions.checkNotNull(protoStorageClientModule.providesProtoStorageClientForCampaign(application), "Cannot return null from a non-@Nullable @Provides method");
    }
}

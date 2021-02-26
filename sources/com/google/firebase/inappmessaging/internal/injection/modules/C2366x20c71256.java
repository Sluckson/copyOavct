package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForImpressionStoreFactory */
public final class C2366x20c71256 implements Factory<ProtoStorageClient> {
    private final Provider<Application> applicationProvider;
    private final ProtoStorageClientModule module;

    public C2366x20c71256(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        this.module = protoStorageClientModule;
        this.applicationProvider = provider;
    }

    public ProtoStorageClient get() {
        return providesProtoStorageClientForImpressionStore(this.module, this.applicationProvider.get());
    }

    public static C2366x20c71256 create(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        return new C2366x20c71256(protoStorageClientModule, provider);
    }

    public static ProtoStorageClient providesProtoStorageClientForImpressionStore(ProtoStorageClientModule protoStorageClientModule, Application application) {
        return (ProtoStorageClient) Preconditions.checkNotNull(protoStorageClientModule.providesProtoStorageClientForImpressionStore(application), "Cannot return null from a non-@Nullable @Provides method");
    }
}

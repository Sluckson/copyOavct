package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ProtoStorageClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: com.google.firebase.inappmessaging.internal.injection.modules.ProtoStorageClientModule_ProvidesProtoStorageClientForLimiterStoreFactory */
public final class C2367x2680546d implements Factory<ProtoStorageClient> {
    private final Provider<Application> applicationProvider;
    private final ProtoStorageClientModule module;

    public C2367x2680546d(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        this.module = protoStorageClientModule;
        this.applicationProvider = provider;
    }

    public ProtoStorageClient get() {
        return providesProtoStorageClientForLimiterStore(this.module, this.applicationProvider.get());
    }

    public static C2367x2680546d create(ProtoStorageClientModule protoStorageClientModule, Provider<Application> provider) {
        return new C2367x2680546d(protoStorageClientModule, provider);
    }

    public static ProtoStorageClient providesProtoStorageClientForLimiterStore(ProtoStorageClientModule protoStorageClientModule, Application application) {
        return (ProtoStorageClient) Preconditions.checkNotNull(protoStorageClientModule.providesProtoStorageClientForLimiterStore(application), "Cannot return null from a non-@Nullable @Provides method");
    }
}

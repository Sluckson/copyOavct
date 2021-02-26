package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import p011io.grpc.Channel;
import p011io.grpc.ManagedChannelBuilder;

@Module
public class GrpcChannelModule {
    @Singleton
    @Provides
    @Named("host")
    public String providesServiceHost() {
        return "firebaseinappmessaging.googleapis.com";
    }

    @Singleton
    @Provides
    public Channel providesGrpcChannel(@Named("host") String str) {
        return ManagedChannelBuilder.forTarget(str).build();
    }
}

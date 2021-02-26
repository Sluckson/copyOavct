package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.installations.FirebaseInstallationsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiClientModule_ProvidesFirebaseInstallationsFactory implements Factory<FirebaseInstallationsApi> {
    private final ApiClientModule module;

    public ApiClientModule_ProvidesFirebaseInstallationsFactory(ApiClientModule apiClientModule) {
        this.module = apiClientModule;
    }

    public FirebaseInstallationsApi get() {
        return providesFirebaseInstallations(this.module);
    }

    public static ApiClientModule_ProvidesFirebaseInstallationsFactory create(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvidesFirebaseInstallationsFactory(apiClientModule);
    }

    public static FirebaseInstallationsApi providesFirebaseInstallations(ApiClientModule apiClientModule) {
        return (FirebaseInstallationsApi) Preconditions.checkNotNull(apiClientModule.providesFirebaseInstallations(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

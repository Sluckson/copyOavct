package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiClientModule {
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    public ApiClientModule(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock2) {
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.clock = clock2;
    }

    /* access modifiers changed from: package-private */
    @Provides
    public FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    /* access modifiers changed from: package-private */
    @Provides
    public FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    /* access modifiers changed from: package-private */
    @Provides
    public SharedPreferencesUtils providesSharedPreferencesUtils() {
        return new SharedPreferencesUtils(this.firebaseApp);
    }

    /* access modifiers changed from: package-private */
    @Provides
    public DataCollectionHelper providesDataCollectionHelper(SharedPreferencesUtils sharedPreferencesUtils, Subscriber subscriber) {
        return new DataCollectionHelper(this.firebaseApp, sharedPreferencesUtils, subscriber);
    }

    /* access modifiers changed from: package-private */
    @Provides
    public TestDeviceHelper providesTestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        return new TestDeviceHelper(sharedPreferencesUtils);
    }

    /* access modifiers changed from: package-private */
    @FirebaseAppScope
    @Provides
    public ApiClient providesApiClient(Lazy<GrpcClient> lazy, Application application, ProviderInstaller providerInstaller) {
        return new ApiClient(lazy, this.firebaseApp, application, this.clock, providerInstaller);
    }
}

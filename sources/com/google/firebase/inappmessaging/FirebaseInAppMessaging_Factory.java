package com.google.firebase.inappmessaging;

import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.installations.FirebaseInstallationsApi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FirebaseInAppMessaging_Factory implements Factory<FirebaseInAppMessaging> {
    private final Provider<DataCollectionHelper> dataCollectionHelperProvider;
    private final Provider<DeveloperListenerManager> developerListenerManagerProvider;
    private final Provider<DisplayCallbacksFactory> displayCallbacksFactoryProvider;
    private final Provider<FirebaseInstallationsApi> firebaseInstallationsProvider;
    private final Provider<InAppMessageStreamManager> inAppMessageStreamManagerProvider;
    private final Provider<ProgramaticContextualTriggers> programaticContextualTriggersProvider;

    public FirebaseInAppMessaging_Factory(Provider<InAppMessageStreamManager> provider, Provider<ProgramaticContextualTriggers> provider2, Provider<DataCollectionHelper> provider3, Provider<FirebaseInstallationsApi> provider4, Provider<DisplayCallbacksFactory> provider5, Provider<DeveloperListenerManager> provider6) {
        this.inAppMessageStreamManagerProvider = provider;
        this.programaticContextualTriggersProvider = provider2;
        this.dataCollectionHelperProvider = provider3;
        this.firebaseInstallationsProvider = provider4;
        this.displayCallbacksFactoryProvider = provider5;
        this.developerListenerManagerProvider = provider6;
    }

    public FirebaseInAppMessaging get() {
        return new FirebaseInAppMessaging(this.inAppMessageStreamManagerProvider.get(), this.programaticContextualTriggersProvider.get(), this.dataCollectionHelperProvider.get(), this.firebaseInstallationsProvider.get(), this.displayCallbacksFactoryProvider.get(), this.developerListenerManagerProvider.get());
    }

    public static FirebaseInAppMessaging_Factory create(Provider<InAppMessageStreamManager> provider, Provider<ProgramaticContextualTriggers> provider2, Provider<DataCollectionHelper> provider3, Provider<FirebaseInstallationsApi> provider4, Provider<DisplayCallbacksFactory> provider5, Provider<DeveloperListenerManager> provider6) {
        return new FirebaseInAppMessaging_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static FirebaseInAppMessaging newInstance(InAppMessageStreamManager inAppMessageStreamManager, ProgramaticContextualTriggers programaticContextualTriggers, DataCollectionHelper dataCollectionHelper, FirebaseInstallationsApi firebaseInstallationsApi, DisplayCallbacksFactory displayCallbacksFactory, DeveloperListenerManager developerListenerManager) {
        return new FirebaseInAppMessaging(inAppMessageStreamManager, programaticContextualTriggers, dataCollectionHelper, firebaseInstallationsApi, displayCallbacksFactory, developerListenerManager);
    }
}

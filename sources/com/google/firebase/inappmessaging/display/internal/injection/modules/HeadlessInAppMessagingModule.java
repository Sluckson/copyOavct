package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import dagger.Module;
import dagger.Provides;

@Module
public class HeadlessInAppMessagingModule {
    private final FirebaseInAppMessaging headless;

    public HeadlessInAppMessagingModule(FirebaseInAppMessaging firebaseInAppMessaging) {
        this.headless = firebaseInAppMessaging;
    }

    /* access modifiers changed from: package-private */
    @FirebaseAppScope
    @Provides
    public FirebaseInAppMessaging providesHeadlesssSingleton() {
        return this.headless;
    }
}

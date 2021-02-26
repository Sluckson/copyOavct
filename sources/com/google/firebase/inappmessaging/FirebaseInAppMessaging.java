package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@FirebaseAppScope
public class FirebaseInAppMessaging {
    private boolean areMessagesSuppressed = false;
    private final DataCollectionHelper dataCollectionHelper;
    private final DeveloperListenerManager developerListenerManager;
    private final DisplayCallbacksFactory displayCallbacksFactory;
    private FirebaseInAppMessagingDisplay fiamDisplay;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final InAppMessageStreamManager inAppMessageStreamManager;
    private final ProgramaticContextualTriggers programaticContextualTriggers;

    @Inject
    @VisibleForTesting
    FirebaseInAppMessaging(InAppMessageStreamManager inAppMessageStreamManager2, @ProgrammaticTrigger ProgramaticContextualTriggers programaticContextualTriggers2, DataCollectionHelper dataCollectionHelper2, FirebaseInstallationsApi firebaseInstallationsApi, DisplayCallbacksFactory displayCallbacksFactory2, DeveloperListenerManager developerListenerManager2) {
        this.inAppMessageStreamManager = inAppMessageStreamManager2;
        this.programaticContextualTriggers = programaticContextualTriggers2;
        this.dataCollectionHelper = dataCollectionHelper2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.displayCallbacksFactory = displayCallbacksFactory2;
        this.developerListenerManager = developerListenerManager2;
        firebaseInstallationsApi.getId().addOnSuccessListener(FirebaseInAppMessaging$$Lambda$1.lambdaFactory$());
        inAppMessageStreamManager2.createFirebaseInAppMessageStream().subscribe(FirebaseInAppMessaging$$Lambda$2.lambdaFactory$(this));
    }

    @NonNull
    public static FirebaseInAppMessaging getInstance() {
        return (FirebaseInAppMessaging) FirebaseApp.getInstance().get(FirebaseInAppMessaging.class);
    }

    public boolean isAutomaticDataCollectionEnabled() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    public void setAutomaticDataCollectionEnabled(@Nullable Boolean bool) {
        this.dataCollectionHelper.setAutomaticDataCollectionEnabled(bool);
    }

    public void setAutomaticDataCollectionEnabled(boolean z) {
        this.dataCollectionHelper.setAutomaticDataCollectionEnabled(z);
    }

    public void setMessagesSuppressed(@NonNull Boolean bool) {
        this.areMessagesSuppressed = bool.booleanValue();
    }

    public boolean areMessagesSuppressed() {
        return this.areMessagesSuppressed;
    }

    public void setMessageDisplayComponent(@NonNull FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        Logging.logi("Setting display event component");
        this.fiamDisplay = firebaseInAppMessagingDisplay;
    }

    public void clearDisplayListener() {
        Logging.logi("Removing display event component");
        this.fiamDisplay = null;
    }

    public void addImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.developerListenerManager.addImpressionListener(firebaseInAppMessagingImpressionListener);
    }

    public void addClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.developerListenerManager.addClickListener(firebaseInAppMessagingClickListener);
    }

    public void addDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.developerListenerManager.addDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener);
    }

    public void addImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, @NonNull Executor executor) {
        this.developerListenerManager.addImpressionListener(firebaseInAppMessagingImpressionListener, executor);
    }

    public void addClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, @NonNull Executor executor) {
        this.developerListenerManager.addClickListener(firebaseInAppMessagingClickListener, executor);
    }

    public void addDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, @NonNull Executor executor) {
        this.developerListenerManager.addDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener, executor);
    }

    public void removeImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.developerListenerManager.removeImpressionListener(firebaseInAppMessagingImpressionListener);
    }

    public void removeClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.developerListenerManager.removeClickListener(firebaseInAppMessagingClickListener);
    }

    public void removeDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.developerListenerManager.removeDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeAllListeners() {
        this.developerListenerManager.removeAllListeners();
    }

    public void triggerEvent(@NonNull String str) {
        this.programaticContextualTriggers.triggerEvent(str);
    }

    /* access modifiers changed from: private */
    public void triggerInAppMessage(TriggeredInAppMessage triggeredInAppMessage) {
        FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay = this.fiamDisplay;
        if (firebaseInAppMessagingDisplay != null) {
            firebaseInAppMessagingDisplay.displayMessage(triggeredInAppMessage.getInAppMessage(), this.displayCallbacksFactory.generateDisplayCallback(triggeredInAppMessage.getInAppMessage(), triggeredInAppMessage.getTriggeringEvent()));
        }
    }
}

package com.google.firebase.inappmessaging;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.inappmessaging.model.InAppMessage;

@Keep
public interface FirebaseInAppMessagingDisplay {
    @Keep
    void displayMessage(@NonNull InAppMessage inAppMessage, @NonNull FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks);
}

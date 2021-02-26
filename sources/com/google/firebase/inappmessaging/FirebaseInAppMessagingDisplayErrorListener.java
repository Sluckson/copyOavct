package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

public interface FirebaseInAppMessagingDisplayErrorListener {
    void displayErrorEncountered(@NonNull InAppMessage inAppMessage, @NonNull FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason);
}

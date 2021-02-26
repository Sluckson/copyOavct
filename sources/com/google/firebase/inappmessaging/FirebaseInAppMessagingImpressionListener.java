package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import com.google.firebase.inappmessaging.model.InAppMessage;

public interface FirebaseInAppMessagingImpressionListener {
    void impressionDetected(@NonNull InAppMessage inAppMessage);
}

package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inappmessaging.model.Action;

public interface FirebaseInAppMessagingDisplayCallbacks {

    public enum InAppMessagingDismissType {
        UNKNOWN_DISMISS_TYPE,
        AUTO,
        CLICK,
        SWIPE
    }

    public enum InAppMessagingErrorReason {
        UNSPECIFIED_RENDER_ERROR,
        IMAGE_FETCH_ERROR,
        IMAGE_DISPLAY_ERROR,
        IMAGE_UNSUPPORTED_FORMAT
    }

    @NonNull
    Task<Void> displayErrorEncountered(@NonNull InAppMessagingErrorReason inAppMessagingErrorReason);

    @NonNull
    Task<Void> impressionDetected();

    @NonNull
    Task<Void> messageClicked(@NonNull Action action);

    @NonNull
    Task<Void> messageDismissed(@NonNull InAppMessagingDismissType inAppMessagingDismissType);
}

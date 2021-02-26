package com.iaai.android.old.utils.p016ui;

import android.app.Activity;
import com.google.inject.Inject;
import java.lang.ref.WeakReference;
import roboguice.activity.event.OnPauseEvent;
import roboguice.event.Observes;

/* renamed from: com.iaai.android.old.utils.ui.CloseSoftKeyboardEnforcer */
public class CloseSoftKeyboardEnforcer {
    private final WeakReference<Activity> activityRef;

    @Inject
    CloseSoftKeyboardEnforcer(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
    }

    /* access modifiers changed from: package-private */
    public void closeSoftKeyboard(@Observes OnPauseEvent onPauseEvent) {
        Activity activity = (Activity) this.activityRef.get();
        if (activity != null) {
            ActivityHelper.closeSoftKeyboard(activity);
        }
    }
}

package com.google.firebase.crashlytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

class CrashlyticsAnalyticsListener implements AnalyticsConnector.AnalyticsConnectorListener {
    static final String CRASHLYTICS_ORIGIN = "clx";
    static final String EVENT_NAME_KEY = "name";
    static final String EVENT_ORIGIN_KEY = "_o";
    static final String EVENT_PARAMS_KEY = "params";
    private AnalyticsEventReceiver breadcrumbEventReceiver;
    private AnalyticsEventReceiver crashlyticsOriginEventReceiver;

    CrashlyticsAnalyticsListener() {
    }

    public void setCrashlyticsOriginEventReceiver(@Nullable AnalyticsEventReceiver analyticsEventReceiver) {
        this.crashlyticsOriginEventReceiver = analyticsEventReceiver;
    }

    public void setBreadcrumbEventReceiver(@Nullable AnalyticsEventReceiver analyticsEventReceiver) {
        this.breadcrumbEventReceiver = analyticsEventReceiver;
    }

    public void onMessageTriggered(int i, @Nullable Bundle bundle) {
        String string;
        Logger logger = Logger.getLogger();
        logger.mo33257d("Received Analytics message: " + i + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + bundle);
        if (bundle != null && (string = bundle.getString("name")) != null) {
            Bundle bundle2 = bundle.getBundle(EVENT_PARAMS_KEY);
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            notifyEventReceivers(string, bundle2);
        }
    }

    private void notifyEventReceivers(@NonNull String str, @NonNull Bundle bundle) {
        AnalyticsEventReceiver analyticsEventReceiver;
        if (CRASHLYTICS_ORIGIN.equals(bundle.getString(EVENT_ORIGIN_KEY))) {
            analyticsEventReceiver = this.crashlyticsOriginEventReceiver;
        } else {
            analyticsEventReceiver = this.breadcrumbEventReceiver;
        }
        notifyEventReceiver(analyticsEventReceiver, str, bundle);
    }

    private static void notifyEventReceiver(@Nullable AnalyticsEventReceiver analyticsEventReceiver, @NonNull String str, @NonNull Bundle bundle) {
        if (analyticsEventReceiver != null) {
            analyticsEventReceiver.onEvent(str, bundle);
        }
    }
}

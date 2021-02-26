package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StubAnalyticsConnector implements AnalyticsConnector {
    public static final StubAnalyticsConnector instance = new StubAnalyticsConnector();

    public void clearConditionalUserProperty(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
    }

    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Nullable String str2) {
        return null;
    }

    public int getMaxUserProperties(@NonNull String str) {
        return 0;
    }

    public Map<String, Object> getUserProperties(boolean z) {
        return null;
    }

    public void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle) {
    }

    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
    }

    public void setUserProperty(@NonNull String str, @NonNull String str2, Object obj) {
    }

    private StubAnalyticsConnector() {
    }

    public AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        return AnalyticsConnectorHandle.instance;
    }

    private static class AnalyticsConnectorHandle implements AnalyticsConnector.AnalyticsConnectorHandle {
        static final AnalyticsConnectorHandle instance = new AnalyticsConnectorHandle();

        public void registerEventNames(Set<String> set) {
        }

        public void unregister() {
        }

        public void unregisterEventNames() {
        }

        private AnalyticsConnectorHandle() {
        }
    }
}

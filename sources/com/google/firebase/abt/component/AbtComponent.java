package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-abt@@19.0.1 */
public class AbtComponent {
    @GuardedBy("this")
    private final Map<String, FirebaseABTesting> abtOriginInstances = new HashMap();
    private final AnalyticsConnector analyticsConnector;
    private final Context appContext;

    @VisibleForTesting(otherwise = 3)
    protected AbtComponent(Context context, AnalyticsConnector analyticsConnector2) {
        this.appContext = context;
        this.analyticsConnector = analyticsConnector2;
    }

    public synchronized FirebaseABTesting get(String str) {
        if (!this.abtOriginInstances.containsKey(str)) {
            this.abtOriginInstances.put(str, createAbtInstance(str));
        }
        return this.abtOriginInstances.get(str);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public FirebaseABTesting createAbtInstance(String str) {
        return new FirebaseABTesting(this.appContext, this.analyticsConnector, str);
    }
}

package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import p011io.reactivex.FlowableEmitter;

final class FiamAnalyticsConnectorListener implements AnalyticsConnector.AnalyticsConnectorListener {
    private FlowableEmitter<String> emitter;

    FiamAnalyticsConnectorListener(FlowableEmitter<String> flowableEmitter) {
        this.emitter = flowableEmitter;
    }

    public void onMessageTriggered(int i, Bundle bundle) {
        if (i == 2) {
            this.emitter.onNext(bundle.getString("events"));
        }
    }
}

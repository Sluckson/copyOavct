package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.internal.firebase.inappmessaging.p014v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import p011io.reactivex.BackpressureStrategy;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableEmitter;
import p011io.reactivex.FlowableOnSubscribe;
import p011io.reactivex.flowables.ConnectableFlowable;

public class AnalyticsEventsManager {
    @VisibleForTesting
    static final String TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR = "Too many contextual triggers defined - limiting to 50";
    /* access modifiers changed from: private */
    public final AnalyticsConnector analyticsConnector;
    private final ConnectableFlowable<String> flowable = Flowable.create(new AnalyticsFlowableSubscriber(), BackpressureStrategy.BUFFER).publish();
    /* access modifiers changed from: private */
    public AnalyticsConnector.AnalyticsConnectorHandle handle;

    public AnalyticsEventsManager(AnalyticsConnector analyticsConnector2) {
        this.analyticsConnector = analyticsConnector2;
        this.flowable.connect();
    }

    @Nullable
    public AnalyticsConnector.AnalyticsConnectorHandle getHandle() {
        return this.handle;
    }

    public ConnectableFlowable<String> getAnalyticsEventsFlowable() {
        return this.flowable;
    }

    @VisibleForTesting
    static Set<String> extractAnalyticsEventNames(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        HashSet hashSet = new HashSet();
        for (CampaignProto.ThickContent triggeringConditionsList : fetchEligibleCampaignsResponse.getMessagesList()) {
            for (CommonTypesProto.TriggeringCondition next : triggeringConditionsList.getTriggeringConditionsList()) {
                if (!TextUtils.isEmpty(next.getEvent().getName())) {
                    hashSet.add(next.getEvent().getName());
                }
            }
        }
        if (hashSet.size() > 50) {
            Logging.logi(TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR);
        }
        return hashSet;
    }

    public void updateContextualTriggers(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        Set<String> extractAnalyticsEventNames = extractAnalyticsEventNames(fetchEligibleCampaignsResponse);
        Logging.logd("Updating contextual triggers for the following analytics events: " + extractAnalyticsEventNames);
        this.handle.registerEventNames(extractAnalyticsEventNames);
    }

    private class AnalyticsFlowableSubscriber implements FlowableOnSubscribe<String> {
        AnalyticsFlowableSubscriber() {
        }

        public void subscribe(FlowableEmitter<String> flowableEmitter) {
            Logging.logd("Subscribing to analytics events.");
            AnalyticsEventsManager analyticsEventsManager = AnalyticsEventsManager.this;
            AnalyticsConnector.AnalyticsConnectorHandle unused = analyticsEventsManager.handle = analyticsEventsManager.analyticsConnector.registerAnalyticsConnectorListener("fiam", new FiamAnalyticsConnectorListener(flowableEmitter));
        }
    }
}

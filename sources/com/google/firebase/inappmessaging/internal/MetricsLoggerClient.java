package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.firebase.inappmessaging.DismissType;
import com.google.firebase.inappmessaging.EventType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.RenderErrorReason;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class MetricsLoggerClient {
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType> dismissTransform = new HashMap();
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason> errorTransform = new HashMap();
    private final AnalyticsConnector analyticsConnector;
    private final Clock clock;
    private final DeveloperListenerManager developerListenerManager;
    private final EngagementMetricsLoggerInterface engagementMetricsLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    public interface EngagementMetricsLoggerInterface {
        void logEvent(byte[] bArr);
    }

    static {
        errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR, RenderErrorReason.UNSPECIFIED_RENDER_ERROR);
        errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR, RenderErrorReason.IMAGE_FETCH_ERROR);
        errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_DISPLAY_ERROR, RenderErrorReason.IMAGE_DISPLAY_ERROR);
        errorTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT, RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO, DismissType.AUTO);
        dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK, DismissType.CLICK);
        dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.SWIPE, DismissType.SWIPE);
        dismissTransform.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE, DismissType.UNKNOWN_DISMISS_TYPE);
    }

    public MetricsLoggerClient(EngagementMetricsLoggerInterface engagementMetricsLoggerInterface, AnalyticsConnector analyticsConnector2, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock2, DeveloperListenerManager developerListenerManager2) {
        this.engagementMetricsLogger = engagementMetricsLoggerInterface;
        this.analyticsConnector = analyticsConnector2;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.clock = clock2;
        this.developerListenerManager = developerListenerManager2;
    }

    /* access modifiers changed from: package-private */
    public void logImpression(InAppMessage inAppMessage) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(MetricsLoggerClient$$Lambda$1.lambdaFactory$(this, inAppMessage));
            logEventAsync(inAppMessage, "fiam_impression", impressionCountsAsConversion(inAppMessage));
        }
        this.developerListenerManager.impressionDetected(inAppMessage);
    }

    /* access modifiers changed from: package-private */
    public void logMessageClick(InAppMessage inAppMessage, Action action) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(MetricsLoggerClient$$Lambda$2.lambdaFactory$(this, inAppMessage));
            logEventAsync(inAppMessage, "fiam_action", true);
        }
        this.developerListenerManager.messageClicked(inAppMessage, action);
    }

    /* access modifiers changed from: package-private */
    public void logRenderError(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(MetricsLoggerClient$$Lambda$3.lambdaFactory$(this, inAppMessage, inAppMessagingErrorReason));
        }
        this.developerListenerManager.displayErrorEncountered(inAppMessage, inAppMessagingErrorReason);
    }

    /* access modifiers changed from: package-private */
    public void logDismiss(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(MetricsLoggerClient$$Lambda$4.lambdaFactory$(this, inAppMessage, inAppMessagingDismissType));
            logEventAsync(inAppMessage, "fiam_dismiss", false);
        }
    }

    private CampaignAnalytics createEventEntry(InAppMessage inAppMessage, String str, EventType eventType) {
        return (CampaignAnalytics) createCampaignAnalyticsBuilder(inAppMessage, str).setEventType(eventType).build();
    }

    private CampaignAnalytics createDismissEntry(InAppMessage inAppMessage, String str, DismissType dismissType) {
        return (CampaignAnalytics) createCampaignAnalyticsBuilder(inAppMessage, str).setDismissType(dismissType).build();
    }

    private CampaignAnalytics createRenderErrorEntry(InAppMessage inAppMessage, String str, RenderErrorReason renderErrorReason) {
        return (CampaignAnalytics) createCampaignAnalyticsBuilder(inAppMessage, str).setRenderErrorReason(renderErrorReason).build();
    }

    private CampaignAnalytics.Builder createCampaignAnalyticsBuilder(InAppMessage inAppMessage, String str) {
        return CampaignAnalytics.newBuilder().setFiamSdkVersion("19.0.7").setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).setCampaignId(inAppMessage.getCampaignMetadata().getCampaignId()).setClientApp(ClientAppInfo.newBuilder().setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setFirebaseInstanceId(str)).setClientTimestampMillis(this.clock.now());
    }

    private void logEventAsync(InAppMessage inAppMessage, String str, boolean z) {
        String campaignId = inAppMessage.getCampaignMetadata().getCampaignId();
        Bundle collectAnalyticsParams = collectAnalyticsParams(inAppMessage.getCampaignMetadata().getCampaignName(), campaignId);
        Logging.logd("Sending event=" + str + " params=" + collectAnalyticsParams);
        AnalyticsConnector analyticsConnector2 = this.analyticsConnector;
        if (analyticsConnector2 != null) {
            analyticsConnector2.logEvent("fiam", str, collectAnalyticsParams);
            if (z) {
                AnalyticsConnector analyticsConnector3 = this.analyticsConnector;
                analyticsConnector3.setUserProperty("fiam", AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION, "fiam:" + campaignId);
                return;
            }
            return;
        }
        Logging.logw("Unable to log event: analytics library is missing");
    }

    /* access modifiers changed from: package-private */
    public Bundle collectAnalyticsParams(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_nmid", str2);
        bundle.putString("_nmn", str);
        try {
            bundle.putInt("_ndt", (int) (this.clock.now() / 1000));
        } catch (NumberFormatException e) {
            Logging.logw("Error while parsing use_device_time in FIAM event: " + e.getMessage());
        }
        return bundle;
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$1 */
    static /* synthetic */ class C23431 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = new int[MessageType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.google.firebase.inappmessaging.model.MessageType[] r0 = com.google.firebase.inappmessaging.model.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = r0
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.CARD     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.MODAL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.BANNER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$google$firebase$inappmessaging$model$MessageType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.firebase.inappmessaging.model.MessageType r1 = com.google.firebase.inappmessaging.model.MessageType.IMAGE_ONLY     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.MetricsLoggerClient.C23431.<clinit>():void");
        }
    }

    private boolean impressionCountsAsConversion(InAppMessage inAppMessage) {
        int i = C23431.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        if (i == 1) {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            boolean z = !isValidAction(cardMessage.getPrimaryAction());
            boolean z2 = !isValidAction(cardMessage.getSecondaryAction());
            if (!z || !z2) {
                return false;
            }
            return true;
        } else if (i == 2) {
            return !isValidAction(((ModalMessage) inAppMessage).getAction());
        } else {
            if (i == 3) {
                return !isValidAction(((BannerMessage) inAppMessage).getAction());
            }
            if (i == 4) {
                return !isValidAction(((ImageOnlyMessage) inAppMessage).getAction());
            }
            Logging.loge("Unable to determine if impression should be counted as conversion.");
            return false;
        }
    }

    private boolean isTestCampaign(InAppMessage inAppMessage) {
        return inAppMessage.getCampaignMetadata().getIsTestMessage();
    }

    private boolean isValidAction(@Nullable Action action) {
        return (action == null || action.getActionUrl() == null || action.getActionUrl().isEmpty()) ? false : true;
    }
}

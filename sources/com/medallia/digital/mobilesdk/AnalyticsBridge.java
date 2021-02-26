package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iaai.android.old.utils.constants.Constants;
import com.medallia.digital.mobilesdk.C3433a2;
import com.medallia.digital.mobilesdk.C3815z4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

class AnalyticsBridge extends Observable implements C3713r5 {
    private static final String CLEAR_DATA = "clearData";
    private static final String FORM_LISTENER_VERSION = "formListenerVersion";
    private static final String JSON_ACTION_BUTTONS_ENABLED = "actionButtonsEnabled";
    private static final String JSON_ACTIVITY_NAME = "activityName";
    private static final String JSON_APP_RATING_ID = "appRatingId";
    private static final String JSON_CUSTOM_PARAMETER_NAME = "customParameterName";
    private static final String JSON_CUSTOM_PARAMETER_NAMES = "customParameterNames";
    private static final String JSON_DB_SIZE = "dbSize";
    private static final String JSON_DEFERRED_REASON = "deferredReason";
    private static final String JSON_DELAY = "delay";
    private static final String JSON_DELIVERED_TIMESTAMP = "deliveredTimestamp";
    private static final String JSON_DURATION = "duration";
    private static final String JSON_END_TIME = "endTime";
    private static final String JSON_ENGAGEMENT_TYPE = "engagementType";
    private static final String JSON_ERROR_CODE = "errorCode";
    private static final String JSON_ERROR_MESSAGE = "errorMessage";
    private static final String JSON_FEEDBACK_ID = "feedbackId";
    private static final String JSON_FEEDBACK_UUID = "feedbackUUID";
    private static final String JSON_FILE_PATH = "filePath";
    private static final String JSON_FORMS_RESOURCES_SIZE = "formsResourcesSize";
    private static final String JSON_FORM_ID = "formId";
    private static final String JSON_FORM_LOADING_TIME = "formLoadingTime";
    private static final String JSON_FORM_STATUS = "formStatus";
    private static final String JSON_FORM_TIME_TO_DISPLAY = "timeToDisplay";
    private static final String JSON_FORM_TRIGGER_TYPE = "formTriggerType";
    private static final String JSON_FORM_VIEW_TYPE = "formViewType";
    private static final String JSON_ID = "id";
    private static final String JSON_INITIATOR = "initiator";
    private static final String JSON_INVITATION_SKIPPED_REASON = "invitationSkippedReason";
    private static final String JSON_INVITATION_TYPE = "invitationType";
    private static final String JSON_INVITE_TYPE = "inviteType";
    private static final String JSON_IS_FAST_LOADING_FORM = "isFastLoadingForm";
    private static final String JSON_KILLED_OS_VERSION = "killedOsVersion";
    private static final String JSON_KILLED_SDK_VERSION = "killedSdkVersion";
    private static final String JSON_KILL_SDK_TIMESTAMP = "killSdkTimestamp";
    private static final String JSON_LAST_SUBMIT_TIMESTAMP = "lastSubmitTimestamp";
    private static final String JSON_LOG_LEVEL = "logLevel";
    private static final String JSON_METHOD = "method";
    private static final String JSON_NUMBER_OF_FEEDBACKS = "numberOfFeedbacks";
    private static final String JSON_NUMBER_OF_RETRIES = "numberOfRetries";
    private static final String JSON_PAYLOAD_SIZE = "payloadSizeInKB";
    private static final String JSON_PREVIOUS_SESSION_ID = "previousSessionId";
    private static final String JSON_PRE_INIT = "preInit";
    private static final String JSON_REASON = "reason";
    private static final String JSON_RELOADING_FORM_NUMBER = "reloadingFormNumber";
    private static final String JSON_RESPONSE_CODE = "responseCode";
    private static final String JSON_RESTORE_TIME = "restoreTime";
    private static final String JSON_RESULT_FROM_JS = "resultFromJs";
    private static final String JSON_SESSION_INACTIVITY_TIME = "sessionInactivityTime";
    private static final String JSON_START_TIME = "startTime";
    private static final String JSON_STATUS = "status";
    private static final String JSON_STICKY_MODE = "stickyMode";
    private static final String JSON_SUBMITTED_TIMESTAMP = "submittedTimestamp";
    private static final String JSON_TARGET_ENGINE_SIZE = "targetEngineSize";
    private static final String JSON_TEMPLATES_SIZE = "templatesSize";
    private static final String JSON_TIMESTAMP_LAST_CACHED_DATA = "timestampLastCachedData";
    private static final String JSON_TIME_IN_BACKGROUND = "timeInBackground";
    private static final String JSON_TOTAL_DIRECTORY_SIZE = "totalDirectorySize";
    private static final String JSON_URL = "url";
    private static AnalyticsBridge instance;
    private C3526g analyticsV2Generator = new C3526g();
    private boolean isAnalyticsV2;
    private boolean isFormResourcesReady = false;
    private boolean isSdkRunning;
    private boolean isTreResourceReady = false;
    private ArrayList<C3803z> pendingEvents = new ArrayList<>();
    private ArrayList<C3485e> pendingEventsV2 = new ArrayList<>();
    private HashMap<C3413b, JSONObject> preInitEventsV2 = new HashMap<>();

    /* renamed from: com.medallia.digital.mobilesdk.AnalyticsBridge$a */
    static /* synthetic */ class C3412a {

        /* renamed from: a */
        static final /* synthetic */ int[] f811a = new int[C3413b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.medallia.digital.mobilesdk.AnalyticsBridge$b[] r0 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f811a = r0
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.init     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.initCallback     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.initOfflineMechanism     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.disableIntercept     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.enableIntercept     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.logger     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.setCustomParameter     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.setCustomParameters     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.internalError     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x007a }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.setActivity     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.stopSDK     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.revertStopSDK     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x009e }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.setFormListener     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.setFeedbackListener     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.setInvitationListener     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x00c2 }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.setInterceptListener     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x00ce }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.preloadMechanism     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r0 = f811a     // Catch:{ NoSuchFieldError -> 0x00da }
                com.medallia.digital.mobilesdk.AnalyticsBridge$b r1 = com.medallia.digital.mobilesdk.AnalyticsBridge.C3413b.deleteStorage     // Catch:{ NoSuchFieldError -> 0x00da }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00da }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00da }
            L_0x00da:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.AnalyticsBridge.C3412a.<clinit>():void");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.AnalyticsBridge$b */
    protected enum C3413b {
        init,
        initCallback,
        initOfflineMechanism,
        disableIntercept,
        enableIntercept,
        logger,
        setCustomParameter,
        setCustomParameters,
        internalError,
        crash,
        setActivity,
        stopSDK,
        revertStopSDK,
        setFormListener,
        setFeedbackListener,
        setInvitationListener,
        setInterceptListener,
        preloadMechanism,
        deleteStorage
    }

    /* renamed from: com.medallia.digital.mobilesdk.AnalyticsBridge$c */
    protected enum C3414c {
        f832a,
        failure,
        pending
    }

    AnalyticsBridge() {
    }

    private void deleteStorageV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55399a(jSONObject));
    }

    private void disableInterceptV2() {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55398a());
    }

    private void enableInterceptV2() {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55402b());
    }

    protected static AnalyticsBridge getInstance() {
        if (instance == null) {
            instance = new AnalyticsBridge();
        }
        return instance;
    }

    private void initCallbackV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55415j(jSONObject));
    }

    private void initOfflineMechanismV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55416k(jSONObject));
    }

    private void initV2() {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55404c());
    }

    private void internalErrorV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55418m(jSONObject));
    }

    private void loggerV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55423r(jSONObject));
    }

    private void preloadMechanismV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55424s(jSONObject));
    }

    private void report(C3485e eVar) {
        setChanged();
        notifyObservers(eVar);
    }

    private void report(C3803z zVar) {
        setChanged();
        notifyObservers(zVar);
    }

    private void reportOrStashToPendingV2(C3485e eVar) {
        if (this.isAnalyticsV2 && eVar != null) {
            if (!this.isSdkRunning || !CollectorsInfrastructure.getInstance().isInitialized()) {
                this.pendingEventsV2.add(eVar);
            } else {
                report(eVar);
            }
        }
    }

    private void revertStopSDKV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55385B(jSONObject));
    }

    private void setActivityV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55386C(jSONObject));
    }

    private void setCustomParameterV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55387D(jSONObject));
    }

    private void setCustomParametersV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55388E(jSONObject));
    }

    private void setFeedbackListenerV2() {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55406d());
    }

    private void setFormListenerV2(JSONObject jSONObject) {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55391H(jSONObject));
    }

    private void setInterceptListenerV2() {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55408e());
    }

    private void setInvitationListenerV2() {
        reportOrStashToPendingV2(this.analyticsV2Generator.mo55410f());
    }

    private void stopSDKV2(JSONObject jSONObject) {
        C3782x0.m1872d().mo55912b((C3792y) this.analyticsV2Generator.mo55395L(jSONObject));
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void addObserverToAnalyticsItems(Observer observer) {
        addObserver(observer);
    }

    public void clearAndDisconnect() {
        C3490e3.m659a(AnalyticsBridge.class.getSimpleName());
        deleteObservers();
        this.pendingEvents.clear();
        this.isSdkRunning = false;
        instance = null;
    }

    /* access modifiers changed from: protected */
    public String exportPendingEventsToJson() {
        try {
            if (this.pendingEvents == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<C3803z> it = this.pendingEvents.iterator();
            while (it.hasNext()) {
                C3803z next = it.next();
                if (next.mo55938d() != null) {
                    jSONArray.put(next.mo55938d());
                }
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public String exportPendingV2EventsToJson() {
        try {
            if (this.pendingEventsV2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<C3485e> it = this.pendingEventsV2.iterator();
            while (it.hasNext()) {
                C3485e next = it.next();
                if (next != null) {
                    jSONArray.put(next.toJsonString());
                }
            }
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void initAnalytics(boolean z, C3473d dVar) {
        this.isSdkRunning = true;
        this.isAnalyticsV2 = z;
        this.analyticsV2Generator.mo55401a(dVar);
    }

    /* access modifiers changed from: package-private */
    public void regeneratePreInitV2Events() {
        if (!this.preInitEventsV2.isEmpty()) {
            for (C3413b next : this.preInitEventsV2.keySet()) {
                if (next != null) {
                    switch (C3412a.f811a[next.ordinal()]) {
                        case 1:
                            initV2();
                            break;
                        case 2:
                            initCallbackV2(this.preInitEventsV2.get(C3413b.initCallback));
                            break;
                        case 3:
                            initOfflineMechanismV2(this.preInitEventsV2.get(C3413b.initOfflineMechanism));
                            break;
                        case 4:
                            disableInterceptV2();
                            break;
                        case 5:
                            enableInterceptV2();
                            break;
                        case 6:
                            loggerV2(this.preInitEventsV2.get(C3413b.logger));
                            break;
                        case 7:
                            setCustomParameterV2(this.preInitEventsV2.get(C3413b.setCustomParameter));
                            break;
                        case 8:
                            setCustomParametersV2(this.preInitEventsV2.get(C3413b.setCustomParameters));
                            break;
                        case 9:
                            internalErrorV2(this.preInitEventsV2.get(C3413b.internalError));
                            break;
                        case 10:
                            setActivityV2(this.preInitEventsV2.get(C3413b.setActivity));
                            break;
                        case 11:
                            stopSDKV2(this.preInitEventsV2.get(C3413b.stopSDK));
                            break;
                        case 12:
                            revertStopSDKV2(this.preInitEventsV2.get(C3413b.revertStopSDK));
                            break;
                        case 13:
                            setFormListenerV2(this.preInitEventsV2.get(C3413b.setFormListener));
                            break;
                        case 14:
                            setFeedbackListenerV2();
                            break;
                        case 15:
                            setInvitationListenerV2();
                            break;
                        case 16:
                            setInterceptListenerV2();
                            break;
                        case 17:
                            preloadMechanismV2(this.preInitEventsV2.get(C3413b.preloadMechanism));
                            break;
                        case 18:
                            deleteStorageV2(this.preInitEventsV2.get(C3413b.deleteStorage));
                            break;
                    }
                }
            }
            this.preInitEventsV2.clear();
        }
    }

    public void reportDeleteStorageEvent(String str, boolean z) {
        C3414c cVar;
        if (z) {
            try {
                cVar = C3414c.f832a;
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
                return;
            }
        } else {
            cVar = C3414c.failure;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JSON_FILE_PATH, str);
        jSONObject.put("status", cVar);
        reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "DeleteStorage"));
        if (this.isSdkRunning) {
            if (CollectorsInfrastructure.getInstance().isInitialized()) {
                deleteStorageV2(jSONObject);
                return;
            }
        }
        this.preInitEventsV2.put(C3413b.deleteStorage, jSONObject);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportDisableInterceptEvent() {
        try {
            reportOrStashToPending(new C3803z((JSONObject) null, GroupType.api, Lifetime.Application, "DisableIntercept"));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        if (!this.isSdkRunning || !CollectorsInfrastructure.getInstance().isInitialized()) {
            this.preInitEventsV2.put(C3413b.disableIntercept, (Object) null);
        } else {
            disableInterceptV2();
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportEnableInterceptEvent() {
        try {
            reportOrStashToPending(new C3803z((JSONObject) null, GroupType.api, Lifetime.Application, "EnableIntercept"));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        if (!this.isSdkRunning || !CollectorsInfrastructure.getInstance().isInitialized()) {
            this.preInitEventsV2.put(C3413b.enableIntercept, (Object) null);
        } else {
            enableInterceptV2();
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportFeedbackRetryMechanismEvent(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_NUMBER_OF_FEEDBACKS, i);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "FeedbackRetryMechanism"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55403b(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportFormClosedEvent(String str, FormTriggerType formTriggerType, FormViewType formViewType) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = null;
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, formTriggerType != null ? formTriggerType.toString() : null);
            if (formViewType != null) {
                str2 = formViewType.toString();
            }
            jSONObject.put(JSON_FORM_VIEW_TYPE, str2);
            jSONObject.put(JSON_FORM_ID, str);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "FormClosed"));
            if (this.isAnalyticsV2) {
                reportOrStashToPendingV2(this.analyticsV2Generator.mo55405c(jSONObject));
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportFormDismissedEvent(String str, FormTriggerType formTriggerType, FormViewType formViewType) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = null;
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, formTriggerType != null ? formTriggerType.toString() : null);
            if (formViewType != null) {
                str2 = formViewType.toString();
            }
            jSONObject.put(JSON_FORM_VIEW_TYPE, str2);
            jSONObject.put(JSON_FORM_ID, str);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "FormDismissed"));
            if (this.isAnalyticsV2) {
                reportOrStashToPendingV2(this.analyticsV2Generator.mo55407d(jSONObject));
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportFormDisplayedEvent(String str, FormTriggerType formTriggerType, FormViewType formViewType, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = null;
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, formTriggerType != null ? formTriggerType.toString() : null);
            if (formViewType != null) {
                str2 = formViewType.toString();
            }
            jSONObject.put(JSON_FORM_VIEW_TYPE, str2);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_FORM_TIME_TO_DISPLAY, j);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "FormDisplayed"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55409e(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportFormLoadSpinnerEvent(String str, Long l, FormViewType formViewType, FormTriggerType formTriggerType) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_FORM_VIEW_TYPE, formViewType != null ? formViewType.toString() : null);
            jSONObject.put(JSON_DELAY, l);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, formTriggerType);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "FormLoadSpinner"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55411f(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportFormLoadedEvent(String str, FormTriggerType formTriggerType, long j, FormViewType formViewType, boolean z, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = null;
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, formTriggerType != null ? formTriggerType.toString() : null);
            if (formViewType != null) {
                str2 = formViewType.toString();
            }
            jSONObject.put(JSON_FORM_VIEW_TYPE, str2);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_FORM_LOADING_TIME, j);
            jSONObject.put(JSON_IS_FAST_LOADING_FORM, z ? 1 : 0);
            jSONObject.put(JSON_RELOADING_FORM_NUMBER, i);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "FormLoaded"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55412g(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportFormSubmittedEvent(String str, FormTriggerType formTriggerType, long j, FormViewType formViewType) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = null;
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, formTriggerType != null ? formTriggerType.toString() : null);
            if (formViewType != null) {
                str2 = formViewType.toString();
            }
            jSONObject.put(JSON_FORM_VIEW_TYPE, str2);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_LAST_SUBMIT_TIMESTAMP, j);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "FormSubmitted"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55413h(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportHandleNotificationEvent(String str, FormViewType formViewType, boolean z, C3414c cVar, MDExternalError mDExternalError) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = null;
            jSONObject.put(JSON_FORM_VIEW_TYPE, formViewType != null ? formViewType.toString() : null);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_PRE_INIT, z);
            jSONObject.put("method", cVar != null ? cVar.name() : null);
            jSONObject.put(JSON_ERROR_CODE, mDExternalError != null ? Integer.valueOf(mDExternalError.getErrorCode()) : null);
            if (mDExternalError != null) {
                str2 = mDExternalError.getMessage();
            }
            jSONObject.put(JSON_ERROR_MESSAGE, str2);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.api, Lifetime.Session, "HandleNotification"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55414i(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInitCallbackEvent(C3414c cVar, Integer num, String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", cVar != null ? cVar.name() : null);
            jSONObject.put(JSON_ERROR_CODE, num);
            jSONObject.put(JSON_ERROR_MESSAGE, str);
            jSONObject.put(JSON_DURATION, j);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.callback, Lifetime.Session, "InitCallback"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    initCallbackV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.initCallback, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInitEvent() {
        try {
            reportOrStashToPending(new C3803z((JSONObject) null, GroupType.api, Lifetime.Session, "Init"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    initV2();
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.init, (Object) null);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInitOfflineMechanismEvent(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_TIMESTAMP_LAST_CACHED_DATA, j);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "InitOfflineMechanism"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    initOfflineMechanismV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.initOfflineMechanism, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInterceptMechanismEvent(long j, long j2, String str, Reason reason, C3414c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_START_TIME, j);
            jSONObject.put(JSON_END_TIME, j2);
            jSONObject.put(JSON_FORM_ID, str);
            String str2 = null;
            jSONObject.put(JSON_INVITATION_SKIPPED_REASON, reason == null ? null : reason.name());
            if (cVar != null) {
                str2 = cVar.name();
            }
            jSONObject.put("status", str2);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "InterceptMechanism"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55417l(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInternalErrorEvent(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_ERROR_CODE, i);
            jSONObject.put(JSON_ERROR_MESSAGE, str);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.error, Lifetime.Session, "InternalError"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    internalErrorV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.internalError, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInvitationAcceptedEvent(String str, String str2, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_INVITATION_TYPE, str2);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
            jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
            jSONObject.put(JSON_FORM_ID, str);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "InvitationAccepted"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55419n(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInvitationDeclinedEvent(String str, String str2, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_INVITATION_TYPE, str2);
            jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
            jSONObject.put(JSON_REASON, s2Var.mo55797a());
            jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
            jSONObject.put(JSON_FORM_ID, str);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "InvitationDeclined"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55420o(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInvitationDeferredEvent(String str, String str2, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_INVITATION_TYPE, str2);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
            jSONObject.put(JSON_REASON, s2Var.mo55797a());
            jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "InvitationDeferred"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55421p(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportInvitationDisplayedEvent(String str, String str2, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_INVITATION_TYPE, str2);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
            jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
            reportOrStashToPending(new C3803z(jSONObject, GroupType.feedback, Lifetime.Session, "InvitationDisplayed"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55422q(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void reportLoggerEvent(MDLogLevel mDLogLevel) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_LOG_LEVEL, mDLogLevel != null ? mDLogLevel.toString() : null);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.api, Lifetime.Application, "Logger"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    loggerV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.logger, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public boolean reportMedalliaCrashEventImmediate(String str, long j, String str2, Long l) {
        C3792y zVar;
        try {
            if (!this.isSdkRunning) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_REASON, str);
            jSONObject.put("propertyId", l);
            jSONObject.put(Constants.DEVICEID_HEADER, C3815z4.m2010d().mo55975a(C3815z4.C3816a.DEVICE_ID, (String) null));
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("osName", "Android");
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, BuildConfig.VERSION_NAME);
            if (this.isAnalyticsV2) {
                zVar = this.analyticsV2Generator.mo55400a(jSONObject, str2, j);
                if (zVar == null) {
                    return true;
                }
            } else {
                zVar = new C3803z(jSONObject, GroupType.error, Lifetime.Session, "MedalliaCrash");
            }
            return C3782x0.m1872d().mo55912b(zVar);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void reportOrStashToPending(C3803z zVar) {
        if (!this.isSdkRunning) {
            this.pendingEvents.add(zVar);
        } else {
            report(zVar);
        }
    }

    /* access modifiers changed from: protected */
    public void reportPreInitEvents() {
        if (!this.pendingEvents.isEmpty()) {
            Iterator<C3803z> it = this.pendingEvents.iterator();
            while (it.hasNext()) {
                C3803z next = it.next();
                next.mo55946k();
                report(next);
            }
            this.pendingEvents.clear();
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportPreloadMechanismEvent(long j, long j2, String str, C3433a2.C3434a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_START_TIME, j);
            jSONObject.put(JSON_END_TIME, j2);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_FORM_STATUS, aVar != null ? aVar.name() : null);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "PreloadMechanism"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    preloadMechanismV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.preloadMechanism, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportPromptAcceptedEvent(String str, String str2, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_INVITATION_TYPE, str2);
            jSONObject.put(JSON_APP_RATING_ID, str);
            jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
            jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
            reportOrStashToPending(new C3803z(jSONObject, GroupType.appRating, Lifetime.Session, "PromptAccepted"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55425t(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportPromptDeclinedEvent(String str, String str2, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_INVITATION_TYPE, str2);
            jSONObject.put(JSON_APP_RATING_ID, str);
            jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
            jSONObject.put(JSON_REASON, s2Var.mo55797a());
            jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
            reportOrStashToPending(new C3803z(jSONObject, GroupType.appRating, Lifetime.Session, "PromptDeclined"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55426u(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportPromptDeferredEvent(String str, String str2, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_INVITATION_TYPE, str2);
            jSONObject.put(JSON_APP_RATING_ID, str);
            jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
            jSONObject.put(JSON_REASON, s2Var.mo55797a());
            jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
            reportOrStashToPending(new C3803z(jSONObject, GroupType.appRating, Lifetime.Session, "PromptDeferred"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55427v(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportPromptDisplayedEvent(String str, String str2, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_INVITATION_TYPE, str2);
            jSONObject.put(JSON_APP_RATING_ID, str);
            jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
            jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
            reportOrStashToPending(new C3803z(jSONObject, GroupType.appRating, Lifetime.Session, "PromptDisplayed"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55428w(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportRefreshSessionEvent(long j, long j2, long j3, long j4, String str, C3414c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_START_TIME, j);
            jSONObject.put(JSON_END_TIME, j2);
            jSONObject.put(JSON_TIME_IN_BACKGROUND, j3);
            jSONObject.put(JSON_SESSION_INACTIVITY_TIME, j4);
            jSONObject.put(JSON_PREVIOUS_SESSION_ID, str);
            jSONObject.put("status", cVar != null ? cVar.name() : null);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "RefreshSession"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55429x(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportResourcesSizeEvent() {
        if (!this.isTreResourceReady || !this.isFormResourcesReady) {
            C3490e3.m665e("Can't report ResourcesSizeEvent, Resources not ready yet");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_TARGET_ENGINE_SIZE, C3785x1.m1899e());
            jSONObject.put(JSON_FORMS_RESOURCES_SIZE, C3785x1.m1893c());
            jSONObject.put(JSON_TEMPLATES_SIZE, C3785x1.m1901f());
            jSONObject.put(JSON_TOTAL_DIRECTORY_SIZE, C3785x1.m1890b());
            jSONObject.put(JSON_DB_SIZE, C3782x0.m1872d().mo55909b());
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "ResourcesSize"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55430y(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportRestClientEvent(long j, long j2, String str, int i, int i2, Double d) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_START_TIME, j);
            jSONObject.put(JSON_END_TIME, j2);
            jSONObject.put("url", str);
            jSONObject.put(JSON_RESPONSE_CODE, i);
            jSONObject.put(JSON_NUMBER_OF_RETRIES, i2);
            jSONObject.put(JSON_PAYLOAD_SIZE, d);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "RestClient"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55431z(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void reportRestoreFromKillSDKEvent(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_RESTORE_TIME, j);
            jSONObject.put(JSON_KILL_SDK_TIMESTAMP, C3815z4.m2010d().mo55974a(C3815z4.C3816a.SDK_KILL_TIMESTAMP, 0));
            jSONObject.put(JSON_KILLED_SDK_VERSION, C3815z4.m2010d().mo55975a(C3815z4.C3816a.LAST_SDK_VERSION, (String) null));
            jSONObject.put(JSON_KILLED_OS_VERSION, C3815z4.m2010d().mo55975a(C3815z4.C3816a.LAST_OS_VERSION, (String) null));
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "RestoreFromKillSDK"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55384A(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void reportRevertStopSdkEvent() {
        try {
            JSONObject jSONObject = new JSONObject();
            reportOrStashToPending(new C3803z(jSONObject, GroupType.api, Lifetime.Application, "RevertStopSDK"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    revertStopSDKV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.revertStopSDK, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportSetActivityEvent(Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (activity != null) {
                jSONObject.put(JSON_ACTIVITY_NAME, activity.getClass().getSimpleName());
            }
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "SetActivity"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    setActivityV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.setActivity, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportSetCustomParameterEvent(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(JSON_CUSTOM_PARAMETER_NAME, str);
                reportOrStashToPending(new C3803z(jSONObject, GroupType.api, Lifetime.Application, "SetCustomParameter"));
                if (this.isSdkRunning) {
                    if (CollectorsInfrastructure.getInstance().isInitialized()) {
                        setCustomParameterV2(jSONObject);
                        return;
                    }
                }
                this.preInitEventsV2.put(C3413b.setCustomParameter, jSONObject);
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportSetCustomParametersEvent(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            try {
                if (!hashMap.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(JSON_CUSTOM_PARAMETER_NAMES, hashMap);
                    reportOrStashToPending(new C3803z(jSONObject, GroupType.api, Lifetime.Application, "SetCustomParameters"));
                    if (this.isSdkRunning) {
                        if (CollectorsInfrastructure.getInstance().isInitialized()) {
                            setCustomParametersV2(jSONObject);
                            return;
                        }
                    }
                    this.preInitEventsV2.put(C3413b.setCustomParameters, jSONObject);
                }
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportSetFeedbackCallbackEvent(String str, String str2, FormTriggerType formTriggerType, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put(JSON_FORM_ID, str2);
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, formTriggerType != null ? formTriggerType.toString() : null);
            jSONObject.put(JSON_FEEDBACK_ID, str3);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.callback, Lifetime.Session, "SetFeedbackCallback"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55389F(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportSetFeedbackListenerEvent() {
        try {
            reportOrStashToPending(new C3803z((JSONObject) null, GroupType.api, Lifetime.Application, "SetFeedbackListener"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    setFeedbackListenerV2();
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.setFeedbackListener, (Object) null);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportSetFormCallbackEvent(String str, String str2, FormTriggerType formTriggerType) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put(JSON_FORM_ID, str2);
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, formTriggerType != null ? formTriggerType.toString() : null);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.callback, Lifetime.Session, "SetFormCallback"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55390G(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportSetFormListenerEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FORM_LISTENER_VERSION, str);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.api, Lifetime.Application, "SetFormListener"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    setFormListenerV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.setFormListener, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void reportSetInterceptCallbackEvent(String str, String str2, String str3, String str4, C3717s2 s2Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put("id", str2);
            jSONObject.put(JSON_INVITE_TYPE, str3);
            jSONObject.put(JSON_ENGAGEMENT_TYPE, str4);
            if (s2Var != null) {
                jSONObject.put(JSON_STICKY_MODE, s2Var.mo55798b());
                jSONObject.put(JSON_ACTION_BUTTONS_ENABLED, s2Var.mo55799c());
                if (s2Var.mo55800d()) {
                    jSONObject.put(JSON_DEFERRED_REASON, s2Var.mo55797a());
                }
            }
            reportOrStashToPending(new C3803z(jSONObject, GroupType.callback, Lifetime.Session, "SetInterceptCallback"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55392I(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void reportSetInterceptListenerEvent() {
        try {
            reportOrStashToPending(new C3803z((JSONObject) null, GroupType.api, Lifetime.Application, "SetInterceptListener"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    setInterceptListenerV2();
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.setInterceptListener, (Object) null);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void reportSetInvitationListenerEvent() {
        try {
            reportOrStashToPending(new C3803z((JSONObject) null, GroupType.api, Lifetime.Application, "SetInvitationListener"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    setInvitationListenerV2();
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.setInvitationListener, (Object) null);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportShowFormCallbackEvent(C3414c cVar, Integer num, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", cVar != null ? cVar.name() : null);
            jSONObject.put(JSON_ERROR_CODE, num);
            jSONObject.put(JSON_ERROR_MESSAGE, str);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.callback, Lifetime.Session, "ShowFormCallback"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55393J(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportShowFormEvent(String str, FormViewType formViewType, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_FORM_VIEW_TYPE, formViewType != null ? formViewType.toString() : null);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_IS_FAST_LOADING_FORM, z ? 1 : 0);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.api, Lifetime.Session, "ShowForm"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55394K(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void reportStopSDKEventImmidated(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CLEAR_DATA, z);
            C3782x0.m1872d().mo55912b((C3792y) new C3803z(jSONObject, GroupType.api, Lifetime.Application, "StopSDK"));
            if (this.isSdkRunning) {
                if (CollectorsInfrastructure.getInstance().isInitialized()) {
                    stopSDKV2(jSONObject);
                    return;
                }
            }
            this.preInitEventsV2.put(C3413b.stopSDK, jSONObject);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportSubmitFeedbackEvent(C3731t1 t1Var, long j, C3414c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_FEEDBACK_UUID, t1Var.mo55817b() != null ? t1Var.mo55817b() : UUID.randomUUID().toString());
            String str = null;
            jSONObject.put("status", cVar != null ? cVar.name() : null);
            jSONObject.put(JSON_SUBMITTED_TIMESTAMP, t1Var.mo55820e());
            jSONObject.put(JSON_DELIVERED_TIMESTAMP, j);
            jSONObject.put(JSON_NUMBER_OF_RETRIES, t1Var.mo55819d());
            if (t1Var.mo55818c() != null) {
                str = t1Var.mo55818c().toString();
            }
            jSONObject.put(JSON_FORM_TRIGGER_TYPE, str);
            jSONObject.put(JSON_FORM_ID, t1Var.getFormId());
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "SubmitFeedback"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55396M(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public void reportTargetEvaluatorEvent(long j, long j2, String str, C3433a2.C3434a aVar, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_START_TIME, j);
            jSONObject.put(JSON_END_TIME, j2);
            jSONObject.put(JSON_FORM_ID, str);
            jSONObject.put(JSON_FORM_STATUS, aVar != null ? aVar.name() : null);
            jSONObject.put(JSON_RESULT_FROM_JS, str2);
            jSONObject.put(JSON_INITIATOR, str3);
            reportOrStashToPending(new C3803z(jSONObject, GroupType.internalSdk, Lifetime.Session, "TargetEvaluator"));
            reportOrStashToPendingV2(this.analyticsV2Generator.mo55397N(jSONObject));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    public void setFormResourcesReady(boolean z) {
        this.isFormResourcesReady = z;
    }

    public void setTreResourceReady(boolean z) {
        this.isTreResourceReady = z;
    }
}

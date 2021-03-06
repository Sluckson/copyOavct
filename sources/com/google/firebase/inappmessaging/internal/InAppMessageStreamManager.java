package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.internal.firebase.inappmessaging.p014v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.FetchEligibleCampaignsResponse;
import javax.inject.Inject;
import org.reactivestreams.Publisher;
import p011io.reactivex.Flowable;
import p011io.reactivex.Maybe;
import p011io.reactivex.MaybeEmitter;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.Single;
import p011io.reactivex.flowables.ConnectableFlowable;
import p011io.reactivex.functions.Consumer;
import p011io.reactivex.functions.Function;

@FirebaseAppScope
public class InAppMessageStreamManager {
    public static final String ON_FOREGROUND = "ON_FOREGROUND";
    private final AbtIntegrationHelper abtIntegrationHelper;
    private final AnalyticsEventsManager analyticsEventsManager;
    private final ApiClient apiClient;
    private final ConnectableFlowable<String> appForegroundEventFlowable;
    private final RateLimit appForegroundRateLimit;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final ImpressionStorageClient impressionStorageClient;
    private final ConnectableFlowable<String> programmaticTriggerEventFlowable;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final TestDeviceHelper testDeviceHelper;

    static /* synthetic */ CampaignProto.ThickContent lambda$createFirebaseInAppMessageStream$10(CampaignProto.ThickContent thickContent, Boolean bool) throws Exception {
        return thickContent;
    }

    static /* synthetic */ CampaignProto.ThickContent lambda$getContentIfNotRateLimited$24(CampaignProto.ThickContent thickContent, Boolean bool) throws Exception {
        return thickContent;
    }

    @Inject
    public InAppMessageStreamManager(@AppForeground ConnectableFlowable<String> connectableFlowable, @ProgrammaticTrigger ConnectableFlowable<String> connectableFlowable2, CampaignCacheClient campaignCacheClient2, Clock clock2, ApiClient apiClient2, AnalyticsEventsManager analyticsEventsManager2, Schedulers schedulers2, ImpressionStorageClient impressionStorageClient2, RateLimiterClient rateLimiterClient2, @AppForeground RateLimit rateLimit, TestDeviceHelper testDeviceHelper2, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionHelper dataCollectionHelper2, AbtIntegrationHelper abtIntegrationHelper2) {
        this.appForegroundEventFlowable = connectableFlowable;
        this.programmaticTriggerEventFlowable = connectableFlowable2;
        this.campaignCacheClient = campaignCacheClient2;
        this.clock = clock2;
        this.apiClient = apiClient2;
        this.analyticsEventsManager = analyticsEventsManager2;
        this.schedulers = schedulers2;
        this.impressionStorageClient = impressionStorageClient2;
        this.rateLimiterClient = rateLimiterClient2;
        this.appForegroundRateLimit = rateLimit;
        this.testDeviceHelper = testDeviceHelper2;
        this.dataCollectionHelper = dataCollectionHelper2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.abtIntegrationHelper = abtIntegrationHelper2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean containsTriggeringCondition(java.lang.String r4, com.google.internal.firebase.inappmessaging.p014v1.CampaignProto.ThickContent r5) {
        /*
            boolean r0 = isAppForegroundEvent((java.lang.String) r4)
            r1 = 1
            if (r0 == 0) goto L_0x000e
            boolean r0 = r5.getIsTestCampaign()
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            java.util.List r5 = r5.getTriggeringConditionsList()
            java.util.Iterator r5 = r5.iterator()
        L_0x0016:
            boolean r0 = r5.hasNext()
            r2 = 0
            if (r0 == 0) goto L_0x003d
            java.lang.Object r0 = r5.next()
            com.google.firebase.inappmessaging.CommonTypesProto$TriggeringCondition r0 = (com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition) r0
            boolean r3 = hasFiamTrigger(r0, r4)
            if (r3 != 0) goto L_0x002f
            boolean r0 = hasAnalyticsTrigger(r0, r4)
            if (r0 == 0) goto L_0x0016
        L_0x002f:
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r2] = r4
            java.lang.String r4 = "The event %s is contained in the list of triggers"
            java.lang.String r4 = java.lang.String.format(r4, r5)
            com.google.firebase.inappmessaging.internal.Logging.logd(r4)
            return r1
        L_0x003d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager.containsTriggeringCondition(java.lang.String, com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent):boolean");
    }

    private static boolean hasFiamTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getFiamTrigger().toString().equals(str);
    }

    private static boolean hasAnalyticsTrigger(CommonTypesProto.TriggeringCondition triggeringCondition, String str) {
        return triggeringCondition.getEvent().getName().equals(str);
    }

    private static boolean isActive(Clock clock2, CampaignProto.ThickContent thickContent) {
        long j;
        long j2;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            j2 = thickContent.getVanillaPayload().getCampaignStartTimeMillis();
            j = thickContent.getVanillaPayload().getCampaignEndTimeMillis();
        } else if (!thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            return false;
        } else {
            j2 = thickContent.getExperimentalPayload().getCampaignStartTimeMillis();
            j = thickContent.getExperimentalPayload().getCampaignEndTimeMillis();
        }
        long now = clock2.now();
        if (now <= j2 || now >= j) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int compareByPriority(CampaignProto.ThickContent thickContent, CampaignProto.ThickContent thickContent2) {
        if (thickContent.getIsTestCampaign() && !thickContent2.getIsTestCampaign()) {
            return -1;
        }
        if (!thickContent2.getIsTestCampaign() || thickContent.getIsTestCampaign()) {
            return Integer.compare(thickContent.getPriority().getValue(), thickContent2.getPriority().getValue());
        }
        return 1;
    }

    public static boolean isAppForegroundEvent(CommonTypesProto.TriggeringCondition triggeringCondition) {
        return triggeringCondition.getFiamTrigger().toString().equals(ON_FOREGROUND);
    }

    public static boolean isAppForegroundEvent(String str) {
        return str.equals(ON_FOREGROUND);
    }

    private boolean shouldIgnoreCache(String str) {
        if (this.testDeviceHelper.isAppInstallFresh()) {
            return isAppForegroundEvent(str);
        }
        return this.testDeviceHelper.isDeviceInTestMode();
    }

    public Flowable<TriggeredInAppMessage> createFirebaseInAppMessageStream() {
        return Flowable.merge(this.appForegroundEventFlowable, this.analyticsEventsManager.getAnalyticsEventsFlowable(), this.programmaticTriggerEventFlowable).doOnNext(InAppMessageStreamManager$$Lambda$1.lambdaFactory$()).observeOn(this.schedulers.mo34832io()).concatMap(InAppMessageStreamManager$$Lambda$4.lambdaFactory$(this)).observeOn(this.schedulers.mainThread());
    }

    static /* synthetic */ Publisher lambda$createFirebaseInAppMessageStream$21(InAppMessageStreamManager inAppMessageStreamManager, String str) throws Exception {
        Maybe<FetchEligibleCampaignsResponse> onErrorResumeNext = inAppMessageStreamManager.campaignCacheClient.get().doOnSuccess(InAppMessageStreamManager$$Lambda$15.lambdaFactory$()).doOnError(InAppMessageStreamManager$$Lambda$16.lambdaFactory$()).onErrorResumeNext(Maybe.empty());
        Consumer lambdaFactory$ = InAppMessageStreamManager$$Lambda$17.lambdaFactory$(inAppMessageStreamManager);
        Function lambdaFactory$2 = InAppMessageStreamManager$$Lambda$21.lambdaFactory$(inAppMessageStreamManager, str, InAppMessageStreamManager$$Lambda$18.lambdaFactory$(inAppMessageStreamManager), InAppMessageStreamManager$$Lambda$19.lambdaFactory$(inAppMessageStreamManager, str), InAppMessageStreamManager$$Lambda$20.lambdaFactory$());
        Maybe onErrorResumeNext2 = inAppMessageStreamManager.impressionStorageClient.getAllImpressions().doOnError(InAppMessageStreamManager$$Lambda$22.lambdaFactory$()).defaultIfEmpty(CampaignImpressionList.getDefaultInstance()).onErrorResumeNext(Maybe.just(CampaignImpressionList.getDefaultInstance()));
        Function lambdaFactory$3 = InAppMessageStreamManager$$Lambda$24.lambdaFactory$(inAppMessageStreamManager, Maybe.zip(taskToMaybe(inAppMessageStreamManager.firebaseInstallations.getId()), taskToMaybe(inAppMessageStreamManager.firebaseInstallations.getToken(false)), InAppMessageStreamManager$$Lambda$23.lambdaFactory$()).observeOn(inAppMessageStreamManager.schedulers.mo34832io()));
        if (inAppMessageStreamManager.shouldIgnoreCache(str)) {
            Logging.logi(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", new Object[]{Boolean.valueOf(inAppMessageStreamManager.testDeviceHelper.isDeviceInTestMode()), Boolean.valueOf(inAppMessageStreamManager.testDeviceHelper.isAppInstallFresh())}));
            return onErrorResumeNext2.flatMap(lambdaFactory$3).flatMap(lambdaFactory$2).toFlowable();
        }
        Logging.logd("Attempting to fetch campaigns using cache");
        return onErrorResumeNext.switchIfEmpty((MaybeSource<? extends FetchEligibleCampaignsResponse>) onErrorResumeNext2.flatMap(lambdaFactory$3).doOnSuccess(lambdaFactory$)).flatMap(lambdaFactory$2).toFlowable();
    }

    static /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$11(InAppMessageStreamManager inAppMessageStreamManager, CampaignProto.ThickContent thickContent) throws Exception {
        if (thickContent.getIsTestCampaign()) {
            return Maybe.just(thickContent);
        }
        return inAppMessageStreamManager.impressionStorageClient.isImpressed(thickContent).doOnError(InAppMessageStreamManager$$Lambda$32.lambdaFactory$()).onErrorResumeNext(Single.just(false)).doOnSuccess(InAppMessageStreamManager$$Lambda$33.lambdaFactory$(thickContent)).filter(InAppMessageStreamManager$$Lambda$34.lambdaFactory$()).map(InAppMessageStreamManager$$Lambda$35.lambdaFactory$(thickContent));
    }

    static /* synthetic */ boolean lambda$createFirebaseInAppMessageStream$9(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$1 */
    static /* synthetic */ class C23421 {

        /* renamed from: $SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase */
        static final /* synthetic */ int[] f369x95e22605 = new int[MessagesProto.Content.MessageDetailsCase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase[] r0 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f369x95e22605 = r0
                int[] r0 = f369x95e22605     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.BANNER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f369x95e22605     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f369x95e22605     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.MODAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f369x95e22605     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.firebase.inappmessaging.MessagesProto$Content$MessageDetailsCase r1 = com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase.CARD     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager.C23421.<clinit>():void");
        }
    }

    static /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$13(CampaignProto.ThickContent thickContent) throws Exception {
        int i = C23421.f369x95e22605[thickContent.getContent().getMessageDetailsCase().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return Maybe.just(thickContent);
        }
        Logging.logd("Filtering non-displayable message");
        return Maybe.empty();
    }

    static /* synthetic */ Maybe lambda$createFirebaseInAppMessageStream$20(InAppMessageStreamManager inAppMessageStreamManager, Maybe maybe, CampaignImpressionList campaignImpressionList) throws Exception {
        if (!inAppMessageStreamManager.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logi("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return Maybe.just(cacheExpiringResponse());
        }
        Maybe doOnSuccess = maybe.filter(InAppMessageStreamManager$$Lambda$25.lambdaFactory$()).map(InAppMessageStreamManager$$Lambda$26.lambdaFactory$(inAppMessageStreamManager, campaignImpressionList)).switchIfEmpty(Maybe.just(cacheExpiringResponse())).doOnSuccess(InAppMessageStreamManager$$Lambda$27.lambdaFactory$()).doOnSuccess(InAppMessageStreamManager$$Lambda$28.lambdaFactory$(inAppMessageStreamManager));
        AnalyticsEventsManager analyticsEventsManager2 = inAppMessageStreamManager.analyticsEventsManager;
        analyticsEventsManager2.getClass();
        Maybe doOnSuccess2 = doOnSuccess.doOnSuccess(InAppMessageStreamManager$$Lambda$29.lambdaFactory$(analyticsEventsManager2));
        TestDeviceHelper testDeviceHelper2 = inAppMessageStreamManager.testDeviceHelper;
        testDeviceHelper2.getClass();
        return doOnSuccess2.doOnSuccess(InAppMessageStreamManager$$Lambda$30.lambdaFactory$(testDeviceHelper2)).doOnError(InAppMessageStreamManager$$Lambda$31.lambdaFactory$()).onErrorResumeNext(Maybe.empty());
    }

    /* access modifiers changed from: private */
    public Maybe<CampaignProto.ThickContent> getContentIfNotRateLimited(String str, CampaignProto.ThickContent thickContent) {
        if (thickContent.getIsTestCampaign() || !isAppForegroundEvent(str)) {
            return Maybe.just(thickContent);
        }
        return this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit).doOnSuccess(InAppMessageStreamManager$$Lambda$5.lambdaFactory$()).onErrorResumeNext(Single.just(false)).filter(InAppMessageStreamManager$$Lambda$6.lambdaFactory$()).map(InAppMessageStreamManager$$Lambda$7.lambdaFactory$(thickContent));
    }

    static /* synthetic */ boolean lambda$getContentIfNotRateLimited$23(Boolean bool) throws Exception {
        return !bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public static void logImpressionStatus(CampaignProto.ThickContent thickContent, Boolean bool) {
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            Logging.logi(String.format("Already impressed campaign %s ? : %s", new Object[]{thickContent.getVanillaPayload().getCampaignName(), bool}));
        } else if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            Logging.logi(String.format("Already impressed experiment %s ? : %s", new Object[]{thickContent.getExperimentalPayload().getCampaignName(), bool}));
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent, io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent>>] */
    /* JADX WARNING: type inference failed for: r5v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent, io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent>>] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p011io.reactivex.Maybe<com.google.firebase.inappmessaging.model.TriggeredInAppMessage> getTriggeredInAppMessageMaybe(java.lang.String r2, p011io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.p014v1.CampaignProto.ThickContent, p011io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.p014v1.CampaignProto.ThickContent>> r3, p011io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.p014v1.CampaignProto.ThickContent, p011io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.p014v1.CampaignProto.ThickContent>> r4, p011io.reactivex.functions.Function<com.google.internal.firebase.inappmessaging.p014v1.CampaignProto.ThickContent, p011io.reactivex.Maybe<com.google.internal.firebase.inappmessaging.p014v1.CampaignProto.ThickContent>> r5, com.google.internal.firebase.inappmessaging.p014v1.sdkserving.FetchEligibleCampaignsResponse r6) {
        /*
            r1 = this;
            java.util.List r6 = r6.getMessagesList()
            io.reactivex.Flowable r6 = p011io.reactivex.Flowable.fromIterable(r6)
            io.reactivex.functions.Predicate r0 = com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$Lambda$8.lambdaFactory$(r1)
            io.reactivex.Flowable r6 = r6.filter(r0)
            io.reactivex.functions.Predicate r0 = com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$Lambda$9.lambdaFactory$(r2)
            io.reactivex.Flowable r6 = r6.filter(r0)
            io.reactivex.Flowable r3 = r6.flatMapMaybe(r3)
            io.reactivex.Flowable r3 = r3.flatMapMaybe(r4)
            io.reactivex.Flowable r3 = r3.flatMapMaybe(r5)
            java.util.Comparator r4 = com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$Lambda$10.lambdaFactory$()
            io.reactivex.Flowable r3 = r3.sorted(r4)
            io.reactivex.Maybe r3 = r3.firstElement()
            io.reactivex.functions.Function r2 = com.google.firebase.inappmessaging.internal.InAppMessageStreamManager$$Lambda$11.lambdaFactory$(r1, r2)
            io.reactivex.Maybe r2 = r3.flatMap(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.InAppMessageStreamManager.getTriggeredInAppMessageMaybe(java.lang.String, io.reactivex.functions.Function, io.reactivex.functions.Function, io.reactivex.functions.Function, com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse):io.reactivex.Maybe");
    }

    static /* synthetic */ boolean lambda$getTriggeredInAppMessageMaybe$25(InAppMessageStreamManager inAppMessageStreamManager, CampaignProto.ThickContent thickContent) throws Exception {
        return inAppMessageStreamManager.testDeviceHelper.isDeviceInTestMode() || isActive(inAppMessageStreamManager.clock, thickContent);
    }

    /* access modifiers changed from: private */
    public Maybe<TriggeredInAppMessage> triggeredInAppMessage(CampaignProto.ThickContent thickContent, String str) {
        String str2;
        String str3;
        if (thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.VANILLA_PAYLOAD)) {
            str3 = thickContent.getVanillaPayload().getCampaignId();
            str2 = thickContent.getVanillaPayload().getCampaignName();
        } else if (!thickContent.getPayloadCase().equals(CampaignProto.ThickContent.PayloadCase.EXPERIMENTAL_PAYLOAD)) {
            return Maybe.empty();
        } else {
            str3 = thickContent.getExperimentalPayload().getCampaignId();
            str2 = thickContent.getExperimentalPayload().getCampaignName();
            if (!thickContent.getIsTestCampaign()) {
                this.abtIntegrationHelper.setExperimentActive(thickContent.getExperimentalPayload().getExperimentPayload());
            }
        }
        InAppMessage decode = ProtoMarshallerClient.decode(thickContent.getContent(), str3, str2, thickContent.getIsTestCampaign(), thickContent.getDataBundleMap());
        if (decode.getMessageType().equals(MessageType.UNSUPPORTED)) {
            return Maybe.empty();
        }
        return Maybe.just(new TriggeredInAppMessage(decode, str));
    }

    /* access modifiers changed from: private */
    public static boolean validIID(InstallationIdResult installationIdResult) {
        return !TextUtils.isEmpty(installationIdResult.installationId()) && !TextUtils.isEmpty(installationIdResult.installationTokenResult().getToken());
    }

    @VisibleForTesting
    static FetchEligibleCampaignsResponse cacheExpiringResponse() {
        return (FetchEligibleCampaignsResponse) FetchEligibleCampaignsResponse.newBuilder().setExpirationEpochTimestampMillis(1).build();
    }

    private static <T> Maybe<T> taskToMaybe(Task<T> task) {
        return Maybe.create(InAppMessageStreamManager$$Lambda$12.lambdaFactory$(task));
    }

    static /* synthetic */ void lambda$taskToMaybe$30(Task task, MaybeEmitter maybeEmitter) throws Exception {
        task.addOnSuccessListener(InAppMessageStreamManager$$Lambda$13.lambdaFactory$(maybeEmitter));
        task.addOnFailureListener(InAppMessageStreamManager$$Lambda$14.lambdaFactory$(maybeEmitter));
    }

    static /* synthetic */ void lambda$taskToMaybe$28(MaybeEmitter maybeEmitter, Object obj) {
        maybeEmitter.onSuccess(obj);
        maybeEmitter.onComplete();
    }

    static /* synthetic */ void lambda$taskToMaybe$29(MaybeEmitter maybeEmitter, Exception exc) {
        maybeEmitter.onError(exc);
        maybeEmitter.onComplete();
    }
}

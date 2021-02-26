package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging_Factory;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory_Factory;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.GrpcClient_Factory;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager_Factory;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.components.AppComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesApiClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesDataCollectionHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseAppFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesSharedPreferencesUtilsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesTestDeviceHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesApiKeyHeadersFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule_ProvidesMetricsLoggerClientFactory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.InAppMessagingSdkServingGrpc;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import p011io.grpc.Channel;
import p011io.grpc.Metadata;
import p011io.reactivex.flowables.ConnectableFlowable;

public final class DaggerAppComponent implements AppComponent {
    private Provider<AbtIntegrationHelper> abtIntegrationHelperProvider;
    private Provider<AnalyticsConnector> analyticsConnectorProvider;
    private Provider<AnalyticsEventsManager> analyticsEventsManagerProvider;
    private final ApiClientModule apiClientModule;
    private Provider<ConnectableFlowable<String>> appForegroundEventFlowableProvider;
    private Provider<RateLimit> appForegroundRateLimitProvider;
    private Provider<Application> applicationProvider;
    private Provider<CampaignCacheClient> campaignCacheClientProvider;
    private Provider<Clock> clockProvider;
    private Provider<DeveloperListenerManager> developerListenerManagerProvider;
    private Provider<DisplayCallbacksFactory> displayCallbacksFactoryProvider;
    private Provider<Subscriber> firebaseEventsSubscriberProvider;
    private Provider<FirebaseInAppMessaging> firebaseInAppMessagingProvider;
    private Provider<Channel> gRPCChannelProvider;
    private Provider<GrpcClient> grpcClientProvider;
    private Provider<ImpressionStorageClient> impressionStorageClientProvider;
    private Provider<InAppMessageStreamManager> inAppMessageStreamManagerProvider;
    private Provider<ProviderInstaller> probiderInstallerProvider;
    private Provider<ConnectableFlowable<String>> programmaticContextualTriggerFlowableProvider;
    private Provider<ProgramaticContextualTriggers> programmaticContextualTriggersProvider;
    private Provider<ApiClient> providesApiClientProvider;
    private Provider<Metadata> providesApiKeyHeadersProvider;
    private Provider<DataCollectionHelper> providesDataCollectionHelperProvider;
    private Provider<FirebaseApp> providesFirebaseAppProvider;
    private Provider<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
    private Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> providesInAppMessagingSdkServingStubProvider;
    private Provider<MetricsLoggerClient> providesMetricsLoggerClientProvider;
    private Provider<SharedPreferencesUtils> providesSharedPreferencesUtilsProvider;
    private Provider<TestDeviceHelper> providesTestDeviceHelperProvider;
    private Provider<RateLimiterClient> rateLimiterClientProvider;
    private Provider<Schedulers> schedulersProvider;
    private Provider<TransportFactory> transportFactoryProvider;
    private final UniversalComponent universalComponent;

    private DaggerAppComponent(ApiClientModule apiClientModule2, GrpcClientModule grpcClientModule, UniversalComponent universalComponent2, AbtIntegrationHelper abtIntegrationHelper, TransportFactory transportFactory) {
        this.universalComponent = universalComponent2;
        this.apiClientModule = apiClientModule2;
        initialize(apiClientModule2, grpcClientModule, universalComponent2, abtIntegrationHelper, transportFactory);
    }

    public static AppComponent.Builder builder() {
        return new Builder();
    }

    private DataCollectionHelper getDataCollectionHelper() {
        ApiClientModule apiClientModule2 = this.apiClientModule;
        return ApiClientModule_ProvidesDataCollectionHelperFactory.providesDataCollectionHelper(apiClientModule2, ApiClientModule_ProvidesSharedPreferencesUtilsFactory.providesSharedPreferencesUtils(apiClientModule2), (Subscriber) Preconditions.checkNotNull(this.universalComponent.firebaseEventsSubscriber(), "Cannot return null from a non-@Nullable component method"));
    }

    private void initialize(ApiClientModule apiClientModule2, GrpcClientModule grpcClientModule, UniversalComponent universalComponent2, AbtIntegrationHelper abtIntegrationHelper, TransportFactory transportFactory) {
        ApiClientModule apiClientModule3 = apiClientModule2;
        UniversalComponent universalComponent3 = universalComponent2;
        this.appForegroundEventFlowableProvider = new C2348x345a1105(universalComponent3);
        this.programmaticContextualTriggerFlowableProvider = new C2358xa33e14f2(universalComponent3);
        this.campaignCacheClientProvider = new C2351x4d59aff6(universalComponent3);
        this.clockProvider = new C2352x55447107(universalComponent3);
        this.gRPCChannelProvider = new C2355x6b6ee15e(universalComponent3);
        this.providesApiKeyHeadersProvider = GrpcClientModule_ProvidesApiKeyHeadersFactory.create(grpcClientModule);
        this.providesInAppMessagingSdkServingStubProvider = DoubleCheck.provider(GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory.create(grpcClientModule, this.gRPCChannelProvider, this.providesApiKeyHeadersProvider));
        this.grpcClientProvider = DoubleCheck.provider(GrpcClient_Factory.create(this.providesInAppMessagingSdkServingStubProvider));
        this.applicationProvider = new C2350x8bf33b89(universalComponent3);
        this.probiderInstallerProvider = new C2357x8f6097a4(universalComponent3);
        this.providesApiClientProvider = DoubleCheck.provider(ApiClientModule_ProvidesApiClientFactory.create(apiClientModule3, this.grpcClientProvider, this.applicationProvider, this.probiderInstallerProvider));
        this.analyticsEventsManagerProvider = new C2347xbdbce295(universalComponent3);
        this.schedulersProvider = new C2361xd050f5bf(universalComponent3);
        this.impressionStorageClientProvider = new C2356x7d9fb756(universalComponent3);
        this.rateLimiterClientProvider = new C2360x87c20e0c(universalComponent3);
        this.appForegroundRateLimitProvider = new C2349x727a18fe(universalComponent3);
        this.providesSharedPreferencesUtilsProvider = ApiClientModule_ProvidesSharedPreferencesUtilsFactory.create(apiClientModule2);
        this.providesTestDeviceHelperProvider = ApiClientModule_ProvidesTestDeviceHelperFactory.create(apiClientModule3, this.providesSharedPreferencesUtilsProvider);
        this.providesFirebaseInstallationsProvider = ApiClientModule_ProvidesFirebaseInstallationsFactory.create(apiClientModule2);
        this.firebaseEventsSubscriberProvider = new C2354x4a8174ef(universalComponent3);
        this.providesDataCollectionHelperProvider = ApiClientModule_ProvidesDataCollectionHelperFactory.create(apiClientModule3, this.providesSharedPreferencesUtilsProvider, this.firebaseEventsSubscriberProvider);
        this.abtIntegrationHelperProvider = InstanceFactory.create(abtIntegrationHelper);
        this.inAppMessageStreamManagerProvider = DoubleCheck.provider(InAppMessageStreamManager_Factory.create(this.appForegroundEventFlowableProvider, this.programmaticContextualTriggerFlowableProvider, this.campaignCacheClientProvider, this.clockProvider, this.providesApiClientProvider, this.analyticsEventsManagerProvider, this.schedulersProvider, this.impressionStorageClientProvider, this.rateLimiterClientProvider, this.appForegroundRateLimitProvider, this.providesTestDeviceHelperProvider, this.providesFirebaseInstallationsProvider, this.providesDataCollectionHelperProvider, this.abtIntegrationHelperProvider));
        this.programmaticContextualTriggersProvider = new C2359x7c101e69(universalComponent3);
        this.providesFirebaseAppProvider = ApiClientModule_ProvidesFirebaseAppFactory.create(apiClientModule2);
        this.transportFactoryProvider = InstanceFactory.create(transportFactory);
        this.analyticsConnectorProvider = new C2346x92f0170e(universalComponent3);
        this.developerListenerManagerProvider = new C2353x559e6196(universalComponent3);
        this.providesMetricsLoggerClientProvider = DoubleCheck.provider(TransportClientModule_ProvidesMetricsLoggerClientFactory.create(this.providesFirebaseAppProvider, this.transportFactoryProvider, this.analyticsConnectorProvider, this.providesFirebaseInstallationsProvider, this.clockProvider, this.developerListenerManagerProvider));
        this.displayCallbacksFactoryProvider = DisplayCallbacksFactory_Factory.create(this.impressionStorageClientProvider, this.clockProvider, this.schedulersProvider, this.rateLimiterClientProvider, this.campaignCacheClientProvider, this.appForegroundRateLimitProvider, this.providesMetricsLoggerClientProvider, this.providesDataCollectionHelperProvider);
        this.firebaseInAppMessagingProvider = DoubleCheck.provider(FirebaseInAppMessaging_Factory.create(this.inAppMessageStreamManagerProvider, this.programmaticContextualTriggersProvider, this.providesDataCollectionHelperProvider, this.providesFirebaseInstallationsProvider, this.displayCallbacksFactoryProvider, this.developerListenerManagerProvider));
    }

    public FirebaseInAppMessaging providesFirebaseInAppMessaging() {
        return this.firebaseInAppMessagingProvider.get();
    }

    public DisplayCallbacksFactory displayCallbacksFactory() {
        return new DisplayCallbacksFactory((ImpressionStorageClient) Preconditions.checkNotNull(this.universalComponent.impressionStorageClient(), "Cannot return null from a non-@Nullable component method"), (Clock) Preconditions.checkNotNull(this.universalComponent.clock(), "Cannot return null from a non-@Nullable component method"), (Schedulers) Preconditions.checkNotNull(this.universalComponent.schedulers(), "Cannot return null from a non-@Nullable component method"), (RateLimiterClient) Preconditions.checkNotNull(this.universalComponent.rateLimiterClient(), "Cannot return null from a non-@Nullable component method"), (CampaignCacheClient) Preconditions.checkNotNull(this.universalComponent.campaignCacheClient(), "Cannot return null from a non-@Nullable component method"), (RateLimit) Preconditions.checkNotNull(this.universalComponent.appForegroundRateLimit(), "Cannot return null from a non-@Nullable component method"), this.providesMetricsLoggerClientProvider.get(), getDataCollectionHelper());
    }

    private static final class Builder implements AppComponent.Builder {
        private AbtIntegrationHelper abtIntegrationHelper;
        private ApiClientModule apiClientModule;
        private GrpcClientModule grpcClientModule;
        private TransportFactory transportFactory;
        private UniversalComponent universalComponent;

        private Builder() {
        }

        public Builder abtIntegrationHelper(AbtIntegrationHelper abtIntegrationHelper2) {
            this.abtIntegrationHelper = (AbtIntegrationHelper) Preconditions.checkNotNull(abtIntegrationHelper2);
            return this;
        }

        public Builder apiClientModule(ApiClientModule apiClientModule2) {
            this.apiClientModule = (ApiClientModule) Preconditions.checkNotNull(apiClientModule2);
            return this;
        }

        public Builder grpcClientModule(GrpcClientModule grpcClientModule2) {
            this.grpcClientModule = (GrpcClientModule) Preconditions.checkNotNull(grpcClientModule2);
            return this;
        }

        public Builder universalComponent(UniversalComponent universalComponent2) {
            this.universalComponent = (UniversalComponent) Preconditions.checkNotNull(universalComponent2);
            return this;
        }

        public Builder transportFactory(TransportFactory transportFactory2) {
            this.transportFactory = (TransportFactory) Preconditions.checkNotNull(transportFactory2);
            return this;
        }

        public AppComponent build() {
            Preconditions.checkBuilderRequirement(this.abtIntegrationHelper, AbtIntegrationHelper.class);
            Preconditions.checkBuilderRequirement(this.apiClientModule, ApiClientModule.class);
            Preconditions.checkBuilderRequirement(this.grpcClientModule, GrpcClientModule.class);
            Preconditions.checkBuilderRequirement(this.universalComponent, UniversalComponent.class);
            Preconditions.checkBuilderRequirement(this.transportFactory, TransportFactory.class);
            return new DaggerAppComponent(this.apiClientModule, this.grpcClientModule, this.universalComponent, this.abtIntegrationHelper, this.transportFactory);
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable */
    private static class C2348x345a1105 implements Provider<ConnectableFlowable<String>> {
        private final UniversalComponent universalComponent;

        C2348x345a1105(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public ConnectableFlowable<String> get() {
            return (ConnectableFlowable) Preconditions.checkNotNull(this.universalComponent.appForegroundEventFlowable(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable */
    private static class C2358xa33e14f2 implements Provider<ConnectableFlowable<String>> {
        private final UniversalComponent universalComponent;

        C2358xa33e14f2(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public ConnectableFlowable<String> get() {
            return (ConnectableFlowable) Preconditions.checkNotNull(this.universalComponent.programmaticContextualTriggerFlowable(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient */
    private static class C2351x4d59aff6 implements Provider<CampaignCacheClient> {
        private final UniversalComponent universalComponent;

        C2351x4d59aff6(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public CampaignCacheClient get() {
            return (CampaignCacheClient) Preconditions.checkNotNull(this.universalComponent.campaignCacheClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock */
    private static class C2352x55447107 implements Provider<Clock> {
        private final UniversalComponent universalComponent;

        C2352x55447107(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public Clock get() {
            return (Clock) Preconditions.checkNotNull(this.universalComponent.clock(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel */
    private static class C2355x6b6ee15e implements Provider<Channel> {
        private final UniversalComponent universalComponent;

        C2355x6b6ee15e(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public Channel get() {
            return (Channel) Preconditions.checkNotNull(this.universalComponent.gRPCChannel(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application */
    private static class C2350x8bf33b89 implements Provider<Application> {
        private final UniversalComponent universalComponent;

        C2350x8bf33b89(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public Application get() {
            return (Application) Preconditions.checkNotNull(this.universalComponent.application(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller */
    private static class C2357x8f6097a4 implements Provider<ProviderInstaller> {
        private final UniversalComponent universalComponent;

        C2357x8f6097a4(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public ProviderInstaller get() {
            return (ProviderInstaller) Preconditions.checkNotNull(this.universalComponent.probiderInstaller(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager */
    private static class C2347xbdbce295 implements Provider<AnalyticsEventsManager> {
        private final UniversalComponent universalComponent;

        C2347xbdbce295(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public AnalyticsEventsManager get() {
            return (AnalyticsEventsManager) Preconditions.checkNotNull(this.universalComponent.analyticsEventsManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers */
    private static class C2361xd050f5bf implements Provider<Schedulers> {
        private final UniversalComponent universalComponent;

        C2361xd050f5bf(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public Schedulers get() {
            return (Schedulers) Preconditions.checkNotNull(this.universalComponent.schedulers(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient */
    private static class C2356x7d9fb756 implements Provider<ImpressionStorageClient> {
        private final UniversalComponent universalComponent;

        C2356x7d9fb756(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public ImpressionStorageClient get() {
            return (ImpressionStorageClient) Preconditions.checkNotNull(this.universalComponent.impressionStorageClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient */
    private static class C2360x87c20e0c implements Provider<RateLimiterClient> {
        private final UniversalComponent universalComponent;

        C2360x87c20e0c(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public RateLimiterClient get() {
            return (RateLimiterClient) Preconditions.checkNotNull(this.universalComponent.rateLimiterClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit */
    private static class C2349x727a18fe implements Provider<RateLimit> {
        private final UniversalComponent universalComponent;

        C2349x727a18fe(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public RateLimit get() {
            return (RateLimit) Preconditions.checkNotNull(this.universalComponent.appForegroundRateLimit(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber */
    private static class C2354x4a8174ef implements Provider<Subscriber> {
        private final UniversalComponent universalComponent;

        C2354x4a8174ef(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public Subscriber get() {
            return (Subscriber) Preconditions.checkNotNull(this.universalComponent.firebaseEventsSubscriber(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers */
    private static class C2359x7c101e69 implements Provider<ProgramaticContextualTriggers> {
        private final UniversalComponent universalComponent;

        C2359x7c101e69(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public ProgramaticContextualTriggers get() {
            return (ProgramaticContextualTriggers) Preconditions.checkNotNull(this.universalComponent.programmaticContextualTriggers(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector */
    private static class C2346x92f0170e implements Provider<AnalyticsConnector> {
        private final UniversalComponent universalComponent;

        C2346x92f0170e(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public AnalyticsConnector get() {
            return (AnalyticsConnector) Preconditions.checkNotNull(this.universalComponent.analyticsConnector(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent$com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager */
    private static class C2353x559e6196 implements Provider<DeveloperListenerManager> {
        private final UniversalComponent universalComponent;

        C2353x559e6196(UniversalComponent universalComponent2) {
            this.universalComponent = universalComponent2;
        }

        public DeveloperListenerManager get() {
            return (DeveloperListenerManager) Preconditions.checkNotNull(this.universalComponent.developerListenerManager(), "Cannot return null from a non-@Nullable component method");
        }
    }
}

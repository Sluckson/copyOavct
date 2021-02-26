package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.CampaignImpressionList;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.ClientAppInfo;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.FetchEligibleCampaignsRequest;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.FetchEligibleCampaignsResponse;
import dagger.Lazy;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@FirebaseAppScope
public class ApiClient {
    private static final String FETCHING_CAMPAIGN_MESSAGE = "Fetching campaigns from service.";
    private final Application application;
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final Lazy<GrpcClient> grpcClient;
    private final ProviderInstaller providerInstaller;

    public ApiClient(Lazy<GrpcClient> lazy, FirebaseApp firebaseApp2, Application application2, Clock clock2, ProviderInstaller providerInstaller2) {
        this.grpcClient = lazy;
        this.firebaseApp = firebaseApp2;
        this.application = application2;
        this.clock = clock2;
        this.providerInstaller = providerInstaller2;
    }

    /* access modifiers changed from: package-private */
    public FetchEligibleCampaignsResponse getFiams(InstallationIdResult installationIdResult, CampaignImpressionList campaignImpressionList) {
        Logging.logi(FETCHING_CAMPAIGN_MESSAGE);
        this.providerInstaller.install();
        return withCacheExpirationSafeguards(this.grpcClient.get().fetchEligibleCampaigns((FetchEligibleCampaignsRequest) FetchEligibleCampaignsRequest.newBuilder().setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).addAllAlreadySeenCampaigns(campaignImpressionList.getAlreadySeenCampaignsList()).setClientSignals(getClientSignals()).setRequestingClientApp(getClientAppInfo(installationIdResult)).build()));
    }

    private FetchEligibleCampaignsResponse withCacheExpirationSafeguards(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        if (fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis() < this.clock.now() + TimeUnit.MINUTES.toMillis(1) || fetchEligibleCampaignsResponse.getExpirationEpochTimestampMillis() > this.clock.now() + TimeUnit.DAYS.toMillis(3)) {
            return (FetchEligibleCampaignsResponse) ((FetchEligibleCampaignsResponse.Builder) fetchEligibleCampaignsResponse.toBuilder()).setExpirationEpochTimestampMillis(this.clock.now() + TimeUnit.DAYS.toMillis(1)).build();
        }
        return fetchEligibleCampaignsResponse;
    }

    private ClientSignalsProto.ClientSignals getClientSignals() {
        ClientSignalsProto.ClientSignals.Builder timeZone = ClientSignalsProto.ClientSignals.newBuilder().setPlatformVersion(String.valueOf(Build.VERSION.SDK_INT)).setLanguageCode(Locale.getDefault().toString()).setTimeZone(TimeZone.getDefault().getID());
        String versionName = getVersionName();
        if (!TextUtils.isEmpty(versionName)) {
            timeZone.setAppVersion(versionName);
        }
        return (ClientSignalsProto.ClientSignals) timeZone.build();
    }

    private ClientAppInfo getClientAppInfo(InstallationIdResult installationIdResult) {
        return (ClientAppInfo) ClientAppInfo.newBuilder().setGmpAppId(this.firebaseApp.getOptions().getApplicationId()).setAppInstanceId(installationIdResult.installationId()).setAppInstanceIdToken(installationIdResult.installationTokenResult().getToken()).build();
    }

    @Nullable
    private String getVersionName() {
        try {
            return this.application.getPackageManager().getPackageInfo(this.application.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logging.loge("Error finding versionName : " + e.getMessage());
            return null;
        }
    }
}

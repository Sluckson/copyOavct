package com.salesforce.marketingcloud;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C3926b;
import com.salesforce.marketingcloud.notifications.NotificationCustomizationOptions;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.Locale;

@AutoValue
@MCKeep
public abstract class MarketingCloudConfig {
    private static final int ACCESS_TOKEN_LENGTH = 24;
    private static final String APPLICATION_ID_REGEX = "[0-9a-f]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}";

    @AutoValue.Builder
    @MCKeep
    public static abstract class Builder {
        /* access modifiers changed from: package-private */
        public abstract MarketingCloudConfig autoBuild();

        @NonNull
        public final MarketingCloudConfig build(@NonNull Context context) {
            C4028g.m2762a(context, "Context is null");
            String packageName = context.getPackageName();
            setAppPackageName(packageName);
            try {
                setAppVersionName(context.getPackageManager().getPackageInfo(packageName, 0).versionName);
            } catch (Exception unused) {
                setAppVersionName("null");
            }
            if (predictiveIntelligenceServerUrl() == null) {
                if (mid() == null) {
                    setPredictiveIntelligenceServerUrl("https://app.igodigital.com/api/v1/collect/process_batch");
                } else {
                    int indexOf = mid().toLowerCase().indexOf("-");
                    String substring = indexOf != -1 ? mid().substring(0, indexOf) : mid();
                    setPredictiveIntelligenceServerUrl(String.format(Locale.ENGLISH, "https://%s.collect.igodigital.com/c2/%s/process_batch.json", new Object[]{mid(), substring}));
                    setMid(substring);
                }
            }
            MarketingCloudConfig autoBuild = autoBuild();
            if (!autoBuild.applicationId().toLowerCase().matches(MarketingCloudConfig.APPLICATION_ID_REGEX)) {
                throw new IllegalArgumentException("The applicationId is not a valid UUID.");
            } else if (autoBuild.accessToken().length() != 24) {
                throw new IllegalArgumentException("The accessToken must be 24 characters.");
            } else if (autoBuild.senderId() != null && autoBuild.senderId().trim().isEmpty()) {
                throw new IllegalArgumentException("The senderId cannot be empty.");
            } else if (autoBuild.marketingCloudServerUrl().trim().isEmpty()) {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Marketing Cloud Server Url must not be empty.  URL:'%s'", new Object[]{autoBuild.marketingCloudServerUrl()}));
            } else if (autoBuild.mid() == null || !autoBuild.mid().trim().isEmpty()) {
                return autoBuild;
            } else {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "MID must not be empty.  MID:'%s'", new Object[]{autoBuild.mid()}));
            }
        }

        /* access modifiers changed from: package-private */
        public abstract String mid();

        /* access modifiers changed from: package-private */
        @Nullable
        public abstract String predictiveIntelligenceServerUrl();

        @NonNull
        public abstract Builder setAccessToken(@NonNull String str);

        @NonNull
        public abstract Builder setAnalyticsEnabled(boolean z);

        /* access modifiers changed from: package-private */
        public abstract Builder setAppPackageName(String str);

        /* access modifiers changed from: package-private */
        public abstract Builder setAppVersionName(String str);

        @NonNull
        public abstract Builder setApplicationId(@NonNull String str);

        @NonNull
        public abstract Builder setGeofencingEnabled(boolean z);

        @NonNull
        public abstract Builder setInboxEnabled(boolean z);

        @NonNull
        public abstract Builder setMarkMessageReadOnInboxNotificationOpen(boolean z);

        @NonNull
        public abstract Builder setMarketingCloudServerUrl(@NonNull String str);

        @NonNull
        public abstract Builder setMid(@NonNull String str);

        @NonNull
        public abstract Builder setNotificationCustomizationOptions(@NonNull NotificationCustomizationOptions notificationCustomizationOptions);

        @NonNull
        public abstract Builder setPiAnalyticsEnabled(boolean z);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract Builder setPredictiveIntelligenceServerUrl(@Nullable String str);

        @NonNull
        public abstract Builder setProximityEnabled(boolean z);

        @NonNull
        public abstract Builder setSenderId(@NonNull String str);
    }

    @NonNull
    public static Builder builder() {
        return new C3926b.C3928a().setMarketingCloudServerUrl("https://consumer.exacttargetapis.com/").setAnalyticsEnabled(false).setPiAnalyticsEnabled(false).setInboxEnabled(false).setMarkMessageReadOnInboxNotificationOpen(true).setGeofencingEnabled(false).setProximityEnabled(false);
    }

    @NonNull
    public abstract String accessToken();

    public abstract boolean analyticsEnabled();

    @NonNull
    public abstract String appPackageName();

    @NonNull
    public abstract String appVersionName();

    /* access modifiers changed from: package-private */
    public final boolean applicationChanged(MarketingCloudConfig marketingCloudConfig) {
        return marketingCloudConfig == null || !applicationId().equals(marketingCloudConfig.applicationId()) || !accessToken().equals(marketingCloudConfig.accessToken());
    }

    @NonNull
    public abstract String applicationId();

    public abstract boolean geofencingEnabled();

    public abstract boolean inboxEnabled();

    public abstract boolean markMessageReadOnInboxNotificationOpen();

    @NonNull
    public abstract String marketingCloudServerUrl();

    @Nullable
    public abstract String mid();

    @NonNull
    public abstract NotificationCustomizationOptions notificationCustomizationOptions();

    public abstract boolean piAnalyticsEnabled();

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract String predictiveIntelligenceServerUrl();

    public abstract boolean proximityEnabled();

    @Nullable
    public abstract String senderId();

    @NonNull
    public abstract Builder toBuilder();
}

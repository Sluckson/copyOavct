package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class FirebaseRemoteConfigSettings {
    private final boolean enableDeveloperMode;
    private final long fetchTimeoutInSeconds;
    private final long minimumFetchInterval;

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.enableDeveloperMode = builder.enableDeveloperMode;
        this.fetchTimeoutInSeconds = builder.fetchTimeoutInSeconds;
        this.minimumFetchInterval = builder.minimumFetchInterval;
    }

    @Deprecated
    public boolean isDeveloperModeEnabled() {
        return this.enableDeveloperMode;
    }

    public long getFetchTimeoutInSeconds() {
        return this.fetchTimeoutInSeconds;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.minimumFetchInterval;
    }

    @NonNull
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setDeveloperModeEnabled(isDeveloperModeEnabled());
        builder.setFetchTimeoutInSeconds(getFetchTimeoutInSeconds());
        builder.setMinimumFetchIntervalInSeconds(getMinimumFetchIntervalInSeconds());
        return builder;
    }

    /* compiled from: com.google.firebase:firebase-config@@19.1.4 */
    public static class Builder {
        /* access modifiers changed from: private */
        public boolean enableDeveloperMode = false;
        /* access modifiers changed from: private */
        public long fetchTimeoutInSeconds = 60;
        /* access modifiers changed from: private */
        public long minimumFetchInterval = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;

        @NonNull
        @Deprecated
        public Builder setDeveloperModeEnabled(boolean z) {
            this.enableDeveloperMode = z;
            return this;
        }

        @NonNull
        public Builder setFetchTimeoutInSeconds(long j) throws IllegalArgumentException {
            if (j >= 0) {
                this.fetchTimeoutInSeconds = j;
                return this;
            }
            throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", new Object[]{Long.valueOf(j)}));
        }

        @NonNull
        public Builder setMinimumFetchIntervalInSeconds(long j) {
            if (j >= 0) {
                this.minimumFetchInterval = j;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j + " is an invalid argument");
        }

        public long getFetchTimeoutInSeconds() {
            return this.fetchTimeoutInSeconds;
        }

        public long getMinimumFetchIntervalInSeconds() {
            return this.minimumFetchInterval;
        }

        @NonNull
        public FirebaseRemoteConfigSettings build() {
            return new FirebaseRemoteConfigSettings(this);
        }
    }
}

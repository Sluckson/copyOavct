package com.google.firebase.inappmessaging.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Subscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

public class DataCollectionHelper {
    @VisibleForTesting
    static final String AUTO_INIT_PREFERENCES = "auto_init";
    @VisibleForTesting
    static final String MANIFEST_METADATA_AUTO_INIT_ENABLED = "firebase_inapp_messaging_auto_data_collection_enabled";
    private AtomicBoolean isGlobalAutomaticDataCollectionEnabled;
    private SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public DataCollectionHelper(FirebaseApp firebaseApp, SharedPreferencesUtils sharedPreferencesUtils2, Subscriber subscriber) {
        this.sharedPreferencesUtils = sharedPreferencesUtils2;
        this.isGlobalAutomaticDataCollectionEnabled = new AtomicBoolean(firebaseApp.isDataCollectionDefaultEnabled());
        subscriber.subscribe(DataCollectionDefaultChange.class, DataCollectionHelper$$Lambda$1.lambdaFactory$(this));
    }

    public boolean isAutomaticDataCollectionEnabled() {
        if (isProductManuallySet()) {
            return this.sharedPreferencesUtils.getBooleanPreference(AUTO_INIT_PREFERENCES, true);
        }
        if (isProductManifestSet()) {
            return this.sharedPreferencesUtils.getBooleanManifestValue(MANIFEST_METADATA_AUTO_INIT_ENABLED, true);
        }
        return this.isGlobalAutomaticDataCollectionEnabled.get();
    }

    public void setAutomaticDataCollectionEnabled(boolean z) {
        this.sharedPreferencesUtils.setBooleanPreference(AUTO_INIT_PREFERENCES, z);
    }

    public void setAutomaticDataCollectionEnabled(Boolean bool) {
        if (bool == null) {
            this.sharedPreferencesUtils.clearPreference(AUTO_INIT_PREFERENCES);
        } else {
            this.sharedPreferencesUtils.setBooleanPreference(AUTO_INIT_PREFERENCES, Boolean.TRUE.equals(bool));
        }
    }

    private boolean readAutomaticDataCollectionEnabledFromPreferences() {
        return this.sharedPreferencesUtils.getBooleanPreference(AUTO_INIT_PREFERENCES, true);
    }

    private boolean isProductManuallySet() {
        return this.sharedPreferencesUtils.isPreferenceSet(AUTO_INIT_PREFERENCES);
    }

    private boolean isProductManifestSet() {
        return this.sharedPreferencesUtils.isManifestSet(MANIFEST_METADATA_AUTO_INIT_ENABLED);
    }
}

package com.google.firebase.inappmessaging.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.internal.firebase.inappmessaging.p014v1.CampaignProto;
import com.google.internal.firebase.inappmessaging.p014v1.sdkserving.FetchEligibleCampaignsResponse;
import javax.inject.Inject;

public class TestDeviceHelper {
    @VisibleForTesting
    static final String FRESH_INSTALL_PREFERENCES = "fresh_install";
    @VisibleForTesting
    static final int MAX_FETCH_COUNT = 5;
    @VisibleForTesting
    static final String TEST_DEVICE_PREFERENCES = "test_device";
    private int fetchCount = 0;
    private boolean isFreshInstall;
    private boolean isTestDevice;
    private final SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public TestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils2) {
        this.sharedPreferencesUtils = sharedPreferencesUtils2;
        this.isFreshInstall = readFreshInstallStatusFromPreferences();
        this.isTestDevice = readTestDeviceStatusFromPreferences();
    }

    public boolean isDeviceInTestMode() {
        return this.isTestDevice;
    }

    public boolean isAppInstallFresh() {
        return this.isFreshInstall;
    }

    public void processCampaignFetch(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        if (!this.isTestDevice) {
            updateFreshInstallStatus();
            for (CampaignProto.ThickContent isTestCampaign : fetchEligibleCampaignsResponse.getMessagesList()) {
                if (isTestCampaign.getIsTestCampaign()) {
                    setTestDeviceStatus(true);
                    Logging.logi("Setting this device as a test device");
                    return;
                }
            }
        }
    }

    private void updateFreshInstallStatus() {
        if (this.isFreshInstall) {
            this.fetchCount++;
            if (this.fetchCount >= 5) {
                setFreshInstallStatus(false);
            }
        }
    }

    private void setTestDeviceStatus(boolean z) {
        this.isTestDevice = z;
        this.sharedPreferencesUtils.setBooleanPreference(TEST_DEVICE_PREFERENCES, z);
    }

    private void setFreshInstallStatus(boolean z) {
        this.isFreshInstall = z;
        this.sharedPreferencesUtils.setBooleanPreference(FRESH_INSTALL_PREFERENCES, z);
    }

    private boolean readTestDeviceStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference(TEST_DEVICE_PREFERENCES, false);
    }

    private boolean readFreshInstallStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference(FRESH_INSTALL_PREFERENCES, true);
    }
}

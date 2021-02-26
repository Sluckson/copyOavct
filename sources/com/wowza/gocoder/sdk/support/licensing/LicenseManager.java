package com.wowza.gocoder.sdk.support.licensing;

import com.wowza.gocoder.sdk.api.WOWZVersionInfo;
import com.wowza.gocoder.sdk.api.errors.WOWZSDKError;
import java.util.Date;

/* compiled from: GoCoderSDK */
public final class LicenseManager {
    private static final int LICENSE_ERR_EXPIRED = 2;
    private static final int LICENSE_ERR_LICENSEE_MISMATCH = 1;
    private static final long LICENSE_KEY_LENGTH = 29;
    private static final int LICENSE_VERIFIED = 0;
    private static final long MILLISECONDS_IN_DAY = 86400000;
    private static volatile LicenseManager instance = new LicenseManager();
    private boolean mEvaluation = false;
    private boolean mExpires = false;
    private int mFeatureSet1 = 0;
    private int mFeatureSet2 = 0;
    private long mLicenseDate = 0;
    private String mLicenseKey = null;
    private int mLicenseVersion = 0;
    private String mLicenseeId = null;
    private int mVerificationResult = -1;

    private static native void validateLicenseKey(String str, String str2, LicenseManager licenseManager);

    public static LicenseManager getInstance() {
        return instance;
    }

    public static LicenseManager init(String str, String str2) {
        instance.mLicenseeId = str;
        instance.mLicenseKey = str2;
        if (str2 != null && ((long) str2.length()) == LICENSE_KEY_LENGTH) {
            validateLicenseKey(str, str2, instance);
        }
        return instance;
    }

    LicenseManager() {
    }

    public boolean canDoPublishing() {
        if (!isValid()) {
            return false;
        }
        int i = this.mFeatureSet1;
        if (i == 1 || (i == 0 && this.mFeatureSet2 == 0)) {
            return true;
        }
        return false;
    }

    public boolean canDoPlayback() {
        return this.mFeatureSet2 == 1;
    }

    public boolean isValid() {
        return isRegistered() && !isExpired() && matchesVersion();
    }

    public boolean isRegistered() {
        return this.mVerificationResult == 0;
    }

    public boolean isExpired() {
        return this.mExpires && this.mLicenseDate < System.currentTimeMillis() / 86400000;
    }

    public boolean isEvaluation() {
        return this.mEvaluation;
    }

    public Date getExpirationDate() {
        if (this.mExpires) {
            return new Date(this.mLicenseDate * 86400000);
        }
        return null;
    }

    public int getLicenseVersion() {
        return this.mLicenseVersion;
    }

    public boolean matchesVersion() {
        if (!this.mLicenseKey.toUpperCase().startsWith("GSDK") && this.mLicenseVersion != WOWZVersionInfo.getInstance().getMajorVersion()) {
            return false;
        }
        return true;
    }

    public WOWZSDKError getLicensingError() {
        int i;
        String str = this.mLicenseKey;
        if (str == null || ((long) str.length()) != LICENSE_KEY_LENGTH) {
            i = 1;
        } else if (!isRegistered()) {
            i = 6;
        } else {
            i = isExpired() ? 2 : !matchesVersion() ? 5 : 0;
        }
        if (i != 0) {
            return new WOWZSDKError(i);
        }
        return null;
    }
}

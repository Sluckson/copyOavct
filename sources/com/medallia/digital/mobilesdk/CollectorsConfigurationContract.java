package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import org.json.JSONException;
import org.json.JSONObject;

class CollectorsConfigurationContract extends C3455c0 {
    private CollectorContract appIdCollector;
    private CollectorContract appNameCollector;
    private CollectorContract appRatingLastAcceptedTimestampCollector;
    private CollectorContract appRatingLastDeclineTimestampCollector;
    private CollectorContract appVersionCollector;
    private CollectorContract batteryPercentageCollector;
    private CollectorContract csatCollector;
    private CollectorContract deviceFreeDiskSpaceCollector;
    private CollectorContract deviceFreeMemoryCollector;
    private CollectorContract deviceIdCollector;
    private CollectorContract deviceModelCollector;
    private CollectorContract deviceResolutionCollector;
    private CollectorContract deviceUsedDiskSpaceCollector;
    private CollectorContract deviceUsedMemoryCollector;
    private CollectorContract deviceVendorCollector;
    private CollectorContract externalDriveFreeSpaceCollector;
    private CollectorContract externalDriveUsedSpaceCollector;
    private CollectorContract invitationDisplayedCollector;
    private CollectorContract ipCollector;
    private CollectorContract languageCollector;
    private CollectorContract lastDeclineTimestampCollector;
    private CollectorContract lastSubmitTimestampCollector;
    private CollectorContract networkCarrierCollector;
    private CollectorContract networkProviderCollector;
    private CollectorContract networkSpeedCollector;
    private CollectorContract networkTypeCollector;
    private CollectorContract npsCollector;
    private CollectorContract orientationCollector;
    private CollectorContract osNameCollector;
    private CollectorContract osVersionCollector;
    private CollectorContract powerTypeCollector;
    private CollectorContract promptDisplayedCollector;
    private CollectorContract propertyIdCollector;
    private CollectorContract sdkVersionCollector;
    private CollectorContract sessionCalculatedPercentageCollector;
    private CollectorContract sessionIdCollector;
    private CollectorContract sessionNumberCollector;
    private CollectorContract timezoneCollector;

    protected CollectorsConfigurationContract() {
        this.deviceModelCollector = C3697r0.C3698a.f1749c;
        this.deviceVendorCollector = C3697r0.C3698a.f1753g;
        this.deviceResolutionCollector = C3697r0.C3698a.f1750d;
        this.deviceUsedMemoryCollector = C3697r0.C3698a.f1752f;
        this.deviceFreeMemoryCollector = C3697r0.C3698a.f1748b;
        this.deviceUsedDiskSpaceCollector = C3697r0.C3698a.f1751e;
        this.deviceFreeDiskSpaceCollector = C3697r0.C3698a.f1747a;
        this.externalDriveUsedSpaceCollector = C3697r0.C3698a.f1754h;
        this.externalDriveFreeSpaceCollector = C3697r0.C3698a.f1755i;
        this.osNameCollector = C3697r0.C3698a.f1756j;
        this.osVersionCollector = C3697r0.C3698a.f1757k;
        this.networkProviderCollector = C3697r0.C3698a.f1758l;
        this.networkCarrierCollector = C3697r0.C3698a.f1759m;
        this.languageCollector = C3697r0.C3698a.f1760n;
        this.timezoneCollector = C3697r0.C3698a.f1761o;
        this.ipCollector = C3697r0.C3698a.f1762p;
        this.networkSpeedCollector = C3697r0.C3698a.f1763q;
        this.deviceIdCollector = C3697r0.C3698a.f1764r;
        this.appNameCollector = C3697r0.C3698a.f1765s;
        this.appIdCollector = C3697r0.C3698a.f1766t;
        this.appVersionCollector = C3697r0.C3698a.f1767u;
        this.sdkVersionCollector = C3697r0.C3698a.f1768v;
        this.sessionCalculatedPercentageCollector = C3697r0.C3698a.f1769w;
        this.sessionNumberCollector = C3697r0.C3698a.f1770x;
        this.networkTypeCollector = C3697r0.C3698a.f1772z;
        this.powerTypeCollector = C3697r0.C3698a.f1725A;
        this.batteryPercentageCollector = C3697r0.C3698a.f1727C;
        this.orientationCollector = C3697r0.C3698a.f1728D;
        this.lastDeclineTimestampCollector = C3697r0.C3698a.f1729E;
        this.lastSubmitTimestampCollector = C3697r0.C3698a.f1730F;
        this.invitationDisplayedCollector = C3697r0.C3698a.f1735K;
        this.npsCollector = C3697r0.C3698a.f1740P;
        this.csatCollector = C3697r0.C3698a.f1741Q;
        this.appRatingLastDeclineTimestampCollector = C3697r0.C3698a.f1742R;
        this.promptDisplayedCollector = C3697r0.C3698a.f1743S;
        this.appRatingLastAcceptedTimestampCollector = C3697r0.C3698a.f1744T;
    }

    protected CollectorsConfigurationContract(CollectorContract collectorContract, CollectorContract collectorContract2, CollectorContract collectorContract3, CollectorContract collectorContract4, CollectorContract collectorContract5, CollectorContract collectorContract6, CollectorContract collectorContract7, CollectorContract collectorContract8, CollectorContract collectorContract9, CollectorContract collectorContract10, CollectorContract collectorContract11, CollectorContract collectorContract12, CollectorContract collectorContract13, CollectorContract collectorContract14, CollectorContract collectorContract15, CollectorContract collectorContract16, CollectorContract collectorContract17, CollectorContract collectorContract18, CollectorContract collectorContract19, CollectorContract collectorContract20, CollectorContract collectorContract21, CollectorContract collectorContract22, CollectorContract collectorContract23, CollectorContract collectorContract24, CollectorContract collectorContract25, CollectorContract collectorContract26, CollectorContract collectorContract27, CollectorContract collectorContract28, CollectorContract collectorContract29, CollectorContract collectorContract30, CollectorContract collectorContract31, CollectorContract collectorContract32, CollectorContract collectorContract33) {
        this.deviceModelCollector = collectorContract;
        this.deviceVendorCollector = collectorContract2;
        this.deviceResolutionCollector = collectorContract3;
        this.deviceUsedMemoryCollector = collectorContract4;
        this.deviceFreeMemoryCollector = collectorContract5;
        this.deviceUsedDiskSpaceCollector = collectorContract6;
        this.deviceFreeDiskSpaceCollector = collectorContract7;
        this.externalDriveUsedSpaceCollector = collectorContract8;
        this.externalDriveFreeSpaceCollector = collectorContract9;
        this.osNameCollector = collectorContract10;
        this.osVersionCollector = collectorContract11;
        this.networkProviderCollector = collectorContract12;
        this.networkCarrierCollector = collectorContract13;
        this.languageCollector = collectorContract14;
        this.timezoneCollector = collectorContract15;
        this.ipCollector = collectorContract16;
        this.networkSpeedCollector = collectorContract17;
        this.deviceIdCollector = collectorContract18;
        this.appNameCollector = collectorContract19;
        this.appIdCollector = collectorContract20;
        this.appVersionCollector = collectorContract21;
        this.sdkVersionCollector = collectorContract22;
        this.sessionCalculatedPercentageCollector = collectorContract23;
        this.sessionNumberCollector = collectorContract24;
        this.sessionIdCollector = collectorContract25;
        this.networkTypeCollector = collectorContract26;
        this.powerTypeCollector = collectorContract27;
        this.batteryPercentageCollector = collectorContract28;
        this.orientationCollector = collectorContract29;
        this.lastDeclineTimestampCollector = collectorContract30;
        this.lastSubmitTimestampCollector = collectorContract31;
        this.invitationDisplayedCollector = collectorContract32;
        this.propertyIdCollector = collectorContract33;
    }

    CollectorsConfigurationContract(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = jSONObject;
        String str2 = "timezoneCollector";
        try {
            if (!jSONObject2.has("deviceModelCollector") || jSONObject2.isNull("deviceModelCollector")) {
                str = "languageCollector";
            } else {
                str = "languageCollector";
                this.deviceModelCollector = new CollectorContract(jSONObject2.getJSONObject("deviceModelCollector"));
            }
            if (jSONObject2.has("deviceVendorCollector") && !jSONObject2.isNull("deviceVendorCollector")) {
                this.deviceVendorCollector = new CollectorContract(jSONObject2.getJSONObject("deviceVendorCollector"));
            }
            if (jSONObject2.has("deviceResolutionCollector") && !jSONObject2.isNull("deviceResolutionCollector")) {
                this.deviceResolutionCollector = new CollectorContract(jSONObject2.getJSONObject("deviceResolutionCollector"));
            }
            if (jSONObject2.has("deviceUsedMemoryCollector") && !jSONObject2.isNull("deviceUsedMemoryCollector")) {
                this.deviceUsedMemoryCollector = new CollectorContract(jSONObject2.getJSONObject("deviceUsedMemoryCollector"));
            }
            if (jSONObject2.has("deviceFreeMemoryCollector") && !jSONObject2.isNull("deviceFreeMemoryCollector")) {
                this.deviceFreeMemoryCollector = new CollectorContract(jSONObject2.getJSONObject("deviceFreeMemoryCollector"));
            }
            if (jSONObject2.has("deviceUsedDiskSpaceCollector") && !jSONObject2.isNull("deviceUsedDiskSpaceCollector")) {
                this.deviceUsedDiskSpaceCollector = new CollectorContract(jSONObject2.getJSONObject("deviceUsedDiskSpaceCollector"));
            }
            if (jSONObject2.has("deviceFreeDiskSpaceCollector") && !jSONObject2.isNull("deviceFreeDiskSpaceCollector")) {
                this.deviceFreeDiskSpaceCollector = new CollectorContract(jSONObject2.getJSONObject("deviceFreeDiskSpaceCollector"));
            }
            if (jSONObject2.has("externalDriveUsedSpaceCollector") && !jSONObject2.isNull("externalDriveUsedSpaceCollector")) {
                this.externalDriveUsedSpaceCollector = new CollectorContract(jSONObject2.getJSONObject("externalDriveUsedSpaceCollector"));
            }
            if (jSONObject2.has("externalDriveFreeSpaceCollector") && !jSONObject2.isNull("externalDriveFreeSpaceCollector")) {
                this.externalDriveFreeSpaceCollector = new CollectorContract(jSONObject2.getJSONObject("externalDriveFreeSpaceCollector"));
            }
            if (jSONObject2.has("osNameCollector") && !jSONObject2.isNull("osNameCollector")) {
                this.osNameCollector = new CollectorContract(jSONObject2.getJSONObject("osNameCollector"));
            }
            if (jSONObject2.has("osVersionCollector") && !jSONObject2.isNull("osVersionCollector")) {
                this.osVersionCollector = new CollectorContract(jSONObject2.getJSONObject("osVersionCollector"));
            }
            if (jSONObject2.has("networkProviderCollector") && !jSONObject2.isNull("networkProviderCollector")) {
                this.networkProviderCollector = new CollectorContract(jSONObject2.getJSONObject("networkProviderCollector"));
            }
            if (jSONObject2.has("networkCarrierCollector") && !jSONObject2.isNull("networkCarrierCollector")) {
                this.networkCarrierCollector = new CollectorContract(jSONObject2.getJSONObject("networkCarrierCollector"));
            }
            String str3 = str;
            if (jSONObject2.has(str3) && !jSONObject2.isNull(str3)) {
                this.languageCollector = new CollectorContract(jSONObject2.getJSONObject(str3));
            }
            String str4 = str2;
            if (jSONObject2.has(str4) && !jSONObject2.isNull(str4)) {
                this.timezoneCollector = new CollectorContract(jSONObject2.getJSONObject(str4));
            }
            if (jSONObject2.has("ipCollector") && !jSONObject2.isNull("ipCollector")) {
                this.ipCollector = new CollectorContract(jSONObject2.getJSONObject("ipCollector"));
            }
            if (jSONObject2.has("networkSpeedCollector") && !jSONObject2.isNull("networkSpeedCollector")) {
                this.networkSpeedCollector = new CollectorContract(jSONObject2.getJSONObject("networkSpeedCollector"));
            }
            if (jSONObject2.has("deviceIdCollector") && !jSONObject2.isNull("deviceIdCollector")) {
                this.deviceIdCollector = new CollectorContract(jSONObject2.getJSONObject("deviceIdCollector"));
            }
            if (jSONObject2.has("appNameCollector") && !jSONObject2.isNull("appNameCollector")) {
                this.appNameCollector = new CollectorContract(jSONObject2.getJSONObject("appNameCollector"));
            }
            if (jSONObject2.has("appIdCollector") && !jSONObject2.isNull("appIdCollector")) {
                this.appIdCollector = new CollectorContract(jSONObject2.getJSONObject("appIdCollector"));
            }
            if (jSONObject2.has("appVersionCollector") && !jSONObject2.isNull("appVersionCollector")) {
                this.appVersionCollector = new CollectorContract(jSONObject2.getJSONObject("appVersionCollector"));
            }
            if (jSONObject2.has("sdkVersionCollector") && !jSONObject2.isNull("sdkVersionCollector")) {
                this.sdkVersionCollector = new CollectorContract(jSONObject2.getJSONObject("sdkVersionCollector"));
            }
            if (jSONObject2.has("sessionNumberCollector") && !jSONObject2.isNull("sessionNumberCollector")) {
                this.sessionNumberCollector = new CollectorContract(jSONObject2.getJSONObject("sessionNumberCollector"));
            }
            if (jSONObject2.has("sessionIdCollector") && !jSONObject2.isNull("sessionIdCollector")) {
                this.sessionIdCollector = new CollectorContract(jSONObject2.getJSONObject("sessionIdCollector"));
            }
            if (jSONObject2.has("sessionCalculatedPercentageCollector") && !jSONObject2.isNull("sessionCalculatedPercentageCollector")) {
                this.sessionCalculatedPercentageCollector = new CollectorContract(jSONObject2.getJSONObject("sessionCalculatedPercentageCollector"));
            }
            if (jSONObject2.has("networkTypeCollector") && !jSONObject2.isNull("networkTypeCollector")) {
                this.networkTypeCollector = new CollectorContract(jSONObject2.getJSONObject("networkTypeCollector"));
            }
            if (jSONObject2.has("powerTypeCollector") && !jSONObject2.isNull("powerTypeCollector")) {
                this.powerTypeCollector = new CollectorContract(jSONObject2.getJSONObject("powerTypeCollector"));
            }
            if (jSONObject2.has("batteryPercentageCollector") && !jSONObject2.isNull("batteryPercentageCollector")) {
                this.batteryPercentageCollector = new CollectorContract(jSONObject2.getJSONObject("batteryPercentageCollector"));
            }
            if (jSONObject2.has("orientationCollector") && !jSONObject2.isNull("orientationCollector")) {
                this.orientationCollector = new CollectorContract(jSONObject2.getJSONObject("orientationCollector"));
            }
            if (jSONObject2.has("lastDeclineTimestampCollector") && !jSONObject2.isNull("lastDeclineTimestampCollector")) {
                this.lastDeclineTimestampCollector = new CollectorContract(jSONObject2.getJSONObject("lastDeclineTimestampCollector"));
            }
            if (jSONObject2.has("lastSubmitTimestampCollector") && !jSONObject2.isNull("lastSubmitTimestampCollector")) {
                this.lastSubmitTimestampCollector = new CollectorContract(jSONObject2.getJSONObject("lastSubmitTimestampCollector"));
            }
            if (jSONObject2.has("invitationDisplayedCollector") && !jSONObject2.isNull("invitationDisplayedCollector")) {
                this.invitationDisplayedCollector = new CollectorContract(jSONObject2.getJSONObject("invitationDisplayedCollector"));
            }
            if (jSONObject2.has("propertyIdCollector") && !jSONObject2.isNull("propertyIdCollector")) {
                this.propertyIdCollector = new CollectorContract(jSONObject2.getJSONObject("propertyIdCollector"));
            }
            if (jSONObject2.has("npsCollector") && !jSONObject2.isNull("npsCollector")) {
                this.npsCollector = new CollectorContract(jSONObject2.getJSONObject("npsCollector"));
            }
            if (jSONObject2.has("csatCollector") && !jSONObject2.isNull("csatCollector")) {
                this.csatCollector = new CollectorContract(jSONObject2.getJSONObject("csatCollector"));
            }
            if (jSONObject2.has("appRatingLastDeclineTimestampCollector") && !jSONObject2.isNull("appRatingLastDeclineTimestampCollector")) {
                this.appRatingLastDeclineTimestampCollector = new CollectorContract(jSONObject2.getJSONObject("appRatingLastDeclineTimestampCollector"));
            }
            if (jSONObject2.has("promptDisplayedCollector") && !jSONObject2.isNull("promptDisplayedCollector")) {
                this.promptDisplayedCollector = new CollectorContract(jSONObject2.getJSONObject("promptDisplayedCollector"));
            }
            if (jSONObject2.has("appRatingLastAcceptedTimestampCollector") && !jSONObject2.isNull("appRatingLastAcceptedTimestampCollector")) {
                this.appRatingLastAcceptedTimestampCollector = new CollectorContract(jSONObject2.getJSONObject("appRatingLastAcceptedTimestampCollector"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    private String collectorToJSonString(CollectorContract collectorContract) {
        return collectorContract == null ? "null" : collectorContract.toJsonString();
    }

    /* access modifiers changed from: protected */
    public CollectorContract getAppIdCollector() {
        return this.appIdCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getAppNameCollector() {
        return this.appNameCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getAppRatingLastAcceptedTimestampCollector() {
        return this.appRatingLastAcceptedTimestampCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getAppRatingLastDeclineTimestampCollector() {
        return this.appRatingLastDeclineTimestampCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getAppVersionCollector() {
        return this.appVersionCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getBatteryPercentageCollector() {
        return this.batteryPercentageCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getCsatCollector() {
        return this.csatCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getDeviceFreeDiskSpaceCollector() {
        return this.deviceFreeDiskSpaceCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getDeviceFreeMemoryCollector() {
        return this.deviceFreeMemoryCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getDeviceIdCollector() {
        return this.deviceIdCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getDeviceModelCollector() {
        return this.deviceModelCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getDeviceResolutionCollector() {
        return this.deviceResolutionCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getDeviceUsedDiskSpaceCollector() {
        return this.deviceUsedDiskSpaceCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getDeviceUsedMemoryCollector() {
        return this.deviceUsedMemoryCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getDeviceVendorCollector() {
        return this.deviceVendorCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getExternalDriveFreeSpaceCollector() {
        return this.externalDriveFreeSpaceCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getExternalDriveUsedSpaceCollector() {
        return this.externalDriveUsedSpaceCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getInvitationDisplayedCollector() {
        return this.invitationDisplayedCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getIpCollector() {
        return this.ipCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getLanguageCollector() {
        return this.languageCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getLastDeclineTimestampCollector() {
        return this.lastDeclineTimestampCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getLastSubmitTimestampCollector() {
        return this.lastSubmitTimestampCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getNetworkCarrierCollector() {
        return this.networkCarrierCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getNetworkProviderCollector() {
        return this.networkProviderCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getNetworkSpeedCollector() {
        return this.networkSpeedCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getNetworkTypeCollector() {
        return this.networkTypeCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getNpsCollector() {
        return this.npsCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getOrientationCollector() {
        return this.orientationCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getOsNameCollector() {
        return this.osNameCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getOsVersionCollector() {
        return this.osVersionCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getPowerTypeCollector() {
        return this.powerTypeCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getPromptDisplayedCollector() {
        return this.promptDisplayedCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getPropertyIdCollector() {
        return this.propertyIdCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getSdkVersionCollector() {
        return this.sdkVersionCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getSessionCalculatedPercentageCollector() {
        return this.sessionCalculatedPercentageCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getSessionIdCollector() {
        return this.sessionIdCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getSessionNumberCollector() {
        return this.sessionNumberCollector;
    }

    /* access modifiers changed from: protected */
    public CollectorContract getTimezoneCollector() {
        return this.timezoneCollector;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            return "{\"deviceModelCollector\":" + collectorToJSonString(this.deviceModelCollector) + ",\"deviceVendorCollector\":" + collectorToJSonString(this.deviceVendorCollector) + ",\"deviceResolutionCollector\":" + collectorToJSonString(this.deviceResolutionCollector) + ",\"deviceUsedMemoryCollector\":" + collectorToJSonString(this.deviceUsedMemoryCollector) + ",\"deviceFreeMemoryCollector\":" + collectorToJSonString(this.deviceFreeMemoryCollector) + ",\"deviceUsedDiskSpaceCollector\":" + collectorToJSonString(this.deviceUsedDiskSpaceCollector) + ",\"deviceFreeDiskSpaceCollector\":" + collectorToJSonString(this.deviceFreeDiskSpaceCollector) + ",\"externalDriveUsedSpaceCollector\":" + collectorToJSonString(this.externalDriveUsedSpaceCollector) + ",\"externalDriveFreeSpaceCollector\":" + collectorToJSonString(this.externalDriveFreeSpaceCollector) + ",\"osNameCollector\":" + collectorToJSonString(this.osNameCollector) + ",\"osVersionCollector\":" + collectorToJSonString(this.osVersionCollector) + ",\"networkProviderCollector\":" + collectorToJSonString(this.networkProviderCollector) + ",\"networkCarrierCollector\":" + collectorToJSonString(this.networkCarrierCollector) + ",\"languageCollector\":" + collectorToJSonString(this.languageCollector) + ",\"timezoneCollector\":" + collectorToJSonString(this.timezoneCollector) + ",\"ipCollector\":" + collectorToJSonString(this.ipCollector) + ",\"networkSpeedCollector\":" + collectorToJSonString(this.networkSpeedCollector) + ",\"deviceIdCollector\":" + collectorToJSonString(this.deviceIdCollector) + ",\"appNameCollector\":" + collectorToJSonString(this.appNameCollector) + ",\"appIdCollector\":" + collectorToJSonString(this.appIdCollector) + ",\"appVersionCollector\":" + collectorToJSonString(this.appVersionCollector) + ",\"sdkVersionCollector\":" + collectorToJSonString(this.sdkVersionCollector) + ",\"sessionCalculatedPercentageCollector\":" + collectorToJSonString(this.sessionCalculatedPercentageCollector) + ",\"sessionNumberCollector\":" + collectorToJSonString(this.sessionNumberCollector) + ",\"sessionIdCollector\":" + collectorToJSonString(this.sessionIdCollector) + ",\"networkTypeCollector\":" + collectorToJSonString(this.networkTypeCollector) + ",\"powerTypeCollector\":" + collectorToJSonString(this.powerTypeCollector) + ",\"batteryPercentageCollector\":" + collectorToJSonString(this.batteryPercentageCollector) + ",\"orientationCollector\":" + collectorToJSonString(this.orientationCollector) + ",\"lastDeclineTimestampCollector\":" + collectorToJSonString(this.lastDeclineTimestampCollector) + ",\"lastSubmitTimestampCollector\":" + collectorToJSonString(this.lastSubmitTimestampCollector) + ",\"invitationDisplayedCollector\":" + collectorToJSonString(this.invitationDisplayedCollector) + ",\"propertyIdCollector\":" + collectorToJSonString(this.propertyIdCollector) + ",\"npsCollector\":" + collectorToJSonString(this.npsCollector) + ",\"csatCollector\":" + collectorToJSonString(this.csatCollector) + ",\"appRatingLastDeclineTimestampCollector\":" + collectorToJSonString(this.appRatingLastDeclineTimestampCollector) + ",\"promptDisplayedCollector\":" + collectorToJSonString(this.promptDisplayedCollector) + ",\"appRatingLastAcceptedTimestampCollector\":" + collectorToJSonString(this.appRatingLastAcceptedTimestampCollector) + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}

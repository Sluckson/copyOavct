package com.medallia.digital.mobilesdk;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.medallia.digital.mobilesdk.C3461c3;
import com.medallia.digital.mobilesdk.C3682q4;
import com.medallia.digital.mobilesdk.C3697r0;
import com.medallia.digital.mobilesdk.C3797y3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

class CollectorsInfrastructure implements C3656o0, C3713r5, C3461c3.C3469h {
    private static CollectorsInfrastructure instance;
    protected C3591k appIdCollector = new C3591k(getPollType(C3697r0.C3698a.f1766t.getFrequency()), C3612m0.AppId);
    protected C3601l appNameCollector = new C3601l(getPollType(C3697r0.C3698a.f1765s.getFrequency()), C3612m0.AppName);
    protected C3641n appRatingLastAcceptedTimestampCollector;
    protected C3654o appRatingLastDeclineTimestampCollector;
    protected C3662p appVersionCollector = new C3662p(getPollType(C3697r0.C3698a.f1767u.getFrequency()), C3612m0.AppVersion);
    protected C3486e0 batteryPercentageCollector = new C3486e0(C3612m0.BatteryPercentage);
    protected C3746u0 csatCollector;
    protected C3760v0 customParametersCollector = new C3760v0(C3612m0.CustomParameters);
    protected C3444b1 deviceFreeDiskSpaceCollector = new C3444b1(getPollType(C3697r0.C3698a.f1747a.getFrequency()), C3612m0.DeviceFreeDiskSpace);
    protected C3456c1 deviceFreeMemoryCollector = new C3456c1(getPollType(C3697r0.C3698a.f1748b.getFrequency()), C3612m0.DeviceFreeMemoryCollector);
    protected C3479d1 deviceIdCollector = new C3479d1(getPollType(C3697r0.C3698a.f1764r.getFrequency()), C3612m0.DeviceId);
    protected C3518f1 deviceModelCollector = new C3518f1(getPollType(C3697r0.C3698a.f1749c.getFrequency()), C3612m0.DeviceModel);
    protected C3538g1 deviceResolutionCollector = new C3538g1(getPollType(C3697r0.C3698a.f1750d.getFrequency()), C3612m0.DeviceResolution);
    protected C3551h1 deviceUsedDiskSpaceCollector = new C3551h1(getPollType(C3697r0.C3698a.f1751e.getFrequency()), C3612m0.DeviceUsedDiskSpace);
    protected C3567i1 deviceUsedMemoryCollector = new C3567i1(getPollType(C3697r0.C3698a.f1752f.getFrequency()), C3612m0.DeviceUsedMemory);
    protected C3583j1 deviceVendorCollector = new C3583j1(getPollType(C3697r0.C3698a.f1753g.getFrequency()), C3612m0.DeviceVendor);
    private ArrayList<C3603l1> eventCollectors = new ArrayList<>();
    protected C3657o1 externalDriveFreeSpaceCollector = new C3657o1(getPollType(C3697r0.C3698a.f1755i.getFrequency()), C3612m0.ExternalDriveFreeSpace);
    protected C3664p1 externalDriveUsedSpaceCollector = new C3664p1(getPollType(C3697r0.C3698a.f1754h.getFrequency()), C3612m0.ExternalDriveUsedSpace);
    private ArrayList<C3677q1> feedCollectors = new ArrayList<>();
    private boolean initialized;
    protected C3614m2 interceptDisabledCollector = new C3614m2(C3612m0.InterceptDisabled);
    protected C3645n2 interceptEnabledCollector = new C3645n2(C3612m0.InterceptEnabled);
    protected C3678q2 invitationDisplayedCollector = new C3678q2(C3612m0.InvitationDisplayed);
    protected C3594k2 ipCollector = new C3594k2(getPollType(C3697r0.C3698a.f1762p.getFrequency()), C3612m0.IP);
    protected C3813z2 languageCollector = new C3813z2(getPollType(C3697r0.C3698a.f1760n.getFrequency()), C3612m0.Language);
    protected C3435a3 lastDeclineTimestampCollector = new C3435a3(C3612m0.LastDeclineTimestamp);
    protected C3448b3 lastSubmitTimestampCollector = new C3448b3(C3612m0.LastSubmitTimestamp);
    protected C3742t3 networkCarrierCollector = new C3742t3(getPollType(C3697r0.C3698a.f1759m.getFrequency()), C3612m0.NetworkCarrier);
    protected C3763v3 networkProviderCollector = new C3763v3(getPollType(C3697r0.C3698a.f1758l.getFrequency()), C3612m0.NetworkProvider);
    protected C3771w3 networkTypeCollector = new C3771w3(C3612m0.NetworkType);
    protected C3787x3 npsCollector;
    protected C3797y3 orientationCollector = new C3797y3(C3612m0.Orientation);
    protected C3814z3 osNameCollector = new C3814z3(getPollType(C3697r0.C3698a.f1756j.getFrequency()), C3612m0.OsName);
    protected C3437a4 osVersionCollector = new C3437a4(getPollType(C3697r0.C3698a.f1757k.getFrequency()), C3612m0.OsVersion);
    private ArrayList<C3493e4> pollingCollectors = new ArrayList<>();
    protected C3522f4 powerTypeCollector = new C3522f4(C3612m0.PowerType);
    protected C3543g4 promptDisplayedCollector;
    protected C3559h4 propertyIdCollector = new C3559h4(C3612m0.PropertyId);
    protected C3682q4 sdkAnalyticsVersionCollector;
    protected C3743t4 sdkFrameworkCollector;
    protected C3753u4 sdkVersionCollector = new C3753u4(getPollType(C3697r0.C3698a.f1768v.getFrequency()), C3612m0.SdkVersion);
    protected C3775w4 sessionCalculatedPercentageCollector = new C3775w4(getPollType(C3697r0.C3698a.f1769w.getFrequency()), C3612m0.SessionCalculatedPercentage);
    protected C3789x4 sessionIdCollector = new C3789x4(C3612m0.SessionId);
    protected C3800y4 sessionNumberCollector = new C3800y4(C3612m0.SessionNumber);
    protected C3590j5 timeInBackgroundCollector = new C3590j5(C3612m0.TimeInBackground);
    protected C3600k5 timeInForegroundCollector = new C3600k5(C3612m0.TimeInForeground);
    protected C3610l5 timezoneCollector = new C3610l5(getPollType(C3697r0.C3698a.f1761o.getFrequency()), C3612m0.Timezone);
    protected C3724s5 userEmailCollector = new C3724s5(C3612m0.UserEmail);
    protected C3744t5 userIdCollector = new C3744t5(C3612m0.UserId);
    protected C3791x5 userNameCollector = new C3791x5(C3612m0.UserName);

    private CollectorsInfrastructure() {
        this.timeInBackgroundCollector.mo55338a(true);
        this.timeInForegroundCollector.mo55338a(true);
        this.npsCollector = new C3787x3(C3612m0.NPS);
        this.csatCollector = new C3746u0(C3612m0.CSAT);
        this.appRatingLastDeclineTimestampCollector = new C3654o(C3612m0.AppRatingLastDeclineTimestamp);
        this.promptDisplayedCollector = new C3543g4(C3612m0.PromptDisplayed);
        this.appRatingLastAcceptedTimestampCollector = new C3641n(C3612m0.AppRatingLastAcceptedTimestamp);
        this.sdkAnalyticsVersionCollector = new C3682q4(C3612m0.SDKAnalyticsVersion);
        this.sdkFrameworkCollector = new C3743t4(C3612m0.SDKFramework);
        initCollectorsCollections();
        C3461c3.m562g().mo55265a((C3461c3.C3469h) this);
    }

    private boolean addObserver(C3602l0 l0Var, Observer observer, C3612m0 m0Var) {
        if (l0Var.mo55523a() != m0Var) {
            return false;
        }
        l0Var.addObserver(observer);
        return true;
    }

    protected static CollectorsInfrastructure getInstance() {
        if (instance == null && C3595k3.m1060d().mo55511a() != null) {
            instance = new CollectorsInfrastructure();
        }
        return instance;
    }

    private C3482d4 getPollType(Integer num) {
        return new C3482d4((long) num.intValue());
    }

    private void initCollectorsCollections() {
        this.feedCollectors.add(this.userIdCollector);
        this.feedCollectors.add(this.userEmailCollector);
        this.feedCollectors.add(this.userNameCollector);
        this.feedCollectors.add(this.customParametersCollector);
        this.feedCollectors.add(this.interceptEnabledCollector);
        this.feedCollectors.add(this.interceptDisabledCollector);
        this.feedCollectors.add(this.sdkAnalyticsVersionCollector);
        this.eventCollectors.add(this.networkTypeCollector);
        this.eventCollectors.add(this.powerTypeCollector);
        this.eventCollectors.add(this.batteryPercentageCollector);
        this.eventCollectors.add(this.orientationCollector);
        this.eventCollectors.add(this.lastDeclineTimestampCollector);
        this.eventCollectors.add(this.lastSubmitTimestampCollector);
        this.eventCollectors.add(this.sessionNumberCollector);
        this.eventCollectors.add(this.sessionIdCollector);
        this.eventCollectors.add(this.invitationDisplayedCollector);
        this.eventCollectors.add(this.propertyIdCollector);
        this.eventCollectors.add(this.npsCollector);
        this.eventCollectors.add(this.csatCollector);
        this.eventCollectors.add(this.appRatingLastDeclineTimestampCollector);
        this.eventCollectors.add(this.promptDisplayedCollector);
        this.eventCollectors.add(this.appRatingLastAcceptedTimestampCollector);
        this.eventCollectors.add(this.sdkFrameworkCollector);
        this.pollingCollectors.add(this.deviceModelCollector);
        this.pollingCollectors.add(this.deviceResolutionCollector);
        this.pollingCollectors.add(this.deviceUsedMemoryCollector);
        this.pollingCollectors.add(this.deviceFreeMemoryCollector);
        this.pollingCollectors.add(this.deviceUsedDiskSpaceCollector);
        this.pollingCollectors.add(this.deviceFreeDiskSpaceCollector);
        this.pollingCollectors.add(this.externalDriveUsedSpaceCollector);
        this.pollingCollectors.add(this.externalDriveFreeSpaceCollector);
        this.pollingCollectors.add(this.osNameCollector);
        this.pollingCollectors.add(this.osVersionCollector);
        this.pollingCollectors.add(this.networkProviderCollector);
        this.pollingCollectors.add(this.networkCarrierCollector);
        this.pollingCollectors.add(this.languageCollector);
        this.pollingCollectors.add(this.timezoneCollector);
        this.pollingCollectors.add(this.ipCollector);
        this.pollingCollectors.add(this.deviceIdCollector);
        this.pollingCollectors.add(this.appNameCollector);
        this.pollingCollectors.add(this.appIdCollector);
        this.pollingCollectors.add(this.appVersionCollector);
        this.pollingCollectors.add(this.sdkVersionCollector);
        this.pollingCollectors.add(this.sessionCalculatedPercentageCollector);
        this.pollingCollectors.add(this.deviceVendorCollector);
    }

    private void removeAllObservers() {
        Iterator<C3677q1> it = this.feedCollectors.iterator();
        while (it.hasNext()) {
            it.next().deleteObservers();
        }
        Iterator<C3493e4> it2 = this.pollingCollectors.iterator();
        while (it2.hasNext()) {
            it2.next().deleteObservers();
        }
        Iterator<C3603l1> it3 = this.eventCollectors.iterator();
        while (it3.hasNext()) {
            it3.next().deleteObservers();
        }
        this.timeInBackgroundCollector.deleteObservers();
        this.timeInForegroundCollector.deleteObservers();
    }

    private void setEventCollectorConfiguration(CollectorContract collectorContract, C3603l1 l1Var) {
        if (collectorContract == null) {
            collectorContract = l1Var.mo55204c();
        }
        if (collectorContract.getLifetime() != null) {
            l1Var.mo55524a(collectorContract.getLifetime());
        }
        if (collectorContract.isEnabled() != null) {
            l1Var.mo55338a(collectorContract.isEnabled().booleanValue());
        }
    }

    private void setPollingCollectorConfiguration(CollectorContract collectorContract, C3493e4 e4Var) {
        if (collectorContract == null) {
            collectorContract = e4Var.mo55204c();
        }
        if (collectorContract.getFrequency() != null) {
            e4Var.mo55336a(getPollType(collectorContract.getFrequency()));
        }
        if (collectorContract.getLifetime() != null) {
            e4Var.mo55524a(collectorContract.getLifetime());
        }
        if (collectorContract.isEnabled() != null) {
            e4Var.mo55338a(collectorContract.isEnabled().booleanValue());
        }
    }

    private void updateEventCollectors(CollectorsConfigurationContract collectorsConfigurationContract) {
        if (collectorsConfigurationContract != null) {
            setEventCollectorConfiguration(collectorsConfigurationContract.getNetworkTypeCollector(), this.networkTypeCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getPowerTypeCollector(), this.powerTypeCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getBatteryPercentageCollector(), this.batteryPercentageCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getOrientationCollector(), this.orientationCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getLastDeclineTimestampCollector(), this.lastDeclineTimestampCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getLastSubmitTimestampCollector(), this.lastSubmitTimestampCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getInvitationDisplayedCollector(), this.invitationDisplayedCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getSessionNumberCollector(), this.sessionNumberCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getSessionIdCollector(), this.sessionIdCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getPropertyIdCollector(), this.propertyIdCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getNpsCollector(), this.npsCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getCsatCollector(), this.csatCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getAppRatingLastDeclineTimestampCollector(), this.appRatingLastDeclineTimestampCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getPromptDisplayedCollector(), this.promptDisplayedCollector);
            setEventCollectorConfiguration(collectorsConfigurationContract.getAppRatingLastAcceptedTimestampCollector(), this.appRatingLastAcceptedTimestampCollector);
        }
    }

    private void updatedPollingCollectors(CollectorsConfigurationContract collectorsConfigurationContract) {
        if (collectorsConfigurationContract != null) {
            setPollingCollectorConfiguration(collectorsConfigurationContract.getDeviceModelCollector(), this.deviceModelCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getDeviceResolutionCollector(), this.deviceResolutionCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getDeviceUsedMemoryCollector(), this.deviceUsedMemoryCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getDeviceFreeMemoryCollector(), this.deviceFreeMemoryCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getDeviceUsedDiskSpaceCollector(), this.deviceUsedDiskSpaceCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getDeviceFreeDiskSpaceCollector(), this.deviceFreeDiskSpaceCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getExternalDriveUsedSpaceCollector(), this.externalDriveUsedSpaceCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getExternalDriveFreeSpaceCollector(), this.externalDriveFreeSpaceCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getOsNameCollector(), this.osNameCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getOsVersionCollector(), this.osVersionCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getNetworkProviderCollector(), this.networkProviderCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getNetworkCarrierCollector(), this.networkCarrierCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getLanguageCollector(), this.languageCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getTimezoneCollector(), this.timezoneCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getIpCollector().setEnabled(false), this.ipCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getDeviceIdCollector(), this.deviceIdCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getAppNameCollector(), this.appNameCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getAppIdCollector(), this.appIdCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getAppVersionCollector(), this.appVersionCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getSdkVersionCollector(), this.sdkVersionCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getSessionCalculatedPercentageCollector(), this.sessionCalculatedPercentageCollector);
            setPollingCollectorConfiguration(collectorsConfigurationContract.getDeviceVendorCollector(), this.deviceVendorCollector);
        }
    }

    public void addObserverToCollector(Observer observer, C3612m0 m0Var) {
        Iterator<C3677q1> it = this.feedCollectors.iterator();
        while (it.hasNext()) {
            if (addObserver(it.next(), observer, m0Var)) {
                return;
            }
        }
        Iterator<C3493e4> it2 = this.pollingCollectors.iterator();
        while (it2.hasNext()) {
            if (addObserver(it2.next(), observer, m0Var)) {
                return;
            }
        }
        Iterator<C3603l1> it3 = this.eventCollectors.iterator();
        while (it3.hasNext()) {
            if (addObserver(it3.next(), observer, m0Var)) {
                return;
            }
        }
        if (!addObserver(this.timeInBackgroundCollector, observer, m0Var) && addObserver(this.timeInForegroundCollector, observer, m0Var)) {
        }
    }

    public void addObserverToCollectors(Observer observer) {
        Iterator<C3677q1> it = this.feedCollectors.iterator();
        while (it.hasNext()) {
            it.next().addObserver(observer);
        }
        Iterator<C3493e4> it2 = this.pollingCollectors.iterator();
        while (it2.hasNext()) {
            it2.next().addObserver(observer);
        }
        Iterator<C3603l1> it3 = this.eventCollectors.iterator();
        while (it3.hasNext()) {
            it3.next().addObserver(observer);
        }
        this.timeInBackgroundCollector.addObserver(observer);
        this.timeInForegroundCollector.addObserver(observer);
    }

    public void clearAndDisconnect() {
        C3490e3.m659a("Collectors");
        removeAllObservers();
        unregister();
        instance = null;
    }

    public String getAppId() {
        return (String) this.appIdCollector.mo55504f();
    }

    public String getAppName() {
        return (String) this.appNameCollector.mo55504f();
    }

    public Long getAppRatingLastAcceptedTimestamp() {
        return (Long) this.appRatingLastAcceptedTimestampCollector.mo55504f();
    }

    public Long getAppRatingLastDeclineTimestamp() {
        return (Long) this.appRatingLastDeclineTimestampCollector.mo55504f();
    }

    public String getAppVersion() {
        return (String) this.appVersionCollector.mo55504f();
    }

    public Integer getBatteryPercentage() {
        return (Integer) this.batteryPercentageCollector.mo55504f();
    }

    /* access modifiers changed from: package-private */
    public Object getByName(String str) {
        try {
            String replaceFirst = str.replaceFirst(String.valueOf(str.charAt(0)), String.valueOf(str.toLowerCase().charAt(0)));
            Class<?> cls = getClass();
            return ((C3602l0) cls.getDeclaredField(replaceFirst + "Collector").get(this)).mo55504f();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return null;
        }
    }

    public Integer getCSAT() {
        return (Integer) this.csatCollector.mo55504f();
    }

    public ArrayList<CustomParameter> getCustomParameters() {
        return this.customParametersCollector.mo55873j();
    }

    public String getDeviceFreeDiskSpace() {
        return (String) this.deviceFreeDiskSpaceCollector.mo55504f();
    }

    public String getDeviceFreeMemory() {
        return (String) this.deviceFreeMemoryCollector.mo55504f();
    }

    public String getDeviceId() {
        return (String) this.deviceIdCollector.mo55504f();
    }

    public String getDeviceModel() {
        return (String) this.deviceModelCollector.mo55504f();
    }

    public String getDeviceResolution() {
        return (String) this.deviceResolutionCollector.mo55504f();
    }

    public Long getDeviceUsedDiskSpace() {
        return (Long) this.deviceUsedDiskSpaceCollector.mo55504f();
    }

    public Long getDeviceUsedMemory() {
        return (Long) this.deviceUsedMemoryCollector.mo55504f();
    }

    public String getDeviceVendor() {
        return (String) this.deviceVendorCollector.mo55504f();
    }

    public String getExternalDriveFreeSpace() {
        return (String) this.externalDriveFreeSpaceCollector.mo55504f();
    }

    public Long getExternalDriveUsedSpace() {
        return (Long) this.externalDriveUsedSpaceCollector.mo55504f();
    }

    public String getIp() {
        return (String) this.ipCollector.mo55504f();
    }

    public String getLanguage() {
        return (String) this.languageCollector.mo55504f();
    }

    public Long getLastDeclineTimestamp() {
        return (Long) this.lastDeclineTimestampCollector.mo55504f();
    }

    public Long getLastSubmitTimestamp() {
        return (Long) this.lastSubmitTimestampCollector.mo55504f();
    }

    public Integer getNPS() {
        return (Integer) this.npsCollector.mo55504f();
    }

    public String getNetworkCarrier() {
        return (String) this.networkCarrierCollector.mo55504f();
    }

    public String getNetworkProvider() {
        return (String) this.networkProviderCollector.mo55504f();
    }

    public Double getNetworkSpeed() {
        return Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public String getNetworkType() {
        return (String) this.networkTypeCollector.mo55504f();
    }

    public String getOSName() {
        return (String) this.osNameCollector.mo55504f();
    }

    public String getOSVersion() {
        return (String) this.osVersionCollector.mo55504f();
    }

    public C3797y3.C3799b getOrientation() {
        return (C3797y3.C3799b) this.orientationCollector.mo55504f();
    }

    public String getPowerType() {
        return (String) this.powerTypeCollector.mo55504f();
    }

    public Long getPropertyId() {
        return (Long) this.propertyIdCollector.mo55504f();
    }

    public C3682q4.C3683a getSDKAnalyticsVersion() {
        return (C3682q4.C3683a) this.sdkAnalyticsVersionCollector.mo55504f();
    }

    public MDSdkFrameworkType getSDKFramework() {
        return (MDSdkFrameworkType) this.sdkFrameworkCollector.mo55504f();
    }

    public String getSDKVersion() {
        return (String) this.sdkVersionCollector.mo55504f();
    }

    public Integer getSessionCalculatedPercentage() {
        return (Integer) this.sessionCalculatedPercentageCollector.mo55504f();
    }

    public String getSessionId() {
        return (String) this.sessionIdCollector.mo55504f();
    }

    public Integer getSessionNumber() {
        return (Integer) this.sessionNumberCollector.mo55504f();
    }

    public Long getTimeInBackground() {
        return this.timeInBackgroundCollector.m1039f();
    }

    public Long getTimeInForeground() {
        return this.timeInForegroundCollector.m1086f();
    }

    public String getTimezone() {
        return (String) this.timezoneCollector.mo55504f();
    }

    public String getUserEmail() {
        return (String) this.userEmailCollector.mo55504f();
    }

    public String getUserID() {
        return (String) this.userIdCollector.mo55504f();
    }

    public String getUserName() {
        return (String) this.userNameCollector.mo55504f();
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public String isInvitationDisplayed() {
        return String.valueOf(this.invitationDisplayedCollector.mo55504f());
    }

    public String isPromptDisplayed() {
        return String.valueOf(this.promptDisplayedCollector.mo55504f());
    }

    public void onBackground() {
        unregister();
    }

    public void onForeground() {
        register();
    }

    public void pollAll() {
        Iterator<C3493e4> it = this.pollingCollectors.iterator();
        while (it.hasNext()) {
            it.next().mo55340l();
        }
        Iterator<C3603l1> it2 = this.eventCollectors.iterator();
        while (it2.hasNext()) {
            it2.next().mo55533k();
        }
    }

    public void register() {
        Iterator<C3603l1> it = this.eventCollectors.iterator();
        while (it.hasNext()) {
            it.next().mo55205l();
        }
        Iterator<C3493e4> it2 = this.pollingCollectors.iterator();
        while (it2.hasNext()) {
            it2.next().mo55341m();
        }
    }

    public void setInitialized(boolean z) {
        this.initialized = z;
    }

    public void setPropertyId(Long l) {
        this.propertyIdCollector.mo55525a(l);
    }

    public void setSDKAnalyticsVersion(C3682q4.C3683a aVar) {
        this.sdkAnalyticsVersionCollector.mo55525a(aVar);
    }

    public void setSDKFramework(MDSdkFrameworkType mDSdkFrameworkType) {
        this.sdkFrameworkCollector.mo55525a(mDSdkFrameworkType);
    }

    public void setSessionId(String str) {
        this.sessionIdCollector.mo55525a(str);
    }

    public void setSessionNumber(Integer num) {
        this.sessionNumberCollector.mo55525a(num);
    }

    public void setUserEmail(String str) {
        this.userEmailCollector.mo55525a(str);
    }

    public void setUserID(String str) {
        this.userIdCollector.mo55525a(str);
    }

    public void setUserName(String str) {
        this.userNameCollector.mo55525a(str);
    }

    public void stopCollectors() {
        Iterator<C3603l1> it = this.eventCollectors.iterator();
        while (it.hasNext()) {
            it.next().mo55338a(false);
        }
        Iterator<C3493e4> it2 = this.pollingCollectors.iterator();
        while (it2.hasNext()) {
            it2.next().mo55338a(false);
        }
        Iterator<C3677q1> it3 = this.feedCollectors.iterator();
        while (it3.hasNext()) {
            it3.next().mo55338a(false);
        }
    }

    public void unregister() {
        Iterator<C3603l1> it = this.eventCollectors.iterator();
        while (it.hasNext()) {
            it.next().mo55206m();
        }
        Iterator<C3493e4> it2 = this.pollingCollectors.iterator();
        while (it2.hasNext()) {
            it2.next().mo55342n();
        }
    }

    public void updateConfiguration(CollectorsConfigurationContract collectorsConfigurationContract) {
        if (collectorsConfigurationContract == null) {
            collectorsConfigurationContract = new CollectorsConfigurationContract();
        }
        C3600k5 k5Var = this.timeInForegroundCollector;
        if (k5Var != null) {
            k5Var.mo55522o();
        }
        C3590j5 j5Var = this.timeInBackgroundCollector;
        if (j5Var != null) {
            j5Var.mo55505n();
        }
        updateEventCollectors(collectorsConfigurationContract);
        updatedPollingCollectors(collectorsConfigurationContract);
    }
}

package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3682q4;
import com.medallia.digital.mobilesdk.C3797y3;
import java.util.ArrayList;
import java.util.Observer;

/* renamed from: com.medallia.digital.mobilesdk.o0 */
interface C3656o0 {
    void addObserverToCollector(Observer observer, C3612m0 m0Var);

    void addObserverToCollectors(Observer observer);

    String getAppId();

    String getAppName();

    Long getAppRatingLastAcceptedTimestamp();

    Long getAppRatingLastDeclineTimestamp();

    String getAppVersion();

    Integer getBatteryPercentage();

    Integer getCSAT();

    ArrayList<CustomParameter> getCustomParameters();

    String getDeviceFreeDiskSpace();

    String getDeviceFreeMemory();

    String getDeviceId();

    String getDeviceModel();

    String getDeviceResolution();

    Long getDeviceUsedDiskSpace();

    Long getDeviceUsedMemory();

    String getDeviceVendor();

    String getExternalDriveFreeSpace();

    Long getExternalDriveUsedSpace();

    String getIp();

    String getLanguage();

    Long getLastDeclineTimestamp();

    Long getLastSubmitTimestamp();

    Integer getNPS();

    String getNetworkCarrier();

    String getNetworkProvider();

    Double getNetworkSpeed();

    String getNetworkType();

    String getOSName();

    String getOSVersion();

    C3797y3.C3799b getOrientation();

    String getPowerType();

    Long getPropertyId();

    C3682q4.C3683a getSDKAnalyticsVersion();

    MDSdkFrameworkType getSDKFramework();

    String getSDKVersion();

    Integer getSessionCalculatedPercentage();

    String getSessionId();

    Integer getSessionNumber();

    Long getTimeInBackground();

    Long getTimeInForeground();

    String getTimezone();

    String getUserEmail();

    String getUserID();

    String getUserName();

    String isInvitationDisplayed();

    String isPromptDisplayed();

    void pollAll();

    void register();

    void setPropertyId(Long l);

    void setSDKAnalyticsVersion(C3682q4.C3683a aVar);

    void setSDKFramework(MDSdkFrameworkType mDSdkFrameworkType);

    void setSessionId(String str);

    void setSessionNumber(Integer num);

    void setUserEmail(String str);

    void setUserID(String str);

    void setUserName(String str);

    void stopCollectors();

    void unregister();

    void updateConfiguration(CollectorsConfigurationContract collectorsConfigurationContract);
}

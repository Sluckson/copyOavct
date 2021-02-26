package com.medallia.digital.mobilesdk;

import androidx.exifinterface.media.ExifInterface;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.medallia.digital.mobilesdk.C3697r0;

/* renamed from: com.medallia.digital.mobilesdk.m0 */
enum C3612m0 {
    Unknown("", -1, (String) null),
    AppId("AppId", 0, C3697r0.C3698a.f1766t.getLifetime()),
    AppName("AppName", 1, C3697r0.C3698a.f1765s.getLifetime()),
    AppVersion("AppVersion", 2, C3697r0.C3698a.f1767u.getLifetime()),
    BatteryPercentage("BatteryPercentage", 3, C3697r0.C3698a.f1727C.getLifetime()),
    CustomParameters("CustomParameters", 4, C3697r0.C3698a.f1734J.getLifetime()),
    DeviceFreeDiskSpace("DeviceFreeDiskSpace", 5, C3697r0.C3698a.f1747a.getLifetime()),
    DeviceFreeMemoryCollector("DeviceFreeMemory", 6, C3697r0.C3698a.f1748b.getLifetime()),
    DeviceId("DeviceId", 7, C3697r0.C3698a.f1764r.getLifetime()),
    DeviceModel(AnalyticsContract.Analytics.COLUMN_NAME_DEVICE_MODEL_NO, 8, C3697r0.C3698a.f1749c.getLifetime()),
    DeviceResolution("DeviceResolution", 9, C3697r0.C3698a.f1750d.getLifetime()),
    DeviceUsedDiskSpace("DeviceUsedDiskSpace", 10, C3697r0.C3698a.f1751e.getLifetime()),
    DeviceUsedMemory("DeviceUsedMemory", 11, C3697r0.C3698a.f1752f.getLifetime()),
    DeviceVendor("DeviceVendor", 12, C3697r0.C3698a.f1753g.getLifetime()),
    ExternalDriveFreeSpace("ExternalDriveFreeSpace", 13, C3697r0.C3698a.f1755i.getLifetime()),
    ExternalDriveUsedSpace("ExternalDriveUsedSpace", 14, C3697r0.C3698a.f1754h.getLifetime()),
    InvitationDisplayed("InvitationDisplayed", 15, C3697r0.C3698a.f1735K.getLifetime()),
    InterceptEnabled("InterceptEnabled", 16, C3697r0.C3698a.f1738N.getLifetime()),
    InterceptDisabled("InterceptDisabled", 17, C3697r0.C3698a.f1739O.getLifetime()),
    IP("IP", 18, C3697r0.C3698a.f1762p.getLifetime()),
    Language("Language", 19, C3697r0.C3698a.f1760n.getLifetime()),
    LastDeclineTimestamp("LastDeclineTimestamp", 20, C3697r0.C3698a.f1729E.getLifetime()),
    LastSubmitTimestamp("LastSubmitTimestamp", 21, C3697r0.C3698a.f1730F.getLifetime()),
    TimeInBackground("TimeInBackground", 22, C3697r0.C3698a.f1736L.getLifetime()),
    TimeInForeground("TimeInForeground", 23, C3697r0.C3698a.f1737M.getLifetime()),
    NetworkCarrier("NetworkCarrier", 24, C3697r0.C3698a.f1759m.getLifetime()),
    NetworkProvider("NetworkProvider", 25, C3697r0.C3698a.f1758l.getLifetime()),
    NetworkSpeed("NetworkSpeed", 26, C3697r0.C3698a.f1763q.getLifetime()),
    NetworkType("NetworkType", 27, C3697r0.C3698a.f1772z.getLifetime()),
    Orientation(ExifInterface.TAG_ORIENTATION, 28, C3697r0.C3698a.f1728D.getLifetime()),
    OsName("OsName", 29, C3697r0.C3698a.f1756j.getLifetime()),
    OsVersion("OsVersion", 30, C3697r0.C3698a.f1757k.getLifetime()),
    PowerType("PowerType", 31, C3697r0.C3698a.f1725A.getLifetime()),
    PropertyId("PropertyId", 32, C3697r0.C3698a.f1726B.getLifetime()),
    SdkVersion("SdkVersion", 33, C3697r0.C3698a.f1768v.getLifetime()),
    SessionCalculatedPercentage("SessionCalculatedPercentage", 34, C3697r0.C3698a.f1769w.getLifetime()),
    SessionNumber("SessionNumber", 35, C3697r0.C3698a.f1770x.getLifetime()),
    SessionId("SessionId", 36, C3697r0.C3698a.f1771y.getLifetime()),
    Timezone("Timezone", 37, C3697r0.C3698a.f1761o.getLifetime()),
    UserEmail("UserEmail", 38, C3697r0.C3698a.f1732H.getLifetime()),
    UserId("UserId", 39, C3697r0.C3698a.f1731G.getLifetime()),
    UserName("UserName", 40, C3697r0.C3698a.f1733I.getLifetime()),
    NPS("NPS", 41, C3697r0.C3698a.f1740P.getLifetime()),
    CSAT("CSAT", 42, C3697r0.C3698a.f1741Q.getLifetime()),
    AppRatingLastDeclineTimestamp("AppRatingLastDeclineTimestamp", 43, C3697r0.C3698a.f1742R.getLifetime()),
    PromptDisplayed("PromptDisplayed", 44, C3697r0.C3698a.f1743S.getLifetime()),
    AppRatingLastAcceptedTimestamp("AppRatingLastAcceptedTimestamp", 45, C3697r0.C3698a.f1744T.getLifetime()),
    SDKAnalyticsVersion("SDKAnalyticsVersion", 46, C3697r0.C3698a.f1745U.getLifetime()),
    SDKFramework("SDKFrameworkCollector", 47, C3697r0.C3698a.f1746V.getLifetime());
    

    /* renamed from: id */
    private int f1434id;
    private Lifetime lifetime;
    private String name;

    private C3612m0(String str, int i, Lifetime lifetime2) {
        this.name = str;
        this.f1434id = i;
        this.lifetime = lifetime2;
    }

    /* access modifiers changed from: protected */
    public int getId() {
        return this.f1434id;
    }

    /* access modifiers changed from: protected */
    public Lifetime getLifetime() {
        return this.lifetime;
    }

    /* access modifiers changed from: protected */
    public String getName() {
        return this.name;
    }
}

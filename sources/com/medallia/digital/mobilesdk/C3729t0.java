package com.medallia.digital.mobilesdk;

import android.util.Pair;
import com.medallia.digital.mobilesdk.C3815z4;
import java.io.File;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.t0 */
class C3729t0 {

    /* renamed from: a */
    private static final Long f1877a = 604800000L;

    /* renamed from: com.medallia.digital.mobilesdk.t0$a */
    static class C3730a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ String f1878a;

        C3730a(String str) {
            this.f1878a = str;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3490e3.m665e("Saving local configuration storage, timestamp, uuid");
            long currentTimeMillis = System.currentTimeMillis();
            String format = String.format(Locale.US, "%s/%d", new Object[]{"configuration", Long.valueOf(currentTimeMillis)});
            C3815z4.m2010d().mo55983b(C3815z4.C3816a.LOCAL_CONFIGURATION_TIMESTAMP, currentTimeMillis);
            C3785x1.m1885a(format, this.f1878a);
        }
    }

    C3729t0() {
    }

    /* renamed from: a */
    protected static Pair<String, Boolean> m1642a() {
        C3490e3.m665e("Deleting local configuration storage, timestamp, uuid");
        C3815z4.m2010d().mo55983b(C3815z4.C3816a.LOCAL_CONFIGURATION_TIMESTAMP, 0);
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.UUID, (String) null);
        return C3785x1.m1884a("configuration");
    }

    /* renamed from: a */
    protected static Pair<String, Boolean> m1643a(String str) {
        Pair<String, Boolean> a = m1642a();
        new Thread(new C3730a(str)).start();
        return a;
    }

    /* renamed from: a */
    protected static ConfigurationContract m1644a(File file) {
        if (file == null) {
            return null;
        }
        return ModelFactory.getInstance().createConfiguration(C3785x1.m1900e(file));
    }

    /* renamed from: a */
    protected static boolean m1645a(ConfigurationContract configurationContract) {
        Long offlineConfigurationExpirationTime = configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().getOfflineConfigurationExpirationTime();
        if (offlineConfigurationExpirationTime == null) {
            offlineConfigurationExpirationTime = f1877a;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return offlineConfigurationExpirationTime.longValue() < currentTimeMillis - C3815z4.m2010d().mo55974a(C3815z4.C3816a.LOCAL_CONFIGURATION_TIMESTAMP, currentTimeMillis);
    }

    /* renamed from: a */
    protected static boolean m1646a(File file, ConfigurationContract configurationContract) {
        return (configurationContract == null || file == null || configurationContract.getSdkConfiguration() == null || configurationContract.getSdkConfiguration().getMedalliaDigitalBrain() == null) ? false : true;
    }

    /* renamed from: b */
    protected static File m1647b() {
        File c = C3785x1.m1895c("configuration");
        if (c == null || !c.isDirectory() || c.listFiles() == null || c.listFiles().length <= 0) {
            return null;
        }
        return c.listFiles()[0];
    }
}

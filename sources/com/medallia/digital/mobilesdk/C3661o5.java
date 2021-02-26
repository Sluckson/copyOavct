package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3815z4;

/* renamed from: com.medallia.digital.mobilesdk.o5 */
class C3661o5 {
    C3661o5() {
    }

    /* renamed from: a */
    protected static void m1405a() {
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.UUID_URL, (String) null);
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.UUID, (String) null);
    }

    /* renamed from: a */
    private static void m1406a(String str) {
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.UUID, str);
    }

    /* renamed from: a */
    protected static boolean m1407a(ConfigurationUUID configurationUUID) {
        if (!(configurationUUID == null || configurationUUID.getUuid() == null)) {
            String b = m1408b();
            if (b == null) {
                C3490e3.m665e("New UUID is not equal to previous using remote configuration");
                return false;
            } else if (b.equals(configurationUUID.getUuid())) {
                C3490e3.m661b("Uuid is equal -> using previous config file");
                return true;
            } else {
                C3490e3.m665e("New UUID is not equal to previous using remote configuration");
            }
        }
        return false;
    }

    /* renamed from: b */
    protected static String m1408b() {
        return C3815z4.m2010d().mo55975a(C3815z4.C3816a.UUID, (String) null);
    }

    /* renamed from: b */
    protected static boolean m1409b(ConfigurationUUID configurationUUID) {
        if (configurationUUID == null || configurationUUID.getUuid() == null) {
            return false;
        }
        String b = m1408b();
        if (b != null && b.equals(configurationUUID.getUuid())) {
            C3490e3.m661b("Uuid is equal -> using previous config file");
            return true;
        }
        m1406a(configurationUUID.getUuid());
        C3490e3.m665e("New uuid saved");
        return false;
    }
}

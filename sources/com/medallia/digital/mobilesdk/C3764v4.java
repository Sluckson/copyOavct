package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3815z4;
import java.util.UUID;

/* renamed from: com.medallia.digital.mobilesdk.v4 */
class C3764v4 {

    /* renamed from: a */
    private long f1955a = -1;

    C3764v4() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo55874a() {
        return this.f1955a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55875a(ConfigurationContract configurationContract) {
        this.f1955a = (configurationContract == null || configurationContract.getSdkConfiguration() == null || configurationContract.getSdkConfiguration().getMedalliaDigitalBrain() == null || configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().getSessionInactivityTime().longValue() <= 0) ? 60000 : configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().getSessionInactivityTime().longValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55876a(long j) {
        return j > this.f1955a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55877b() {
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.PREVIOUS_SESSION_ID, C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, (String) null));
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.SESSION_ID, UUID.randomUUID().toString());
        C3815z4.m2010d().mo55982b(C3815z4.C3816a.SESSION_COUNTER, C3815z4.m2010d().mo55973a(C3815z4.C3816a.SESSION_COUNTER, 0) + 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo55878c() {
        CollectorsInfrastructure.getInstance().setSessionNumber(Integer.valueOf(C3815z4.m2010d().mo55973a(C3815z4.C3816a.SESSION_COUNTER, 0)));
        CollectorsInfrastructure.getInstance().setSessionId(C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, (String) null));
    }
}

package com.medallia.digital.mobilesdk;

import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3815z4;

/* renamed from: com.medallia.digital.mobilesdk.x2 */
class C3786x2 implements C3796y2 {
    C3786x2() {
    }

    /* renamed from: a */
    public boolean mo55918a() {
        boolean a = C3815z4.m2010d().mo55979a(C3815z4.C3816a.IS_SDK_KILLED, false);
        boolean a2 = C3815z4.m2010d().mo55979a(C3815z4.C3816a.SHOULD_CHECK_OS, false);
        Long valueOf = Long.valueOf(C3815z4.m2010d().mo55974a(C3815z4.C3816a.SDK_RECOVER_TIMESTAMP, 0));
        if (a) {
            return C3723s4.m1629b() || (a2 && C3723s4.m1628a()) || (valueOf.longValue() != -1 && mo55922c() >= valueOf.longValue());
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo55919a(KillStatus killStatus) {
        return (killStatus == null || killStatus.isKilled() == null || !killStatus.isKilled().booleanValue()) ? false : true;
    }

    /* renamed from: b */
    public void mo55920b(KillStatus killStatus) {
        long j;
        C3815z4.C3816a aVar;
        C3815z4 z4Var;
        if (killStatus != null && killStatus.isKilled().booleanValue()) {
            C3815z4.m2010d().mo55983b(C3815z4.C3816a.SDK_KILL_TIMESTAMP, System.currentTimeMillis());
            if (killStatus.getShouldCheckRestoreOnOsChange() != null) {
                C3815z4.m2010d().mo55985b(C3815z4.C3816a.SHOULD_CHECK_OS, killStatus.getShouldCheckRestoreOnOsChange().booleanValue());
            }
            if (killStatus.getRestorePollingInterval() != null) {
                if (killStatus.getRestorePollingInterval().longValue() == -1) {
                    z4Var = C3815z4.m2010d();
                    aVar = C3815z4.C3816a.SDK_RECOVER_TIMESTAMP;
                    j = killStatus.getRestorePollingInterval().longValue();
                } else {
                    z4Var = C3815z4.m2010d();
                    aVar = C3815z4.C3816a.SDK_RECOVER_TIMESTAMP;
                    j = System.currentTimeMillis() + killStatus.getRestorePollingInterval().longValue();
                }
                z4Var.mo55983b(aVar, j);
            }
            if (killStatus.isKilled() != null) {
                C3815z4.m2010d().mo55985b(C3815z4.C3816a.IS_SDK_KILLED, killStatus.isKilled().booleanValue());
            }
        }
    }

    /* renamed from: b */
    public boolean mo55921b() {
        return C3815z4.m2010d().mo55979a(C3815z4.C3816a.IS_SDK_KILLED, false);
    }

    @VisibleForTesting
    /* renamed from: c */
    public long mo55922c() {
        return System.currentTimeMillis();
    }

    /* renamed from: c */
    public boolean mo55923c(KillStatus killStatus) {
        return !mo55919a(killStatus) && mo55921b();
    }

    public void clear() {
        C3815z4.m2010d().mo55985b(C3815z4.C3816a.IS_SDK_KILLED, false);
        C3815z4.m2010d().mo55983b(C3815z4.C3816a.SDK_RECOVER_TIMESTAMP, 0);
        C3815z4.m2010d().mo55983b(C3815z4.C3816a.SDK_KILL_TIMESTAMP, 0);
    }
}

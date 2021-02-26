package com.salesforce.marketingcloud.proximity;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.proximity.C4124g;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.proximity.f */
class C4123f extends C4124g {

    /* renamed from: e */
    private final boolean f3351e;

    /* renamed from: f */
    private final JSONObject f3352f;

    public C4123f(boolean z, JSONObject jSONObject) {
        this.f3351e = z;
        this.f3352f = jSONObject;
    }

    /* renamed from: a */
    public JSONObject mo56200a() {
        return this.f3352f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo56202a(@NonNull InitializationStatus.C3832a aVar) {
        aVar.mo56108d(this.f3351e);
    }

    /* renamed from: a */
    public void mo56919a(@NonNull C4124g.C4125a aVar) {
        String str = f3356d;
        Object[] objArr = new Object[1];
        objArr[0] = aVar != null ? aVar.getClass().getSimpleName() : "null";
        C4039h.m2817a(str, "registerProximityEventListener(%s) call ignored because of unsupported device.", objArr);
    }

    /* renamed from: a */
    public void mo56920a(List<C4122e> list) {
        C4039h.m2817a(f3356d, "unmonitorBeaconRegions call ignored because of unsupported device.", new Object[0]);
    }

    /* renamed from: b */
    public void mo56922b(@NonNull C4124g.C4125a aVar) {
        String str = f3356d;
        Object[] objArr = new Object[1];
        objArr[0] = aVar != null ? aVar.getClass().getSimpleName() : "null";
        C4039h.m2817a(str, "unregisterProximityEventListener(%s) call ignored because of unsupported device.", objArr);
    }

    /* renamed from: b */
    public void mo56923b(List<C4122e> list) {
        C4039h.m2817a(f3356d, "monitorBeaconRegions call ignored because of unsupported device.", new Object[0]);
    }

    /* renamed from: d */
    public void mo56925d() {
        C4039h.m2817a(f3356d, "stopMonitoringBeaconRegions() call ignored because of unsupported device.", new Object[0]);
    }
}

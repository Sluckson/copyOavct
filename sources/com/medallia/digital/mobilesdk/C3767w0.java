package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3815z4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.medallia.digital.mobilesdk.w0 */
class C3767w0 implements C3713r5 {

    /* renamed from: b */
    private static C3767w0 f1969b;

    /* renamed from: a */
    private ArrayList<CustomParameter> f1970a = new ArrayList<>();

    C3767w0() {
    }

    /* renamed from: a */
    private void m1811a(String str, Object obj) {
        CustomParameter customParameter = new CustomParameter();
        if (!customParameter.mo54992a(str)) {
            C3490e3.m663c("name can't be empty");
        } else if (!customParameter.mo54991a(obj)) {
            C3490e3.m663c("Object is not a valid type(String, int, long, double, float, bool");
        } else {
            Iterator<CustomParameter> it = this.f1970a.iterator();
            while (it.hasNext()) {
                CustomParameter next = it.next();
                if (next.mo54993b().equals(customParameter.mo54993b())) {
                    next.mo54991a(customParameter.mo54994c());
                    return;
                }
            }
            this.f1970a.add(customParameter);
        }
    }

    /* renamed from: b */
    protected static C3767w0 m1812b() {
        if (f1969b == null) {
            f1969b = new C3767w0();
        }
        return f1969b;
    }

    /* renamed from: c */
    private void m1813c() {
        StringBuilder sb = new StringBuilder("Set " + this.f1970a.size() + " custom parameters successfully\n");
        for (int i = 0; i < this.f1970a.size(); i++) {
            sb.append(this.f1970a.get(i).mo54997e());
            sb.append("\n");
        }
        C3490e3.m665e(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55893a() {
        if (C3815z4.m2010d().mo55977a(C3815z4.C3816a.CUSTOM_PARAMETERS)) {
            C3490e3.m665e("Cleared custom parameters");
        } else {
            C3490e3.m663c("Failed to clear custom parameters - storage is not initiated");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55894a(String str, Object obj, boolean z) {
        m1811a(str, obj);
        mo55896a(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55895a(HashMap<String, Object> hashMap, boolean z) {
        if (hashMap == null || hashMap.isEmpty()) {
            C3490e3.m663c("Hashmap is not valid");
            return;
        }
        for (Map.Entry next : hashMap.entrySet()) {
            m1811a((String) next.getKey(), next.getValue());
        }
        mo55896a(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55896a(boolean z) {
        if (!this.f1970a.isEmpty() && CollectorsInfrastructure.getInstance().isInitialized() && C3815z4.m2010d().mo55986c() && z) {
            if (C3815z4.m2010d().mo55978a(C3815z4.C3816a.CUSTOM_PARAMETERS, ModelFactory.getInstance().customParametersToJsonArray(this.f1970a))) {
                m1813c();
            }
            Iterator<CustomParameter> it = this.f1970a.iterator();
            while (it.hasNext()) {
                CollectorsInfrastructure.getInstance().customParametersCollector.mo55525a(it.next());
            }
            this.f1970a.clear();
        }
    }

    public void clearAndDisconnect() {
        C3490e3.m659a("CustomParameters");
        mo55893a();
        f1969b = null;
    }
}

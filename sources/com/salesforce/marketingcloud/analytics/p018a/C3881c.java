package com.salesforce.marketingcloud.analytics.p018a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.iaai.android.old.utils.constants.Constants;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.analytics.C3913e;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p021c.C3953g;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.analytics.a.c */
public class C3881c implements C3872b.C3874a, C3949f.C3951a {

    /* renamed from: a */
    private static final String f2274a = C4039h.m2810a((Class<?>) C3881c.class);

    /* renamed from: b */
    private final MarketingCloudConfig f2275b;

    /* renamed from: c */
    private final String f2276c;

    /* renamed from: d */
    private final C4016h f2277d;

    /* renamed from: e */
    private final C3949f f2278e;

    /* renamed from: f */
    private final C3872b f2279f;

    public C3881c(MarketingCloudConfig marketingCloudConfig, String str, C4016h hVar, C3949f fVar, C3872b bVar) {
        this.f2275b = (MarketingCloudConfig) C4028g.m2762a(marketingCloudConfig, "Config is null");
        this.f2276c = (String) C4028g.m2762a(str, "DeviceId is null");
        this.f2277d = (C4016h) C4028g.m2762a(hVar, "MCStorage is null");
        this.f2278e = (C3949f) C4028g.m2762a(fVar, "RequestManager is null");
        this.f2279f = (C3872b) C4028g.m2762a(bVar, "AlarmScheduler is null");
        fVar.mo56415a(C3944d.ET_ANALYTICS, (C3949f.C3951a) this);
        bVar.mo56203a((C3872b.C3874a) this, C3848a.C3850a.ET_ANALYTICS);
    }

    /* renamed from: a */
    private JSONArray m2176a(String str, String str2, List<C3910d> list) {
        JSONArray jSONArray = new JSONArray();
        for (C3910d next : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("etAppId", str);
                jSONObject.put(Constants.DEVICEID_HEADER, str2);
                jSONObject.put("eventDate", C4029h.m2766a(next.mo56311b()));
                jSONObject.put("value", next.mo56315e());
                jSONObject.put("analyticTypes", new JSONArray(Collections.singletonList(Integer.valueOf(next.mo56314d()))));
                jSONObject.put("objectIds", new JSONArray(next.mo56316f()));
                String i = next.mo56319i();
                if (!TextUtils.isEmpty(i)) {
                    jSONObject.put("requestId", i);
                }
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                C4039h.m2830e(f2274a, e, "Failed to update EtAnalyticItem or convert it to JSON for transmission.", new Object[0]);
            }
        }
        return jSONArray;
    }

    /* renamed from: b */
    private void m2177b() {
        List<C3910d> c = this.f2277d.mo56535g().mo56442c();
        if (!c.isEmpty()) {
            C3949f fVar = this.f2278e;
            C3944d dVar = C3944d.ET_ANALYTICS;
            MarketingCloudConfig marketingCloudConfig = this.f2275b;
            fVar.mo56416a(dVar.mo56403a(marketingCloudConfig, m2176a(marketingCloudConfig.applicationId(), this.f2276c, c).toString()).mo56408a(C3913e.m2297a(c)));
            return;
        }
        this.f2279f.mo56213c(C3848a.C3850a.ET_ANALYTICS);
    }

    /* renamed from: a */
    public void mo56261a() {
        this.f2278e.mo56414a(C3944d.ET_ANALYTICS);
        this.f2279f.mo56213c(C3848a.C3850a.ET_ANALYTICS);
        this.f2279f.mo56206a(C3848a.C3850a.ET_ANALYTICS);
    }

    /* renamed from: a */
    public void mo56216a(@NonNull C3848a.C3850a aVar) {
        if (aVar == C3848a.C3850a.ET_ANALYTICS) {
            m2177b();
        }
    }

    /* renamed from: a */
    public void mo56262a(C3946e eVar, C3953g gVar) {
        if (gVar.mo56419h()) {
            this.f2279f.mo56214d(C3848a.C3850a.ET_ANALYTICS);
            if (eVar.mo56409j() != null) {
                for (String parseInt : C3913e.m2298a(eVar.mo56409j())) {
                    this.f2277d.mo56535g().mo56432a(Integer.parseInt(parseInt));
                }
                return;
            }
            return;
        }
        C4039h.m2823c(f2274a, "Request failed: %d - %s", Integer.valueOf(gVar.mo56361c()), gVar.mo56360b());
        this.f2279f.mo56211b(C3848a.C3850a.ET_ANALYTICS);
    }
}

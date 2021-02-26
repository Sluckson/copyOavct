package com.salesforce.marketingcloud.analytics.p019b;

import com.google.auto.value.AutoValue;
import java.util.Date;
import org.json.JSONObject;

@AutoValue
/* renamed from: com.salesforce.marketingcloud.analytics.b.l */
abstract class C3894l extends C3895m {
    C3894l() {
    }

    /* renamed from: a */
    public static C3894l m2207a(Date date) {
        return new C3888f("track_event", "app_close", date);
    }

    /* renamed from: a_ */
    public abstract JSONObject mo56289a_();

    /* renamed from: e */
    public int mo56293e() {
        return 0;
    }
}

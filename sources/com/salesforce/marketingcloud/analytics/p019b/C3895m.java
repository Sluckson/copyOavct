package com.salesforce.marketingcloud.analytics.p019b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.C4039h;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.b.m */
abstract class C3895m {

    /* renamed from: a */
    static final String f2308a = "cart";

    /* renamed from: b */
    static final String f2309b = "track_cart";

    /* renamed from: c */
    static final String f2310c = "item";

    /* renamed from: d */
    static final String f2311d = "quantity";

    /* renamed from: e */
    static final String f2312e = "price";

    /* renamed from: f */
    static final String f2313f = "api_endpoint";

    /* renamed from: g */
    static final String f2314g = "timestamp";

    /* renamed from: h */
    static final String f2315h = "details";

    /* renamed from: i */
    static final String f2316i = "message_ids";

    /* renamed from: j */
    static final String f2317j = "app_open";

    /* renamed from: k */
    static final String f2318k = "app_close";

    /* renamed from: l */
    static final String f2319l = "track_event";

    /* renamed from: m */
    static final String f2320m = "track_view";

    /* renamed from: n */
    static final String f2321n = "url";

    /* renamed from: o */
    static final String f2322o = "item";

    /* renamed from: p */
    static final String f2323p = "search";

    /* renamed from: q */
    static final String f2324q = "title";

    /* renamed from: r */
    static final String f2325r = "shipping";

    /* renamed from: s */
    static final String f2326s = "discount";

    /* renamed from: t */
    static final String f2327t = "track_conversion";

    /* renamed from: u */
    static final String f2328u = "order_number";

    /* renamed from: v */
    static final String f2329v = "clear_cart";

    /* renamed from: w */
    private static final int f2330w = 1024;

    /* renamed from: x */
    private static final String f2331x = C4039h.m2810a((Class<?>) C3895m.class);

    C3895m() {
    }

    /* renamed from: a */
    public abstract String mo56263a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo56294a(@Size(min = 1) @NonNull String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2) && str2.trim().length() > 0) {
            String trim = str2.trim();
            if (trim.trim().length() <= 1024) {
                return trim;
            }
            String trim2 = trim.trim().substring(0, 1024).trim();
            C4039h.m2826d(f2331x, "PiEvent item %s is larger than %s bytes, truncating data.  New value: %s", str, 1024, trim2);
            return trim2;
        } else if (!z) {
            return str2;
        } else {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "PiEvent must contain a %s.", new Object[]{str}));
        }
    }

    @Nullable
    /* renamed from: a_ */
    public abstract JSONObject mo56289a_();

    /* renamed from: b */
    public abstract String mo56264b();

    /* renamed from: c */
    public abstract Date mo56265c();

    /* renamed from: e */
    public abstract int mo56293e();
}

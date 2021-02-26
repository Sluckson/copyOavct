package com.salesforce.marketingcloud.analytics.p019b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.analytics.C3913e;
import com.salesforce.marketingcloud.analytics.C3920i;
import com.salesforce.marketingcloud.analytics.C3923k;
import com.salesforce.marketingcloud.analytics.C3924l;
import com.salesforce.marketingcloud.analytics.C3925m;
import com.salesforce.marketingcloud.analytics.PiCart;
import com.salesforce.marketingcloud.analytics.PiOrder;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p021c.C3953g;
import com.salesforce.marketingcloud.p022d.C3961a;
import com.salesforce.marketingcloud.p022d.C4007c;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.analytics.b.r */
public final class C3904r extends C3923k implements C3872b.C3874a, C3920i, C3924l, C3925m, C3949f.C3951a {
    @VisibleForTesting

    /* renamed from: a */
    static final String f2342a = "user_id";
    @VisibleForTesting

    /* renamed from: b */
    static final String f2343b = "session_id";
    @VisibleForTesting

    /* renamed from: c */
    static final int f2344c = 100;

    /* renamed from: d */
    private static final int f2345d = 30;

    /* renamed from: e */
    private static final String f2346e = "et_background_time_cache";

    /* renamed from: f */
    private static final String f2347f = C4039h.m2810a((Class<?>) C3904r.class);

    /* renamed from: g */
    private static final int f2348g = 1;

    /* renamed from: h */
    private static C3906s f2349h;

    /* renamed from: i */
    private final C4016h f2350i;

    /* renamed from: j */
    private final C3872b f2351j;

    /* renamed from: k */
    private final C3949f f2352k;

    /* renamed from: l */
    private final C3961a f2353l;

    /* renamed from: com.salesforce.marketingcloud.analytics.b.r$1 */
    static /* synthetic */ class C39051 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2354a = new int[C3848a.C3850a.values().length];

        static {
            try {
                f2354a[C3848a.C3850a.PI_ANALYTICS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public C3904r(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull C4016h hVar, @NonNull C3872b bVar, @NonNull C3949f fVar) {
        C4028g.m2762a(marketingCloudConfig, "MarketingCloudConfig may not be null.");
        this.f2350i = (C4016h) C4028g.m2762a(hVar, "MCStorage may not be null.");
        this.f2351j = (C3872b) C4028g.m2762a(bVar, "AlarmScheduler may not be null.");
        this.f2352k = (C3949f) C4028g.m2762a(fVar, "RequestManager may not be null.");
        this.f2353l = hVar.mo56535g();
        f2349h = m2260a(marketingCloudConfig) ? new C3908t(marketingCloudConfig, hVar) : new C3893k(marketingCloudConfig, hVar);
        fVar.mo56415a(C3944d.PI_ANALYTICS, (C3949f.C3951a) this);
        bVar.mo56203a((C3872b.C3874a) this, C3848a.C3850a.PI_ANALYTICS);
    }

    /* renamed from: a */
    private void m2256a() {
        C4016h hVar = this.f2350i;
        if (hVar != null && hVar.mo56535g() != null) {
            boolean a = m2261a(this.f2352k, this.f2350i.mo56535g().mo56440b(this.f2350i.mo56524a()));
            boolean a2 = m2261a(this.f2352k, this.f2350i.mo56535g().mo56434a(this.f2350i.mo56524a()));
            if (!a && !a2) {
                this.f2351j.mo56213c(C3848a.C3850a.PI_ANALYTICS);
            }
        }
    }

    /* renamed from: a */
    private void m2257a(@NonNull C3895m mVar, long j) {
        JSONObject a_ = mVar.mo56289a_();
        if (a_ != null) {
            try {
                C3910d a = C3910d.m2281a(new Date(j), 1, mVar.mo56293e());
                a.mo56309a(a_.toString());
                a.mo56310a(true);
                if (!TextUtils.isEmpty(a.mo56318h())) {
                    this.f2353l.mo56436a(a, this.f2350i.mo56524a());
                }
            } catch (Exception e) {
                C4039h.m2830e(f2347f, e, "Failed to record PiWamaItem in local storage.", new Object[0]);
                throw new IllegalArgumentException("Failed to record PiWamaItem in local storage.");
            }
        } else {
            throw new IllegalArgumentException("Failed to convert your input type to a JSON Object.");
        }
    }

    /* renamed from: a */
    public static void m2258a(C4016h hVar, C3872b bVar, C3949f fVar, boolean z) {
        if (z) {
            hVar.mo56535g().mo56438b(1);
        }
        bVar.mo56213c(C3848a.C3850a.PI_ANALYTICS);
        fVar.mo56414a(C3944d.PI_ANALYTICS);
    }

    /* renamed from: a */
    private void m2259a(String[] strArr, String str, String str2) {
        this.f2351j.mo56214d(C3848a.C3850a.PI_ANALYTICS);
        this.f2350i.mo56531d().mo56522a(C4007c.f2880g, str);
        this.f2350i.mo56531d().mo56522a(C4007c.f2879f, str2);
        if (strArr != null) {
            for (String parseInt : strArr) {
                try {
                    this.f2350i.mo56535g().mo56432a(Integer.parseInt(parseInt));
                } catch (Exception e) {
                    C4039h.m2830e(f2347f, e, "Failed to delete transmitted PI Analytics from local storage.", new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m2260a(@NonNull MarketingCloudConfig marketingCloudConfig) {
        String trim = marketingCloudConfig.predictiveIntelligenceServerUrl().toLowerCase().trim();
        return !trim.startsWith("https://stage.app.igodigital.com/api/v1/collect/qa/qa1s1/process_batch") && !trim.startsWith("https://stage.app.igodigital.com/api/v1/collect/qa/qa3s1/process_batch") && !trim.startsWith("https://app.igodigital.com/api/v1/collect/process_batch");
    }

    @VisibleForTesting
    /* renamed from: a */
    static boolean m2261a(C3949f fVar, List<C3910d> list) {
        MarketingCloudSdk instance;
        if ((!MarketingCloudSdk.isReady() && !MarketingCloudSdk.isInitializing()) || (instance = MarketingCloudSdk.getInstance()) == null || list.isEmpty()) {
            return false;
        }
        for (List list2 : m2262a(list)) {
            fVar.mo56416a(f2349h.mo56301a(instance.getRegistrationManager(), instance.getPushMessageManager(), instance.getRegionMessageManager(), list2).mo56408a(C3913e.m2297a((List<C3910d>) list2)));
        }
        return true;
    }

    @VisibleForTesting
    /* renamed from: a */
    static List<C3910d>[] m2262a(List<C3910d> list) {
        int size = list.size();
        List<C3910d>[] listArr = new List[((int) Math.ceil(((double) size) / 100.0d))];
        int i = size;
        int i2 = 0;
        while (i > 0) {
            int i3 = i2 * 100;
            int i4 = i2 + 1;
            int i5 = i4 * 100;
            if (i5 > size) {
                i5 = i + i3;
            }
            listArr[i2] = list.subList(i3, i5);
            i -= 100;
            i2 = i4;
        }
        return listArr;
    }

    /* renamed from: b */
    private void m2263b() {
        long j = this.f2350i.mo56532e().getLong(f2346e, -1);
        if (j != -1) {
            this.f2350i.mo56532e().edit().remove(f2346e).apply();
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            Calendar instance2 = Calendar.getInstance();
            instance2.add(12, -30);
            if (instance.before(instance2)) {
                this.f2350i.mo56531d().mo56521a(C4007c.f2879f);
            }
        }
    }

    /* renamed from: a */
    public void mo56255a(long j) {
        Date date = new Date(j);
        m2263b();
        if (!this.f2350i.mo56535g().mo56447e(1)) {
            try {
                C3910d a = C3910d.m2281a(date, 1, 5);
                a.mo56309a(C3896n.m2216a(date, false, Collections.emptyList()).mo56289a_().toString());
                this.f2353l.mo56436a(a, this.f2350i.mo56524a());
            } catch (Exception e) {
                C4039h.m2830e(f2347f, e, "Failed to create WamaItem for TimeInApp.", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public void mo56216a(@NonNull C3848a.C3850a aVar) {
        if (C39051.f2354a[aVar.ordinal()] == 1) {
            m2256a();
        }
    }

    /* renamed from: a */
    public void mo56262a(C3946e eVar, C3953g gVar) {
        if (gVar.mo56419h()) {
            try {
                JSONObject jSONObject = new JSONObject(gVar.mo56359a());
                m2259a(C3913e.m2298a(eVar.mo56409j()), jSONObject.getString(f2342a), jSONObject.getString(f2343b));
            } catch (Exception e) {
                C4039h.m2830e(f2347f, e, "Error parsing response.", new Object[0]);
                this.f2351j.mo56211b(C3848a.C3850a.PI_ANALYTICS);
            }
        } else {
            C4039h.m2823c(f2347f, "Request failed: %d - %s", Integer.valueOf(gVar.mo56361c()), gVar.mo56360b());
            this.f2351j.mo56211b(C3848a.C3850a.PI_ANALYTICS);
        }
    }

    /* renamed from: a */
    public void mo56254a(boolean z) {
        C3872b bVar = this.f2351j;
        if (bVar != null) {
            bVar.mo56206a(C3848a.C3850a.PI_ANALYTICS);
        }
        C3949f fVar = this.f2352k;
        if (fVar != null) {
            fVar.mo56414a(C3944d.PI_ANALYTICS);
        }
    }

    /* renamed from: b */
    public void mo56257b(long j) {
        this.f2350i.mo56532e().edit().putLong(f2346e, j).apply();
        try {
            for (C3910d next : this.f2353l.mo56443c(this.f2350i.mo56524a())) {
                int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(j - next.mo56311b().getTime());
                if (seconds > 0) {
                    next.mo56312b(seconds);
                    next.mo56310a(true);
                    this.f2353l.mo56439b(next, this.f2350i.mo56524a());
                }
            }
            C3910d a = C3910d.m2281a(new Date(j), 1, 2);
            a.mo56310a(true);
            a.mo56309a(C3894l.m2207a(new Date(j)).mo56289a_().toString());
            this.f2353l.mo56436a(a, this.f2350i.mo56524a());
        } catch (Exception e) {
            C4039h.m2830e(f2347f, e, "Failed to update our PiWama TimeInApp.", new Object[0]);
        }
        this.f2351j.mo56211b(C3848a.C3850a.PI_ANALYTICS);
    }

    /* renamed from: b */
    public void mo56259b(@NonNull NotificationMessage notificationMessage) {
        List list;
        try {
            if (this.f2350i.mo56535g().mo56447e(1)) {
                mo56257b(0);
            }
            Date date = new Date();
            String id = notificationMessage.mo56835id();
            String regionId = notificationMessage.regionId();
            if (TextUtils.isEmpty(regionId)) {
                list = Collections.singletonList(id);
            } else {
                list = Arrays.asList(new String[]{id, regionId});
            }
            C3910d a = C3910d.m2283a(date, 1, 5, list, false);
            a.mo56309a(C3896n.m2216a(date, true, a.mo56316f()).mo56289a_().toString());
            this.f2353l.mo56436a(a, this.f2350i.mo56524a());
        } catch (Exception e) {
            C4039h.m2830e(f2347f, e, "Failed to store our WamaItem for message opened.", new Object[0]);
        }
    }

    public void trackCartContents(@NonNull PiCart piCart) {
        if (piCart != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                m2257a((C3895m) C3899o.m2228a(piCart, new Date(currentTimeMillis)), currentTimeMillis);
            } catch (Exception e) {
                C4039h.m2830e(f2347f, e, "Failed to add PiWamaAnalytic for trackCartContents.  See LogCat for details.", new Object[0]);
            }
        }
    }

    public void trackCartConversion(@NonNull PiOrder piOrder) {
        if (piOrder != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                m2257a((C3895m) C3901p.m2238a(piOrder, new Date(currentTimeMillis)), currentTimeMillis);
            } catch (IllegalArgumentException e) {
                C4039h.m2830e(f2347f, e, "Failed to add PiWamaAnalytic for trackCartConversion.  See LogCat for details.", new Object[0]);
            }
        }
    }

    public void trackPageView(@Size(min = 1) @NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            m2257a((C3895m) new C3903q(str, str2, str3, str4, new Date(currentTimeMillis)), currentTimeMillis);
        } catch (IllegalArgumentException e) {
            C4039h.m2830e(f2347f, e, "Failed to record PiWamaItem for trackPageView.", new Object[0]);
        }
    }
}

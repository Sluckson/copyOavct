package com.salesforce.marketingcloud.analytics;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.C3956d;
import com.salesforce.marketingcloud.C4037f;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.analytics.p018a.C3879a;
import com.salesforce.marketingcloud.analytics.p018a.C3880b;
import com.salesforce.marketingcloud.analytics.p018a.C3881c;
import com.salesforce.marketingcloud.analytics.p019b.C3904r;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3930b;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.EnumSet;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.analytics.j */
public final class C3921j implements AnalyticsManager, C3920i, C3924l, C3930b, C4037f, RegionMessageManager.RegionTransitionEventListener {

    /* renamed from: a */
    private static final String f2408a = C4039h.m2810a((Class<?>) C3921j.class);

    /* renamed from: b */
    private final C3931c f2409b;

    /* renamed from: c */
    private final EnumSet<C3929a> f2410c = EnumSet.of(C3929a.BEHAVIOR_APP_BACKGROUNDED, C3929a.BEHAVIOR_APP_FOREGROUNDED, C3929a.BEHAVIOR_DEVICE_SHUTDOWN, C3929a.BEHAVIOR_DEVICE_BOOT_COMPLETE);

    /* renamed from: d */
    private final C4016h f2411d;

    /* renamed from: e */
    private final C3949f f2412e;

    /* renamed from: f */
    private final String f2413f;

    /* renamed from: g */
    private final MarketingCloudConfig f2414g;

    /* renamed from: h */
    private final C3872b f2415h;

    /* renamed from: i */
    private C3881c f2416i;

    /* renamed from: j */
    private C3880b f2417j;

    /* renamed from: k */
    private C3879a f2418k;

    /* renamed from: l */
    private C3904r f2419l;

    /* renamed from: com.salesforce.marketingcloud.analytics.j$1 */
    static /* synthetic */ class C39221 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2420a = new int[C3929a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.salesforce.marketingcloud.b.a[] r0 = com.salesforce.marketingcloud.p020b.C3929a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2420a = r0
                int[] r0 = f2420a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_APP_BACKGROUNDED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2420a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_APP_FOREGROUNDED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2420a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_DEVICE_SHUTDOWN     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f2420a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_DEVICE_BOOT_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.analytics.C3921j.C39221.<clinit>():void");
        }
    }

    public C3921j(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull C4016h hVar, @NonNull String str, @NonNull C3872b bVar, @NonNull C3931c cVar, @NonNull C3949f fVar) {
        this.f2411d = (C4016h) C4028g.m2762a(hVar, "MCStorage may not be null.");
        this.f2409b = (C3931c) C4028g.m2762a(cVar, "BehaviorManager may not be null.");
        this.f2412e = fVar;
        this.f2413f = str;
        this.f2414g = marketingCloudConfig;
        this.f2415h = bVar;
    }

    /* renamed from: a */
    private void m2306a(Bundle bundle) {
        long j = bundle.getLong("timestamp", System.currentTimeMillis());
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.mo56255a(j);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.mo56255a(j);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.mo56255a(j);
        }
    }

    /* renamed from: b */
    private void m2307b(Bundle bundle) {
        long j = bundle.getLong("timestamp", 0);
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.mo56257b(j);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.mo56257b(j);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.mo56257b(j);
        }
        if (this.f2416i != null) {
            this.f2415h.mo56211b(C3848a.C3850a.ET_ANALYTICS);
        }
    }

    /* renamed from: c */
    private void m2308c(Bundle bundle) {
        long j = bundle.getLong("timestamp", 0);
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.mo56260c(j);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.mo56260c(j);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.mo56260c(j);
        }
    }

    /* renamed from: a */
    public JSONObject mo56200a() {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean z = true;
            jSONObject.put("bet_analytics", this.f2418k != null);
            jSONObject.put("et_analytics", this.f2417j != null);
            if (this.f2419l == null) {
                z = false;
            }
            jSONObject.put("pi_analytics", z);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void mo56338a(int i) {
        if (C3956d.m2459b(i, 2048)) {
            C3879a aVar = this.f2418k;
            if (aVar != null) {
                aVar.mo56254a(false);
                this.f2418k = null;
            }
            C3879a aVar2 = this.f2418k;
            C3879a.m2162a(this.f2411d, C3956d.m2460c(i, 2048));
        } else {
            this.f2418k = new C3879a(this.f2411d);
        }
        if (C3956d.m2459b(i, 256)) {
            C3880b bVar = this.f2417j;
            if (bVar != null) {
                bVar.mo56254a(false);
                this.f2417j = null;
            }
            C3880b.m2166a(this.f2411d, C3956d.m2460c(i, 256));
        } else if (this.f2417j == null && this.f2414g.analyticsEnabled()) {
            this.f2417j = new C3880b(this.f2411d);
        }
        if (C3956d.m2459b(i, 512)) {
            C3904r rVar = this.f2419l;
            if (rVar != null) {
                rVar.mo56254a(false);
                this.f2419l = null;
            }
            C3904r.m2258a(this.f2411d, this.f2415h, this.f2412e, C3956d.m2460c(i, 512));
        } else if (this.f2419l == null && this.f2414g.piAnalyticsEnabled()) {
            this.f2419l = new C3904r(this.f2414g, this.f2411d, this.f2415h, this.f2412e);
        }
        if (this.f2418k == null && this.f2417j == null) {
            this.f2415h.mo56213c(C3848a.C3850a.ET_ANALYTICS);
            C3881c cVar = this.f2416i;
            if (cVar != null) {
                cVar.mo56261a();
                this.f2416i = null;
            }
        } else if (this.f2416i == null) {
            this.f2416i = new C3881c(this.f2414g, this.f2413f, this.f2411d, this.f2412e, this.f2415h);
        }
    }

    /* renamed from: a */
    public void mo56339a(@NonNull InitializationStatus.C3832a aVar, int i) {
        if (C3956d.m2457a(i, 2048)) {
            this.f2418k = new C3879a(this.f2411d);
        }
        if (C3956d.m2457a(i, 256) && this.f2414g.analyticsEnabled()) {
            this.f2417j = new C3880b(this.f2411d);
        }
        if (C3956d.m2457a(i, 512) && this.f2414g.piAnalyticsEnabled()) {
            this.f2419l = new C3904r(this.f2414g, this.f2411d, this.f2415h, this.f2412e);
        }
        if (!(this.f2418k == null && this.f2417j == null)) {
            this.f2416i = new C3881c(this.f2414g, this.f2413f, this.f2411d, this.f2412e, this.f2415h);
        }
        this.f2409b.mo56346a((C3930b) this, this.f2410c);
    }

    /* renamed from: a */
    public void mo56204a(@NonNull C3929a aVar, @NonNull Bundle bundle) {
        int i = C39221.f2420a[aVar.ordinal()];
        if (i == 1) {
            m2307b(bundle);
        } else if (i == 2) {
            m2306a(bundle);
        } else if (i == 3 || i == 4) {
            m2308c(bundle);
        }
    }

    /* renamed from: a */
    public void mo56252a(@NonNull InboxMessage inboxMessage) {
        if (inboxMessage == null) {
            C4039h.m2826d(f2408a, "InboxMessage is null.  Call to onMessageDownloaded() ignored.", new Object[0]);
            return;
        }
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.mo56252a(inboxMessage);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.mo56252a(inboxMessage);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.mo56252a(inboxMessage);
        }
    }

    /* renamed from: a */
    public void mo56253a(@NonNull NotificationMessage notificationMessage) {
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.mo56253a(notificationMessage);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.mo56253a(notificationMessage);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.mo56253a(notificationMessage);
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
        this.f2409b.mo56345a((C3930b) this);
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.mo56254a(z);
            this.f2418k = null;
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.mo56254a(z);
            this.f2417j = null;
        }
        C3881c cVar = this.f2416i;
        if (cVar != null) {
            cVar.mo56261a();
            this.f2416i = null;
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.mo56254a(z);
            this.f2419l = null;
        }
    }

    /* renamed from: b */
    public String mo56210b() {
        return "AnalyticsManager";
    }

    /* renamed from: b */
    public void mo56259b(@NonNull NotificationMessage notificationMessage) {
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.mo56259b(notificationMessage);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.mo56259b(notificationMessage);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.mo56259b(notificationMessage);
        }
    }

    public void onTransitionEvent(int i, @NonNull Region region) {
        if (i == 1) {
            C3879a aVar = this.f2418k;
            if (aVar != null) {
                aVar.mo56256a(region);
            }
            C3880b bVar = this.f2417j;
            if (bVar != null) {
                bVar.mo56256a(region);
            }
            C3904r rVar = this.f2419l;
            if (rVar != null) {
                rVar.mo56256a(region);
            }
        } else if (i == 2) {
            C3879a aVar2 = this.f2418k;
            if (aVar2 != null) {
                aVar2.mo56258b(region);
            }
            C3880b bVar2 = this.f2417j;
            if (bVar2 != null) {
                bVar2.mo56258b(region);
            }
            C3904r rVar2 = this.f2419l;
            if (rVar2 != null) {
                rVar2.mo56258b(region);
            }
        }
    }

    public void trackCartContents(@NonNull PiCart piCart) {
        if (piCart == null) {
            C4039h.m2826d(f2408a, "PiCart may not be null.  We could not complete your trackCartContents() request.", new Object[0]);
            return;
        }
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.trackCartContents(piCart);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.trackCartContents(piCart);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.trackCartContents(piCart);
        }
    }

    public void trackCartConversion(@NonNull PiOrder piOrder) {
        if (piOrder == null) {
            C4039h.m2826d(f2408a, "PiOrder may not be null.  We could not complete your trackCartConversion() request.", new Object[0]);
            return;
        }
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.trackCartConversion(piOrder);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.trackCartConversion(piOrder);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.trackCartConversion(piOrder);
        }
    }

    public void trackInboxOpenEvent(@NonNull InboxMessage inboxMessage) {
        if (inboxMessage == null || !this.f2411d.mo56541m().mo56471a(inboxMessage.mo56741id()) || inboxMessage.mo56734c() == 1) {
            C4039h.m2826d(f2408a, "InboxMessage is a Legacy message, null or unknown.  Call to trackInboxOpenEvent() ignored.", new Object[0]);
            return;
        }
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.trackInboxOpenEvent(inboxMessage);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.trackInboxOpenEvent(inboxMessage);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.trackInboxOpenEvent(inboxMessage);
        }
    }

    public void trackPageView(@Size(min = 1) @NonNull String str) {
        trackPageView(str, (String) null, (String) null, (String) null);
    }

    public void trackPageView(@Size(min = 1) @NonNull String str, @Nullable String str2) {
        trackPageView(str, str2, (String) null, (String) null);
    }

    public void trackPageView(@Size(min = 1) @NonNull String str, @Nullable String str2, @Nullable String str3) {
        trackPageView(str, str2, str3, (String) null);
    }

    public void trackPageView(@Size(min = 1) @NonNull String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            C4039h.m2826d(f2408a, "url may not be null or empty.  We could not complete your trackPageView() request.", new Object[0]);
            return;
        }
        C3879a aVar = this.f2418k;
        if (aVar != null) {
            aVar.trackPageView(str, str2, str3, str4);
        }
        C3880b bVar = this.f2417j;
        if (bVar != null) {
            bVar.trackPageView(str, str2, str3, str4);
        }
        C3904r rVar = this.f2419l;
        if (rVar != null) {
            rVar.trackPageView(str, str2, str3, str4);
        }
    }
}

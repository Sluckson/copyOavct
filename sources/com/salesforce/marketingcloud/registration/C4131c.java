package com.salesforce.marketingcloud.registration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.C3956d;
import com.salesforce.marketingcloud.C4037f;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3930b;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p021c.C3953g;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import com.salesforce.marketingcloud.registration.C4134d;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.registration.c */
public class C4131c implements C3872b.C3874a, C3930b, C3949f.C3951a, C4037f, RegistrationManager, C4134d.C4136b {

    /* renamed from: c */
    private static final EnumSet<C3929a> f3402c = EnumSet.of(C3929a.BEHAVIOR_APP_PACKAGE_REPLACED, new C3929a[]{C3929a.BEHAVIOR_DEVICE_TIME_ZONE_CHANGED, C3929a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED, C3929a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED, C3929a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED, C3929a.BEHAVIOR_SDK_TOKEN_REFRESHED});

    /* renamed from: d */
    private static final String f3403d = C4039h.m2810a((Class<?>) C4131c.class);

    /* renamed from: e */
    private final Context f3404e;

    /* renamed from: f */
    private final MarketingCloudConfig f3405f;

    /* renamed from: g */
    private final C4016h f3406g;

    /* renamed from: h */
    private final String f3407h;

    /* renamed from: i */
    private final C3931c f3408i;

    /* renamed from: j */
    private final C3872b f3409j;

    /* renamed from: k */
    private final C3949f f3410k;

    /* renamed from: l */
    private final PushMessageManager f3411l;

    /* renamed from: m */
    private final RegionMessageManager f3412m;

    /* renamed from: n */
    private C4134d f3413n;

    /* renamed from: com.salesforce.marketingcloud.registration.c$1 */
    static /* synthetic */ class C41321 {

        /* renamed from: b */
        static final /* synthetic */ int[] f3415b = new int[C3848a.C3850a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0027 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0032 */
        static {
            /*
                com.salesforce.marketingcloud.a.a$a[] r0 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3415b = r0
                r0 = 1
                int[] r1 = f3415b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.marketingcloud.a.a$a r2 = com.salesforce.marketingcloud.p017a.C3848a.C3850a.REGISTRATION     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                com.salesforce.marketingcloud.b.a[] r1 = com.salesforce.marketingcloud.p020b.C3929a.values()
                int r1 = r1.length
                int[] r1 = new int[r1]
                f3414a = r1
                int[] r1 = f3414a     // Catch:{ NoSuchFieldError -> 0x0027 }
                com.salesforce.marketingcloud.b.a r2 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_APP_PACKAGE_REPLACED     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                int[] r0 = f3414a     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_DEVICE_TIME_ZONE_CHANGED     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = f3414a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f3414a     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f3414a     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f3414a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.salesforce.marketingcloud.b.a r1 = com.salesforce.marketingcloud.p020b.C3929a.BEHAVIOR_SDK_TOKEN_REFRESHED     // Catch:{ NoSuchFieldError -> 0x005e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.registration.C4131c.C41321.<clinit>():void");
        }
    }

    /* renamed from: com.salesforce.marketingcloud.registration.c$a */
    private static class C4133a implements RegistrationManager.Editor {
        private C4133a() {
        }

        /* synthetic */ C4133a(C41321 r1) {
            this();
        }

        @NonNull
        public RegistrationManager.Editor addTag(String str) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor addTags(Iterable<String> iterable) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor addTags(String... strArr) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor clearAttribute(String str) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor clearAttributes(Iterable<String> iterable) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor clearAttributes(String... strArr) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor clearTags() {
            return this;
        }

        public boolean commit() {
            return false;
        }

        @NonNull
        public RegistrationManager.Editor removeTag(String str) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor removeTags(Iterable<String> iterable) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor removeTags(String... strArr) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor setAttribute(@NonNull String str, @NonNull String str2) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor setContactKey(@NonNull String str) {
            return this;
        }

        @NonNull
        public RegistrationManager.Editor setSignedString(@NonNull String str) {
            return this;
        }
    }

    public C4131c(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @NonNull C4016h hVar, @NonNull String str, @NonNull C3931c cVar, @NonNull C3872b bVar, @NonNull C3949f fVar, @NonNull PushMessageManager pushMessageManager, @NonNull RegionMessageManager regionMessageManager) {
        this.f3404e = (Context) C4028g.m2762a(context, "Context may not be null.");
        this.f3405f = (MarketingCloudConfig) C4028g.m2762a(marketingCloudConfig, "Config may not be null.");
        this.f3406g = (C4016h) C4028g.m2762a(hVar, "Storage may not be null.");
        this.f3407h = (String) C4028g.m2761a(str, "DeviceID must not be null or empty.");
        this.f3408i = (C3931c) C4028g.m2762a(cVar, "BehaviorManager may not be null.");
        this.f3409j = (C3872b) C4028g.m2762a(bVar, "AlarmScheduler may not be null.");
        this.f3410k = (C3949f) C4028g.m2762a(fVar, "RequestManager may not be null.");
        this.f3411l = (PushMessageManager) C4028g.m2762a(pushMessageManager, "PushMessageManager is null.");
        this.f3412m = (RegionMessageManager) C4028g.m2762a(regionMessageManager, "RegionMessageManager is null.");
    }

    @VisibleForTesting(otherwise = 5)
    C4131c(C4134d dVar) {
        this.f3413n = dVar;
        this.f3404e = null;
        this.f3405f = null;
        this.f3406g = null;
        this.f3407h = null;
        this.f3408i = null;
        this.f3409j = null;
        this.f3410k = null;
        this.f3411l = null;
        this.f3412m = null;
    }

    /* renamed from: a */
    public static C3953g m3420a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull Context context, @Size(min = 1) @NonNull String str) {
        return C3944d.REGISTRATION.mo56403a(marketingCloudConfig, Registration.m3386c().mo56979a(marketingCloudConfig, context, str).mo56957a((Map<String, String>) Collections.emptyMap()).mo56958a((Set<String>) Collections.emptySet()).mo56966d(false).mo56964c(false).mo56962b(false).mo56981b().mo56978f()).mo56411l();
    }

    /* renamed from: a */
    public static boolean m3421a(@NonNull C4016h hVar) {
        return C4134d.m3433a(hVar);
    }

    @Nullable
    /* renamed from: a */
    public final JSONObject mo56200a() {
        C4134d dVar = this.f3413n;
        return dVar != null ? dVar.mo57024a() : new JSONObject();
    }

    /* renamed from: a */
    public void mo56338a(int i) {
        if (C3956d.m2459b(i, 2)) {
            this.f3413n = null;
            C4134d.m3432a(this.f3406g, this.f3409j, C3956d.m2460c(i, 2));
            this.f3408i.mo56345a((C3930b) this);
            this.f3409j.mo56206a(C3848a.C3850a.REGISTRATION);
            this.f3410k.mo56414a(C3944d.REGISTRATION);
        } else if (this.f3413n == null) {
            mo57021a((InitializationStatus.C3832a) null);
            this.f3413n.mo57031b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57021a(InitializationStatus.C3832a aVar) {
        this.f3408i.mo56346a((C3930b) this, f3402c);
        this.f3409j.mo56203a((C3872b.C3874a) this, C3848a.C3850a.REGISTRATION);
        this.f3410k.mo56415a(C3944d.REGISTRATION, (C3949f.C3951a) this);
        try {
            this.f3413n = new C4134d(this.f3404e, this.f3405f, this.f3406g, this.f3407h, this.f3409j, this.f3410k, this.f3411l, this.f3412m);
        } catch (Exception e) {
            if (aVar != null) {
                aVar.mo56099a((Throwable) e);
            }
        }
    }

    /* renamed from: a */
    public void mo56339a(@NonNull InitializationStatus.C3832a aVar, int i) {
        if (C3956d.m2457a(i, 2)) {
            mo57021a(aVar);
        }
    }

    /* renamed from: a */
    public final void mo56216a(@NonNull C3848a.C3850a aVar) {
        C4134d dVar;
        if (C41321.f3415b[aVar.ordinal()] == 1 && (dVar = this.f3413n) != null) {
            dVar.mo57033c();
        }
    }

    /* renamed from: a */
    public final void mo56204a(@NonNull C3929a aVar, @NonNull Bundle bundle) {
        if (this.f3413n != null) {
            switch (aVar) {
                case BEHAVIOR_APP_PACKAGE_REPLACED:
                    this.f3413n.mo57035d();
                    return;
                case BEHAVIOR_DEVICE_TIME_ZONE_CHANGED:
                    this.f3413n.mo57036e();
                    return;
                case BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED:
                    this.f3413n.mo57030a(bundle.getBoolean(PushMessageManager.f3234e));
                    return;
                case BEHAVIOR_CUSTOMER_FENCE_MESSAGING_TOGGLED:
                    this.f3413n.mo57032b(bundle.getBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED));
                    return;
                case BEHAVIOR_CUSTOMER_PROXIMITY_MESSAGING_TOGGLED:
                    this.f3413n.mo57034c(bundle.getBoolean(RegionMessageManager.BUNDLE_KEY_MESSAGING_ENABLED));
                    return;
                case BEHAVIOR_SDK_TOKEN_REFRESHED:
                    this.f3413n.mo57028a(bundle.getString(PushMessageManager.f3235f, ""));
                    return;
                default:
                    C4039h.m2820b(f3403d, "Unhandled behavior: %s", aVar);
                    return;
            }
        }
    }

    /* renamed from: a */
    public void mo56262a(C3946e eVar, C3953g gVar) {
        if (this.f3413n == null) {
            return;
        }
        if (gVar.mo56419h()) {
            try {
                this.f3413n.mo57027a(Registration.m3385b(new JSONObject(eVar.mo56376b())));
            } catch (Exception unused) {
                this.f3413n.mo57025a(-1, "Failed to convert our Response Body into a Registration.");
            }
        } else {
            this.f3413n.mo57025a(gVar.mo56361c(), gVar.mo56360b());
        }
    }

    /* renamed from: a */
    public void mo57022a(String str, String str2, Map<String, String> map, Collection<String> collection) {
        C4134d dVar = this.f3413n;
        if (dVar != null) {
            try {
                dVar.mo57029a(str, str2, map, collection);
            } catch (Exception e) {
                C4039h.m2830e(f3403d, e, "Error encountered while saving registration", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
        this.f3409j.mo56213c(C3848a.C3850a.REGISTRATION);
        this.f3409j.mo56206a(C3848a.C3850a.REGISTRATION);
        this.f3408i.mo56345a((C3930b) this);
    }

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return "RegistrationManager";
    }

    public RegistrationManager.Editor edit() {
        C4134d dVar = this.f3413n;
        return dVar != null ? dVar.mo57023a((C4134d.C4136b) this) : new C4133a((C41321) null);
    }

    @NonNull
    public Map<String, String> getAttributes() {
        C4134d dVar = this.f3413n;
        return dVar != null ? dVar.getAttributes() : Collections.emptyMap();
    }

    @Nullable
    public String getContactKey() {
        C4134d dVar = this.f3413n;
        if (dVar != null) {
            return dVar.getContactKey();
        }
        return null;
    }

    @NonNull
    public String getDeviceId() {
        C4134d dVar = this.f3413n;
        return dVar != null ? dVar.getDeviceId() : "";
    }

    @Nullable
    public String getSignedString() {
        C4134d dVar = this.f3413n;
        if (dVar != null) {
            return dVar.getSignedString();
        }
        return null;
    }

    @Nullable
    public String getSystemToken() {
        C4134d dVar = this.f3413n;
        if (dVar != null) {
            return dVar.getSystemToken();
        }
        return null;
    }

    @NonNull
    public Set<String> getTags() {
        C4134d dVar = this.f3413n;
        return dVar != null ? dVar.getTags() : Collections.emptySet();
    }

    public void registerForRegistrationEvents(@NonNull RegistrationManager.RegistrationEventListener registrationEventListener) {
        C4134d dVar = this.f3413n;
        if (dVar != null) {
            dVar.registerForRegistrationEvents(registrationEventListener);
        }
    }

    public void unregisterForRegistrationEvents(@NonNull RegistrationManager.RegistrationEventListener registrationEventListener) {
        C4134d dVar = this.f3413n;
        if (dVar != null) {
            dVar.unregisterForRegistrationEvents(registrationEventListener);
        }
    }
}

package com.salesforce.marketingcloud.registration;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.xml.TagMap;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p022d.C4007c;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4029h;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.registration.d */
class C4134d implements RegistrationManager {
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: c */
    public static final String f3416c = "Android";
    @VisibleForTesting

    /* renamed from: d */
    static final String f3417d = "previousRegistrationHash";
    @VisibleForTesting

    /* renamed from: e */
    static final String f3418e = "lastRegistrationSendTimestamp";
    @VisibleForTesting

    /* renamed from: f */
    static final String f3419f = "_sfmc_last_registration_request_timestamp";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final String f3420h = C4039h.m2810a((Class<?>) C4131c.class);
    @VisibleForTesting

    /* renamed from: g */
    final Set<String> f3421g;

    /* renamed from: i */
    private final Context f3422i;

    /* renamed from: j */
    private final MarketingCloudConfig f3423j;

    /* renamed from: k */
    private final C4016h f3424k;

    /* renamed from: l */
    private final String f3425l;

    /* renamed from: m */
    private final C3872b f3426m;

    /* renamed from: n */
    private final C3949f f3427n;

    /* renamed from: o */
    private final Set<RegistrationManager.RegistrationEventListener> f3428o = new ArraySet();

    /* renamed from: p */
    private Map<String, String> f3429p = new HashMap();

    /* renamed from: q */
    private Set<String> f3430q = new TreeSet();

    /* renamed from: r */
    private boolean f3431r;

    /* renamed from: s */
    private boolean f3432s;

    /* renamed from: t */
    private boolean f3433t;

    /* renamed from: u */
    private String f3434u;

    /* renamed from: v */
    private String f3435v;

    /* renamed from: w */
    private String f3436w;

    /* renamed from: com.salesforce.marketingcloud.registration.d$a */
    static class C4135a implements RegistrationManager.Editor {

        /* renamed from: a */
        private static final List<String> f3437a;

        /* renamed from: b */
        private final Object f3438b = new Object();
        @GuardedBy("lock")

        /* renamed from: c */
        private final Map<String, String> f3439c = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        @GuardedBy("lock")

        /* renamed from: d */
        private final Set<String> f3440d = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        @GuardedBy("lock")

        /* renamed from: e */
        private String f3441e;
        @GuardedBy("lock")

        /* renamed from: f */
        private C4136b f3442f;
        @GuardedBy("lock")

        /* renamed from: g */
        private String f3443g;
        @GuardedBy("lock")

        /* renamed from: h */
        private Map<String, String> f3444h;
        @GuardedBy("lock")

        /* renamed from: i */
        private boolean f3445i;

        static {
            String[] strArr = {"addressId", TagMap.AttributeHandler.ALIAS, "apId", "backgroundRefreshEnabled", "badge", "channel", "contactId", "contactKey", "createdBy", "createdDate", "customObjectKey", "device", Constants.DEVICEID_HEADER, "deviceType", "gcmSenderId", "hardwareId", "isHonorDst", "lastAppOpen", "lastMessageOpen", "lastSend", "locationEnabled", "messageOpenCount", "modifiedBy", "modifiedDate", "optInDate", "optInMethodId", "optInStatusId", "optOutDate", "optOutMethodId", "optOutStatusId", "platform", RemoteConfigConstants.RequestFieldKey.PLATFORM_VERSION, "providerToken", "proximityEnabled", "pushAddressExtensionId", "pushApplicationId", RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "sendCount", FirebaseAnalytics.Param.SOURCE, "sourceObjectId", "status", "systemToken", "timezone", "utcOffset", "signedString"};
            ArrayList arrayList = new ArrayList();
            for (String lowerCase : strArr) {
                arrayList.add(lowerCase.toLowerCase(Locale.ENGLISH));
            }
            f3437a = Collections.unmodifiableList(arrayList);
        }

        C4135a(C4136b bVar, String str, String str2, Map<String, String> map, Set<String> set, Set<String> set2) {
            this.f3442f = bVar;
            this.f3441e = str;
            this.f3443g = str2;
            this.f3444h = new C4129a(map);
            for (String next : set) {
                this.f3439c.put(next, next);
            }
            this.f3440d.addAll(set2);
        }

        @Nullable
        /* renamed from: a */
        private boolean m3454a(String str) {
            if (TextUtils.isEmpty(str)) {
                C4039h.m2826d(C4134d.f3420h, "The attribute you provided was null or empty.", new Object[0]);
                return false;
            }
            String trim = str.trim();
            if (TextUtils.isEmpty(trim)) {
                C4039h.m2826d(C4134d.f3420h, "The attribute you provided was blank.", new Object[0]);
                return false;
            } else if (f3437a.contains(trim.toLowerCase(Locale.ENGLISH))) {
                C4039h.m2826d(C4134d.f3420h, "Attribute key '%s' is invalid and can not be added.  Please see documentation regarding Attributes and Reserved Words.", trim);
                return false;
            } else if (trim.length() <= 128) {
                return true;
            } else {
                C4039h.m2826d(C4134d.f3420h, "Your attribute key was %s characters long.  Attribute keys are restricted to %s characters.  Your attribute key will be truncated.", Integer.valueOf(trim.length()), 128);
                return false;
            }
        }

        @Nullable
        /* renamed from: b */
        private boolean m3455b(String str) {
            if (str != null) {
                return true;
            }
            C4039h.m2829e(C4134d.f3420h, "Attribute value was null and will not be saved.", new Object[0]);
            return false;
        }

        @Nullable
        /* renamed from: c */
        private String m3456c(String str) {
            return str != null ? str.trim() : str;
        }

        @Nullable
        /* renamed from: d */
        private String m3457d(String str) {
            if (!TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) != 0) {
                return str.trim();
            }
            C4039h.m2826d(C4134d.f3420h, "An empty or NULL ContactKey will not be transmitted to the Marketing Cloud and was NOT updated with the provided value.", new Object[0]);
            return null;
        }

        /* renamed from: e */
        private boolean m3458e(@Nullable String str) {
            return str == null || !str.trim().isEmpty();
        }

        @NonNull
        public RegistrationManager.Editor addTag(String str) {
            String c = m3456c(str);
            synchronized (this.f3438b) {
                if (!TextUtils.isEmpty(c) && !c.equals(this.f3439c.put(c, c))) {
                    this.f3445i = true;
                }
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor addTags(Iterable<String> iterable) {
            if (iterable == null) {
                return this;
            }
            for (String addTag : iterable) {
                addTag(addTag);
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor addTags(String... strArr) {
            if (!(strArr == null || strArr.length == 0)) {
                for (String addTag : strArr) {
                    addTag(addTag);
                }
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor clearAttribute(String str) {
            return !m3454a(str) ? this : setAttribute(str, "");
        }

        @NonNull
        public RegistrationManager.Editor clearAttributes(Iterable<String> iterable) {
            for (String clearAttribute : iterable) {
                clearAttribute(clearAttribute);
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor clearAttributes(String... strArr) {
            if (!(strArr == null || strArr.length == 0)) {
                for (String clearAttribute : strArr) {
                    clearAttribute(clearAttribute);
                }
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor clearTags() {
            synchronized (this.f3438b) {
                if (this.f3439c.keySet().retainAll(this.f3440d)) {
                    this.f3445i = true;
                }
            }
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean commit() {
            /*
                r6 = this;
                java.lang.Object r0 = r6.f3438b
                monitor-enter(r0)
                com.salesforce.marketingcloud.registration.d$b r1 = r6.f3442f     // Catch:{ all -> 0x0022 }
                if (r1 == 0) goto L_0x001f
                boolean r1 = r6.f3445i     // Catch:{ all -> 0x0022 }
                if (r1 == 0) goto L_0x001f
                com.salesforce.marketingcloud.registration.d$b r1 = r6.f3442f     // Catch:{ all -> 0x0022 }
                java.lang.String r2 = r6.f3441e     // Catch:{ all -> 0x0022 }
                java.lang.String r3 = r6.f3443g     // Catch:{ all -> 0x0022 }
                java.util.Map<java.lang.String, java.lang.String> r4 = r6.f3444h     // Catch:{ all -> 0x0022 }
                java.util.Map<java.lang.String, java.lang.String> r5 = r6.f3439c     // Catch:{ all -> 0x0022 }
                java.util.Collection r5 = r5.values()     // Catch:{ all -> 0x0022 }
                r1.mo57022a(r2, r3, r4, r5)     // Catch:{ all -> 0x0022 }
                r1 = 1
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                return r1
            L_0x001f:
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                r0 = 0
                return r0
            L_0x0022:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.registration.C4134d.C4135a.commit():boolean");
        }

        @NonNull
        public RegistrationManager.Editor removeTag(String str) {
            if (str == null) {
                return this;
            }
            synchronized (this.f3438b) {
                if (!this.f3440d.contains(str) && this.f3439c.remove(str) != null) {
                    this.f3445i = true;
                }
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor removeTags(Iterable<String> iterable) {
            if (iterable == null) {
                return this;
            }
            for (String removeTag : iterable) {
                removeTag(removeTag);
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor removeTags(String... strArr) {
            if (!(strArr == null || strArr.length == 0)) {
                for (String removeTag : strArr) {
                    removeTag(removeTag);
                }
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor setAttribute(@NonNull String str, @NonNull String str2) {
            synchronized (this.f3438b) {
                if (m3454a(str) && m3455b(str2)) {
                    this.f3444h.put(str, str2);
                    this.f3445i = true;
                }
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor setContactKey(@NonNull String str) {
            if (m3457d(str) != null) {
                synchronized (this.f3438b) {
                    this.f3445i = true;
                    this.f3443g = str;
                }
            }
            return this;
        }

        @NonNull
        public RegistrationManager.Editor setSignedString(@Size(min = 1) @Nullable String str) {
            synchronized (this.f3438b) {
                if (m3458e(str)) {
                    this.f3441e = str;
                    this.f3445i = true;
                }
            }
            return this;
        }
    }

    /* renamed from: com.salesforce.marketingcloud.registration.d$b */
    interface C4136b {
        /* renamed from: a */
        void mo57022a(String str, String str2, Map<String, String> map, Collection<String> collection);
    }

    C4134d(@NonNull Context context, @NonNull MarketingCloudConfig marketingCloudConfig, @NonNull C4016h hVar, @NonNull String str, @NonNull C3872b bVar, @NonNull C3949f fVar, @NonNull PushMessageManager pushMessageManager, @NonNull RegionMessageManager regionMessageManager) {
        this.f3422i = context;
        this.f3423j = marketingCloudConfig;
        this.f3424k = hVar;
        this.f3425l = str;
        this.f3426m = bVar;
        this.f3427n = fVar;
        TreeSet treeSet = new TreeSet();
        treeSet.add("ALL");
        treeSet.add("Android");
        if (C4029h.m2776b(context)) {
            treeSet.add("DEBUG");
        }
        this.f3421g = Collections.unmodifiableSet(treeSet);
        this.f3433t = pushMessageManager.isPushEnabled();
        this.f3432s = regionMessageManager.isProximityMessagingEnabled();
        this.f3431r = regionMessageManager.isGeofenceMessagingEnabled();
        this.f3435v = pushMessageManager.getPushToken();
        try {
            Registration a = hVar.mo56540l().mo56508a(hVar.mo56524a());
            if (a == null) {
                C4007c d = hVar.mo56531d();
                this.f3429p = C4029h.m2778c(d.mo56523b(C4007c.f2875b, ""));
                this.f3434u = d.mo56523b(C4007c.f2877d, (String) null);
                Set<String> d2 = C4029h.m2780d(d.mo56523b(C4007c.f2876c, ""));
                this.f3430q = d2.isEmpty() ? new TreeSet<>(this.f3421g) : d2;
                this.f3436w = null;
                hVar.mo56540l().mo56509a(m3439h(), hVar.mo56524a());
            } else {
                this.f3436w = a.signedString();
                this.f3434u = a.contactKey();
                this.f3429p = new HashMap(a.attributes());
                this.f3430q = a.tags();
                hVar.mo56540l().mo56511b(m3439h(), hVar.mo56524a());
                m3438g();
            }
        } catch (Exception e) {
            C4039h.m2830e(f3420h, e, "Error trying to get, update or add a registration to local storage.", new Object[0]);
            this.f3430q = new TreeSet(this.f3421g);
            this.f3429p = new HashMap();
            this.f3435v = null;
            this.f3434u = null;
            this.f3436w = null;
            hVar.mo56540l().mo56509a(m3439h(), hVar.mo56524a());
        }
        bVar.mo56211b(C3848a.C3850a.REGISTRATION);
    }

    /* renamed from: a */
    static void m3432a(C4016h hVar, C3872b bVar, boolean z) {
        if (z) {
            hVar.mo56540l().mo56510b();
        }
        bVar.mo56213c(C3848a.C3850a.REGISTRATION);
    }

    /* renamed from: a */
    static boolean m3433a(@NonNull C4016h hVar) {
        try {
            Registration a = hVar.mo56540l().mo56508a(hVar.mo56524a());
            return a != null && m3435a(a, hVar);
        } catch (Exception e) {
            C4039h.m2830e(f3420h, e, "Failed to get Registration from local storage, we do not have a push token from Google or we can not determine if this Registration contains any changes.", new Object[0]);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m3434a(@NonNull C4016h hVar, @IntRange(from = 0) long j) {
        return j < hVar.mo56532e().getLong(f3419f, 0) + 60000;
    }

    /* renamed from: a */
    private static boolean m3435a(Registration registration, @NonNull C4016h hVar) {
        if (registration == null || !m3436b(registration)) {
            return false;
        }
        String string = hVar.mo56532e().getString(f3417d, (String) null);
        return string == null || !C4029h.m2782f(registration.mo56975b().toString()).equals(string);
    }

    /* renamed from: b */
    private static boolean m3436b(Registration registration) {
        return !TextUtils.isEmpty(registration.systemToken());
    }

    /* renamed from: g */
    private void m3438g() {
        if (!this.f3430q.containsAll(this.f3421g)) {
            this.f3430q.addAll(this.f3421g);
            mo57031b();
        }
    }

    /* renamed from: h */
    private Registration m3439h() {
        return Registration.m3386c().mo56956a(this.f3436w).mo56969g(this.f3434u).mo56957a(this.f3429p).mo56958a(this.f3430q).mo56961b(this.f3425l).mo56966d(this.f3433t).mo56962b(this.f3431r || this.f3432s).mo56964c(this.f3432s).mo56963c(this.f3435v).mo56979a(this.f3423j, this.f3422i, this.f3425l).mo56981b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public RegistrationManager.Editor mo57023a(C4136b bVar) {
        return new C4135a(bVar, this.f3436w, this.f3434u, this.f3429p, this.f3430q, this.f3421g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo57024a() {
        Registration h = m3439h();
        if (h == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("current_registration", h.mo56975b());
            String b = this.f3424k.mo56531d().mo56523b(C4007c.f2881h, (String) null);
            if (b != null) {
                jSONObject.put("last_registration_sent", new JSONObject(b));
            }
            long j = this.f3424k.mo56532e().getLong(f3418e, 0);
            if (j > 0) {
                jSONObject.put("last_sent_timestamp", C4029h.m2766a(new Date(j)));
            }
        } catch (JSONException e) {
            C4039h.m2830e(f3420h, e, "Failed to build our component state JSONObject.", new Object[0]);
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57025a(int i, String str) {
        C4039h.m2820b(f3420h, "%s: %s", Integer.valueOf(i), str);
        mo57026a(System.currentTimeMillis());
        this.f3426m.mo56211b(C3848a.C3850a.REGISTRATION);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public void mo57026a(long j) {
        this.f3424k.mo56532e().edit().putLong(f3419f, j).apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57027a(@NonNull Registration registration) {
        this.f3426m.mo56214d(C3848a.C3850a.REGISTRATION);
        mo57026a(System.currentTimeMillis());
        synchronized (this.f3428o) {
            for (RegistrationManager.RegistrationEventListener next : this.f3428o) {
                if (next != null) {
                    try {
                        next.onRegistrationReceived(registration);
                    } catch (Exception e) {
                        C4039h.m2830e(f3420h, e, "%s threw an exception while processing the registration response", next.getClass().getName());
                    }
                }
            }
        }
        String jSONObject = registration.mo56975b().toString();
        this.f3424k.mo56531d().mo56522a(C4007c.f2881h, jSONObject);
        this.f3424k.mo56532e().edit().putLong(f3418e, System.currentTimeMillis()).putString(f3417d, C4029h.m2782f(jSONObject)).apply();
        this.f3424k.mo56540l().mo56507a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57028a(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f3435v)) {
            this.f3435v = str;
            mo57031b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57029a(String str, String str2, Map<String, String> map, Collection<String> collection) {
        this.f3436w = str;
        this.f3434u = str2;
        this.f3429p.clear();
        this.f3429p.putAll(map);
        this.f3430q.clear();
        this.f3430q.addAll(collection);
        mo57031b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57030a(boolean z) {
        this.f3433t = z;
        mo57031b();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public void mo57031b() {
        try {
            this.f3424k.mo56540l().mo56509a(m3439h(), this.f3424k.mo56524a());
            if (m3434a(this.f3424k, System.currentTimeMillis())) {
                this.f3426m.mo56214d(C3848a.C3850a.REGISTRATION);
                this.f3426m.mo56211b(C3848a.C3850a.REGISTRATION);
                return;
            }
            this.f3426m.mo56213c(C3848a.C3850a.REGISTRATION);
            mo57033c();
        } catch (Exception e) {
            C4039h.m2830e(f3420h, e, "An error occurred trying to save our Registration.", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo57032b(boolean z) {
        this.f3431r = z;
        mo57031b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo57033c() {
        mo57026a(System.currentTimeMillis());
        try {
            Registration a = this.f3424k.mo56540l().mo56508a(this.f3424k.mo56524a());
            if (a != null && m3435a(a, this.f3424k)) {
                this.f3427n.mo56416a(C3944d.REGISTRATION.mo56403a(this.f3423j, a.mo56978f()));
            }
        } catch (Exception e) {
            C4039h.m2830e(f3420h, e, "Failed to get our Registration from local storage.", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo57034c(boolean z) {
        this.f3432s = z;
        mo57031b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo57035d() {
        this.f3426m.mo56213c(C3848a.C3850a.REGISTRATION);
        mo57031b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo57036e() {
        mo57031b();
    }

    @NonNull
    public RegistrationManager.Editor edit() {
        C4039h.m2820b(f3420h, "Changes with this editor will not be saved.", new Object[0]);
        return new C4135a((C4136b) null, this.f3436w, this.f3434u, this.f3429p, this.f3430q, this.f3421g);
    }

    @NonNull
    public Map<String, String> getAttributes() {
        return new HashMap(this.f3429p);
    }

    @Nullable
    public String getContactKey() {
        return this.f3434u;
    }

    @NonNull
    public String getDeviceId() {
        return this.f3425l;
    }

    @Nullable
    public String getSignedString() {
        return this.f3436w;
    }

    @Nullable
    public String getSystemToken() {
        return this.f3435v;
    }

    @NonNull
    public Set<String> getTags() {
        return new TreeSet(this.f3430q);
    }

    public void registerForRegistrationEvents(@NonNull RegistrationManager.RegistrationEventListener registrationEventListener) {
        if (registrationEventListener != null) {
            synchronized (this.f3428o) {
                this.f3428o.add(registrationEventListener);
            }
        }
    }

    public void unregisterForRegistrationEvents(@NonNull RegistrationManager.RegistrationEventListener registrationEventListener) {
        synchronized (this.f3428o) {
            this.f3428o.remove(registrationEventListener);
        }
    }
}

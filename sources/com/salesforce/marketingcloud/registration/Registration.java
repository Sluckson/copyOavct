package com.salesforce.marketingcloud.registration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.p027e.C4026e;
import com.salesforce.marketingcloud.p027e.C4029h;
import com.salesforce.marketingcloud.p027e.C4036i;
import com.salesforce.marketingcloud.registration.C$AutoValue_Registration;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONObject;

@AutoValue
public abstract class Registration {

    /* renamed from: a */
    private int f3394a;

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @AutoValue.Builder
    /* renamed from: com.salesforce.marketingcloud.registration.Registration$a */
    public static abstract class C4128a {

        /* renamed from: a */
        private int f3395a;

        /* renamed from: a */
        public abstract C4128a mo56955a(int i);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final C4128a mo56979a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull Context context, @NonNull String str) {
            mo56961b(str);
            mo56972j(marketingCloudConfig.applicationId());
            mo56955a(C4029h.m2774b());
            mo56959a(TimeZone.getDefault().inDaylightTime(new Date()));
            mo56973k(Locale.getDefault().toString());
            mo56970h("Android");
            mo56968f(Build.VERSION.RELEASE);
            mo56971i(String.format(Locale.ENGLISH, "%s %s", new Object[]{Build.MANUFACTURER, Build.MODEL}));
            mo56965d(C4036i.m2803a());
            mo56967e(C4026e.m2756a(context));
            return this;
        }

        /* renamed from: a */
        public abstract C4128a mo56956a(String str);

        /* renamed from: a */
        public abstract C4128a mo56957a(Map<String, String> map);

        /* renamed from: a */
        public abstract C4128a mo56958a(Set<String> set);

        /* renamed from: a */
        public abstract C4128a mo56959a(boolean z);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract Registration mo56960a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final C4128a mo56980b(int i) {
            this.f3395a = i;
            return this;
        }

        /* renamed from: b */
        public abstract C4128a mo56961b(String str);

        /* renamed from: b */
        public abstract C4128a mo56962b(boolean z);

        /* renamed from: b */
        public final Registration mo56981b() {
            Registration a = mo56960a();
            a.mo56974a(this.f3395a);
            return a;
        }

        /* renamed from: c */
        public abstract C4128a mo56963c(String str);

        /* renamed from: c */
        public abstract C4128a mo56964c(boolean z);

        /* renamed from: d */
        public abstract C4128a mo56965d(String str);

        /* renamed from: d */
        public abstract C4128a mo56966d(boolean z);

        /* renamed from: e */
        public abstract C4128a mo56967e(String str);

        /* renamed from: f */
        public abstract C4128a mo56968f(String str);

        /* renamed from: g */
        public abstract C4128a mo56969g(String str);

        /* renamed from: h */
        public abstract C4128a mo56970h(String str);

        /* renamed from: i */
        public abstract C4128a mo56971i(String str);

        /* renamed from: j */
        public abstract C4128a mo56972j(String str);

        /* renamed from: k */
        public abstract C4128a mo56973k(String str);
    }

    /* renamed from: b */
    static Registration m3385b(JSONObject jSONObject) {
        return C4130b.m3418a(jSONObject);
    }

    @NonNull
    /* renamed from: c */
    public static C4128a m3386c() {
        return new C$AutoValue_Registration.C4127a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C4128a mo56933a();

    /* renamed from: a */
    public final void mo56974a(int i) {
        this.f3394a = i;
    }

    @NonNull
    @MCKeep
    public abstract String appId();

    @NonNull
    @MCKeep
    public abstract String appVersion();

    @NonNull
    @MCKeep
    public abstract Map<String, String> attributes();

    @NonNull
    /* renamed from: b */
    public abstract JSONObject mo56975b();

    @Nullable
    @MCKeep
    public abstract String contactKey();

    @VisibleForTesting
    @NonNull
    /* renamed from: d */
    public final C4128a mo56976d() {
        return mo56933a().mo56980b(this.f3394a);
    }

    @NonNull
    @MCKeep
    public abstract String deviceId();

    @MCKeep
    public abstract boolean dst();

    @SuppressLint({"KotlinPropertyAccess"})
    /* renamed from: e */
    public final int mo56977e() {
        return this.f3394a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo56978f() {
        try {
            return mo56975b().put("registrationDateUtc", C4029h.m2766a(new Date())).toString();
        } catch (Exception e) {
            C4039h.m2830e("Registration", e, "Unable to create registration request payload", new Object[0]);
            return null;
        }
    }

    @NonNull
    @MCKeep
    public abstract String hwid();

    @NonNull
    @MCKeep
    public abstract String locale();

    @MCKeep
    public abstract boolean locationEnabled();

    @NonNull
    @MCKeep
    public abstract String platform();

    @NonNull
    @MCKeep
    public abstract String platformVersion();

    @MCKeep
    public abstract boolean proximityEnabled();

    @MCKeep
    public abstract boolean pushEnabled();

    @NonNull
    @MCKeep
    public abstract String sdkVersion();

    @Nullable
    @MCKeep
    public abstract String signedString();

    @Nullable
    @MCKeep
    public abstract String systemToken();

    @NonNull
    @MCKeep
    public abstract Set<String> tags();

    @MCKeep
    public abstract int timeZone();
}

package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.salesforce.marketingcloud.p022d.C4020l;
import com.salesforce.marketingcloud.p022d.p023a.p024a.C3964a;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4025d;
import com.salesforce.marketingcloud.p027e.C4026e;
import com.salesforce.marketingcloud.p027e.C4029h;
import com.salesforce.marketingcloud.p027e.C4036i;
import com.salesforce.marketingcloud.registration.Registration;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.a.i */
public final class C4002i extends C3979b implements C4020l {

    /* renamed from: a */
    public static final String f2836a = "registration";
    @VisibleForTesting

    /* renamed from: b */
    public static final String[] f2837b = {"id", "platform", "subscriber_key", "et_app_id", "timezone", "dst", "tags", "attributes", "platform_version", "push_enabled", "location_enabled", C4003a.f2851l, "hwid", C4003a.f2854o, "device_id", C4003a.f2856q, C4003a.f2857r, C4003a.f2858s, "locale"};

    /* renamed from: c */
    public static final String f2838c = "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, proximity_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, signed_string VARCHAR, locale VARCHAR );";

    /* renamed from: d */
    private final Context f2839d;

    /* renamed from: com.salesforce.marketingcloud.d.a.i$a */
    public static class C4003a {

        /* renamed from: a */
        public static final String f2840a = "id";

        /* renamed from: b */
        public static final String f2841b = "platform";

        /* renamed from: c */
        public static final String f2842c = "subscriber_key";

        /* renamed from: d */
        public static final String f2843d = "et_app_id";

        /* renamed from: e */
        public static final String f2844e = "timezone";

        /* renamed from: f */
        public static final String f2845f = "dst";

        /* renamed from: g */
        public static final String f2846g = "tags";

        /* renamed from: h */
        public static final String f2847h = "attributes";

        /* renamed from: i */
        public static final String f2848i = "platform_version";

        /* renamed from: j */
        public static final String f2849j = "push_enabled";

        /* renamed from: k */
        public static final String f2850k = "location_enabled";

        /* renamed from: l */
        public static final String f2851l = "proximity_enabled";

        /* renamed from: m */
        public static final String f2852m = "hwid";

        /* renamed from: n */
        public static final String f2853n = "locale";

        /* renamed from: o */
        public static final String f2854o = "system_token";

        /* renamed from: p */
        public static final String f2855p = "device_id";

        /* renamed from: q */
        public static final String f2856q = "app_version";

        /* renamed from: r */
        public static final String f2857r = "sdk_version";

        /* renamed from: s */
        public static final String f2858s = "signed_string";
    }

    public C4002i(SQLiteDatabase sQLiteDatabase, Context context) {
        super(sQLiteDatabase);
        this.f2839d = context;
    }

    /* renamed from: a */
    private static Registration m2626a(Cursor cursor, @NonNull C4022a aVar) {
        boolean z = false;
        Registration.C4128a a = Registration.m3386c().mo56972j(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("et_app_id")))).mo56957a(C4029h.m2778c(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("attributes"))))).mo56958a(C4029h.m2780d(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("tags"))))).mo56969g(aVar.mo56545b(cursor.getString(cursor.getColumnIndex("subscriber_key")))).mo56956a(aVar.mo56545b(cursor.getString(cursor.getColumnIndex(C4003a.f2858s)))).mo56963c(aVar.mo56545b(cursor.getString(cursor.getColumnIndex(C4003a.f2854o)))).mo56961b(cursor.getString(cursor.getColumnIndex("device_id"))).mo56966d(cursor.getInt(cursor.getColumnIndex("push_enabled")) == 1).mo56962b(cursor.getInt(cursor.getColumnIndex("location_enabled")) == 1).mo56964c(cursor.getInt(cursor.getColumnIndex(C4003a.f2851l)) == 1).mo56973k(cursor.getString(cursor.getColumnIndex("locale"))).mo56955a(cursor.getInt(cursor.getColumnIndex("timezone")));
        if (cursor.getInt(cursor.getColumnIndex("dst")) == 1) {
            z = true;
        }
        Registration b = a.mo56959a(z).mo56971i(cursor.getString(cursor.getColumnIndex("hwid"))).mo56970h(cursor.getString(cursor.getColumnIndex("platform"))).mo56968f(cursor.getString(cursor.getColumnIndex("platform_version"))).mo56967e(cursor.getString(cursor.getColumnIndex(C4003a.f2856q))).mo56965d(cursor.getString(cursor.getColumnIndex(C4003a.f2857r))).mo56981b();
        b.mo56974a(cursor.getInt(cursor.getColumnIndex("id")));
        return b;
    }

    /* renamed from: a */
    private static String m2627a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* renamed from: c */
    private static ContentValues m2628c(Registration registration, @NonNull C4022a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("subscriber_key", aVar.mo56544a(registration.contactKey()));
        contentValues.put(C4003a.f2858s, aVar.mo56544a(registration.signedString()));
        contentValues.put("et_app_id", aVar.mo56544a(registration.appId()));
        contentValues.put(C4003a.f2854o, aVar.mo56544a(registration.systemToken()));
        contentValues.put("tags", aVar.mo56544a(C4029h.m2768a(registration.tags())));
        contentValues.put("attributes", aVar.mo56544a(C4029h.m2767a(registration.attributes())));
        contentValues.put("device_id", registration.deviceId());
        contentValues.put("platform", registration.platform());
        contentValues.put("timezone", Integer.valueOf(registration.timeZone()));
        contentValues.put("dst", Integer.valueOf(registration.dst() ? 1 : 0));
        contentValues.put("platform_version", registration.platformVersion());
        contentValues.put("push_enabled", Integer.valueOf(registration.pushEnabled() ? 1 : 0));
        contentValues.put("location_enabled", Integer.valueOf(registration.locationEnabled() ? 1 : 0));
        contentValues.put(C4003a.f2851l, Integer.valueOf(registration.proximityEnabled() ? 1 : 0));
        contentValues.put("hwid", registration.hwid());
        contentValues.put("locale", registration.locale());
        contentValues.put(C4003a.f2856q, registration.appVersion());
        contentValues.put(C4003a.f2857r, registration.sdkVersion());
        return contentValues;
    }

    /* renamed from: a */
    public int mo56507a() {
        return mo56462c(m2627a("%1$s NOT IN ( SELECT %1$s FROM ( SELECT %1$s FROM %2$s ORDER BY %1$s DESC LIMIT 1))", "id", mo56450e()));
    }

    @Nullable
    /* renamed from: a */
    public Registration mo56508a(@NonNull C4022a aVar) {
        Cursor a = mo56461a(f2837b, (String) null, (String[]) null, (String) null, (String) null, m2627a("%s DESC", "id"), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        Registration registration = null;
        if (a != null) {
            if (a.moveToFirst()) {
                registration = m2626a(a, aVar);
            }
            a.close();
        }
        return registration;
    }

    /* renamed from: a */
    public void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase) {
        Cursor query = sQLiteDatabase.query("registration", C3964a.C3977g.f2708a, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            if (query.moveToFirst()) {
                do {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("subscriber_key", aVar2.mo56544a(aVar.mo56545b(query.getString(query.getColumnIndex("subscriber_key")))));
                    contentValues.put(C4003a.f2858s, (String) null);
                    contentValues.put("et_app_id", aVar2.mo56544a(aVar.mo56545b(query.getString(query.getColumnIndex("et_app_id")))));
                    contentValues.put("tags", aVar2.mo56544a(aVar.mo56545b(query.getString(query.getColumnIndex("tags")))));
                    contentValues.put("attributes", aVar2.mo56544a(aVar.mo56545b(query.getString(query.getColumnIndex("attributes")))));
                    contentValues.put("device_id", C4025d.m2755a(this.f2839d));
                    contentValues.put("id", Integer.valueOf(query.getInt(query.getColumnIndex("id"))));
                    contentValues.put("platform", query.getString(query.getColumnIndex("platform")));
                    contentValues.put(C4003a.f2856q, C4026e.m2756a(this.f2839d));
                    contentValues.put(C4003a.f2857r, C4036i.m2803a());
                    contentValues.put("timezone", Integer.valueOf(query.getInt(query.getColumnIndex("timezone"))));
                    contentValues.put("dst", Integer.valueOf(query.getInt(query.getColumnIndex("dst"))));
                    contentValues.put("platform_version", query.getString(query.getColumnIndex("platform_version")));
                    contentValues.put("push_enabled", Integer.valueOf(query.getInt(query.getColumnIndex("push_enabled"))));
                    contentValues.put("location_enabled", Integer.valueOf(query.getInt(query.getColumnIndex("location_enabled"))));
                    contentValues.put("hwid", query.getString(query.getColumnIndex("hwid")));
                    contentValues.put("locale", query.getString(query.getColumnIndex("locale")));
                    mo56455a(contentValues);
                } while (query.moveToNext());
            }
            query.close();
        }
    }

    /* renamed from: a */
    public void mo56509a(Registration registration, @NonNull C4022a aVar) {
        registration.mo56974a((int) mo56455a(m2628c(registration, aVar)));
    }

    /* renamed from: b */
    public int mo56510b() {
        return mo56462c((String) null);
    }

    /* renamed from: b */
    public int mo56511b(Registration registration, @NonNull C4022a aVar) {
        return mo56453a(m2628c(registration, aVar), m2627a("%s = ?", "id"), new String[]{String.valueOf(registration.mo56977e())});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo56450e() {
        return "registration";
    }
}

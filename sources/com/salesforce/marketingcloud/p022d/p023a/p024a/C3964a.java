package com.salesforce.marketingcloud.p022d.p023a.p024a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@Deprecated
/* renamed from: com.salesforce.marketingcloud.d.a.a.a */
public class C3964a extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final String f2605a = "etdb.db";

    /* renamed from: b */
    public static final String[] f2606b = {"registration", "messages", "analytic_item", C3967b.f2635b, C3969c.f2642b, "region_message", "regions"};

    /* renamed from: c */
    private static final String f2607c = C4039h.m2810a((Class<?>) C3964a.class);

    /* renamed from: d */
    private static final int f2608d = 10;

    /* renamed from: e */
    private static final String f2609e = " ADD COLUMN ";

    /* renamed from: f */
    private static final String f2610f = " BIGINT;";

    /* renamed from: g */
    private static final String f2611g = " VARCHAR;";

    /* renamed from: h */
    private static final String f2612h = " SMALLINT;";

    /* renamed from: i */
    private static final String f2613i = " INTEGER;";

    /* renamed from: j */
    private static final String f2614j = " TEXT;";

    /* renamed from: k */
    private static final String f2615k = "DROP TABLE IF EXISTS ";

    /* renamed from: l */
    private static final String f2616l = "ALTER TABLE ";

    /* renamed from: m */
    private static final String f2617m = " = ? ";

    /* renamed from: n */
    private static final String f2618n = " = ?";

    /* renamed from: o */
    private final C4022a f2619o;

    /* renamed from: com.salesforce.marketingcloud.d.a.a.a$a */
    public static class C3965a {

        /* renamed from: a */
        public static final String[] f2620a = {"id", "device_id", "et_app_id", "event_date", C3966a.f2627e, "object_ids", "value", "ready_to_send", C3966a.f2631i, "last_sent", "json_payload"};

        /* renamed from: b */
        public static final String f2621b = "analytic_item";

        /* renamed from: c */
        public static final String f2622c = "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, et_app_id VARCHAR, event_date VARCHAR, analytic_types VARCHAR, object_ids VARCHAR, value INTEGER, ready_to_send SMALLINT, pi_app_key VARCHAR, last_sent BIGINT, json_payload VARCHAR);";

        /* renamed from: com.salesforce.marketingcloud.d.a.a.a$a$a */
        public static class C3966a {

            /* renamed from: a */
            public static final String f2623a = "id";

            /* renamed from: b */
            public static final String f2624b = "device_id";

            /* renamed from: c */
            public static final String f2625c = "et_app_id";

            /* renamed from: d */
            public static final String f2626d = "event_date";

            /* renamed from: e */
            public static final String f2627e = "analytic_types";

            /* renamed from: f */
            public static final String f2628f = "object_ids";

            /* renamed from: g */
            public static final String f2629g = "value";

            /* renamed from: h */
            public static final String f2630h = "ready_to_send";

            /* renamed from: i */
            public static final String f2631i = "pi_app_key";

            /* renamed from: j */
            public static final String f2632j = "last_sent";

            /* renamed from: k */
            public static final String f2633k = "json_payload";
        }
    }

    /* renamed from: com.salesforce.marketingcloud.d.a.a.a$b */
    public static class C3967b {

        /* renamed from: a */
        public static final String[] f2634a = {"id", "device_id", "latitude", "longitude"};

        /* renamed from: b */
        public static final String f2635b = "beacon_request";

        /* renamed from: c */
        public static final String f2636c = "CREATE TABLE beacon_request (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION );";

        /* renamed from: com.salesforce.marketingcloud.d.a.a.a$b$a */
        public static class C3968a {

            /* renamed from: a */
            public static final String f2637a = "id";

            /* renamed from: b */
            public static final String f2638b = "device_id";

            /* renamed from: c */
            public static final String f2639c = "latitude";

            /* renamed from: d */
            public static final String f2640d = "longitude";
        }
    }

    /* renamed from: com.salesforce.marketingcloud.d.a.a.a$c */
    public static class C3969c {

        /* renamed from: a */
        public static final String[] f2641a = {"id", "device_id", "latitude", "longitude"};

        /* renamed from: b */
        public static final String f2642b = "geofence_request";

        /* renamed from: c */
        public static final String f2643c = "CREATE TABLE geofence_request (id INTEGER PRIMARY KEY AUTOINCREMENT, device_id VARCHAR, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION );";

        /* renamed from: com.salesforce.marketingcloud.d.a.a.a$c$a */
        public static class C3970a {

            /* renamed from: a */
            public static final String f2644a = "id";

            /* renamed from: b */
            public static final String f2645b = "device_id";

            /* renamed from: c */
            public static final String f2646c = "latitude";

            /* renamed from: d */
            public static final String f2647d = "longitude";
        }
    }

    /* renamed from: com.salesforce.marketingcloud.d.a.a.a$d */
    public static class C3971d {

        /* renamed from: a */
        public static final String[] f2648a = {"id", "alert", "sound", "badge", "open_direct", C3972a.f2664f, "start_date", "end_date", "message_type", "content_type", C3972a.f2669k, "url", "subject", C3972a.f2672n, "read", "custom", "keys", "period_show_count", "last_shown_date", "next_allowed_show", "show_count", "message_limit", "rolling_period", "period_type", "number_of_periods", "messages_per_period", "message_deleted", C3972a.f2652B, "proximity", C3972a.f2654D, "has_entered", "notify_id", C3972a.f2657G, C3972a.f2658H};

        /* renamed from: b */
        public static final String f2649b = "messages";

        /* renamed from: c */
        public static final String f2650c = "CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, badge VARCHAR, open_direct VARCHAR, category VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, page_id VARCHAR, url VARCHAR, subject VARCHAR, site_id VARCHAR, read SMALLINT, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, message_deleted SMALLINT, min_tripped INTEGER, proximity INTEGER, ephemeral_message SMALLINT, has_entered SMALLINT, notify_id INTEGER, loiter_seconds INTEGER, entry_time BIGINT );";

        /* renamed from: com.salesforce.marketingcloud.d.a.a.a$d$a */
        public static class C3972a {

            /* renamed from: A */
            public static final String f2651A = "message_deleted";

            /* renamed from: B */
            public static final String f2652B = "min_tripped";

            /* renamed from: C */
            public static final String f2653C = "proximity";

            /* renamed from: D */
            public static final String f2654D = "ephemeral_message";

            /* renamed from: E */
            public static final String f2655E = "has_entered";

            /* renamed from: F */
            public static final String f2656F = "notify_id";

            /* renamed from: G */
            public static final String f2657G = "loiter_seconds";

            /* renamed from: H */
            public static final String f2658H = "entry_time";

            /* renamed from: a */
            public static final String f2659a = "id";

            /* renamed from: b */
            public static final String f2660b = "alert";

            /* renamed from: c */
            public static final String f2661c = "sound";

            /* renamed from: d */
            public static final String f2662d = "badge";

            /* renamed from: e */
            public static final String f2663e = "open_direct";

            /* renamed from: f */
            public static final String f2664f = "category";

            /* renamed from: g */
            public static final String f2665g = "start_date";

            /* renamed from: h */
            public static final String f2666h = "end_date";

            /* renamed from: i */
            public static final String f2667i = "message_type";

            /* renamed from: j */
            public static final String f2668j = "content_type";

            /* renamed from: k */
            public static final String f2669k = "page_id";

            /* renamed from: l */
            public static final String f2670l = "url";

            /* renamed from: m */
            public static final String f2671m = "subject";

            /* renamed from: n */
            public static final String f2672n = "site_id";

            /* renamed from: o */
            public static final String f2673o = "read";

            /* renamed from: p */
            public static final String f2674p = "custom";

            /* renamed from: q */
            public static final String f2675q = "keys";

            /* renamed from: r */
            public static final String f2676r = "period_show_count";

            /* renamed from: s */
            public static final String f2677s = "show_count";

            /* renamed from: t */
            public static final String f2678t = "last_shown_date";

            /* renamed from: u */
            public static final String f2679u = "next_allowed_show";

            /* renamed from: v */
            public static final String f2680v = "message_limit";

            /* renamed from: w */
            public static final String f2681w = "rolling_period";

            /* renamed from: x */
            public static final String f2682x = "period_type";

            /* renamed from: y */
            public static final String f2683y = "number_of_periods";

            /* renamed from: z */
            public static final String f2684z = "messages_per_period";
        }
    }

    /* renamed from: com.salesforce.marketingcloud.d.a.a.a$e */
    public static class C3973e {

        /* renamed from: a */
        public static final String[] f2685a = {"id", "message_id", "region_id"};

        /* renamed from: b */
        public static final String f2686b = "region_message";

        /* renamed from: c */
        public static final String f2687c = "CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );";

        /* renamed from: com.salesforce.marketingcloud.d.a.a.a$e$a */
        public static class C3974a {

            /* renamed from: a */
            public static final String f2688a = "id";

            /* renamed from: b */
            public static final String f2689b = "region_id";

            /* renamed from: c */
            public static final String f2690c = "message_id";
        }
    }

    /* renamed from: com.salesforce.marketingcloud.d.a.a.a$f */
    public static class C3975f {

        /* renamed from: a */
        public static final String[] f2691a = {"id", "latitude", "longitude", "radius", "active", "beacon_guid", "beacon_major", "beacon_minor", C3976a.f2702i, C3976a.f2703j, "description", "name", "location_type", "has_entered"};

        /* renamed from: b */
        public static final String f2692b = "regions";

        /* renamed from: c */
        public static final String f2693c = "CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude DOUBLE PRECISION, longitude DOUBLE PRECISION, radius INTEGER, active SMALLINT, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, entry_count INTEGER, exit_count INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER, has_entered SMALLINT );";

        /* renamed from: com.salesforce.marketingcloud.d.a.a.a$f$a */
        public static class C3976a {

            /* renamed from: a */
            public static final String f2694a = "id";

            /* renamed from: b */
            public static final String f2695b = "latitude";

            /* renamed from: c */
            public static final String f2696c = "longitude";

            /* renamed from: d */
            public static final String f2697d = "radius";

            /* renamed from: e */
            public static final String f2698e = "active";

            /* renamed from: f */
            public static final String f2699f = "beacon_guid";

            /* renamed from: g */
            public static final String f2700g = "beacon_major";

            /* renamed from: h */
            public static final String f2701h = "beacon_minor";

            /* renamed from: i */
            public static final String f2702i = "entry_count";

            /* renamed from: j */
            public static final String f2703j = "exit_count";

            /* renamed from: k */
            public static final String f2704k = "description";

            /* renamed from: l */
            public static final String f2705l = "name";

            /* renamed from: m */
            public static final String f2706m = "location_type";

            /* renamed from: n */
            public static final String f2707n = "has_entered";
        }
    }

    /* renamed from: com.salesforce.marketingcloud.d.a.a.a$g */
    public static class C3977g {

        /* renamed from: a */
        public static final String[] f2708a = {"id", "platform", "device_id", "subscriber_key", "et_app_id", "email", "badge", "timezone", "dst", "tags", "attributes", "platform_version", "push_enabled", "location_enabled", "last_sent", "hwid", C3978a.f2727q, "locale"};

        /* renamed from: b */
        public static final String f2709b = "registration";

        /* renamed from: c */
        public static final String f2710c = "CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, device_id VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, email VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, last_sent BIGINT, hwid VARCHAR, gcm_sender_id VARCHAR, locale VARCHAR );";

        /* renamed from: com.salesforce.marketingcloud.d.a.a.a$g$a */
        public static class C3978a {

            /* renamed from: a */
            public static final String f2711a = "id";

            /* renamed from: b */
            public static final String f2712b = "platform";

            /* renamed from: c */
            public static final String f2713c = "device_id";

            /* renamed from: d */
            public static final String f2714d = "subscriber_key";

            /* renamed from: e */
            public static final String f2715e = "et_app_id";

            /* renamed from: f */
            public static final String f2716f = "email";

            /* renamed from: g */
            public static final String f2717g = "badge";

            /* renamed from: h */
            public static final String f2718h = "timezone";

            /* renamed from: i */
            public static final String f2719i = "dst";

            /* renamed from: j */
            public static final String f2720j = "tags";

            /* renamed from: k */
            public static final String f2721k = "attributes";

            /* renamed from: l */
            public static final String f2722l = "platform_version";

            /* renamed from: m */
            public static final String f2723m = "push_enabled";

            /* renamed from: n */
            public static final String f2724n = "location_enabled";

            /* renamed from: o */
            public static final String f2725o = "last_sent";

            /* renamed from: p */
            public static final String f2726p = "hwid";

            /* renamed from: q */
            public static final String f2727q = "gcm_sender_id";

            /* renamed from: r */
            public static final String f2728r = "locale";
        }
    }

    public C3964a(Context context, C4022a aVar) {
        super(context, f2605a, (SQLiteDatabase.CursorFactory) null, 10);
        this.f2619o = aVar;
    }

    /* renamed from: a */
    private void m2514a(SQLiteDatabase sQLiteDatabase, @NonNull C4022a aVar) {
        Cursor query = sQLiteDatabase.query("analytic_item", C3965a.f2620a, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                int i = query.getInt(query.getColumnIndex("id"));
                String string = query.getString(query.getColumnIndex("device_id"));
                String string2 = query.getString(query.getColumnIndex("et_app_id"));
                String string3 = query.getString(query.getColumnIndex(C3965a.C3966a.f2631i));
                ContentValues contentValues = new ContentValues();
                contentValues.put("device_id", aVar.mo56544a(string));
                contentValues.put("et_app_id", aVar.mo56544a(string2));
                contentValues.put(C3965a.C3966a.f2631i, aVar.mo56544a(string3));
                sQLiteDatabase.update("analytic_item", contentValues, "id = ?", new String[]{String.valueOf(i)});
                query.moveToNext();
            }
            query.close();
        }
    }

    /* renamed from: b */
    private void m2515b(SQLiteDatabase sQLiteDatabase, @NonNull C4022a aVar) {
        Cursor query = sQLiteDatabase.query(C3967b.f2635b, C3967b.f2634a, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                int i = query.getInt(query.getColumnIndex("id"));
                String string = query.getString(query.getColumnIndex("device_id"));
                Double valueOf = Double.valueOf(query.getDouble(query.getColumnIndex("latitude")));
                Double valueOf2 = Double.valueOf(query.getDouble(query.getColumnIndex("longitude")));
                ContentValues contentValues = new ContentValues();
                contentValues.put("device_id", aVar.mo56544a(string));
                contentValues.put("latitude", aVar.mo56544a(String.valueOf(valueOf)));
                contentValues.put("longitude", aVar.mo56544a(String.valueOf(valueOf2)));
                sQLiteDatabase.update(C3967b.f2635b, contentValues, "id = ?", new String[]{String.valueOf(i)});
                query.moveToNext();
            }
            query.close();
        }
    }

    /* renamed from: c */
    private void m2516c(SQLiteDatabase sQLiteDatabase, @NonNull C4022a aVar) {
        Cursor query = sQLiteDatabase.query(C3969c.f2642b, C3969c.f2641a, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                int i = query.getInt(query.getColumnIndex("id"));
                String string = query.getString(query.getColumnIndex("device_id"));
                Double valueOf = Double.valueOf(query.getDouble(query.getColumnIndex("latitude")));
                Double valueOf2 = Double.valueOf(query.getDouble(query.getColumnIndex("longitude")));
                ContentValues contentValues = new ContentValues();
                contentValues.put("device_id", aVar.mo56544a(string));
                contentValues.put("latitude", aVar.mo56544a(String.valueOf(valueOf)));
                contentValues.put("longitude", aVar.mo56544a(String.valueOf(valueOf2)));
                sQLiteDatabase.update(C3969c.f2642b, contentValues, "id = ?", new String[]{String.valueOf(i)});
                query.moveToNext();
            }
            query.close();
        }
    }

    /* renamed from: d */
    private void m2517d(SQLiteDatabase sQLiteDatabase, @NonNull C4022a aVar) {
        C4022a aVar2 = aVar;
        Cursor query = sQLiteDatabase.query("messages", C3971d.f2648a, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                String string = query.getString(query.getColumnIndex("id"));
                String string2 = query.getString(query.getColumnIndex("alert"));
                String string3 = query.getString(query.getColumnIndex("open_direct"));
                String string4 = query.getString(query.getColumnIndex(C3971d.C3972a.f2664f));
                String string5 = query.getString(query.getColumnIndex("url"));
                String string6 = query.getString(query.getColumnIndex("subject"));
                Map<String, String> c = C4029h.m2778c(new String(query.getBlob(query.getColumnIndex("keys"))));
                ContentValues contentValues = new ContentValues();
                contentValues.put("alert", aVar2.mo56544a(string2));
                contentValues.put("open_direct", aVar2.mo56544a(string3));
                contentValues.put(C3971d.C3972a.f2664f, aVar2.mo56544a(string4));
                contentValues.put("url", aVar2.mo56544a(string5));
                contentValues.put("subject", aVar2.mo56544a(string6));
                contentValues.put("keys", aVar2.mo56544a(C4029h.m2767a(c)));
                sQLiteDatabase.update("messages", contentValues, "id = ?", new String[]{string});
                query.moveToNext();
            }
            query.close();
        }
    }

    /* renamed from: e */
    private void m2518e(SQLiteDatabase sQLiteDatabase, @NonNull C4022a aVar) {
        Cursor query = sQLiteDatabase.query("regions", C3975f.f2691a, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                String string = query.getString(query.getColumnIndex("id"));
                Double valueOf = Double.valueOf(query.getDouble(query.getColumnIndex("latitude")));
                Double valueOf2 = Double.valueOf(query.getDouble(query.getColumnIndex("longitude")));
                String string2 = query.getString(query.getColumnIndex("beacon_guid"));
                String string3 = query.getString(query.getColumnIndex("description"));
                String string4 = query.getString(query.getColumnIndex("name"));
                ContentValues contentValues = new ContentValues();
                contentValues.put("latitude", aVar.mo56544a(String.valueOf(valueOf)));
                contentValues.put("longitude", aVar.mo56544a(String.valueOf(valueOf2)));
                contentValues.put("beacon_guid", aVar.mo56544a(string2));
                contentValues.put("description", aVar.mo56544a(string3));
                contentValues.put("name", aVar.mo56544a(string4));
                sQLiteDatabase.update("regions", contentValues, "id = ?", new String[]{string});
                query.moveToNext();
            }
            query.close();
        }
    }

    /* renamed from: f */
    private void m2519f(SQLiteDatabase sQLiteDatabase, @NonNull C4022a aVar) {
        C4022a aVar2 = aVar;
        Cursor query = sQLiteDatabase.query("registration", C3977g.f2708a, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                int i = query.getInt(query.getColumnIndex("id"));
                String string = query.getString(query.getColumnIndex("device_id"));
                String string2 = query.getString(query.getColumnIndex("subscriber_key"));
                String string3 = query.getString(query.getColumnIndex("et_app_id"));
                String string4 = query.getString(query.getColumnIndex("email"));
                String string5 = query.getString(query.getColumnIndex(C3977g.C3978a.f2727q));
                Set<String> d = C4029h.m2780d(new String(query.getBlob(query.getColumnIndex("tags"))));
                int i2 = i;
                String str = "tags";
                Map<String, String> c = C4029h.m2778c(new String(query.getBlob(query.getColumnIndex("attributes"))));
                ContentValues contentValues = new ContentValues();
                contentValues.put("device_id", aVar2.mo56544a(string));
                if (query.getColumnIndex("device_token") >= 0) {
                    contentValues.put("device_token", "");
                }
                contentValues.put("subscriber_key", aVar2.mo56544a(string2));
                contentValues.put("et_app_id", aVar2.mo56544a(string3));
                contentValues.put("email", aVar2.mo56544a(string4));
                contentValues.put(C3977g.C3978a.f2727q, aVar2.mo56544a(string5));
                contentValues.put(str, aVar2.mo56544a(C4029h.m2768a(d)));
                contentValues.put("attributes", aVar2.mo56544a(C4029h.m2767a(c)));
                sQLiteDatabase.update("registration", contentValues, "id = ?", new String[]{String.valueOf(i2)});
                query.moveToNext();
            }
            query.close();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            C4039h.m2820b(f2607c, "onCreate", new Object[0]);
            sQLiteDatabase.execSQL(C3977g.f2710c);
            sQLiteDatabase.execSQL(C3967b.f2636c);
            sQLiteDatabase.execSQL(C3969c.f2643c);
            sQLiteDatabase.execSQL(C3971d.f2650c);
            sQLiteDatabase.execSQL(C3975f.f2693c);
            sQLiteDatabase.execSQL("CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );");
            sQLiteDatabase.execSQL(C3965a.f2622c);
        } catch (Exception e) {
            C4039h.m2830e(f2607c, e, "Can't create database", new Object[0]);
            throw new RuntimeException(e);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            try {
                C4039h.m2820b(f2607c, "Updating DB from %d to 2", Integer.valueOf(i));
                sQLiteDatabase.execSQL("ALTER TABLE registration ADD COLUMN last_sent BIGINT;");
                sQLiteDatabase.execSQL("ALTER TABLE registration ADD COLUMN hwid VARCHAR;");
                sQLiteDatabase.execSQL("ALTER TABLE registration ADD COLUMN gcm_sender_id VARCHAR;");
                sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN message_deleted SMALLINT;");
            } catch (Exception e) {
                C4039h.m2830e(f2607c, e, "Can't update database. blow it away and re-create", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS beacon_request");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS geofence_request");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regions");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS region_message");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS analytic_item");
                onCreate(sQLiteDatabase);
                return;
            }
        }
        if (i < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN beacon_guid VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN beacon_major INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN beacon_minor INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN entry_count INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN exit_count INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN description VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN location_type INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN name VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN has_entered SMALLINT;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN min_tripped INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN proximity INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN ephemeral_message SMALLINT;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN has_entered SMALLINT;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN notify_id INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN loiter_seconds INTEGER;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN entry_time BIGINT;");
            sQLiteDatabase.execSQL(C3965a.f2622c);
            sQLiteDatabase.execSQL(C3967b.f2636c);
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("ALTER TABLE registration ADD COLUMN locale TEXT;");
        }
        if (i < 5) {
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN category VARCHAR;");
        }
        if (i < 6) {
            sQLiteDatabase.execSQL("ALTER TABLE analytic_item ADD COLUMN pi_app_key VARCHAR;");
        }
        if (i < 7) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C3965a.C3966a.f2631i, (String) null);
            int update = sQLiteDatabase.update("analytic_item", contentValues, "pi_app_key = ? ", new String[]{""});
            C4039h.m2820b(f2607c, "PI App Rows updated to null: %d", Integer.valueOf(update));
            m2514a(sQLiteDatabase, this.f2619o);
            m2515b(sQLiteDatabase, this.f2619o);
            m2516c(sQLiteDatabase, this.f2619o);
            m2517d(sQLiteDatabase, this.f2619o);
            m2518e(sQLiteDatabase, this.f2619o);
            m2519f(sQLiteDatabase, this.f2619o);
        }
        if (i < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE analytic_item ADD COLUMN json_payload VARCHAR;");
        }
        if (i < 9) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS location_update");
        }
        if (i < 10) {
            C4039h.m2820b(f2607c, "Deleting magic fence to force messages fetch.", new Object[0]);
            if (sQLiteDatabase.delete("regions", "id = ?", new String[]{Region.C4072b.f3088a}) > 0) {
                C4039h.m2820b(f2607c, "Found and deleted magic fence.", new Object[0]);
            }
        }
    }
}

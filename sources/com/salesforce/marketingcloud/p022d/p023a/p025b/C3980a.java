package com.salesforce.marketingcloud.p022d.p023a.p025b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.p023a.C3962a;
import com.salesforce.marketingcloud.p022d.p023a.C3994e;
import com.salesforce.marketingcloud.p022d.p023a.C4002i;
import com.salesforce.marketingcloud.p022d.p023a.p024a.C3964a;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4025d;
import com.salesforce.marketingcloud.p027e.C4026e;
import com.salesforce.marketingcloud.p027e.C4036i;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d.a.b.a */
public final class C3980a {

    /* renamed from: a */
    static final String f2731a = "geofence_request";

    /* renamed from: b */
    static final String f2732b = "beacon_request";

    /* renamed from: c */
    private static final String f2733c = C4039h.m2810a((Class<?>) C3980a.class);

    /* renamed from: com.salesforce.marketingcloud.d.a.b.a$a */
    private static class C3981a {

        /* renamed from: a */
        final String f2734a;

        /* renamed from: b */
        final String f2735b;

        C3981a(String str, String str2) {
            this.f2734a = str;
            this.f2735b = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C3981a)) {
                return false;
            }
            C3981a aVar = (C3981a) obj;
            if (this.f2734a == null && aVar.f2734a == null) {
                return true;
            }
            return this.f2734a.equalsIgnoreCase(aVar.f2734a);
        }

        public int hashCode() {
            return this.f2734a.toLowerCase().hashCode();
        }
    }

    private C3980a() {
    }

    /* renamed from: a */
    private static synchronized String m2532a(Collection<C3981a> collection) {
        synchronized (C3980a.class) {
            if (collection == null) {
                return null;
            }
            ArrayList<C3981a> arrayList = new ArrayList<>(collection.size());
            for (C3981a add : collection) {
                arrayList.add(add);
            }
            StringBuilder sb = new StringBuilder();
            for (C3981a aVar : arrayList) {
                if (aVar != null) {
                    sb.append(aVar.f2734a);
                    sb.append("^|^");
                    sb.append(aVar.f2735b);
                    sb.append("^|^");
                } else {
                    C4039h.m2826d(f2733c, "A null attribute was encountered.", new Object[0]);
                }
            }
            String sb2 = sb.toString();
            return sb2;
        }
    }

    /* renamed from: a */
    private static ArrayList<C3981a> m2533a(String str) {
        ArrayList<C3981a> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\^\\|\\^");
            int i = 0;
            while (i < split.length) {
                while (true) {
                    if (split[i] != null && !split[i].isEmpty()) {
                        break;
                    }
                    i++;
                }
                int i2 = i + 1;
                if (i2 >= split.length) {
                    arrayList.add(new C3981a(split[i], ""));
                } else {
                    arrayList.add(new C3981a(split[i], split[i2]));
                }
                i += 2;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m2534a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT)");
            sQLiteDatabase.execSQL("INSERT INTO cloud_page_messages SELECT id,start_date,end_date,message_type,content_type,url,subject,read,message_deleted FROM messages WHERE message_type=1 AND content_type=2");
            sQLiteDatabase.execSQL("DELETE FROM messages WHERE message_type=1 AND content_type=2");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C4039h.m2830e(f2733c, e, "Failed to move Messages to CloudPage Messages table.", new Object[0]);
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
                sQLiteDatabase.execSQL("CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT)");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                C4039h.m2830e(f2733c, e2, "Could not create cloud_page_messages table.", new Object[0]);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    /* renamed from: a */
    public static void m2535a(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull Context context, @NonNull C4022a aVar) {
        m2534a(sQLiteDatabase);
        m2536b(sQLiteDatabase);
        m2538c(sQLiteDatabase);
        m2539d(sQLiteDatabase);
        m2537b(sQLiteDatabase, context, aVar);
        m2540e(sQLiteDatabase);
    }

    /* renamed from: b */
    private static void m2536b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DELETE FROM messages WHERE message_type NOT IN ( 5, 3, 4 )");
        } catch (Exception e) {
            C4039h.m2830e(f2733c, e, "Unable to clean unused messages from db.", new Object[0]);
        }
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE messages RENAME TO " + "old_messages");
            sQLiteDatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, has_entered SMALLINT, notify_id INTEGER );");
            sQLiteDatabase.execSQL("INSERT INTO messages SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, has_entered, notify_id FROM " + "old_messages");
            sQLiteDatabase.execSQL("DROP TABLE " + "old_messages");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e2) {
            sQLiteDatabase.endTransaction();
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
                sQLiteDatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, has_entered SMALLINT, notify_id INTEGER );");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e3) {
                C4039h.m2830e(f2733c, e3, "Unable a create message table.", new Object[0]);
            }
            C4039h.m2830e(f2733c, e2, "Unable to update message table", new Object[0]);
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    /* renamed from: b */
    private static void m2537b(SQLiteDatabase sQLiteDatabase, Context context, C4022a aVar) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE registration RENAME TO old_registration");
            sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, gcm_sender_id VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR )");
            sQLiteDatabase.execSQL("INSERT INTO registration (" + "id,platform,subscriber_key,et_app_id,badge,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,gcm_sender_id,locale" + ") SELECT " + "id,platform,subscriber_key,et_app_id,badge,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,gcm_sender_id,locale" + " FROM old_registration");
            if (DatabaseUtils.queryNumEntries(sQLiteDatabase, "registration") > 0) {
                ContentValues contentValues = new ContentValues(3);
                contentValues.put("device_id", C4025d.m2755a(context));
                contentValues.put(C4002i.C4003a.f2856q, C4026e.m2756a(context));
                contentValues.put(C4002i.C4003a.f2857r, C4036i.m2803a());
                sQLiteDatabase.update("registration", contentValues, (String) null, (String[]) null);
            }
            sQLiteDatabase.execSQL("DROP TABLE old_registration");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C4039h.m2830e(f2733c, e, "Unable to update registration table", new Object[0]);
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
                sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, badge INTEGER, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, gcm_sender_id VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR )");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                C4039h.m2830e(f2733c, e2, "Unable to create registration table", new Object[0]);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
        try {
            sQLiteDatabase.beginTransaction();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT id, attributes FROM registration", (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        ArrayList<C3981a> a = m2533a(aVar.mo56545b(rawQuery.getString(rawQuery.getColumnIndex("attributes"))));
                        ArraySet arraySet = new ArraySet();
                        if (!a.isEmpty()) {
                            for (int size = a.size() - 1; size >= 0; size--) {
                                arraySet.add(a.get(size));
                            }
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("attributes", aVar.mo56544a(m2532a((Collection<C3981a>) arraySet)));
                            sQLiteDatabase.update("registration", contentValues2, "id=?", new String[]{rawQuery.getString(rawQuery.getColumnIndex("id"))});
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
        } catch (Exception e3) {
            C4039h.m2829e(f2733c, "Unable to remove duplicate attributes from row", e3);
        } catch (Throwable th2) {
            sQLiteDatabase.endTransaction();
            throw th2;
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
    }

    /* renamed from: c */
    private static void m2538c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL(C3994e.f2778b);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            C4039h.m2830e(f2733c, e, "Unable to create location table", new Object[0]);
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
        try {
            sQLiteDatabase.execSQL("DROP TABLE beacon_request");
            sQLiteDatabase.execSQL("DROP TABLE geofence_request");
        } catch (Exception e2) {
            C4039h.m2830e(f2733c, e2, "Unable to drop unused request tables", new Object[0]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3.execSQL("DROP TABLE IF EXISTS regions");
        r3.execSQL("DROP TABLE IF EXISTS region_message");
        r3.execSQL("CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER );");
        r3.execSQL("CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );");
        r3.setTransactionSuccessful();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        r3.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001b */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m2539d(android.database.sqlite.SQLiteDatabase r3) {
        /*
            java.lang.String r0 = "CREATE TABLE regions (id VARCHAR PRIMARY KEY, latitude VARCHAR, longitude VARCHAR, radius INTEGER, beacon_guid VARCHAR, beacon_major INTEGER, beacon_minor INTEGER, description VARCHAR, name VARCHAR, location_type INTEGER );"
            java.lang.String r1 = "DROP TABLE IF EXISTS regions"
            r3.beginTransaction()     // Catch:{ SQLException -> 0x001b }
            r3.execSQL(r1)     // Catch:{ SQLException -> 0x001b }
            r3.execSQL(r0)     // Catch:{ SQLException -> 0x001b }
            java.lang.String r2 = "DELETE FROM region_message"
            r3.execSQL(r2)     // Catch:{ SQLException -> 0x001b }
            r3.setTransactionSuccessful()     // Catch:{ SQLException -> 0x001b }
        L_0x0015:
            r3.endTransaction()
            goto L_0x002f
        L_0x0019:
            r0 = move-exception
            goto L_0x0030
        L_0x001b:
            r3.execSQL(r1)     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = "DROP TABLE IF EXISTS region_message"
            r3.execSQL(r1)     // Catch:{ all -> 0x0019 }
            r3.execSQL(r0)     // Catch:{ all -> 0x0019 }
            java.lang.String r0 = "CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );"
            r3.execSQL(r0)     // Catch:{ all -> 0x0019 }
            r3.setTransactionSuccessful()     // Catch:{ all -> 0x0019 }
            goto L_0x0015
        L_0x002f:
            return
        L_0x0030:
            r3.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.p022d.p023a.p025b.C3980a.m2539d(android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: e */
    private static void m2540e(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE analytic_item RENAME TO " + "old_analytic_item");
            sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_types VARCHAR, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR)");
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + "old_analytic_item", (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        ContentValues contentValues = new ContentValues();
                        try {
                            contentValues.put("id", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("id"))));
                            contentValues.put("event_date", rawQuery.getString(rawQuery.getColumnIndex("event_date")));
                            contentValues.put(C3962a.C3963a.f2603h, Integer.valueOf(TextUtils.isEmpty(rawQuery.getString(rawQuery.getColumnIndex(C3964a.C3965a.C3966a.f2631i))) ? 0 : 1));
                            contentValues.put(C3964a.C3965a.C3966a.f2627e, rawQuery.getString(rawQuery.getColumnIndex(C3964a.C3965a.C3966a.f2627e)));
                            contentValues.put("value", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("value"))));
                            contentValues.put("ready_to_send", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("ready_to_send"))));
                            contentValues.put("object_ids", rawQuery.getString(rawQuery.getColumnIndex("object_ids")));
                            contentValues.put("json_payload", rawQuery.getString(rawQuery.getColumnIndex("json_payload")));
                            sQLiteDatabase.insert("analytic_item", (String) null, contentValues);
                        } catch (Exception e) {
                            C4039h.m2830e(f2733c, e, "Failed to update item in Analytics local storage during upgrade.", new Object[0]);
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            sQLiteDatabase.execSQL("DROP TABLE " + "old_analytic_item");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e2) {
            C4039h.m2830e(f2733c, e2, "Failed to upgrade Analytics local storage.  Starting fresh.  Some analytics items may have been lost.", new Object[0]);
            try {
                sQLiteDatabase.execSQL(C3962a.f2593c);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e3) {
                C4039h.m2830e(f2733c, e3, "Failed to create local storage for Analytics.", new Object[0]);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }
}

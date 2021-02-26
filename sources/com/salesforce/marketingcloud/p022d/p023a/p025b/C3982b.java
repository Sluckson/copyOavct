package com.salesforce.marketingcloud.p022d.p023a.p025b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.p023a.C3962a;
import com.salesforce.marketingcloud.p022d.p023a.C3988c;
import com.salesforce.marketingcloud.p022d.p023a.C3992d;
import com.salesforce.marketingcloud.p022d.p023a.p024a.C3964a;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d.a.b.b */
public final class C3982b {

    /* renamed from: a */
    private static final String f2736a = C4039h.m2810a((Class<?>) C3982b.class);

    private C3982b() {
    }

    /* renamed from: a */
    public static int m2541a(@NonNull Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex(C3964a.C3965a.C3966a.f2627e));
        return string.contains(",") ? string.contains("4") ? 5 : 2 : Integer.valueOf(string.replaceAll("\\[", "").replaceAll("\\]", "").trim()).intValue();
    }

    /* renamed from: a */
    public static void m2542a(@NonNull SQLiteDatabase sQLiteDatabase) {
        m2543b(sQLiteDatabase);
        m2544c(sQLiteDatabase);
        m2545d(sQLiteDatabase);
        m2546e(sQLiteDatabase);
        m2547f(sQLiteDatabase);
    }

    /* renamed from: b */
    private static void m2543b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("CREATE TEMPORARY TABLE analytic_item_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_types VARCHAR, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR)");
            sQLiteDatabase.execSQL("INSERT INTO analytic_item_temp SELECT id,event_date,analytic_product_type,analytic_types,value,ready_to_send,object_ids,json_payload FROM analytic_item");
            sQLiteDatabase.execSQL("DROP TABLE analytic_item");
            sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR)");
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM analytic_item_temp", (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        ContentValues contentValues = new ContentValues();
                        try {
                            contentValues.put("id", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("id"))));
                            contentValues.put("event_date", rawQuery.getString(rawQuery.getColumnIndex("event_date")));
                            contentValues.put(C3962a.C3963a.f2603h, Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex(C3962a.C3963a.f2603h))));
                            contentValues.put(C3962a.C3963a.f2599d, Integer.valueOf(m2541a(rawQuery)));
                            contentValues.put("value", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("value"))));
                            contentValues.put("ready_to_send", Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("ready_to_send"))));
                            contentValues.put("object_ids", rawQuery.getString(rawQuery.getColumnIndex("object_ids")));
                            contentValues.put("json_payload", rawQuery.getString(rawQuery.getColumnIndex("json_payload")));
                            sQLiteDatabase.insert("analytic_item", (String) null, contentValues);
                        } catch (Exception e) {
                            C4039h.m2830e(f2736a, e, "Failed to update item in Analytics local storage during upgrade.", new Object[0]);
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            sQLiteDatabase.execSQL("DROP TABLE analytic_item_temp");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e2) {
            C4039h.m2830e(f2736a, e2, "Failed to upgrade Analytics local storage.  Starting fresh.  Some analytics items may have been lost.", new Object[0]);
            try {
                sQLiteDatabase.execSQL("CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR)");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e3) {
                C4039h.m2830e(f2736a, e3, "Failed to create local storage for Analytics.", new Object[0]);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    /* renamed from: c */
    private static void m2544c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("CREATE TEMPORARY TABLE reg_temp (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
            sQLiteDatabase.execSQL("INSERT INTO reg_temp SELECT " + "id,platform,subscriber_key,et_app_id,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,system_token,device_id,app_version,sdk_version,locale" + " FROM registration");
            sQLiteDatabase.execSQL("DROP TABLE registration");
            sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
            sQLiteDatabase.execSQL("INSERT INTO registration SELECT " + "id,platform,subscriber_key,et_app_id,timezone,dst,tags,attributes,platform_version,push_enabled,location_enabled,hwid,system_token,device_id,app_version,sdk_version,locale" + " FROM reg_temp");
            sQLiteDatabase.execSQL("DROP TABLE reg_temp");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C4039h.m2830e(f2736a, e, "Failed to upgrade Registration local storage.  Starting fresh.  Attributes, Tags and ContactKey will be lost.", new Object[0]);
            try {
                sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e2) {
                C4039h.m2830e(f2736a, e2, "Failed to create local storage for Registration.", new Object[0]);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    /* renamed from: d */
    private static void m2545d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL(C3992d.f2773h);
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM cloud_page_messages", (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        boolean z = rawQuery.getInt(rawQuery.getColumnIndex("message_deleted")) == 1;
                        boolean z2 = rawQuery.getInt(rawQuery.getColumnIndex("read")) == 1;
                        String string = rawQuery.getString(rawQuery.getColumnIndex("id"));
                        int i = z ? 2 : z2 ? 1 : 0;
                        ContentValues contentValues = new ContentValues();
                        if (i > 0) {
                            try {
                                contentValues.put("id", string);
                                contentValues.put("status", Integer.valueOf(i));
                                sQLiteDatabase.insert(C3992d.f2771d, (String) null, contentValues);
                            } catch (Exception e) {
                                C4039h.m2827d(f2736a, e, "Failed to add message %s to inbox_message_status table.", string);
                            }
                        }
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e2) {
            C4039h.m2830e(f2736a, e2, "Failed to update inbox_message_status table.", new Object[0]);
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS inbox_message_status;");
                sQLiteDatabase.execSQL(C3992d.f2773h);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e3) {
                C4039h.m2830e(f2736a, e3, "Failed to create inbox_message_status table.", new Object[0]);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    /* renamed from: e */
    private static void m2546e(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("message_type", 8);
            sQLiteDatabase.update(C3988c.f2742a, contentValues, (String) null, (String[]) null);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            C4039h.m2827d(f2736a, e, "Failed to convert CloudPageMessage to an InboxMessage.", new Object[0]);
            try {
                sQLiteDatabase.execSQL("DELETE FROM cloud_page_messages WHERE content_type=2 AND message_type=1;");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e2) {
                C4039h.m2830e(f2736a, e2, "Failed to remove legacy CloudPage data.", new Object[0]);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    /* renamed from: f */
    private static void m2547f(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN message_hash VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN request_id VARCHAR;");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            C4039h.m2830e(f2736a, e, "Failed to update cloud_page_messages table.", new Object[0]);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloud_page_messages;");
            sQLiteDatabase.execSQL("CREATE TABLE cloud_page_messages (id VARCHAR PRIMARY KEY, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, subject VARCHAR, read SMALLINT, message_deleted SMALLINT, message_hash VARCHAR, request_id VARCHAR)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }
}

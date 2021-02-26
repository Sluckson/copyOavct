package com.salesforce.marketingcloud.p022d.p023a.p025b;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.C4039h;

/* renamed from: com.salesforce.marketingcloud.d.a.b.e */
public class C3985e {

    /* renamed from: a */
    private static final String f2739a = C4039h.m2810a((Class<?>) C3985e.class);

    /* renamed from: a */
    public static void m2553a(@NonNull SQLiteDatabase sQLiteDatabase) {
        m2554b(sQLiteDatabase);
    }

    /* renamed from: b */
    private static void m2554b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE registration ADD COLUMN proximity_enabled SMALLINT DEFAULT 0");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            try {
                C4039h.m2830e(f2739a, e, "Unable to update registration table", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
                sQLiteDatabase.execSQL("CREATE TABLE registration (id INTEGER PRIMARY KEY AUTOINCREMENT, platform VARCHAR, subscriber_key VARCHAR, et_app_id VARCHAR, timezone INTEGER, dst SMALLINT, tags VARCHAR, attributes VARCHAR, platform_version VARCHAR, push_enabled SMALLINT, location_enabled SMALLINT, proximity_enabled SMALLINT, hwid VARCHAR, system_token VARCHAR, device_id VARCHAR, app_version VARCHAR, sdk_version VARCHAR, locale VARCHAR );");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e2) {
                C4039h.m2830e(f2739a, e2, "Unable to create registration table", new Object[0]);
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
        sQLiteDatabase.endTransaction();
    }
}

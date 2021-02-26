package com.salesforce.marketingcloud.p022d.p023a.p025b;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.p023a.C3998g;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d.a.b.c */
public class C3983c {

    /* renamed from: a */
    private static final String f2737a = C4039h.m2810a((Class<?>) C3983c.class);

    private C3983c() {
    }

    /* renamed from: a */
    public static void m2548a(@NonNull SQLiteDatabase sQLiteDatabase) {
        m2549b(sQLiteDatabase);
        m2550c(sQLiteDatabase);
    }

    /* renamed from: b */
    private static void m2549b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("CREATE TABLE messages_temp (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
            sQLiteDatabase.execSQL("INSERT INTO messages_temp SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, notify_id FROM messages");
            sQLiteDatabase.execSQL("DROP TABLE messages");
            sQLiteDatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, alert VARCHAR, sound VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
            sQLiteDatabase.execSQL("INSERT INTO messages SELECT id, alert, sound, open_direct, start_date, end_date, message_type, content_type, url, custom, keys, period_show_count, last_shown_date, next_allowed_show, show_count, message_limit, rolling_period, period_type, number_of_periods, messages_per_period, proximity, notify_id FROM messages_temp");
            sQLiteDatabase.execSQL("DROP TABLE messages_temp");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN title VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN mediaUrl VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN mediaAlt VARCHAR;");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
                sQLiteDatabase.execSQL("CREATE TABLE messages (id VARCHAR PRIMARY KEY, title VARCHAR, alert VARCHAR, sound VARCHAR, mediaUrl VARCHAR, mediaAlt VARCHAR, open_direct VARCHAR, start_date VARCHAR, end_date VARCHAR, message_type INTEGER, content_type INTEGER, url VARCHAR, custom VARCHAR, keys VARCHAR, period_show_count INTEGER, last_shown_date VARCHAR, next_allowed_show VARCHAR, show_count INTEGER, message_limit INTEGER, rolling_period SMALLINT, period_type INTEGER, number_of_periods INTEGER, messages_per_period INTEGER, proximity INTEGER, notify_id INTEGER);");
                sQLiteDatabase.setTransactionSuccessful();
                C4039h.m2830e(f2737a, e, "Unable to update messages table", new Object[0]);
            } catch (SQLException e2) {
                C4039h.m2830e(f2737a, e2, "Unable to create messages table", new Object[0]);
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
        sQLiteDatabase.endTransaction();
    }

    /* renamed from: c */
    private static void m2550c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE regions ADD COLUMN is_inside SMALLINT");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            try {
                sQLiteDatabase.execSQL(C3998g.f2815c);
                sQLiteDatabase.setTransactionSuccessful();
                C4039h.m2830e(f2737a, e, "Unable to update regions table", new Object[0]);
            } catch (SQLException e2) {
                C4039h.m2830e(f2737a, e2, "Unable to create regions table", new Object[0]);
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
        sQLiteDatabase.endTransaction();
    }
}

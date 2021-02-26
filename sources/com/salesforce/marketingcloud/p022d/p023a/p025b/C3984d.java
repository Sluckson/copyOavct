package com.salesforce.marketingcloud.p022d.p023a.p025b;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.p023a.C3988c;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d.a.b.d */
public class C3984d {

    /* renamed from: a */
    private static final String f2738a = C4039h.m2810a((Class<?>) C3984d.class);

    private C3984d() {
    }

    /* renamed from: a */
    public static void m2551a(@NonNull SQLiteDatabase sQLiteDatabase) {
        try {
            Cursor query = sQLiteDatabase.query(C3988c.f2742a, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query != null) {
                if (query.getColumnIndex("custom") == -1) {
                    m2552b(sQLiteDatabase);
                }
                query.close();
            }
        } catch (Exception unused) {
            C4039h.m2829e(f2738a, "Failed to update cloud_page_messages table.", new Object[0]);
        }
    }

    /* renamed from: b */
    private static void m2552b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN custom VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN keys VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN title VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN alert VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN sound VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN mediaUrl VARCHAR;");
            sQLiteDatabase.execSQL("ALTER TABLE cloud_page_messages ADD COLUMN mediaAlt VARCHAR;");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cloud_page_messages");
                sQLiteDatabase.execSQL(C3988c.f2744c);
                sQLiteDatabase.setTransactionSuccessful();
                C4039h.m2830e(f2738a, e, "Unable to update cloud_page_messages table", new Object[0]);
            } catch (SQLException e2) {
                C4039h.m2830e(f2738a, e2, "Unable to create cloud_page_messages table", new Object[0]);
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
        sQLiteDatabase.endTransaction();
    }
}

package com.salesforce.marketingcloud.p022d.p023a.p025b;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.p023a.C4002i;

/* renamed from: com.salesforce.marketingcloud.d.a.b.f */
public class C3986f {

    /* renamed from: a */
    private static final String f2740a = C4039h.m2810a((Class<?>) C3986f.class);

    /* renamed from: a */
    public static void m2555a(@NonNull SQLiteDatabase sQLiteDatabase) {
        m2556b(sQLiteDatabase);
    }

    /* renamed from: b */
    private static void m2556b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("ALTER TABLE registration ADD COLUMN signed_string VARCHAR DEFAULT NULL");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
            try {
                C4039h.m2830e(f2740a, e, "Unable to update registration table", new Object[0]);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
                sQLiteDatabase.execSQL(C4002i.f2838c);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e2) {
                C4039h.m2830e(f2740a, e2, "Unable to create registration table", new Object[0]);
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
        sQLiteDatabase.endTransaction();
    }
}

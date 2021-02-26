package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.p023a.p025b.C3980a;
import com.salesforce.marketingcloud.p022d.p023a.p025b.C3982b;
import com.salesforce.marketingcloud.p022d.p023a.p025b.C3983c;
import com.salesforce.marketingcloud.p022d.p023a.p025b.C3984d;
import com.salesforce.marketingcloud.p022d.p023a.p025b.C3985e;
import com.salesforce.marketingcloud.p022d.p023a.p025b.C3986f;
import com.salesforce.marketingcloud.p022d.p023a.p025b.C3987g;
import com.salesforce.marketingcloud.p022d.p026b.C4006a;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d.a.j */
public final class C4004j extends SQLiteOpenHelper {
    @VisibleForTesting

    /* renamed from: a */
    public static final int f2859a = 8;

    /* renamed from: b */
    private static final String f2860b = "mcsdk_%s.db";

    /* renamed from: c */
    private static final String f2861c = C4039h.m2810a((Class<?>) C4004j.class);

    /* renamed from: d */
    private final Context f2862d;

    /* renamed from: e */
    private final C4022a f2863e;

    /* renamed from: f */
    private boolean f2864f;

    /* renamed from: g */
    private SQLiteDatabase f2865g;

    public C4004j(Context context, C4022a aVar, String str) {
        this(context, aVar, m2636a(str), 8);
    }

    C4004j(Context context, C4022a aVar, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f2864f = false;
        this.f2862d = context;
        this.f2863e = aVar;
    }

    /* renamed from: a */
    public static String m2636a(String str) {
        return String.format(Locale.ENGLISH, f2860b, new Object[]{str});
    }

    /* renamed from: a */
    private void m2637a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS  %s", new Object[]{C3988c.f2742a}));
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS  %s", new Object[]{"region_message"}));
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS  %s", new Object[]{"analytic_item"}));
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS %s", new Object[]{"regions"}));
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS %s", new Object[]{"messages"}));
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS %s", new Object[]{"registration"}));
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS %s", new Object[]{C3994e.f2777a}));
            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS %s", new Object[]{C3992d.f2771d}));
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: a */
    private boolean m2638a(@NonNull String str, @NonNull String str2) {
        if (!m2640b(str)) {
            return false;
        }
        m2639b(str, str2);
        return m2640b(str);
    }

    /* renamed from: b */
    private void m2639b(@NonNull String str, @NonNull String str2) {
        try {
            SQLiteDatabase b = mo56513b();
            C4039h.m2826d(f2861c, "Database table %s was not initialized properly and will be dropped and recreated.  Some data may be lost.", str);
            b.execSQL(String.format(Locale.ENGLISH, "DROP TABLE IF EXISTS %s", new Object[]{str}));
            b.execSQL(str2);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /* renamed from: b */
    private boolean m2640b(@NonNull String str) {
        Cursor rawQuery = mo56513b().rawQuery(String.format("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='%s'", new Object[]{str}), (String[]) null);
        if (rawQuery == null) {
            return false;
        }
        boolean z = !rawQuery.moveToFirst();
        rawQuery.close();
        return z;
    }

    /* renamed from: a */
    public boolean mo56512a() {
        return this.f2864f;
    }

    /* renamed from: b */
    public synchronized SQLiteDatabase mo56513b() {
        if (this.f2865g == null) {
            this.f2865g = getWritableDatabase();
        }
        return this.f2865g;
    }

    /* renamed from: c */
    public void mo56514c() {
        if (m2640b("registration")) {
            C4039h.m2826d(f2861c, "Database table %s was not initialized properly and will be dropped and recreated.  Some data may be lost.", "registration");
            try {
                mo56515d();
                if (m2640b("registration")) {
                    throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", new Object[]{"registration"}));
                }
                throw new C4006a();
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        } else if (m2638a(C3988c.f2742a, C3988c.f2744c)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", new Object[]{C3988c.f2742a}));
        } else if (m2638a("region_message", "CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );")) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", new Object[]{"region_message"}));
        } else if (m2638a("analytic_item", C3962a.f2593c)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", new Object[]{"analytic_item"}));
        } else if (m2638a("regions", C3998g.f2815c)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", new Object[]{"regions"}));
        } else if (m2638a("messages", C3996f.f2786c)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", new Object[]{"messages"}));
        } else if (m2638a(C3994e.f2777a, C3994e.f2778b)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", new Object[]{C3994e.f2777a}));
        } else if (m2638a(C3992d.f2771d, C3992d.f2773h)) {
            throw new IllegalStateException(String.format(Locale.ENGLISH, "%s could not be initialized.", new Object[]{C3992d.f2771d}));
        }
    }

    /* renamed from: d */
    public void mo56515d() {
        SQLiteDatabase b = mo56513b();
        m2637a(b);
        b.execSQL("VACUUM");
        onCreate(b);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(C3988c.f2744c);
        sQLiteDatabase.execSQL("CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );");
        sQLiteDatabase.execSQL(C3998g.f2815c);
        sQLiteDatabase.execSQL(C3996f.f2786c);
        sQLiteDatabase.execSQL(C4002i.f2838c);
        sQLiteDatabase.execSQL(C3962a.f2593c);
        sQLiteDatabase.execSQL(C3994e.f2778b);
        sQLiteDatabase.execSQL(C3992d.f2773h);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C4039h.m2826d(f2861c, "SQLite database being downgraded from %d to %d", Integer.valueOf(i2), Integer.valueOf(i));
        this.f2864f = true;
        m2637a(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            C3980a.m2535a(sQLiteDatabase, this.f2862d, this.f2863e);
        }
        if (i < 3) {
            C3982b.m2542a(sQLiteDatabase);
        }
        if (i < 4) {
            C3983c.m2548a(sQLiteDatabase);
        }
        if (i < 5) {
            C3984d.m2551a(sQLiteDatabase);
        }
        if (i < 6) {
            C3985e.m2553a(sQLiteDatabase);
        }
        if (i < 7) {
            C3986f.m2555a(sQLiteDatabase);
        }
        if (i < 8) {
            C3987g.m2557a(sQLiteDatabase);
        }
    }
}

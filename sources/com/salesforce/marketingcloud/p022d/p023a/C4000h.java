package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.messages.C4083g;
import com.salesforce.marketingcloud.p022d.C4018j;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.a.h */
public final class C4000h extends C3979b implements C4018j {

    /* renamed from: a */
    public static final String f2828a = "region_message";

    /* renamed from: b */
    public static final String[] f2829b = {"id", "message_id", "region_id"};

    /* renamed from: c */
    public static final String f2830c = "CREATE TABLE region_message (id INTEGER PRIMARY KEY AUTOINCREMENT, region_id VARCHAR, message_id VARCHAR );";

    /* renamed from: d */
    private static final String f2831d = C4039h.m2810a((Class<?>) C4000h.class);

    /* renamed from: g */
    private static final String f2832g = String.format(Locale.ENGLISH, "EXISTS (SELECT 1 FROM %s WHERE %s.%s = %s.%s and %s.%s = ?);", new Object[]{"regions", "region_message", "region_id", "regions", "id", "regions", "location_type"});

    /* renamed from: com.salesforce.marketingcloud.d.a.h$a */
    public static class C4001a {

        /* renamed from: a */
        public static final String f2833a = "id";

        /* renamed from: b */
        public static final String f2834b = "region_id";

        /* renamed from: c */
        public static final String f2835c = "message_id";
    }

    public C4000h(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a */
    private static C4083g m2617a(Cursor cursor) {
        try {
            return C4083g.m3054a(cursor.getString(cursor.getColumnIndex("region_id")), cursor.getString(cursor.getColumnIndex("message_id")));
        } catch (Exception e) {
            C4039h.m2830e(f2831d, e, "Failed to convert cursor to RegionMessage", new Object[0]);
            return null;
        }
    }

    /* renamed from: b */
    private static ContentValues m2618b(C4083g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_id", gVar.mo56710b());
        contentValues.put("region_id", gVar.mo56709a());
        return contentValues;
    }

    /* renamed from: a */
    public int mo56502a() {
        return mo56462c((String) null);
    }

    /* renamed from: a */
    public int mo56503a(int i) {
        return mo56454a(f2832g, new String[]{String.valueOf(i)});
    }

    @NonNull
    /* renamed from: a */
    public List<C4083g> mo56504a(String str) {
        List<C4083g> emptyList = Collections.emptyList();
        Cursor a = mo56460a(f2829b, String.format(Locale.ENGLISH, "%s = ?", new Object[]{"region_id"}), new String[]{str}, (String) null, (String) null, (String) null);
        if (a != null) {
            if (a.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                do {
                    C4083g a2 = m2617a(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } while (a.moveToNext());
                emptyList = arrayList;
            }
            a.close();
        }
        return emptyList;
    }

    /* renamed from: a */
    public void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase) {
    }

    /* renamed from: a */
    public void mo56505a(C4083g gVar) {
        mo56455a(m2618b(gVar));
    }

    /* renamed from: b */
    public int mo56506b(String str) {
        return mo56454a(String.format(Locale.ENGLISH, "%s = ?", new Object[]{"message_id"}), new String[]{str});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo56450e() {
        return "region_message";
    }
}

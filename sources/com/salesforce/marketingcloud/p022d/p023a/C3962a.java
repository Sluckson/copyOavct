package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.p022d.C3961a;
import com.salesforce.marketingcloud.p022d.p023a.p024a.C3964a;
import com.salesforce.marketingcloud.p022d.p023a.p025b.C3982b;
import com.salesforce.marketingcloud.p027e.C4022a;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.a.a */
public final class C3962a extends C3979b implements C3961a {

    /* renamed from: a */
    public static final String f2591a = "analytic_item";

    /* renamed from: b */
    public static final String[] f2592b = {"id", "event_date", C3963a.f2603h, C3963a.f2599d, "value", "ready_to_send", "object_ids", "json_payload", "request_id"};

    /* renamed from: c */
    public static final String f2593c = "CREATE TABLE analytic_item (id INTEGER PRIMARY KEY AUTOINCREMENT, event_date VARCHAR, analytic_product_type INTEGER, analytic_type INTEGER, value INTEGER, ready_to_send SMALLINT, object_ids VARCHAR, json_payload VARCHAR, request_id VARCHAR);";
    @VisibleForTesting

    /* renamed from: d */
    static final int f2594d = 1000;

    /* renamed from: g */
    private static final String f2595g = C4039h.m2810a((Class<?>) C3962a.class);

    /* renamed from: com.salesforce.marketingcloud.d.a.a$a */
    public static class C3963a {

        /* renamed from: a */
        public static final String f2596a = "id";

        /* renamed from: b */
        public static final String f2597b = "value";

        /* renamed from: c */
        public static final String f2598c = "event_date";

        /* renamed from: d */
        public static final String f2599d = "analytic_type";

        /* renamed from: e */
        public static final String f2600e = "object_ids";

        /* renamed from: f */
        public static final String f2601f = "ready_to_send";

        /* renamed from: g */
        public static final String f2602g = "json_payload";

        /* renamed from: h */
        public static final String f2603h = "analytic_product_type";

        /* renamed from: i */
        public static final String f2604i = "request_id";
    }

    public C3962a(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a */
    public static String m2488a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* renamed from: a */
    private List<C3910d> m2489a(int i, @Nullable C4022a aVar) {
        String a = m2488a("(%1$s=? OR %1$s=?) AND %2$s=? AND %3$s=? AND %4$s=?", C3963a.f2599d, C3963a.f2603h, "value", "ready_to_send");
        String[] strArr = {String.valueOf(4), String.valueOf(5), String.valueOf(i), String.valueOf(0), String.valueOf(0)};
        return mo56448a(mo56460a(f2592b, a, strArr, (String) null, (String) null, m2488a("%s ASC", "id")), aVar);
    }

    /* renamed from: a */
    private void m2490a(int i, int i2, int i3) {
        mo56462c(m2488a("%s IN ( SELECT %s FROM %s WHERE %s=%d ORDER BY %s ASC LIMIT %d )", "id", "id", "analytic_item", C3963a.f2603h, Integer.valueOf(i3), "id", Integer.valueOf((i + 1) - i2)));
    }

    /* renamed from: b */
    private static C3910d m2491b(Cursor cursor, @Nullable C4022a aVar) {
        C3910d dVar;
        try {
            int i = cursor.getInt(cursor.getColumnIndex(C3963a.f2599d));
            int i2 = cursor.getInt(cursor.getColumnIndex(C3963a.f2603h)) == 0 ? 0 : 1;
            String string = cursor.getString(cursor.getColumnIndex("request_id"));
            Date a = C4029h.m2770a(cursor.getString(cursor.getColumnIndex("event_date")));
            boolean z = cursor.getInt(cursor.getColumnIndex("ready_to_send")) == 1;
            List emptyList = Collections.emptyList();
            JSONArray jSONArray = new JSONArray(cursor.getString(cursor.getColumnIndex("object_ids")));
            if (jSONArray.length() > 0) {
                emptyList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    emptyList.add(jSONArray.getString(i3));
                }
            }
            List list = emptyList;
            if (!TextUtils.isEmpty(string)) {
                dVar = C3910d.m2282a(a, i2, i, list, string, z);
            } else if (list.size() > 0) {
                dVar = C3910d.m2283a(a, i2, i, list, z);
            } else {
                dVar = C3910d.m2281a(a, i2, i);
                dVar.mo56310a(z);
            }
            dVar.mo56308a(cursor.getInt(cursor.getColumnIndex("id")));
            dVar.mo56312b(cursor.getInt(cursor.getColumnIndex("value")));
            if (i2 != 1 || aVar == null) {
                return dVar;
            }
            String string2 = cursor.getString(cursor.getColumnIndex("json_payload"));
            if (TextUtils.isEmpty(string2)) {
                return dVar;
            }
            dVar.mo56309a(aVar.mo56545b(string2));
            return dVar;
        } catch (Exception e) {
            C4039h.m2830e(f2595g, e, "Failed to create our analytic item from storage.", new Object[0]);
            return null;
        }
    }

    /* renamed from: c */
    private static ContentValues m2492c(@NonNull C3910d dVar, @NonNull C4022a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_date", C4029h.m2766a(dVar.mo56311b()));
        contentValues.put(C3963a.f2603h, Integer.valueOf(dVar.mo56313c()));
        contentValues.put(C3963a.f2599d, Integer.valueOf(dVar.mo56314d()));
        contentValues.put("value", Integer.valueOf(dVar.mo56315e()));
        contentValues.put("ready_to_send", Integer.valueOf(dVar.mo56317g() ? 1 : 0));
        contentValues.put("object_ids", new JSONArray(dVar.mo56316f()).toString());
        contentValues.put("json_payload", dVar.mo56313c() == 1 ? aVar.mo56544a(dVar.mo56318h()) : "");
        contentValues.put("request_id", dVar.mo56319i());
        return contentValues;
    }

    /* renamed from: f */
    private int m2493f(int i) {
        return (int) DatabaseUtils.queryNumEntries(this.f2730f, "analytic_item", m2488a("%s=%s", C3963a.f2603h, Integer.valueOf(i)));
    }

    /* renamed from: a */
    public int mo56431a() {
        return m2493f(1);
    }

    /* renamed from: a */
    public int mo56432a(int i) {
        return mo56454a(m2488a("%s = ?", "id"), new String[]{String.valueOf(i)});
    }

    /* renamed from: a */
    public int mo56433a(List<Integer> list) {
        return mo56462c(m2488a("%s IN (%s)", "id", TextUtils.join(",", list)));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public List<C3910d> mo56448a(Cursor cursor, @Nullable C4022a aVar) {
        List<C3910d> emptyList = Collections.emptyList();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                ArrayList arrayList = new ArrayList();
                do {
                    C3910d b = m2491b(cursor, aVar);
                    if (b != null) {
                        arrayList.add(b);
                    } else {
                        int i = cursor.getInt(cursor.getColumnIndex("id"));
                        if (i >= 0) {
                            mo56432a(i);
                        }
                    }
                } while (cursor.moveToNext());
                emptyList = arrayList;
            }
            cursor.close();
        }
        return emptyList;
    }

    @NonNull
    /* renamed from: a */
    public List<C3910d> mo56434a(@NonNull C4022a aVar) {
        String a = m2488a("(%1$s=? OR %1$s=? OR %1$s=?) AND %2$s=? AND %3$s=?", C3963a.f2599d, C3963a.f2603h, "ready_to_send");
        String[] strArr = {String.valueOf(C3910d.f2394p), String.valueOf(C3910d.f2395q), String.valueOf(C3910d.f2393o), String.valueOf(1), String.valueOf(1)};
        return mo56448a(mo56460a(f2592b, a, strArr, (String) null, (String) null, m2488a("%s ASC", "event_date")), aVar);
    }

    @NonNull
    /* renamed from: a */
    public List<C3910d> mo56435a(@NonNull Region region, @NonNull C4022a aVar) {
        return mo56448a(mo56459a(f2592b, m2488a("(%1$s=? OR %1$s=?) AND %2$s LIKE ? AND %3$s=?", C3963a.f2599d, "object_ids", "ready_to_send"), new String[]{String.valueOf(13), String.valueOf(11), m2488a("%%%s%%", region.mo56647id()), String.valueOf(0)}), aVar);
    }

    /* renamed from: a */
    public void mo56436a(C3910d dVar, @NonNull C4022a aVar) {
        int i = dVar.mo56313c() == 0 ? 0 : 1;
        int f = m2493f(i);
        if (f + 1 > 1000) {
            m2490a(f, 1000, i);
        }
        dVar.mo56308a((int) mo56455a(m2492c(dVar, aVar)));
    }

    /* renamed from: a */
    public void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase) {
        Cursor query = sQLiteDatabase.query("analytic_item", new String[]{"id", "event_date", C3964a.C3965a.C3966a.f2627e, "object_ids", "value", "ready_to_send", C3964a.C3965a.C3966a.f2631i, "json_payload"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            if (query.moveToFirst()) {
                do {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", Integer.valueOf(query.getInt(query.getColumnIndex("id"))));
                    contentValues.put("event_date", query.getString(query.getColumnIndex("event_date")));
                    contentValues.put(C3963a.f2603h, Integer.valueOf(TextUtils.isEmpty(query.getString(query.getColumnIndex(C3964a.C3965a.C3966a.f2631i))) ^ true ? 1 : 0));
                    contentValues.put(C3963a.f2599d, Integer.valueOf(C3982b.m2541a(query)));
                    contentValues.put("object_ids", query.getString(query.getColumnIndex("object_ids")));
                    contentValues.put("value", query.getString(query.getColumnIndex("value")));
                    contentValues.put("ready_to_send", Integer.valueOf(query.getInt(query.getColumnIndex("ready_to_send"))));
                    C4022a aVar3 = aVar2;
                    contentValues.put("json_payload", aVar3.mo56544a(aVar.mo56545b(query.getString(query.getColumnIndex("json_payload")))));
                    mo56455a(contentValues);
                } while (query.moveToNext());
            }
            query.close();
            return;
        }
    }

    /* renamed from: b */
    public int mo56437b() {
        return m2493f(0);
    }

    /* renamed from: b */
    public int mo56438b(int i) {
        return mo56454a(m2488a("%s = ?", C3963a.f2603h), new String[]{String.valueOf(i)});
    }

    /* renamed from: b */
    public int mo56439b(C3910d dVar, @NonNull C4022a aVar) {
        return mo56453a(m2492c(dVar, aVar), m2488a("%s = ?", "id"), new String[]{String.valueOf(dVar.mo56307a())});
    }

    @NonNull
    /* renamed from: b */
    public List<C3910d> mo56440b(@NonNull C4022a aVar) {
        String a = m2488a("(%1$s=? OR %1$s=? OR %1$s=? OR %1$s=? OR %1$s=? OR %1$s=? OR %1$s=? OR %1$s=? OR %1$s=? OR %1$s=?) AND %2$s=? AND %3$s=?", C3963a.f2599d, C3963a.f2603h, "ready_to_send");
        String[] strArr = {String.valueOf(2), String.valueOf(3), String.valueOf(4), String.valueOf(5), String.valueOf(6), String.valueOf(7), String.valueOf(10), String.valueOf(11), String.valueOf(12), String.valueOf(13), String.valueOf(1), String.valueOf(1)};
        return mo56448a(mo56460a(f2592b, a, strArr, (String) null, (String) null, m2488a("%s ASC", "event_date")), aVar);
    }

    /* renamed from: c */
    public int mo56441c(int i) {
        return mo56454a(m2488a("%s = ? AND %s IN (%s)", C3963a.f2603h, C3963a.f2599d, TextUtils.join(",", C3910d.f2396r)), new String[]{String.valueOf(i)});
    }

    @NonNull
    /* renamed from: c */
    public List<C3910d> mo56442c() {
        return mo56448a(mo56460a(f2592b, m2488a("%s=? AND %s=?", C3963a.f2603h, "ready_to_send"), new String[]{String.valueOf(0), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE}, (String) null, (String) null, m2488a("%s ASC", "id")), (C4022a) null);
    }

    @NonNull
    /* renamed from: c */
    public List<C3910d> mo56443c(@NonNull C4022a aVar) {
        return m2489a(1, aVar);
    }

    /* renamed from: d */
    public int mo56444d(int i) {
        return mo56454a(m2488a("%s = ? AND %s NOT IN (%s)", C3963a.f2603h, C3963a.f2599d, TextUtils.join(",", C3910d.f2396r)), new String[]{String.valueOf(i)});
    }

    @NonNull
    /* renamed from: d */
    public List<C3910d> mo56445d() {
        return m2489a(0, (C4022a) null);
    }

    @NonNull
    /* renamed from: d */
    public List<C3910d> mo56446d(@NonNull C4022a aVar) {
        return mo56448a(mo56459a(f2592b, m2488a("(%1$s=? OR %1$s=?) AND %2$s=?", C3963a.f2599d, "ready_to_send"), new String[]{String.valueOf(13), String.valueOf(11), String.valueOf(0)}), aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo56450e() {
        return "analytic_item";
    }

    /* renamed from: e */
    public boolean mo56447e(int i) {
        return DatabaseUtils.queryNumEntries(this.f2730f, mo56450e(), m2488a("(%1$s=? OR %1$s=?) AND %2$s=? AND %3$s=? AND %4$s=?", C3963a.f2599d, C3963a.f2603h, "value", "ready_to_send"), new String[]{String.valueOf(4), String.valueOf(5), String.valueOf(i), String.valueOf(0), String.valueOf(0)}) > 0;
    }
}

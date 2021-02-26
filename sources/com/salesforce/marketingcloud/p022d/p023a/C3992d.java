package com.salesforce.marketingcloud.p022d.p023a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.p022d.C4011e;
import com.salesforce.marketingcloud.p022d.p023a.p024a.C3964a;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d.a.d */
public final class C3992d extends C3979b implements C4011e {

    /* renamed from: d */
    public static final String f2771d = "inbox_message_status";

    /* renamed from: g */
    public static final String[] f2772g = {"id", "status"};

    /* renamed from: h */
    public static final String f2773h = "CREATE TABLE inbox_message_status (id VARCHAR PRIMARY KEY, status INTEGER);";

    /* renamed from: i */
    private static final String f2774i = C4039h.m2810a((Class<?>) C3992d.class);

    /* renamed from: com.salesforce.marketingcloud.d.a.d$a */
    public static class C3993a {

        /* renamed from: a */
        public static final String f2775a = "id";

        /* renamed from: b */
        public static final String f2776b = "status";
    }

    public C3992d(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a */
    private static String m2577a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* renamed from: b */
    private static ContentValues m2578b(InboxMessage inboxMessage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", inboxMessage.mo56741id());
        contentValues.put("status", Integer.valueOf(inboxMessage.deleted() ? 2 : inboxMessage.read() ? 1 : 0));
        return contentValues;
    }

    @NonNull
    /* renamed from: a */
    public Map<String, Integer> mo56478a() {
        Cursor rawQuery = this.f2730f.rawQuery("SELECT * FROM inbox_message_status", (String[]) null);
        Map<String, Integer> emptyMap = Collections.emptyMap();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                HashMap hashMap = new HashMap(rawQuery.getCount());
                do {
                    hashMap.put(rawQuery.getString(rawQuery.getColumnIndex("id")), Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("status"))));
                } while (rawQuery.moveToNext());
                emptyMap = hashMap;
            }
            rawQuery.close();
        }
        return emptyMap;
    }

    /* renamed from: a */
    public void mo56479a(int i, @NonNull String... strArr) {
        if (strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : strArr) {
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append("'");
                sb.append(str);
                sb.append("'");
            }
            this.f2730f.execSQL(m2577a("UPDATE %1$s SET status=%2$s WHERE id IN (%3$s)", mo56450e(), Integer.valueOf(i), sb.toString()));
        }
    }

    /* renamed from: a */
    public void mo56449a(C4022a aVar, C4022a aVar2, SQLiteDatabase sQLiteDatabase) {
        Cursor query = sQLiteDatabase.query("messages", C3964a.C3971d.f2648a, m2577a("%s=? AND %s=? AND (%s=? OR %s=?)", "content_type", "message_type", "read", "message_deleted"), new String[]{String.valueOf(2), String.valueOf(1), String.valueOf(1), String.valueOf(1)}, (String) null, (String) null, (String) null);
        if (query != null) {
            if (query.moveToFirst()) {
                do {
                    int i = query.getInt(query.getColumnIndex("message_deleted")) == 1 ? 2 : query.getInt(query.getColumnIndex("read")) == 1 ? 1 : 0;
                    ContentValues contentValues = new ContentValues();
                    if (i != 0) {
                        contentValues.put("id", query.getString(query.getColumnIndex("id")));
                        contentValues.put("status", Integer.valueOf(i));
                        mo56455a(contentValues);
                    }
                } while (query.moveToNext());
            }
            query.close();
            return;
        }
    }

    /* renamed from: a */
    public void mo56480a(@NonNull InboxMessage inboxMessage) {
        ContentValues b = m2578b(inboxMessage);
        if (mo56453a(b, m2577a("%s = ?", "id"), new String[]{inboxMessage.mo56741id()}) == 0) {
            mo56455a(b);
        }
    }

    /* renamed from: a */
    public void mo56481a(@Size(min = 1) @NonNull String... strArr) {
        for (String str : strArr) {
            try {
                mo56454a("id=?", new String[]{str});
            } catch (Exception e) {
                C4039h.m2830e(f2774i, e, "Failed to delete message %s from %s table.", str, f2771d);
            }
        }
    }

    /* renamed from: b */
    public int mo56482b() {
        return super.mo56462c((String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo56450e() {
        return f2771d;
    }
}

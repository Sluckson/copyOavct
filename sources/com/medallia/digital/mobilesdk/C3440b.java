package com.medallia.digital.mobilesdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.b */
class C3440b extends C3794y0<C3485e> {

    /* renamed from: d */
    private static final String f905d = "analyticsEvents";

    /* renamed from: com.medallia.digital.mobilesdk.b$a */
    class C3441a extends HashMap<String, String> {
        C3441a() {
            put("sessionId", "TEXT");
            put("name", "TEXT");
            put("lifetime", "TEXT");
            put("timestamp", "INTEGER");
            put("groupType", "TEXT");
            put(NotificationCompat.CATEGORY_EVENT, "TEXT");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.b$b */
    private static class C3442b {

        /* renamed from: a */
        private static final String f907a = "sessionId";

        /* renamed from: b */
        private static final String f908b = "name";

        /* renamed from: c */
        private static final String f909c = "lifetime";

        /* renamed from: d */
        private static final String f910d = "timestamp";

        /* renamed from: e */
        private static final String f911e = "groupType";

        /* renamed from: f */
        private static final String f912f = "event";

        private C3442b() {
        }
    }

    C3440b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ContentValues mo55215b(C3485e eVar) {
        ContentValues contentValues = new ContentValues();
        if (eVar != null) {
            contentValues.put("sessionId", eVar.mo55325e());
            contentValues.put("name", eVar.mo55320a());
            contentValues.put("timestamp", Long.valueOf(eVar.mo55326f()));
            String str = null;
            contentValues.put("lifetime", eVar.mo55323c() == null ? null : eVar.mo55323c().name());
            contentValues.put("groupType", eVar.mo55322b() == null ? null : eVar.mo55322b().name());
            if (eVar.mo55324d() != null) {
                str = eVar.mo55324d().toString();
            }
            contentValues.put(NotificationCompat.CATEGORY_EVENT, str);
        }
        return contentValues;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55213a(Object... objArr) {
        long j;
        String str;
        String str2;
        StringBuilder sb;
        Object[] objArr2 = objArr;
        boolean z = false;
        if (objArr2 == null || objArr2.length == 0) {
            return false;
        }
        long j2 = -1;
        if (objArr2.length <= 0 || !(objArr2[0] instanceof Long)) {
            j = -1;
            str = null;
        } else {
            j = ((Long) objArr2[0]).longValue();
            str = "timestamp<='" + j + "'";
        }
        if (objArr2.length > 1 && (objArr2[1] instanceof Long)) {
            j2 = ((Long) objArr2[1]).longValue();
            if (str == null) {
                sb = new StringBuilder();
                str2 = "timestamp>='";
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str2 = " AND timestamp>='";
            }
            sb.append(str2);
            sb.append(j2);
            sb.append("'");
            str = sb.toString();
        }
        String str3 = str;
        if (C3782x0.m1872d().getWritableDatabase().delete(mo55222d(), str3, (String[]) null) > 0) {
            z = true;
        }
        if (z) {
            C3490e3.m665e("Delete Analytics records from timestamp " + j2 + " to timestamp " + j);
        }
        int i = -1;
        if (!z) {
            i = C3782x0.m1872d().getReadableDatabase().query(mo55222d(), (String[]) null, str3, (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null).getCount();
        }
        mo55928a(!z, "delete " + i + " analytics records from timestamp " + j2 + " to timestamp " + j);
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo55214b() {
        try {
            return DatabaseUtils.queryNumEntries(C3782x0.m1872d().getWritableDatabase(), f905d);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3485e m476b(Object... objArr) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo55221c(C3485e eVar) {
        if (!TextUtils.isEmpty(eVar.mo55325e()) && eVar.mo55326f() > 0) {
            return super.mo55221c(eVar);
        }
        mo55928a(true, "insert (invalid data from analytics) - " + eVar.toString());
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ArrayList<C3485e> mo55218c(Object... objArr) {
        String str;
        ArrayList<C3485e> arrayList = new ArrayList<>();
        String str2 = null;
        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Long)) {
            str = null;
        } else {
            str = "timestamp<='" + objArr[0].longValue() + "'";
        }
        if (objArr != null && objArr.length > 0 && objArr[1] != null && (objArr[1] instanceof Long)) {
            str = str + " AND timestamp>'" + objArr[1].longValue() + "'";
        }
        String str3 = str;
        if (objArr != null && objArr.length > 0 && objArr[2] != null && (objArr[2] instanceof Integer)) {
            str2 = String.valueOf(objArr[2]);
        }
        Cursor query = C3782x0.m1872d().getReadableDatabase().query(mo55222d(), (String[]) null, str3, (String[]) null, (String) null, (String) null, "timestamp ASC", str2);
        if (query != null && query.moveToFirst()) {
            do {
                arrayList.add(new C3485e(query.getString(query.getColumnIndex(NotificationCompat.CATEGORY_EVENT)), GroupType.valueOf(query.getString(query.getColumnIndex("groupType"))), Lifetime.valueOf(query.getString(query.getColumnIndex("lifetime"))), query.getString(query.getColumnIndex("name")), query.getLong(query.getColumnIndex("timestamp")), query.getString(query.getColumnIndex("sessionId"))));
            } while (query.moveToNext());
            query.close();
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public HashMap<String, String> mo55219c() {
        return new C3441a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55223d(C3485e eVar) {
        SQLiteDatabase writableDatabase = C3782x0.m1872d().getWritableDatabase();
        String d = mo55222d();
        ContentValues a = mo55215b(eVar);
        StringBuilder sb = new StringBuilder();
        sb.append("name='");
        sb.append(eVar.mo55320a());
        sb.append("'");
        return writableDatabase.update(d, a, sb.toString(), (String[]) null) > 0 || super.mo55221c(eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo55222d() {
        return f905d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo55224e() {
        return "timestamp";
    }
}
